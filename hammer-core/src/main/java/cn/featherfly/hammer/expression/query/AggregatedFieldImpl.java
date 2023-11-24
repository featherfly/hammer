
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
 * NamedFieldImpl.
 *
 * @author zhongj
 */
public class AggregatedFieldImpl extends AbstractFetchField<AggregateFunction> implements AggregatedField {

    /**
     * Instantiates a new named field impl.
     *
     * @param consumer          the consumer
     * @param aggregateFunction the aggregate function
     * @param name              the name
     */
    public AggregatedFieldImpl(Consumer<QueryableField> consumer, AggregateFunction aggregateFunction, String name) {
        super(consumer, aggregateFunction, name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AggregatedAliasedField alias(String alias) {
        return new AggregatedAliasedFieldImpl(getConsumer(), function(), name(), alias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AggregateDistinctNameAware distinct(boolean distinct) {
        return new AggregateDistinctNameAwareImpl(getConsumer(), distinct, function(), name());
    }
}
