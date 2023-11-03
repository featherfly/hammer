
package cn.featherfly.hammer.expression.repository.condition;

import java.util.Date;

import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryDateFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryEnumFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryLocalDateFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryLocalDateTimeFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryLocalTimeFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryNumberFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositorySerializableFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryStringFieldExpression;

/**
 * repository field expression. .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryFieldExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * field.
     *
     * @param name the name
     * @return the object expression
     */
    RepositorySerializableFieldExpression<C, L> field(String name);

    /**
     * Field as string.
     *
     * @param name the name
     * @return the string expression
     */
    RepositoryStringFieldExpression<C, L> fieldAsString(String name);

    /**
     * Field as number.
     *
     * @param <N>  the number type
     * @param name the name
     * @return the number expression
     */
    <N extends Number> RepositoryNumberFieldExpression<N, C, L> fieldAsNumber(String name);

    /**
     * Field as enum.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return the enum expression
     */
    <R extends Enum<R>> RepositoryEnumFieldExpression<R, C, L> fieldAsEnum(String name);

    /**
     * Field as date.
     *
     * @param <D>  the generic type
     * @param name the name
     * @return the date expression
     */
    <D extends Date> RepositoryDateFieldExpression<D, C, L> fieldAsDate(String name);

    /**
     * Field as local date.
     *
     * @param name the name
     * @return the date expression
     */
    RepositoryLocalDateFieldExpression<C, L> fieldAsLocalDate(String name);

    /**
     * Field as local date time.
     *
     * @param name the name
     * @return the date expression
     */
    RepositoryLocalDateTimeFieldExpression<C, L> fieldAsLocalDateTime(String name);

    /**
     * Field as local time.
     *
     * @param name the name
     * @return the date expression
     */
    RepositoryLocalTimeFieldExpression<C, L> fieldAsLocalTime(String name);

    /**
     * field.
     *
     * @param field the field
     * @return the object expression
     */
    default RepositorySerializableFieldExpression<C, L> field(Field field) {
        return field(field.name());
    }

    /**
     * Field as string.
     *
     * @param field the field
     * @return the string expression
     */
    default RepositoryStringFieldExpression<C, L> fieldAsString(Field field) {
        return fieldAsString(field.name());
    }

    /**
     * Field as number.
     *
     * @param <N>   the number type
     * @param field the field
     * @return the number expression
     */
    default <N extends Number> RepositoryNumberFieldExpression<N, C, L> fieldAsNumber(Field field) {
        return fieldAsNumber(field.name());
    }

    /**
     * Field as enum.
     *
     * @param <R>   the generic type
     * @param field the field
     * @return the enum expression
     */
    default <R extends Enum<R>> RepositoryEnumFieldExpression<R, C, L> fieldAsEnum(Field field) {
        return fieldAsEnum(field.name());
    }

    /**
     * Field as date.
     *
     * @param <D>   the generic type
     * @param field the field
     * @return the date expression
     */
    default <D extends Date> RepositoryDateFieldExpression<D, C, L> fieldAsDate(Field field) {
        return fieldAsDate(field.name());
    }

    /**
     * Field as local date.
     *
     * @param field the field
     * @return the date expression
     */
    default RepositoryLocalDateFieldExpression<C, L> fieldAsLocalDate(Field field) {
        return fieldAsLocalDate(field.name());
    }

    /**
     * Field as local date time.
     *
     * @param field the field
     * @return the date expression
     */
    default RepositoryLocalDateTimeFieldExpression<C, L> fieldAsLocalDateTime(Field field) {
        return fieldAsLocalDateTime(field.name());
    }

    /**
     * Field as local time.
     *
     * @param field the field
     * @return the date expression
     */
    default RepositoryLocalTimeFieldExpression<C, L> fieldAsLocalTime(Field field) {
        return fieldAsLocalTime(field.name());
    }

    //    /**
    //     * Property.
    //     *
    //     * @param <T>  the generic type
    //     * @param <R>  the generic type
    //     * @param name the name
    //     * @return the object expression
    //     */
    //    default <T, R> RepositorySerializableFieldExpression<C, L> field(SerializableFunction<T, R> name) {
    //        return field(LambdaUtils.getLambdaPropertyName(name));
    //    }
    //
    //    /**
    //     * Property string.
    //     *
    //     * @param <T>  the generic type
    //     * @param name the name
    //     * @return the string expression
    //     */
    //    default <T> RepositoryStringFieldExpression<C, L> field(SerializableToStringFunction<T> name) {
    //        return fieldAsString(LambdaUtils.getLambdaPropertyName(name));
    //    }
    //
    //    /**
    //     * Property number.
    //     *
    //     * @param <T>  the generic type
    //     * @param <R>  the generic type
    //     * @param name the name
    //     * @return the number expression
    //     */
    //    default <T,
    //            R extends Number> RepositoryNumberFieldExpression<R, C, L> field(SerializableToNumberFunction<T, R> name) {
    //        return fieldAsNumber(LambdaUtils.getLambdaPropertyName(name));
    //    }
    //
    //    /**
    //     * Property date.
    //     *
    //     * @param <T>  the generic type
    //     * @param <R>  the generic type
    //     * @param name the name
    //     * @return the date expression
    //     */
    //    default <T, R extends Date> RepositoryDateFieldExpression<R, C, L> field(SerializableToDateFunction<T, R> name) {
    //        return fieldAsDate(LambdaUtils.getLambdaPropertyName(name));
    //    }
    //
    //    /**
    //     * Property enum.
    //     *
    //     * @param <T>  the generic type
    //     * @param <R>  the generic type
    //     * @param name the name
    //     * @return the enum expression
    //     */
    //    default <T, R extends Enum<R>> RepositoryEnumFieldExpression<R, C, L> field(SerializableToEnumFunction<T, R> name) {
    //        return fieldAsEnum(LambdaUtils.getLambdaPropertyName(name));
    //    }
}
