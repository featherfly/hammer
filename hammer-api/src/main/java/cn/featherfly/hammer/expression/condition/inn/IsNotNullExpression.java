
package cn.featherfly.hammer.expression.condition.inn;

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
public interface IsNotNullExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * is not null.
     *
     * @param name 参数名称
     * @return LogicExpression
     */
    default L inn(String name) {
        return inn(name, true);
    }

    /**
     * is not null.
     *
     * @param name  参数名称
     * @param value if true, is not null; if false, is null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    L inn(String name, Boolean value);

    /**
     * is not null.
     *
     * @param name 参数名称
     * @return LogicExpression
     */
    default L inn(Field name) {
        return inn(name.name());
    }

    /**
     * is not null.
     *
     * @param name  参数名称
     * @param value if true, is not null; if false, is null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    default L inn(Field name, Boolean value) {
        return inn(name.name(), value);
    }
}