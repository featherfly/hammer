
/*
 * All rights Reserved, Designed By zhongj
 * @Title: FuzzyQueryTransverterTest.java
 * @Package cn.featherfly.hammer.sqldb.tpl.transverter
 * @Description: FuzzyQueryTransverterTest
 * @author: zhongj
 * @date: 2023-02-10 16:07:10
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.tpl.transverter;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import cn.featherfly.hammer.sqldb.SqldbHammerException;

/**
 * FuzzyQueryTransverterTest.
 *
 * @author zhongj
 */
public class FuzzyQueryTransverterTest {

    @Test
    public void test() {
        FuzzyQueryTransverter transverter = new FuzzyQueryTransverter(true);
        assertTrue(transverter.isUpperCase());

        transverter = new FuzzyQueryTransverter(false);
        assertFalse(transverter.isUpperCase());
    }

    @Test(expectedExceptions = SqldbHammerException.class)
    public void test2() {
        FuzzyQueryTransverter transverter = new FuzzyQueryTransverter(false);

        transverter.transvert("tttt", "value");

    }

}
