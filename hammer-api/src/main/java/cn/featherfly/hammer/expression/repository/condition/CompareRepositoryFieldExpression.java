
package cn.featherfly.hammer.expression.repository.condition;

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
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.hammer.expression.condition.field.CompareFieldExpression;
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
 * repository conpare field expression.
 *
 * @author zhongj
 */
public interface CompareRepositoryFieldExpression extends CompareFieldExpression {

    /**
     * get set int expression with name.
     *
     * @param <T>  the generic type
     * @param name the name
     * @return set int expression.
     */
    default <T> SetIntExpression field(SerializableToIntFunction<T> name) {
        return fieldAsInt(LambdaUtils.getLambdaPropertyName(name));
    }

    /**
     * get set long expression with name.
     *
     * @param <T>  the generic type
     * @param name the name
     * @return set long expression.
     */
    default <T> SetLongExpression field(SerializableToLongFunction<T> name) {
        return fieldAsLong(LambdaUtils.getLambdaPropertyName(name));
    }

    /**
     * get set double expression with name.
     *
     * @param <T>  the generic type
     * @param name the name
     * @return set double expression.
     */
    default <T> SetDoubleExpression field(SerializableToDoubleFunction<T> name) {
        return fieldAsDouble(LambdaUtils.getLambdaPropertyName(name));
    }

    /**
     * get set Date expression with name.
     *
     * @param <T>  the generic type
     * @param <D>  the generic type
     * @param name the name
     * @return set Date expression.
     */
    default <T, D extends Date> SetDateExpression<D> field(SerializableToDateFunction<T, D> name) {
        return fieldAsDate(LambdaUtils.getLambdaPropertyName(name));
    }

    /**
     * get set LocalDate expression with name.
     *
     * @param <T>  the generic type
     * @param name the name
     * @return set LocalDate expression.
     */
    default <T> SetLocalDateExpression field(SerializableToLocalDateFunction<T> name) {
        return fieldAsLocalDate(LambdaUtils.getLambdaPropertyName(name));
    }

    /**
     * get set LocalTime expression with name.
     *
     * @param <T>  the generic type
     * @param name the name
     * @return set LocalTime expression.
     */
    default <T> SetLocalTimeExpression field(SerializableToLocalTimeFunction<T> name) {
        return fieldAsLocalTime(LambdaUtils.getLambdaPropertyName(name));
    }

    /**
     * get set LocalDateTime expression with name.
     *
     * @param <T>  the generic type
     * @param name the name
     * @return set LocalDateTime expression.
     */
    default <T> SetLocalDateTimeExpression field(SerializableToLocalDateTimeFunction<T> name) {
        return fieldAsLocalDateTime(LambdaUtils.getLambdaPropertyName(name));
    }

    /**
     * get set Number expression with name.
     *
     * @param <T>  the generic type
     * @param <N>  the generic type
     * @param name the name
     * @return set Number expression.
     */
    default <T, N extends Number> SetNumberExpression<N> field(SerializableToNumberFunction<T, N> name) {
        return fieldAsNumber(LambdaUtils.getLambdaPropertyName(name));
    }

    /**
     * get set Enum expression with name.
     *
     * @param <T>  the generic type
     * @param <E>  the element type
     * @param name the name
     * @return set Enum expression.
     */
    default <T, E extends Enum<E>> SetEnumExpression<E> field(SerializableToEnumFunction<T, E> name) {
        return fieldAsEnum(LambdaUtils.getLambdaPropertyName(name));
    }

    /**
     * get set String expression with name.
     *
     * @param <T>  the generic type
     * @param name the name
     * @return set String expression.
     */
    default <T> SetStringExpression field(SerializableToStringFunction<T> name) {
        return fieldAsString(LambdaUtils.getLambdaPropertyName(name));
    }
}
