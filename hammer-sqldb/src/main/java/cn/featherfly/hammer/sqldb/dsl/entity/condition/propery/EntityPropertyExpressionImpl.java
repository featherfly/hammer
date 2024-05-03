
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityPropertyFunctionImpl.java
 * @Description: EntityPropertyFunctionImpl
 * @author: zhongj
 * @date: 2023-08-21 18:00:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.entity.condition.propery;

import java.util.Collection;
import java.util.Date;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToCollectionFunction;
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
import cn.featherfly.hammer.expression.entity.condition.EntityPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityDatePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityDoublePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityEnumPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityIntPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLocalDatePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLocalDateTimePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLocalTimePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLongPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityNumberPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityStringPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityTypePropertyExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlRelation;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.InternalMulitiEntityCondition;

/**
 * EntityPropertyFunctionImpl.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class EntityPropertyExpressionImpl<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        implements EntityPropertyExpression<E, C, L> {

    /** The expression. */
    //    protected EntityConditionsExpression<E, ?, L> expression;

    private int index;

    private InternalMulitiEntityCondition<L> expression;

    private JdbcMappingFactory factory;

    private EntitySqlRelation<?, ?> queryRelation;

    /**
     * Instantiates a new entity property function impl.
     *
     * @param index         the index
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    public EntityPropertyExpressionImpl(int index, InternalMulitiEntityCondition<L> expression,
            JdbcMappingFactory factory, EntitySqlRelation<?, ?> queryRelation) {
        this.index = index;
        this.expression = expression;
        this.factory = factory;
        this.queryRelation = queryRelation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityIntPropertyExpression<E, C, L> property(SerializableToIntFunction<E> name) {
        return new EntityIntPropertyExpressionImpl<>(index, name, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLongPropertyExpression<E, C, L> property(SerializableToLongFunction<E> name) {
        return new EntityLongPropertyExpressionImpl<>(index, name, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityDoublePropertyExpression<E, C, L> property(SerializableToDoubleFunction<E> name) {
        return new EntityDoublePropertyExpressionImpl<>(index, name, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityStringPropertyExpression<E, C, L> property(SerializableToStringFunction<E> name) {
        return new EntityStringPropertyExpressionImpl<>(index, name, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> EntityNumberPropertyExpression<E, R, C, L> property(
            SerializableToNumberFunction<E, R> name) {
        return new EntityNumberPropertyExpressionImpl<>(index, name, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> EntityDatePropertyExpression<E, R, C, L> property(SerializableToDateFunction<E, R> name) {
        return new EntityDatePropertyExpressionImpl<>(index, name, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalDatePropertyExpression<E, C, L> property(SerializableToLocalDateFunction<E> name) {
        return new EntityLocalDatePropertyExpressionImpl<>(index, name, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalDateTimePropertyExpression<E, C, L> property(SerializableToLocalDateTimeFunction<E> name) {
        return new EntityLocalDateTimePropertyExpressionImpl<>(index, name, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalTimePropertyExpression<E, C, L> property(SerializableToLocalTimeFunction<E> name) {
        return new EntityLocalTimePropertyExpressionImpl<>(index, name, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Enum<R>> EntityEnumPropertyExpression<E, R, C, L> property(
            SerializableToEnumFunction<E, R> name) {
        return new EntityEnumPropertyExpressionImpl<>(index, name, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityTypePropertyExpression<R, C, L> property(SerializableFunction<E, R> name) {
        return new EntityTypePropertyExpressionImpl<>(index, name, expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<T>,
            T> EntityTypePropertyExpression<T, C, L> property(SerializableToCollectionFunction<E, R, T> name) {
        //        EntityTypePropertyExpression<R, C,
        //                L> exp = new EntityTypePropertyExpressionImpl<>(index, name, expression, factory, queryRelation);
        // 下面这个类型才是正确的，但是实例化会报错，所以需要特化的EntityTypePropertyExpression实现
        // YUFEI_TODO 考虑是否需要抽象出对应的EntityPropertyMulitiValueExpression
        //        EntityTypePropertyExpression<T, C,
        //                L> exp2 = new EntityTypePropertyExpressionImpl<>(index, name, expression, factory, queryRelation);
        // IMPLSOON 后续来实现集合类型property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        return expression.expression();
    }
}
