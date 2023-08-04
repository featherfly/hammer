
/*
 * All rights Reserved, Designed By zhongj
 * @Title: MulitiConditionExpression.java
 * @Package cn.featherfly.hammer.expression.condition
 * @Description: MulitiConditionExpression
 * @author: zhongj
 * @date: 2023-07-28 18:59:28
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.condition;

import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.PropertyMapping;

/**
 * MulitiConditionExpression.
 *
 * @author zhongj
 */
public interface MulitiConditionExpression extends Expression {

    /**
     * Gets the query alias.
     *
     * @param index the index
     * @return the query alias
     */
    String getAlias(int index);

    /**
     * Gets the class mapping.
     *
     * @param <CM>  the generic type
     * @param <T>   the generic type
     * @param <P>   the generic type
     * @param index the index
     * @return the class mapping
     */
    <CM extends ClassMapping<T, P>, T, P extends PropertyMapping<P>> CM getClassMapping(int index);

    /**
     * Adds the condition.
     *
     * @param condition the condition
     * @return the object
     */
    Expression addCondition(Expression condition);
}
