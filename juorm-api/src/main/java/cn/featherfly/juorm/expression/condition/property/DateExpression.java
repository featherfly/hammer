
package cn.featherfly.juorm.expression.condition.property;

import java.util.Date;

import cn.featherfly.juorm.expression.condition.ConditionExpression;
import cn.featherfly.juorm.expression.condition.LogicExpression;

/**
 * <p>
 * EqualsExpressoin
 * </p>
 *
 * @author zhongj
 */
public interface DateExpression<C extends ConditionExpression,
        L extends LogicExpression<C, L>>
        extends PropertyEqualsExpression<C, L, Date>,
        PropertyNotEqualsExpression<C, L, Date>,
        PropertyInExpression<C, L, Date>, PropertyNotInExpression<C, L, Date>,
        PropertyLessEqualsExpressoin<C, L, Date>,
        PropertyLessThanExpressoin<C, L, Date>,
        PropertyGreatEqualsExpressoin<C, L, Date>,
        PropertyGreatThanExpressoin<C, L, Date>, PropertyIsNullExpression<C, L>,
        PropertyIsNotNullExpression<C, L> {

}