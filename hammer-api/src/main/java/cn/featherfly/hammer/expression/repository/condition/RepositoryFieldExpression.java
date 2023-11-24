
package cn.featherfly.hammer.expression.repository.condition;

import java.util.Date;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToDateFunction;
import cn.featherfly.common.function.serializable.SerializableToEnumFunction;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.FieldExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.field.DateFieldExpression;
import cn.featherfly.hammer.expression.condition.field.EnumFieldExpression;
import cn.featherfly.hammer.expression.condition.field.NumberFieldExpression;
import cn.featherfly.hammer.expression.condition.field.ObjectFieldExpression;
import cn.featherfly.hammer.expression.condition.field.StringFieldExpression;

/**
 * repository field expression. .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryFieldExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends FieldExpression<C, L> {

    /**
     * Property.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name the name
     * @return the object expression
     */
    default <T, R> ObjectFieldExpression<C, L> field(SerializableFunction<T, R> name) {
        return field(LambdaUtils.getLambdaPropertyName(name));
    }

    /**
     * Property string.
     *
     * @param <T>  the generic type
     * @param name the name
     * @return the string expression
     */
    default <T> StringFieldExpression<C, L> field(SerializableToStringFunction<T> name) {
        return fieldAsString(LambdaUtils.getLambdaPropertyName(name));
    }

    /**
     * Property number.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name the name
     * @return the number expression
     */
    default <T, R extends Number> NumberFieldExpression<R, C, L> field(SerializableToNumberFunction<T, R> name) {
        return fieldAsNumber(LambdaUtils.getLambdaPropertyName(name));
    }

    /**
     * Property date.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name the name
     * @return the date expression
     */
    default <T, R extends Date> DateFieldExpression<R, C, L> field(SerializableToDateFunction<T, R> name) {
        return fieldAsDate(LambdaUtils.getLambdaPropertyName(name));
    }

    /**
     * Property enum.
     *
     * @param <T>  the generic type
     * @param <R>  the generic type
     * @param name the name
     * @return the enum expression
     */
    default <T, R extends Enum<R>> EnumFieldExpression<R, C, L> field(SerializableToEnumFunction<T, R> name) {
        return fieldAsEnum(LambdaUtils.getLambdaPropertyName(name));
    }
}
