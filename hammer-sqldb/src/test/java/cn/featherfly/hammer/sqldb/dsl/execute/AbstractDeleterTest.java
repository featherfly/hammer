
package cn.featherfly.hammer.sqldb.dsl.execute;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;

import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;

/**
 * AbstractDeleterTest.
 *
 * @author zhongj
 */
public class AbstractDeleterTest extends AbstractExeTest {

    /** The deleter. */
    protected SqlDeleter deleter;

    /**
     * Setup.
     */
    @BeforeClass
    void setup() {
        deleter = new SqlDeleter(jdbc, mappingFactory, hammerConfig.getDslConfig().getDeleteConfig());
    }

    protected User assertUserExist(Integer id) {
        User user = hammer.get(id, User.class);
        assertEquals(user.getId(), id);
        return user;
    }
}
