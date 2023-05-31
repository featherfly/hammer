
package cn.featherfly.hammer.expression.condition;

import java.util.Collections;
import java.util.Map;

/**
 * condition expression.
 *
 * @author zhongj
 */
public interface ConditionExpression extends Expression {

    @SuppressWarnings("unchecked")
    Map<String, Object> EMPTY_PARAMS = Collections.EMPTY_MAP;

}
