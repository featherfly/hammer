
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
 * AggregatedAliasedFieldImpl.
 *
 * @author zhongj
 */
public class AggregatedAliasedFieldImpl extends AbstractFetchField<AggregateFunction>
        implements AggregatedAliasedField {

    /**
     * Instantiates a new named aliased field impl.
     *
     * @param index             the index
     * @param consumer          the consumer
     * @param aggregateFunction the aggregate function
     * @param name              the name
     * @param alias             the alias
     */
    public AggregatedAliasedFieldImpl(int index, BiConsumer<Integer, QueryableField> consumer,
            AggregateFunction aggregateFunction, String name, String alias) {
        super(index, consumer, aggregateFunction, name, alias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AggregateDistinctNameAliasAware distinct(boolean distinct) {
        return new AggregateDistinctNameAliasAwareImpl(getIndex(), getConsumer(), function(), name(), alias(),
                distinct);
    }

}
