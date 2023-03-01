package cn.featherfly.hammer.sqldb.jdbc;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.sql.DataSource;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuple4;
import com.speedment.common.tuple.Tuple5;

import cn.featherfly.common.bean.BeanPropertyValue;
import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.repository.mapping.RowMapper;

/**
 * Jdbc.
 *
 * @author zhongj
 */
public interface Jdbc {

    /**
     * Gets the data source.
     *
     * @return DataSource
     */
    DataSource getDataSource();

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
        if (columnParams.size() == 0) {
            return 0;
        }
        int i = 0;
        int columnLen = columnParams.get(0).size();
        int paramLen = columnLen * columnParams.size();
        String[] columns = new String[columnLen];
        Object[] params = new Object[paramLen];
        for (Map.Entry<String, Object> entry : columnParams.get(0).entrySet()) {
            columns[i] = entry.getKey();
            i++;
        }

        i = 0;
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

    /**
     * Update.
     *
     * @param sql  the sql
     * @param args the args
     * @return the int
     */
    int update(String sql, Object... args);

    /**
     * Update.
     *
     * @param sql  the sql
     * @param args the args
     * @return the int
     */
    int update(String sql, BeanPropertyValue<?>... args);

    /**
     * Update.
     *
     * @param sql  the sql
     * @param args the args
     * @return the int
     */
    int update(String sql, Map<String, Object> args);

    /**
     * Update.
     *
     * @param <T>                the generic type
     * @param sql                sql
     * @param generatedKeyHolder the key supplier
     * @param args               args
     * @return map list
     */
    <T extends Serializable> int update(String sql, GeneratedKeyHolder<T> generatedKeyHolder, Object... args);

    /**
     * Update.
     *
     * @param <T>                the generic type
     * @param sql                the sql
     * @param generatedKeyHolder the generated key holder
     * @param args               the args
     * @return the int
     */
    <T extends Serializable> int update(String sql, GeneratedKeyHolder<T> generatedKeyHolder,
            BeanPropertyValue<?>... args);

    /**
     * Update.
     *
     * @param <T>                the generic type
     * @param sql                sql
     * @param generatedKeyHolder the key supplier
     * @param args               args
     * @return map list
     */
    <T extends Serializable> int update(String sql, GeneratedKeyHolder<T> generatedKeyHolder, Map<String, Object> args);

    /**
     * Update.
     *
     * @param <T>       the generic type
     * @param sql       sql
     * @param batchSize the batch size
     * @param args      args
     * @return map list
     */
    default <T extends Serializable> int updateBatch(String sql, int batchSize, Object... args) {
        return updateBatch(sql, batchSize, null, args);
    }

    /**
     * Update.
     *
     * @param sql       the sql
     * @param batchSize the batch size
     * @param args      the args
     * @return the int
     */
    default int updateBatch(String sql, int batchSize, Map<String, Object> args) {
        return updateBatch(sql, batchSize, null, args);
    }

    /**
     * Update.
     *
     * @param <T>                the generic type
     * @param sql                the sql
     * @param batchSize          the batch size
     * @param generatedKeyHolder the generated key holder
     * @param args               the args
     * @return the int
     */
    <T extends Serializable> int updateBatch(String sql, int batchSize, GeneratedKeyHolder<T> generatedKeyHolder,
            Map<String, Object> args);

    /**
     * Update.
     *
     * @param <T>                the generic type
     * @param sql                sql
     * @param batchSize          the batch size
     * @param generatedKeyHolder the key supplier
     * @param args               args
     * @return map list
     */
    <T extends Serializable> int updateBatch(String sql, int batchSize, GeneratedKeyHolder<T> generatedKeyHolder,
            Object... args);

    /**
     * Query.
     *
     * @param sql  sql
     * @param args args
     * @return map list
     */
    List<Map<String, Object>> query(String sql, Object... args);

    /**
     * Query.
     *
     * @param sql  sql
     * @param args args
     * @return map list
     */
    List<Map<String, Object>> query(String sql, Map<String, Object> args);

    /**
     * Query.
     *
     * @param <T>       generic type
     * @param sql       sql
     * @param rowMapper rowMapper
     * @param args      args
     * @return elementType object list
     */
    <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... args);

    //    /**
    //     * Query.
    //     *
    //     * @param <T>       the generic type
    //     * @param sql       the sql
    //     * @param rowMapper the row mapper
    //     * @param args      the args
    //     * @return the list
    //     */
    //    <T> List<T> query(String sql, RowMapper<T> rowMapper, BeanPropertyValue<?>... args);

    /**
     * Query.
     *
     * @param <T>         generic type
     * @param sql         sql
     * @param elementType return object type
     * @param args        args
     * @return elementType object list
     */
    <T> List<T> query(String sql, Class<T> elementType, Object... args);

    /**
     * Query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2> List<Tuple2<T1, T2>> query(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Tuple2<String, String> prefixes, Object... args);

    /**
     * Query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2, T3> List<Tuple3<T1, T2, T3>> query(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Tuple3<String, String, String> prefixes, Object... args);

    /**
     * Query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2, T3, T4> List<Tuple4<T1, T2, T3, T4>> query(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Class<T4> elementType4, Tuple4<String, String, String, String> prefixes,
            Object... args);

    /**
     * Query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param <T5>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2, T3, T4, T5> List<Tuple5<T1, T2, T3, T4, T5>> query(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
            Tuple5<String, String, String, String, String> prefixes, Object... args);

    //    /**
    //     * Query.
    //     *
    //     * @param <T>         the generic type
    //     * @param sql         the sql
    //     * @param elementType the element type
    //     * @param args        the args
    //     * @return the list
    //     */
    //    <T> List<T> query(String sql, Class<T> elementType, BeanPropertyValue<?>... args);

    /**
     * Query.
     *
     * @param <T>       generic type
     * @param sql       sql
     * @param rowMapper rowMapper
     * @param args      args
     * @return elementType object list
     */
    <T> List<T> query(String sql, RowMapper<T> rowMapper, Map<String, Object> args);

    /**
     * Query.
     *
     * @param <T>         generic type
     * @param sql         sql
     * @param elementType return object type
     * @param args        args
     * @return elementType object list
     */
    <T> List<T> query(String sql, Class<T> elementType, Map<String, Object> args);

    /**
     * Query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2> List<Tuple2<T1, T2>> query(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Tuple2<String, String> prefixes, Map<String, Object> args);

    /**
     * Query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2, T3> List<Tuple3<T1, T2, T3>> query(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Tuple3<String, String, String> prefixes, Map<String, Object> args);

    /**
     * Query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2, T3, T4> List<Tuple4<T1, T2, T3, T4>> query(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Class<T4> elementType4, Tuple4<String, String, String, String> prefixes,
            Map<String, Object> args);

    /**
     * Query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param <T5>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2, T3, T4, T5> List<Tuple5<T1, T2, T3, T4, T5>> query(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> args);

    /**
     * Query single.
     *
     * @param sql  sql
     * @param args args
     * @return map
     */
    Map<String, Object> querySingle(String sql, Map<String, Object> args);

    /**
     * Query single.
     *
     * @param sql  sql
     * @param args args
     * @return map
     */
    Map<String, Object> querySingle(String sql, Object... args);

    /**
     * Query single.
     *
     * @param <T>       generic type
     * @param sql       sql
     * @param rowMapper rowMapper
     * @param args      args
     * @return single elementType object
     */
    <T> T querySingle(String sql, RowMapper<T> rowMapper, Object... args);

    //    /**
    //     * Query single.
    //     *
    //     * @param <T>       the generic type
    //     * @param sql       the sql
    //     * @param rowMapper the row mapper
    //     * @param args      the args
    //     * @return the t
    //     */
    //    <T> T querySingle(String sql, RowMapper<T> rowMapper, BeanPropertyValue<?>... args);

    /**
     * Query single.
     *
     * @param <T>       generic type
     * @param sql       sql
     * @param rowMapper rowMapper
     * @param args      args
     * @return single elementType object
     */
    <T> T querySingle(String sql, RowMapper<T> rowMapper, Map<String, Object> args);

    /**
     * Query single.
     *
     * @param <T>         generic type
     * @param sql         sql
     * @param elementType return object type
     * @param args        args
     * @return element type object list
     */
    <T> T querySingle(String sql, Class<T> elementType, Map<String, Object> args);

    /**
     * Query single.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param prefixes     the prefixes of mapping element type
     * @param args         the args
     * @return the tuple 2
     */
    <T1, T2> Tuple2<T1, T2> querySingle(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Tuple2<String, String> prefixes, Map<String, Object> args);

    /**
     * Query single.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2, T3> Tuple3<T1, T2, T3> querySingle(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Tuple3<String, String, String> prefixes, Map<String, Object> args);

    /**
     * Query single.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> querySingle(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Class<T4> elementType4, Tuple4<String, String, String, String> prefixes,
            Map<String, Object> args);

    /**
     * Query single.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param <T5>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> querySingle(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> args);

    /**
     * Query single.
     *
     * @param <T>         generic type
     * @param sql         sql
     * @param elementType return object type
     * @param args        args
     * @return single elementType object
     */
    <T> T querySingle(String sql, Class<T> elementType, Object... args);

    //    /**
    //     * Query single.
    //     *
    //     * @param <T1>         the generic type
    //     * @param <T2>         the generic type
    //     * @param sql          the sql
    //     * @param elementType1 the element type 1
    //     * @param elementType2 the element type 2
    //     * @param args         the args
    //     * @return the tuple 2
    //     */
    //    <T1, T2> Tuple2<T1, T2> querySingle(String sql, Class<T1> elementType1, Class<T2> elementType2, Object... args);

    /**
     * Query single.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param prefixes     the prefixes of mapping element type
     * @param args         the args
     * @return the tuple 2
     */
    <T1, T2> Tuple2<T1, T2> querySingle(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Tuple2<String, String> prefixes, Object... args);

    /**
     * Query single.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2, T3> Tuple3<T1, T2, T3> querySingle(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Tuple3<String, String, String> prefixes, Object... args);

    /**
     * Query single.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> querySingle(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Class<T4> elementType4, Tuple4<String, String, String, String> prefixes,
            Object... args);

    /**
     * Query single.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param <T5>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> querySingle(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
            Tuple5<String, String, String, String, String> prefixes, Object... args);

    //    /**
    //     * Query single.
    //     *
    //     * @param <T>         the generic type
    //     * @param sql         the sql
    //     * @param elementType the element type
    //     * @param args        the args
    //     * @return the t
    //     */
    //    <T> T querySingle(String sql, Class<T> elementType, BeanPropertyValue<?>... args);

    /**
     * Query unique.
     *
     * @param sql  sql
     * @param args args
     * @return map
     */
    Map<String, Object> queryUnique(String sql, Map<String, Object> args);

    /**
     * Query unique.
     *
     * @param sql  sql
     * @param args args
     * @return map
     */
    Map<String, Object> queryUnique(String sql, Object... args);

    /**
     * Query unique.
     *
     * @param <T>       generic type
     * @param sql       sql
     * @param rowMapper rowMapper
     * @param args      args
     * @return single elementType object
     */
    <T> T queryUnique(String sql, RowMapper<T> rowMapper, Object... args);

    //    /**
    //     * Query unique.
    //     *
    //     * @param <T>       the generic type
    //     * @param sql       the sql
    //     * @param rowMapper the row mapper
    //     * @param args      the args
    //     * @return the t
    //     */
    //    <T> T queryUnique(String sql, RowMapper<T> rowMapper, BeanPropertyValue<?>... args);

    /**
     * Query unique.
     *
     * @param <T>       generic type
     * @param sql       sql
     * @param rowMapper rowMapper
     * @param args      args
     * @return single elementType object
     */
    <T> T queryUnique(String sql, RowMapper<T> rowMapper, Map<String, Object> args);

    /**
     * Query unique.
     *
     * @param <T>         generic type
     * @param sql         sql
     * @param elementType return object type
     * @param args        args
     * @return element type object list
     */
    <T> T queryUnique(String sql, Class<T> elementType, Map<String, Object> args);

    /**
     * Query unique.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param prefixes     the prefixes of mapping element type
     * @param args         the args
     * @return the tuple 2
     */
    <T1, T2> Tuple2<T1, T2> queryUnique(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Tuple2<String, String> prefixes, Map<String, Object> args);

    /**
     * Query unique.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2, T3> Tuple3<T1, T2, T3> queryUnique(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Tuple3<String, String, String> prefixes, Map<String, Object> args);

    /**
     * Query unique.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> queryUnique(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Class<T4> elementType4, Tuple4<String, String, String, String> prefixes,
            Map<String, Object> args);

    /**
     * Query unique.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param <T5>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> queryUnique(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
            Tuple5<String, String, String, String, String> prefixes, Map<String, Object> args);

    /**
     * Query unique.
     *
     * @param <T>         generic type
     * @param sql         sql
     * @param elementType return object type
     * @param args        args
     * @return single elementType object
     */
    <T> T queryUnique(String sql, Class<T> elementType, Object... args);

    /**
     * Query unique.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param prefixes     the prefixes of mapping element type
     * @param args         the args
     * @return the tuple 2
     */
    <T1, T2> Tuple2<T1, T2> queryUnique(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Tuple2<String, String> prefixes, Object... args);

    /**
     * Query unique.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2, T3> Tuple3<T1, T2, T3> queryUnique(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Tuple3<String, String, String> prefixes, Object... args);

    /**
     * Query unique.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> queryUnique(String sql, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Class<T4> elementType4, Tuple4<String, String, String, String> prefixes,
            Object... args);

    /**
     * Query unique.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param <T5>         the generic type
     * @param sql          the sql
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> queryUnique(String sql, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
            Tuple5<String, String, String, String, String> prefixes, Object... args);

    //    /**
    //     * Query unique.
    //     *
    //     * @param <T>         the generic type
    //     * @param sql         the sql
    //     * @param elementType the element type
    //     * @param args        the args
    //     * @return the t
    //     */
    //    <T> T queryUnique(String sql, Class<T> elementType, BeanPropertyValue<?>... args);

    /**
     * queryInt.
     *
     * @param sql  the sql
     * @param args the args
     * @return the integer
     */
    default Integer queryInt(String sql, Object... args) {
        return queryValue(sql, Integer.class, args);
    }

    /**
     * Query int.
     *
     * @param sql  the sql
     * @param args the args
     * @return the integer
     */
    default Integer queryInt(String sql, Map<String, Object> args) {
        return queryValue(sql, Integer.class, args);
    }

    /**
     * Query long.
     *
     * @param sql  the sql
     * @param args the args
     * @return the long
     */
    default Long queryLong(String sql, Object... args) {
        return queryValue(sql, Long.class, args);
    }

    /**
     * Query long.
     *
     * @param sql  the sql
     * @param args the args
     * @return the long
     */
    default Long queryLong(String sql, Map<String, Object> args) {
        return queryValue(sql, Long.class, args);
    }

    /**
     * Query big decimal.
     *
     * @param sql  the sql
     * @param args the args
     * @return the big decimal
     */
    default BigDecimal queryBigDecimal(String sql, Object... args) {
        return queryValue(sql, BigDecimal.class, args);
    }

    /**
     * Query big decimal.
     *
     * @param sql  the sql
     * @param args the args
     * @return the big decimal
     */
    default BigDecimal queryBigDecimal(String sql, Map<String, Object> args) {
        return queryValue(sql, BigDecimal.class, args);
    }

    /**
     * Query double.
     *
     * @param sql  the sql
     * @param args the args
     * @return the double
     */
    default Double queryDouble(String sql, Object... args) {
        return queryValue(sql, Double.class, args);
    }

    /**
     * Query double.
     *
     * @param sql  the sql
     * @param args the args
     * @return the double
     */
    default Double queryDouble(String sql, Map<String, Object> args) {
        return queryValue(sql, Double.class, args);
    }

    /**
     * Query string.
     *
     * @param sql  the sql
     * @param args the args
     * @return the string
     */
    default String queryString(String sql, Object... args) {
        return queryValue(sql, String.class, args);
    }

    /**
     * Query string.
     *
     * @param sql  the sql
     * @param args the args
     * @return the string
     */
    default String queryString(String sql, Map<String, Object> args) {
        return queryValue(sql, String.class, args);
    }

    /**
     * Query value.
     *
     * @param <T>       the generic type
     * @param sql       the sql
     * @param valueType the value type
     * @param args      the args
     * @return the t
     */
    <T> T queryValue(String sql, Class<T> valueType, Object... args);

    /**
     * Query value.
     *
     * @param <T>       the generic type
     * @param sql       the sql
     * @param valueType the value type
     * @param args      the args
     * @return the t
     */
    <T> T queryValue(String sql, Class<T> valueType, Map<String, Object> args);

    /**
     * Query value.
     *
     * @param <T>       the generic type
     * @param sql       the sql
     * @param rowMapper the row mapper
     * @param args      the args
     * @return the t
     */
    <T> T queryValue(String sql, RowMapper<T> rowMapper, Object... args);

    /**
     * Query value.
     *
     * @param <T>       the generic type
     * @param sql       the sql
     * @param rowMapper the row mapper
     * @param args      the args
     * @return the t
     */
    <T> T queryValue(String sql, RowMapper<T> rowMapper, Map<String, Object> args);

    /**
     * call procedure .
     *
     * @param name the procedure name
     * @param args the args
     * @return the list
     */
    int call(String name, Object... args);

    //    /**
    //     * call procedure .
    //     *
    //     * @param name the procedure name
    //     * @param args the args
    //     * @return the list
    //     */
    //    int call(String name, Map<String, Object> args);

    /**
     * call procedure query.
     *
     * @param name the procedure name
     * @param args the args
     * @return the list
     */
    List<Map<String, Object>> callQuery(String name, Object... args);

    /**
     * call procedure query.
     *
     * @param <E>    the element type
     * @param name   the procedure name
     * @param mapper the mapper
     * @param args   the args
     * @return the list
     */
    <E> List<E> callQuery(String name, RowMapper<E> mapper, Object... args);

    /**
     * call procedure query.
     *
     * @param <T>         the generic type
     * @param name        the procedure name
     * @param elementType the element type
     * @param args        the args
     * @return the list
     */
    <T> List<T> callQuery(String name, Class<T> elementType, Object... args);

    /**
     * call procedure query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param name         the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2> List<Tuple2<T1, T2>> callQuery(String name, Class<T1> elementType1, Class<T2> elementType2,
            Tuple2<String, String> prefixes, Object... args);

    /**
     * call procedure query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param name         the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2, T3> List<Tuple3<T1, T2, T3>> callQuery(String name, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Tuple3<String, String, String> prefixes, Object... args);

    /**
     * call procedure query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param name         the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2, T3, T4> List<Tuple4<T1, T2, T3, T4>> callQuery(String name, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Class<T4> elementType4, Tuple4<String, String, String, String> prefixes,
            Object... args);

    /**
     * call procedure query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param <T5>         the generic type
     * @param name         the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the list
     */
    <T1, T2, T3, T4, T5> List<Tuple5<T1, T2, T3, T4, T5>> callQuery(String name, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
            Tuple5<String, String, String, String, String> prefixes, Object... args);

    /**
     * call procedure query.
     *
     * @param name the procedure name
     * @param args the args
     * @return the list
     */
    Map<String, Object> callQuerySingle(String name, Object... args);

    /**
     * call procedure query.
     *
     * @param <E>    the element type
     * @param name   the procedure name
     * @param mapper the mapper
     * @param args   the args
     * @return the list
     */
    <E> E callQuerySingle(String name, RowMapper<E> mapper, Object... args);

    /**
     * call procedure query.
     *
     * @param <T>         the generic type
     * @param name        the procedure name
     * @param elementType the element type
     * @param args        the args
     * @return the t
     */
    <T> T callQuerySingle(String name, Class<T> elementType, Object... args);

    /**
     * call procedure query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param name         the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the tuple 2
     */
    <T1, T2> Tuple2<T1, T2> callQuerySingle(String name, Class<T1> elementType1, Class<T2> elementType2,
            Tuple2<String, String> prefixes, Object... args);

    /**
     * call procedure query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param name         the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the tuple 3
     */
    <T1, T2, T3> Tuple3<T1, T2, T3> callQuerySingle(String name, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Tuple3<String, String, String> prefixes, Object... args);

    /**
     * call procedure query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param name         the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the tuple 4
     */
    <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> callQuerySingle(String name, Class<T1> elementType1, Class<T2> elementType2,
            Class<T3> elementType3, Class<T4> elementType4, Tuple4<String, String, String, String> prefixes,
            Object... args);

    /**
     * call procedure query.
     *
     * @param <T1>         the generic type
     * @param <T2>         the generic type
     * @param <T3>         the generic type
     * @param <T4>         the generic type
     * @param <T5>         the generic type
     * @param name         the procedure name
     * @param elementType1 the element type 1
     * @param elementType2 the element type 2
     * @param elementType3 the element type 3
     * @param elementType4 the element type 4
     * @param elementType5 the element type 5
     * @param prefixes     the prefixes
     * @param args         the args
     * @return the tuple 5
     */
    <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> callQuerySingle(String name, Class<T1> elementType1,
            Class<T2> elementType2, Class<T3> elementType3, Class<T4> elementType4, Class<T5> elementType5,
            Tuple5<String, String, String, String, String> prefixes, Object... args);
}