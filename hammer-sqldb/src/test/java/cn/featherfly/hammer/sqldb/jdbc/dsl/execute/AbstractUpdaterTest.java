
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;

import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;

/**
 * AbstractDeleterTest.
 *
 * @author zhongj
 */
public class AbstractUpdaterTest extends AbstractExeTest {

    SqlUpdater updater;

    final String NOT_MODIFY = "not_modify";

    @BeforeClass
    void setup() {
        updater = new SqlUpdater(jdbc, mappingFactory, hammerConfig.getDslConfig().getUpdateConfig());
    }

    protected User assertUserExist(Integer id) {
        User user = hammer.get(id, User.class);
        assertEquals(user.getId(), id);
        return user;
    }
}
