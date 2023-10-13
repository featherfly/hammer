
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

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToDateFunction;
import cn.featherfly.common.function.serializable.SerializableToDoubleFunction;
import cn.featherfly.common.function.serializable.SerializableToEnumFunction;
import cn.featherfly.common.function.serializable.SerializableToIntFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLongFunction;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityDatePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityDoublePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityEnumPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityIntPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLocalDatePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLocalDateTimePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLocalTimePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLongPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityNumberPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityPropertyFunction;
import cn.featherfly.hammer.expression.entity.condition.property.EntityTypePropertyExpression;
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

    private JdbcMappingFactory factory;

    /**
     * Instantiates a new entity property function impl.
     *
     * @param index      the index
     * @param expression the expression
     * @param factory    the factory
     */
    public EntityPropertyFunctionImpl(int index, AbstractMulitiEntityConditionExpression<C, L> expression,
            JdbcMappingFactory factory) {
        this.index = index;
        this.expression = expression;
        this.factory = factory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityIntPropertyExpression<E, C, L> apply(SerializableToIntFunction<E> name) {
        return new EntityIntPropertyExpressionImpl<>(index, name, expression, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLongPropertyExpression<E, C, L> apply(SerializableToLongFunction<E> name) {
        return new EntityLongPropertyExpressionImpl<>(index, name, expression, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityDoublePropertyExpression<E, C, L> apply(SerializableToDoubleFunction<E> name) {
        return new EntityDoublePropertyExpressionImpl<>(index, name, expression, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityStringPropertyExpression<E, C, L> apply(SerializableToStringFunction<E> name) {
        return new EntityStringPropertyExpressionImpl<>(index, name, expression, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> EntityNumberPropertyExpression<E, R, C, L> apply(
            SerializableToNumberFunction<E, R> name) {
        return new EntityNumberPropertyExpressionImpl<>(index, name, expression, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> EntityDatePropertyExpression<E, R, C, L> apply(SerializableToDateFunction<E, R> name) {
        return new EntityDatePropertyExpressionImpl<>(index, name, expression, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalDatePropertyExpression<E, C, L> apply(SerializableToLocalDateFunction<E> name) {
        return new EntityLocalDatePropertyExpressionImpl<>(index, name, expression, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalDateTimePropertyExpression<E, C, L> apply(SerializableToLocalDateTimeFunction<E> name) {
        return new EntityLocalDateTimePropertyExpressionImpl<>(index, name, expression, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalTimePropertyExpression<E, C, L> apply(SerializableToLocalTimeFunction<E> name) {
        return new EntityLocalTimePropertyExpressionImpl<>(index, name, expression, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Enum<R>> EntityEnumPropertyExpression<E, R, C, L> apply(SerializableToEnumFunction<E, R> name) {
        return new EntityEnumPropertyExpressionImpl<>(index, name, expression, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityTypePropertyExpression<R, C, L> apply(SerializableFunction<E, R> name) {
        return new EntityTypePropertyExpressionImpl<>(index, name, expression, factory);
    }

}
