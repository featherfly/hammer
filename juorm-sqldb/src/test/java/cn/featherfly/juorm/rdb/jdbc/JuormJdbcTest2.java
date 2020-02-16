
package cn.featherfly.juorm.rdb.jdbc;

import org.testng.annotations.BeforeClass;

import cn.featherfly.juorm.rdb.config.SqlDbConfigurator;

/**
 * <p>
 * SqlOrmTest
 * </p>
 *
 * @author zhongj
 */
public class JuormJdbcTest2 extends JuormJdbcTest {

    @Override
    @BeforeClass
    void before() {
        juorm = SqlDbConfigurator.getDefault("juorm.yaml").getJuorm();
    }

    @Override
    @BeforeClass
    public void initMysql() {

    }

}
