
package cn.featherfly.juorm.sql.dml;

import cn.featherfly.juorm.dml.BuildableConditionGroupExpression;
import cn.featherfly.juorm.dml.BuildableConditionGroupLogicExpression;
import cn.featherfly.juorm.sql.dialect.Dialect;

/**
 * <p>
 * sql condition group builder sql条件逻辑组构造器
 * </p>
 *
 * @author zhongj
 */
public class SqlConditionGroupExpressionBuilder extends
        AbstractSqlConditionGroupExpression<BuildableConditionGroupExpression, BuildableConditionGroupLogicExpression>
        implements BuildableConditionGroupExpression,
        BuildableConditionGroupLogicExpression {

    /**
     * @param dialect
     *            dialect
     */
    public SqlConditionGroupExpressionBuilder(Dialect dialect) {
        this(dialect, null);
    }

    /**
     * @param dialect
     *            dialect
     * @param queryAlias
     *            queryAlias
     */
    public SqlConditionGroupExpressionBuilder(Dialect dialect,
            String queryAlias) {
        this(dialect, null, queryAlias);
    }

    /**
     * @param dialect
     *            dialect
     * @param parent
     *            parent group
     * @param queryAlias
     *            queryAlias
     */
    SqlConditionGroupExpressionBuilder(Dialect dialect,
            BuildableConditionGroupLogicExpression parent, String queryAlias) {
        super(dialect, parent, queryAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BuildableConditionGroupExpression createGroup(
            BuildableConditionGroupLogicExpression parent, String queryAlias) {
        return new SqlConditionGroupExpressionBuilder(dialect, parent,
                queryAlias);
    }

    // ********************************************************************
    // property
    // ********************************************************************

}
