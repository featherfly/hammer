
package cn.featherfly.juorm.mapping;

import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.lang.WordUtils;

/**
 * <p>
 * PropertyNameUnderlineConversion use _ join type every word. ClassNameMapping
 * as class_name_mapping
 * </p>
 *
 * @author zhongj
 */
public class PropertyNameUnderlineConversion implements PropertyNameConversion {

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMappingName(BeanProperty<?> type) {
        return WordUtils.addSignBeforeUpper(type.getName(), '_', true);
    }

}
