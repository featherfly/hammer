
package cn.featherfly.hammer.expression.entity.condition;

import java.util.Date;

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
import cn.featherfly.hammer.expression.condition.field.value.SetDateExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetDoubleExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetEnumExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetIntExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateTimeExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalTimeExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetLongExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetNumberExpression2;
import cn.featherfly.hammer.expression.condition.field.value.SetStringExpression2;

/**
 * The Interface BetweenAndEntityValuePropertyExpression.
 *
 * @author zhongj
 * @param <T> the element type
 */
public interface BetweenAndEntityValuePropertyExpression<T> {

    /**
     * entity between and function property expression.
     *
     * @param name the name
     * @return set between and values expression.
     */
    SetIntExpression2 property(SerializableToIntFunction<T> name);

    /**
     * entity between and function property expression.
     *
     * @param name the name
     * @return set between and values expression.
     */
    SetLongExpression2 property(SerializableToLongFunction<T> name);

    /**
     * entity between and function property expression.
     *
     * @param name the name
     * @return set between and values expression.
     */
    SetDoubleExpression2 property(SerializableToDoubleFunction<T> name);

    /**
     * entity between and function property expression.
     *
     * @param <D>  the generic type
     * @param name the name
     * @return set between and values expression.
     */
    <D extends Date> SetDateExpression2<D> property(SerializableToDateFunction<T, D> name);

    /**
     * entity between and function property expression.
     *
     * @param name the name
     * @return set between and values expression.
     */
    SetLocalDateExpression2 property(SerializableToLocalDateFunction<T> name);

    /**
     * entity between and function property expression.
     *
     * @param name the name
     * @return set between and values expression.
     */
    SetLocalTimeExpression2 property(SerializableToLocalTimeFunction<T> name);

    /**
     * entity between and function property expression.
     *
     * @param name the name
     * @return set between and values expression.
     */
    SetLocalDateTimeExpression2 property(SerializableToLocalDateTimeFunction<T> name);

    /**
     * entity between and function property expression.
     *
     * @param <N>  the generic type
     * @param name the name
     * @return set between and values expression.
     */
    <N extends Number> SetNumberExpression2<N> property(SerializableToNumberFunction<T, N> name);

    /**
     * entity between and function property expression.
     *
     * @param <E>  the generic type
     * @param name the name
     * @return set between and values expression.
     */
    <E extends Enum<E>> SetEnumExpression2<E> property(SerializableToEnumFunction<T, E> name);

    /**
     * entity between and function property expression.
     *
     * @param name the name
     * @return set between and values expression.
     */
    SetStringExpression2 property(SerializableToStringFunction<T> name);
}
