
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-10-23 18:47:23
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config;

import javax.validation.Validator;

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

    /**
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
     */
    public void setDslConfig(DslConfig dslConfig) {
        this.dslConfig = dslConfig;
    }

    /**
     * Sets the validator.
     *
     * @param validator the new validator
     */
    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    /**
     * set templateConfig value
     *
     * @param templateConfig templateConfig
     */
    public void setTemplateConfig(TemplateConfigImpl templateConfig) {
        this.templateConfig = templateConfig;
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
     * get devMode value
     *
     * @return devMode
     */
    @Override
    public boolean isDevMode() {
        return devMode;
    }
}
