
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EqualsRepositoryExpressionImpl.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: EqualsRepositoryExpressionImpl
 * @author: zhongj
 * @date: 2023-08-07 17:41:07
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.condition.ba;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

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
import cn.featherfly.hammer.expression.repository.condition.AbstractRepositoryIndexableConditionExpression;

/**
 * The Class AbstractBetweenRepositoryExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractBetweenRepositoryExpression<C extends ConditionExpression,
    L extends LogicExpression<C, L>>
    extends AbstractRepositoryIndexableConditionExpression<MulitiBetweenExpression<C, L>>
    implements BetweenRepositoryExpression {

    /**
     * Instantiates a new great equals entity expression impl.
     *
     * @param index          the index
     * @param expression     the expression
     * @param ignoreStrategy the ignore strategy
     */
    protected AbstractBetweenRepositoryExpression(int index, MulitiBetweenExpression<C, L> expression,
        Predicate<Object> ignoreStrategy) {
        super(index, expression, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, int min, int max) {
        expression.ba(index, name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, int min, int max, BiPredicate<Integer, Integer> ignoreStrategy) {
        expression.ba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, long min, long max) {
        expression.ba(index, name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, long min, long max, BiPredicate<Long, Long> ignoreStrategy) {
        expression.ba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, double min, double max) {
        expression.ba(index, name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, double min, double max, BiPredicate<Double, Double> ignoreStrategy) {
        expression.ba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> void accept(String name, N min, N max) {
        expression.ba(index, name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> void accept(String name, N min, N max, BiPredicate<N, N> ignoreStrategy) {
        expression.ba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> void accept(String name, D min, D max) {
        expression.ba(index, name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> void accept(String name, D min, D max, BiPredicate<D, D> ignoreStrategy) {
        expression.ba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> void accept(String name, E min, E max) {
        expression.ba(index, name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> void accept(String name, E min, E max, BiPredicate<E, E> ignoreStrategy) {
        expression.ba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, LocalTime min, LocalTime max) {
        expression.ba(index, name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, LocalTime min, LocalTime max, BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
        expression.ba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, LocalDate min, LocalDate max) {
        expression.ba(index, name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, LocalDate min, LocalDate max, BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
        expression.ba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, LocalDateTime min, LocalDateTime max) {
        expression.ba(index, name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        expression.ba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, String min, String max) {
        expression.ba(index, name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(String name, String min, String max, BiPredicate<String, String> ignoreStrategy) {
        expression.ba(index, name, min, max, ignoreStrategy);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public SetIntExpression2 fieldAsInt(String name) {
        return new SetIntExpression2Impl(v -> null, ignoreStrategy,
            (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetLongExpression2 fieldAsLong(String name) {
        return new SetLongExpression2Impl(v -> null, ignoreStrategy,
            (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetDoubleExpression2 fieldAsDouble(String name) {
        return new SetDoubleExpression2Impl(v -> null, ignoreStrategy,
            (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> SetDateExpression2<D> fieldAsDate(String name) {
        return new SetDateExpression2Impl<>(v -> null, ignoreStrategy,
            (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetLocalDateExpression2 fieldAsLocalDate(String name) {
        return new SetLocalDateExpression2Impl(v -> null, ignoreStrategy,
            (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetLocalTimeExpression2 fieldAsLocalTime(String name) {
        return new SetLocalTimeExpression2Impl(v -> null, ignoreStrategy,
            (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetLocalDateTimeExpression2 fieldAsLocalDateTime(String name) {
        return new SetLocalDateTimeExpression2Impl(v -> null, ignoreStrategy,
            (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> SetNumberExpression2<N> fieldAsNumber(String name) {
        return new SetNumberExpression2Impl<>(v -> null, ignoreStrategy,
            (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Enum<R>> SetEnumExpression2<R> fieldAsEnum(String name) {
        return new SetEnumExpression2Impl<>(v -> null, ignoreStrategy,
            (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetStringExpression2 fieldAsString(String name) {
        return new SetStringExpression2Impl(v -> null, ignoreStrategy,
            (min, max, ignore, pm) -> accept(name, min, max, ignore));
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <V> SetValueExpression2<V> field(String name) {
    //        return new SetValueExpression2Impl<>(v -> null, ignoreStrategy,
    //            (min, max, ignore, pm) -> accept(name, min, max, ignore));
    //    }
}
