
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-15 15:58:15
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.condition;

import java.util.function.Predicate;

import cn.featherfly.hammer.expression.condition.AbstractIndexableConditionExpression;
import cn.featherfly.hammer.expression.condition.ConditionExpression;

/**
 * AbstractConditionRepositoryExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public class AbstractRepositoryIndexableConditionExpression<C extends ConditionExpression>
        extends AbstractIndexableConditionExpression<C> {

    /**
     * Instantiates a new abstract condition repository expression.
     *
     * @param index          the index
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     */
    protected AbstractRepositoryIndexableConditionExpression(int index, C expression,
            Predicate<Object> ignoreStrategy) {
        super(index, expression, ignoreStrategy);
    }
}
