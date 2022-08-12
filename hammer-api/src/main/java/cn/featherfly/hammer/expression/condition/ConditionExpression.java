
package cn.featherfly.hammer.expression.condition;

import java.util.HashMap;
import java.util.Map;

/**
 * condition expression.
 *
 * @author zhongj
 */
public interface ConditionExpression extends Expression {

    Map<String, Object> EMPTY_PARAMS = new HashMap<>(0);
}
