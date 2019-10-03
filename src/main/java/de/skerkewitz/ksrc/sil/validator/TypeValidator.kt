package de.skerkewitz.ksrc.sil.validator

import de.skerkewitz.ksrc.sil.ast.SilAstNodeType

class TypeCheckValidator : TypeValidator {

  override fun validate(type: SilAstNodeType, validationEmitter: ValidationEmitter) {

    when (type) {
      is SilAstNodeType.Simple -> {
        if (type.name != "Builtin.Int") {
          validationEmitter.emit(type.srcLocation, "Unknown type '${type.name}'")
        }
      }
      is SilAstNodeType.Function -> {
        type.arguments.forEach { validate(it, validationEmitter) }
        type.returnType.also { validate(it, validationEmitter) }
      }
    }
  }
}

object TypeValidatorImpl : ValidatorContainer<Validator<SilAstNodeType>, SilAstNodeType>() {

  override val validator = arrayListOf(
          TypeCheckValidator()
  )

  override fun validate(subject: SilAstNodeType, validationEmitter: ValidationEmitter) {
    validator.forEach { it.validate(subject, validationEmitter) }
  }
}