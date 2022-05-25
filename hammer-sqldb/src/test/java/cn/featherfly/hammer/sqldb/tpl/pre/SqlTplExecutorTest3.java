
package cn.featherfly.hammer.sqldb.tpl.pre;

import static org.testng.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

import cn.featherfly.common.structure.HashChainMap;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.sqldb.jdbc.DataSourceTestBase;
import cn.featherfly.hammer.sqldb.jdbc.SimpleSqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.vo.Role;
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

    @org.testng.annotations.BeforeClass
    void setup() {
        Set<String> prefixs = new HashSet<>();
        prefixs.add("tpl_pre/");
        prefixs.add("tpl_pre2/");
        Set<String> suffixs = new HashSet<>();
        suffixs.add(".yaml.tpl");
        suffixs.add(".yaml.sql");
        //        TplConfigFactoryImpl configFactory = new TplConfigFactoryImpl("tpl_pre/", new FreemarkerTemplatePreProcessor());
        TplConfigFactoryImpl configFactory = new TplConfigFactoryImpl(prefixs, suffixs, new HashSet<String>(),
                new FreemarkerTemplatePreProcessor());
        executor = new SqlTplExecutor(configFactory, new SqldbFreemarkerTemplateEngine(configFactory), jdbc,
                mappingFactory, new SimpleSqlPageFactory());
    }

    @Test
    void testPreprocess() {
        List<User> users = executor.list("preprocess@selectConditions", User.class, new HashChainMap<String, Object>());
        assertTrue(users.size() > 0);
    }

    @Test
    void testMulityPrefixAndSuffix() {
        PaginationResults<Role> uis = executor.pagination("role@selectWithTemplate3", Role.class,
                new HashChainMap<String, Object>(), 0, 10);
        assertTrue(uis.getResultSize() > 0);
        System.out.println("result size:" + uis.getResultSize());
        uis.getPageResults().forEach(ui -> {
            System.out.println(ui);
        });
    }
}
