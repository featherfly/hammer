
/*
 * All rights Reserved, Designed By zhongj
 * @Title: T.java
 * @Package cn.featherfly.hammer.sqldb.tpl.freemarker.directive
 * @Description: T
 * @author: zhongj
 * @date: 2023-02-08 17:48:08
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.tpl.freemarker;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.testng.annotations.Test;

import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.tpl.SqlDbTemplateProcessEnv;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerDirective;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerMethod;
import cn.featherfly.hammer.tpl.supports.ConditionParamsManager;

/**
 * T.
 *
 * @author zhongj
 */
public class SqlDbTemplateProcessEnvTest extends JdbcTestBase {

    @Test
    void test() {
        SqldbFreemarkerTemplateEngine templateEngine = new SqldbFreemarkerTemplateEngine(configFactory);
        SqlDbTemplateProcessEnv<FreemarkerDirective, FreemarkerMethod> env = templateEngine.createTemplateProcessEnv();

        assertNull(env.getConfigFactory());
        assertNull(env.getDialect());
        assertNull(env.getManager());
        assertNull(env.getMappingFactory());
        assertNull(env.getResultType());

        env.setConfigFactory(configFactory);
        env.setDialect(jdbc.getDialect());
        env.setManager(new ConditionParamsManager());
        env.setMappingFactory(mappingFactory);
        env.setResultType(String.class);

        assertNotNull(env.getConfigFactory());
        assertNotNull(env.getDialect());
        assertNotNull(env.getManager());
        assertNotNull(env.getMappingFactory());
        assertNotNull(env.getResultType());
    }
}
