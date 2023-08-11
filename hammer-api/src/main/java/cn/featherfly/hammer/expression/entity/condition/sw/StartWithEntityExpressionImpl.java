
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

import java.util.Collection;
import java.util.function.Predicate;

import cn.featherfly.common.lang.function.SerializableToStringFunction;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.lang.function.SerializableToCollectionFunction;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.AbstractConditionEntityExpression;

/**
 * StartWithEntityExpressionImpl.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class StartWithEntityExpressionImpl<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractConditionEntityExpression<MulitiEntityStartWithExpression<C, L>>
        implements StartWithEntityExpression<E> {

    /**
     * Instantiates a new start with entity expression impl.
     *
     * @param index      the index
     * @param expression the expression
     */
    public StartWithEntityExpressionImpl(int index, MulitiEntityStartWithExpression<C, L> expression) {
        super(index, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> StartWithEntityPropertyExpression<R> property(SerializableFunction<E, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<RE>,
            RE> StartWithEntityPropertyExpression<RE> property(SerializableToCollectionFunction<E, R, RE> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> StartWithEntityPropertyValueExpression<E> property(SerializableToStringFunction<E> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
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
    public void accept(SerializableToStringFunction<E> property, String value, QueryPolicy queryPolicy) {
        expression.sw(index, property, value, queryPolicy);
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
    public void accept(SerializableToStringFunction<E> property, String value, QueryPolicy queryPolicy,
            Predicate<String> ignoreStrategy) {
        expression.sw(index, property, value, queryPolicy, ignoreStrategy);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableSupplier<String> propertyValue) {
        expression.sw(index, propertyValue);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableSupplier<String> propertyValue, Predicate<String> ignoreStrategy) {
        expression.sw(index, propertyValue, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableSupplier<String> propertyValue, QueryPolicy queryPolicy) {
        expression.sw(index, propertyValue, queryPolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableSupplier<String> propertyValue, QueryPolicy queryPolicy,
            Predicate<String> ignoreStrategy) {
        expression.sw(index, propertyValue, queryPolicy, ignoreStrategy);
    }

}
