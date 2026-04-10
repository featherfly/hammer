
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2025-03-16 01:15:16
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dsl.repository.query.sort;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.data.query.LimitAwareQuery2;
import cn.featherfly.data.query.QueryMapperSetter2;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortedExpression3;

/**
 * RepositoryQuerySortedExpression3FF.
 *
 * @author zhongj
 */
public interface RepositoryQuerySortedExpression3FF extends
    RepositoryQuerySortedExpression3<RepositoryQuerySortedExpression3FF, LimitAwareQuery2<Map<String, Serializable>>>,
    QueryMapperSetter2 {
}
