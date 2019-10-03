package de.skerkewitz.ksrc.sil.ast

import de.skerkewitz.ksrc.common.SourceLocation
import java.util.*

abstract class SilAstNode(open val srcLocation: SourceLocation) {

  abstract fun toSilString(): String

}