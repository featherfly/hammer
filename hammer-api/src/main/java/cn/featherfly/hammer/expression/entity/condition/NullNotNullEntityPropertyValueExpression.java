
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ConpareEntityExpression.java
 * @Package cn.featherfly.hammer.expression.entity.condition
 * @Description: ConpareEntityExpression
 * @author: zhongj
 * @date: 2023-07-19 18:01:19
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition;

/**
 * The Interface NullNotNullEntityPropertyValueExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface NullNotNullEntityPropertyValueExpression {

    /**
     * Value.
     *
     * @return LogicExpression
     */
    default void value() {
        value(true);
    }

    /**
     * Value.
     *
     * @param value 参数值
     * @return LogicExpression
     */
    void value(Boolean value);
}
