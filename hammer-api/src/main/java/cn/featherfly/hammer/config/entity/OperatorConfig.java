
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-14 15:11:14
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config.entity;

/**
 * OperatorConfig.
 *
 * @author zhongj
 */
public interface OperatorConfig {
    /**
     * Sets the batch size.
     *
     * @param  batchSize the batch size
     * @return           the operator config
     */
    OperatorConfig setBatchSize(int batchSize);

    /**
     * Gets the batch size.
     *
     * @return the batch size
     */
    int getBatchSize();
}
