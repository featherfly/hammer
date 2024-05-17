
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EndWithEntityExpressionImpl.java
 * @Package cn.featherfly.hammer.expression.entity.ewndition.ew
 * @Description: EndWithEntityExpressionImpl
 * @author: zhongj
 * @date: 2023-07-28 16:46:28
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.newv;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.newv.MulitiNotEndWithExpression;
import cn.featherfly.hammer.expression.entity.condition.AbstractEntityIndexableConditionExpression;

/**
 * The Class AbstractNotEndWithEntityExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractNotEndWithEntityExpression<E, C extends ConditionExpression,
    L extends LogicExpression<C, L>>
    extends AbstractEntityIndexableConditionExpression<MulitiNotEndWithExpression<C, L>>
    implements NotEndWithEntityExpression<E> {

    /**
     * Instantiates a new abstract not end with entity expression.
     *
     * @param index the index
     * @param expression the expression
     * @param ignoreStrategy the ignore strategy
     */
    protected AbstractNotEndWithEntityExpression(int index, MulitiNotEndWithExpression<C, L> expression,
        Predicate<Object> ignoreStrategy) {
        super(index, expression, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToStringFunction<E> property, String value) {
        expression.newv(index, property, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToStringFunction<E> property, String value, MatchStrategy matchStrategy) {
        expression.newv(index, property, value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToStringFunction<E> property, String value, Predicate<String> ignoreStrategy) {
        expression.newv(index, property, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToStringFunction<E> property, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        expression.newv(index, property, value, matchStrategy, ignoreStrategy);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableStringSupplier propertyValue) {
        expression.newv(index, propertyValue);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableStringSupplier propertyValue, Predicate<String> ignoreStrategy) {
        expression.newv(index, propertyValue, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy) {
        expression.newv(index, propertyValue, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {
        expression.newv(index, propertyValue, matchStrategy, ignoreStrategy);
    }

}
