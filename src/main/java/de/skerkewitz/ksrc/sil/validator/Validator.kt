package de.skerkewitz.ksrc.sil.validator

import de.skerkewitz.ksrc.common.SourceLocation
import de.skerkewitz.ksrc.sil.ast.*

interface Validator<T> {
  fun validate(subject: T, validationEmitter: ValidationEmitter)
}

interface ValidationEmitter {
  fun emit(srcLocation: SourceLocation, message: String)
}

interface FunctionValidator : Validator<SilAstNodeFunction>
interface TypeValidator : Validator<SilAstNodeType>
interface BlockValidator : Validator<SilAstNodeBlock>
interface InstructionDefinitionValidator : Validator<SilAstNodeInstructionDefinition>
interface InstructionValidator : Validator<SilAstNodeInstruction>
interface TerminatorInstructionValidator : Validator<SilAstNodeTerminator>

abstract class ValidatorContainer<V : Validator<T>, T> : Validator<T> {
  abstract val validator: List<V>
}

object ErrorEmitter : ValidationEmitter {
  override fun emit(srcLocation: SourceLocation, message: String) {
    println("Error $srcLocation: $message")
  }
}
