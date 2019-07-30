
package cn.featherfly.juorm.rdb.jdbc;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import cn.featherfly.juorm.rdb.Constants;
import cn.featherfly.juorm.rdb.sql.dialect.Dialect;

/**
 * <p>
 * Jdbc
 * </p>
 *
 * @author zhongj
 */
public class SpringJdbcTemplateImpl implements Jdbc {

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private DataSource dataSource;

    private Dialect dialect;

    /**
     *
     */
    public SpringJdbcTemplateImpl() {
        super();
    }

    /**
     * @param jdbcTemplate
     * @param dialect
     */
    public SpringJdbcTemplateImpl(DataSource dataSource, Dialect dialect) {
        super();
        setDataSource(dataSource);
        this.dialect = dialect;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T execute(ConnectionCallback<T> action) {
        return jdbcTemplate.execute(action);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Dialect getDialect() {
        return dialect;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> query(String sql, Object[] args, RowMapper<T> rowMapper) {
        Constants.LOGGER.debug("sql -> {}, args -> {}", sql, args);
        return jdbcTemplate.query(sql, args, rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal queryBigDecimal(String sql, Map<String, Object> args) {
        return queryValue(sql, args, BigDecimal.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal queryBigDecimal(String sql, Object[] args) {
        return queryValue(sql, args, BigDecimal.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double queryDouble(String sql, Map<String, Object> args) {
        return queryValue(sql, args, Double.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double queryDouble(String sql, Object[] args) {
        return queryValue(sql, args, Double.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer queryInt(String sql, Map<String, Object> args) {
        return queryValue(sql, args, Integer.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer queryInt(String sql, Object[] args) {
        return queryValue(sql, args, Integer.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> queryList(String sql, Map<String, Object> args, Class<T> elementType) {
        Constants.LOGGER.debug("sql -> {}, args -> {}", sql, args);
        return namedParameterJdbcTemplate.query(sql, args, new BeanPropertyRowMapper<>(elementType));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> List<T> queryList(String sql, Object[] args, Class<T> elementType) {
        Constants.LOGGER.debug("sql -> {}, args -> {}", sql, args);
        return jdbcTemplate.query(sql, args, new BeanPropertyRowMapper<>(elementType));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long queryLong(String sql, Map<String, Object> args) {
        return queryValue(sql, args, Long.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long queryLong(String sql, Object[] args) {
        return queryValue(sql, args, Long.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T querySingle(String sql, Map<String, Object> args, Class<T> elementType) {
        Constants.LOGGER.debug("sql -> {}, args -> {} , type -> {}", sql, args, elementType.getName());
        try {
            return namedParameterJdbcTemplate.queryForObject(sql, args, new BeanPropertyRowMapper<>(elementType));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T querySingle(String sql, Map<String, Object> args, RowMapper<T> rowMapper) {
        Constants.LOGGER.debug("sql -> {}, args -> {}", sql, args);
        try {
            return namedParameterJdbcTemplate.queryForObject(sql, args, rowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T querySingle(String sql, Object[] args, Class<T> elementType) {
        Constants.LOGGER.debug("sql -> {}, args -> {} , type -> {}", sql, args, elementType.getName());
        return jdbcTemplate.queryForObject(sql, args, new BeanPropertyRowMapper<>(elementType));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T querySingle(String sql, Object[] args, RowMapper<T> rowMapper) {
        Constants.LOGGER.debug("sql -> {}, args -> {}", sql, args);
        return jdbcTemplate.queryForObject(sql, args, rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String queryString(String sql, Map<String, Object> args) {
        return queryValue(sql, args, String.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String queryString(String sql, Object[] args) {
        return queryValue(sql, args, String.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T queryValue(String sql, Map<String, Object> args, Class<T> valueType) {
        Constants.LOGGER.debug("sql -> {}, args -> {}, type -> {}", sql, args, valueType.getName());
        return namedParameterJdbcTemplate.queryForObject(sql, args, valueType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T queryValue(String sql, Object[] args, Class<T> valueType) {
        Constants.LOGGER.debug("sql -> {}, args -> {}, type -> {}", sql, args, valueType.getName());
        return jdbcTemplate.queryForObject(sql, args, valueType);
    }

    /**
     * 设置dataSource
     *
     * @param dataSource dataSource
     */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
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
     * {@inheritDoc}
     */
    @Override
    public int update(String sql, Object... args) {
        return jdbcTemplate.update(sql, args);
    }
}
