
package cn.featherfly.hammer.expression.condition.field;

import java.util.Date;

import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
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
 * The Interface CompareEntityValuePropertyExpression.
 *
 * @author zhongj
 */
public interface CompareFieldExpression {

    /**
     * get set int expression with name.
     *
     * @param name the name
     * @return set int expression.
     */
    SetIntExpression fieldAsInt(String name);

    /**
     * get set long expression with name.
     *
     * @param name the name
     * @return set long expression.
     */
    SetLongExpression fieldAsLong(String name);

    /**
     * get set double expression with name.
     *
     * @param name the name
     * @return set double expression.
     */
    SetDoubleExpression fieldAsDouble(String name);

    /**
     * get set Number expression with name.
     *
     * @param <N>  the number type
     * @param name the name
     * @return set Number expression.
     */
    <N extends Number> SetNumberExpression<N> fieldAsNumber(String name);

    /**
     * get set Number expression with name.
     *
     * @param <N>  the number type
     * @param name the name
     * @param type the type
     * @return set Number expression.
     */
    <N extends Number> SetNumberExpression<N> fieldAsNumber(String name, Class<N> type);

    /**
     * get set Enum expression with name.
     *
     * @param <E>  the element type
     * @param name the name
     * @return set Enum expression.
     */
    <E extends Enum<E>> SetEnumExpression<E> fieldAsEnum(String name);

    /**
     * get set Enum expression with name.
     *
     * @param <E>  the element type
     * @param name the name
     * @param type the type
     * @return set Enum expression.
     */
    <E extends Enum<E>> SetEnumExpression<E> fieldAsEnum(String name, Class<E> type);

    /**
     * get set date expression with name.
     *
     * @param <D>  the generic type
     * @param name the name
     * @return set date expression.
     */
    <D extends Date> SetDateExpression<D> fieldAsDate(String name);

    /**
     * get set date expression with name.
     *
     * @param <D>  the generic type
     * @param name the name
     * @param type the type
     * @return set date expression.
     */
    <D extends Date> SetDateExpression<D> fieldAsDate(String name, Class<D> type);

    /**
     * get set LocalDate expression with name.
     *
     * @param name the name
     * @return set LocalDate expression.
     */
    SetLocalDateExpression fieldAsLocalDate(String name);

    /**
     * get set LocalTime expression with name.
     *
     * @param name the name
     * @return set LocalTime expression.
     */
    SetLocalTimeExpression fieldAsLocalTime(String name);

    /**
     * get set LocalDateTime expression with name.
     *
     * @param name the name
     * @return set LocalDateTime expression.
     */
    SetLocalDateTimeExpression fieldAsLocalDateTime(String name);

    /**
     * get set String expression with name.
     *
     * @param name the name
     * @return set String expression.
     */
    SetStringExpression fieldAsString(String name);

    /**
     * get set int expression with name.
     *
     * @param field the field
     * @return set int expression.
     */
    default SetIntExpression fieldAsInt(Field field) {
        return fieldAsInt(field.name());
    }

    /**
     * get set long expression with name.
     *
     * @param field the field
     * @return set long expression.
     */
    default SetLongExpression fieldAsLong(Field field) {
        return fieldAsLong(field.name());
    }

    /**
     * get set double expression with name.
     *
     * @param field the field
     * @return set double expression.
     */
    default SetDoubleExpression fieldAsDouble(Field field) {
        return fieldAsDouble(field.name());
    }

    /**
     * get set Number expression with name.
     *
     * @param <N>   the number type
     * @param field the field
     * @return set Number expression.
     */
    default <N extends Number> SetNumberExpression<N> fieldAsNumber(Field field) {
        return fieldAsNumber(field.name());
    }

    /**
     * get set Number expression with name.
     *
     * @param <N>   the number type
     * @param field the field
     * @param type  the type
     * @return set Number expression.
     */
    default <N extends Number> SetNumberExpression<N> fieldAsNumber(Field field, Class<N> type) {
        return fieldAsNumber(field.name(), type);
    }

    /**
     * get set Enum expression with name.
     *
     * @param <E>   the element type
     * @param field the field
     * @return set Enum expression.
     */
    default <E extends Enum<E>> SetEnumExpression<E> fieldAsEnum(Field field) {
        return fieldAsEnum(field.name());
    }

    /**
     * get set Enum expression with name.
     *
     * @param <E>   the element type
     * @param field the field
     * @param type  the type
     * @return set Enum expression.
     */
    default <E extends Enum<E>> SetEnumExpression<E> fieldAsEnum(Field field, Class<E> type) {
        return fieldAsEnum(field.name(), type);
    }

    /**
     * get set date expression with name.
     *
     * @param <D>   the generic type
     * @param field the field
     * @return set date expression.
     */
    default <D extends Date> SetDateExpression<D> fieldAsDate(Field field) {
        return fieldAsDate(field.name());
    }

    /**
     * get set date expression with name.
     *
     * @param <D>   the generic type
     * @param field the field
     * @param type  the type
     * @return set date expression.
     */
    default <D extends Date> SetDateExpression<D> fieldAsDate(Field field, Class<D> type) {
        return fieldAsDate(field.name(), type);
    }

    /**
     * get set LocalDate expression with name.
     *
     * @param field the field
     * @return set LocalDate expression.
     */
    default SetLocalDateExpression fieldAsLocalDate(Field field) {
        return fieldAsLocalDate(field.name());
    }

    /**
     * get set LocalTime expression with name.
     *
     * @param field the field
     * @return set LocalTime expression.
     */
    default SetLocalTimeExpression fieldAsLocalTime(Field field) {
        return fieldAsLocalTime(field.name());
    }

    /**
     * get set LocalDateTime expression with name.
     *
     * @param field the field
     * @return set LocalDateTime expression.
     */
    default SetLocalDateTimeExpression fieldAsLocalDateTime(Field field) {
        return fieldAsLocalDateTime(field.name());
    }

    /**
     * get set String expression with name.
     *
     * @param field the field
     * @return set String expression.
     */
    default SetStringExpression fieldAsString(Field field) {
        return fieldAsString(field.name());
    }

    /**
     * get set int expression with name.
     *
     * @param field the field
     * @return set int expression.
     */
    default SetIntExpression fieldAsInt(AliasField field) {
        return fieldAsInt(field.getAliasOrName());
    }

    /**
     * get set long expression with name.
     *
     * @param field the field
     * @return set long expression.
     */
    default SetLongExpression fieldAsLong(AliasField field) {
        return fieldAsLong(field.getAliasOrName());
    }

    /**
     * get set double expression with name.
     *
     * @param field the field
     * @return set double expression.
     */
    default SetDoubleExpression fieldAsDouble(AliasField field) {
        return fieldAsDouble(field.getAliasOrName());
    }

    /**
     * get set Number expression with name.
     *
     * @param <N>   the number type
     * @param field the field
     * @return set Number expression.
     */
    default <N extends Number> SetNumberExpression<N> fieldAsNumber(AliasField field) {
        return fieldAsNumber(field.getAliasOrName());
    }

    /**
     * get set Number expression with name.
     *
     * @param <N>   the number type
     * @param field the field
     * @param type  the type
     * @return set Number expression.
     */
    default <N extends Number> SetNumberExpression<N> fieldAsNumber(AliasField field, Class<N> type) {
        return fieldAsNumber(field.getAliasOrName(), type);
    }

    /**
     * get set Enum expression with name.
     *
     * @param <E>   the element type
     * @param field the field
     * @return set Enum expression.
     */
    default <E extends Enum<E>> SetEnumExpression<E> fieldAsEnum(AliasField field) {
        return fieldAsEnum(field.getAliasOrName());
    }

    /**
     * get set Enum expression with name.
     *
     * @param <E>   the element type
     * @param field the field
     * @param type  the type
     * @return set Enum expression.
     */
    default <E extends Enum<E>> SetEnumExpression<E> fieldAsEnum(AliasField field, Class<E> type) {
        return fieldAsEnum(field.getAliasOrName(), type);
    }

    /**
     * get set date expression with name.
     *
     * @param <D>   the generic type
     * @param field the field
     * @return set date expression.
     */
    default <D extends Date> SetDateExpression<D> fieldAsDate(AliasField field) {
        return fieldAsDate(field.getAliasOrName());
    }

    /**
     * get set date expression with name.
     *
     * @param <D>   the generic type
     * @param field the field
     * @param type  the type
     * @return set date expression.
     */
    default <D extends Date> SetDateExpression<D> fieldAsDate(AliasField field, Class<D> type) {
        return fieldAsDate(field.getAliasOrName(), type);
    }

    /**
     * get set LocalDate expression with name.
     *
     * @param field the field
     * @return set LocalDate expression.
     */
    default SetLocalDateExpression fieldAsLocalDate(AliasField field) {
        return fieldAsLocalDate(field.getAliasOrName());
    }

    /**
     * get set LocalTime expression with name.
     *
     * @param field the field
     * @return set LocalTime expression.
     */
    default SetLocalTimeExpression fieldAsLocalTime(AliasField field) {
        return fieldAsLocalTime(field.getAliasOrName());
    }

    /**
     * get set LocalDateTime expression with name.
     *
     * @param field the field
     * @return set LocalDateTime expression.
     */
    default SetLocalDateTimeExpression fieldAsLocalDateTime(AliasField field) {
        return fieldAsLocalDateTime(field.getAliasOrName());
    }

    /**
     * get set String expression with name.
     *
     * @param field the field
     * @return set String expression.
     */
    default SetStringExpression fieldAsString(AliasField field) {
        return fieldAsString(field.getAliasOrName());
    }
}
