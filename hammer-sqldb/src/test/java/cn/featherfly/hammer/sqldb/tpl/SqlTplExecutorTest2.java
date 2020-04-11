
package cn.featherfly.hammer.sqldb.tpl;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cn.featherfly.hammer.HammerException;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.tpl.freemarker.SqldbFreemarkerTemplateEngine;
import cn.featherfly.hammer.tpl.TplConfigFactoryImpl;

/**
 * <p>
 * SqlTplExecutorTest
 * </p>
 *
 * @author zhongj
 */
public class SqlTplExecutorTest2 extends JdbcTestBase {

    SqlTplExecutor executor;

    @BeforeMethod
    void setup() {
    }

    @Test(expectedExceptions = HammerException.class)
    void testInvalidateChar() {
        TplConfigFactoryImpl configFactory = new TplConfigFactoryImpl("tpl2/");
        executor = new SqlTplExecutor(configFactory, new SqldbFreemarkerTemplateEngine(configFactory), jdbc,
                mappingFactory);
    }
}
