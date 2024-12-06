
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
 * @param <T> the entity type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityPropertyExpression<T, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends ConditionExpression {

    //    /**
    //     * Property.
    //     *
    //     * @param <R> the generic type
    //     * @param name the name
    //     * @param propertyExpressions the property expressions
    //     * @return the logic expressoin
    //     */
    //    default <R, C2 extends EntityConditionGroupExpression<R, C2, L2>,
    //        L2 extends EntityConditionGroupLogicExpression<R, C2, L2>> L property(SerializableFunction<T, R> name,
    //            Consumer<C2> propertyExpressions) {
    //        propertyExpressions.accept((C2) property(name));
    //    }
    //    /**
    //     * Property.
    //     *
    //     * @param <R> the generic type
    //     * @param name the name
    //     * @param propertyExpressions the property expressions
    //     * @return the logic expressoin
    //     */
    //    <R, C2 extends EntityConditionGroupExpression<R, C2, L2>,
    //        L2 extends EntityConditionGroupLogicExpression<R, C2, L2>> L property(SerializableFunction<T, R> name,
    //            Consumer<C2> propertyExpressions);

    /**
     * Property.
     *
     * @param <R> the generic type
     * @param name the name
     * @return the object expression
     */
    <R> EntityTypePropertyExpression<R, C, L> property(SerializableFunction<T, R> name);

    /**
     * Property Collection.
     *
     * @param <R> the collection type
     * @param <E> the element type of collection
     * @param name the name
     * @return the object expression
     */
    <R extends Collection<E>,
        E> EntityTypePropertyExpression<E, C, L> property(SerializableToCollectionFunction<T, R, E> name);

    /**
     * int property.
     *
     * @param name the name
     * @return the string expression
     */
    EntityIntPropertyExpression<C, L> property(SerializableToIntFunction<T> name);

    /**
     * long property.
     *
     * @param name the name
     * @return the string expression
     */
    EntityLongPropertyExpression<C, L> property(SerializableToLongFunction<T> name);

    /**
     * double property.
     *
     * @param name the name
     * @return the string expression
     */
    EntityDoublePropertyExpression<C, L> property(SerializableToDoubleFunction<T> name);

    /**
     * Property number.
     *
     * @param <R> the number type
     * @param name the name
     * @return the number expression
     */
    <R extends Number> EntityNumberPropertyExpression<R, C, L> property(SerializableToNumberFunction<T, R> name);

    /**
     * Property date.
     *
     * @param <R> the generic type
     * @param name the name
     * @return the date expression
     */
    <R extends Date> EntityDatePropertyExpression<R, C, L> property(SerializableToDateFunction<T, R> name);

    /**
     * Property string.
     *
     * @param name the name
     * @return the string expression
     */
    EntityStringPropertyExpression<C, L> property(SerializableToStringFunction<T> name);

    /**
     * Property LocalDate.
     *
     * @param name the name
     * @return the date expression
     */
    EntityLocalDatePropertyExpression<C, L> property(SerializableToLocalDateFunction<T> name);

    /**
     * Property date.
     *
     * @param name the name
     * @return the date expression
     */
    EntityLocalDateTimePropertyExpression<C, L> property(SerializableToLocalDateTimeFunction<T> name);

    /**
     * Property date.
     *
     * @param name the name
     * @return the date expression
     */
    EntityLocalTimePropertyExpression<C, L> property(SerializableToLocalTimeFunction<T> name);

    /**
     * Property enum.
     *
     * @param <R> the generic type
     * @param name the name
     * @return the enum expression
     */
    <R extends Enum<R>> EntityEnumPropertyExpression<R, C, L> property(SerializableToEnumFunction<T, R> name);
}
