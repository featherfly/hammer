
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
 * NamedFieldImpl.
 *
 * @author zhongj
 */
public class AggregatedFieldImpl extends AbstractFetchField<AggregateFunction> implements AggregatedField {

    /**
     * Instantiates a new named field impl.
     *
     * @param index             the index
     * @param consumer          the consumer
     * @param aggregateFunction the aggregate function
     * @param name              the name
     */
    public AggregatedFieldImpl(int index, BiConsumer<Integer, QueryableField> consumer,
            AggregateFunction aggregateFunction, String name) {
        super(index, consumer, aggregateFunction, name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AggregatedAliasedField alias(String alias) {
        return new AggregatedAliasedFieldImpl(getIndex(), getConsumer(), function(), name(), alias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AggregateDistinctNameAware distinct(boolean distinct) {
        return new AggregateDistinctNameAwareImpl(getIndex(), getConsumer(), distinct, function(), name());
    }
}
