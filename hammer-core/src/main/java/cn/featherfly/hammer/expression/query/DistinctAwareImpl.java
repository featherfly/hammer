
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-29 10:41:29
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.query;

import java.util.function.Consumer;

import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.QueryableField;

/**
 * DistinctAwareImpl.
 *
 * @author zhongj
 */
public class DistinctAwareImpl extends AbstractFetchField<AggregateFunction> implements DistinctAware {

    /**
     * Instantiates a new distinct aware impl.
     *
     * @param consumer the consumer
     * @param distinct the distinct
     */
    public DistinctAwareImpl(Consumer<QueryableField> consumer, boolean distinct) {
        super(consumer, distinct);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DistinctNameAware name(String name) {
        return new DistinctNameAwareImpl(getConsumer(), name, isDistinct());
    }

}
