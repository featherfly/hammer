
package cn.featherfly.hammer.expression.condition.inn;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.MulitiConditionExpression;

/**
 * muliti is not null expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiIsNotNullExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends MulitiConditionExpression {

    /**
     * is not null.
     *
     * @param <R>   the generic type
     * @param index the index
     * @param name  参数名称
     * @return LogicExpression
     */
    default <E, R> L inn(int index, SerializableFunction<E, R> name) {
        return inn(index, name, true);
    }

    /**
     * is not null.
     *
     * @param <E>   the element type
     * @param <R>   the generic type
     * @param index the index
     * @param name  参数名称
     * @param value if true, is null; if false, is not null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    <E, R> L inn(int index, SerializableFunction<E, R> name, Boolean value);
}