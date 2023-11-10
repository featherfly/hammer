
/*
 * All rights Reserved, Designed By zhongj
 * @Title: MulitiConditionExpression.java
 * @Package cn.featherfly.hammer.expression.condition
 * @Description: MulitiConditionExpression
 * @author: zhongj
 * @date: 2023-07-28 18:59:28
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition;

/**
 * MulitiConditionExpression.
 *
 * @author zhongj
 */
public interface MulitiRepositoryExpression extends Expression {

    /**
     * Gets the query alias.
     *
     * @param index the index
     * @return the query alias
     */
    String getAlias(int index);
}
