
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
import java.util.function.Predicate;

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
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionDateAndArrayPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionDoubleAndArrayPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionEnumAndArrayPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionIntAndArrayPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLocalDateAndArrayPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLocalDateTimeAndArrayPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLocalTimeAndArrayPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLongAndArrayPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionNumberAndArrayPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionStringAndArrayPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.in.AbstractInEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.in.InEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.in.InEntityPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.in.MulitiEntityInExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionDateAndArrayPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionDoubleAndArrayPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionEnumAndArrayPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionIntAndArrayPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionLocalDateAndArrayPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionLocalDateTimeAndArrayPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionLocalTimeAndArrayPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionLongAndArrayPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionNumberAndArrayPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionStringAndArrayPropertyExpressionImpl;

/**
 * The Class InEntityExpressionImpl.
 *
 * @author zhongj
 * @param <T> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class InEntityExpressionImpl<T, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractInEntityExpression<T, C, L> implements InEntityExpression<T> {

    /** The factory. */
    private JdbcMappingFactory factory;

    /** The query relation. */
    private EntitySqlRelation<?, ?> queryRelation;

    /**
     * Instantiates a new in entity expression impl.
     *
     * @param index          the index
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     * @param factory        the factory
     * @param queryRelation  the query relation
     */
    public InEntityExpressionImpl(int index, MulitiEntityInExpression<C, L> expression, Predicate<?> ignoreStrategy,
            JdbcMappingFactory factory, EntitySqlRelation<?, ?> queryRelation) {
        super(index, expression, ignoreStrategy);
        this.factory = factory;
        this.queryRelation = queryRelation;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public ConditionEntityExpressionIntAndArrayPropertyExpression property(SerializableToIntFunction<T> name) {
        return new ConditionEntityExpressionIntAndArrayPropertyExpressionImpl(v -> null, ignoreStrategy,
                (value, ignore, pm) -> expression.in(index, name, value, ignore), v -> null,
                array -> ((Predicate<Object>) ignoreStrategy).test(array),
                (value, ignore, pm) -> expression.in(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public ConditionEntityExpressionLongAndArrayPropertyExpression property(SerializableToLongFunction<T> name) {
        return new ConditionEntityExpressionLongAndArrayPropertyExpressionImpl(v -> null, ignoreStrategy,
                (value, ignore, pm) -> expression.in(index, name, value, ignore), v -> null,
                array -> ((Predicate<Object>) ignoreStrategy).test(array),
                (value, ignore, pm) -> expression.in(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public ConditionEntityExpressionDoubleAndArrayPropertyExpression property(SerializableToDoubleFunction<T> name) {
        return new ConditionEntityExpressionDoubleAndArrayPropertyExpressionImpl(v -> null, ignoreStrategy,
                (value, ignore, pm) -> expression.in(index, name, value, ignore), v -> null,
                array -> ((Predicate<Object>) ignoreStrategy).test(array),
                (value, ignore, pm) -> expression.in(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <N extends Number> ConditionEntityExpressionNumberAndArrayPropertyExpression<N> property(
            SerializableToNumberFunction<T, N> name) {
        return new ConditionEntityExpressionNumberAndArrayPropertyExpressionImpl<>(v -> null, ignoreStrategy,
                (value, ignore, pm) -> expression.in(index, name, value, ignore), v -> null,
                array -> ((Predicate<Object>) ignoreStrategy).test(array),
                (value, ignore, pm) -> expression.in(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <D extends Date> ConditionEntityExpressionDateAndArrayPropertyExpression<D> property(
            SerializableToDateFunction<T, D> name) {
        return new ConditionEntityExpressionDateAndArrayPropertyExpressionImpl<>(v -> null, ignoreStrategy,
                (value, ignore, pm) -> expression.in(index, name, value, ignore), v -> null,
                array -> ((Predicate<Object>) ignoreStrategy).test(array),
                (value, ignore, pm) -> expression.in(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <E extends Enum<E>> ConditionEntityExpressionEnumAndArrayPropertyExpression<E> property(
            SerializableToEnumFunction<T, E> name) {
        return new ConditionEntityExpressionEnumAndArrayPropertyExpressionImpl<>(v -> null, ignoreStrategy,
                (value, ignore, pm) -> expression.in(index, name, value, ignore), v -> null,
                array -> ((Predicate<Object>) ignoreStrategy).test(array),
                (value, ignore, pm) -> expression.in(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public ConditionEntityExpressionLocalDateTimeAndArrayPropertyExpression property(
            SerializableToLocalDateTimeFunction<T> name) {
        return new ConditionEntityExpressionLocalDateTimeAndArrayPropertyExpressionImpl(v -> null, ignoreStrategy,
                (value, ignore, pm) -> expression.in(index, name, value, ignore), v -> null,
                array -> ((Predicate<Object>) ignoreStrategy).test(array),
                (value, ignore, pm) -> expression.in(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public ConditionEntityExpressionLocalDateAndArrayPropertyExpression property(
            SerializableToLocalDateFunction<T> name) {
        return new ConditionEntityExpressionLocalDateAndArrayPropertyExpressionImpl(v -> null, ignoreStrategy,
                (value, ignore, pm) -> expression.in(index, name, value, ignore), v -> null,
                array -> ((Predicate<Object>) ignoreStrategy).test(array),
                (value, ignore, pm) -> expression.in(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public ConditionEntityExpressionLocalTimeAndArrayPropertyExpression property(
            SerializableToLocalTimeFunction<T> name) {
        return new ConditionEntityExpressionLocalTimeAndArrayPropertyExpressionImpl(v -> null, ignoreStrategy,
                (value, ignore, pm) -> expression.in(index, name, value, ignore), v -> null,
                array -> ((Predicate<Object>) ignoreStrategy).test(array),
                (value, ignore, pm) -> expression.in(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public ConditionEntityExpressionStringAndArrayPropertyExpression property(SerializableToStringFunction<T> name) {
        return new ConditionEntityExpressionStringAndArrayPropertyExpressionImpl(v -> null, ignoreStrategy,
                (value, match, ignore, pm) -> expression.in(index, name, value, match, ignore), v -> null,
                array -> ((Predicate<Object>) ignoreStrategy).test(array),
                (value, match, ignore, pm) -> expression.in(index, name, value, match, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> InEntityPropertyExpression<R> property(SerializableFunction<T, R> name) {
        return new InEntityPropertyExpressionImpl<>(index, name, (MulitiEntityInExpressionImpl<C, L>) expression,
                factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<E>,
            E> InEntityPropertyExpression<E> property(SerializableToCollectionFunction<T, R, E> name) {
        // IMPLSOON 后续来实现集合类型property
        throw new NotImplementedException();
    }
}
