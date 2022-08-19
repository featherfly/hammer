
package cn.featherfly.hammer.tpl.mapper;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.hammer.GenericHammer;

/**
 * <p>
 * Test
 * </p>
 *
 * @author zhongj
 */
public interface Test extends GenericHammer<User, Long> {

    List<Superclass> find();

    static Map<String, Type> getInterfacesGenricTypeMap(Class<?> clazz) {
        Map<String, Type> typeGenericParams = new HashMap<>();
        // 得到泛型父类
        Type genType = clazz.getGenericSuperclass();
        if (genType instanceof ParameterizedType) {
            // 如果是泛型父类拿到泛型父类定义中已经明确的泛型
            ParameterizedType pt = (ParameterizedType) genType;
            Type[] types = pt.getActualTypeArguments();
            // 获取父类型的泛型定义
            TypeVariable<?>[] tvs = clazz.getSuperclass().getTypeParameters();
            for (int i = 0; i < types.length; i++) {
                typeGenericParams.put(tvs[i].getName(), types[i]);
            }
        }
        return typeGenericParams;
    }

    static void main(String[] args) throws NoSuchMethodException, SecurityException {
        Method method = Test.class.getMethod("find", new Class[] {});

        ParameterizedType type = (ParameterizedType) method.getGenericReturnType();
        System.out.println(type.getRawType());
        System.out.println(type.getOwnerType());
        System.out.println(type.getActualTypeArguments()[0].getTypeName());
        System.out.println(method.getGenericReturnType());
        System.out.println(method.getGenericReturnType().getTypeName());
        System.out.println(method.getReturnType());
        System.out.println(method.getReturnType().getTypeName());

        method = Test.class.getMethod("get", Serializable.class);

        Map<String, Type> map = ClassUtils.getSuperClassGenericTypeMap(Test.class);

        System.out.println(map);
        System.out.println(method.getGenericReturnType().getClass());
        //        TypeVariable typeVariable;
        System.out.println(ArrayUtils.toString(method.getGenericReturnType().getClass().getInterfaces()));
        System.out.println(method.getGenericReturnType());
        System.out.println(method.getGenericReturnType().getTypeName());
        System.out.println(method.getReturnType());
        System.out.println(method.getReturnType().getTypeName());

        for (Type t : Test.class.getGenericInterfaces()) {
            ParameterizedType pt = (ParameterizedType) t;
            System.out.println(pt);
            System.out.println(pt.getRawType());
            System.out.println(ArrayUtils.toString(pt.getActualTypeArguments()));
        }
    }
}
