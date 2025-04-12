
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2025-04-12 16:05:12
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.tpl.mapper;

import java.io.IOException;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.DelegatingSmartContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;

/**
 * SpringTestBase.
 *
 * @author zhongj
 */
@ContextConfiguration(loader = DelegatingSmartContextLoader.class, locations = "classpath:app.xml")
public class SpringTestBase extends AbstractTestNGSpringContextTests {

    @BeforeSuite
    @Parameters({ "dataBase", "pool" })
    public void init(@Optional("mysql") String dataBase, @Optional("hikari") String pool) throws IOException {
        JdbcTestBase.init(dataBase, pool);
    }
}
