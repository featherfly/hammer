
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-04 17:26:04
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.data.query;

import cn.featherfly.common.repository.mapper.RowMapper;

/**
 * query mapper setter0.
 *
 * @author zhongj
 */
public interface QueryMapperSetter0 {

    /**
     * mapper.
     *
     * @param <T> the generic type
     * @param rowMapper the row mapper
     * @return the generic type query executor
     */
    <T> QueryExecutor<T> mapper(RowMapper<T> rowMapper);
}