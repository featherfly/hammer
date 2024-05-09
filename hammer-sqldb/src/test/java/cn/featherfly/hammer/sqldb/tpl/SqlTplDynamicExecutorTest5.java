
package cn.featherfly.hammer.sqldb.tpl;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.lang.Randoms;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.sqldb.SqldbHammerImpl;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.tpl.mapper.TplDynamicExecutorFactory;

/**
 * <p>
 * SqlTplExecutorTest
 * </p>
 *
 * @author zhongj
 */
public class SqlTplDynamicExecutorTest5 extends JdbcTestBase {

    UserMapper5 userMapper;
    UserMapper4 userMapper4;

    @BeforeClass
    void setup() {
        TplDynamicExecutorFactory mapperFactory = TplDynamicExecutorFactory.getInstance();
        Hammer hammer = new SqldbHammerImpl(jdbc, mappingFactory, configFactory, hammerConfig);
        userMapper = mapperFactory.newInstance(UserMapper5.class, hammer, hammerConfig);
        userMapper4 = mapperFactory.newInstance(UserMapper4.class, hammer, hammerConfig);
    }

    @Test
    void testGetByUsername() {
        User user = new User();
        user.setAge(18);
        user.setUsername("username_" + Randoms.getString(5));
        userMapper4.save(user);

        User u = userMapper.getByUsername(user.getUsername());
        assertEquals(u.getAge(), user.getAge());
        assertEquals(u.getUsername(), user.getUsername());

    }
}
