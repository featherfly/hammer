
package cn.featherfly.hammer.expression.condition.isn;

import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * is null expression5 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface IsNullExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends IsNullExpression4<C, L> {

    /**
     * is null.
     *
     * @param name the name
     * @return LogicExpression
     */
    default L isn5(String name) {
        return isn5(name, true);
    }

    /**
     * is null.
     *
     * @param name the name
     * @param value if true, is null; if false, is not null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    L isn5(String name, Boolean value);

    /**
     * is null.
     *
     * @param name the name
     * @return LogicExpression
     */
    default L isn5(Field name) {
        return isn5(name.name());
    }

    /**
     * is null.
     *
     * @param name the name
     * @param value if true, is null; if false, is not null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    default L isn5(Field name, Boolean value) {
        return isn5(name.name(), value);
    }
}