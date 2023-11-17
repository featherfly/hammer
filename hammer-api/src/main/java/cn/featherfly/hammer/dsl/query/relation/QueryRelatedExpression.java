/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-17 18:27:17
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.query.relation;

import cn.featherfly.hammer.expression.api.entity.QueryRelate;

/**
 * query related expression.
 *
 * @author zhongj
 * @param <J1>  the first join type
 * @param <J2>  the second join type
 * @param <QR>  the generic type
 * @param <QRF> the generic type
 */
public interface QueryRelatedExpression<QR extends QueryRelate<QRF>, QRF> {
    // TODO 后续来加入其他方式
    /**
     * On.
     *
     * @param <P>                 the generic type
     * @param field               the field
     * @param joinRepositoryField the join repository field
     * @return the re
     */
    <P> QR on(String field, String joinRepositoryField);
}
