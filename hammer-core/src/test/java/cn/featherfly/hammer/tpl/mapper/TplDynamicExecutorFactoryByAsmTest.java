
package cn.featherfly.hammer.tpl.mapper;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.log4j.xml.DOMConfigurator;
import org.slf4j.Logger;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import cn.featherfly.common.lang.ClassLoaderUtils;
import cn.featherfly.common.lang.ClassUtils;

/**
 * <p>
 * TplDynamicExecutorFactoryTest
 * </p>
 *
 * @author zhongj
 */
public class TplDynamicExecutorFactoryByAsmTest {

    //    static TplDynamicExecutorFactoryByAsm factory = TplDynamicExecutorFactoryByAsm.getInstance();

    static TplDynamicExecutorFactory factory = TplDynamicExecutorFactory.getInstance();

    Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

    @BeforeSuite
    public void init() throws IOException {
        DOMConfigurator.configure(ClassLoaderUtils.getResource("log4j.xml", this.getClass()));

        logger.debug("init");
    }

    @Test
    public void testNoExtends() throws Exception {
        Class<?> type = ClassUtils
                .forName(factory.create(TeMapper.class, Thread.currentThread().getContextClassLoader()));
        //        Class<TMapper> type = forName(factory.create(TMapper.class));
        System.out.println(type);
        System.out.println(Arrays.toString(type.getInterfaces()));
        System.out.println(type.getGenericSuperclass());
        System.out.println(ClassUtils.getSuperClassGenericType(type));

        //        ClassUtils.forName(factory.create(TestMapper.class));
    }

    @Test
    public void testExtendsHammer() throws Exception {
        Class<?> type = ClassUtils.forName(factory.create(TMapper.class));
        //        Class<TMapper> type = forName(factory.create(TMapper.class));
        System.out.println(type);
        System.out.println(Arrays.toString(type.getInterfaces()));
        System.out.println(type.getGenericSuperclass());
        System.out.println(ClassUtils.getSuperClassGenericType(type));

        //        ClassUtils.forName(factory.create(TestMapper.class));
    }

    @Test
    public void testExtendsGenericHammer() throws Exception {
        Class<?> c = TestMapper.class;
        Class<?> type = ClassUtils.forName(factory.create(c, Thread.currentThread().getContextClassLoader()));
        System.out.println(type);
        System.out.println(Arrays.toString(type.getInterfaces()));
        System.out.println(type.getGenericSuperclass());
        System.out.println(ClassUtils.getSuperClassGenericTypeMap(type));

        assertEquals(type.getSimpleName(), c.getSimpleName() + TplDynamicExecutorFactory.CLASS_NAME_SUFFIX);

        String id = "id";
        assertEquals(TestMapper.class.getMethod("get", Long.class).getParameters()[0].getName(), id);
        assertEquals(type.getMethod("get", Long.class).getParameters()[0].getName(), id);

        for (Method method : type.getMethods()) {
            if (method.getParameterCount() > 0) {
                System.out.println(type.getName() + "." + method.getName() + " " + method.getParameters()[0].getName()
                        + " " + method.getParameters()[0].getType().getName());
            }
        }
        assertEquals(type.getMethod("save", Object.class).getParameters()[0].getName(), "entity");
        assertEquals(type.getMethod("getByUsername", String.class).getParameters()[0].getName(), "username");

    }

    public static void main(String[] args) throws Exception {
        Class<?> type = ClassUtils.forName(factory.create(TMapper.class));
        System.out.println(type.getName());
    }
}
