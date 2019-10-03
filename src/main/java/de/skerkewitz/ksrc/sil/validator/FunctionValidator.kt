package de.skerkewitz.ksrc.sil.validator

import de.skerkewitz.ksrc.sil.ast.SilAstNodeFunction

/**
 * Check if the first block in a method is called 'entry'.
 */
class FunctionFirstBlockShouldBeNamedEntryValidator : FunctionValidator {

  override fun validate(subject: SilAstNodeFunction, validationEmitter: ValidationEmitter) {
    val firstBlock = subject.blocks.first()
    if (firstBlock.identifier != "entry") {
      validationEmitter.emit(firstBlock.srcLocation, "First block in function should be named 'entry' but is '${firstBlock.identifier}'")
    }
  }
}

/**
 * The operands of the first block must match the operands of the functions.
 */
class FunctionFirstBlockOperandMustMatchFunctionOperandsValidator : FunctionValidator {

  override fun validate(subject: SilAstNodeFunction, validationEmitter: ValidationEmitter) {
    val firstBlock = subject.blocks.first()
    val blockOperandCount = firstBlock.arguments.size
    val funcOperandCount = subject.type.arguments.size
    if (blockOperandCount != funcOperandCount) {
      val funcName = subject.functionName
      validationEmitter.emit(firstBlock.srcLocation, "Entry block in function '$funcName' has an operand count of $blockOperandCount but function has an operand count of $funcOperandCount ")
    } else {
      subject.type.arguments
              .zip(firstBlock.arguments.map { it.type })
              .forEachIndexed { index, pair ->
                if (pair.first != pair.second) {
                  validationEmitter.emit(pair.second.srcLocation, "Expected operand ${index + 1} of block '${firstBlock.identifier}' to be type '${pair.first.toSilString()}' but found '${pair.second.toSilString()}'")
                }
              }
    }
  }
}

/**
 * The operands of the first block must match the operands of the functions.
 */
class FunctionCheckAllTypesValidator : FunctionValidator {
  override fun validate(subject: SilAstNodeFunction, validationEmitter: ValidationEmitter) {
    TypeValidatorImpl.validate(subject.type, validationEmitter)
  }
}

/**
 * The operands of the first block must match the operands of the functions.
 */
class FunctionCheckAllBlocksValidator : FunctionValidator {
  override fun validate(subject: SilAstNodeFunction, validationEmitter: ValidationEmitter) {
    subject.blocks.forEach { BlockValidatorImpl.validate(it, validationEmitter) }
  }
}

object FunctionValidatorImpl : ValidatorContainer<Validator<SilAstNodeFunction>, SilAstNodeFunction>() {

  override val validator = arrayListOf(
          FunctionFirstBlockShouldBeNamedEntryValidator(),
          FunctionFirstBlockOperandMustMatchFunctionOperandsValidator(),
          FunctionCheckAllTypesValidator(),
          FunctionCheckAllBlocksValidator()
  )

  override fun validate(subject: SilAstNodeFunction, validationEmitter: ValidationEmitter) {
    validator.forEach { it.validate(subject, validationEmitter) }
  }
}