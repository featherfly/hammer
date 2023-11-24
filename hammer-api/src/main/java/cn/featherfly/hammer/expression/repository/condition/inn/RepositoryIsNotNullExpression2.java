
package cn.featherfly.hammer.expression.repository.condition.inn;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository is not null expression2 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryIsNotNullExpression2<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryIsNotNullExpressionBase2<C, L> {

}