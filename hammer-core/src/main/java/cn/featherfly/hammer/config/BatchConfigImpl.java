
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-09 18:11:09
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config;

/**
 * BatchConfig.
 *
 * @author zhongj
 */
public class BatchConfigImpl implements BatchConfig {

    private int insertBatchSize = 2000;

    /**
     * {@inheritDoc}
     */
    @Override
    public int getInsertBatchSize() {
        return insertBatchSize;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BatchConfig setInsertBatchSize(int insertBatchSize) {
        this.insertBatchSize = insertBatchSize;
        return this;
    }

}
