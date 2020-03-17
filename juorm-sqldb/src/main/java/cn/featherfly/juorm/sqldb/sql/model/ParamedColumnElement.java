
package cn.featherfly.juorm.sqldb.sql.model;

import cn.featherfly.juorm.sqldb.sql.dialect.Dialect;

/**
 * <p>
 * ParamedColumnElement
 * </p>
 *
 * @author zhongj
 */
public abstract class ParamedColumnElement extends ColumnElement {

    protected Object param;

    /**
     * @param dialect dialect
     * @param name    name
     * @param param   param
     */
    public ParamedColumnElement(Dialect dialect, String name, Object param) {
        this(dialect, name, param, null);
    }

    /**
     * @param dialect    dialect
     * @param name       name
     * @param param      param
     * @param tableAlias tableAlias
     */
    public ParamedColumnElement(Dialect dialect, String name, Object param, String tableAlias) {
        super(dialect, name, tableAlias);
        this.param = param;
    }

    /**
     * 返回param
     *
     * @return param
     */
    public Object getParam() {
        return param;
    }

    /**
     * 设置param
     *
     * @param param param
     */
    public void setParam(Object param) {
        this.param = param;
    }
}
