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
     * @param basePackages    basePackages
     * @param hammerReference hammerReference
     */
    public DynamicTplExecutorScanSpringRegistor(Set<String> basePackages, String hammerReference) {
        super(hammerReference);
        Set<MetadataReader> metadataReaders = new ClassPathScanningProvider()
                .findMetadata(basePackages.toArray(new String[] {}));
        setMetadataReaders(metadataReaders);
    }
}
