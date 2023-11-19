
package cn.featherfly.hammer.expression.condition.isn;

import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * is null expression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface IsNullExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * is null.
     *
     * @param name the name
     * @return LogicExpression
     */
    default L isn(String name) {
        return isn(name, true);
    }

    /**
     * is null.
     *
     * @param name  the name
     * @param value if true, is null; if false, is not null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    L isn(String name, Boolean value);

    /**
     * is null.
     *
     * @param field the field
     * @return LogicExpression
     */
    default L isn(Field field) {
        return isn(field.name());
    }

    /**
     * is null.
     *
     * @param field the field
     * @param value if true, is null; if false, is not null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    default L isn(Field field, Boolean value) {
        return isn(field.name(), value);
    }

    /**
     * is null.
     *
     * @param field the field
     * @return LogicExpression
     */
    default L isn(AliasField field) {
        return isn(field.getAliasOrName());
    }

    /**
     * is null.
     *
     * @param field the field
     * @param value if true, is null; if false, is not null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    default L isn(AliasField field, Boolean value) {
        return isn(field.getAliasOrName(), value);
    }
}