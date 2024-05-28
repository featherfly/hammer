
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-10-23 18:47:23
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config;

import java.util.function.Supplier;

import javax.validation.Validator;

import cn.featherfly.hammer.config.cache.CacheConfig;
import cn.featherfly.hammer.config.cache.CacheConfigImpl;
import cn.featherfly.hammer.config.dsl.DslConfig;
import cn.featherfly.hammer.config.entity.EntityConfig;
import cn.featherfly.hammer.config.entity.EntityConfigImpl;
import cn.featherfly.hammer.config.tpl.TemplateConfig;

/**
 * HammerConfigImpl.
 *
 * @author zhongj
 */
public class HammerConfigImpl implements HammerConfig {

    private DslConfig dslConfig = new DslConfigImpl();

    private EntityConfig entityConfig = new EntityConfigImpl();

    private Validator validator;

    private TemplateConfigImpl templateConfig = new TemplateConfigImpl();

    private final boolean devMode;

    private Supplier<ClassLoader> classLoaderSupplier = () -> Thread.currentThread().getContextClassLoader();

    private CacheConfig cacheConfig = new CacheConfigImpl();

    /**
     * Instantiates a new hammer config impl.
     */
    public HammerConfigImpl() {
        this(false);
    }

    /**
     * Instantiates a new hammer config impl.
     *
     * @param devMode the dev mode
     */
    public HammerConfigImpl(boolean devMode) {
        this.devMode = devMode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DslConfig getDslConfig() {
        return dslConfig;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Validator getValidator() {
        return validator;
    }

    /**
     * Sets the dsl config.
     *
     * @param dslConfig the new dsl config
     * @return the hammer config impl
     */
    public HammerConfigImpl setDslConfig(DslConfig dslConfig) {
        this.dslConfig = dslConfig;
        return this;
    }

    /**
     * Sets the validator.
     *
     * @param validator the new validator
     * @return the hammer config impl
     */
    public HammerConfigImpl setValidator(Validator validator) {
        this.validator = validator;
        return this;
    }

    /**
     * set templateConfig value.
     *
     * @param templateConfig templateConfig
     * @return the hammer config impl
     */
    public HammerConfigImpl setTemplateConfig(TemplateConfigImpl templateConfig) {
        this.templateConfig = templateConfig;
        return this;
    }

    /**
     * Sets the class loader supplier.
     *
     * @param classLoaderSupplier the class loader supplier
     * @return the hammer config impl
     */
    public HammerConfigImpl setClassLoaderSupplier(Supplier<ClassLoader> classLoaderSupplier) {
        this.classLoaderSupplier = classLoaderSupplier;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TemplateConfig getTemplateConfig() {
        return templateConfig;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityConfig getEntityConfig() {
        return entityConfig;
    }

    /**
     * get devMode value.
     *
     * @return devMode
     */
    @Override
    public boolean isDevMode() {
        return devMode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Supplier<ClassLoader> getClassLoader() {
        return classLoaderSupplier;
    }

    /**
     * set cacheConfig value
     *
     * @param cacheConfig cacheConfig
     */
    public HammerConfigImpl setCacheConfig(CacheConfig cacheConfig) {
        this.cacheConfig = cacheConfig;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CacheConfig getCacheConfig() {
        return cacheConfig;
    }
}
