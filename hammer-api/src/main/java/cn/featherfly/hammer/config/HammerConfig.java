
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-10-23 18:18:23
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config;

import javax.validation.Validator;

import cn.featherfly.hammer.config.dsl.DslConfig;

/**
 * HammerConfig.
 *
 * @author zhongj
 */
public interface HammerConfig {

    /**
     * Gets the dsl config.
     *
     * @return the dsl config
     */
    DslConfig getDslConfig();

    /**
     * Gets the validator.
     *
     * @return the validator
     */
    Validator getValidator();

    /**
     * Gets the batch config.
     *
     * @return the batch config
     */
    BatchConfig getBatchConfig();
}
