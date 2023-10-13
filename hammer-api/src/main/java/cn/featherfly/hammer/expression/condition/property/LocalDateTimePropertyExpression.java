
package cn.featherfly.hammer.expression.condition.property;

import java.time.LocalDateTime;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * LocalDateTime property expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface LocalDateTimePropertyExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends PropertyBetweenExpression<C, L, LocalDateTime>, PropertyNotBetweenExpression<C, L, LocalDateTime> //
        , PropertyEqualsExpression<C, L, LocalDateTime>, PropertyNotEqualsExpression<C, L, LocalDateTime>,
        PropertyInExpression<C, L, LocalDateTime>, PropertyNotInExpression<C, L, LocalDateTime>,
        PropertyLessEqualsExpression<C, L, LocalDateTime>, PropertyLessThanExpression<C, L, LocalDateTime>,
        PropertyGreatEqualsExpression<C, L, LocalDateTime>, PropertyGreatThanExpression<C, L, LocalDateTime>,
        PropertyIsNullExpression<C, L>, PropertyIsNotNullExpression<C, L> {

}