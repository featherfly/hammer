
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Entities.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: Entities
 * @author: zhongj
 * @date: 2023-07-18 14:44:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition.ew;

import java.util.function.Predicate;

import cn.featherfly.common.lang.function.ReturnStringFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;

/**
 * The Interface EndWithEntityExpression.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface EndWithEntityExpression<E>
        //        extends EntityEndWithFunctionValuePropertyExpression<E> {
        extends EndWithEntityPropertyExpression<E> {

    //    /**
    //     * entity end with function property expression.
    //     *
    //     * @param <R>  the generic type
    //     * @param name the name
    //     * @return entity end with function property expression
    //     */
    //    <R> EntityEndWithFunctionPropertyExpression<R> property(SerializableFunction<E, R> name);

    /**
     * end with value. 以value结尾.
     *
     * @param property the property
     * @param value    the value
     * @return the l
     */
    void accept(ReturnStringFunction<E> property, String value);

    /**
     * end with value. 以value结尾.
     *
     * @param property    the property
     * @param value       the value
     * @param queryPolicy the query policy
     * @return the l
     */
    void accept(ReturnStringFunction<E> property, String value, QueryPolicy queryPolicy);

    /**
     * end with value. 以value结尾.
     *
     * @param property     the property
     * @param value        the value
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    void accept(ReturnStringFunction<E> property, String value, Predicate<String> ignoreStrategy);

    /**
     * end with value. 以value结尾.
     *
     * @param property     the property
     * @param value        the value
     * @param queryPolicy  the query policy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    void accept(ReturnStringFunction<E> property, String value, QueryPolicy queryPolicy,
            Predicate<String> ignoreStrategy);

    /**
     * end with value. 以value结尾.
     *
     * @param propertyValue the property value
     * @return LogicExpression
     */
    void accept(SerializableSupplier<String> propertyValue);

    /**
     * end with value. 以value结尾.
     *
     * @param propertyValue the property value
     * @param ignoreStrategy  the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableSupplier<String> propertyValue, Predicate<String> ignoreStrategy);

    /**
     * end with value. 以value结尾.
     *
     * @param propertyValue the property value
     * @param queryPolicy   the query policy
     * @return LogicExpression
     */
    void accept(SerializableSupplier<String> propertyValue, QueryPolicy queryPolicy);

    /**
     * end with value. 以value结尾.
     *
     * @param propertyValue the property value
     * @param queryPolicy   the query policy
     * @param ignoreStrategy  the ignore strategy
     * @return LogicExpression
     */
    void accept(SerializableSupplier<String> propertyValue, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy);
}
