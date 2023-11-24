
package cn.featherfly.hammer.expression.repository.condition.lk;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * repository like expression2.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryLikeExpression2<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends RepositoryLikeExpressionBase2<C, L> {

}