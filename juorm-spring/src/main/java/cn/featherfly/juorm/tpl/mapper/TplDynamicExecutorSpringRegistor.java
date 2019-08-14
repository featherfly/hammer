package cn.featherfly.juorm.tpl.mapper;

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

import cn.featherfly.common.io.ClassPathScanningProvider;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.juorm.JuormException;
import cn.featherfly.juorm.tpl.annotation.TplExecution;
import javassist.CannotCompileException;
import javassist.NotFoundException;

/**
 * <p>
 * 自动注册配置信息到spring context
 * </p>
 *
 * @author 钟冀
 */
public class TplDynamicExecutorSpringRegistor implements BeanDefinitionRegistryPostProcessor {

    /**
     * logger
     */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Set<String> basePackages = new HashSet<>();

    private TplDynamicExecutorFactory dynamicExecutorFactory = TplDynamicExecutorFactory.getInstance();

    private String juormReference;

    /**
     * @param basePackages   basePackages
     * @param juormReference juormReference
     */
    public TplDynamicExecutorSpringRegistor(Set<String> basePackages, String juormReference) {
        super();
        this.basePackages = basePackages;
        this.juormReference = juormReference;
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
        Set<MetadataReader> metadataReaders = new ClassPathScanningProvider()
                .findMetadata(basePackages.toArray(new String[] {}));
        for (MetadataReader metadataReader : metadataReaders) {
            if (metadataReader.getAnnotationMetadata().hasAnnotation(TplExecution.class.getName())) {
                try {
                    Class<?> type = ClassUtils.forName(metadataReader.getClassMetadata().getClassName());
                    String dynamicImplName = dynamicExecutorFactory.create(type);
                    logger.debug("create class {} for {} with juormReference {}", dynamicImplName, type.getName(),
                            juormReference);
                    BeanDefinitionBuilder builder = BeanDefinitionBuilder
                            .rootBeanDefinition(ClassUtils.forName(dynamicImplName));
                    builder.addConstructorArgReference(juormReference);
                    builder.setScope(BeanDefinition.SCOPE_SINGLETON);
                    registry.registerBeanDefinition(type.getName(), builder.getBeanDefinition());
                } catch (NotFoundException | CannotCompileException e) {
                    throw new JuormException(e);
                }
            }
        }
        logger.debug("end regist configuration to spring");
    }
}
