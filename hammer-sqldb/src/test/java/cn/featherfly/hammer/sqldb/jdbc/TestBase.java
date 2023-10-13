
package cn.featherfly.hammer.sqldb.jdbc;

import org.testng.annotations.BeforeTest;

/**
 * TestBase.
 *
 * @author zhongj
 */
public class TestBase {

    @BeforeTest
    public void beforeTest() {
        System.err
                .println("currentThread: " + Thread.currentThread().getId() + " - " + Thread.currentThread().getName());
    }
}
