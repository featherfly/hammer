
package cn.featherfly.hammer.sqldb.tpl;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cn.featherfly.hammer.HammerException;
import cn.featherfly.hammer.config.HammerConfigImpl;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.SimpleSqlPageFactory;
import cn.featherfly.hammer.sqldb.tpl.freemarker.SqldbFreemarkerTemplateEngine;
import cn.featherfly.hammer.tpl.TplConfigFactoryImpl;
import cn.featherfly.hammer.tpl.TransverterManager;
import freemarker.template.TemplateModelException;

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
    void testInvalidateChar() throws TemplateModelException {
        TplConfigFactoryImpl configFactory = TplConfigFactoryImpl.builder().prefixes("tpl2/").suffixes(".yaml.tpl")
            .config(hammerConfig.getTemplateConfig()).build();
        executor = new SqlTplExecutor(new HammerConfigImpl(devMode), configFactory,
            new SqldbFreemarkerTemplateEngine(configFactory, hammerConfig.getTemplateConfig(),
                sharedTemplateProcessEnv.createDirectives(), sharedTemplateProcessEnv.createMethods()),
            jdbc, mappingFactory, new SimpleSqlPageFactory(), new TransverterManager());
    }
}
