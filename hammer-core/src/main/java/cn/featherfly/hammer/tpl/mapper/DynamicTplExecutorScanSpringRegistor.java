package cn.featherfly.hammer.tpl.mapper;

import java.util.Set;

import cn.featherfly.common.io.ClassPathScanningProvider;
import cn.featherfly.hammer.config.HammerConfig;

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
     * @param hammerConfig the hammer config
     */
    public DynamicTplExecutorScanSpringRegistor(Set<String> basePackages, String hammerReference,
        String hammerConfigReference, HammerConfig hammerConfig) {
        this(basePackages, hammerReference, hammerConfigReference, hammerConfig, null);
    }

    /**
     * Instantiates a new dynamic tpl executor scan spring registor.
     *
     * @param basePackages the base packages
     * @param hammerReference hammerReference
     * @param hammerConfigReference the hammer config reference
     * @param hammerConfig the hammer config
     * @param classLoader the class loader
     */
    public DynamicTplExecutorScanSpringRegistor(Set<String> basePackages, String hammerReference,
        String hammerConfigReference, HammerConfig hammerConfig, ClassLoader classLoader) {
        super(new ClassPathScanningProvider()
            .findMetadata(basePackages.toArray(new String[basePackages.size()])), hammerReference,
            hammerConfigReference, hammerConfig, classLoader);
    }
}
