
package cn.featherfly.hammer.expression.execute;

import java.io.Serializable;
import java.util.function.Consumer;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * update value .
 *
 * @author zhongj
 * @param <T> the generic type
 * @param <U> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface UpdateValueExpression<T extends Serializable, U, C extends ConditionExpression,
    L extends LogicExpression<C, L>> extends UpdateValueExpressionBase<T, U, C, L> {

    /**
     * set value.
     *
     * @param consumer the consumer
     * @return the u
     */
    U set(Consumer<UpdateValueExpression<T, U, C, L>> consumer);
}
