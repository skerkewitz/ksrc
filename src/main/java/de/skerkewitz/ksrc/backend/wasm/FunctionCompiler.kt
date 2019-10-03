package de.skerkewitz.ksrc.backend.wasm

import asmble.ast.Node
import de.skerkewitz.ksrc.parse.ast.nodes.AstNode
import de.skerkewitz.ksrc.parse.ast.nodes.expr.AstExprFunctionCall
import de.skerkewitz.ksrc.parse.ast.nodes.expr.AstExprIdent
import de.skerkewitz.ksrc.parse.ast.nodes.expr.AstExprInfixOp
import de.skerkewitz.ksrc.parse.ast.nodes.expr.AstExprLiteral
import de.skerkewitz.ksrc.parse.ast.nodes.statement.AstStatementIf
import de.skerkewitz.ksrc.parse.ast.nodes.statement.AstStatementReturn
import de.skerkewitz.ksrc.parse.ast.nodes.statement.AstStatements
import de.skerkewitz.ksrc.parse.ast.nodes.statement.declaration.AstDeclarationFunction
import de.skerkewitz.ksrc.parse.ast.util.WasmCompiler
import java.lang.IllegalArgumentException

object FunctionCompiler {

    data class WasmFunction(
            val functionName: String,
            val localNames: Map<Int, String>,
            val function: Node.Func
    )

    private fun compileBody(node: AstNode, locals: Map<Int, String>, resolver: WasmCompiler.Resolver): List<Node.Instr> {
        println("Compile $node")
        when(node) {
            is AstStatements -> {
                val flatten = node.statements.map { compileBody(it, locals, resolver) }.flatten()
                return flatten
            }
            is AstStatementIf -> {

                var instructions = arrayListOf<Node.Instr>()
                instructions.addAll(compileBody(node.condition, locals, resolver))
                instructions.add(Node.Instr.If(null))
                instructions.addAll(compileBody(node.thenStatement, locals, resolver))

                if (node.elseStatement != null) {
                    instructions.add(Node.Instr.Else)
                    instructions.addAll(compileBody(node.elseStatement, locals, resolver))
                }

                instructions.add(Node.Instr.End)
                return instructions
            }
            is AstExprInfixOp -> {
                var instructions = arrayListOf<Node.Instr>()
                instructions.addAll(compileBody(node.lhs, locals, resolver))
                instructions.addAll(compileBody(node.rhs, locals, resolver))

                var instr: Node.Instr = when(node.op) {
                    AstExprInfixOp.Token.POW -> TODO()
                    AstExprInfixOp.Token.MINUS -> Node.Instr.I32Sub
                    AstExprInfixOp.Token.MULT -> Node.Instr.I32Mul
                    AstExprInfixOp.Token.DIV -> TODO()
                    AstExprInfixOp.Token.MOD -> TODO()
                    AstExprInfixOp.Token.PLUS -> Node.Instr.I32Add
                    AstExprInfixOp.Token.LTEQ -> TODO()
                    AstExprInfixOp.Token.GTEQ -> TODO()
                    AstExprInfixOp.Token.LT -> TODO()
                    AstExprInfixOp.Token.GT -> TODO()
                    AstExprInfixOp.Token.EQ -> Node.Instr.I32Eq
                    AstExprInfixOp.Token.IDEQ -> TODO()
                    AstExprInfixOp.Token.NEQ -> TODO()
                    AstExprInfixOp.Token.AND -> TODO()
                    AstExprInfixOp.Token.OR -> TODO()
                }

                instructions.add(instr)
                return instructions
            }
            is AstExprIdent -> {
                val index = locals.entries.indexOfFirst { it.value == node.ident }
                var instructions = arrayListOf<Node.Instr>()
                instructions.add(Node.Instr.GetLocal(index))
                return instructions
            }
            is AstExprLiteral -> {
                var instructions = arrayListOf<Node.Instr>()
                instructions.add(Node.Instr.I32Const(node.value.toInt()))
                return instructions
            }
            is AstStatementReturn -> {
                var instructions = arrayListOf<Node.Instr>()
                instructions.addAll(compileBody(node.expr, locals, resolver))
                instructions.add(Node.Instr.Return)
                return instructions
            }
            is AstExprFunctionCall -> {
                var instructions = arrayListOf<Node.Instr>()
                instructions.addAll(compileBody(node.arguments.list.first(), locals, resolver))
                instructions.add(Node.Instr.Call(resolver.indexOfFunction(node.functionNameIdent.ident)))
                return instructions
            }
            else -> {
                throw IllegalArgumentException("Unknown node $node")
            }

        }

        return emptyList()
    }

    interface FunctionResolver {

        fun indexOfFunction(name: String): Int
    }


    fun compile(declarationFunction: AstDeclarationFunction, resolver: WasmCompiler.Resolver): WasmFunction {

        val name: String = declarationFunction.name.ident
        val localNames = mutableMapOf<Int, String>()

        val paramTypes: List<Node.Type.Value> = declarationFunction.signature.params
                .map { p -> WasmTypeMapper.mapType(p.type.name) }

        declarationFunction.signature.params
                .map { it.name.ident }
                .onEach { localNames[localNames.size] = it }

        val result = WasmTypeMapper.mapType(declarationFunction.signature.returnType.name)


        val funcType = Node.Type.Func(paramTypes, result)

        var instructions = compileBody(declarationFunction.body, localNames, resolver)

        val func = Node.Func(funcType, arrayListOf(), instructions)

        return WasmFunction(name, localNames, func)
    }
}