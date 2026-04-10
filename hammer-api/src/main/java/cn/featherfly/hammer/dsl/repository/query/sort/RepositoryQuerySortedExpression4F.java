
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

import cn.featherfly.data.query.LimitAwareQuery1;
import cn.featherfly.data.query.QueryMapperSetter1;
import cn.featherfly.hammer.expression.repository.query.RepositoryQuerySortedExpression4;

/**
 * RepositoryQuerySortedExpression4F.
 *
 * @author zhongj
 */
public interface RepositoryQuerySortedExpression4F extends
    RepositoryQuerySortedExpression4<RepositoryQuerySortedExpression4F, LimitAwareQuery1<Map<String, Serializable>>>,
    QueryMapperSetter1 {
}
