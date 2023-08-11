
/*
 * All rights Reserved, Designed By zhongj
 * @Title: LikeEntityExpressionImpl.java
 * @Package cn.featherfly.hammer.expression.entity.condition.lk
 * @Description: LikeEntityExpressionImpl
 * @author: zhongj
 * @date: 2023-08-07 17:34:07
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.lk;

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
 * The Class LikeEntityExpressionImpl.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class LikeEntityExpressionImpl<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractConditionEntityExpression<MulitiEntityLikeExpression<C, L>> implements LikeEntityExpression<E> {

    /**
     * Instantiates a new end with entity expression impl.
     *
     * @param index      the index
     * @param expression the expression
     */
    public LikeEntityExpressionImpl(int index, MulitiEntityLikeExpression<C, L> expression) {
        super(index, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> LikeEntityPropertyExpression<R> property(SerializableFunction<E, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<RE>,
            RE> LikeEntityPropertyExpression<RE> property(SerializableToCollectionFunction<E, R, RE> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> LikeEntityPropertyValueExpression<E> property(SerializableToStringFunction<E> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToStringFunction<E> property, String value) {
        expression.lk(index, property, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToStringFunction<E> property, String value, QueryPolicy queryPolicy) {
        expression.lk(index, property, value, queryPolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToStringFunction<E> property, String value, Predicate<String> ignoreStrategy) {
        expression.lk(index, property, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableToStringFunction<E> property, String value, QueryPolicy queryPolicy,
            Predicate<String> ignoreStrategy) {
        expression.lk(index, property, value, queryPolicy, ignoreStrategy);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableSupplier<String> propertyValue) {
        expression.lk(index, propertyValue);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableSupplier<String> propertyValue, Predicate<String> ignoreStrategy) {
        expression.lk(index, propertyValue, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableSupplier<String> propertyValue, QueryPolicy queryPolicy) {
        expression.lk(index, propertyValue, queryPolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableSupplier<String> propertyValue, QueryPolicy queryPolicy,
            Predicate<String> ignoreStrategy) {
        expression.lk(index, propertyValue, queryPolicy, ignoreStrategy);
    }

}
