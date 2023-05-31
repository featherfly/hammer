
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

import cn.featherfly.common.repository.mapping.RowMapper;

/**
 * The Interface JdbcQueryValue.
 *
 * @author zhongj
 */
public interface JdbcQueryValue {

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

}
