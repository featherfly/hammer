
package cn.featherfly.hammer.tpl.mapper.freemarker;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.IOUtils;

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
public class FreemakerTemplatePreProcessorTest {
    //
    //    static String s = "select /*<<prop alias='r'*/* from /*<<wrap*/user\n" + "/*<where*/ where\n"
    //            + "    /*id?*/id = /*$=:id*/1\n" + "    /*name??*/and name like /*$=:name*/'name'\n"
    //            + "    /*gender?*/ and gender = /*$=:gender*/1\n" + "    /*<?*/ and\n" + "    (\n"
    //            + "        /*??*/ username = /*$=:username*/'admin'\n"
    //            + "        /*??*/ or email = /*$=:email*/'featherfly@foxmail.com'\n"
    //            + "        /*??*/ or mobile = /*$=:mobile*/13212345678\n" + "    )\n" + "    /*>?*/\n" + "/*>where*/";

    public static void main(String[] args) throws IOException {
        String file = ClassUtils.packageToDir(FreemakerTemplatePreProcessorTest.class) + "/tpl.sql";
        System.out.println(ClassLoaderUtils.getResource(file));
        List<String> list = IOUtils.readLines(ClassLoaderUtils.getResourceAsStream(file), StandardCharsets.UTF_8);
        StringBuilder sb = new StringBuilder();
        for (String string : list) {
            sb.append(string).append("\n");
        }
        String s = sb.toString();
        System.out.println(s);
        System.err.println(new FreemarkerTemplatePreProcessor().process(s));
        //        Parser parser = new Parser(s);
        //        parser.parse();
        //        System.out.println(parser.elements);
    }
}
