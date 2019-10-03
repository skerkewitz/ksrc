package de.skerkewitz.ksrc.sil

import de.skerkewitz.ksrc.sil.antlr.SilParser
import de.skerkewitz.ksrc.sil.antlr.SilParser.Translation_unitContext
import de.skerkewitz.ksrc.sil.antlr.SilParserUtil
import de.skerkewitz.ksrc.sil.ast.SilAstNodeFunction
import de.skerkewitz.ksrc.sil.validator.FunctionValidatorImpl
import org.antlr.v4.runtime.CharStreams
import org.junit.jupiter.api.Test
import java.io.File
import java.io.IOException
import java.io.InputStream
import java.net.URISyntaxException
import java.net.URL

internal class SilParserUtilTest {

  @Test
  @Throws(IOException::class)
  fun parseLanguage() {
    val resource: URL = this.javaClass.getResource("test.sil")
    val inputStream: InputStream? = resource.openStream()
    val parse = SilAstParser.parse(CharStreams.fromStream(inputStream)) as SilAstNodeFunction
    println("${parse.toSilString()}")

    FunctionValidatorImpl().validate(parse)
  }

  @Test
  @Throws(IOException::class, URISyntaxException::class)
  fun testLanguage() {
    val resource: URL = this.javaClass.getResource("test.sil")
    println(File(resource.toURI()))
    val inputStream: InputStream? = resource.openStream()

    /* Build AST tree. */

    val silParser: SilParser = SilParserUtil.parserFromInputStream(inputStream)
    val tree: Translation_unitContext = silParser.translation_unit()
    //ParseTreeWalker.DEFAULT.walk(new TestListener(), tree);


    println(tree.toStringTree(silParser))
  }
}