
package cn.featherfly.juorm.jdbc.dsl.query;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.juorm.dsl.query.QueryConditionGroupExpression;
import cn.featherfly.juorm.dsl.query.QueryConditionGroupLogicExpression;
import cn.featherfly.juorm.jdbc.Jdbc;
import cn.featherfly.juorm.sql.dml.builder.basic.SqlSelectBasicBuilder;

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
     * @param tableName
     */
    public SqlQueryExpression(Jdbc jdbc, String tableName, SqlSelectBasicBuilder selectBuilder) {
        super(jdbc, selectBuilder.getTableAlias());
        this.selectBuilder = selectBuilder;
    }

    /**
     * @param jdbc
     * @param parent
     * @param queryAlias
     */
    SqlQueryExpression(Jdbc jdbc, QueryConditionGroupLogicExpression parent, String queryAlias) {
        super(jdbc, parent, queryAlias);
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
        return new SqlQueryExpression(jdbc, parent, queryAlias);
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
            result = result + Chars.SPACE + jdbc.getDialect().getKeywords().where() + Chars.SPACE + condition;
        }
        return result;
    }
}
