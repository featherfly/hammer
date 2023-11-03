
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-21 13:32:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.query;

import java.util.function.BiConsumer;

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
     * @param index             the index
     * @param consumer          the consumer
     * @param distinct          the distinct
     * @param aggregateFunction the aggregate function
     * @param name              the name
     */
    public AggregateDistinctNameAwareImpl(int index, BiConsumer<Integer, QueryableField> consumer, boolean distinct,
            AggregateFunction aggregateFunction, String name) {
        super(index, consumer, aggregateFunction, name, distinct);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AggregateDistinctNameAliasAware alias(String alias) {
        return new AggregateDistinctNameAliasAwareImpl(getIndex(), getConsumer(), function(), name(), alias,
                isDistinct());
    }

}
