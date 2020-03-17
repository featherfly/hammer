
package cn.featherfly.hammer.sqldb.sql.dml;

import cn.featherfly.hammer.dml.BuildableConditionGroupExpression;
import cn.featherfly.hammer.dml.BuildableConditionGroupLogicExpression;
import cn.featherfly.hammer.mapping.ClassMapping;
import cn.featherfly.hammer.sqldb.sql.dialect.Dialect;

/**
 * <p>
 * sql condition group builder sql条件逻辑组构造器
 * </p>
 *
 * @author zhongj
 */
public class SqlConditionGroupExpressionBuilder extends
        AbstractSqlConditionGroupExpression<BuildableConditionGroupExpression, BuildableConditionGroupLogicExpression>
        implements BuildableConditionGroupExpression, BuildableConditionGroupLogicExpression {

    /**
     * @param dialect dialect
     */
    public SqlConditionGroupExpressionBuilder(Dialect dialect) {
        this(dialect, null);
    }

    /**
     * @param dialect    dialect
     * @param queryAlias queryAlias
     */
    public SqlConditionGroupExpressionBuilder(Dialect dialect, String queryAlias) {
        this(dialect, queryAlias, null);
    }

    /**
     * @param dialect      dialect
     * @param queryAlias   queryAlias
     * @param classMapping classMapping
     */
    public SqlConditionGroupExpressionBuilder(Dialect dialect, String queryAlias, ClassMapping<?> classMapping) {
        this(dialect, null, queryAlias, classMapping);
    }

    /**
     * @param dialect      dialect
     * @param parent       parent group
     * @param queryAlias   queryAlias
     * @param classMapping classMapping
     */
    SqlConditionGroupExpressionBuilder(Dialect dialect, BuildableConditionGroupLogicExpression parent,
            String queryAlias, ClassMapping<?> classMapping) {
        super(dialect, parent, queryAlias, classMapping);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BuildableConditionGroupExpression createGroup(BuildableConditionGroupLogicExpression parent,
            String queryAlias) {
        return new SqlConditionGroupExpressionBuilder(dialect, parent, queryAlias, classMapping);
    }

    // ********************************************************************
    // property
    // ********************************************************************

}
