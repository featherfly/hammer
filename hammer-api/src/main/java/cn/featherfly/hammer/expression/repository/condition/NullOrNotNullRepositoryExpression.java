
package cn.featherfly.hammer.expression.repository.condition;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.expression.condition.NullOrNotNullExpression;
import cn.featherfly.hammer.expression.condition.field.value.SetIsNullOrIsNotNullValueExpression;

/**
 * The Interface NullOrNotNullRepositoryExpression.
 *
 * @author zhongj
 */
public interface NullOrNotNullRepositoryExpression extends NullOrNotNullExpression {

    /**
     * repository is not null field expression.
     *
     * @param name the name
     * @return repository is not null field expression
     */
    SetIsNullOrIsNotNullValueExpression field(String name);

    /**
     * repository is not null field expression.
     *
     * @param <T> the generic type
     * @param <R> the generic type
     * @param name the name
     * @return repository is not null field expression
     */
    <T, R> SetIsNullOrIsNotNullValueExpression field(SerializableFunction<T, R> name);

    /**
     * is null value or is not null value.
     *
     * @param field the field
     */
    default void accept(Field field) {
        accept(field.name());
    }

    /**
     * is null value or is not null value.
     *
     * @param field the field
     * @param value the value
     */
    default void accept(Field field, Boolean value) {
        accept(field.name(), value);
    }

    /**
     * is null value or is not null value.
     *
     * @param <E> the element type
     * @param <R> the generic type
     * @param property the property
     */
    default <E, R> void accept(SerializableFunction<E, R> property) {
        accept(property, true);
    }

    /**
     * is null value or is not null value.
     *
     * @param <E> the element type
     * @param <R> the generic type
     * @param property the property
     * @param value the value
     */
    <E, R> void accept(SerializableFunction<E, R> property, Boolean value);
}
