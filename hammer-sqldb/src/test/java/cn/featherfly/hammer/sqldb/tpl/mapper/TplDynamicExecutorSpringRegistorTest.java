
package cn.featherfly.hammer.sqldb.tpl.mapper;

import static org.testng.Assert.assertEquals;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.DelegatingSmartContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
}
