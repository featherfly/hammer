package cn.featherfly.hammer.tpl.mapper;

import java.util.Set;

import org.springframework.core.type.classreading.MetadataReader;

import cn.featherfly.common.io.ClassPathScanningProvider;
import cn.featherfly.common.lang.CollectionUtils;

/**
 * 自动注册配置信息到spring context .
 *
 * @author zhongj
 */
public class DynamicTplExecutorScanSpringRegistor extends DynamicTplExecutorSpringRegistor {

    /**
     * Instantiates a new dynamic tpl executor scan spring registor.
     *
     * @param basePackages basePackages
     * @param hammerReference hammerReference
     * @param hammerConfigReference the hammer config reference
     */
    public DynamicTplExecutorScanSpringRegistor(Set<String> basePackages, String hammerReference,
        String hammerConfigReference) {
        this(basePackages, hammerReference, hammerConfigReference, null);
    }

    /**
     * Instantiates a new dynamic tpl executor scan spring registor.
     *
     * @param basePackages the base packages
     * @param hammerReference hammerReference
     * @param hammerConfigReference the hammer config reference
     * @param classLoader the class loader
     */
    public DynamicTplExecutorScanSpringRegistor(Set<String> basePackages, String hammerReference,
        String hammerConfigReference, ClassLoader classLoader) {
        super(hammerReference, hammerConfigReference, classLoader);
        Set<MetadataReader> metadataReaders = new ClassPathScanningProvider()
            .findMetadata(basePackages.toArray(new String[basePackages.size()]));
        CollectionUtils.addAll(getMetadataReaders(), metadataReaders);
        setClassLoader(classLoader);
    }
}
