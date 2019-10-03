package de.skerkewitz.ksrc.sil

/**
 * Represents a type. A type has a fully qualified name and my be a pointer.
 *
 * `sil-type ::= '$' '*'? generic-parameter-list? type`
 */
data class SilType(val fqName: String, val pointer: Boolean = false) {

  fun toSilString(): String {
    val p = if (pointer) "*" else ""
    return "\$${p}$fqName"
  }

}