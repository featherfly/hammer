
/*
 * All rights Reserved, Designed By zhongj
 * @Title: NotEqualsEntityExpressionImpl.java
 * @Description: NotEqualsEntityExpressionImpl
 * @author: zhongj
 * @date: 2023-08-07 17:41:07
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.ne;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.AbstractConditionEntityExpression;

/**
 * The Class AbstractNotEqualsEntityExpressionImpl.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractNotEqualsEntityExpression<E, C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        extends AbstractConditionEntityExpression<MulitiEntityNotEqualsExpression<C, L>>
        implements NotEqualsEntityExpression<E> {

    /**
     * Instantiates a new abstract not equals entity expression impl.
     *
     * @param index          the index
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     */
    protected AbstractNotEqualsEntityExpression(int index, MulitiEntityNotEqualsExpression<C, L> expression,
            Predicate<?> ignoreStrategy) {
        super(index, expression, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> void accept(SerializableFunction<E, R> property, R value) {
        expression.ne(index, property, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> void accept(SerializableFunction<E, R> property, R value, MatchStrategy matchStrategy) {
        expression.ne(index, property, value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> void accept(SerializableFunction<E, R> property, R value, Predicate<R> ignoreStrategy) {
        expression.ne(index, property, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> void accept(SerializableFunction<E, R> property, R value, MatchStrategy matchStrategy,
            Predicate<R> ignoreStrategy) {
        expression.ne(index, property, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> void accept(SerializableSupplier<R> property) {
        expression.ne(index, property);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> void accept(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        expression.ne(index, property, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> void accept(SerializableSupplier<R> property, MatchStrategy matchStrategy) {
        expression.ne(index, property, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> void accept(SerializableSupplier<R> property, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy) {
        expression.ne(index, property, matchStrategy, ignoreStrategy);
    }

}
