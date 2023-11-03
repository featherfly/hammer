
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
 * NameAwareImpl.
 *
 * @author zhongj
 */
public class NameAwareImpl extends AbstractFetchField<Function> implements NameAware {

    /**
     * Instantiates a new named field impl.
     *
     * @param index    the index
     * @param consumer the consumer
     * @param name     the name
     */
    public NameAwareImpl(int index, BiConsumer<Integer, QueryableField> consumer, String name) {
        super(index, consumer, name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NameAliaseAware alias(String alias) {
        return new NameAliaseAwareImpl(getIndex(), getConsumer(), name(), alias);
    }
}
