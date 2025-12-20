
package cn.featherfly.hammer.expression.condition.field.value;

import java.util.Date;
import java.util.function.Predicate;

/**
 * set value in or not in expression.
 *
 * @author zhongj
 * @param <V> the value type
 */
public interface SetCompareValueExpression extends SetIntExpression, SetLongExpression, SetDoubleExpression,
    SetLocalDateExpression, SetLocalTimeExpression, SetLocalDateTimeExpression, SetStringExpression {

    /**
     * Value.
     *
     * @param value the value
     */
    <E extends Number> void value(E value);

    /**
     * Value.
     *
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    <E extends Number> void value(E value, Predicate<Enum<?>> ignoreStrategy);

    /**
     * Value.
     *
     * @param value the value
     */
    <E extends Date> void value(E value);

    /**
     * Value.
     *
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    <E extends Date> void value(E value, Predicate<Enum<?>> ignoreStrategy);

    /**
     * Value.
     *
     * @param value the value
     */
    <E extends Enum<E>> void value(E value);

    /**
     * Value.
     *
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     */
    <E extends Enum<E>> void value(E value, Predicate<Enum<?>> ignoreStrategy);
}
