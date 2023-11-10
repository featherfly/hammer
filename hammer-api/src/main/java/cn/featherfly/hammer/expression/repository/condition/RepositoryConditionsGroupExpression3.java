
package cn.featherfly.hammer.expression.repository.condition;

import cn.featherfly.hammer.expression.condition.ConditionsGroupExpression3;

/**
 * repository all conditions group expression3.
 *
 * @author zhongj
 */
public interface RepositoryConditionsGroupExpression3<C extends RepositoryConditionsGroupExpression3<C, L>,
        L extends RepositoryConditionsGroupLogicExpression3<C, L>>
        extends RepositoryConditionsExpression3<C, L>, ConditionsGroupExpression3<C, L> {

}
