
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
 * AggregateDistinctNameAliasAwareImpl.
 *
 * @author zhongj
 */
public class AggregateDistinctNameAliasAwareImpl extends AbstractFetchField<AggregateFunction>
        implements AggregateDistinctNameAliasAware {

    /**
     * Instantiates a new named aliased distincted field impl.
     *
     * @param consumer          the consumer
     * @param aggregateFunction the aggregate function
     * @param name              the name
     * @param alias             the alias
     * @param distinct          the distinct
     */
    public AggregateDistinctNameAliasAwareImpl(Consumer<QueryableField> consumer, AggregateFunction aggregateFunction,
            String name, String alias, boolean distinct) {
        super(consumer, aggregateFunction, name, alias, distinct);
    }
}
