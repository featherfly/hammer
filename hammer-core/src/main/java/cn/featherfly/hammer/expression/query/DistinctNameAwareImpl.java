
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-21 13:32:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.query;

import java.util.function.Consumer;

import cn.featherfly.common.operator.Function;
import cn.featherfly.common.repository.QueryableField;

/**
 * DistinctNameAwareImpl.
 *
 * @author zhongj
 */
public class DistinctNameAwareImpl extends AbstractFetchField<Function> implements DistinctNameAware {

    /**
     * Instantiates a new named distincted field impl.
     *
     * @param consumer the consumer
     * @param name     the name
     * @param distinct the distinct
     */
    public DistinctNameAwareImpl(Consumer<QueryableField> consumer, String name, boolean distinct) {
        super(consumer, name, distinct);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DistinctNameAliaseAware alias(String alias) {
        return new DistinctNamAliasAwareImpl(getConsumer(), name(), alias, isDistinct());
    }

}
