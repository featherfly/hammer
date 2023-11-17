
/*
 * All rights Reserved, Designed By zhongj
 * @Title: ConpareEntityExpression.java
 * @Package cn.featherfly.hammer.expression.entity.condition
 * @Description: ConpareEntityExpression
 * @author: zhongj
 * @date: 2023-07-19 18:01:19
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.condition;

/**
 * The Interface NullNotNullEntityPropertyValueExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface NullNotNullRepositoryPropertyValueExpression {

    /**
     * Value.
     */
    default void value() {
        value(true);
    }

    /**
     * Value.
     *
     * @param value the value
     */
    void value(Boolean value);
}
