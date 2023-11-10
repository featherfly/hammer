
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityQueryRelatedExpression.java
 * @Description: EntityQueryRelatedExpression
 * @author: zhongj
 * @date: 2023-08-11 16:17:11
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.entity.query.relation;

import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.hammer.expression.query.QueryRelateExpression;

/**
 * EntityQueryRelatedExpression.
 *
 * @author zhongj
 * @param <J1> the first join type
 * @param <J2> the second join type
 * @param <R>  the generic type
 * @param <F>  the generic type
 */
public interface EntityQueryRelatedExpression<J1, J2, R extends QueryRelateExpression<F>, F> {

    /**
     * On.
     *
     * @param <P>          the generic type
     * @param propertyName the property name
     * @return the re
     */
    <P> R on(SerializableFunction1<J1, P> propertyName);

    /**
     * On.
     *
     * @param <P>                  the generic type
     * @param joinTypePropertyName the join type property name
     * @return the re
     */
    <P> R on(SerializableFunction2<J2, P> joinTypePropertyName);

    /**
     * On.
     *
     * @param <P>                  the generic type
     * @param propertyName         the property name
     * @param joinTypePropertyName the join type property name
     * @return the re
     */
    <P> R on(SerializableFunction1<J1, P> propertyName, SerializableFunction2<J2, P> joinTypePropertyName);

}
