
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
 * NamedDistinctedFieldImpl.
 *
 * @author zhongj
 */
public class AggregatedDistinctedFieldImpl extends AbstractFetchField<AggregateFunction>
        implements AggregatedDistinctedField {

    /**
     * Instantiates a new named distincted field impl.
     *
     * @param index             the index
     * @param consumer          the consumer
     * @param aggregateFunction the aggregate function
     * @param name              the name
     * @param distinct          the distinct
     */
    public AggregatedDistinctedFieldImpl(int index, BiConsumer<Integer, QueryableField> consumer,
            AggregateFunction aggregateFunction, String name, boolean distinct) {
        super(index, consumer, aggregateFunction, name, distinct);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AggregatedAliasedDistinctedField alias(String alias) {
        return new AggregatedAliasedDistinctedFieldImpl(getIndex(), getConsumer(), function(), name(), alias,
                isDistinct());
    }

}
