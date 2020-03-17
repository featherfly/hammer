
package cn.featherfly.juorm.sqldb.sql.model;

import cn.featherfly.juorm.dml.DmlElement;

/**
 * <p>
 * SqlElement
 * </p>
 *
 * @author zhongj
 */
public interface SqlElement extends DmlElement {
    /**
     * toSql
     *
     * @return sql
     */
    String toSql();

    /**
     * {@inheritDoc}
     */
    @Override
    default String toDml() {
        return toSql();
    }
}
