
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-14 14:59:14
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config.entity;

import java.util.Set;

/**
 * EntityConfig.
 *
 * @author zhongj
 */
public interface EntityConfig {

    /**
     * Sets the base packages.
     *
     * @param basePackages the base packages
     * @return the entity config
     */
    EntityConfig setBasePackages(Set<String> basePackages);

    /**
     * Gets the base packages.
     *
     * @return the base packages
     */
    String[] getBasePackages();

    /**
     * Sets the all operator(insert,udpate,delete and so on) batch size.
     *
     * @param batchSize the batch size
     * @return the batch config
     */
    EntityConfig setBatchSize(int batchSize);

    /**
     * Gets the insert.
     *
     * @return the insert
     */
    OperatorConfig getInsert();

    /**
     * Gets the update.
     *
     * @return the update
     */
    OperatorConfig getUpdate();

    /**
     * Gets the delete.
     *
     * @return the delete
     */
    OperatorConfig getDelete();
}
