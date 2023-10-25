
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EqualsEntityExpressionImpl.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: EqualsEntityExpressionImpl
 * @author: zhongj
 * @date: 2023-08-07 17:41:07
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition;

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
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionDatePropertyExpression2;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionDoublePropertyExpression2;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionEnumPropertyExpression2;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionIntPropertyExpression2;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLocalDatePropertyExpression2;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLocalDateTimePropertyExpression2;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLocalTimePropertyExpression2;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLongPropertyExpression2;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionNumberPropertyExpression2;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionStringPropertyExpression2;
import cn.featherfly.hammer.expression.entity.condition.nba.AbstractNotBetweenEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.nba.MulitiEntityNotBetweenExpression;
import cn.featherfly.hammer.expression.entity.condition.nba.NotBetweenEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.nba.NotBetweenEntityPropertyExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionDatePropertyExpression2Impl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionDoublePropertyExpression2Impl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionEnumPropertyExpression2Impl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionIntPropertyExpression2Impl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionLocalDatePropertyExpression2Impl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionLocalDateTimePropertyExpression2Impl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionLocalTimePropertyExpression2Impl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionLongPropertyExpression2Impl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionNumberPropertyExpression2Impl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionStringPropertyExpression2Impl;

/**
 * The Class NotBetweenEntityExpressionImpl.
 *
 * @author zhongj
 * @param <T> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class NotBetweenEntityExpressionImpl<T, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractNotBetweenEntityExpression<T, C, L> implements NotBetweenEntityExpression<T> {

    private JdbcMappingFactory factory;

    private EntitySqlRelation<?, ?> queryRelation;

    /**
     * Instantiates a new not between entity expression impl.
     *
     * @param index         the index
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    public NotBetweenEntityExpressionImpl(int index, MulitiEntityNotBetweenExpression<C, L> expression,
            JdbcMappingFactory factory, EntitySqlRelation<?, ?> queryRelation) {
        super(index, expression, queryRelation.getIgnorePolicy());
        this.factory = factory;
        this.queryRelation = queryRelation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> NotBetweenEntityPropertyExpression<R> property(SerializableFunction<T, R> name) {
        return new NotBetweenEntityPropertyExpressionImpl<>(index, name,
                (MulitiEntityNotBetweenExpressionImpl<C, L>) expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<E>,
            E> NotBetweenEntityPropertyExpression<E> property(SerializableToCollectionFunction<T, R, E> name) {
        // IMPLSOON 后续来实现集合类型property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionIntPropertyExpression2 property(SerializableToIntFunction<T> name) {
        return new ConditionEntityExpressionIntPropertyExpression2Impl(v -> null, ignoreStrategy,
                (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionLongPropertyExpression2 property(SerializableToLongFunction<T> name) {
        return new ConditionEntityExpressionLongPropertyExpression2Impl(v -> null, ignoreStrategy,
                (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionDoublePropertyExpression2 property(SerializableToDoubleFunction<T> name) {
        return new ConditionEntityExpressionDoublePropertyExpression2Impl(v -> null, ignoreStrategy,
                (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> ConditionEntityExpressionDatePropertyExpression2<D> property(
            SerializableToDateFunction<T, D> name) {
        return new ConditionEntityExpressionDatePropertyExpression2Impl<>(v -> null, ignoreStrategy,
                (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionLocalDatePropertyExpression2 property(SerializableToLocalDateFunction<T> name) {
        return new ConditionEntityExpressionLocalDatePropertyExpression2Impl(v -> null, ignoreStrategy,
                (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionLocalTimePropertyExpression2 property(SerializableToLocalTimeFunction<T> name) {
        return new ConditionEntityExpressionLocalTimePropertyExpression2Impl(v -> null, ignoreStrategy,
                (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionLocalDateTimePropertyExpression2 property(
            SerializableToLocalDateTimeFunction<T> name) {
        return new ConditionEntityExpressionLocalDateTimePropertyExpression2Impl(v -> null, ignoreStrategy,
                (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> ConditionEntityExpressionNumberPropertyExpression2<N> property(
            SerializableToNumberFunction<T, N> name) {
        return new ConditionEntityExpressionNumberPropertyExpression2Impl<>(v -> null, ignoreStrategy,
                (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> ConditionEntityExpressionEnumPropertyExpression2<E> property(
            SerializableToEnumFunction<T, E> name) {
        return new ConditionEntityExpressionEnumPropertyExpression2Impl<>(v -> null, ignoreStrategy,
                (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionStringPropertyExpression2 property(SerializableToStringFunction<T> name) {
        return new ConditionEntityExpressionStringPropertyExpression2Impl(v -> null, ignoreStrategy,
                (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

}
