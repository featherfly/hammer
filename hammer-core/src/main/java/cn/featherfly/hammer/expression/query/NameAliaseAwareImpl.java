
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
 * NameAliaseAwareImpl.
 *
 * @author zhongj
 */
public class NameAliaseAwareImpl extends AbstractFetchField<Function> implements NameAliaseAware {

    /**
     * Instantiates a new named aliased field impl.
     *
     * @param index    the index
     * @param consumer the consumer
     * @param name     the name
     * @param alias    the alias
     */
    public NameAliaseAwareImpl(int index, BiConsumer<Integer, QueryableField> consumer, String name, String alias) {
        super(index, consumer, name, alias);
    }
}
