
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-19 16:54:19
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc;

import cn.featherfly.common.repository.mapper.RowMapper;

/**
 * MapResultSetExtractor.
 *
 * @author zhongj
 */
public class RowMapperResultSetExtractor<E> extends AbstractResultSetExtractor<E> {

    /**
     * Instantiates a new map result set extractor.
     *
     * @param rowMapper the row mapper
     */
    public RowMapperResultSetExtractor(RowMapper<E> rowMapper) {
        super(rowMapper);
    }
}
