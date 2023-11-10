
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-29 10:54:29
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.query;

import java.util.function.BiConsumer;

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
     * @param index    the index
     * @param consumer the consumer
     * @param function the function
     * @param name     the name
     */
    public AggregateNameAwareImpl(int index, BiConsumer<Integer, QueryableField> consumer, AggregateFunction function,
            String name) {
        super(index, consumer, function, name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AggregatedAliasedField alias(String alias) {
        return new AggregatedAliasedFieldImpl(getIndex(), getConsumer(), function(), name(), alias);
    }

}
