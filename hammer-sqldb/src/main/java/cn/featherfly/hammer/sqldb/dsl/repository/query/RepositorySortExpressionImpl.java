
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2025-03-15 21:59:15
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import cn.featherfly.common.repository.builder.dml.SortBuilder;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortExpression;
import cn.featherfly.hammer.expression.repository.query.sort.RepositorySortedExpression;

/**
 * RepositorySortExpressionImpl.
 *
 * @author zhongj
 */
public class RepositorySortExpressionImpl<S extends RepositorySortedExpression<S>>
    implements RepositorySortExpression<S>, RepositorySortedExpression<S> {

    private final String tableAlias;

    private final SortBuilder sortBuilder;

    /**
     * Instantiates a new repository sort expression impl.
     *
     * @param tableAlias the table alias
     * @param sortBuilder the sort builder
     */
    public RepositorySortExpressionImpl(String tableAlias, SortBuilder sortBuilder) {
        super();
        this.tableAlias = tableAlias;
        this.sortBuilder = sortBuilder;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public S asc(String... names) {
        sortBuilder.asc(tableAlias, () -> names);
        return (S) this;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public S desc(String... names) {
        sortBuilder.desc(tableAlias, () -> names);
        return (S) this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        return sortBuilder.build();
    }

}
