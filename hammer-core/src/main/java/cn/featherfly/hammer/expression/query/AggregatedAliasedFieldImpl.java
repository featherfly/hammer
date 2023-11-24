
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
 * AggregatedAliasedFieldImpl.
 *
 * @author zhongj
 */
public class AggregatedAliasedFieldImpl extends AbstractFetchField<AggregateFunction>
        implements AggregatedAliasedField {

    /**
     * Instantiates a new named aliased field impl.
     *
     * @param consumer          the consumer
     * @param aggregateFunction the aggregate function
     * @param name              the name
     * @param alias             the alias
     */
    public AggregatedAliasedFieldImpl(Consumer<QueryableField> consumer, AggregateFunction aggregateFunction,
            String name, String alias) {
        super(consumer, aggregateFunction, name, alias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AggregateDistinctNameAliasAware distinct(boolean distinct) {
        return new AggregateDistinctNameAliasAwareImpl(getConsumer(), function(), name(), alias(), distinct);
    }

}
