
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
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.db.mapper.SqlResultSet;
import cn.featherfly.common.db.mapping.JdbcMappingException;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.common.repository.builder.AliasManager.AliasGeneretor;

/**
 * MapRowMapper.
 *
 * @author zhongj
 */
public class MapRowMapper implements cn.featherfly.common.repository.mapper.RowMapper<Map<String, Serializable>> {

    private final Map<String, Class<? extends Serializable>> mappingMap = new LinkedHashMap<>();

    private static final AliasGeneretor ALIAS_GENERETOR = (name, no) -> name + "(" + no + ")";

    private SqlTypeMappingManager manager;

    /**
     * Instantiates a new map row mapper.
     *
     * @param manager the manager
     */
    public MapRowMapper(SqlTypeMappingManager manager) {
        super();
        this.manager = manager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Serializable> mapRow(cn.featherfly.common.repository.mapper.ResultSet res, int rowNum) {
        ResultSet rs = null;
        if (res instanceof SqlResultSet) {
            SqlResultSet sqlrs = (SqlResultSet) res;
            rs = sqlrs.getResultSet();
            AssertIllegalArgument.isNotNull(rs, "java.sql.ResultSet");
        } else {
            throw new JdbcMappingException("ResultSet is not type of SqlResultSet");
        }

        try {
            return mapRow(rs, rowNum);
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
    }

    public Map<String, Serializable> mapRow(ResultSet res, int rowNum) throws SQLException {
        if (rowNum == 0) {
            AliasManager aliasManager = new AliasManager(ALIAS_GENERETOR);
            ResultSetMetaData metaData = res.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                String name = JdbcUtils.lookupColumnName(metaData, i, true);
                if (mappingMap.containsKey(name)) {
                    name = aliasManager.put(name);
                }
                mappingMap.put(name, manager.getJavaType(JdbcUtils.getResultSetType(res, i)));
            }
        }
        int columnIndex = 1;
        Map<String, Serializable> resultMap = new LinkedHashMap<>();
        for (Entry<String, Class<? extends Serializable>> entry : mappingMap.entrySet()) {
            resultMap.put(entry.getKey(), manager.get(res, columnIndex, entry.getValue()));
            columnIndex++;
        }
        return resultMap;
        //        return JdbcUtils.getResultSetMap(res, manager);
    }

}
