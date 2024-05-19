
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-19 17:00:19
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc;

import cn.featherfly.common.db.mapping.SqlResultSet;
import cn.featherfly.common.repository.mapping.ResultSetExtractor;

/**
 * SqlResultSetExtractor.
 *
 * @author zhongj
 * @param <E> the element type
 */
public interface SqlResultSetExtractor<E> extends ResultSetExtractor<E, SqlResultSet> {

}
