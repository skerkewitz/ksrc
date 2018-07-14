package asmble.run.jvm

import asmble.AsmErr

sealed class CompileErr(message: String, cause: Throwable? = null) : RuntimeException(message, cause), AsmErr {

    class SelectMismatch(
            val value1: TypeRef,
            val value2: TypeRef
    ) : CompileErr("Select values $value1 and $value2 are not the same type") {
        override val asmErrString get() = "type mismatch"
    }

    class GlobalConstantMismatch(
            val index: Int,
            val expected: TypeRef,
            val actual: TypeRef
    ) : CompileErr("Global $index expected const of type $expected, got $actual") {
        override val asmErrString get() = "type mismatch"
    }

    class UnusedStackOnReturn(
        val leftover: List<TypeRef>
    ) : CompileErr("Expected empty stack on return, still leftover with: $leftover") {
        override val asmErrString get() = "type mismatch"
    }

    class UnknownFunc(
        val index: Int
    ) : CompileErr("Unknown function at index $index") {
        override val asmErrString get() = "unknown function $index"
    }

    class UnknownGlobal(
        val index: Int
    ) : CompileErr("Unknown global at index $index") {
        override val asmErrString get() = "unknown global"
    }

    class UnknownMemory(val index: Int) : CompileErr("No memory present at index $index") {
        override val asmErrString get() = "unknown memory $index"
    }

    class UnknownTable(val index: Int) : CompileErr("No table present at index $index") {
        override val asmErrString get() = "unknown table"
        override val asmErrStrings get() = listOf(asmErrString, "unknown table $index")
    }

    class UnknownType(val index: Int) : CompileErr("No type present for index $index") {
        override val asmErrString get() = "unknown type"
    }

    class GlobalInitNotConstant(
        val index: Int
    ) : CompileErr("Expected init for global $index to be single constant value") {
        override val asmErrString get() = "constant expression required"
        override val asmErrStrings get() = listOf(asmErrString, "type mismatch")
    }

    class OffsetNotConstant : CompileErr("Expected offset to be constant") {
        override val asmErrString get() = "constant expression required"
    }

}