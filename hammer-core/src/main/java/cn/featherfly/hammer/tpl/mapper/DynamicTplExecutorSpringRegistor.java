package cn.featherfly.hammer.tpl.mapper;

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
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.hammer.HammerException;
import cn.featherfly.hammer.tpl.annotation.Mapper;
import javassist.CannotCompileException;
import javassist.NotFoundException;

/**
 * <p>
 * 自动注册配置信息到spring context
 * </p>
 *
 * @author 钟冀
 */
public class DynamicTplExecutorSpringRegistor implements BeanDefinitionRegistryPostProcessor {

    /**
     * logger
     */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Set<MetadataReader> metadataReaders;

    private TplDynamicExecutorFactory dynamicExecutorFactory = TplDynamicExecutorFactory.getInstance();

    private String hammerReference;

    /**
     * @param hammerReference hammerReference
     */
    public DynamicTplExecutorSpringRegistor(String hammerReference) {
        this(null, hammerReference);
    }

    /**
     * @param metadataReaders metadataReaders
     * @param hammerReference hammerReference
     */
    public DynamicTplExecutorSpringRegistor(Set<MetadataReader> metadataReaders, String hammerReference) {
        super();
        this.metadataReaders = metadataReaders;
        this.hammerReference = hammerReference;
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
        if (LangUtils.isEmpty(metadataReaders)) {
            logger.debug("metadataReaders is empty");
            return;
        }
        logger.debug("start regist tpl exececutor mapper to spring");
        for (MetadataReader metadataReader : metadataReaders) {
            if (metadataReader.getAnnotationMetadata().hasAnnotation(Mapper.class.getName())) {
                try {
                    Class<?> type = ClassUtils.forName(metadataReader.getClassMetadata().getClassName());
                    String dynamicImplName = dynamicExecutorFactory.create(type);
                    logger.debug("create class {} for {} with hammerReference {}", dynamicImplName, type.getName(),
                            hammerReference);
                    BeanDefinitionBuilder builder = BeanDefinitionBuilder
                            .rootBeanDefinition(ClassUtils.forName(dynamicImplName));
                    builder.addConstructorArgReference(hammerReference);
                    builder.setScope(BeanDefinition.SCOPE_SINGLETON);
                    registry.registerBeanDefinition(type.getName(), builder.getBeanDefinition());
                } catch (NotFoundException | CannotCompileException e) {
                    throw new HammerException(e);
                }
            }
        }
        logger.debug("end regist tpl exececutor mapper to spring");
    }

    /**
     * 返回metadataReaders
     *
     * @return metadataReaders
     */
    public Set<MetadataReader> getMetadataReaders() {
        return metadataReaders;
    }

    /**
     * 设置metadataReaders
     *
     * @param metadataReaders metadataReaders
     */
    public void setMetadataReaders(Set<MetadataReader> metadataReaders) {
        this.metadataReaders = metadataReaders;
    }
}
