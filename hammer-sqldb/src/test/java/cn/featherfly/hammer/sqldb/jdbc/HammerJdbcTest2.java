
package cn.featherfly.hammer.sqldb.jdbc;

import static org.testng.Assert.assertNotNull;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.constant.ConstantPool;
import cn.featherfly.hammer.sqldb.config.SqlDbConfigurator;
import cn.featherfly.hammer.sqldb.config.SqlDbConstant;

/**
 * HammerJdbcTest2.
 *
 * @author zhongj
 */
public class HammerJdbcTest2 extends HammerJdbcTest {

    SqlDbConfigurator configurator;

    @BeforeClass
    void before2() {
        //        hammer = SqlDbConfigurator.getDefault("hammer.yaml").getHammer();
        configurator = SqlDbConfigurator.getDefault();
        hammer = configurator.getHammer();
    }

    @Test
    void testSqlDbConfigurator() {
        assertNotNull(configurator.getHammer());
        assertNotNull(configurator.getJdbc());
    }

    @Test
    void testNotNull() {
        SqlDbConstant sqlDbConstant = ConstantPool.getDefault().getConstant(SqlDbConstant.class);
        assertNotNull(sqlDbConstant.getDataSource());
        assertNotNull(sqlDbConstant.getDialect());
    }

}
