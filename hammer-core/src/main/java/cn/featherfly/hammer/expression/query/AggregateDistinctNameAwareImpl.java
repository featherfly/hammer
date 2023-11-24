
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-21 13:32:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.query;

import java.util.function.Consumer;

import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.QueryableField;

/**
 * AggregateDistincteNameAwareImpl.
 *
 * @author zhongj
 */
public class AggregateDistinctNameAwareImpl extends AbstractFetchField<AggregateFunction>
        implements AggregateDistinctNameAware {

    /**
     * Instantiates a new named distincted field impl.
     *
     * @param consumer          the consumer
     * @param distinct          the distinct
     * @param aggregateFunction the aggregate function
     * @param name              the name
     */
    public AggregateDistinctNameAwareImpl(Consumer<QueryableField> consumer, boolean distinct,
            AggregateFunction aggregateFunction, String name) {
        super(consumer, aggregateFunction, name, distinct);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AggregateDistinctNameAliasAware alias(String alias) {
        return new AggregateDistinctNameAliasAwareImpl(getConsumer(), function(), name(), alias, isDistinct());
    }

}
