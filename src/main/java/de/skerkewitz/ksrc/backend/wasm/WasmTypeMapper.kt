package de.skerkewitz.ksrc.backend.wasm

import asmble.ast.Node

object WasmTypeMapper {

    fun mapType(typeName: String): Node.Type.Value {
        if (typeName == "Int") {
            return Node.Type.Value.I32
        }

        throw IllegalArgumentException("Uknown type $typeName")
    }
}