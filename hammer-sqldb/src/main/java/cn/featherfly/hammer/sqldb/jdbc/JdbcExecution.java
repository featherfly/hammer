
package cn.featherfly.hammer.sqldb.jdbc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.featherfly.common.lang.CollectionUtils;
import cn.featherfly.common.repository.SimpleExecution;
import cn.featherfly.common.repository.mapping.RowMapper;

/**
 * jdbc excecution.
 *
 * @author zhongj
 */
public class JdbcExecution extends SimpleExecution {

    /** The jdbc. */
    private Jdbc jdbc;

    private List<JdbcExecutionInterceptor> interceptors = new ArrayList<>(0);

    /**
     * Instantiates a new jdbc execution.
     *
     * @param jdbc    the jdbc
     * @param execute execute string
     * @param params  params
     */
    public JdbcExecution(Jdbc jdbc, String execute, Object... params) {
        super(execute, params);
        this.jdbc = jdbc;
    }

    /**
     * Instantiates a new jdbc execution.
     *
     * @param jdbc    the jdbc
     * @param execute execute string
     * @param params  params
     */
    public JdbcExecution(Jdbc jdbc, String execute, Object[] params,
            JdbcExecutionInterceptor... executionInterceptors) {
        super(execute, params);
        this.jdbc = jdbc;
        CollectionUtils.addAll(interceptors, executionInterceptors);
    }

    /**
     * Update.
     *
     * @return the int
     */
    public int update() {
        before();
        int result = jdbc.update(getExecution(), getParams());
        after();
        return result;
    }

    /**
     * Query.
     *
     * @return the list
     */
    public List<Map<String, Object>> query() {
        before();
        List<Map<String, Object>> result = jdbc.query(getExecution(), getParams());
        after();
        return result;
    }

    /**
     * Query.
     *
     * @param <T>       the generic type
     * @param rowMapper the row mapper
     * @return the list
     */
    public <T> List<T> query(RowMapper<T> rowMapper) {
        before();
        List<T> result = jdbc.query(getExecution(), rowMapper, getParams());
        after();
        return result;
    }

    /**
     * Query.
     *
     * @param <T>         the generic type
     * @param elementType the element type
     * @return the list
     */
    public <T> List<T> query(Class<T> elementType) {
        before();
        List<T> result = jdbc.query(getExecution(), elementType, getParams());
        after();
        return result;
    }

    /**
     * Query single.
     *
     * @return the map
     */
    public Map<String, Object> querySingle() {
        before();
        Map<String, Object> result = jdbc.querySingle(getExecution(), getParams());
        after();
        return result;
    }

    /**
     * Query single.
     *
     * @param <T>       the generic type
     * @param rowMapper the row mapper
     * @return the t
     */
    public <T> T querySingle(RowMapper<T> rowMapper) {
        before();
        T result = jdbc.querySingle(getExecution(), rowMapper, getParams());
        after();
        return result;
    }

    /**
     * Query single.
     *
     * @param <T>         the generic type
     * @param elementType the element type
     * @return the t
     */
    public <T> T querySingle(Class<T> elementType) {
        before();
        T result = jdbc.querySingle(getExecution(), elementType, getParams());
        after();
        return result;
    }

    /**
     * Query unique.
     *
     * @return the map
     */
    public Map<String, Object> queryUnique() {
        before();
        Map<String, Object> result = jdbc.queryUnique(getExecution(), getParams());
        after();
        return result;
    }

    /**
     * Query unique.
     *
     * @param <T>       the generic type
     * @param rowMapper the row mapper
     * @return the t
     */
    public <T> T queryUnique(RowMapper<T> rowMapper) {
        before();
        T result = jdbc.queryUnique(getExecution(), rowMapper, getParams());
        after();
        return result;
    }

    /**
     * Query unique.
     *
     * @param <T>         the generic type
     * @param elementType the element type
     * @return the t
     */
    public <T> T queryUnique(Class<T> elementType) {
        before();
        T result = jdbc.queryUnique(getExecution(), elementType, getParams());
        after();
        return result;
    }

    /**
     * Query int.
     *
     * @return the integer
     */
    public Integer queryInt() {
        before();
        Integer result = jdbc.queryInt(getExecution(), getParams());
        after();
        return result;
    }

    /**
     * Query long.
     *
     * @return the long
     */
    public Long queryLong() {
        before();
        Long result = jdbc.queryLong(getExecution(), getParams());
        after();
        return result;
    }

    /**
     * Query big decimal.
     *
     * @return the big decimal
     */
    public BigDecimal queryBigDecimal() {
        before();
        BigDecimal result = jdbc.queryBigDecimal(getExecution(), getParams());
        after();
        return result;
    }

    /**
     * Query double.
     *
     * @return the double
     */
    public Double queryDouble() {
        before();
        Double result = jdbc.queryDouble(getExecution(), getParams());
        after();
        return result;
    }

    /**
     * Query string.
     *
     * @return the string
     */
    public String queryString() {
        before();
        String result = jdbc.queryString(getExecution(), getParams());
        after();
        return result;
    }

    /**
     * Query value.
     *
     * @param <T>       the generic type
     * @param valueType the value type
     * @return the t
     */
    public <T> T queryValue(Class<T> valueType) {
        before();
        T result = jdbc.queryValue(getExecution(), valueType, getParams());
        after();
        return result;
    }

    /**
     * Query value.
     *
     * @param <T>       the generic type
     * @param rowMapper the row mapper
     * @return the t
     */
    public <T> T queryValue(RowMapper<T> rowMapper) {
        before();
        T result = jdbc.queryValue(getExecution(), rowMapper, getParams());
        after();
        return result;
    }

    private void before() {
        for (JdbcExecutionInterceptor interceptor : interceptors) {
            interceptor.preHandle(this);
        }
    }

    private void after() {
        for (JdbcExecutionInterceptor interceptor : interceptors) {
            interceptor.postHandle(this);
        }
    }
}
