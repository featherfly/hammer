
package cn.featherfly.hammer.expression.entity.condition;

import java.util.Collection;
import java.util.Date;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableToCollectionFunction;
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
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityDatePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityDoublePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityEnumPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityIntPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLocalDatePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLocalDateTimePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLocalTimePropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityLongPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityNumberPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityStringPropertyExpression;
import cn.featherfly.hammer.expression.entity.condition.property.EntityTypePropertyExpression;

/**
 * The Interface EntityPropertyExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityPropertyExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * Property.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return the object expression
     */
    <R> EntityTypePropertyExpression<R, C, L> property(SerializableFunction<E, R> name);

    /**
     * Property Collection.
     *
     * @param <R>  the generic type
     * @param <RE> the generic type
     * @param name the name
     * @return the object expression
     */
    <R extends Collection<RE>,
            RE> EntityTypePropertyExpression<RE, C, L> property(SerializableToCollectionFunction<E, R, RE> name);

    /**
     * int property.
     *
     * @param name the name
     * @return the string expression
     */
    EntityIntPropertyExpression<E, C, L> property(SerializableToIntFunction<E> name);

    /**
     * long property.
     *
     * @param name the name
     * @return the string expression
     */
    EntityLongPropertyExpression<E, C, L> property(SerializableToLongFunction<E> name);

    /**
     * double property.
     *
     * @param name the name
     * @return the string expression
     */
    EntityDoublePropertyExpression<E, C, L> property(SerializableToDoubleFunction<E> name);

    /**
     * Property number.
     *
     * @param <R>  the number type
     * @param name the name
     * @return the number expression
     */
    <R extends Number> EntityNumberPropertyExpression<E, R, C, L> property(SerializableToNumberFunction<E, R> name);

    /**
     * Property date.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return the date expression
     */
    <R extends Date> EntityDatePropertyExpression<E, R, C, L> property(SerializableToDateFunction<E, R> name);

    /**
     * Property string.
     *
     * @param name the name
     * @return the string expression
     */
    EntityStringPropertyExpression<E, C, L> property(SerializableToStringFunction<E> name);

    /**
     * Property LocalDate.
     *
     * @param name the name
     * @return the date expression
     */
    EntityLocalDatePropertyExpression<E, C, L> property(SerializableToLocalDateFunction<E> name);

    /**
     * Property date.
     *
     * @param name the name
     * @return the date expression
     */
    EntityLocalDateTimePropertyExpression<E, C, L> property(SerializableToLocalDateTimeFunction<E> name);

    /**
     * Property date.
     *
     * @param name the name
     * @return the date expression
     */
    EntityLocalTimePropertyExpression<E, C, L> property(SerializableToLocalTimeFunction<E> name);

    /**
     * Property enum.
     *
     * @param <R>  the generic type
     * @param name the name
     * @return the enum expression
     */
    <R extends Enum<R>> EntityEnumPropertyExpression<E, R, C, L> property(SerializableToEnumFunction<E, R> name);
}
