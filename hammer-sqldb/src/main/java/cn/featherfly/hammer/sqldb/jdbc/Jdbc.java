/*
 * All rights Reserved, Designed By zhongj
 * @Title: Jdbc.java
 * @Package cn.featherfly.hammer.sqldb.jdbc
 * @Description: todo (用一句话描述该文件做什么)
 * @author: zhongj
 * @date: 2023年7月10日 下午3:57:25
 * @version V1.0
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.lang.Lang;

/**
 * Jdbc.
 *
 * @author zhongj
 */
public interface Jdbc extends JdbcQuery, JdbcProcedure, JdbcUpdate, JdbcQueryProcessSingle {

    //    /**
    //     * Gets the data source.
    //     *
    //     * @return DataSource
    //     */
    //    DataSource getDataSource();

    /**
     * 返回dialect.
     *
     * @return dialect
     */
    Dialect getDialect();

    /**
     * Gets the sql type mapping manager.
     *
     * @return the sql type mapping manager
     */
    SqlTypeMappingManager getSqlTypeMappingManager();

    //    /**
    //     * Adds the interceptor.
    //     *
    //     * @param interceptor the interceptor
    //     */
    //    void addInterceptor(JdbcExecutionInterceptor interceptor);
    //
    //    /**
    //     * Adds the interceptor.
    //     *
    //     * @param interceptors the interceptors
    //     */
    //    default void addInterceptor(List<JdbcExecutionInterceptor> interceptors) {
    //        if (interceptors != null) {
    //            for (JdbcExecutionInterceptor jdbcExecutionInterceptor : interceptors) {
    //                addInterceptor(jdbcExecutionInterceptor);
    //            }
    //        }
    //    }
    //
    //    /**
    //     * Adds the interceptor.
    //     *
    //     * @param interceptors the interceptors
    //     */
    //    default void addInterceptor(JdbcExecutionInterceptor... interceptors) {
    //        if (interceptors != null) {
    //            for (JdbcExecutionInterceptor jdbcExecutionInterceptor : interceptors) {
    //                addInterceptor(jdbcExecutionInterceptor);
    //            }
    //        }
    //    }

    /**
     * Insert.
     *
     * @param tableName   the table name
     * @param columnNames the column names
     * @param args        the args
     * @return the int
     */
    default int insert(String tableName, String[] columnNames, Object... args) {
        return insert(tableName, columnNames, null, args);
    }

    /**
     * Insert.
     *
     * @param <T>         the generic type
     * @param tableName   the table name
     * @param columnNames the column names
     * @param keyHolder   the key holder
     * @param args        the args
     * @return the int
     */
    <T extends Serializable> int insert(String tableName, String[] columnNames, GeneratedKeyHolder<T> keyHolder,
            Object... args);

    /**
     * Insert.
     *
     * @param tableName    the table name
     * @param columnParams the column params
     * @return the int
     */
    default int insert(String tableName, Map<String, Object> columnParams) {
        return insert(tableName, columnParams, null);
    }

    /**
     * Insert.
     *
     * @param <T>          the generic type
     * @param tableName    the table name
     * @param columnParams the column params
     * @param keyHolder    the key holder
     * @return the int
     */
    default <T extends Serializable> int insert(String tableName, Map<String, Object> columnParams,
            GeneratedKeyHolder<T> keyHolder) {
        int i = 0;
        String[] columns = new String[columnParams.size()];
        Object[] params = new Object[columnParams.size()];
        for (Map.Entry<String, Object> entry : columnParams.entrySet()) {
            columns[i] = entry.getKey();
            params[i] = entry.getValue();
            i++;
        }
        return insert(tableName, columns, keyHolder, params);
    }

    /**
     * Insert batch.
     *
     * @param tableName   the table name
     * @param columnNames the column names
     * @param args        the args
     * @return the int
     */
    default int insertBatch(String tableName, String[] columnNames, Object... args) {
        if (args.length % columnNames.length != 0) {
            throw new JdbcException("batch size is not explicit (args.length % columnNames.length != 0)");
        }
        return insertBatch(tableName, columnNames, args.length / columnNames.length, args);
    }

    /**
     * Insert batch.
     *
     * @param tableName    the table name
     * @param columnParams the column params
     * @return the int
     */
    default int insertBatch(String tableName, List<Map<String, Object>> columnParams) {
        if (Lang.isEmpty(columnParams)) {
            return 0;
        }

        int columnLen = columnParams.get(0).size();
        int paramLen = columnLen * columnParams.size();
        String[] columns = new String[columnLen];
        Object[] params = new Object[paramLen];

        Lang.each(columnParams.get(0).entrySet(), (entry, index) -> {
            columns[index] = entry.getKey();
        });

        int i = 0;
        for (Map<String, Object> cp : columnParams) {
            for (Map.Entry<String, Object> entry : cp.entrySet()) {
                params[i] = entry.getValue();
                i++;
            }
        }

        return insertBatch(tableName, columns, columnParams.size(), params);
    }

    /**
     * Insert batch.
     *
     * @param tableName   the table name
     * @param columnNames the column names
     * @param batchSize   the batch size
     * @param args        the args
     * @return the int
     */
    int insertBatch(String tableName, String[] columnNames, int batchSize, Object... args);

    /**
     * Upsert.
     *
     * @param tableName    the table name
     * @param columnNames  the column names
     * @param uniqueColumn the unique column
     * @param args         the args
     * @return the int
     */
    default int upsert(String tableName, String[] columnNames, String uniqueColumn, Object... args) {
        return upsert(tableName, columnNames, new String[] { uniqueColumn }, args);
    }

    /**
     * Upsert.
     *
     * @param tableName     the table name
     * @param columnNames   the column names
     * @param uniqueColumns the unique columns
     * @param args          the args
     * @return the int
     */
    int upsert(String tableName, String[] columnNames, String[] uniqueColumns, Object... args);

    /**
     * Upsert.
     *
     * @param tableName    the table name
     * @param uniqueColumn the unique column
     * @param params       the params
     * @return the int
     */
    default int upsert(String tableName, String uniqueColumn, Map<String, Object> params) {
        return upsert(tableName, new String[] { uniqueColumn }, params);
    }

    /**
     * Upsert.
     *
     * @param tableName     the table name
     * @param uniqueColumns the unique columns
     * @param params        the params
     * @return the int
     */
    default int upsert(String tableName, String[] uniqueColumns, Map<String, Object> params) {
        Object[] ps = new Object[params.size()];
        String[] columnNames = new String[params.size()];
        int i = 0;
        for (Entry<String, Object> e : params.entrySet()) {
            columnNames[i] = e.getKey();
            ps[i] = e.getValue();
            i++;
        }
        return upsert(tableName, columnNames, uniqueColumns, ps);
    }
}