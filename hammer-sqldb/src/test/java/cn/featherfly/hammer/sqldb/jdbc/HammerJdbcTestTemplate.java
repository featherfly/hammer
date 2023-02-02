
package cn.featherfly.hammer.sqldb.jdbc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import cn.featherfly.hammer.sqldb.SqldbHammerImpl;
import cn.featherfly.hammer.sqldb.tpl.SqlTplExecutorTest;
import cn.featherfly.hammer.sqldb.tpl.freemarker.SqldbFreemarkerTemplateEngine;

/**
 * HammerJdbcTest.
 *
 * @author zhongj
 */
public class HammerJdbcTestTemplate extends SqlTplExecutorTest {

    Serializable nullObject;
    List<Serializable> emptyList = new ArrayList<>();
    Serializable[] emptyArray = new Serializable[0];

    @BeforeClass
    void before() {
        //        TplConfigFactoryImpl configFactory = new TplConfigFactoryImpl("tpl/", ".yaml.tpl");
        executor = new SqldbHammerImpl(jdbc, mappingFactory, configFactory,
                new SqldbFreemarkerTemplateEngine(configFactory), new SimpleSqlPageFactory());
    }

    Integer minAge = 5;
    Integer maxAge = 40;
    String username1 = "yufei";
    String username2 = "featherfly";
    String password = "123";

    @BeforeMethod
    void setup() {
    }
}
