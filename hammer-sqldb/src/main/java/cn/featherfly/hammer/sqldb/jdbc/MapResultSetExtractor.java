
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-19 16:54:19
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc;

import java.io.Serializable;
import java.util.Map;

import cn.featherfly.common.db.mapping.SqlTypeMappingManager;

/**
 * MapResultSetExtractor.
 *
 * @author zhongj
 */
public class MapResultSetExtractor extends AbstractResultSetExtractor<Map<String, Serializable>> {

    /**
     * Instantiates a new map result set extractor.
     *
     * @param manager the manager
     */
    public MapResultSetExtractor(SqlTypeMappingManager manager) {
        super(new MapRowMapper(manager));
    }
}
