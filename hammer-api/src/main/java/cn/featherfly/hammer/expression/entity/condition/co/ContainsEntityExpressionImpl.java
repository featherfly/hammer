
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ContainsEntityExpressionImpl.java
 * @Package cn.featherfly.hammer.expression.entity.condition.co
 * @Description: ContainsEntityExpressionImpl
 * @author: zhongj
 * @date: 2023-07-28 16:46:28
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.co;

import java.util.Collection;
import java.util.function.Predicate;

import cn.featherfly.common.lang.function.ReturnStringFunction;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.lang.function.SerializableToCollectionFunction;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.AbstractConditionEntityExpression;

/**
 * ContainsEntityExpressionImpl.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class ContainsEntityExpressionImpl<E, C extends ConditionExpression, L extends LogicExpression<C, L>> extends
        AbstractConditionEntityExpression<MulitiEntityContainsExpression<C, L>> implements ContainsEntityExpression<E> {

    /**
     * Instantiates a new contains entity expression impl.
     *
     * @param index      the index
     * @param expression the expression
     */
    public ContainsEntityExpressionImpl(int index, MulitiEntityContainsExpression<C, L> expression) {
        super(index, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> ContainsEntityPropertyExpression<R> property(SerializableFunction<E, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<RE>,
            RE> ContainsEntityPropertyExpression<RE> property(SerializableToCollectionFunction<E, R, RE> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> ContainsEntityPropertyValueExpression<E> property(ReturnStringFunction<E> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(ReturnStringFunction<E> property, String value) {
        expression.co(index, property, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(ReturnStringFunction<E> property, String value, QueryPolicy queryPolicy) {
        expression.co(index, property, value, queryPolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(ReturnStringFunction<E> property, String value, Predicate<String> ignoreStrategy) {
        expression.co(index, property, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(ReturnStringFunction<E> property, String value, QueryPolicy queryPolicy,
            Predicate<String> ignoreStrategy) {
        expression.co(index, property, value, queryPolicy, ignoreStrategy);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableSupplier<String> propertyValue) {
        expression.co(index, propertyValue);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableSupplier<String> propertyValue, Predicate<String> ignoreStrategy) {
        expression.co(index, propertyValue, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableSupplier<String> propertyValue, QueryPolicy queryPolicy) {
        expression.co(index, propertyValue, queryPolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(SerializableSupplier<String> propertyValue, QueryPolicy queryPolicy,
            Predicate<String> ignoreStrategy) {
        expression.co(index, propertyValue, queryPolicy, ignoreStrategy);
    }

}
