
/*
 * All rights Reserved, Designed By zhongj
 * @Title: MapRowMapper.java
 * @Description: MapRowMapper
 * @author: zhongj
 * @date: 2023-09-18 14:37:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;

/**
 * MapRowMapper.
 *
 * @author zhongj
 */
public class MapRowMapper extends AbstractRowMapper<Map<String, Serializable>> {

    private final List<Mapping> mappings = new ArrayList<>();

    private final SqlTypeMappingManager manager;

    private final String prefix;

    /**
     * Instantiates a new map row mapper.
     *
     * @param manager the manager
     */
    public MapRowMapper(SqlTypeMappingManager manager) {
        this(manager, null);
    }

    /**
     * Instantiates a new map row mapper.
     *
     * @param manager the manager
     */
    public MapRowMapper(SqlTypeMappingManager manager, String prefix) {
        super();
        this.manager = manager;
        this.prefix = prefix;
    }

    @Override
    public Map<String, Serializable> mapRow(ResultSet res, int rowNum) throws SQLException {
        if (rowNum == 0) {
            ResultSetMetaData metaData = res.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                String name = JdbcUtils.lookupColumnName(metaData, i, true);
                if (prefix != null) {
                    if (name.startsWith(prefix)) {
                        name = org.apache.commons.lang3.StringUtils.removeStart(name, prefix);
                    } else {
                        // need match prefix, so ignore not matched
                        continue;
                    }
                }
                Mapping mapping = new Mapping();
                mapping.index = i;
                mapping.name = name;
                mapping.type = manager.getJavaType(JdbcUtils.getResultSetType(res, i));
                mappings.add(mapping);
            }
        }
        Map<String, Serializable> resultMap = new LinkedHashMap<>();
        for (Mapping mapping : mappings) {
            resultMap.put(mapping.name, manager.get(res, mapping.index, mapping.type));
        }
        return resultMap;
    }

    private class Mapping {

        int index;

        String name;

        Class<? extends Serializable> type;
    }
}
