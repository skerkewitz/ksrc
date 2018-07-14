package asmble.run.jvm

import asmble.ast.Node
import org.objectweb.asm.Type
import kotlin.reflect.KClass

val KClass<*>.ref: TypeRef get() = (if (this == Void::class) Void.TYPE else this.java).ref
val Class<*>.asmType: Type get() = Type.getType(this)
val Class<*>.ref: TypeRef get() = TypeRef(this.asmType)

val Class<*>.valueType: Node.Type.Value? get() = when (this) {
    Void.TYPE -> null
    Int::class.java, java.lang.Integer::class.java -> Node.Type.Value.I32
    Long::class.java, java.lang.Long::class.java -> Node.Type.Value.I64
    Float::class.java, java.lang.Float::class.java -> Node.Type.Value.F32
    Double::class.java, java.lang.Double::class.java -> Node.Type.Value.F64
    else -> error("Unrecognized value type class: $this")
}


val Number?.valueType get() = when (this) {
    null -> null
    is Int -> Node.Type.Value.I32
    is Long-> Node.Type.Value.I64
    is Float -> Node.Type.Value.F32
    is Double -> Node.Type.Value.F64
    else -> error("Unrecognized value type class: $this")
}

val Node.Type.Value.kclass: KClass<*> get() = when (this) {
    Node.Type.Value.I32 -> Int::class
    Node.Type.Value.I64 -> Long::class
    Node.Type.Value.F32 -> Float::class
    Node.Type.Value.F64 -> Double::class
}

val Node.Type.Value.typeRef: TypeRef get() = this.jclass.ref
val Node.Type.Value.jclass: Class<*> get() = this.kclass.java

