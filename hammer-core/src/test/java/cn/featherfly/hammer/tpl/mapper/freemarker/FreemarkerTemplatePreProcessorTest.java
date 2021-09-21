
package cn.featherfly.hammer.tpl.mapper.freemarker;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import cn.featherfly.common.lang.ClassLoaderUtils;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerTemplatePreProcessor;

/**
 * <p>
 * FreemakerTemplatePreProcessorTest
 * </p>
 *
 * @author zhongj
 */
public class FreemarkerTemplatePreProcessorTest {

    @Test
    void test() {

    }

    @Test
    void test2() throws IOException {
        String file = ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest.class) + "/tpl2.sql";
        System.out.println(ClassLoaderUtils.getResource(file));
        List<String> list = IOUtils.readLines(ClassLoaderUtils.getResourceAsStream(file), StandardCharsets.UTF_8);
        StringBuilder sb = new StringBuilder();
        for (String string : list) {
            sb.append(string).append("\n");
        }
        String s = sb.toString();
        System.out.println(s);
        System.err.println(new FreemarkerTemplatePreProcessor().process(s));
    }

    @Test
    void test3() throws IOException {
        String file = ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest.class) + "/tpl3.sql";
        System.out.println(ClassLoaderUtils.getResource(file));
        List<String> list = IOUtils.readLines(ClassLoaderUtils.getResourceAsStream(file), StandardCharsets.UTF_8);
        StringBuilder sb = new StringBuilder();
        for (String string : list) {
            sb.append(string).append("\n");
        }
        String s = sb.toString();
        System.out.println(s);
        System.err.println(new FreemarkerTemplatePreProcessor().process(s));
    }

    @Test
    void testSqlHints() throws IOException {
        String file = ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest.class) + "/tpl_sqlhints.sql";
        System.out.println(ClassLoaderUtils.getResource(file));
        String s = read(file);

        String process = new FreemarkerTemplatePreProcessor().process(s);
        System.err.println(process);

        String result = read(
                ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest.class) + "/tpl_sqlhints_result.sql");
        assertEquals(process, result);
    }

    @Test
    void testTransverter() throws IOException {
        String file = ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest.class) + "/tpl_transverter.sql";
        System.out.println(ClassLoaderUtils.getResource(file));
        String s = read(file);

        String process = new FreemarkerTemplatePreProcessor().process(s);
        System.err.println(process);

        String result = read(
                ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest.class) + "/tpl_transverter_result.sql");
        assertEquals(process, result);
    }

    @Test
    void testTransverter2() throws IOException {
        String file = ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest.class) + "/tpl_transverter2.sql";
        System.out.println(ClassLoaderUtils.getResource(file));
        String s = read(file);

        String process = new FreemarkerTemplatePreProcessor().process(s);
        System.err.println(process);

        String result = read(
                ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest.class) + "/tpl_transverter2_result.sql");
        assertEquals(process, result);
    }

    @Test
    void testTransverter3() throws IOException {
        String file = ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest.class) + "/tpl_transverter3.sql";
        System.out.println(ClassLoaderUtils.getResource(file));
        String s = read(file);

        String process = new FreemarkerTemplatePreProcessor().process(s);
        System.err.println(process);

        String result = read(
                ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest.class) + "/tpl_transverter3_result.sql");
        assertEquals(process, result);
    }

    @Test
    void testTransverter4() throws IOException {
        String file = ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest.class) + "/tpl_transverter4.sql";
        System.out.println(ClassLoaderUtils.getResource(file));
        String s = read(file);

        String process = new FreemarkerTemplatePreProcessor().process(s);
        System.err.println(process);

        String result = read(
                ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest.class) + "/tpl_transverter4_result.sql");
        assertEquals(process, result);
    }

    @Test
    void testTransverter5() throws IOException {
        String file = ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest.class) + "/tpl_transverter5.sql";
        System.out.println(ClassLoaderUtils.getResource(file));
        String s = read(file);

        String process = new FreemarkerTemplatePreProcessor().process(s);
        System.err.println(process);

        String result = read(
                ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest.class) + "/tpl_transverter5_result.sql");
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

    //
    //    static String s = "select /*<<prop alias='r'*/* from /*<<wrap*/user\n" + "/*<where*/ where\n"
    //            + "    /*id?*/id = /*$=:id*/1\n" + "    /*name??*/and name like /*$=:name*/'name'\n"
    //            + "    /*gender?*/ and gender = /*$=:gender*/1\n" + "    /*<?*/ and\n" + "    (\n"
    //            + "        /*??*/ username = /*$=:username*/'admin'\n"
    //            + "        /*??*/ or email = /*$=:email*/'featherfly@foxmail.com'\n"
    //            + "        /*??*/ or mobile = /*$=:mobile*/13212345678\n" + "    )\n" + "    /*>?*/\n" + "/*>where*/";

    public static void main(String[] args) throws IOException {
        String file = ClassUtils.packageToDir(FreemarkerTemplatePreProcessorTest.class) + "/tpl.sql";
        System.out.println(ClassLoaderUtils.getResource(file));
        List<String> list = IOUtils.readLines(ClassLoaderUtils.getResourceAsStream(file), StandardCharsets.UTF_8);
        StringBuilder sb = new StringBuilder();
        for (String string : list) {
            sb.append(string).append("\n");
        }
        String s = sb.toString();
        System.out.println(s);
        String result = new FreemarkerTemplatePreProcessor().process(s);
        System.err.println(result);

    }
}
