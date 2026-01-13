
package cn.featherfly.hammer.expression.entity.compatible;

import java.util.Date;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.EntityPropertyExpression;
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
public interface EntityPropertyCompatibleExpression<T, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends EntityPropertyExpression<T, C, L> {

    /**
     * Property.
     *
     * @param <R> the generic type
     * @param name the name
     * @return the object expression
     */
    <R> EntityTypePropertyExpression<R, C, L> property(String name);

    /**
     * int property.
     *
     * @param name the name
     * @return the string expression
     */
    EntityIntPropertyExpression<C, L> propertyAsInt(String name);

    /**
     * long property.
     *
     * @param name the name
     * @return the string expression
     */
    EntityLongPropertyExpression<C, L> propertyAsLong(String name);

    /**
     * double property.
     *
     * @param name the name
     * @return the string expression
     */
    EntityDoublePropertyExpression<C, L> propertyAsDouble(String name);

    /**
     * Property number.
     *
     * @param <R> the number type
     * @param name the name
     * @return the number expression
     */
    <R extends Number> EntityNumberPropertyExpression<R, C, L> propertyAsNumber(String name);

    /**
     * Property date.
     *
     * @param <R> the generic type
     * @param name the name
     * @return the date expression
     */
    <R extends Date> EntityDatePropertyExpression<R, C, L> propertyAsDate(String name);

    /**
     * Property string.
     *
     * @param name the name
     * @return the string expression
     */
    EntityStringPropertyExpression<C, L> propertyAsString(String name);

    /**
     * Property LocalDate.
     *
     * @param name the name
     * @return the date expression
     */
    EntityLocalDatePropertyExpression<C, L> propertyAsLocalDate(String name);

    /**
     * Property date.
     *
     * @param name the name
     * @return the date expression
     */
    EntityLocalDateTimePropertyExpression<C, L> propertyAsLocalDateTime(String name);

    /**
     * Property date.
     *
     * @param name the name
     * @return the date expression
     */
    EntityLocalTimePropertyExpression<C, L> propertyAsLocalTime(String name);

    /**
     * Property enum.
     *
     * @param <R> the generic type
     * @param name the name
     * @return the enum expression
     */
    <R extends Enum<R>> EntityEnumPropertyExpression<R, C, L> propertyAsEnum(String name);
}
