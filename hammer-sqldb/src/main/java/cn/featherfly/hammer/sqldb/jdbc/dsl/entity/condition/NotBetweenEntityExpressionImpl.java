
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
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class NotBetweenEntityExpressionImpl<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractNotBetweenEntityExpression<E, C, L> implements NotBetweenEntityExpression<E> {

    private JdbcMappingFactory factory;

    /**
     * Instantiates a new not between entity expression impl.
     *
     * @param index          the index
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     * @param factory        the factory
     */
    public NotBetweenEntityExpressionImpl(int index, MulitiEntityNotBetweenExpression<C, L> expression,
            Predicate<?> ignoreStrategy, JdbcMappingFactory factory) {
        super(index, expression, ignoreStrategy);
        this.factory = factory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> NotBetweenEntityPropertyExpression<R> property(SerializableFunction<E, R> name) {
        return new NotBetweenEntityPropertyExpressionImpl<>(index, name,
                (MulitiEntityNotBetweenExpressionImpl<C, L>) expression, factory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<RE>,
            RE> NotBetweenEntityPropertyExpression<RE> property(SerializableToCollectionFunction<E, R, RE> name) {
        // IMPLSOON 未实现Collection property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> ConditionEntityExpressionIntPropertyExpression2 property(SerializableToIntFunction<E> name) {
        return new ConditionEntityExpressionIntPropertyExpression2Impl(v -> null, ignoreStrategy,
                (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> ConditionEntityExpressionLongPropertyExpression2 property(SerializableToLongFunction<E> name) {
        return new ConditionEntityExpressionLongPropertyExpression2Impl(v -> null, ignoreStrategy,
                (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> ConditionEntityExpressionDoublePropertyExpression2 property(SerializableToDoubleFunction<E> name) {
        return new ConditionEntityExpressionDoublePropertyExpression2Impl(v -> null, ignoreStrategy,
                (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> ConditionEntityExpressionDatePropertyExpression2<R> property(
            SerializableToDateFunction<E, R> name) {
        return new ConditionEntityExpressionDatePropertyExpression2Impl<>(v -> null, ignoreStrategy,
                (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionLocalDatePropertyExpression2 property(SerializableToLocalDateFunction<E> name) {
        return new ConditionEntityExpressionLocalDatePropertyExpression2Impl(v -> null, ignoreStrategy,
                (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionLocalTimePropertyExpression2 property(SerializableToLocalTimeFunction<E> name) {
        return new ConditionEntityExpressionLocalTimePropertyExpression2Impl(v -> null, ignoreStrategy,
                (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionLocalDateTimePropertyExpression2 property(
            SerializableToLocalDateTimeFunction<E> name) {
        return new ConditionEntityExpressionLocalDateTimePropertyExpression2Impl(v -> null, ignoreStrategy,
                (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> ConditionEntityExpressionNumberPropertyExpression2<R> property(
            SerializableToNumberFunction<E, R> name) {
        return new ConditionEntityExpressionNumberPropertyExpression2Impl<>(v -> null, ignoreStrategy,
                (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Enum<R>> ConditionEntityExpressionEnumPropertyExpression2<R> property(
            SerializableToEnumFunction<E, R> name) {
        return new ConditionEntityExpressionEnumPropertyExpression2Impl<>(v -> null, ignoreStrategy,
                (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionStringPropertyExpression2 property(SerializableToStringFunction<E> name) {
        return new ConditionEntityExpressionStringPropertyExpression2Impl(v -> null, ignoreStrategy,
                (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

}
