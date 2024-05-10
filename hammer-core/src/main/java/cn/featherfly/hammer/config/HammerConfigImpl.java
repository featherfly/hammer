
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
import cn.featherfly.hammer.config.tpl.TemplateConfig;

/**
 * HammerConfigImpl.
 *
 * @author zhongj
 */
public class HammerConfigImpl implements HammerConfig {

    private DslConfig dslConfig = new DslConfigImpl();

    private BatchConfig batchConfig = new BatchConfigImpl();

    private Validator validator;

    private TemplateConfigImpl templateConfig = new TemplateConfigImpl();

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
     * {@inheritDoc}
     */
    @Override
    public BatchConfig getBatchConfig() {
        return batchConfig;
    }

    /**
     * Sets the batch config.
     *
     * @param batchConfig the new batch config
     */
    public void setBatchConfig(BatchConfig batchConfig) {
        this.batchConfig = batchConfig;
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
}
