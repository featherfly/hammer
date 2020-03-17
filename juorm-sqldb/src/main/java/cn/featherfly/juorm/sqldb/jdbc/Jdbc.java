
package cn.featherfly.juorm.sqldb.jdbc;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import cn.featherfly.juorm.mapping.RowMapper;
import cn.featherfly.juorm.sqldb.sql.dialect.Dialect;

/**
 * <p>
 * Jdbc
 * </p>
 * .
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
     * Update.
     *
     * @param sql  the sql
     * @param args the args
     * @return the int
     */
    int update(String sql, Object... args);

    /**
     * Execute.
     *
     * @param <T>    the generic type
     * @param action the action
     * @return the t
     */
    <T> T execute(ConnectionCallback<T> action);

    /**
     * Query.
     *
     * @param sql  sql
     * @param args args
     * @return map list
     */
    List<Map<String, Object>> query(String sql, Object[] args);

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
     * @param args      args
     * @param rowMapper rowMapper
     * @return elementType object list
     */
    <T> List<T> query(String sql, Object[] args, RowMapper<T> rowMapper);

    /**
     * Query.
     *
     * @param <T>         generic type
     * @param sql         sql
     * @param args        args
     * @param elementType return object type
     * @return elementType object list
     */
    <T> List<T> query(String sql, Object[] args, Class<T> elementType);

    /**
     * Query.
     *
     * @param <T>       generic type
     * @param sql       sql
     * @param args      args
     * @param rowMapper rowMapper
     * @return elementType object list
     */
    <T> List<T> query(String sql, Map<String, Object> args, RowMapper<T> rowMapper);

    /**
     * Query.
     *
     * @param <T>         generic type
     * @param sql         sql
     * @param args        args
     * @param elementType return object type
     * @return elementType object list
     */
    <T> List<T> query(String sql, Map<String, Object> args, Class<T> elementType);

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
    Map<String, Object> querySingle(String sql, Object[] args);

    /**
     * Query single.
     *
     * @param <T>       generic type
     * @param sql       sql
     * @param args      args
     * @param rowMapper rowMapper
     * @return single elementType object
     */
    <T> T querySingle(String sql, Object[] args, RowMapper<T> rowMapper);

    /**
     * Query single.
     *
     * @param <T>       generic type
     * @param sql       sql
     * @param args      args
     * @param rowMapper rowMapper
     * @return single elementType object
     */
    <T> T querySingle(String sql, Map<String, Object> args, RowMapper<T> rowMapper);

    /**
     * Query single.
     *
     * @param <T>         generic type
     * @param sql         sql
     * @param args        args
     * @param elementType return object type
     * @return element type object list
     */
    <T> T querySingle(String sql, Map<String, Object> args, Class<T> elementType);

    /**
     * Query single.
     *
     * @param <T>         generic type
     * @param sql         sql
     * @param args        args
     * @param elementType return object type
     * @return single elementType object
     */
    <T> T querySingle(String sql, Object[] args, Class<T> elementType);

    /**
     * queryInt.
     *
     * @param sql  the sql
     * @param args the args
     * @return the integer
     */
    Integer queryInt(String sql, Object[] args);

    /**
     * Query int.
     *
     * @param sql  the sql
     * @param args the args
     * @return the integer
     */
    Integer queryInt(String sql, Map<String, Object> args);

    /**
     * Query long.
     *
     * @param sql  the sql
     * @param args the args
     * @return the long
     */
    Long queryLong(String sql, Object[] args);

    /**
     * Query long.
     *
     * @param sql  the sql
     * @param args the args
     * @return the long
     */
    Long queryLong(String sql, Map<String, Object> args);

    /**
     * Query big decimal.
     *
     * @param sql  the sql
     * @param args the args
     * @return the big decimal
     */
    BigDecimal queryBigDecimal(String sql, Object[] args);

    /**
     * Query big decimal.
     *
     * @param sql  the sql
     * @param args the args
     * @return the big decimal
     */
    BigDecimal queryBigDecimal(String sql, Map<String, Object> args);

    /**
     * Query double.
     *
     * @param sql  the sql
     * @param args the args
     * @return the double
     */
    Double queryDouble(String sql, Object[] args);

    /**
     * Query double.
     *
     * @param sql  the sql
     * @param args the args
     * @return the double
     */
    Double queryDouble(String sql, Map<String, Object> args);

    /**
     * Query string.
     *
     * @param sql  the sql
     * @param args the args
     * @return the string
     */
    String queryString(String sql, Object[] args);

    /**
     * Query string.
     *
     * @param sql  the sql
     * @param args the args
     * @return the string
     */
    String queryString(String sql, Map<String, Object> args);

    /**
     * Query value.
     *
     * @param <T>       the generic type
     * @param sql       the sql
     * @param args      the args
     * @param valueType the value type
     * @return the t
     */
    <T> T queryValue(String sql, Object[] args, Class<T> valueType);

    /**
     * Query value.
     *
     * @param <T>       the generic type
     * @param sql       the sql
     * @param args      the args
     * @param valueType the value type
     * @return the t
     */
    <T> T queryValue(String sql, Map<String, Object> args, Class<T> valueType);

}