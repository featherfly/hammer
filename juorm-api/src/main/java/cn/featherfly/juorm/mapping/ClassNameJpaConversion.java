
package cn.featherfly.juorm.mapping;

import javax.persistence.Table;

import cn.featherfly.common.bean.BeanDescriptor;

/**
 * <p>
 * ClassNameJpaConversion jpa impl. use javax.persistence.Table
 * </p>
 *
 * @author zhongj
 */
public class ClassNameJpaConversion implements ClassNameConversion {

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMappingName(Class<?> type) {
        BeanDescriptor<?> bd = BeanDescriptor.getBeanDescriptor(type);
        Table table = bd.getAnnotation(Table.class);
        if (table != null) {
            return table.name();
        }
        return null;
    }

}
