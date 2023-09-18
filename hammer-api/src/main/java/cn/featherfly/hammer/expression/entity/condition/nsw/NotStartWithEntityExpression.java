
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Entities.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: Entities
 * @author: zhongj
 * @date: 2023-07-18 14:44:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.nsw;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;

/**
 * The Interface NotStartWithEntityExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface NotStartWithEntityExpression<E> extends NotStartWithEntityPropertyExpression<E> {

    /**
     * not start with value. 不以value开始.
     *
     * @param property the property
     * @param value    the value
     * @return the l
     */
    void accept(SerializableToStringFunction<E> property, String value);

    /**
     * not start with value. 不以value开始.
     *
     * @param property    the property
     * @param value       the value
     * @param queryPolicy the query policy
     * @return the l
     */
    void accept(SerializableToStringFunction<E> property, String value, MatchStrategy matchStrategy);

    /**
     * not start with value. 不以value开始.
     *
     * @param property       the property
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    void accept(SerializableToStringFunction<E> property, String value, Predicate<String> ignoreStrategy);

    /**
     * not start with value. 不以value开始.
     *
     * @param property       the property
     * @param value          the value
     * @param queryPolicy    the query policy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    void accept(SerializableToStringFunction<E> property, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);

    /**
     * not start with value. 不以value开始.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    void accept(SerializableSupplier<String> propertyValue);

    /**
     * not start with value. 不以value开始.
     *
     * @param propertyValue  the property value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableSupplier<String> propertyValue, Predicate<String> ignoreStrategy);

    /**
     * not start with value. 不以value开始.
     *
     * @param propertyValue the property value
     * @param queryPolicy   the query policy
     * @return LogicExpression
     */
    void accept(SerializableSupplier<String> propertyValue, MatchStrategy matchStrategy);

    /**
     * not start with value. 不以value开始.
     *
     * @param propertyValue  the property value
     * @param queryPolicy    the query policy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableSupplier<String> propertyValue, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);
}
