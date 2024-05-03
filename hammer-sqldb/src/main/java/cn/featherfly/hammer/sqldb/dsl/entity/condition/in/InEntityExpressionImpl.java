
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EqualsEntityExpressionImpl.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: EqualsEntityExpressionImpl
 * @author: zhongj
 * @date: 2023-08-07 17:41:07
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.entity.condition.in;

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
import cn.featherfly.hammer.expression.condition.field.value.SetDateArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetDateArrayExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetDoubleArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetDoubleArrayExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetEnumArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetEnumArrayExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetIntArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetIntArrayExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateArrayExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateTimeArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateTimeArrayExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalTimeArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalTimeArrayExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetLongArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetLongArrayExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetNumberArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetNumberArrayExpressionImpl;
import cn.featherfly.hammer.expression.condition.field.value.SetStringArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetStringArrayExpressionImpl;
import cn.featherfly.hammer.expression.condition.in.MulitiInExpression;
import cn.featherfly.hammer.expression.entity.condition.in.AbstractInEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.in.InEntityExpression;
import cn.featherfly.hammer.expression.entity.condition.in.InEntityPropertyExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlRelation;

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
    private EntitySqlRelation<?,?> queryRelation;

    /**
     * Instantiates a new in entity expression impl.
     *
     * @param index         the index
     * @param expression    the expression
     * @param factory       the factory
     * @param queryRelation the query relation
     */
    public InEntityExpressionImpl(int index, MulitiInExpression<C, L> expression, JdbcMappingFactory factory,
            EntitySqlRelation<?,?> queryRelation) {
        super(index, expression, queryRelation.getIgnoreStrategy());
        this.factory = factory;
        this.queryRelation = queryRelation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetIntArrayExpression property(SerializableToIntFunction<T> name) {
        return new SetIntArrayExpressionImpl(v -> null, ignoreStrategy,
                (value, ignore, pm) -> expression.in(index, name, value, ignore), v -> null,
                array -> ignoreStrategy.test(array), (value, ignore, pm) -> expression.in(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetLongArrayExpression property(SerializableToLongFunction<T> name) {
        return new SetLongArrayExpressionImpl(v -> null, ignoreStrategy,
                (value, ignore, pm) -> expression.in(index, name, value, ignore), v -> null,
                array -> ignoreStrategy.test(array), (value, ignore, pm) -> expression.in(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetDoubleArrayExpression property(SerializableToDoubleFunction<T> name) {
        return new SetDoubleArrayExpressionImpl(v -> null, ignoreStrategy,
                (value, ignore, pm) -> expression.in(index, name, value, ignore), v -> null,
                array -> ignoreStrategy.test(array), (value, ignore, pm) -> expression.in(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> SetNumberArrayExpression<N> property(SerializableToNumberFunction<T, N> name) {
        return new SetNumberArrayExpressionImpl<>(v -> null, ignoreStrategy,
                (value, ignore, pm) -> expression.in(index, name, value, ignore), v -> null,
                array -> ignoreStrategy.test(array), (value, ignore, pm) -> expression.in(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> SetDateArrayExpression<D> property(SerializableToDateFunction<T, D> name) {
        return new SetDateArrayExpressionImpl<>(v -> null, ignoreStrategy,
                (value, ignore, pm) -> expression.in(index, name, value, ignore), v -> null,
                array -> ignoreStrategy.test(array), (value, ignore, pm) -> expression.in(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> SetEnumArrayExpression<E> property(SerializableToEnumFunction<T, E> name) {
        return new SetEnumArrayExpressionImpl<>(v -> null, ignoreStrategy,
                (value, ignore, pm) -> expression.in(index, name, value, ignore), v -> null,
                array -> ignoreStrategy.test(array), (value, ignore, pm) -> expression.in(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetLocalDateTimeArrayExpression property(SerializableToLocalDateTimeFunction<T> name) {
        return new SetLocalDateTimeArrayExpressionImpl(v -> null, ignoreStrategy,
                (value, ignore, pm) -> expression.in(index, name, value, ignore), v -> null,
                array -> ignoreStrategy.test(array), (value, ignore, pm) -> expression.in(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetLocalDateArrayExpression property(SerializableToLocalDateFunction<T> name) {
        return new SetLocalDateArrayExpressionImpl(v -> null, ignoreStrategy,
                (value, ignore, pm) -> expression.in(index, name, value, ignore), v -> null,
                array -> ignoreStrategy.test(array), (value, ignore, pm) -> expression.in(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetLocalTimeArrayExpression property(SerializableToLocalTimeFunction<T> name) {
        return new SetLocalTimeArrayExpressionImpl(v -> null, ignoreStrategy,
                (value, ignore, pm) -> expression.in(index, name, value, ignore), v -> null,
                array -> ignoreStrategy.test(array), (value, ignore, pm) -> expression.in(index, name, value, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetStringArrayExpression property(SerializableToStringFunction<T> name) {
        return new SetStringArrayExpressionImpl(v -> null, ignoreStrategy,
                (value, match, ignore, pm) -> expression.in(index, name, value, match, ignore), v -> null,
                array -> ignoreStrategy.test(array),
                (value, match, ignore, pm) -> expression.in(index, name, value, match, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> InEntityPropertyExpression<R> property(SerializableFunction<T, R> name) {
        return new InEntityPropertyExpressionImpl<>(index, name,
                ((MulitiEntityInExpressionImpl<C, L>) expression).getHold(), factory, queryRelation);
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
