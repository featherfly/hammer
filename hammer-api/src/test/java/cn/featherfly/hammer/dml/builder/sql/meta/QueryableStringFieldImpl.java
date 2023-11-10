
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-10 16:15:10
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dml.builder.sql.meta;

import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * StringFieldImpl.
 *
 * @author zhongj
 */
public class QueryableStringFieldImpl<C extends ConditionExpression, L extends LogicExpression<C, L>> extends FieldImpl
        implements QueryableStringField<C, L>, QueryableStringAliasField<C, L> {

    /**
     * @param name
     */
    public QueryableStringFieldImpl(String name) {
        super(name);
    }

    /**
     * @param name
     */
    public QueryableStringFieldImpl(String name, String alias) {
        super(name, alias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryableStringAliasField<C, L> alias(String alias) {
        return new QueryableStringFieldImpl<>(name(), alias);
    }

}
