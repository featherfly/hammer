
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityPropertyFunctionImpl.java
 * @Description: EntityPropertyFunctionImpl
 * @author: zhongj
 * @date: 2023-08-21 18:00:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

import java.util.Date;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableToDateFunction;
import cn.featherfly.common.lang.function.SerializableToDoubleFunction;
import cn.featherfly.common.lang.function.SerializableToEnumFunction;
import cn.featherfly.common.lang.function.SerializableToIntFunction;
import cn.featherfly.common.lang.function.SerializableToLocalDateFunction;
import cn.featherfly.common.lang.function.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.lang.function.SerializableToLocalTimeFunction;
import cn.featherfly.common.lang.function.SerializableToLongFunction;
import cn.featherfly.common.lang.function.SerializableToNumberFunction;
import cn.featherfly.common.lang.function.SerializableToStringFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityDatePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityEnumPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLocalDatePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLocalDateTimePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLocalTimePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityNumberPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyFunction;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyTypeExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityStringPropertyExpression;

/**
 * EntityPropertyFunctionImpl.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class EntityPropertyFunctionImpl<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        implements EntityPropertyFunction<E, C, L> {

    /** The expression. */
    //    protected EntityConditionsExpression<E, ?, L> expression;

    private int index;

    private AbstractMulitiEntityConditionExpression<C, L> expression;

    /**
     * Instantiates a new entity property function impl.
     *
     * @param index      the index
     * @param expression the expression
     */
    public EntityPropertyFunctionImpl(int index, AbstractMulitiEntityConditionExpression<C, L> expression) {
        this.index = index;
        this.expression = expression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityNumberPropertyExpression<E, Integer, C, L> apply(SerializableToIntFunction<E> name) {
        // IMPLSOON property primitive int 未实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityNumberPropertyExpression<E, Long, C, L> apply(SerializableToLongFunction<E> name) {
        // IMPLSOON property primitive long 未实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityNumberPropertyExpression<E, Double, C, L> apply(SerializableToDoubleFunction<E> name) {
        // IMPLSOON property primitive double 未实现
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityStringPropertyExpression<E, C, L> apply(SerializableToStringFunction<E> name) {
        return new EntityStringPropertyExpressionImpl<>(index, name, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> EntityNumberPropertyExpression<E, R, C, L> apply(
            SerializableToNumberFunction<E, R> name) {
        return new EntityNumberPropertyExpressionImpl<>(index, name, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> EntityDatePropertyExpression<E, R, C, L> apply(SerializableToDateFunction<E, R> name) {
        return new EntityDatePropertyExpressionImpl<>(index, name, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalDatePropertyExpression<E, C, L> apply(SerializableToLocalDateFunction<E> name) {
        return new EntityLocalDatePropertyExpressionImpl<>(index, name, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalDateTimePropertyExpression<E, C, L> apply(SerializableToLocalDateTimeFunction<E> name) {
        return new EntityLocalDateTimePropertyExpressionImpl<>(index, name, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalTimePropertyExpression<E, C, L> apply(SerializableToLocalTimeFunction<E> name) {
        return new EntityLocalTimePropertyExpressionImpl<>(index, name, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Enum<R>> EntityEnumPropertyExpression<E, R, C, L> apply(SerializableToEnumFunction<E, R> name) {
        return new EntityEnumPropertyExpressionImpl<>(index, name, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityPropertyTypeExpression<R, C, L> apply(SerializableFunction<E, R> name) {
        return new EntityPropertyTypeExpressionImpl<>(index, name, expression);
    }

}
