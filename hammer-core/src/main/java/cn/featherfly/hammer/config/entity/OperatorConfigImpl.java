
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-14 15:18:14
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.config.entity;

/**
 * OperatorConfigImpl.
 *
 * @author zhongj
 */
public class OperatorConfigImpl implements OperatorConfig {

    private int batchSize = 2000;

    /**
     * Instantiates a new operator config impl.
     *
     * @param batchSize the batch size
     */
    public OperatorConfigImpl(int batchSize) {
        super();
        this.batchSize = batchSize;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OperatorConfig setBatchSize(int batchSize) {
        this.batchSize = batchSize;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getBatchSize() {
        return batchSize;
    }

}
