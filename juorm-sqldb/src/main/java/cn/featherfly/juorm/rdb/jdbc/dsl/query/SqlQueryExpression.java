
package cn.featherfly.juorm.rdb.jdbc.dsl.query;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.juorm.dsl.query.QueryConditionGroupExpression;
import cn.featherfly.juorm.dsl.query.QueryConditionGroupLogicExpression;
import cn.featherfly.juorm.rdb.jdbc.Jdbc;
import cn.featherfly.juorm.rdb.jdbc.mapping.ClassMapping;
import cn.featherfly.juorm.rdb.sql.dml.builder.basic.SqlSelectBasicBuilder;

/**
 * <p>
 * SqlDeleteExpression
 * </p>
 *
 * @author zhongj
 */
public class SqlQueryExpression extends SqlQueryConditionGroupExpression {

    private SqlSelectBasicBuilder selectBuilder;

    /**
     * @param jdbc
     * @param selectBuilder
     */
    public SqlQueryExpression(Jdbc jdbc, SqlSelectBasicBuilder selectBuilder) {
        super(jdbc, selectBuilder.getTableAlias());
        this.selectBuilder = selectBuilder;
    }

    /**
     * @param jdbc
     * @param classMapping
     * @param selectBuilder
     */
    public SqlQueryExpression(Jdbc jdbc, ClassMapping<?> classMapping, SqlSelectBasicBuilder selectBuilder) {
        super(jdbc, selectBuilder.getTableAlias(), classMapping);
        this.selectBuilder = selectBuilder;
    }

    /**
     * @param jdbc
     * @param parent
     * @param queryAlias
     * @param classMapping
     */
    SqlQueryExpression(Jdbc jdbc, QueryConditionGroupLogicExpression parent, String queryAlias,
            ClassMapping<?> classMapping) {
        super(jdbc, parent, queryAlias, classMapping);
    }

    /**
     * @param jdbc
     * @param queryAlias
     */
    public SqlQueryExpression(Jdbc jdbc, String queryAlias) {
        super(jdbc, queryAlias);
    }

    /**
     * @param jdbc
     */
    public SqlQueryExpression(Jdbc jdbc) {
        super(jdbc);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected QueryConditionGroupExpression createGroup(QueryConditionGroupLogicExpression parent, String queryAlias) {
        selectBuilder.setTableAlias(queryAlias);
        return new SqlQueryExpression(jdbc, parent, queryAlias, classMapping);
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
            //            result = result + Chars.SPACE + jdbc.getDialect().getKeywords().where() + Chars.SPACE + condition;
            result = result + Chars.SPACE + condition;
        }
        return result;
    }
}