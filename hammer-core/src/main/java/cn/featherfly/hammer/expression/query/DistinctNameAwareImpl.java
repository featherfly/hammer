
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-21 13:32:21
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.query;

import java.util.function.BiConsumer;

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
     * @param index    the index
     * @param consumer the consumer
     * @param name     the name
     * @param distinct the distinct
     */
    public DistinctNameAwareImpl(int index, BiConsumer<Integer, QueryableField> consumer, String name,
            boolean distinct) {
        super(index, consumer, name, distinct);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DistinctNameAliaseAware alias(String alias) {
        return new DistinctNamAliasAwareImpl(getIndex(), getConsumer(), name(), alias, isDistinct());
    }

}
