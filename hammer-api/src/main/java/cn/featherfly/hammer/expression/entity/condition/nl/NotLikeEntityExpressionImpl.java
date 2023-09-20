
/*
 * All rights Reserved, Designed By zhongj
 * @Title: LikeEntityExpressionImpl.java
 * @Package cn.featherfly.hammer.expression.entity.condition.lk
 * @Description: LikeEntityExpressionImpl
 * @author: zhongj
 * @date: 2023-08-07 17:34:07
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.nl;

import java.util.Collection;
import java.util.function.Predicate;

import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.function.serializable.SerializableToCollectionFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.AbstractConditionEntityExpression;

/**
 * The Class NotLikeEntityExpressionImpl.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class NotLikeEntityExpressionImpl<E, C extends ConditionExpression, L extends LogicExpression<C, L>> extends
        AbstractConditionEntityExpression<MulitiEntityNotLikeExpression<C, L>> implements NotLikeEntityExpression<E> {

    /**
     * Instantiates a new end with entity expression impl.
     *
     * @param index      the index
     * @param expression the expression
     */
    public NotLikeEntityExpressionImpl(int index, MulitiEntityNotLikeExpression<C, L> expression) {
        super(index, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> NotLikeEntityPropertyExpression<R> property(SerializableFunction<E, R> name) {
        // IMPLSOON 未实现property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<RE>,
            RE> NotLikeEntityPropertyExpression<RE> property(SerializableToCollectionFunction<E, R, RE> name) {
        // IMPLSOON 未实现property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> NotLikeEntityPropertyValueExpression<E> property(SerializableToStringFunction<E> name) {
        // IMPLSOON 未实现property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToStringFunction<E> property, String value) {
        expression.nl(index, property, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToStringFunction<E> property, String value, MatchStrategy matchStrategy) {
        expression.nl(index, property, value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToStringFunction<E> property, String value, Predicate<String> ignoreStrategy) {
        expression.nl(index, property, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToStringFunction<E> property, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        expression.nl(index, property, value, matchStrategy, ignoreStrategy);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableSupplier<String> propertyValue) {
        expression.nl(index, propertyValue);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableSupplier<String> propertyValue, Predicate<String> ignoreStrategy) {
        expression.nl(index, propertyValue, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableSupplier<String> propertyValue, MatchStrategy matchStrategy) {
        expression.nl(index, propertyValue, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableSupplier<String> propertyValue, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {
        expression.nl(index, propertyValue, matchStrategy, ignoreStrategy);
    }

}
