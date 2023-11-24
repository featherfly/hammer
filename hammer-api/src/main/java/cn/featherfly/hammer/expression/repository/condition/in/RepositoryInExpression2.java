
package cn.featherfly.hammer.expression.repository.condition.in;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository in expression2 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryInExpression2<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryInExpressionBase2<C, L> {

}