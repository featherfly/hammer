
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
import cn.featherfly.hammer.expression.entity.condition.CompareEntityPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionDatePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionDoublePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionEnumPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionIntPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLocalDatePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLocalDateTimePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLocalTimePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionLongPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionNumberPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.ConditionEntityExpressionStringPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.lt.AbstractLessThanEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.lt.LessThanEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.lt.MulitiEntityLessThanExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionDatePropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionDoublePropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionEnumPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionIntPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionLocalDatePropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionLocalDateTimePropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionLocalTimePropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionLongPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionNumberPropertyExpressionImpl;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.condition.propery.ConditionEntityExpressionStringPropertyExpressionImpl;

/**
 * The Class LessThanEntityExpressionImpl.
 *
 * @author zhongj
 * @param <T> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class LessThanEntityExpressionImpl<T, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractLessThanEntityExpression<T, C, L> implements LessThanEntityExpression<T> {

    private JdbcMappingFactory factory;

    private EntitySqlRelation<?, ?> queryRelation;

    /**
     * Instantiates a new less than entity expression impl.
     *
     * @param index          the index
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     * @param factory        the factory
     * @param queryRelation  the query relation
     */
    public LessThanEntityExpressionImpl(int index, MulitiEntityLessThanExpression<C, L> expression,
            Predicate<?> ignoreStrategy, JdbcMappingFactory factory, EntitySqlRelation<?, ?> queryRelation) {
        super(index, expression, ignoreStrategy);
        this.factory = factory;
        this.queryRelation = queryRelation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> CompareEntityPropertyExpression<R> property(SerializableFunction<T, R> name) {
        return new LessThanEntityPropertyExpressionImpl<>(index, name,
                (MulitiEntityLessThanExpressionImpl<C, L>) expression, factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Collection<RE>,
            RE> CompareEntityPropertyExpression<RE> property(SerializableToCollectionFunction<T, R, RE> name) {
        // IMPLSOON 后续来实现集合类型property
        throw new NotImplementedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionIntPropertyExpression property(SerializableToIntFunction<T> name) {
        return new ConditionEntityExpressionIntPropertyExpressionImpl(v -> null, ignoreStrategy,
                (value, ignore, pm) -> expression.lt(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionLongPropertyExpression property(SerializableToLongFunction<T> name) {
        return new ConditionEntityExpressionLongPropertyExpressionImpl(v -> null, ignoreStrategy,
                (value, ignore, pm) -> expression.lt(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionDoublePropertyExpression property(SerializableToDoubleFunction<T> name) {
        return new ConditionEntityExpressionDoublePropertyExpressionImpl(v -> null, ignoreStrategy,
                (value, ignore, pm) -> expression.lt(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> ConditionEntityExpressionDatePropertyExpression<R> property(
            SerializableToDateFunction<T, R> name) {
        return new ConditionEntityExpressionDatePropertyExpressionImpl<>(v -> null, ignoreStrategy,
                (value, ignore, pm) -> expression.lt(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionLocalDatePropertyExpression property(SerializableToLocalDateFunction<T> name) {
        return new ConditionEntityExpressionLocalDatePropertyExpressionImpl(v -> null, ignoreStrategy,
                (value, ignore, pm) -> expression.lt(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionLocalTimePropertyExpression property(SerializableToLocalTimeFunction<T> name) {
        return new ConditionEntityExpressionLocalTimePropertyExpressionImpl(v -> null, ignoreStrategy,
                (value, ignore, pm) -> expression.lt(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionLocalDateTimePropertyExpression property(
            SerializableToLocalDateTimeFunction<T> name) {
        return new ConditionEntityExpressionLocalDateTimePropertyExpressionImpl(v -> null, ignoreStrategy,
                (value, ignore, pm) -> expression.lt(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> ConditionEntityExpressionNumberPropertyExpression<R> property(
            SerializableToNumberFunction<T, R> name) {
        return new ConditionEntityExpressionNumberPropertyExpressionImpl<>(v -> null, ignoreStrategy,
                (value, ignore, pm) -> expression.lt(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> ConditionEntityExpressionEnumPropertyExpression<E> property(
            SerializableToEnumFunction<T, E> name) {
        return new ConditionEntityExpressionEnumPropertyExpressionImpl<>(v -> null, ignoreStrategy,
                (value, ignore, pm) -> expression.lt(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConditionEntityExpressionStringPropertyExpression property(SerializableToStringFunction<T> name) {
        return new ConditionEntityExpressionStringPropertyExpressionImpl(v -> null, ignoreStrategy,
                (value, match, ignore, pm) -> expression.lt(index, name, value, match, ignore));
    }

}
