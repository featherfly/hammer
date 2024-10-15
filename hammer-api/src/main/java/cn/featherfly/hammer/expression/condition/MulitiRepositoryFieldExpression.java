
package cn.featherfly.hammer.expression.condition;

import java.util.Date;
import java.util.function.ToIntFunction;

import cn.featherfly.common.tuple.Tuple;

import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.expression.condition.field.DateFieldExpression;
import cn.featherfly.hammer.expression.condition.field.EnumFieldExpression;
import cn.featherfly.hammer.expression.condition.field.LocalDateFieldExpression;
import cn.featherfly.hammer.expression.condition.field.LocalDateTimeFieldExpression;
import cn.featherfly.hammer.expression.condition.field.LocalTimeFieldExpression;
import cn.featherfly.hammer.expression.condition.field.NumberFieldExpression;
import cn.featherfly.hammer.expression.condition.field.SerializableFieldExpression;
import cn.featherfly.hammer.expression.condition.field.StringFieldExpression;

/**
 * muliti repository field expression.
 *
 * @author zhongj
 * @param <T> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiRepositoryFieldExpression<T extends Tuple, C extends ConditionExpression,
        L extends LogicExpression<C, L>> {

    /**
     * field.
     *
     * @param repositoiesFunction the repositoies function
     * @param name                the name
     * @return the object expression
     */
    SerializableFieldExpression<C, L> field(ToIntFunction<T> repositoiesFunction, String name);

    /**
     * Field as string.
     *
     * @param repositoiesFunction the repositoies function
     * @param name                the name
     * @return the string expression
     */
    StringFieldExpression<C, L> fieldAsString(ToIntFunction<T> repositoiesFunction, String name);

    /**
     * Field as number.
     *
     * @param <N>                 the number type
     * @param repositoiesFunction the repositoies function
     * @param name                the name
     * @return the number expression
     */
    <N extends Number> NumberFieldExpression<N, C, L> fieldAsNumber(ToIntFunction<T> repositoiesFunction, String name);

    /**
     * Field as enum.
     *
     * @param <R>                 the generic type
     * @param repositoiesFunction the repositoies function
     * @param name                the name
     * @return the enum expression
     */
    <R extends Enum<R>> EnumFieldExpression<R, C, L> fieldAsEnum(ToIntFunction<T> repositoiesFunction, String name);

    /**
     * Field as date.
     *
     * @param <D>                 the generic type
     * @param repositoiesFunction the repositoies function
     * @param name                the name
     * @return the date expression
     */
    <D extends Date> DateFieldExpression<D, C, L> fieldAsDate(ToIntFunction<T> repositoiesFunction, String name);

    /**
     * Field as local date.
     *
     * @param repositoiesFunction the repositoies function
     * @param name                the name
     * @return the date expression
     */
    LocalDateFieldExpression<C, L> fieldAsLocalDate(ToIntFunction<T> repositoiesFunction, String name);

    /**
     * Field as local date time.
     *
     * @param repositoiesFunction the repositoies function
     * @param name                the name
     * @return the date expression
     */
    LocalDateTimeFieldExpression<C, L> fieldAsLocalDateTime(ToIntFunction<T> repositoiesFunction, String name);

    /**
     * Field as local time.
     *
     * @param repositoiesFunction the repositoies function
     * @param name                the name
     * @return the date expression
     */
    LocalTimeFieldExpression<C, L> fieldAsLocalTime(ToIntFunction<T> repositoiesFunction, String name);

    /**
     * field.
     *
     * @param repositoiesFunction the repositoies function
     * @param field               the field
     * @return the object expression
     */
    default SerializableFieldExpression<C, L> field(ToIntFunction<T> repositoiesFunction, Field field) {
        return field(repositoiesFunction, field.name());
    }

    /**
     * Field as string.
     *
     * @param repositoiesFunction the repositoies function
     * @param field               the field
     * @return the string expression
     */
    default StringFieldExpression<C, L> fieldAsString(ToIntFunction<T> repositoiesFunction, Field field) {
        return fieldAsString(repositoiesFunction, field.name());
    }

    /**
     * Field as number.
     *
     * @param <N>                 the number type
     * @param repositoiesFunction the repositoies function
     * @param field               the field
     * @return the number expression
     */
    default <N extends Number> NumberFieldExpression<N, C, L> fieldAsNumber(ToIntFunction<T> repositoiesFunction,
            Field field) {
        return fieldAsNumber(repositoiesFunction, field.name());
    }

    /**
     * Field as enum.
     *
     * @param <R>                 the generic type
     * @param repositoiesFunction the repositoies function
     * @param field               the field
     * @return the enum expression
     */
    default <R extends Enum<R>> EnumFieldExpression<R, C, L> fieldAsEnum(ToIntFunction<T> repositoiesFunction,
            Field field) {
        return fieldAsEnum(repositoiesFunction, field.name());
    }

    /**
     * Field as date.
     *
     * @param <D>                 the generic type
     * @param repositoiesFunction the repositoies function
     * @param field               the field
     * @return the date expression
     */
    default <D extends Date> DateFieldExpression<D, C, L> fieldAsDate(ToIntFunction<T> repositoiesFunction,
            Field field) {
        return fieldAsDate(repositoiesFunction, field.name());
    }

    /**
     * Field as local date.
     *
     * @param repositoiesFunction the repositoies function
     * @param field               the field
     * @return the date expression
     */
    default LocalDateFieldExpression<C, L> fieldAsLocalDate(ToIntFunction<T> repositoiesFunction, Field field) {
        return fieldAsLocalDate(repositoiesFunction, field.name());
    }

    /**
     * Field as local date time.
     *
     * @param repositoiesFunction the repositoies function
     * @param field               the field
     * @return the date expression
     */
    default LocalDateTimeFieldExpression<C, L> fieldAsLocalDateTime(ToIntFunction<T> repositoiesFunction, Field field) {
        return fieldAsLocalDateTime(repositoiesFunction, field.name());
    }

    /**
     * Field as local time.
     *
     * @param repositoiesFunction the repositoies function
     * @param field               the field
     * @return the date expression
     */
    default LocalTimeFieldExpression<C, L> fieldAsLocalTime(ToIntFunction<T> repositoiesFunction, Field field) {
        return fieldAsLocalTime(repositoiesFunction, field.name());
    }
}
