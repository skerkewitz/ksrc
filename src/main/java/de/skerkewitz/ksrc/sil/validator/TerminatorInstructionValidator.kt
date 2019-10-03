package de.skerkewitz.ksrc.sil.validator

import de.skerkewitz.ksrc.sil.ast.SilAstNodeTerminator


/**
 * The operands of the first block must match the operands of the functions.
 */
class TerminatorInstructionCheckTypesValidator : TerminatorInstructionValidator {
  override fun validate(subject: SilAstNodeTerminator, validationEmitter: ValidationEmitter) {

    when(subject) {
      is SilAstNodeTerminator.Return -> TypeValidatorImpl.validate(subject.operand.type, validationEmitter)
      is SilAstNodeTerminator.Branch -> subject.jumpTarget.operands.map { it.type }.forEach { TypeValidatorImpl.validate(it, validationEmitter) }
      is SilAstNodeTerminator.BranchConditionally -> {
        TypeValidatorImpl.validate(subject.condition.type, validationEmitter)
        subject.thenJumpTarget.operands.map { it.type }.forEach { TypeValidatorImpl.validate(it, validationEmitter) }
        subject.elseJumpTarget.operands.map { it.type }.forEach { TypeValidatorImpl.validate(it, validationEmitter) }
      }
    }
  }
}

object TerminatorInstructionValidatorImpl : ValidatorContainer<Validator<SilAstNodeTerminator>, SilAstNodeTerminator>() {

  override val validator = arrayListOf(
          TerminatorInstructionCheckTypesValidator()
  )

  override fun validate(subject: SilAstNodeTerminator, validationEmitter: ValidationEmitter) {
    validator.forEach { it.validate(subject, validationEmitter) }
  }
}