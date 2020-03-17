
package cn.featherfly.juorm.sqldb.sql.model;

import cn.featherfly.juorm.sqldb.sql.dialect.Dialect;

/**
 * <p>
 * SqlElement
 * </p>
 *
 * @author zhongj
 */
public abstract class AbstractSqlElement implements SqlElement {

    protected Dialect dialect;

    /**
     * @param dialect dialect
     */
    public AbstractSqlElement(Dialect dialect) {
        super();
        this.dialect = dialect;
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
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return toSql();
    }
}
