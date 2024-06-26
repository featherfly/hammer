
/*
 * All rights Reserved, Designed By zhongj
 * @Title: SqlSortEntity.java
 * @Description: SqlSortEntity
 * @author: zhongj
 * @date: 2023-08-15 18:11:15
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.entity.query.sort;

import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.operator.SortOperator;
import cn.featherfly.common.repository.builder.dml.SortBuilder;
import cn.featherfly.hammer.expression.entity.query.sort.EntitySetSortPropertyExpression;

/**
 * SqlSortEntity.
 *
 * @author zhongj
 * @param <E> the element type
 */
public class EntitySetSqlSortPropertyExpression<E> implements EntitySetSortPropertyExpression<E> {

    private SortBuilder sortBuilder;

    private String queryAlias;

    private SortOperator sortOperator;

    private JdbcClassMapping<E> classMapping;

    /**
     * Instantiates a new sql sort entity.
     *
     * @param sortBuilder  the sort builder
     * @param queryAlias   the query alias
     * @param sortOperator the sort operator
     * @param classMapping the class mapping
     */
    public EntitySetSqlSortPropertyExpression(SortBuilder sortBuilder, String queryAlias, SortOperator sortOperator,
            JdbcClassMapping<E> classMapping) {
        super();
        this.sortBuilder = sortBuilder;
        this.queryAlias = queryAlias;
        this.sortOperator = sortOperator;
        this.classMapping = classMapping;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntitySetSortPropertyExpression<E> property(SerializableFunction<E, ?> t) {
        String name = LambdaUtils.getLambdaPropertyName(t);
        if (sortOperator == SortOperator.ASC) {
            sortBuilder.asc(queryAlias, () -> ClassMappingUtils.getSimpleColumnName(name, classMapping));
        } else {
            sortBuilder.desc(queryAlias, () -> ClassMappingUtils.getSimpleColumnName(name, classMapping));
        }
        return this;
    }
}
