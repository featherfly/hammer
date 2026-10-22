
package cn.featherfly.hammer.sqldb.jdbc;

import java.io.Serializable;

import cn.featherfly.common.repository.InterceptionExecution;

/**
 * jdbc excecution.
 *
 * @author zhongj
 */
public class JdbcExecution implements InterceptionExecution {

    /** The jdbc. */
    private Jdbc jdbc;

    /** The execution. */
    protected String execution;

    /** The original execution. */
    protected String originalExecution;

    /** The params. */
    protected Serializable[] params;

    /** The original params. */
    protected Serializable[] originalParams;

    /** The result. */
    protected Object result;

    /** The original result. */
    protected Object originalResult;

    /**
     * Instantiates a new jdbc execution.
     *
     * @param jdbc the jdbc
     * @param execution execution string
     * @param params params
     */
    JdbcExecution(Jdbc jdbc, String execution, Serializable... params) {
        this.jdbc = jdbc;
        originalExecution = execution;
        this.execution = execution;
        originalParams = params;
        this.params = params;
    }

    /**
     * Sets the original result.
     *
     * @param result the result
     * @return the jdbc execution
     */
    JdbcExecution setOriginalResult(Object result) {
        originalResult = result;
        this.result = result;
        return this;
    }

    /**
     * get jdbc value.
     *
     * @return jdbc
     */
    public Jdbc getJdbc() {
        return jdbc;
    }

    /**
     * get originalExecution value.
     *
     * @return originalExecution
     */
    @Override
    public String getOriginalExecution() {
        return originalExecution;
    }

    /**
     * get originalParams value.
     *
     * @return originalParams
     */
    @Override
    public Serializable[] getOriginalParams() {
        return originalParams;
    }

    /**
     * get execution value.
     *
     * @return execution
     */
    @Override
    public String getExecution() {
        return execution;
    }

    /**
     * set execution value.
     *
     * @param execution execution
     */
    @Override
    public void setExecution(String execution) {
        this.execution = execution;
    }

    /**
     * get params value.
     *
     * @return params
     */
    @Override
    public Serializable[] getParams() {
        return params;
    }

    /**
     * set params value.
     *
     * @param params params
     */
    @Override
    public void setParams(Serializable[] params) {
        this.params = params;
    }

    /**
     * get result value.
     *
     * @return result
     */
    public Object getResult() {
        return result;
    }

    /**
     * set result value.
     *
     * @param result result
     */
    public void setResult(Object result) {
        this.result = result;
    }

    /**
     * get originalResult value.
     *
     * @return originalResult
     */
    public Object getOriginalResult() {
        return originalResult;
    }
}
