
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2025-04-17 02:13:17
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.mapper;

import cn.featherfly.common.bean.PropertyAccessor;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.repository.mapper.RowMapper;

/**
 * BeanRowMapperFactory.
 *
 * @author zhongj
 */
public interface BeanRowMapperFactory {

    /**
     * Creates a new BeanRowMapper object.
     *
     * @param <T> the generic type
     * @param type the type
     * @param manager the manager
     * @param prefix the prefix
     * @return the row mapper< t>
     */
    <T> RowMapper<T> createRowMapper(PropertyAccessor<T> type, SqlTypeMappingManager manager, String prefix);
}
