
package cn.featherfly.hammer.expression.condition.isn;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.MulitiConditionExpression;

/**
 * muliti is null expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiIsNullExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends MulitiConditionExpression {

    /**
     * is null.
     *
     * @param index the index
     * @param name  the name
     * @return LogicExpression
     */
    default L isn(int index, String name) {
        return isn(index, name, true);
    }

    /**
     * is null.
     *
     * @param index the index
     * @param name  the name
     * @param value if true, is null; if false, is not null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    L isn(int index, String name, Boolean value);

    /**
     * is null.
     *
     * @param <E>   the element type
     * @param <R>   the generic type
     * @param index the index
     * @param name  the name
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
     * @param name  the name
     * @param value if true, is null; if false, is not null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    <E, R> L isn(int index, SerializableFunction<E, R> name, Boolean value);
}