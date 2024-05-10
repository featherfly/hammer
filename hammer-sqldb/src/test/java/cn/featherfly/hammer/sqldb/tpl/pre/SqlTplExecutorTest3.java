
package cn.featherfly.hammer.sqldb.tpl.pre;

import static org.testng.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

import cn.featherfly.common.structure.ChainMapImpl;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.config.HammerConfigImpl;
import cn.featherfly.hammer.sqldb.jdbc.DataSourceTestBase;
import cn.featherfly.hammer.sqldb.jdbc.SimpleSqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Role;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.tpl.SqlTplExecutor;
import cn.featherfly.hammer.sqldb.tpl.freemarker.SqldbFreemarkerTemplateEngine;
import cn.featherfly.hammer.tpl.TplConfigFactoryImpl;
import cn.featherfly.hammer.tpl.TransverterManager;
import cn.featherfly.hammer.tpl.freemarker.FreemarkerTemplatePreProcessor;

/**
 * SqlTplExecutorTest.
 *
 * @author zhongj
 */
public class SqlTplExecutorTest3 extends DataSourceTestBase {

    SqlTplExecutor executor;

    @org.testng.annotations.BeforeClass
    void setup() {
        Set<String> prefixes = new HashSet<>();
        prefixes.add("tpl_pre/");
        prefixes.add("tpl_pre2/");
        Set<String> suffixes = new HashSet<>();
        suffixes.add(".yaml.tpl");
        suffixes.add(".yaml.sql");
        //        TplConfigFactoryImpl configFactory = new TplConfigFactoryImpl("tpl_pre/", new FreemarkerTemplatePreProcessor());
        TplConfigFactoryImpl configFactory = TplConfigFactoryImpl.builder() //
                .prefixes(prefixes).suffixes(suffixes).preCompile(new FreemarkerTemplatePreProcessor()).build();

        executor = new SqlTplExecutor(new HammerConfigImpl(), configFactory,
                new SqldbFreemarkerTemplateEngine(configFactory), jdbc, mappingFactory, new SimpleSqlPageFactory(),
                new TransverterManager());
    }

    @Test
    void testPreprocess() {
        List<User> users = executor.list("selectConditions@preprocess", User.class, new ChainMapImpl<>());
        assertTrue(users.size() > 0);
    }

    @Test
    void testMulityPrefixAndSuffix() {
        PaginationResults<Role> uis = executor.pagination("selectWithTemplate3@role", Role.class, new ChainMapImpl<>(),
                0, 10);
        assertTrue(uis.getResultSize() > 0);
        System.out.println("result size:" + uis.getResultSize());
        uis.getPageResults().forEach(ui -> {
            System.out.println(ui);
        });
    }
}
