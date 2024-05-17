
/*
 * All rights Reserved, Designed By zhongj
 * @Title: StartWithEntityExpressionImpl.java
 * @Package cn.featherfly.hammer.expression.entity.swndition.sw
 * @Description: StartWithEntityExpressionImpl
 * @author: zhongj
 * @date: 2023-07-28 16:46:28
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.sw;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.sw.MulitiStartWithExpression;
import cn.featherfly.hammer.expression.entity.condition.AbstractEntityIndexableConditionExpression;

/**
 * The Class AbstractStartWithEntityExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractStartWithEntityExpression<E, C extends ConditionExpression,
    L extends LogicExpression<C, L>> extends AbstractEntityIndexableConditionExpression<MulitiStartWithExpression<C, L>>
    implements StartWithEntityExpression<E> {

    /**
     * Instantiates a new abstract start with entity expression.
     *
     * @param index the index
     * @param expression the expression
     * @param ignoreStrategy the ignore strategy
     */
    protected AbstractStartWithEntityExpression(int index, MulitiStartWithExpression<C, L> expression,
        Predicate<Object> ignoreStrategy) {
        super(index, expression, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToStringFunction<E> property, String value) {
        expression.sw(index, property, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToStringFunction<E> property, String value, MatchStrategy matchStrategy) {
        expression.sw(index, property, value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToStringFunction<E> property, String value, Predicate<String> ignoreStrategy) {
        expression.sw(index, property, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToStringFunction<E> property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        expression.sw(index, property, value, matchStrategy, ignoreStrategy);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableStringSupplier propertyValue) {
        expression.sw(index, propertyValue);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableStringSupplier propertyValue, Predicate<String> ignoreStrategy) {
        expression.sw(index, propertyValue, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy) {
        expression.sw(index, propertyValue, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        expression.sw(index, propertyValue, matchStrategy, ignoreStrategy);
    }

}
