
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntityQueryRelatedExpression.java
 * @Description: EntityQueryRelatedExpression
 * @author: zhongj
 * @date: 2023-08-11 16:17:11
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.query.relation;

import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.hammer.expression.api.entity.QueryRelate;

/**
 * EntityQueryRelatedExpression.
 *
 * @author zhongj
 * @param <J1>  the first join type
 * @param <J2>  the second join type
 * @param <QR>  the generic type
 * @param <QRF> the generic type
 */
public interface EntityQueryRelatedExpression<J1, J2, QR extends QueryRelate<QRF>, QRF> {

    /**
     * On.
     *
     * @param <P>          the generic type
     * @param propertyName the property name
     * @return the re
     */
    <P> QR on(SerializableFunction1<J1, P> propertyName);

    /**
     * On.
     *
     * @param <JP>                 the generic type
     * @param joinTypePropertyName the join type property name
     * @return the re
     */
    <JP> QR on(SerializableFunction2<J2, JP> joinTypePropertyName);

    /**
     * On.
     *
     * @param <P>                  the generic type
     * @param propertyName         the property name
     * @param joinTypePropertyName the join type property name
     * @return the re
     */
    <P> QR on(SerializableFunction1<J1, P> propertyName, SerializableFunction2<J2, P> joinTypePropertyName);

}
