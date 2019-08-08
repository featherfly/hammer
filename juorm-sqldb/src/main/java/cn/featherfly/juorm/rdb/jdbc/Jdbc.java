
package cn.featherfly.juorm.rdb.jdbc;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.ConnectionCallback;

import cn.featherfly.juorm.mapping.RowMapper;
import cn.featherfly.juorm.rdb.sql.dialect.Dialect;

/**
 * <p>
 * Jdbc
 * </p>
 *
 * @author zhongj
 */
public interface Jdbc {

    /**
     * @return DataSource
     */
    DataSource getDataSource();

    /**
     * 返回dialect
     *
     * @return dialect
     */
    Dialect getDialect();

    /**
     * @param sql
     * @param args
     * @return
     * @see org.springframework.jdbc.core.JdbcTemplate#update(java.lang.String,
     *      java.lang.Object[])
     */
    int update(String sql, Object... args);

    /**
     * @param <T>
     * @param action
     * @return
     * @see org.springframework.jdbc.core.JdbcTemplate#execute(org.springframework.jdbc.core.ConnectionCallback)
     */
    <T> T execute(ConnectionCallback<T> action);

    /**
     * @param <T>       generic type
     * @param sql       sql
     * @param args      args
     * @param rowMapper rowMapper
     * @return elementType object list
     */
    <T> List<T> query(String sql, Object[] args, RowMapper<T> rowMapper);

    /**
     * @param <T>         generic type
     * @param sql         sql
     * @param args        args
     * @param elementType return object type
     * @return elementType object list
     */
    <T> List<T> queryList(String sql, Object[] args, Class<T> elementType);

    /**
     * @param <T>         generic type
     * @param sql         sql
     * @param args        args
     * @param elementType return object type
     * @return elementType object list
     */
    <T> List<T> queryList(String sql, Map<String, Object> args, Class<T> elementType);

    /**
     * @param <T>       generic type
     * @param sql       sql
     * @param args      args
     * @param rowMapper rowMapper
     * @return single elementType object
     */
    <T> T querySingle(String sql, Object[] args, RowMapper<T> rowMapper);

    /**
     * @param <T>       generic type
     * @param sql       sql
     * @param args      args
     * @param rowMapper rowMapper
     * @return single elementType object
     */
    <T> T querySingle(String sql, Map<String, Object> args, RowMapper<T> rowMapper);

    /**
     * @param <T>         generic type
     * @param sql         sql
     * @param args        args
     * @param elementType return object type
     * @return elementType object list
     */
    <T> T querySingle(String sql, Map<String, Object> args, Class<T> elementType);

    /**
     * @param <T>         generic type
     * @param sql         sql
     * @param args        args
     * @param elementType return object type
     * @return single elementType object
     */
    <T> T querySingle(String sql, Object[] args, Class<T> elementType);

    Integer queryInt(String sql, Object[] args);

    Integer queryInt(String sql, Map<String, Object> args);

    Long queryLong(String sql, Object[] args);

    Long queryLong(String sql, Map<String, Object> args);

    BigDecimal queryBigDecimal(String sql, Object[] args);

    BigDecimal queryBigDecimal(String sql, Map<String, Object> args);

    Double queryDouble(String sql, Object[] args);

    Double queryDouble(String sql, Map<String, Object> args);

    String queryString(String sql, Object[] args);

    String queryString(String sql, Map<String, Object> args);

    <T> T queryValue(String sql, Object[] args, Class<T> valueType);

    <T> T queryValue(String sql, Map<String, Object> args, Class<T> valueType);

}