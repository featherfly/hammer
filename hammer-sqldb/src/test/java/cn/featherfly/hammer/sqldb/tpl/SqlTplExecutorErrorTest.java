
package cn.featherfly.hammer.sqldb.tpl;

import java.io.Serializable;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cn.featherfly.common.structure.ChainMapImpl;
import cn.featherfly.hammer.config.HammerConfigImpl;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.SimpleSqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.tpl.freemarker.SqldbFreemarkerTemplateEngine;
import cn.featherfly.hammer.tpl.TplConfigFactoryImpl;
import cn.featherfly.hammer.tpl.TplException;
import cn.featherfly.hammer.tpl.TplExecutor;
import cn.featherfly.hammer.tpl.TransverterManager;
import freemarker.template.TemplateModelException;

/**
 * SqlTplExecutorTest.
 *
 * @author zhongj
 */
public class SqlTplExecutorErrorTest extends JdbcTestBase {

    protected TplExecutor executor;

    @BeforeMethod
    void setup() throws TemplateModelException {
        TplConfigFactoryImpl configFactory = TplConfigFactoryImpl.builder().prefixes("tpl/").suffixes(".yaml.tpl")
            .config(hammerConfig.getTemplateConfig()).build();
        executor = new SqlTplExecutor(new HammerConfigImpl(devMode), configFactory,
            new SqldbFreemarkerTemplateEngine(configFactory, hammerConfig.getTemplateConfig(),
                sharedTemplateProcessEnv.createDirectives(), sharedTemplateProcessEnv.createMethods()),
            jdbc, mappingFactory, new SimpleSqlPageFactory(), new TransverterManager());
    }

    @Test(expectedExceptions = TplException.class)
    void testWrapError() {
        executor.numberInt("wrapError", new ChainMapImpl<>());
    }

    @Test(expectedExceptions = TplException.class)
    void testWrapError2() {
        executor.numberInt("wrapError2", new ChainMapImpl<>());
    }

    @Test(expectedExceptions = TplException.class)
    void testLogicDirectiveError() {
        executor.list("logicError", User.class, new ChainMapImpl<String, Serializable>().putChain("username", "yufei"));
    }

    @Test(expectedExceptions = TplException.class)
    void testLogicDirectiveError2() {
        executor.list("logicError2", User.class,
            new ChainMapImpl<String, Serializable>().putChain("username", "yufei"));
    }

    @Test(expectedExceptions = TplException.class)
    void testLogicDirectiveError3() {
        executor.list("logicError3", User.class,
            new ChainMapImpl<String, Serializable>().putChain("username", "yufei"));
    }

    @Test(expectedExceptions = TplException.class)
    void testLogicDirectiveError4() {
        executor.list("logicError4", User.class,
            new ChainMapImpl<String, Serializable>().putChain("username", "yufei"));
    }

    @Test(expectedExceptions = TplException.class)
    void testIncludeDirectiveError() {
        executor.list("includeError", new ChainMapImpl<>());
    }

    @Test(expectedExceptions = TplException.class)
    void testIncludeDirectiveError2() {
        executor.list("includeError2", new ChainMapImpl<>());
    }

    @Test(expectedExceptions = TplException.class)
    void testIncludeDirectiveError3() {
        executor.list("includeError3", new ChainMapImpl<>());
    }

    @Test(expectedExceptions = TplException.class)
    void testPropDirectiveError() {
        executor.list("propError", new ChainMapImpl<>());
    }

    @Test(expectedExceptions = TplException.class)
    void testPropDirectiveError2() {
        executor.list("propError2", new ChainMapImpl<>());
    }

    @Test(expectedExceptions = TplException.class)
    void testPropDirectiveError3() {
        executor.list("propError3", new ChainMapImpl<>());
    }

    @Test(expectedExceptions = TplException.class)
    void testPropDirectiveError4() {
        executor.list("propError4", new ChainMapImpl<>());
    }

    @Test(expectedExceptions = TplException.class)
    void testPropDirectiveError5() {
        executor.list("propError5", new ChainMapImpl<>());
    }

    @Test(expectedExceptions = TplException.class)
    void testPropDirectiveError6() {
        executor.list("propError6", new ChainMapImpl<>());
    }
}
