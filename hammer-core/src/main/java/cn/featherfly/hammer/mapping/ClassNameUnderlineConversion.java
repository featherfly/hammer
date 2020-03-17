
package cn.featherfly.hammer.mapping;

import cn.featherfly.common.lang.WordUtils;
import cn.featherfly.hammer.mapping.ClassNameConversion;

/**
 * <p>
 * ClassNameUnderlineConversion use _ join type every word. ClassNameMapping as
 * class_name_mapping
 * </p>
 *
 * @author zhongj
 * @since 0.1.0
 * @version 0.1.0
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
