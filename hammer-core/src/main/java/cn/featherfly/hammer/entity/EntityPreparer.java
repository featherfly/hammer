
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-25 01:13:25
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.core.type.classreading.MetadataReader;

import cn.featherfly.common.bean.PropertyAccessorFactory;
import cn.featherfly.common.io.ClassPathScanningProvider;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.HammerException;

/**
 * Entity.
 *
 * @author zhongj
 */
public class EntityPreparer {

    private final Set<MetadataReader> metadataReaders = new HashSet<>();

    private final PropertyAccessorFactory propertyAccessorFactory;

    /**
     * Instantiates a new entity preparer.
     *
     * @param metadataReaders the metadata readers
     * @param propertyAccessorFactory the property accessor factory
     */
    private EntityPreparer(Set<MetadataReader> metadataReaders, PropertyAccessorFactory propertyAccessorFactory) {
        super();
        this.metadataReaders.addAll(metadataReaders);
        this.propertyAccessorFactory = propertyAccessorFactory;
    }

    /**
     * Builder.
     *
     * @return the entity preparer builder
     */
    public static EntityPreparerBuilder builder() {
        return new EntityPreparerBuilder();
    }

    /**
     * Prepare.
     *
     * @return the entity preparer
     */
    public EntityPreparer prepare() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        for (MetadataReader metadataReader : metadataReaders) {
            if (metadataReader.getAnnotationMetadata().hasAnnotation(Table.class.getName())
                || metadataReader.getAnnotationMetadata().hasAnnotation(Entity.class.getName())) {
                try {
                    Class<?> type = ClassUtils.forName(metadataReader.getClassMetadata().getClassName());
                    propertyAccessorFactory.create(type, classLoader);

                } catch (Exception e) {
                    throw new HammerException(e);
                }
            }
        }
        propertyAccessorFactory.createPropertyAccessorCascade(classLoader);
        return this;
    }

    /**
     * The Class EntityPreparerBuilder.
     */
    public static class EntityPreparerBuilder {

        private final Set<MetadataReader> metadataReaders = new HashSet<>();

        private PropertyAccessorFactory propertyAccessorFactory;

        private EntityPreparerBuilder() {
        }

        /**
         * set basePackages.
         *
         * @param basePackages the base packages
         * @return the entity preparer builder
         */
        public EntityPreparerBuilder basePackages(String... basePackages) {
            return basePackages(Lang.set(basePackages));
        }

        /**
         * set basePackages.
         *
         * @param basePackages the base packages
         * @return the entity preparer builder
         */
        public EntityPreparerBuilder basePackages(Set<String> basePackages) {
            metadataReaders.addAll(
                new ClassPathScanningProvider().findMetadata(basePackages.toArray(new String[basePackages.size()])));
            return this;
        }

        /**
         * set metadataReaders value.
         *
         * @param metadataReaders metadataReaders
         * @return the entity preparer builder
         */
        public EntityPreparerBuilder metadataReaders(Set<MetadataReader> metadataReaders) {
            this.metadataReaders.clear();
            this.metadataReaders.addAll(metadataReaders);
            return this;
        }

        /**
         * set propertyAccessorFactory value.
         *
         * @param propertyAccessorFactory propertyAccessorFactory
         * @return the entity preparer builder
         */
        public EntityPreparerBuilder propertyAccessorFactory(PropertyAccessorFactory propertyAccessorFactory) {
            this.propertyAccessorFactory = propertyAccessorFactory;
            return this;
        }

        /**
         * Builds the.
         *
         * @return the entity preparer
         */
        public EntityPreparer build() {
            return new EntityPreparer(metadataReaders, propertyAccessorFactory);
        }
    }

    /**
     * get propertyAccessorFactory value.
     *
     * @return propertyAccessorFactory
     */
    public PropertyAccessorFactory getPropertyAccessorFactory() {
        return propertyAccessorFactory;
    }
}
