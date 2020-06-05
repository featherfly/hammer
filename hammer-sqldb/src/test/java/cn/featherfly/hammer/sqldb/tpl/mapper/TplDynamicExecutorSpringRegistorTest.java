
package cn.featherfly.hammer.sqldb.tpl.mapper;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.DelegatingSmartContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.lang.RandomUtils;
import cn.featherfly.hammer.sqldb.jdbc.vo.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.UserInfo;
import cn.featherfly.hammer.sqldb.tpl.UserMapper;

/**
 * <p>
 * TplDynamicExecutorSpringRegistorTest
 * </p>
 *
 * @author zhongj
 */
@ContextConfiguration(loader = DelegatingSmartContextLoader.class, locations = "classpath:app.xml")
public class TplDynamicExecutorSpringRegistorTest extends AbstractTestNGSpringContextTests {

    @Resource
    UserMapper userMapper;

    @Resource
    UserInfoMapper userInfoMapper;

    @Resource
    UserInfoMapper2 userInfoMapper2;

    @Resource
    UserService userService;

    @BeforeClass
    public void setUp() {

    }

    @Test
    void testMapperString() {
        String str = userMapper.selectString();
        System.out.println("selectString = " + str);
        assertEquals(str, "yufei");

        str = userMapper.selectString2(2);
        System.out.println("selectString = " + str);
        assertEquals(str, "featherfly");
    }

    @Test
    void testMapperCache() {
        Integer id = 1;
        UserInfo ui = userInfoMapper.selectById(id);
        System.out.println("selectString = " + ui);
        assertEquals(ui.getId(), id);

        System.err.println("--------------------------------");

        userInfoMapper.selectById(id);
        System.out.println("selectString = " + ui);
        assertEquals(ui.getId(), id);

        userInfoMapper.selectById(id);
        System.out.println("selectString = " + ui);
        assertEquals(ui.getId(), id);
    }

    @Test
    void testMapperCache2() {
        Integer id = 1;
        UserInfo ui = userInfoMapper2.selectById(id);
        System.out.println("selectString = " + ui);
        assertEquals(ui.getId(), id);

        System.err.println("--------------------------------");

        userInfoMapper.selectById(id);
        System.out.println("selectString = " + ui);
        assertEquals(ui.getId(), id);

        userInfoMapper.selectById(id);
        System.out.println("selectString = " + ui);
        assertEquals(ui.getId(), id);
    }

    @Test(expectedExceptions = { RuntimeException.class })
    void testTransactionRollBack() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            User u = new User();
            u.setUsername("rollback_" + RandomUtils.getRandomString(6));
            u.setPwd(RandomUtils.getRandomString(6));
            u.setAge(RandomUtils.getRandomInt(40));
            list.add(u);
        }
        userService.saveBatch(list.toArray(new User[list.size()]));
    }
}
