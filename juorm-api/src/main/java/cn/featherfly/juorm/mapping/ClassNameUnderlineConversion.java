
package cn.featherfly.juorm.mapping;

import cn.featherfly.common.lang.WordUtils;

/**
 * <p>
 * ClassNameUnderlineConversion use _ join type every word. ClassNameMapping as
 * class_name_mapping
 * </p>
 *
 * @author zhongj
 */
public class ClassNameUnderlineConversion implements ClassNameConversion {

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMappingName(Class<?> type) {
        return WordUtils.addSignBeforeUpper(type.getSimpleName(), '_', true);
    }

}
