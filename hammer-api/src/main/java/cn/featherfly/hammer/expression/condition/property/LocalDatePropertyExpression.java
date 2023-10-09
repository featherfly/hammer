
package cn.featherfly.hammer.expression.condition.property;

import java.time.LocalDate;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * LocalDate property expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface LocalDatePropertyExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends PropertyBetweenExpression<C, L, LocalDate>, PropertyNotBetweenExpression<C, L, LocalDate> //
        , PropertyEqualsExpression<C, L, LocalDate>, PropertyNotEqualsExpression<C, L, LocalDate>,
        PropertyInExpression<C, L, LocalDate>, PropertyNotInExpression<C, L, LocalDate>,
        PropertyLessEqualsExpression<C, L, LocalDate>, PropertyLessThanExpression<C, L, LocalDate>,
        PropertyGreatEqualsExpression<C, L, LocalDate>, PropertyGreatThanExpression<C, L, LocalDate>,
        PropertyIsNullExpression<C, L>, PropertyIsNotNullExpression<C, L> {

}