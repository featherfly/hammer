
package cn.featherfly.hammer.sqldb.jdbc;

import org.testng.annotations.BeforeClass;

import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.sqldb.SqldbHammerImpl;

/**
 * HammerJdbcTest.
 *
 * @author zhongj
 */
public class HammerJdbcTestBase extends JdbcTestBase {

    protected Hammer hammer;

    @BeforeClass
    public void before() {
        hammer = SqldbHammerImpl.builder(jdbc, mappingFactory, configFactory, propertyAccessorFactory, hammerConfig)
            .build();
    }
}
