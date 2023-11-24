
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
 * NameAliaseAwareImpl.
 *
 * @author zhongj
 */
public class NameAliaseAwareImpl extends AbstractFetchField<Function> implements NameAliaseAware {

    /**
     * Instantiates a new named aliased field impl.
     *
     * @param consumer the consumer
     * @param name     the name
     * @param alias    the alias
     */
    public NameAliaseAwareImpl(Consumer<QueryableField> consumer, String name, String alias) {
        super(consumer, name, alias);
    }
}
