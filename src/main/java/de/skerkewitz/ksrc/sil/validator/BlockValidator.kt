package de.skerkewitz.ksrc.sil.validator

import de.skerkewitz.ksrc.sil.ast.SilAstNodeBlock


/**
 * The operands of the first block must match the operands of the functions.
 */
class BlockCheckAllTypesValidator : BlockValidator {
  override fun validate(subject: SilAstNodeBlock, validationEmitter: ValidationEmitter) {
    subject.arguments.forEach {  TypeValidatorImpl.validate(it.type, validationEmitter) }
  }
}

class BlockForwardInstructionsDefinitionsValidator :  BlockValidator {
  override fun validate(subject: SilAstNodeBlock, validationEmitter: ValidationEmitter) {
    subject.instructionsDefinitions.forEach {  InstructionDefinitionValidatorImpl.validate(it, validationEmitter) }
    TerminatorInstructionValidatorImpl.validate(subject.terminator, validationEmitter)
  }
}

class BlockEnsureSsaValidator : BlockValidator {
  override fun validate(subject: SilAstNodeBlock, validationEmitter: ValidationEmitter) {

    val argumentNames = subject.arguments.map { it.identifier }
    val valueName = subject.instructionsDefinitions.map { it.result }

    val duplicates = arrayListOf(argumentNames, valueName)
            .flatten()
            .groupingBy { it }
            .eachCount()
            .filter { it.value > 1 }
            .map { it.key }

    if (duplicates.isNotEmpty()) {
      validationEmitter.emit(subject.srcLocation, "Value name '${duplicates.joinToString(", ")}' are not unique and therefore violate SSA")
    }
  }
}

object BlockValidatorImpl : ValidatorContainer<Validator<SilAstNodeBlock>, SilAstNodeBlock>() {

  override val validator = arrayListOf(
          BlockCheckAllTypesValidator(),
          BlockEnsureSsaValidator(),
          BlockForwardInstructionsDefinitionsValidator()


  )

  override fun validate(subject: SilAstNodeBlock, validationEmitter: ValidationEmitter) {
    validator.forEach { it.validate(subject, validationEmitter) }
  }
}