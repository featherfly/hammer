
package cn.featherfly.hammer.sqldb.tpl.pre;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

import cn.featherfly.common.structure.ChainMapImpl;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.config.HammerConfigImpl;
import cn.featherfly.hammer.config.TemplateConfigImpl;
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
            .prefixes(prefixes).suffixes(suffixes).config(hammerConfig.getTemplateConfig())
            .preCompile(new FreemarkerTemplatePreProcessor(
                new TemplateConfigImpl().setPrecompileMinimize(false).setPrecompileNamedParamPlaceholder(false)))
            .build();

        executor = new SqlTplExecutor(new HammerConfigImpl(devMode), configFactory,
            new SqldbFreemarkerTemplateEngine(configFactory, hammerConfig.getTemplateConfig()), jdbc, mappingFactory,
            new SimpleSqlPageFactory(), new TransverterManager());
    }

    @Test
    void testPreprocess() {
        List<User> users = executor.list("selectConditions@preprocess", User.class, new ChainMapImpl<>());
        assertTrue(users.size() > 0);
    }

    @Test
    void testMulityPrefixAndSuffix() {
        PaginationResults<
            Role> uis = executor.pagination("selectWithTemplate3@role", Role.class, new ChainMapImpl<>(), 0, 10);
        assertTrue(uis.getResultSize() > 0);
        System.out.println("result size:" + uis.getResultSize());
        uis.getPageResults().forEach(ui -> {
            System.out.println(ui);
        });
    }

    @Test
    public void selectConditions2() {
        Map<String,
            Object> u = executor.single("selectById2@user", new ChainMapImpl<String, Object>().putChain("id", 1));

        Map<String,
            Object> uis = executor.single("selectConditions2@user",
                new ChainMapImpl<String, Object>().putChain("username", u.get("username")) //
                    .putChain("mobile", u.get("mobileNo")) //
                    .putChain("age", null) //
                    .putChain("id", u.get("id")) //
                    .putChain("password", u.get("password")));
        assertNotNull(uis);
        assertEquals(uis.get("id"), u.get("id"));
        assertEquals(uis.get("mobileNo"), u.get("mobileNo"));
        assertEquals(uis.get("password"), u.get("password"));
        assertEquals(uis.get("username"), u.get("username"));

        PaginationResults<Map<String, Object>> up = executor.pagination("selectConditions2@user",
            new ChainMapImpl<String, Object>().putChain("username", u.get("username")) //
                .putChain("mobile", u.get("mobileNo")) //
                .putChain("age", null) //
                .putChain("id", u.get("id")) //
                .putChain("password", u.get("password")),
            0, 1);
        assertNotNull(up);
        assertTrue(up.getTotal().equals(1));

        //        <@and if=age??>id = :id</@and>
        //        <@and if=age??>age > :age</@and>
        //        <@and>
        //        (
        //            <#if test=username??>username = :username</#if>
        //            <@or if=password??>password = :password</@or>
        //            <@or if=mobile??>mobile_no = :mobile</@or>
        //        )
        //        </@and>
    }
}
