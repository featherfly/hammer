
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EqualsEntityExpressionImpl.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: EqualsEntityExpressionImpl
 * @author: zhongj
 * @date: 2023-08-07 17:41:07
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.ba;

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
import cn.featherfly.hammer.expression.condition.ba.MulitiBetweenExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetDateExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetDateExpression2Impl;
import cn.featherfly.hammer.expression.condition.field.value.SetDoubleExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetDoubleExpression2Impl;
import cn.featherfly.hammer.expression.condition.field.value.SetEnumExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetEnumExpression2Impl;
import cn.featherfly.hammer.expression.condition.field.value.SetIntExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetIntExpression2Impl;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateExpression2Impl;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateTimeExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateTimeExpression2Impl;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalTimeExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalTimeExpression2Impl;
import cn.featherfly.hammer.expression.condition.field.value.SetLongExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetLongExpression2Impl;
import cn.featherfly.hammer.expression.condition.field.value.SetNumberExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetNumberExpression2Impl;
import cn.featherfly.hammer.expression.condition.field.value.SetStringExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetStringExpression2Impl;
import cn.featherfly.hammer.expression.entity.condition.ba.AbstractBetweenEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ba.BetweenEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.ba.BetweenEntityPropertyExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation;

/**
 * The Class BetweenEntityExpressionImpl.
 *
 * @author zhongj
 * @param <T> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class BetweenEntityExpressionImpl<T, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractBetweenEntityExpression<T, C, L> implements BetweenEntityExpression<T> {

    private JdbcMappingFactory factory;

    private EntitySqlRelation<?, ?> queryRelation;

    /**
     * Instantiates a new great equals entity expression impl.
     *
     * @param index         the index
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    public BetweenEntityExpressionImpl(int index, MulitiBetweenExpression<C, L> expression, JdbcMappingFactory factory,
        EntitySqlRelation<?, ?> queryRelation) {
        super(index, expression, queryRelation.getIgnoreStrategy());
        this.factory = factory;
        this.queryRelation = queryRelation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> BetweenEntityPropertyExpression<R> property(SerializableFunction<T, R> name) {
        return new BetweenEntityPropertyExpressionImpl<>(index, name,
            ((MulitiEntityBetweenExpressionImpl<C, L>) expression).getHold(), factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<E>,
        E> BetweenEntityPropertyExpression<E> property(SerializableToCollectionFunction<T, R, E> name) {
        // IMPLSOON 后续来实现集合类型property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetIntExpression2 property(SerializableToIntFunction<T> name) {
        return new SetIntExpression2Impl(v -> null, ignoreStrategy,
            (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetLongExpression2 property(SerializableToLongFunction<T> name) {
        return new SetLongExpression2Impl(v -> null, ignoreStrategy,
            (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetDoubleExpression2 property(SerializableToDoubleFunction<T> name) {
        return new SetDoubleExpression2Impl(v -> null, ignoreStrategy,
            (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> SetDateExpression2<D> property(SerializableToDateFunction<T, D> name) {
        return new SetDateExpression2Impl<>(v -> null, ignoreStrategy,
            (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetLocalDateExpression2 property(SerializableToLocalDateFunction<T> name) {
        return new SetLocalDateExpression2Impl(v -> null, ignoreStrategy,
            (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetLocalTimeExpression2 property(SerializableToLocalTimeFunction<T> name) {
        return new SetLocalTimeExpression2Impl(v -> null, ignoreStrategy,
            (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetLocalDateTimeExpression2 property(SerializableToLocalDateTimeFunction<T> name) {
        return new SetLocalDateTimeExpression2Impl(v -> null, ignoreStrategy,
            (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> SetNumberExpression2<N> property(SerializableToNumberFunction<T, N> name) {
        return new SetNumberExpression2Impl<>(v -> null, ignoreStrategy,
            (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Enum<R>> SetEnumExpression2<R> property(SerializableToEnumFunction<T, R> name) {
        return new SetEnumExpression2Impl<>(v -> null, ignoreStrategy,
            (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetStringExpression2 property(SerializableToStringFunction<T> name) {
        return new SetStringExpression2Impl(v -> null, ignoreStrategy,
            (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }
}
