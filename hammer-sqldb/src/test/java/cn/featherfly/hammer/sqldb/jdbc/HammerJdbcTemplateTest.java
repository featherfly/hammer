
package cn.featherfly.hammer.sqldb.jdbc;

import org.testng.annotations.BeforeClass;

import cn.featherfly.hammer.sqldb.SqldbHammerImpl;
import cn.featherfly.hammer.sqldb.tpl.SqlTplExecutorTest;
import cn.featherfly.hammer.sqldb.tpl.freemarker.SqldbFreemarkerTemplateEngine;

/**
 * HammerJdbcTest.
 *
 * @author zhongj
 */
public class HammerJdbcTemplateTest extends SqlTplExecutorTest {

    @BeforeClass
    void before() {
        //        TplConfigFactoryImpl configFactory = new TplConfigFactoryImpl("tpl/", ".yaml.tpl");
        executor = new SqldbHammerImpl(jdbc, mappingFactory, configFactory,
                new SqldbFreemarkerTemplateEngine(configFactory), new SimpleSqlPageFactory(), hammerConfig);
    }
}
