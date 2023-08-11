
package cn.featherfly.hammer.expression.entity.condition.inn;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.MulitiEntityConditionExpression;

/**
 * The Interface MulitiEntityIsNotNullExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiEntityIsNotNullExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends MulitiEntityConditionExpression {

    /**
     * is null.
     *
     * @param <R>   the generic type
     * @param index the index
     * @param name  参数名称
     * @return LogicExpression
     */
    default <E, R> L isn(int index, SerializableFunction<E, R> name) {
        return isn(index, name, true);
    }

    /**
     * is null.
     *
     * @param <E>   the element type
     * @param <R>   the generic type
     * @param index the index
     * @param name  参数名称
     * @param value if true, is null; if false, is not null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    <E, R> L isn(int index, SerializableFunction<E, R> name, Boolean value);
}