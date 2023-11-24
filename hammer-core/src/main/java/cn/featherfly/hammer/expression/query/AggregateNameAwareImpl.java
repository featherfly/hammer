
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-29 10:54:29
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.query;

import java.util.function.Consumer;

import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.QueryableField;

/**
 * AggregateNameAwareImpl.
 *
 * @author zhongj
 */
public class AggregateNameAwareImpl extends AbstractFetchField<AggregateFunction> implements AggregateNameAware {

    /**
     * Instantiates a new aggregate name aware impl.
     *
     * @param consumer the consumer
     * @param function the function
     * @param name     the name
     */
    public AggregateNameAwareImpl(Consumer<QueryableField> consumer, AggregateFunction function, String name) {
        super(consumer, function, name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AggregatedAliasedField alias(String alias) {
        return new AggregatedAliasedFieldImpl(getConsumer(), function(), name(), alias);
    }

}
