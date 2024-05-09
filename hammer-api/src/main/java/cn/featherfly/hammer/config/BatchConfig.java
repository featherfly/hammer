
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-09 18:09:09
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config;

/**
 * BatchConfig.
 *
 * @author zhongj
 */
public interface BatchConfig {

    /**
     * Gets the insert batch size.
     *
     * @return the insert batch size
     */
    int getInsertBatchSize();

    /**
     * Sets the insert batch size.
     *
     * @param  insertBatchSize the new insert batch size
     * @return                 this
     */
    BatchConfig setInsertBatchSize(int insertBatchSize);
}
