
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-29 11:04:29
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.query;

import java.util.function.Consumer;

import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.QueryableField;

/**
 * AggregateDistinctAwareImpl.
 *
 * @author zhongj
 */
public class AggregateDistinctAwareImpl extends AbstractFetchField<AggregateFunction>
        implements AggregateDistinctAware {

    /**
     * Instantiates a new aggregate distincte aware impl.
     *
     * @param consumer the consumer
     * @param distinct the distinct
     * @param function the function
     */
    public AggregateDistinctAwareImpl(Consumer<QueryableField> consumer, boolean distinct, AggregateFunction function) {
        super(consumer, function, distinct);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AggregateDistinctNameAware name(String name) {
        return new AggregateDistinctNameAwareImpl(getConsumer(), isDistinct(), function(), name);
    }

}
