
package cn.featherfly.hammer.sqldb.tpl;

import java.lang.reflect.Method;

import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.tpl.mapper.BasedTplGenericHammer;

/**
 * UserMapper4Impl.
 *
 * @author zhongj
 */
public class UserMapper4Impl extends BasedTplGenericHammer<cn.featherfly.hammer.sqldb.jdbc.vo.r.User, Integer>
        implements UserMapper4 {

    /**
     * Instantiates a new user mapper 4 impl.
     *
     * @param hammer       the hammer
     * @param type         the type
     * @param hammerConfig the hammer config
     */
    public UserMapper4Impl(Hammer hammer, Class<User> type, HammerConfig hammerConfig) {
        super(hammer, type, hammerConfig);
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
        System.out.println(ClassUtils.getSuperClassGenericType(UserMapper4.class));
        System.out.println(UserMapper4.class.getGenericSuperclass());

        System.out.println(UserMapper4Impl.class.getGenericSuperclass());
        System.out.println(ClassUtils.getSuperClassGenericType(UserMapper4Impl.class));

    }
}
