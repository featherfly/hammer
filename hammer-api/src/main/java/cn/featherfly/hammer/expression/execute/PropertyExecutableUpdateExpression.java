
package cn.featherfly.hammer.expression.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.expression.WhereExpression;

/**
 * The Interface PropertyExecutableUpdateExpression.
 *
 * @author zhongj
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <V> the value type
 * @param <N> the number value type
 */
public interface PropertyExecutableUpdateExpression<U extends PropertyExecutableUpdateExpression<U, C, L, V, N>,
        C extends ExecutableConditionGroupExpression<C, L, UpdateConditionConfig>,
        L extends ExecutableConditionGroupLogicExpression<C, L, UpdateConditionConfig>,
        V extends UpdateValueExpression<U, C, L, Object, V, N>,
        N extends UpdateNumberValueExpression<U, C, L, Number, V, N>>
        extends WhereExpression<C, L>, PropertyUpdateExpression<U, C, L, V, N>, Executor {

}
