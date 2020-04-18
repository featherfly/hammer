
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.operate.AggregateFunction;
import cn.featherfly.hammer.dsl.query.TypeQueryConditionGroupLogicExpression;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * <p>
 * SqlDeleteExpression
 * </p>
 * .
 *
 * @author zhongj
 */
public class TypeSqlQueryExpression extends TypeSqlQueryConditionGroupExpression {

    private SqlSelectBasicBuilder selectBuilder;

    /**
     * Instantiates a new sql query expression.
     *
     * @param jdbc          the jdbc
     * @param classMapping  the class mapping
     * @param selectBuilder the select builder
     */
    public TypeSqlQueryExpression(Jdbc jdbc, ClassMapping<?> classMapping, SqlSelectBasicBuilder selectBuilder) {
        super(jdbc, selectBuilder.getTableAlias(), classMapping);
        this.selectBuilder = selectBuilder;
    }

    /**
     * @param jdbc
     * @param parent
     * @param queryAlias
     * @param classMapping
     */
    TypeSqlQueryExpression(Jdbc jdbc, TypeQueryConditionGroupLogicExpression parent, String queryAlias,
            ClassMapping<?> classMapping) {
        super(jdbc, parent, queryAlias, classMapping);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected TypeSqlQueryConditionGroupExpression createGroup(TypeQueryConditionGroupLogicExpression parent,
            String queryAlias) {
        selectBuilder.setTableAlias(queryAlias);
        return new TypeSqlQueryExpression(jdbc, parent, queryAlias, classMapping);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long count() {
        selectBuilder.addSelectColumn(Chars.STAR, AggregateFunction.COUNT);
        return jdbc.queryLong(getRoot().expression(), getRoot().getParams().toArray());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String build() {
        String result = "";
        if (selectBuilder != null) {
            result = selectBuilder.build();
        }
        String condition = super.build();
        if (LangUtils.isNotEmpty(condition)) {
            result = result + Chars.SPACE + condition;
        }
        return result;
    }
}
