package cn.featherfly.hammer.sqldb.jdbc;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import cn.featherfly.common.bean.BeanPropertyValue;
import cn.featherfly.common.db.dialect.Dialect;
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
     * @param <T>       the generic type
     * @param sql       sql
     * @param batchSize the batch size
     * @param args      args
     * @return map list
     */
    <T extends Serializable> int updateBatch(String sql, int batchSize, Object... args);

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
     * @param <T>         generic type
     * @param sql         sql
     * @param elementType return object type
     * @param args        args
     * @return single elementType object
     */
    <T> T queryUnique(String sql, Class<T> elementType, Object... args);

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
    Integer queryInt(String sql, Object... args);

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
    Long queryLong(String sql, Object... args);

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
    BigDecimal queryBigDecimal(String sql, Object... args);

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
    Double queryDouble(String sql, Object... args);

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
    String queryString(String sql, Object... args);

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

}