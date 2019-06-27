
package cn.featherfly.juorm.sql.model;

import cn.featherfly.juorm.sql.dialect.Dialect;

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
     * @param dialect
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
