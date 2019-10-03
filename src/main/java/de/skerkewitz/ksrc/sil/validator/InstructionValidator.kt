package de.skerkewitz.ksrc.sil.validator

import de.skerkewitz.ksrc.sil.ast.SilAstNodeInstruction


/**
 * The operands of the first block must match the operands of the functions.
 */
class InstructionsTypeValidator : InstructionValidator {
  override fun validate(subject: SilAstNodeInstruction, validationEmitter: ValidationEmitter) {

    when(subject) {
      is SilAstNodeInstruction.IntegerLiteral -> TypeValidatorImpl.validate(subject.type, validationEmitter)
      is SilAstNodeInstruction.Builtin -> {
        TypeValidatorImpl.validate(subject.returnType, validationEmitter)
        subject.operands.map { it.type }.forEach { TypeValidatorImpl.validate(it, validationEmitter) }
      }
      is SilAstNodeInstruction.FunctionRef -> TypeValidatorImpl.validate(subject.type, validationEmitter)
      is SilAstNodeInstruction.Apply -> TypeValidatorImpl.validate(subject.returnType, validationEmitter)
    }
  }
}

object InstructionValidatorImpl : ValidatorContainer<Validator<SilAstNodeInstruction>, SilAstNodeInstruction>() {

  override val validator = arrayListOf(
          InstructionsTypeValidator()

  )

  override fun validate(subject: SilAstNodeInstruction, validationEmitter: ValidationEmitter) {
    validator.forEach { it.validate(subject, validationEmitter) }
  }
}