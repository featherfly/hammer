
package cn.featherfly.hammer.expression.condition.ba;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.function.BiPredicate;

import cn.featherfly.common.function.serializable.SerializableDateSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableNumberSupplier;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * between and expression3.
 *
 * @author zhongj
 * @param <C> the generic type ConditionExpression
 * @param <L> the generic type LogicExpression
 */
public interface BetweenSupplierExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * between and.
     *
     * @param <N> number type
     * @param property the property
     * @param min the min
     * @param max the max
     * @return LogicExpression
     */
    <N extends Number> L ba3(SerializableNumberSupplier<N> property, N min, N max);

    /**
     * between and.
     *
     * @param <N> number type
     * @param property the property
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @SuppressWarnings("unchecked")
    default <N extends Number> L ba3(SerializableNumberSupplier<N> property, N min, N max,
        IgnoreStrategy ignoreStrategy) {
        return ba3(property, min, max, (v1, v2) -> ignoreStrategy.test(Lang.array(v1, v2)));
    }

    /**
     * between and.
     *
     * @param <N> number type
     * @param property the property
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <N extends Number> L ba3(SerializableNumberSupplier<N> property, N min, N max, BiPredicate<N, N> ignoreStrategy);

    /**
     * between and.
     *
     * @param <D> date type
     * @param property the property
     * @param min the min
     * @param max the max
     * @return LogicExpression
     */
    <D extends Date> L ba3(SerializableDateSupplier<D> property, D min, D max);

    /**
     * between and.
     *
     * @param <D> date type
     * @param property the property
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    @SuppressWarnings("unchecked")
    default <D extends Date> L ba3(SerializableDateSupplier<D> property, D min, D max, IgnoreStrategy ignoreStrategy) {
        return ba3(property, min, max, (v1, v2) -> ignoreStrategy.test(Lang.array(v1, v2)));
    }

    /**
     * between and.
     *
     * @param <D> date type
     * @param property the property
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <D extends Date> L ba3(SerializableDateSupplier<D> property, D min, D max, BiPredicate<D, D> ignoreStrategy);

    /**
     * between and.
     *
     * @param property the property
     * @param min the min
     * @param max the max
     * @return LogicExpression
     */
    L ba3(SerializableLocalTimeSupplier property, LocalTime min, LocalTime max);

    /**
     * between and.
     *
     * @param property the property
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba3(SerializableLocalTimeSupplier property, LocalTime min, LocalTime max, IgnoreStrategy ignoreStrategy) {
        return ba3(property, min, max, (v1, v2) -> ignoreStrategy.test(Lang.array(v1, v2)));
    }

    /**
     * between and.
     *
     * @param property the property
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba3(SerializableLocalTimeSupplier property, LocalTime min, LocalTime max,
        BiPredicate<LocalTime, LocalTime> ignoreStrategy);

    /**
     * between and.
     *
     * @param property the property
     * @param min the min
     * @param max the max
     * @return LogicExpression
     */
    L ba3(SerializableLocalDateSupplier property, LocalDate min, LocalDate max);

    /**
     * between and.
     *
     * @param property the property
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba3(SerializableLocalDateSupplier property, LocalDate min, LocalDate max, IgnoreStrategy ignoreStrategy) {
        return ba3(property, min, max, (v1, v2) -> ignoreStrategy.test(Lang.array(v1, v2)));
    }

    /**
     * between and.
     *
     * @param property the property
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba3(SerializableLocalDateSupplier property, LocalDate min, LocalDate max,
        BiPredicate<LocalDate, LocalDate> ignoreStrategy);

    /**
     * between and.
     *
     * @param property the property
     * @param min the min
     * @param max the max
     * @return LogicExpression
     */
    L ba3(SerializableLocalDateTimeSupplier property, LocalDateTime min, LocalDateTime max);

    /**
     * between and.
     *
     * @param property the property
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba3(SerializableLocalDateTimeSupplier property, LocalDateTime min, LocalDateTime max,
        IgnoreStrategy ignoreStrategy) {
        return ba3(property, min, max, (v1, v2) -> ignoreStrategy.test(Lang.array(v1, v2)));
    }

    /**
     * between and.
     *
     * @param property the property
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba3(SerializableLocalDateTimeSupplier property, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy);

    /**
     * between and.
     *
     * @param property the property
     * @param min the min
     * @param max the max
     * @return LogicExpression
     */
    L ba3(SerializableStringSupplier property, String min, String max);

    /**
     * between and.
     *
     * @param property the property
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ba3(SerializableStringSupplier property, String min, String max, IgnoreStrategy ignoreStrategy) {
        return ba3(property, min, max, (v1, v2) -> ignoreStrategy.test(Lang.array(v1, v2)));
    }

    /**
     * between and.
     *
     * @param property the property
     * @param min the min
     * @param max the max
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ba3(SerializableStringSupplier property, String min, String max, BiPredicate<String, String> ignoreStrategy);
}