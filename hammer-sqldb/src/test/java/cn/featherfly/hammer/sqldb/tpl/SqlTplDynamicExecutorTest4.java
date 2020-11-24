
package cn.featherfly.hammer.sqldb.tpl;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.lang.Randoms;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.sqldb.SqldbHammerImpl;
import cn.featherfly.hammer.sqldb.jdbc.JdbcTestBase;
import cn.featherfly.hammer.sqldb.jdbc.vo.User;
import cn.featherfly.hammer.tpl.mapper.TplDynamicExecutorFactory;

/**
 * <p>
 * SqlTplExecutorTest
 * </p>
 *
 * @author zhongj
 */
public class SqlTplDynamicExecutorTest4 extends JdbcTestBase {

    UserMapper4 userMapper;

    @BeforeClass
    void setup() {
        TplDynamicExecutorFactory mapperFactory = TplDynamicExecutorFactory.getInstance();
        Hammer hammer = new SqldbHammerImpl(jdbc, mappingFactory, configFactory);
        userMapper = mapperFactory.newInstance(UserMapper4.class, hammer);
    }

    @Test
    void testGet() {
        User user = new User();
        user.setAge(100);
        user.setUsername("username_" + Randoms.getString(5));
        userMapper.save(user);

        User u = userMapper.get(user.getId());
        assertEquals(u.getAge(), user.getAge());
        assertEquals(u.getUsername(), user.getUsername());

    }
}
