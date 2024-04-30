
package cn.featherfly.hammer.expression.repository.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.config.dsl.UpdateConfig;
import cn.featherfly.hammer.expression.ConfigureExpression;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * RepositoryUpdateExpression.
 *
 * @author zhongj
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface RepositoryUpdateExpression<U, C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends RepositoryFieldUpdateExpression<U, C, L>, RepositoryUpdateSetExpression<U, C, L>,
    ConfigureExpression<RepositoryUpdateExpression<U, C, L>, UpdateConfig, UpdateConditionConfig> {

}
