
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Test.java
 * @Description: Test
 * @author: zhongj
 * @date: 2023-09-01 14:58:01
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.vo;

import org.testng.annotations.Test;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.lang.Timer;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;

/**
 * Test.
 *
 * @author zhongj
 */
public class TestMethodInvoke {

    @Test
    void testNativeInvoke() {
        Timer timer = Timer.start();
        for (int i = 0; i < 1000000; i++) {
            User user = new User();
            user.setAge(i);
        }
        long time = timer.stop();
        System.out.println("testNativeInvoke:\t" + time);
    }

    @Test
    void testReflectInvoke() {
        Timer timer = Timer.start();

        for (int i = 0; i < 1000000; i++) {
            BeanDescriptor<User> bd = BeanDescriptor.getBeanDescriptor(User.class);
            //            BeanProperty<Integer> bp = bd.getBeanProperty(4);
            //                        BeanProperty<Integer> bp = bd.getBeanProperty("age");
            BeanProperty<User, Integer> bp = bd.getBeanProperty(User::getAge);
            User user = new User();
            bp.setValue(user, i);
        }
        long time = timer.stop();
        System.out.println("testReflectInvoke:\t" + time);
    }

}
