
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

import java.math.BigDecimal;
import java.util.Map;

import cn.featherfly.common.db.NamedParamSql;
import cn.featherfly.common.repository.Execution;
import cn.featherfly.common.repository.mapping.RowMapper;

/**
 * jdbc query value.
 *
 * @author zhongj
 */
public interface JdbcQueryValue {

    /**
     * Query value.
     *
     * @param <T>  the generic type
     * @param sql  the sql
     * @param args the args
     * @return the t
     */
    <T> T queryValue(String sql, Object... args);

    /**
     * Query value.
     *
     * @param <T>  the generic type
     * @param sql  the sql
     * @param args the args
     * @return the t
     */
    <T> T queryValue(String sql, Map<String, Object> args);

    /**
     * Query value.
     *
     * @param <T>  the generic type
     * @param sql  the sql
     * @param args the args
     * @return the t
     */
    default <T> T queryValue(NamedParamSql sql, Map<String, Object> args) {
        Execution execution = sql.getExecution(args);
        return queryValue(execution.getExecution(), execution.getParams());
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

    //    /** IMPLSOON 后续来实现多个值得查询
    //     * Query value.
    //     *
    //     * @param <T1>       the generic type
    //     * @param <T2>       the generic type
    //     * @param sql        the sql
    //     * @param valueType1 the value type 1
    //     * @param valueType2 the value type 2
    //     * @param args       the args
    //     * @return the t
    //     */
    //    <T1, T2> Tuple2<T1, T2> queryValue(String sql, Class<T1> valueType1, Class<T2> valueType2, Object... args);

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
     * @param valueType the value type
     * @param args      the args
     * @return the t
     */
    default <T> T queryValue(NamedParamSql sql, Class<T> valueType, Map<String, Object> args) {
        Execution execution = sql.getExecution(args);
        return queryValue(execution.getExecution(), valueType, execution.getParams());
    }

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
     * Query value.
     *
     * @param <T>       the generic type
     * @param sql       the sql
     * @param rowMapper the row mapper
     * @param args      the args
     * @return the t
     */
    default <T> T queryValue(NamedParamSql sql, RowMapper<T> rowMapper, Map<String, Object> args) {
        Execution execution = sql.getExecution(args);
        return queryValue(execution.getExecution(), execution.getParams());
    }

    /**
     * query Integer.
     *
     * @param sql  the sql
     * @param args the args
     * @return the integer
     */
    default Integer queryInteger(String sql, Object... args) {
        return queryValue(sql, Integer.class, args);
    }

    /**
     * query Integer.
     *
     * @param sql  the sql
     * @param args the args
     * @return the integer
     */
    default Integer queryInteger(String sql, Map<String, Object> args) {
        return queryValue(sql, Integer.class, args);
    }

    /**
     * query Integer.
     *
     * @param sql  the sql
     * @param args the args
     * @return the integer
     */
    default Integer queryInteger(NamedParamSql sql, Map<String, Object> args) {
        return queryValue(sql, Integer.class, args);
    }

    /**
     * Query long.
     *
     * @param sql  the sql
     * @param args the args
     * @return LogicExpressionong
     */
    default Long queryLongWrapper(String sql, Object... args) {
        return queryValue(sql, Long.class, args);
    }

    /**
     * Query long.
     *
     * @param sql  the sql
     * @param args the args
     * @return LogicExpressionong
     */
    default Long queryLongWrapper(String sql, Map<String, Object> args) {
        return queryValue(sql, Long.class, args);
    }

    /**
     * Query long.
     *
     * @param sql  the sql
     * @param args the args
     * @return LogicExpressionong
     */
    default Long queryLongWrapper(NamedParamSql sql, Map<String, Object> args) {
        return queryValue(sql, Long.class, args);
    }

    /**
     * Query double.
     *
     * @param sql  the sql
     * @param args the args
     * @return the double
     */
    default Double queryDoubleWrapper(String sql, Object... args) {
        return queryValue(sql, Double.class, args);
    }

    /**
     * Query double.
     *
     * @param sql  the sql
     * @param args the args
     * @return the double
     */
    default Double queryDoubleWrapper(String sql, Map<String, Object> args) {
        return queryValue(sql, Double.class, args);
    }

    /**
     * Query double.
     *
     * @param sql  the sql
     * @param args the args
     * @return the double
     */
    default Double queryDoubleWrapper(NamedParamSql sql, Map<String, Object> args) {
        return queryValue(sql, Double.class, args);
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
     * Query big decimal.
     *
     * @param sql  the sql
     * @param args the args
     * @return the big decimal
     */
    default BigDecimal queryBigDecimal(NamedParamSql sql, Map<String, Object> args) {
        return queryValue(sql, BigDecimal.class, args);
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
     * Query string.
     *
     * @param sql  the sql
     * @param args the args
     * @return the string
     */
    default String queryString(NamedParamSql sql, Map<String, Object> args) {
        return queryValue(sql, String.class, args);
    }

    /**
     * Query bool.
     *
     * @param sql  the sql
     * @param args the args
     * @return true, if successful
     */
    boolean queryBool(String sql, Object... args);

    /**
     * Query bool.
     *
     * @param sql  the sql
     * @param args the args
     * @return true, if successful
     */
    boolean queryBool(String sql, Map<String, Object> args);

    /**
     * Query bool.
     *
     * @param sql  the sql
     * @param args the args
     * @return true, if successful
     */
    default boolean queryBool(NamedParamSql sql, Map<String, Object> args) {
        Execution execution = sql.getExecution(args);
        return queryBool(execution.getExecution(), execution.getParams());
    }

    /**
     * Query byte.
     *
     * @param sql  the sql
     * @param args the args
     * @return the byte
     */
    byte queryByte(String sql, Object... args);

    /**
     * Query byte.
     *
     * @param sql  the sql
     * @param args the args
     * @return the byte
     */
    byte queryByte(String sql, Map<String, Object> args);

    /**
     * Query byte.
     *
     * @param sql  the sql
     * @param args the args
     * @return the byte
     */
    default byte queryByte(NamedParamSql sql, Map<String, Object> args) {
        Execution execution = sql.getExecution(args);
        return queryByte(execution.getExecution(), execution.getParams());
    }

    /**
     * Query bytes.
     *
     * @param sql  the sql
     * @param args the args
     * @return the byte
     */
    byte[] queryBytes(String sql, Object... args);

    /**
     * Query bytes.
     *
     * @param sql  the sql
     * @param args the args
     * @return the byte
     */
    byte[] queryBytes(String sql, Map<String, Object> args);

    /**
     * Query bytes.
     *
     * @param sql  the sql
     * @param args the args
     * @return the byte
     */
    default byte[] queryBytes(NamedParamSql sql, Map<String, Object> args) {
        Execution execution = sql.getExecution(args);
        return queryBytes(execution.getExecution(), execution.getParams());
    }

    /**
     * Query short.
     *
     * @param sql  the sql
     * @param args the args
     * @return the short
     */
    short queryShort(String sql, Object... args);

    /**
     * Query short.
     *
     * @param sql  the sql
     * @param args the args
     * @return the short
     */
    short queryShort(String sql, Map<String, Object> args);

    /**
     * Query short.
     *
     * @param sql  the sql
     * @param args the args
     * @return the short
     */
    default short queryShort(NamedParamSql sql, Map<String, Object> args) {
        Execution execution = sql.getExecution(args);
        return queryShort(execution.getExecution(), execution.getParams());
    }

    /**
     * query int.
     *
     * @param sql  the sql
     * @param args the args
     * @return the int value
     */
    int queryInt(String sql, Object... args);

    /**
     * Query int.
     *
     * @param sql  the sql
     * @param args the args
     * @return the int value
     */
    int queryInt(String sql, Map<String, Object> args);

    /**
     * Query int.
     *
     * @param sql  the sql
     * @param args the args
     * @return the int value
     */
    default int queryInt(NamedParamSql sql, Map<String, Object> args) {
        Execution execution = sql.getExecution(args);
        return queryInt(execution.getExecution(), execution.getParams());
    }

    /**
     * query long.
     *
     * @param sql  the sql
     * @param args the args
     * @return LogicExpressionong value
     */
    long queryLong(String sql, Object... args);

    /**
     * query long.
     *
     * @param sql  the sql
     * @param args the args
     * @return LogicExpressionong value
     */
    long queryLong(String sql, Map<String, Object> args);

    /**
     * query long.
     *
     * @param sql  the sql
     * @param args the args
     * @return LogicExpressionong value
     */
    default long queryLong(NamedParamSql sql, Map<String, Object> args) {
        Execution execution = sql.getExecution(args);
        return queryLong(execution.getExecution(), execution.getParams());
    }

    /**
     * Query double.
     *
     * @param sql  the sql
     * @param args the args
     * @return the double
     */
    double queryDouble(String sql, Object... args);

    /**
     * Query double.
     *
     * @param sql  the sql
     * @param args the args
     * @return the double
     */
    double queryDouble(String sql, Map<String, Object> args);

    /**
     * Query double.
     *
     * @param sql  the sql
     * @param args the args
     * @return the double
     */
    default double queryDouble(NamedParamSql sql, Map<String, Object> args) {
        Execution execution = sql.getExecution(args);
        return queryDouble(execution.getExecution(), execution.getParams());
    }
}
