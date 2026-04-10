/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-27 17:06:27
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.repository.query;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery0;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortExpression6;

/**
 * repository query sort expression6.
 *
 * @author zhongj
 * @param <S> the generic type
 * @param <Q> the generic type
 */
public interface RepositoryQuerySortExpression6<S extends RepositoryQuerySortedExpression6<S, Q>,
    Q extends LimitAwareQuery0<Map<String, Serializable>>> extends RepositorySortExpression6<S> {

}
