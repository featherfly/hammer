
package cn.featherfly.hammer.expression.condition.property;

import java.util.Date;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * Date property expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface DatePropertyExpression<D extends Date, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends PropertyBetweenExpression<C, L, D>, PropertyNotBetweenExpression<C, L, D> //
        , PropertyEqualsExpression<C, L, D>, PropertyNotEqualsExpression<C, L, D>, PropertyInExpression<C, L, D>,
        PropertyNotInExpression<C, L, D>, PropertyLessEqualsExpression<C, L, D>, PropertyLessThanExpression<C, L, D>,
        PropertyGreatEqualsExpression<C, L, D>, PropertyGreatThanExpression<C, L, D>, PropertyIsNullExpression<C, L>,
        PropertyIsNotNullExpression<C, L> {

}