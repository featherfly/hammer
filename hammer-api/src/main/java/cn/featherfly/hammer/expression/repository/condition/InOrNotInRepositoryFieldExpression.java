package cn.featherfly.hammer.expression.repository.condition;

import java.util.Date;

import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.expression.condition.field.value.SetDateArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetDoubleArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetEnumArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetIntArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalDateTimeArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetLocalTimeArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetLongArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetNumberArrayExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetStringArrayExpression;

/**
 * The Interface InNotInRepositoryFieldExpression.
 *
 * @author zhongj
 */
public interface InOrNotInRepositoryFieldExpression {

    /**
     * int and int array field expression.
     *
     * @param name the field name
     * @return int and int array field expression.
     */
    SetIntArrayExpression fieldAsInt(String name);

    /**
     * long and long array field expression.
     *
     * @param name the field name
     * @return long and long array field expression.
     */
    SetLongArrayExpression fieldAsLong(String name);

    /**
     * double and double array field expression.
     *
     * @param name the field name
     * @return double and double array field expression.
     */
    SetDoubleArrayExpression fieldAsDouble(String name);

    /**
     * number and number array field expression.
     *
     * @param <N>  the number type
     * @param name the field name
     * @return number and number array field expression.
     */
    <N extends Number> SetNumberArrayExpression<N> fieldAsNumber(String name);

    /**
     * date and date array field expression.
     *
     * @param <D>  the date type
     * @param name the field name
     * @return date and date array field expression.
     */
    <D extends Date> SetDateArrayExpression<D> fieldAsDate(String name);

    /**
     * enum and enum array field expression.
     *
     * @param <E>  the enum type
     * @param name the name
     * @return entity in function property expression.
     */
    <E extends Enum<E>> SetEnumArrayExpression<E> fieldAsEnum(String name);

    /**
     * LocalDateTime and LocalDateTime array field expression.
     *
     * @param name the name
     * @return LocalDateTime and LocalDateTime array field expression.
     */
    SetLocalDateTimeArrayExpression fieldAsLocalDateTime(String name);

    /**
     * LocalDate and LocalDate array field expression.
     *
     * @param name the name
     * @return LocalDate and LocalDate array field expression.
     */
    SetLocalDateArrayExpression fieldAsLocalDate(String name);

    /**
     * LocalTime and LocalTime array field expression.
     *
     * @param name the name
     * @return LocalTime and LocalTime array field expression.
     */
    SetLocalTimeArrayExpression fieldAsLocalTime(String name);

    /**
     * String and String array field expression.
     *
     * @param name the name
     * @return String and String array field expression.
     */
    SetStringArrayExpression fieldAsString(String name);

    /**
     * int and int array field expression.
     *
     * @param field the field
     * @return int and int array field expression.
     */
    default SetIntArrayExpression fieldAsInt(Field field) {
        return fieldAsInt(field.name());
    }

    /**
     * long and long array field expression.
     *
     * @param field the field
     * @return long and long array field expression.
     */
    default SetLongArrayExpression fieldAsLong(Field field) {
        return fieldAsLong(field.name());
    }

    /**
     * double and double array field expression.
     *
     * @param field the field
     * @return double and double array field expression.
     */
    default SetDoubleArrayExpression fieldAsDouble(Field field) {
        return fieldAsDouble(field.name());
    }

    /**
     * number and number array field expression.
     *
     * @param <N>   the number type
     * @param field the field
     * @return number and number array field expression.
     */
    default <N extends Number> SetNumberArrayExpression<N> fieldAsNumber(Field field) {
        return fieldAsNumber(field.name());
    }

    /**
     * date and date array field expression.
     *
     * @param <D>   the date type
     * @param field the field
     * @return date and date array field expression.
     */
    default <D extends Date> SetDateArrayExpression<D> fieldAsDate(Field field) {
        return fieldAsDate(field.name());
    }

    /**
     * enum and enum array field expression.
     *
     * @param <E>   the enum type
     * @param field the field
     * @return entity in function property expression.
     */
    default <E extends Enum<E>> SetEnumArrayExpression<E> fieldAsEnum(Field field) {
        return fieldAsEnum(field.name());
    }

    /**
     * LocalDateTime and LocalDateTime array field expression.
     *
     * @param field the field
     * @return LocalDateTime and LocalDateTime array field expression.
     */
    default SetLocalDateTimeArrayExpression fieldAsLocalDateTime(Field field) {
        return fieldAsLocalDateTime(field.name());
    }

    /**
     * LocalDate and LocalDate array field expression.
     *
     * @param field the field
     * @return LocalDate and LocalDate array field expression.
     */
    default SetLocalDateArrayExpression fieldAsLocalDate(Field field) {
        return fieldAsLocalDate(field.name());
    }

    /**
     * LocalTime and LocalTime array field expression.
     *
     * @param field the field
     * @return LocalTime and LocalTime array field expression.
     */
    default SetLocalTimeArrayExpression fieldAsLocalTime(Field field) {
        return fieldAsLocalTime(field.name());
    }

    /**
     * String and String array field expression.
     *
     * @param field the field
     * @return String and String array field expression.
     */
    default SetStringArrayExpression fieldAsString(Field field) {
        return fieldAsString(field.name());
    }
}
