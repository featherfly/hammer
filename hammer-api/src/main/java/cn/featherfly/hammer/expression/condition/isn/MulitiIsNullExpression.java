
package cn.featherfly.hammer.expression.condition.isn;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * muliti is null expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiIsNullExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

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
     * @param index the index
     * @param field the field
     * @return LogicExpression
     */
    default L isn(int index, Field field) {
        return isn(index, field.name());
    }

    /**
     * is null.
     *
     * @param index the index
     * @param field the field
     * @param value if true, is null; if false, is not null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    default L isn(int index, Field field, Boolean value) {
        return isn(index, field.name(), value);
    }

    /**
     * is null.
     *
     * @param index the index
     * @param field the field
     * @return LogicExpression
     */
    default L isn(int index, AliasField field) {
        return isn(index, field.getAliasOrName());
    }

    /**
     * is null.
     *
     * @param index the index
     * @param field the field
     * @param value if true, is null; if false, is not null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    default L isn(int index, AliasField field, Boolean value) {
        return isn(index, field.getAliasOrName(), value);
    }

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