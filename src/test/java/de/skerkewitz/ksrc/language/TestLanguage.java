package de.skerkewitz.ksrc.language;

import de.skerkewitz.ksrc.ast.Builder;
import de.skerkewitz.ksrc.ast.nodes.statement.AstStatement;
import de.skerkewitz.ksrc.sema.Sema;
import de.skerkewitz.ksrc.sema.SemaFactory;
import de.skerkewitz.ksrc.vm.Vm;
import de.skerkewitz.ksrc.vm.impl.DefaultVm;
import de.skerkewitz.ksrc.vm.impl.VmDefaultExecContext;
import de.skerkewitz.ksrc.vm.impl.VmExecContextFactory;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static de.skerkewitz.ksrc.antlr.KsrcParserUtil.parserFromInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLanguage {

  public static class TeeOutStream extends OutputStream {
    final OutputStream one;
    final OutputStream two;

    public TeeOutStream(OutputStream one, OutputStream two) {
      this.one = one;
      this.two = two;
    }

    @Override
    public void write(int b) throws IOException {
      one.write(b);
      two.write(b);
    }
  }

  @Test
  void testLanguage() throws URISyntaxException {
    ClassLoader classLoader = getClass().getClassLoader();
    var directory = classLoader.getResource("language").toURI();

    File[] files = new File(directory).listFiles();
    List<File> fileList = List.of(files);


    Map<String, File> expectedOutput = fileList.stream().filter(file -> file.getName().endsWith(".out")).collect(Collectors.toMap(f -> f.getName().substring(0, f.getName().length() - 4), o -> o));


    Stream<File> sourceStream = fileList.stream().filter(file -> file.getName().endsWith(".ksrc"));

    /* Run each source and compare if with the result. */
    sourceStream.forEach(file -> {
      System.out.println("Testing file: " + file.getName());

      ParseTree treeLib = null;
      try {
        treeLib = parserFromInputStream(new FileInputStream(file)).translation_unit();

        AstStatement rootStatement = (AstStatement) new Builder().visit(treeLib);

        final Sema sema = SemaFactory.buildSemaFromRootStatement(rootStatement);

        var vmExecContext = (VmDefaultExecContext)VmExecContextFactory.initialContext();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        vmExecContext.setStdout(new TeeOutStream(System.out, outputStream));
        vmExecContext.setStderr(new TeeOutStream(System.err, outputStream));

        Vm vm = new DefaultVm(sema);
        Vm.Value ret = vm.exec(rootStatement, vmExecContext);

        /* Assert equals of capture with ".out" file. */
        final var capture = new String(outputStream.toByteArray());
        final var outFile = expectedOutput.get(file.getName().substring(0, file.getName().length() - 5));

        System.out.println("Capture: ");
        System.out.println(capture);

        final var expected = IOUtils.toString(outFile.toURI(), "ISO-8859-1");
        assertEquals(expected, capture);

      } catch (IOException e) {
        throw new RuntimeException("Could not access file " + file.getName() + " because of:", e);
      }
    });
  }

  @Test
  void testSingleLanguageFile() throws URISyntaxException, IOException {

    final var filename = "language/sum-call.ksrc6666666666";
    final var classLoader = getClass().getClassLoader();
    final var sourceStream = classLoader.getResource(filename).openStream();

    /* Run each source and compare if with the result. */
    System.out.println("Testing file: " + filename);

    ParseTree treeLib = parserFromInputStream(sourceStream).translation_unit();
    AstStatement rootStatement = (AstStatement) new Builder().visit(treeLib);

    final Sema sema = SemaFactory.buildSemaFromRootStatement(rootStatement);

    var vmExecContext = VmExecContextFactory.initialContext();

    Vm vm = new DefaultVm(sema);
    Vm.Value ret = vm.exec(rootStatement, vmExecContext);
  }
}