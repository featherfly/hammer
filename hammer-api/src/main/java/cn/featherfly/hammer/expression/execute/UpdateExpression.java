
package cn.featherfly.hammer.expression.execute;

import cn.featherfly.hammer.config.dsl.UpdateConditionConfig;
import cn.featherfly.hammer.config.dsl.UpdateConfig;
import cn.featherfly.hammer.expression.ConfigureExpression;

/**
 * UpdateExpression.
 *
 * @author zhongj
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <V> the value type
 * @param <N> the number value type
 */
public interface UpdateExpression<U extends ExecutableUpdateExpression<U, C, L, V, N>,
        C extends ExecutableConditionGroupExpression<C, L, UpdateConditionConfig>,
        L extends ExecutableConditionGroupLogicExpression<C, L, UpdateConditionConfig>,
        V extends UpdateValueExpression<U, C, L, Object, V, N>,
        N extends UpdateNumberValueExpression<U, C, L, Number, V, N>>
        extends PropertyUpdateExpression<U, C, L, V, N>, UpdateSetExpression<U, C, L>,
        ConfigureExpression<UpdateExpression<U, C, L, V, N>, UpdateConfig, UpdateConditionConfig> {

}
