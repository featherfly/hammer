
package cn.featherfly.hammer.expression.condition.inn;

import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * is not null expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface IsNotNullExpression<C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * is not null.
     *
     * @param name the name
     * @return LogicExpression
     */
    default L inn(String name) {
        return inn(name, true);
    }

    /**
     * is not null.
     *
     * @param name  the name
     * @param value if true, is not null; if false, is null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    L inn(String name, Boolean value);

    /**
     * is not null.
     *
     * @param field the field
     * @return LogicExpression
     */
    default L inn(Field field) {
        return inn(field.name());
    }

    /**
     * is not null.
     *
     * @param field the field
     * @param value if true, is not null; if false, is null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    default L inn(Field field, Boolean value) {
        return inn(field.name(), value);
    }

    /**
     * is not null.
     *
     * @param field the field
     * @return LogicExpression
     */
    default L inn(AliasField field) {
        return inn(field.getAliasOrName());
    }

    /**
     * is not null.
     *
     * @param field the field
     * @param value if true, is not null; if false, is null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    default L inn(AliasField field, Boolean value) {
        return inn(field.getAliasOrName(), value);
    }
}