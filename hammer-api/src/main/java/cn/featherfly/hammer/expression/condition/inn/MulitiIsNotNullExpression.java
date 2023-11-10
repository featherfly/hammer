
package cn.featherfly.hammer.expression.condition.inn;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * muliti is not null expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiIsNotNullExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * is not null.
     *
     * @param index the index
     * @param name  the name
     * @return LogicExpression
     */
    default L inn(int index, String name) {
        return inn(index, name, true);
    }

    /**
     * is not null.
     *
     * @param index the index
     * @param name  the name
     * @param value if true, is null; if false, is not null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    L inn(int index, String name, Boolean value);

    /**
     * is not null.
     *
     * @param index the index
     * @param field the field
     * @return LogicExpression
     */
    default L inn(int index, Field field) {
        return inn(index, field.name());
    }

    /**
     * is not null.
     *
     * @param index the index
     * @param field the field
     * @param value if true, is null; if false, is not null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    default L inn(int index, Field field, Boolean value) {
        return inn(index, field.name(), value);
    }

    /**
     * is not null.
     *
     * @param index the index
     * @param field the field
     * @return LogicExpression
     */
    default L inn(int index, AliasField field) {
        return inn(index, field.getAliasOrName());
    }

    /**
     * is not null.
     *
     * @param index the index
     * @param field the field
     * @param value if true, is null; if false, is not null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    default L inn(int index, AliasField field, Boolean value) {
        return inn(index, field.getAliasOrName(), value);
    }

    /**
     * is not null.
     *
     * @param <E>   the element type
     * @param <R>   the generic type
     * @param index the index
     * @param name  the name
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
     * @param name  the name
     * @param value if true, is null; if false, is not null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    <E, R> L inn(int index, SerializableFunction<E, R> name, Boolean value);
}