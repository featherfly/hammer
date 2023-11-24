
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-29 10:53:29
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.query;

import java.util.function.Consumer;

import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.QueryableField;

/**
 * AggregateAwareImpl.
 *
 * @author zhongj
 */
public class AggregateAwareImpl extends AbstractFetchField<AggregateFunction> implements AggregateAware {

    /**
     * Instantiates a new aggregate aware impl.
     *
     * @param consumer the consumer
     * @param function the function
     */
    public AggregateAwareImpl(Consumer<QueryableField> consumer, AggregateFunction function) {
        super(consumer, function);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AggregateNameAware name(String name) {
        return new AggregateNameAwareImpl(getConsumer(), function(), name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AggregateDistinctAware distinct(boolean distinct) {
        return new AggregateDistinctAwareImpl(getConsumer(), distinct, function());
    }

}
