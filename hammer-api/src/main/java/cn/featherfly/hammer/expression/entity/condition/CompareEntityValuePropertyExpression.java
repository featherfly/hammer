
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
import cn.featherfly.hammer.expression.condition.field.value.SetDateExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetDoubleExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetEnumExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetIntExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateTimeExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalTimeExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetLongExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetNumberExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetStringExpression;

/**
 * compare entity value property expression.
 *
 * @author zhongj
 * @param <T> the element type
 */
public interface CompareEntityValuePropertyExpression<T> {

    /**
     * entity compare function property expression.
     *
     * @param name the name
     * @return entity compare function property expression.
     */
    SetIntExpression property(SerializableToIntFunction<T> name);

    /**
     * entity compare function property expression.
     *
     * @param name the name
     * @return entity compare function property expression.
     */
    SetLongExpression property(SerializableToLongFunction<T> name);

    /**
     * entity compare function property expression.
     *
     * @param name the name
     * @return entity compare function property expression.
     */
    SetDoubleExpression property(SerializableToDoubleFunction<T> name);

    /**
     * entity compare function property expression.
     *
     * @param <D>  the generic type
     * @param name the name
     * @return entity compare function property expression.
     */
    <D extends Date> SetDateExpression<D> property(SerializableToDateFunction<T, D> name);

    /**
     * entity compare function property expression.
     *
     * @param name the name
     * @return entity compare function property expression.
     */
    SetLocalDateExpression property(SerializableToLocalDateFunction<T> name);

    /**
     * entity compare function property expression.
     *
     * @param name the name
     * @return entity compare function property expression.
     */
    SetLocalTimeExpression property(SerializableToLocalTimeFunction<T> name);

    /**
     * entity compare function property expression.
     *
     * @param name the name
     * @return entity compare function property expression.
     */
    SetLocalDateTimeExpression property(SerializableToLocalDateTimeFunction<T> name);

    /**
     * entity compare function property expression.
     *
     * @param <N>  the generic type
     * @param name the name
     * @return entity compare function property expression.
     */
    <N extends Number> SetNumberExpression<N> property(SerializableToNumberFunction<T, N> name);

    /**
     * entity compare function property expression.
     *
     * @param <E>  the element type
     * @param name the name
     * @return entity compare function property expression.
     */
    <E extends Enum<E>> SetEnumExpression<E> property(SerializableToEnumFunction<T, E> name);

    /**
     * entity compare function property expression.
     *
     * @param name the name
     * @return entity compare function property expression.
     */
    SetStringExpression property(SerializableToStringFunction<T> name);
}
