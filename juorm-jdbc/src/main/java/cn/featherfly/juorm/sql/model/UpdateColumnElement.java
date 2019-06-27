
package cn.featherfly.juorm.sql.model;

import cn.featherfly.juorm.sql.dialect.Dialect;

/**
 * <p>
 * UpdateColumnElement
 * </p>
 *
 * @author zhongj
 */
public class UpdateColumnElement extends ParamedColumnElement {

    /**
     * @param dialect dialect
     * @param name    name
     * @param param   param
     */
    public UpdateColumnElement(Dialect dialect, String name, Object param) {
        this(dialect, name, param, null);
    }

    /**
     * @param dialect    dialect
     * @param name       name
     * @param param      param
     * @param tableAlias tableAlias
     */
    public UpdateColumnElement(Dialect dialect, String name, Object param, String tableAlias) {
        super(dialect, name, param, tableAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toSql() {
        return dialect.buildColumnSql(getName(), getTableAlias()) + " = ?";
    }
}
