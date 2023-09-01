
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.Field;

/**
 * ContainsExpression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface ContainsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * contains value. 包含value.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L co(Field name, String value) {
        return co(name, value, MatchStrategy.AUTO);
    }

    /**
     * contains value. 包含value.
     *
     * @param name        the name
     * @param value       the value
     * @param queryPolicy the query policy
     * @return the l
     */
    default L co(Field name, String value, MatchStrategy queryPolicy) {
        return co(name.name(), value, MatchStrategy.AUTO);
    }

    /**
     * contains value. 包含value.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L co(String name, String value) {
        return co(name, value, MatchStrategy.AUTO);
    }

    /**
     * contains value. 包含value.
     *
     * @param name        the name
     * @param value       the value
     * @param queryPolicy the query policy
     * @return the l
     */
    L co(String name, String value, MatchStrategy queryPolicy);

    /**
     * contains value. 包含value.
     *
     * @param <T>   the generic type
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default <T> L co(SerializableToStringFunction<T> name, String value) {
        return co(name, value, MatchStrategy.AUTO);
    }

    /**
     * contains value. 包含value.
     *
     * @param <T>         the generic type
     * @param name        the name
     * @param value       the value
     * @param queryPolicy the query policy
     * @return the l
     */
    <T> L co(SerializableToStringFunction<T> name, String value, MatchStrategy queryPolicy);

    /**
     * contains value. 包含value.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    default L co(SerializableStringSupplier property) {
        return co(property, MatchStrategy.AUTO);
    }

    /**
     * contains value. 包含value.
     *
     * @param property    the property
     * @param queryPolicy the query policy
     * @return the l
     */
    L co(SerializableStringSupplier property, MatchStrategy queryPolicy);
}