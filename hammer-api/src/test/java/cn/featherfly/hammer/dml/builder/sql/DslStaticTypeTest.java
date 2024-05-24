
package cn.featherfly.hammer.dml.builder.sql;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import org.testng.annotations.Test;

import cn.featherfly.common.bean.function.BeanPropertySupplier;
import cn.featherfly.common.bean.function.BeanPropertySupplierImpl;
import cn.featherfly.common.function.ThreeArgusFunction;
import cn.featherfly.hammer.dml.builder.sql.vo.User;
import cn.featherfly.hammer.dml.builder.sql.vo.UserInfo;

/**
 * <p>
 * DslTest
 * </p>
 *
 * @author zhongj
 */
public class DslStaticTypeTest {

    public void testQuery() {
        //        UserQuery userQuery = null;
        // userQuery.find().properties().name().pwd().limit(1)
        // .single(UserQuery.class);

        //        IMPLSOON 后续来修正下面几行
        //        userQuery.find().properties().name().pwd().limit(1).single(UserQuery.class);
        //        userQuery.find().limit(1).single(UserQuery.class);
        //        userQuery.find().where().name().eq("yufei").and().pwd().eq("123456").and().group().age().ge(18).and().age()
        //                .le(30);

    }

    public void testUpdate() {
        //        UserUpdate userUpdate = null;
        //        userUpdate.name().set("yufei").age().increase(10).pwd().set("123").execute();
        //
        //        UserUpdater userUpdater = null;
        //        userUpdater.update().name().set("yufei").age().increase(10).pwd().set("123").execute();
    }

    public void testDelete() {
    }

    void s(Supplier<String> c) {
        System.out.println(c.getClass().getName());
        System.out.println(c.get());
    }

    <T, V> void s2(BeanPropertySupplier<T, V> c) {
        System.out.println(c.getClass().getName());
        System.out.println(c.getInstanceType());
        System.out.println(c.getName());
        System.out.println(c.get());
    }

    <V> void s3(BeanPropertySupplier<User, V> c) {
        System.out.println(c.getClass().getName());
        System.out.println(c.getInstanceType());
        System.out.println(c.getName());
        System.out.println(c.get());
    }

    <V> void f(Function<User, String> f) {
        System.out.println(f.getClass().getName());
    }

    <V> void f2(BiFunction<User, String, User> f) {
        System.out.println(f.getClass().getName());
    }

    <V> void f4(ThreeArgusFunction<User, Integer, Integer, String> f) {
        System.out.println(f.getClass().getName());
    }

    @Test
    public void testFun() {
        User user = new User();
        user.setUsername("yufei");

        f2(User::username);

        Supplier<String> s = user::getUsername;
        String username = s.get();

        Function<String, User> f = user::username;
        f.apply("yi");

        Function<User, String> f2 = User::getUsername;
        f2.apply(user);

        f4(User::testTwoArgu);
    }

    @Test
    public void test() {
        User user = new User();
        user.setUsername("yufei");
        UserInfo userInfo = new UserInfo();
        userInfo.setName("yufei");

        s(user::getUsername);

        //        s2(user::getUsername);

        System.out.println("---------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------");

        s2(new BeanPropertySupplierImpl<>(User.class, String.class, user.getUsername(), "username", 0));

        System.out.println("---------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------");

        s2(new BeanPropertySupplier<User, String>() {

            private static final long serialVersionUID = 2065662718868959669L;

            private String value = user.getUsername();

            @Override
            public Class<User> getInstanceType() {
                return User.class;
            }

            @Override
            public String getName() {
                return "username";
            }

            @Override
            public String get() {
                return value;
            }

            @Override
            public int getIndex() {
                // YUFEI_TODO Auto-generated method stub
                return 0;
            }
        });

        //        s3(user::getUsername);
        //
        //        s3(userInfo::getName);
    }
}