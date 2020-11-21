
package cn.featherfly.hammer.sqldb.tpl;

import java.lang.reflect.Method;

import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.sqldb.jdbc.vo.User;
import cn.featherfly.hammer.tpl.mapper.BasedTplGenericHammer;

/**
 * <p>
 * UserMapper4Impl
 * </p>
 *
 * @author zhongj
 */
public class UserMapper4Impl extends BasedTplGenericHammer<cn.featherfly.hammer.sqldb.jdbc.vo.User>
        implements UserMapper4 {

    /**
     * @param hammer
     * @param type
     */
    public UserMapper4Impl(Hammer hammer, Class<User> type) {
        super(hammer, type);
    }

    public static void main(String[] args) {
        System.out.println(UserMapper4.class);
        for (Method method : UserMapper4.class.getDeclaredMethods()) {
            System.out.println(method);
        }
        System.out.println(UserMapper4Impl.class);
        for (Method method : UserMapper4Impl.class.getDeclaredMethods()) {
            System.out.println(method);
        }
        System.out.println("");
        System.out.println(ArrayUtils.toString(UserMapper4.class.getGenericInterfaces()));
        System.out.println(ClassUtils.getSuperClassGenricType(UserMapper4.class));
        System.out.println(UserMapper4.class.getGenericSuperclass());

        System.out.println(UserMapper4Impl.class.getGenericSuperclass());
        System.out.println(ClassUtils.getSuperClassGenricType(UserMapper4Impl.class));

    }
}
