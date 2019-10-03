package de.skerkewitz.ksrc.sil.validator

import de.skerkewitz.ksrc.sil.ast.SilAstNodeInstructionDefinition


/**
 * The operands of the first block must match the operands of the functions.
 */
class InstructionsDefinitionsForwardValidator : InstructionDefinitionValidator {
  override fun validate(subject: SilAstNodeInstructionDefinition, validationEmitter: ValidationEmitter) {
    InstructionValidatorImpl.validate(subject.instruction, validationEmitter)
  }
}

object InstructionDefinitionValidatorImpl : ValidatorContainer<Validator<SilAstNodeInstructionDefinition>, SilAstNodeInstructionDefinition>() {

  override val validator = arrayListOf(
          InstructionsDefinitionsForwardValidator()

  )

  override fun validate(subject: SilAstNodeInstructionDefinition, validationEmitter: ValidationEmitter) {
    validator.forEach { it.validate(subject, validationEmitter) }
  }
}