
/*
 * All rights Reserved, Designed By zhongj
 * @Title: AbstractConditionEntityExpression.java
 * @Package cn.featherfly.hammer.expression.entity.condition
 * @Description: AbstractConditionEntityExpression
 * @author: zhongj
 * @date: 2023-07-28 19:23:28
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition;

import java.util.function.Predicate;

import cn.featherfly.hammer.expression.condition.AbstractConditionExpression;
import cn.featherfly.hammer.expression.condition.MulitiConditionExpression;

/**
 * AbstractConditionEntityExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public class AbstractConditionEntityExpression<E extends MulitiConditionExpression>
        extends AbstractConditionExpression<E> {

    /**
     * Instantiates a new abstract condition entity expression.
     *
     * @param index          the index
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     */
    protected AbstractConditionEntityExpression(int index, E expression, Predicate<?> ignoreStrategy) {
        super(index, expression, ignoreStrategy);
    }
}
