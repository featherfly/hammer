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

import cn.featherfly.common.bean.PropertyAccessorFactory;
import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.tuple.Tuple2;
import cn.featherfly.common.tuple.Tuple3;
import cn.featherfly.common.tuple.Tuple4;
import cn.featherfly.common.tuple.Tuple5;
import cn.featherfly.common.tuple.Tuple6;

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

    /**
     * Gets the property accessor factory.
     *
     * @return the property accessor factory
     */
    PropertyAccessorFactory getPropertyAccessorFactory();

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
     * Creates the row mapper.
     *
     * @param <T> the generic type
     * @param type the type
     * @param prefix the prefix
     * @return the row mapper
     */
    <T> RowMapper<T> createRowMapper(Class<T> type, String prefix);

    /**
     * Creates the row mapper.
     *
     * @param <T> the generic type
     * @param type the type
     * @return the row mapper
     */
    <T> RowMapper<T> createRowMapper(Class<T> type);

    /**
     * Creates the row mapper.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @param prefixes the prefixes
     * @return the row mapper
     */
    <T1, T2> RowMapper<Tuple2<T1, T2>> createRowMapper(Class<T1> type1, Class<T2> type2,
        Tuple2<String, String> prefixes);

    /**
     * Creates the row mapper.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @param prefixes the prefixes
     * @return the row mapper
     */
    <T1, T2, T3> RowMapper<Tuple3<T1, T2, T3>> createRowMapper(Class<T1> type1, Class<T2> type2, Class<T3> type3,
        Tuple3<String, String, String> prefixes);

    /**
     * Creates the row mapper.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param <T4> the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @param type4 the type 4
     * @param prefixes the prefixes
     * @return the row mapper
     */
    <T1, T2, T3, T4> RowMapper<Tuple4<T1, T2, T3, T4>> createRowMapper(Class<T1> type1, Class<T2> type2,
        Class<T3> type3, Class<T4> type4, Tuple4<String, String, String, String> prefixes);

    /**
     * Creates the row mapper.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param <T4> the generic type
     * @param <T5> the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @param type4 the type 4
     * @param type5 the type 5
     * @param prefixes the prefixes
     * @return the row mapper
     */
    <T1, T2, T3, T4, T5> RowMapper<Tuple5<T1, T2, T3, T4, T5>> createRowMapper(Class<T1> type1, Class<T2> type2,
        Class<T3> type3, Class<T4> type4, Class<T5> type5, Tuple5<String, String, String, String, String> prefixes);

    /**
     * Creates the row mapper.
     *
     * @param <T1> the generic type
     * @param <T2> the generic type
     * @param <T3> the generic type
     * @param <T4> the generic type
     * @param <T5> the generic type
     * @param <T6> the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @param type4 the type 4
     * @param type5 the type 5
     * @param type6 the type 6
     * @param prefixes the prefixes
     * @return the row mapper
     */
    <T1, T2, T3, T4, T5, T6> RowMapper<Tuple6<T1, T2, T3, T4, T5, T6>> createRowMapper(Class<T1> type1, Class<T2> type2,
        Class<T3> type3, Class<T4> type4, Class<T5> type5, Class<T6> type6,
        Tuple6<String, String, String, String, String, String> prefixes);

    /**
     * Execute.
     *
     * @param <T> the generic type
     * @param callback the callback
     * @return the int
     */
    <T> T execute(ConnectionCallback<T> callback);

    /**
     * Insert.
     *
     * @param tableName the table name
     * @param columnNames the column names
     * @param args the args
     * @return insert row count
     */
    default int insert(String tableName, String[] columnNames, Serializable... args) {
        return insert(tableName, columnNames, null, args);
    }

    /**
     * Insert.
     *
     * @param <T> the generic type
     * @param tableName the table name
     * @param columnNames the column names
     * @param keyHolder the key holder
     * @param args the args
     * @return insert row count
     */
    <T extends Serializable> int insert(String tableName, String[] columnNames, GeneratedKeyHolder<T> keyHolder,
        Serializable... args);

    /**
     * Insert.
     *
     * @param tableName the table name
     * @param columnParams the column params
     * @return insert row count
     */
    default int insert(String tableName, Map<String, Serializable> columnParams) {
        return insert(tableName, columnParams, null);
    }

    /**
     * Insert.
     *
     * @param <T> the generic type
     * @param tableName the table name
     * @param columnParams the column params
     * @param keyHolder the key holder
     * @return insert row count
     */
    default <T extends Serializable> int insert(String tableName, Map<String, Serializable> columnParams,
        GeneratedKeyHolder<T> keyHolder) {
        int i = 0;
        String[] columns = new String[columnParams.size()];
        Serializable[] params = new Serializable[columnParams.size()];
        for (Map.Entry<String, Serializable> entry : columnParams.entrySet()) {
            columns[i] = entry.getKey();
            params[i] = entry.getValue();
            i++;
        }
        return insert(tableName, columns, keyHolder, params);
    }

    /**
     * Insert batch.
     *
     * @param tableName the table name
     * @param columnNames the column names
     * @param args the args
     * @return insert row count
     */
    default int insertBatch(String tableName, String[] columnNames, Serializable[]... args) {
        return insertBatch(tableName, columnNames, args.length, args);
    }

    /**
     * Insert batch.
     *
     * @param tableName the table name
     * @param columnNames the column names
     * @param batchSize the batch size
     * @param args the args
     * @return insert row count
     */
    int insertBatch(String tableName, String[] columnNames, int batchSize, Serializable[]... args);

    /**
     * Insert batch.
     *
     * @param tableName the table name
     * @param columnNames the column names
     * @param args the args
     * @return insert row count
     */
    default int insertBatch(String tableName, String[] columnNames, Serializable... args) {
        if (args.length % columnNames.length != 0) {
            throw new JdbcException("batch size is not explicit (args.length % columnNames.length != 0)");
        }
        return insertBatch(tableName, columnNames, args.length / columnNames.length, args);
    }

    /**
     * Insert batch.
     *
     * @param tableName the table name
     * @param columnParams the column params
     * @return insert row count
     */
    default int insertBatch(String tableName, List<Map<String, Serializable>> columnParams) {
        if (Lang.isEmpty(columnParams)) {
            return 0;
        }
        return insertBatch(tableName, columnParams, columnParams.size());
    }

    /**
     * Insert batch.
     *
     * @param tableName the table name
     * @param columnParams the column params
     * @param batchSize the batch size
     * @return insert row count
     */
    int insertBatch(String tableName, List<Map<String, Serializable>> columnParams, int batchSize);

    //    default int insertBatch(String tableName, List<Map<String, Serializable>> columnParams, int batchSize) {
    //        if (Lang.isEmpty(columnParams)) {
    //            return 0;
    //        }
    //
    //        int columnLen = columnParams.get(0).size();
    //        int paramLen = columnLen * columnParams.size();
    //        String[] columns = new String[columnLen];
    //        Serializable[] params = new Serializable[paramLen];
    //
    //        Lang.each(columnParams.get(0).entrySet(), (entry, index) -> {
    //            columns[index] = entry.getKey();
    //        });
    //
    //        int i = 0;
    //        for (Map<String, Serializable> cp : columnParams) {
    //            for (Map.Entry<String, Serializable> entry : cp.entrySet()) {
    //                params[i] = entry.getValue();
    //                i++;
    //            }
    //        }
    //
    //        return insertBatch(tableName, columns, columnParams.size(), params);
    //    }

    /**
     * Insert batch.
     *
     * @param tableName the table name
     * @param columnNames the column names
     * @param batchSize the batch size
     * @param args the args
     * @return insert row count
     */
    int insertBatch(String tableName, String[] columnNames, int batchSize, Serializable... args);

    /**
     * Upsert.
     *
     * @param tableName the table name
     * @param columnNames the column names
     * @param uniqueColumn the unique column
     * @param args the args
     * @return the int
     */
    default int upsert(String tableName, String[] columnNames, String uniqueColumn, Serializable... args) {
        return upsert(tableName, columnNames, new String[] { uniqueColumn }, args);
    }

    /**
     * Upsert.
     *
     * @param tableName the table name
     * @param columnNames the column names
     * @param uniqueColumns the unique columns
     * @param args the args
     * @return the int
     */
    int upsert(String tableName, String[] columnNames, String[] uniqueColumns, Serializable... args);

    /**
     * Upsert.
     *
     * @param tableName the table name
     * @param uniqueColumn the unique column
     * @param params the params
     * @return the int
     */
    default int upsert(String tableName, String uniqueColumn, Map<String, Serializable> params) {
        return upsert(tableName, new String[] { uniqueColumn }, params);
    }

    /**
     * Upsert.
     *
     * @param tableName the table name
     * @param uniqueColumns the unique columns
     * @param params the params
     * @return the int
     */
    default int upsert(String tableName, String[] uniqueColumns, Map<String, Serializable> params) {
        Serializable[] ps = new Serializable[params.size()];
        String[] columnNames = new String[params.size()];
        int i = 0;
        for (Entry<String, Serializable> e : params.entrySet()) {
            columnNames[i] = e.getKey();
            ps[i] = e.getValue();
            i++;
        }
        return upsert(tableName, columnNames, uniqueColumns, ps);
    }
}