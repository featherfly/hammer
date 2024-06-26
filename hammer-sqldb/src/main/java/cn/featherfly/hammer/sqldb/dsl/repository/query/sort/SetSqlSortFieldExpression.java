
/*
 * All rights Reserved, Designed By zhongj
 * @Title: SqlSortEntity.java
 * @Description: SqlSortEntity
 * @author: zhongj
 * @date: 2023-08-15 18:11:15
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.repository.query.sort;

import cn.featherfly.common.operator.SortOperator;
import cn.featherfly.common.repository.builder.dml.SortBuilder;
import cn.featherfly.hammer.expression.query.sort.SetSortFieldExpression;

/**
 * SqlSortEntity.
 *
 * @author zhongj
 */
public class SetSqlSortFieldExpression implements SetSortFieldExpression {

    private SortBuilder sortBuilder;

    private String queryAlias;

    private SortOperator sortOperator;

    /**
     * Instantiates a new sql sort entity.
     *
     * @param sortBuilder  the sort builder
     * @param queryAlias   the query alias
     * @param sortOperator the sort operator
     */
    public SetSqlSortFieldExpression(SortBuilder sortBuilder, String queryAlias, SortOperator sortOperator) {
        super();
        this.sortBuilder = sortBuilder;
        this.queryAlias = queryAlias;
        this.sortOperator = sortOperator;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SetSortFieldExpression field(String field) {
        if (sortOperator == SortOperator.ASC) {
            sortBuilder.asc(queryAlias, () -> field);
        } else {
            sortBuilder.desc(queryAlias, () -> field);
        }
        return this;
    }
}
