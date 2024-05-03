
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-03-20 16:37:20
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.query;

import java.util.function.Predicate;

import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.common.repository.builder.Builder;
import cn.featherfly.hammer.config.dsl.ConditionConfig;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * SqlRelation.
 *
 * @author zhongj
 * @param <B> the generic type
 */
public interface SqlRelation<B extends Builder> {

    /**
     * Gets the jdbc.
     *
     * @return the jdbc
     */
    Jdbc getJdbc();

    /**
     * Gets the alias manager.
     *
     * @return the alias manager
     */
    AliasManager getAliasManager();

    /**
     * Gets the config.
     *
     * @param <C> the generic type
     * @return the config
     */
    <C extends ConditionConfig<C>> C getConfig();

    /**
     * Gets the builder.
     *
     * @return the builder
     */
    B getBuilder();

    /**
     * Gets the ignore strategy.
     *
     * @return the ignore strategy
     */
    Predicate<Object> getIgnoreStrategy();
}
