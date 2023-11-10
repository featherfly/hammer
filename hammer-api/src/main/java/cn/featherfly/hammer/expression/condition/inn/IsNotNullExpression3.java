
package cn.featherfly.hammer.expression.condition.inn;

import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * is not null expression3.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface IsNotNullExpression3<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends IsNotNullExpression2<C, L> {

    /**
     * is not null.
     *
     * @param name the name
     * @return LogicExpression
     */
    default L inn3(String name) {
        return inn3(name, true);
    }

    /**
     * is not null.
     *
     * @param name the name
     * @param value if true, is not null; if false, is null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    L inn3(String name, Boolean value);

    /**
     * is not null.
     *
     * @param name the name
     * @return LogicExpression
     */
    default L inn3(Field name) {
        return inn3(name.name());
    }

    /**
     * is not null.
     *
     * @param name the name
     * @param value if true, is not null; if false, is null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    default L inn3(Field name, Boolean value) {
        return inn3(name.name(), value);
    }
}