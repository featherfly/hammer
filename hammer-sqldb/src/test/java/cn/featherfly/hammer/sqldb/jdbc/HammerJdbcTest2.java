
package cn.featherfly.hammer.sqldb.jdbc;

import org.testng.annotations.BeforeClass;

import cn.featherfly.hammer.sqldb.config.SqlDbConfigurator;

/**
 * <p>
 * SqlOrmTest
 * </p>
 *
 * @author zhongj
 */
public class HammerJdbcTest2 extends HammerJdbcTest {

    @Override
    @BeforeClass
    void before() {
        hammer = SqlDbConfigurator.getDefault("hammer.yaml").getHammer();
    }

    @Override
    @BeforeClass
    public void initMysql() {

    }

}
