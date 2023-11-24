
package cn.featherfly.hammer.expression.condition.isn;

import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * is null expression6 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface IsNullExpression6<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends IsNullExpression5<C, L> {

    /**
     * is null.
     *
     * @param name the name
     * @return LogicExpression
     */
    default L isn6(String name) {
        return isn6(name, true);
    }

    /**
     * is null.
     *
     * @param name the name
     * @param value if true, is null; if false, is not null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    L isn6(String name, Boolean value);

    /**
     * is null.
     *
     * @param name the name
     * @return LogicExpression
     */
    default L isn6(Field name) {
        return isn6(name.name());
    }

    /**
     * is null.
     *
     * @param name the name
     * @param value if true, is null; if false, is not null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    default L isn6(Field name, Boolean value) {
        return isn6(name.name(), value);
    }
}