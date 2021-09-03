
package cn.featherfly.hammer.sqldb.sql.dml;

import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.hammer.dml.BuildableConditionGroupExpression;
import cn.featherfly.hammer.dml.BuildableConditionGroupLogicExpression;
import cn.featherfly.hammer.dsl.query.TypeQueryEntity;

/**
 * <p>
 * sql condition group builder sql条件逻辑组构造器
 * </p>
 * .
 *
 * @author zhongj
 */
public class SqlConditionGroupExpressionBuilder extends
        AbstractSqlConditionGroupExpression<BuildableConditionGroupExpression, BuildableConditionGroupLogicExpression>
        implements BuildableConditionGroupExpression, BuildableConditionGroupLogicExpression {

    /**
     * Instantiates a new sql condition group expression builder.
     *
     * @param dialect dialect
     */
    public SqlConditionGroupExpressionBuilder(Dialect dialect) {
        this(dialect, null, null, null);
    }

    /**
     * Instantiates a new sql condition group expression builder.
     *
     * @param dialect    dialect
     * @param queryAlias queryAlias
     */
    public SqlConditionGroupExpressionBuilder(Dialect dialect, String queryAlias) {
        this(dialect, queryAlias, null, null);
    }

    /**
     * Instantiates a new sql condition group expression builder.
     *
     * @param dialect      dialect
     * @param queryAlias   queryAlias
     * @param classMapping classMapping
     */
    public SqlConditionGroupExpressionBuilder(Dialect dialect, String queryAlias, ClassMapping<?> classMapping) {
        this(dialect, queryAlias, classMapping, null);
    }

    /**
     * Instantiates a new sql condition group expression builder.
     *
     * @param dialect         dialect
     * @param typeQueryEntity the type query entity
     */
    public SqlConditionGroupExpressionBuilder(Dialect dialect, TypeQueryEntity typeQueryEntity) {
        this(dialect, null, typeQueryEntity);
    }

    /**
     * Instantiates a new sql condition group expression builder.
     *
     * @param dialect         dialect
     * @param queryAlias      queryAlias
     * @param typeQueryEntity the type query entity
     */
    public SqlConditionGroupExpressionBuilder(Dialect dialect, String queryAlias, TypeQueryEntity typeQueryEntity) {
        this(dialect, queryAlias, null, typeQueryEntity);
    }

    /**
     * Instantiates a new sql condition group expression builder.
     *
     * @param dialect         dialect
     * @param queryAlias      queryAlias
     * @param classMapping    classMapping
     * @param typeQueryEntity the type query entity
     */
    public SqlConditionGroupExpressionBuilder(Dialect dialect, String queryAlias, ClassMapping<?> classMapping,
            TypeQueryEntity typeQueryEntity) {
        this(dialect, null, queryAlias, classMapping, typeQueryEntity);
    }

    /**
     * Instantiates a new sql condition group expression builder.
     *
     * @param dialect         dialect
     * @param parent          parent group
     * @param queryAlias      queryAlias
     * @param classMapping    classMapping
     * @param typeQueryEntity the type query entity
     */
    SqlConditionGroupExpressionBuilder(Dialect dialect, BuildableConditionGroupLogicExpression parent,
            String queryAlias, ClassMapping<?> classMapping, TypeQueryEntity typeQueryEntity) {
        super(dialect, parent, queryAlias, classMapping, typeQueryEntity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BuildableConditionGroupExpression createGroup(BuildableConditionGroupLogicExpression parent,
            String queryAlias, TypeQueryEntity typeQueryEntity) {
        return new SqlConditionGroupExpressionBuilder(dialect, parent, queryAlias, classMapping, typeQueryEntity);
    }
    // ********************************************************************
    // property
    // ********************************************************************

}
