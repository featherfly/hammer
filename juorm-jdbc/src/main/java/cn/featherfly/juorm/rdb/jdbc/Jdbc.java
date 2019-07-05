
package cn.featherfly.juorm.rdb.jdbc;

import java.math.BigDecimal;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cn.featherfly.juorm.rdb.Constants;
import cn.featherfly.juorm.rdb.sql.dialect.Dialect;

/**
 * <p>
 * Jdbc
 * </p>
 *
 * @author zhongj
 */
public class Jdbc {

    private JdbcTemplate jdbcTemplate;

    private Dialect dialect;

    /**
     *
     */
    public Jdbc() {
        super();
    }

    /**
     * @param jdbcTemplate
     * @param dialect
     */
    public Jdbc(DataSource dataSource, Dialect dialect) {
        super();
        jdbcTemplate = new JdbcTemplate(dataSource);
        this.dialect = dialect;
    }

    /**
     * @return DataSource
     */
    public DataSource getDataSource() {
        return jdbcTemplate.getDataSource();
    }

    //    /**
    //     * 返回jdbcTemplate
    //     *
    //     * @return jdbcTemplate
    //     */
    //    public JdbcTemplate getJdbcTemplate() {
    //        return jdbcTemplate;
    //    }

    /**
     * 设置jdbcTemplate
     *
     * @param jdbcTemplate jdbcTemplate
     */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 返回dialect
     *
     * @return dialect
     */
    public Dialect getDialect() {
        return dialect;
    }

    /**
     * 设置dialect
     *
     * @param dialect dialect
     */
    public void setDialect(Dialect dialect) {
        this.dialect = dialect;
    }

    /**
     * @param sql
     * @param args
     * @return
     * @throws DataAccessException
     * @see org.springframework.jdbc.core.JdbcTemplate#update(java.lang.String,
     *      java.lang.Object[])
     */
    public int update(String sql, Object... args) {
        return jdbcTemplate.update(sql, args);
    }

    /**
     * @param <T>
     * @param action
     * @return
     * @throws DataAccessException
     * @see org.springframework.jdbc.core.JdbcTemplate#execute(org.springframework.jdbc.core.ConnectionCallback)
     */
    public <T> T execute(ConnectionCallback<T> action) {
        return jdbcTemplate.execute(action);
    }

    /**
     * @param <T>
     * @param sql
     * @param args
     * @param rowMapper
     * @return
     * @throws DataAccessException
     * @see org.springframework.jdbc.core.JdbcTemplate#query(java.lang.String,
     *      java.lang.Object[], org.springframework.jdbc.core.RowMapper)
     */
    public <T> List<T> query(String sql, Object[] args, RowMapper<T> rowMapper) {
        return jdbcTemplate.query(sql, args, rowMapper);
    }

    /**
     * @param <T>
     * @param sql
     * @param args
     * @param elementType
     * @return
     * @throws DataAccessException
     * @see org.springframework.jdbc.core.JdbcTemplate#queryForList(java.lang.String,
     *      java.lang.Object[], java.lang.Class)
     */
    public <T> List<T> queryList(String sql, Object[] args, Class<T> elementType) {
        Constants.LOGGER.debug("queryList sql -> {}, args -> {}", sql, args);
        System.out.println(sql);
        return jdbcTemplate.queryForList(sql, args, elementType);
    }

    /**
     * @param <T>
     * @param sql
     * @param args
     * @param rowMapper
     * @return
     * @throws DataAccessException
     * @see org.springframework.jdbc.core.JdbcTemplate#queryForObject(java.lang.String,
     *      java.lang.Object[], org.springframework.jdbc.core.RowMapper)
     */
    public <T> T querySingle(String sql, Object[] args, RowMapper<T> rowMapper) {
        return jdbcTemplate.queryForObject(sql, args, rowMapper);
    }

    /**
     * @param <T>
     * @param sql
     * @param args
     * @param requiredType
     * @return
     * @throws DataAccessException
     * @see org.springframework.jdbc.core.JdbcTemplate#queryForObject(java.lang.String,
     *      java.lang.Object[], java.lang.Class)
     */
    public <T> T querySingle(String sql, Object[] args, Class<T> requiredType) {
        return jdbcTemplate.queryForObject(sql, args, requiredType);
    }

    public Integer queryInt(String sql, Object[] args) {
        return queryValue(sql, args, Integer.class);
    }

    public Long queryLong(String sql, Object[] args) {
        return queryValue(sql, args, Long.class);
    }

    public BigDecimal queryBigDecimal(String sql, Object[] args) {
        return queryValue(sql, args, BigDecimal.class);
    }

    public Double queryDouble(String sql, Object[] args) {

        return queryValue(sql, args, Double.class);
    }

    public String queryString(String sql, Object[] args) {
        return queryValue(sql, args, String.class);
    }

    public <T> T queryValue(String sql, Object[] args, Class<T> valueType) {
        return jdbcTemplate.queryForObject(sql, args, valueType);
    }

}
