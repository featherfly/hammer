
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
     * Sets the insert,udpate,delete batch size.
     *
     * @param batchSize the batch size
     * @return the batch config
     */
    BatchConfig setBatchSize(int batchSize);

    /**
     * Gets the insert batch size.
     *
     * @return the insert batch size
     */
    int getInsertBatchSize();

    /**
     * Sets the insert batch size.
     *
     * @param insertBatchSize the insert batch size
     * @return the batch config
     */
    BatchConfig setInsertBatchSize(int insertBatchSize);

    /**
     * Gets the update batch size.
     *
     * @return the update batch size
     */
    int getUpdateBatchSize();

    /**
     * Sets the update batch size.
     *
     * @param updateBatchSize the update batch size
     * @return the batch config
     */
    BatchConfig setUpdateBatchSize(int updateBatchSize);

    /**
     * Gets the delete batch size.
     *
     * @return the delete batch size
     */
    int getDeleteBatchSize();

    /**
     * Sets the delete batch size.
     *
     * @param deleteBatchSize the delete batch size
     * @return the batch config
     */
    BatchConfig setDeleteBatchSize(int deleteBatchSize);
}
