
package cn.featherfly.hammer.expression.condition.inn;

import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * is not null expression4.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface IsNotNullExpression4<C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * is not null.
     *
     * @param name the name
     * @return LogicExpression
     */
    default L inn4(String name) {
        return inn4(name, true);
    }

    /**
     * is not null.
     *
     * @param name  the name
     * @param value if true, is not null; if false, is null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    L inn4(String name, Boolean value);

    /**
     * is not null.
     *
     * @param name the name
     * @return LogicExpression
     */
    default L inn4(Field name) {
        return inn4(name.name());
    }

    /**
     * is not null.
     *
     * @param name  the name
     * @param value if true, is not null; if false, is null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    default L inn4(Field name, Boolean value) {
        return inn4(name.name(), value);
    }
}