
package cn.featherfly.juorm.rdb.tpl;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cn.featherfly.juorm.JuormException;
import cn.featherfly.juorm.rdb.jdbc.JdbcTestBase;
import cn.featherfly.juorm.rdb.tpl.freemarker.SqldbFreemarkerTemplateEngine;
import cn.featherfly.juorm.tpl.TplConfigFactoryImpl;

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

    @Test(expectedExceptions = JuormException.class)
    void testInvalidateChar() {
        TplConfigFactoryImpl configFactory = new TplConfigFactoryImpl("tpl2/");
        executor = new SqlTplExecutor(configFactory, new SqldbFreemarkerTemplateEngine(configFactory), jdbc,
                mappingFactory);
    }
}
