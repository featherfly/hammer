package cn.featherfly.hammer.tpl.mapper;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.type.classreading.MetadataReader;

import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.CollectionUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.HammerException;
import cn.featherfly.hammer.annotation.Mapper;

/**
 * 自动注册配置信息到spring context .
 *
 * @author zhongj
 */
public class DynamicTplExecutorSpringRegistor implements BeanDefinitionRegistryPostProcessor {

    /** logger. */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private TplDynamicExecutorFactory dynamicExecutorFactory = TplDynamicExecutorFactory.getInstance();

    private final Set<MetadataReader> metadataReaders = new HashSet<>();

    private final String hammerReference;

    private final String hammerConfigReference;

    private ClassLoader classLoader;

    /**
     * Instantiates a new dynamic tpl executor spring registor.
     *
     * @param hammerReference       hammerReference
     * @param hammerConfigReference the hammer config reference
     */
    public DynamicTplExecutorSpringRegistor(String hammerReference, String hammerConfigReference) {
        this(null, hammerReference, hammerConfigReference);
    }

    /**
     * Instantiates a new dynamic tpl executor spring registor.
     *
     * @param hammerReference       hammerReference
     * @param hammerConfigReference the hammer config reference
     * @param classLoader           the class loader
     */
    public DynamicTplExecutorSpringRegistor(String hammerReference, String hammerConfigReference,
            ClassLoader classLoader) {
        this(null, hammerReference, hammerConfigReference, classLoader);
    }

    /**
     * Instantiates a new dynamic tpl executor spring registor.
     *
     * @param metadataReaders       metadataReaders
     * @param hammerReference       hammerReference
     * @param hammerConfigReference the hammer config reference
     */
    public DynamicTplExecutorSpringRegistor(Set<MetadataReader> metadataReaders, String hammerReference,
            String hammerConfigReference) {
        this(metadataReaders, hammerReference, hammerConfigReference, null);
    }

    /**
     * Instantiates a new dynamic tpl executor spring registor.
     *
     * @param metadataReaders       metadataReaders
     * @param hammerReference       hammerReference
     * @param hammerConfigReference the hammer config reference
     * @param classLoader           the class loader
     */
    public DynamicTplExecutorSpringRegistor(Set<MetadataReader> metadataReaders, String hammerReference,
            String hammerConfigReference, ClassLoader classLoader) {
        super();
        this.hammerReference = hammerReference;
        this.hammerConfigReference = hammerConfigReference;
        this.classLoader = classLoader;
        CollectionUtils.addAll(this.metadataReaders, metadataReaders);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        if (Lang.isEmpty(metadataReaders)) {
            logger.debug("metadataReaders is empty");
            return;
        }
        logger.debug("start regist tpl exececutor mapper to spring");
        for (MetadataReader metadataReader : metadataReaders) {
            if (metadataReader.getAnnotationMetadata().hasAnnotation(Mapper.class.getName())) {
                try {
                    Class<?> type = ClassUtils.forName(metadataReader.getClassMetadata().getClassName());
                    String dynamicImplName = dynamicExecutorFactory.create(type, classLoader);
                    logger.debug("create class {} for {} with hammerReference {}, hammerConfigReference {}",
                            dynamicImplName, type.getName(), hammerReference, hammerConfigReference);
                    Class<?> newType = null;
                    if (classLoader == null) {
                        newType = ClassUtils.forName(dynamicImplName);
                    } else {
                        newType = classLoader.loadClass(dynamicImplName);
                    }
                    BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(newType);
                    builder.addConstructorArgReference(hammerReference)
                            .addConstructorArgReference(hammerConfigReference);
                    builder.setScope(BeanDefinition.SCOPE_SINGLETON);
                    registry.registerBeanDefinition(type.getName(), builder.getBeanDefinition());
                } catch (Exception e) {
                    throw new HammerException(e);
                }
            }
        }
        logger.debug("end regist tpl exececutor mapper to spring");
    }

    /**
     * 返回metadataReaders.
     *
     * @return metadataReaders
     */
    public Set<MetadataReader> getMetadataReaders() {
        return metadataReaders;
    }

    /**
     * 返回classLoader.
     *
     * @return classLoader
     */
    public ClassLoader getClassLoader() {
        return classLoader;
    }

    /**
     * 设置classLoader.
     *
     * @param classLoader classLoader
     */
    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }
}
