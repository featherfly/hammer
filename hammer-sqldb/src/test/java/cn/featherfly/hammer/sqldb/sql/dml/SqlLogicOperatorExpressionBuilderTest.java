
/*
 * All rights Reserved, Designed By zhongj
 * @Title: SqlLogicOperatorExpressionBuilderTest.java
 * @Package cn.featherfly.hammer.sqldb.sql.dml
 * @Description: SqlLogicOperatorExpressionBuilderTest
 * @author: zhongj
 * @date: 2023-02-13 16:42:13
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.sql.dml;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import cn.featherfly.common.operator.LogicOperator;

/**
 * SqlLogicOperatorExpressionBuilderTest.
 *
 * @author zhongj
 */
public class SqlLogicOperatorExpressionBuilderTest {

    @Test
    void testAnd() {
        SqlLogicOperatorExpressionBuilder builder = new SqlLogicOperatorExpressionBuilder(LogicOperator.AND);
        assertEquals(builder.build(), LogicOperator.AND.toString());
        assertEquals(builder.toString(), LogicOperator.AND.toString());
    }

    @Test
    void testOr() {
        SqlLogicOperatorExpressionBuilder builder = new SqlLogicOperatorExpressionBuilder(LogicOperator.OR);
        assertEquals(builder.build(), LogicOperator.OR.toString());
        assertEquals(builder.toString(), LogicOperator.OR.toString());
    }
}
