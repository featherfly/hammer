
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-10-23 18:18:23
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config;

import java.util.function.Supplier;

import javax.validation.Validator;

import cn.featherfly.hammer.config.cache.CacheConfig;
import cn.featherfly.hammer.config.dsl.DslConfig;
import cn.featherfly.hammer.config.entity.EntityConfig;
import cn.featherfly.hammer.config.tpl.TemplateConfig;

/**
 * HammerConfig.
 *
 * @author zhongj
 */
public interface HammerConfig {

    /**
     * Checks if is dev mode.
     *
     * @return true, if is dev mode
     */
    boolean isDevMode();

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
     * Gets the entity config.
     *
     * @return the entity config
     */
    EntityConfig getEntityConfig();

    /**
     * Gets the template config.
     *
     * @return the template config
     */
    TemplateConfig getTemplateConfig();

    /**
     * Gets the cache config.
     *
     * @return the cache config
     */
    CacheConfig getCacheConfig();

    /**
     * Gets the class loader.
     *
     * @return the class loader
     */
    Supplier<ClassLoader> getClassLoader();

    /**
     * Gets the query config.
     *
     * @return the query config
     */
    QueryConfig getQueryConfig();
}
