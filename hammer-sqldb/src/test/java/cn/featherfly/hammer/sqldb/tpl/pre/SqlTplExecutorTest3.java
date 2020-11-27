
package cn.featherfly.hammer.sqldb.tpl.pre;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cn.featherfly.common.structure.HashChainMap;
import cn.featherfly.hammer.sqldb.jdbc.DataSourceTestBase;
import cn.featherfly.hammer.sqldb.jdbc.vo.User;
import cn.featherfly.hammer.sqldb.tpl.SqlTplExecutor;
import cn.featherfly.hammer.sqldb.tpl.freemarker.SqldbFreemarkerTemplateEngine;
import cn.featherfly.hammer.tpl.TplConfigFactoryImpl;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerTemplatePreProcessor;

/**
 * <p>
 * SqlTplExecutorTest
 * </p>
 *
 * @author zhongj
 */
public class SqlTplExecutorTest3 extends DataSourceTestBase {

    SqlTplExecutor executor;

    @BeforeMethod
    void setup() {
    }

    @Test
    void testPreprocess() {
        TplConfigFactoryImpl configFactory = new TplConfigFactoryImpl("tpl/pre", new FreemarkerTemplatePreProcessor());
        executor = new SqlTplExecutor(configFactory, new SqldbFreemarkerTemplateEngine(configFactory), jdbc,
                mappingFactory);

        List<User> users = executor.list("preprocess@selectConditions", User.class, new HashChainMap<String, Object>());
        assertTrue(users.size() > 0);
    }
}
