
package cn.featherfly.juorm.tpl.mapper;

import static org.testng.Assert.assertEquals;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.juorm.rdb.tpl.UserMapper;

/**
 * <p>
 * TplDynamicExecutorSpringRegistorTest
 * </p>
 * <p>
 * 2019-08-15
 * </p>
 *
 * @author zhongj
 */
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = { Appconfig.class })
public class TplDynamicExecutorSpringRegistorTest extends AbstractTestNGSpringContextTests {

    @Resource
    UserMapper userMapper;

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
}
