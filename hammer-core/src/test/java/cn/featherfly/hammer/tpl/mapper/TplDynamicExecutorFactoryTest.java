
package cn.featherfly.hammer.tpl.mapper;

import java.util.Arrays;

import org.testng.annotations.Test;

import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.hammer.Hammer;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.Modifier;
import javassist.NotFoundException;
import javassist.bytecode.SignatureAttribute;

/**
 * <p>
 * TplDynamicExecutorFactoryTest
 * </p>
 *
 * @author zhongj
 */
public class TplDynamicExecutorFactoryTest {

    TplDynamicExecutorFactory factory = TplDynamicExecutorFactory.getInstance();

    @Test
    public void test() throws Exception {
        //        Class<?> type = ClassUtils.forName(factory.create(TestMapper.class));;
        Class<TestMapper> type = forName(factory.create(TestMapper.class));
        System.out.println(type);
        System.out.println(Arrays.toString(type.getInterfaces()));
        System.out.println(type.getGenericSuperclass());
        System.out.println(ClassUtils.getSuperClassGenericType(type));

        //        ClassUtils.forName(factory.create(TestMapper.class));
    }

    @Test
    public void test2() throws Exception {
        Class<TestMapper2> type = forName(factory.create(TestMapper2.class));
        System.out.println(type);
        System.out.println(Arrays.toString(type.getInterfaces()));
        System.out.println(type.getGenericSuperclass());
        System.out.println(ClassUtils.getSuperClassGenericType(type));

        //        ClassUtils.forName(factory.create(TestMapper.class));
    }

    public static void main(String[] args) throws Exception {
        String newClassName = "cn.test.NewClass";
        ClassPool pool = ClassPool.getDefault();
        //        pool.insertClassPath(new ClassClassPath(this.getClass()));
        CtClass newClass = pool.makeClass(newClassName);
        CtClass superclass = pool.getCtClass(BasedTplGenericHammer.class.getName());
        newClass.addInterface(pool.getCtClass(TestMapper.class.getName()));

        newClass.setSuperclass(superclass);
        newClass.setGenericSignature(new SignatureAttribute.TypeVariable("BasedTplGenericHammer<User>").encode());

        System.out.println(newClass);

        CtConstructor constraConstructor = new CtConstructor(
                new CtClass[] { pool.getCtClass(Hammer.class.getName()), pool.getCtClass(String.class.getName()) },
                newClass);
        constraConstructor.setModifiers(Modifier.PUBLIC);
        System.out.println(constraConstructor);

        //        newClass.setSuperclass(superclass);

        //        System.out.println(new SignatureAttribute.TypeVariable("BasedTplGenericHammer<User>").encode());
        //        System.out.println(new SignatureAttribute.TypeParameter("BasedTplGenericHammer<User>"));
        //        System.out.println(new SignatureAttribute.TypeArgument(new ClassType(BasedTplGenericHammer.class.getName())));
        //        ClassSignature cs = new ClassSignature(new TypeParameter[] { new TypeParameter(User.class.getName()) });
        //        System.out.println(cs.encode());
        //        System.out.println(cs.getSuperClass());
        //        System.out.println(cs.getInterfaces());
    }

    @SuppressWarnings("unchecked")
    public <T> Class<T> forName(String name) throws NotFoundException, CannotCompileException {
        return (Class<T>) ClassUtils.forName(name);
    }
}
