
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ContainsEntityExpressionImpl.java
 * @Package cn.featherfly.hammer.expression.entity.condition.co
 * @Description: ContainsEntityExpressionImpl
 * @author: zhongj
 * @date: 2023-07-28 16:46:28
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.condition.co;

import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.co.MulitiContainsExpression;
import cn.featherfly.hammer.expression.repository.condition.AbstractRepositoryIndexableConditionExpression;

/**
 * AbstractContainsRepositoryExpression.
 *
 * @author zhongj
 * @param <T> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractContainsRepositoryExpression<C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        extends AbstractRepositoryIndexableConditionExpression<MulitiContainsExpression<C, L>>
        implements ContainsRepositoryExpression {

    /**
     * Instantiates a new abstract contains entity expression.
     *
     * @param index          the index
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     */
    protected AbstractContainsRepositoryExpression(int index, MulitiContainsExpression<C, L> expression,
            Predicate<Object> ignoreStrategy) {
        super(index, expression, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        expression.co(index, name, value, matchStrategy, ignoreStrategy);
    }
}
