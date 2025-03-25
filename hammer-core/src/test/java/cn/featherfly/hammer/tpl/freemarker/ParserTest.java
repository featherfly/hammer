
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-14 22:12:14
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.tpl.freemarker;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import cn.featherfly.hammer.config.TemplateConfigImpl;
import cn.featherfly.hammer.tpl.TplExecuteConfig;
import cn.featherfly.hammer.tpl.freemarker.processor.Parser;

/**
 * DirectiveElementTest.
 *
 * @author zhongj
 */
public class ParserTest {

    TemplateConfigImpl templateConfig = new TemplateConfigImpl();

    @Test
    public void testNamedParam() {
        //        System.out.println(new Parser(new TemplateConfigImpl()).parse("select * from role r where r.id=:name",
        //            new TplExecuteConfig()));
        //        System.out.println(new Parser(new TemplateConfigImpl()).parse("select * from role r where r.id= :name",
        //            new TplExecuteConfig()));
        //        System.out.println(new Parser(new TemplateConfigImpl())
        //            .parse("insert into role(name, descp) values(:name,:descp)", new TplExecuteConfig()));
        //        System.out
        //            .println(
        //                new Parser(new TemplateConfigImpl()).parse("insert into role(name, descp) values( :name , :descp )",
        //                    new TplExecuteConfig()));

        TplExecuteConfig config = new TplExecuteConfig();
        String result = new Parser(templateConfig).parse("insert into role(name, descp) values(:name, :descp)", config);
        System.out.println(result);

        assertEquals(config.getParamNames().length, 2);
        assertEquals(config.getParams().length, 2);
        assertEquals(result, "insert into role(name, descp) values(?, ?)");

        result = new Parser(templateConfig).parse("insert into role(name,descp) values(:name,:descp)", config);
        System.out.println(result);
        assertEquals(config.getParamNames().length, 2);
        assertEquals(config.getParams().length, 2);
        assertEquals(result, "insert into role(name,descp) values(?,?)");
    }

    @Test
    public void testNamedParamWithFun() {

        TplExecuteConfig config = new TplExecuteConfig();
        // FIXME parser 在没有标签，只有命名参数时，解析出错
        // 错误结果 "insert into role(name, descp) values(:name, ?" , config.getParamNames().length == 1
        String result =
            new Parser(templateConfig).parse("select * from user u where GET_YEAR(u.create_time) = :year", config);
        System.out.println(result);

        assertEquals(config.getParamNames().length, 1);
        assertEquals(config.getParams().length, 1);
        assertEquals(result, "select * from user u where GET_YEAR(u.create_time) = ?");

        result =
            new Parser(templateConfig)
                .parse("select * from user u where DATE_FORMAT(u.create_time, \"%Y:%M:%D\") = :year", config);
        System.out.println(result);

        assertEquals(config.getParamNames().length, 1);
        assertEquals(config.getParams().length, 1);
        assertEquals(result, "select * from user u where DATE_FORMAT(u.create_time, \"%Y:%M:%D\") = ?");

        result =
            new Parser(templateConfig)
                .parse("select * from user u where DATE_FORMAT(u.create_time, '%Y:%M:%D') = :year", config);
        System.out.println(result);

        assertEquals(config.getParamNames().length, 1);
        assertEquals(config.getParams().length, 1);
        assertEquals(result, "select * from user u where DATE_FORMAT(u.create_time, '%Y:%M:%D') = ?");
    }

}
