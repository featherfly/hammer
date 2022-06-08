
package cn.featherfly.hammer.tpl.mapper;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.ClassLoaderUtils;
import cn.featherfly.common.lang.ClassUtils;

/**
 * <p>
 * TplDynamicExecutorFactoryTest
 * </p>
 *
 * @author zhongj
 */
public class MapperTest {

    //    static TplDynamicExecutorFactoryByAsm factory = TplDynamicExecutorFactoryByAsm.getInstance();

    static TplDynamicExecutorFactory factory = TplDynamicExecutorFactory.getInstance();

    Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

    @BeforeSuite
    public void init() throws IOException {
        DOMConfigurator.configure(ClassLoaderUtils.getResource("log4j.xml", this.getClass()));

        logger.debug("init");
    }

    @Test
    public void testTestMapper2() throws Exception {
        Class<?> type = ClassUtils
                .forName(factory.create(TestMapper2.class, Thread.currentThread().getContextClassLoader()));
        //        Class<TMapper> type = forName(factory.create(TMapper.class));
        System.out.println(type);
        System.out.println(Arrays.toString(type.getInterfaces()));
        System.out.println(type.getGenericSuperclass());
        System.out.println(ClassUtils.getSuperClassGenericType(type));

        for (Method m : type.getDeclaredMethods()) {
            System.out.println(m);
            System.out.println(ArrayUtils.toString(m.getAnnotations()));
            System.out.println(ArrayUtils.toString(m.getParameters()));
            System.out.println();
        }

        //        ClassUtils.forName(factory.create(TestMapper.class));
    }
}
