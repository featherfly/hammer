package cn.featherfly.hammer.tpl.mapper;

import java.util.Set;

import org.springframework.core.type.classreading.MetadataReader;

import cn.featherfly.common.io.ClassPathScanningProvider;

/**
 * <p>
 * 自动注册配置信息到spring context
 * </p>
 *
 * @author 钟冀
 */
public class DynamicTplExecutorScanSpringRegistor extends DynamicTplExecutorSpringRegistor {

    /**
     * Instantiates a new dynamic tpl executor scan spring registor.
     *
     * @param basePackages    basePackages
     * @param hammerReference hammerReference
     */
    public DynamicTplExecutorScanSpringRegistor(Set<String> basePackages, String hammerReference) {
        this(basePackages, hammerReference, null);
    }

    /**
     * Instantiates a new dynamic tpl executor scan spring registor.
     *
     * @param basePackages    the base packages
     * @param hammerReference hammerReference
     * @param classLoader     the class loader
     */
    public DynamicTplExecutorScanSpringRegistor(Set<String> basePackages, String hammerReference,
            ClassLoader classLoader) {
        super(hammerReference);
        Set<MetadataReader> metadataReaders = new ClassPathScanningProvider()
                .findMetadata(basePackages.toArray(new String[] {}));
        setMetadataReaders(metadataReaders);
        setClassLoader(classLoader);
    }
}
