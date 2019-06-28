
package cn.featherfly.juorm.jdbc;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.featherfly.juorm.sql.dialect.Dialect;

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
    public Jdbc(JdbcTemplate jdbcTemplate, Dialect dialect) {
        super();
        this.jdbcTemplate = jdbcTemplate;
        this.dialect = dialect;
    }

    /**
     * @return DataSource
     */
    public DataSource getDataSource() {
        return jdbcTemplate.getDataSource();
    }

    /**
     * 返回jdbcTemplate
     *
     * @return jdbcTemplate
     */
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

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
     * @param <T>
     * @param action
     * @return
     * @throws DataAccessException
     * @see org.springframework.jdbc.core.JdbcTemplate#execute(org.springframework.jdbc.core.ConnectionCallback)
     */
    public <T> T execute(ConnectionCallback<T> action) throws DataAccessException {
        return jdbcTemplate.execute(action);
    }
}
