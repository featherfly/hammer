
package cn.featherfly.hammer.sqldb.jdbc.dsl.execute;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;

import cn.featherfly.hammer.sqldb.jdbc.HammerJdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;

/**
 * AbstractDeleterTest.
 *
 * @author zhongj
 */
public class AbstractDeleterTest extends HammerJdbcTestBase {

    /** The deleter. */
    protected SqlDeleter deleter;

    protected static final String ORDER_TABLE = "order";
    protected static final String ORDER_FIELD_NO = "no";
    protected static final String ORDER_FIELD_CREATE_USER = "create_user";
    protected static final String ORDER_FIELD_UPDATE_USER = "update_user";
    protected static final String ORDER_FIELD_USER1 = "user1";
    protected static final String ORDER_FIELD_USER2 = "user2";
    protected static final String ORDER_FIELD_USER3 = "user3";
    protected static final String USER_TABLE = "user";
    protected static final String USER_FIELD_ID = "id";
    protected static final String USER_FIELD_USERNAME = "username";

    protected final Integer createUserId = 6;
    protected final Integer updateUserId = 7;
    protected final Integer userId1 = 8;
    protected final Integer userId2 = 9;
    protected final Integer userId3 = 10;

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
