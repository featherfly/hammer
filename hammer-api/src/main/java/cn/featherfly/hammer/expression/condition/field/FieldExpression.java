
package cn.featherfly.hammer.expression.condition.field;

import cn.featherfly.hammer.expression.condition.ConditionExpression;

/**
 * field expression.
 *
 * @author zhongj
 */
public interface FieldExpression extends ConditionExpression {

    /**
     * Name.
     *
     * @return the string
     */
    String name();
}