
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
import java.util.function.Consumer;

import cn.featherfly.common.db.builder.SqlBuilder;
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
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupExpression;
import cn.featherfly.hammer.expression.entity.EntityConditionGroupLogicExpression;
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
import cn.featherfly.hammer.sqldb.dsl.entity.condition.InternalMulitiEntityPropertyOnlyConditionImpl;

/**
 * EntityPropertyFunctionImpl.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <CC> the generic type
 * @param <S> the generic type
 * @param <B> the generic type
 */
@SuppressWarnings("unchecked")
public class EntityPropertyExpressionImpl2<E, C extends ConditionExpression, L extends LogicExpression<C, L>,
    CC extends ConditionConfig<CC>, S extends EntitySqlRelation<S, B>, B extends SqlBuilder>
    implements EntityPropertyExpression<E, C, L> {

    /** The expression. */
    protected final InternalMulitiEntityPropertyOnlyConditionImpl<E, CC, S, B> expression;

    private int index;

    private JdbcMappingFactory factory;

    /**
     * Instantiates a new entity property function impl.
     *
     * @param index the index
     * @param factory the factory
     * @param relation the relation
     */
    public EntityPropertyExpressionImpl2(int index, JdbcMappingFactory factory, S relation) {
        this.index = index;
        this.factory = factory;
        expression = new InternalMulitiEntityPropertyOnlyConditionImpl<>(factory, relation);
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public EntityIntPropertyExpression<C, L> property(SerializableToIntFunction<E> name) {
        return new EntityIntPropertyExpressionImpl<>(index, name, (InternalMulitiEntityCondition<L>) expression,
            factory, expression.getEntityRelation());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLongPropertyExpression<C, L> property(SerializableToLongFunction<E> name) {
        return new EntityLongPropertyExpressionImpl<>(index, name, (InternalMulitiEntityCondition<L>) expression,
            factory, expression.getEntityRelation());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityDoublePropertyExpression<C, L> property(SerializableToDoubleFunction<E> name) {
        return new EntityDoublePropertyExpressionImpl<>(index, name, (InternalMulitiEntityCondition<L>) expression,
            factory, expression.getEntityRelation());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityStringPropertyExpression<C, L> property(SerializableToStringFunction<E> name) {
        return new EntityStringPropertyExpressionImpl<>(index, name, (InternalMulitiEntityCondition<L>) expression,
            factory, expression.getEntityRelation());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <
        R extends Number> EntityNumberPropertyExpression<R, C, L> property(SerializableToNumberFunction<E, R> name) {
        return new EntityNumberPropertyExpressionImpl<>(index, name, (InternalMulitiEntityCondition<L>) expression,
            factory, expression.getEntityRelation());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> EntityDatePropertyExpression<R, C, L> property(SerializableToDateFunction<E, R> name) {
        return new EntityDatePropertyExpressionImpl<>(index, name, (InternalMulitiEntityCondition<L>) expression,
            factory, expression.getEntityRelation());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalDatePropertyExpression<C, L> property(SerializableToLocalDateFunction<E> name) {
        return new EntityLocalDatePropertyExpressionImpl<>(index, name, (InternalMulitiEntityCondition<L>) expression,
            factory, expression.getEntityRelation());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalDateTimePropertyExpression<C, L> property(SerializableToLocalDateTimeFunction<E> name) {
        return new EntityLocalDateTimePropertyExpressionImpl<>(index, name,
            (InternalMulitiEntityCondition<L>) expression, factory, expression.getEntityRelation());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLocalTimePropertyExpression<C, L> property(SerializableToLocalTimeFunction<E> name) {
        return new EntityLocalTimePropertyExpressionImpl<>(index, name, (InternalMulitiEntityCondition<L>) expression,
            factory, expression.getEntityRelation());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Enum<R>> EntityEnumPropertyExpression<R, C, L> property(SerializableToEnumFunction<E, R> name) {
        return new EntityEnumPropertyExpressionImpl<>(index, name, (InternalMulitiEntityCondition<L>) expression,
            factory, expression.getEntityRelation());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityTypePropertyExpression<R, C, L> property(SerializableFunction<E, R> name) {
        return new EntityTypePropertyExpressionImpl<>(index, name, (InternalMulitiEntityCondition<L>) expression,
            factory, expression.getEntityRelation());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R, C2 extends EntityConditionGroupExpression<R, C2, L2>,
        L2 extends EntityConditionGroupLogicExpression<R, C2, L2>> L property(SerializableFunction<E, R> name,
            Consumer<EntityTypePropertyExpression<R, C2, L2>> entityTypePropertyExpressionConsumer) {
        // IMPLSOON 后续来实现内嵌类型property
        throw new NotImplementedException();
        //        return entityTypePropertyExpressionConsumer.apply((C2) property(name));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<T>,
        T> EntityTypePropertyExpression<T, C, L> property(SerializableToCollectionFunction<E, R, T> name) {
        //        EntityTypePropertyExpression<R, C,
        //                L> exp = new EntityTypePropertyExpressionImpl<>(index, name, (InternalMulitiEntityCondition<L>) expression, factory, expression.getEntityRelation());
        // 下面这个类型才是正确的，但是实例化会报错，所以需要特化的EntityTypePropertyExpression实现
        // YUFEI_TODO 考虑是否需要抽象出对应的EntityPropertyMulitiValueExpression
        //        EntityTypePropertyExpression<T, C,
        //                L> exp2 = new EntityTypePropertyExpressionImpl<>(index, name, (InternalMulitiEntityCondition<L>) expression, factory, expression.getEntityRelation());
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
