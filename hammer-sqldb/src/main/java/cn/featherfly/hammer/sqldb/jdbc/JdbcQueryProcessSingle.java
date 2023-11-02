
/*
 * All rights Reserved, Designed By zhongj
 * @Title: JdbcQuery.java
 * @Package cn.featherfly.hammer.sqldb.jdbc
 * @Description: JdbcQuery
 * @author: zhongj
 * @date: 2023-07-10 16:15:10
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc;

import java.sql.ResultSet;
import java.util.Map;
import java.util.function.ToIntBiFunction;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.repository.mapping.RowMapper;

/**
 * The Interface JdbcQueryUpdateSingle.
 *
 * @since 0.7.0
 * @author zhongj
 */
public interface JdbcQueryProcessSingle {

    /**
     * Query single, then process.
     *
     * @param sql              sql
     * @param setValueOperator the set value operator
     * @param args             args
     * @return tuple2 of updated value map and effective row number
     */
    Tuple2<Map<String, Object>, Integer> queryProcessSingle(String sql,
            ToIntBiFunction<ResultSet, Map<String, Object>> setValueOperator, Map<String, Object> args);

    /**
     * Query single, then update.
     *
     * @param sql              sql
     * @param setValueOperator the set value operator
     * @param args             args
     * @return tuple2 of updated value map and effective row number
     */
    Tuple2<Map<String, Object>, Integer> querySingleUpdate(String sql,
            ToIntBiFunction<ResultSet, Map<String, Object>> setValueOperator, Object... args);

    /**
     * Query single, then update.
     *
     * @param <T>              generic type
     * @param sql              sql
     * @param rowMapper        rowMapper
     * @param setValueOperator the set value operator
     * @param args             args
     * @return tuple2 of updated value object and effective row number
     */
    <T> Tuple2<T, Integer> querySingleUpdate(String sql, RowMapper<T> rowMapper,
            ToIntBiFunction<ResultSet, T> setValueOperator, Object... args);

    /**
     * Query single, then update.
     *
     * @param <T>              generic type
     * @param sql              sql
     * @param rowMapper        rowMapper
     * @param setValueOperator the set value operator
     * @param args             args
     * @return tuple2 of updated value object and effective row number
     */
    <T> Tuple2<T, Integer> querySingleUpdate(String sql, RowMapper<T> rowMapper,
            ToIntBiFunction<ResultSet, T> setValueOperator, Map<String, Object> args);

    /**
     * Query single, then update.
     *
     * @param <T>              generic type
     * @param sql              sql
     * @param elementType      return object type
     * @param setValueOperator the set value operator
     * @param args             args
     * @return tuple2 of updated value object and effective row number
     */
    <T> Tuple2<T, Integer> querySingleUpdate(String sql, Class<T> elementType,
            ToIntBiFunction<ResultSet, T> setValueOperator, Map<String, Object> args);

    /**
     * Query single, then update.
     *
     * @param <T>              generic type
     * @param sql              sql
     * @param elementType      return object type
     * @param setValueOperator the set value operator
     * @param args             args
     * @return tuple2 of updated value object and effective row number
     */
    <T> Tuple2<T, Integer> querySingleUpdate(String sql, Class<T> elementType,
            ToIntBiFunction<ResultSet, T> setValueOperator, Object... args);
}
