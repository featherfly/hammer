
package cn.featherfly.hammer.expression.condition.property;

import java.time.LocalTime;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * LocalTime property expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface LocalTimePropertyExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends PropertyBetweenExpression<C, L, LocalTime>, PropertyNotBetweenExpression<C, L, LocalTime> //
        , PropertyEqualsExpression<C, L, LocalTime>, PropertyNotEqualsExpression<C, L, LocalTime>,
        PropertyInExpression<C, L, LocalTime>, PropertyNotInExpression<C, L, LocalTime>,
        PropertyLessEqualsExpression<C, L, LocalTime>, PropertyLessThanExpression<C, L, LocalTime>,
        PropertyGreatEqualsExpression<C, L, LocalTime>, PropertyGreatThanExpression<C, L, LocalTime>,
        PropertyIsNullExpression<C, L>, PropertyIsNotNullExpression<C, L> {

}