
package cn.featherfly.hammer.tpl.mapper.freemarker;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.ClassLoaderUtils;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.Console;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.config.TemplateConfigImpl;
import cn.featherfly.hammer.config.tpl.TemplateConfig;
import cn.featherfly.hammer.tpl.TplException;
import cn.featherfly.hammer.tpl.TplExecuteConfig;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerTemplatePreProcessor;

/**
 * FreemakerTemplatePreProcessorTest.
 *
 * @author zhongj
 */
public class FreemarkerTemplatePreProcessorTest2 {

    TemplateConfig templateConfig = new TemplateConfigImpl().setPrecompileNamedParamPlaceholder(false)
            .setPrecompileMinimize(false);
    TplExecuteConfig config = new TplExecuteConfig();

    private FreemarkerTemplatePreProcessor processor = new FreemarkerTemplatePreProcessor(templateConfig);

    @Test
    void test() throws IOException {
        String file = ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest2.class) + "/tpl.sql";
        System.out.println(ClassLoaderUtils.getResource(file));
        List<String> list = IOUtils.readLines(ClassLoaderUtils.getResourceAsStream(file), StandardCharsets.UTF_8);
        StringBuilder sb = new StringBuilder();
        for (String string : list) {
            sb.append(string).append("\n");
        }
        String s = sb.toString();
        System.out.println(s);
        System.err.println(processor.process(s, config));
    }

    @Test
    void test2() throws IOException {
        String file = ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest2.class) + "/tpl2.sql";
        System.out.println(ClassLoaderUtils.getResource(file));
        List<String> list = IOUtils.readLines(ClassLoaderUtils.getResourceAsStream(file), StandardCharsets.UTF_8);
        StringBuilder sb = new StringBuilder();
        for (String string : list) {
            sb.append(string).append("\n");
        }
        String s = sb.toString();
        System.out.println(s);
        System.err.println(processor.process(s, config));
    }

    @Test
    void test3() throws IOException {
        String file = ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest2.class) + "/tpl3.sql";
        System.out.println(ClassLoaderUtils.getResource(file));
        List<String> list = IOUtils.readLines(ClassLoaderUtils.getResourceAsStream(file), StandardCharsets.UTF_8);
        StringBuilder sb = new StringBuilder();
        for (String string : list) {
            sb.append(string).append("\n");
        }
        String s = sb.toString();
        System.out.println(s);
        System.err.println(processor.process(s, config));
    }

    @Test(expectedExceptions = TplException.class,
            expectedExceptionsMessageRegExp = "replaceable warp directive has no replaceble target, you can give target after[\\W]+")
    void testError() throws IOException {
        String file = ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest2.class) + "/tpl_error.sql";
        System.out.println(ClassLoaderUtils.getResource(file));
        List<String> list = IOUtils.readLines(ClassLoaderUtils.getResourceAsStream(file), StandardCharsets.UTF_8);
        StringBuilder sb = new StringBuilder();
        for (String string : list) {
            sb.append(string).append("\n");
        }
        String s = sb.toString();
        System.out.println(s);
        System.err.println(processor.process(s, config));
    }

    @Test
    void testScanParams() throws IOException {
        String file = ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest2.class) + "/tpl_names.sql";
        System.out.println(ClassLoaderUtils.getResource(file));
        List<String> list = IOUtils.readLines(ClassLoaderUtils.getResourceAsStream(file), StandardCharsets.UTF_8);
        StringBuilder sb = new StringBuilder();
        for (String string : list) {
            sb.append(string).append("\n");
        }
        String s = sb.toString();
        Console.log(s);
        // namedParamPlaceholder false
        System.err.println(processor.process(s, config));
        Console.error("paramNames({}): {}", config.getParamNames().length, ArrayUtils.toString(config.getParamNames()));
        Console.error("inParamNames({}): {}", config.getInParamNames().length,
                ArrayUtils.toString(config.getInParamNames()));
        Console.error("pames({}): {}", config.getParams().length, ArrayUtils.toString(config.getParams()));

        Set<String> inPs = Lang.set("ids", "ids2", "ids3", "ids4");

        // assert params and paramNames
        assertEquals(config.getParamNames(),
                new String[] { "username", "password", "mobileNo", "mobileNo", "mobileNo", "ids", "minAge", "maxAge",
                        "ids2", "birthday", "ids3", "gender", "birthday", "email", "mobile", "ids4" });
        System.out.println(config.getParams().length);
        assertEquals(config.getParams().length, config.getParamNames().length);

        // assert in param
        for (String inp : inPs) {
            assertTrue(ArrayUtils.contain(config.getInParamNames(), inp));
        }

    }

    @Test
    void testScanParams2() throws IOException {
        String file = ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest2.class) + "/tpl_names2.sql";
        System.out.println(ClassLoaderUtils.getResource(file));
        List<String> list = IOUtils.readLines(ClassLoaderUtils.getResourceAsStream(file), StandardCharsets.UTF_8);
        StringBuilder sb = new StringBuilder();
        for (String string : list) {
            sb.append(string).append("\n");
        }
        String s = sb.toString();
        System.out.println(s);
        // namedParamPlaceholder false
        System.err.println(processor.process(s, config));
        System.err.println("paramNames: " + ArrayUtils.toString(config.getParamNames()));
        assertEquals(config.getParamNames(), new String[] { "id", "age", "username", "password", "mobile" });
        System.out.println(config.getParams().length);
        //        assertEquals(config.getParams().length, config.getParamNames().length);
    }

    @Test
    void testScanParams3() throws IOException {
        String file = ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest2.class) + "/tpl_names3.sql";
        System.out.println(ClassLoaderUtils.getResource(file));
        List<String> list = IOUtils.readLines(ClassLoaderUtils.getResourceAsStream(file), StandardCharsets.UTF_8);
        StringBuilder sb = new StringBuilder();
        for (String string : list) {
            sb.append(string).append("\n");
        }
        String s = sb.toString();
        System.out.println(s);
        // namedParamPlaceholder false
        System.err.println(processor.process(s, config));
        System.err.println("paramNames: " + ArrayUtils.toString(config.getParamNames()));
        //        assertEquals(config.getParamNames(), new String[] { "id", "age", "username", "password", "mobile" });
        //        System.out.println(config.getParams().length);
        //        assertEquals(config.getParams().length, config.getParamNames().length);
    }

    @Test
    void testInclude() throws IOException {
        String file = ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest2.class) + "/tpl_include.sql";
        System.out.println(ClassLoaderUtils.getResource(file));
        List<String> list = IOUtils.readLines(ClassLoaderUtils.getResourceAsStream(file), StandardCharsets.UTF_8);
        StringBuilder sb = new StringBuilder();
        for (String string : list) {
            sb.append(string).append("\n");
        }
        String s = sb.toString();
        System.out.println(s);
        // namedParamPlaceholder false
        String process = processor.process(s, config);
        System.err.println();
        System.err.println("paramNames: " + ArrayUtils.toString(config.getParamNames()));
        //        assertEquals(config.getParamNames(), new String[] { "id", "age", "username", "password", "mobile" });
        //        System.out.println(config.getParams().length);
        //        assertEquals(config.getParams().length, config.getParamNames().length);

        String result = read(
                ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest2.class) + "/tpl_include_result.sql");
        assertEquals(process, result);

    }

    @Test
    void testNoneParam() throws IOException {
        String file = ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest2.class) + "/tpl_none_param.sql";
        System.out.println(ClassLoaderUtils.getResource(file));
        List<String> list = IOUtils.readLines(ClassLoaderUtils.getResourceAsStream(file), StandardCharsets.UTF_8);
        StringBuilder sb = new StringBuilder();
        for (String string : list) {
            sb.append(string).append("\n");
        }
        String s = sb.toString();
        System.out.println(s);
        // namedParamPlaceholder false
        System.err.println(processor.process(s, config));
        System.err.println("paramNames: " + ArrayUtils.toString(config.getParamNames()));
        //        assertEquals(config.getParamNames(), new String[] { "id", "age", "username", "password", "mobile" });
        //        System.out.println(config.getParams().length);
        //        assertEquals(config.getParams().length, config.getParamNames().length);
    }

    @Test
    void testSqlHints() throws IOException {
        String file = ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest2.class) + "/tpl_sqlhints.sql";
        System.out.println(ClassLoaderUtils.getResource(file));
        String s = read(file);

        String process = processor.process(s, config);
        System.err.println(process);

        String result = read(
                ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest2.class) + "/tpl_sqlhints_result2.sql");
        assertEquals(process, result);
    }

    @Test
    void testTransverter() throws IOException {
        String file = ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest2.class) + "/tpl_transverter.sql";
        System.out.println(ClassLoaderUtils.getResource(file));
        String s = read(file);

        String process = processor.process(s, config);
        System.err.println(process);

        String result = read(
                ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest2.class) + "/tpl_transverter_result2.sql");
        assertEquals(process, result);
    }

    @Test
    void testTransverter2() throws IOException {
        String file = ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest2.class) + "/tpl_transverter2.sql";
        System.out.println(ClassLoaderUtils.getResource(file));
        String s = read(file);

        String process = processor.process(s, config);
        System.err.println(process);

        System.err.println("paramNames: " + ArrayUtils.toString(config.getParamNames()));

        String result = read(
                ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest2.class) + "/tpl_transverter2_result2.sql");

        assertEquals(process, result);
    }

    @Test
    void testTransverter3() throws IOException {
        String file = ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest2.class) + "/tpl_transverter3.sql";
        System.out.println(ClassLoaderUtils.getResource(file));
        String s = read(file);

        String process = processor.process(s, config);
        System.err.println(process);

        System.err.println("paramNames: " + ArrayUtils.toString(config.getParamNames()));

        String result = read(
                ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest2.class) + "/tpl_transverter3_result2.sql");
        assertEquals(process.trim(), result.trim());
    }

    @Test
    void testTransverter4() throws IOException {
        String file = ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest2.class) + "/tpl_transverter4.sql";
        System.out.println(ClassLoaderUtils.getResource(file));
        String s = read(file);

        String process = processor.process(s, config);
        System.err.println(process);

        String result = read(
                ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest2.class) + "/tpl_transverter4_result2.sql");
        assertEquals(process, result);
    }

    @Test
    void testTransverter5() throws IOException {
        String file = ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest2.class) + "/tpl_transverter5.sql";
        System.out.println(ClassLoaderUtils.getResource(file));
        String s = read(file);

        String process = processor.process(s, config);
        System.err.println(process);

        String result = read(
                ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest2.class) + "/tpl_transverter5_result2.sql");
        assertEquals(process, result);
    }

    private String read(String file) throws IOException {
        List<String> list = IOUtils.readLines(ClassLoaderUtils.getResourceAsStream(file), StandardCharsets.UTF_8);
        StringBuilder sb = new StringBuilder();
        for (String string : list) {
            sb.append(string).append("\n");
        }
        return sb.toString();
    }

}
