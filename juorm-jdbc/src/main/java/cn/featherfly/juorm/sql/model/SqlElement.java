
package cn.featherfly.juorm.sql.model;

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
     * @return
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
