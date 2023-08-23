
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Test.java
 * @Description: Test
 * @author: zhongj
 * @date: 2023-08-21 15:25:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb;

import java.util.function.Function;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.lang.Timer;
import cn.featherfly.hammer.sqldb.jdbc.vo.s.User2;

/**
 * Test.
 *
 * @author zhongj
 */
public class TestLambdaPerformance {

    long times = Integer.MAX_VALUE * 5L;

    User2 user = new User2();

    TestLambdaPerformance() {
        user.setAge(18);
        System.out.println("times " + times);
    }

    @AfterClass
    void after() {
        System.out.println();
        System.out.println(this.getClass().getName() + " end");
        System.out.println();
    }

    @BeforeClass
    void before() {
        System.out.println();
        System.out.println(this.getClass().getName() + " before");
        System.out.println();
    }

    @Test
    void testNativeMethodInvoke() {
        System.out.println();
        System.out.println("testNativeMethodInvoke");
        Timer timer = Timer.start();
        for (long i = 0; i < times; i++) {
            user.getAge();
        }
        long runtime = timer.stop();
        System.out.println("runtime -> " + runtime);
    }

    @Test
    void testLambdaMethodInvoke() {
        System.out.println();
        System.out.println("testLambdaMethodInvoke");
        Function<User2, Integer> getAge = User2::getAge;
        Timer timer = Timer.start();
        for (long i = 0; i < times; i++) {
            getAge.apply(user);
        }
        long runtime = timer.stop();
        System.out.println("runtime -> " + runtime);
    }
}
