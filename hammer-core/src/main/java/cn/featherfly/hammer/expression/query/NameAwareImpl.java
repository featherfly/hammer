
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
 * NameAwareImpl.
 *
 * @author zhongj
 */
public class NameAwareImpl extends AbstractFetchField<Function> implements NameAware {

    /**
     * Instantiates a new named field impl.
     *
     * @param consumer the consumer
     * @param name     the name
     */
    public NameAwareImpl(Consumer<QueryableField> consumer, String name) {
        super(consumer, name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NameAliaseAware alias(String alias) {
        return new NameAliaseAwareImpl(getConsumer(), name(), alias);
    }
}
