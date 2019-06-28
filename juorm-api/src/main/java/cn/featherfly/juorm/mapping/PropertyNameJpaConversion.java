
package cn.featherfly.juorm.mapping;

import javax.persistence.Column;

import cn.featherfly.common.bean.BeanProperty;

/**
 * <p>
 * PropertyNameJpaConversion jpa impl. use javax.persistence.Table
 * </p>
 *
 * @author zhongj
 */
public class PropertyNameJpaConversion implements PropertyNameConversion {

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMappingName(BeanProperty<?> type) {
        Column column = type.getAnnotation(Column.class);
        if (column != null) {
            return column.name();
        }
        return null;
    }

}
