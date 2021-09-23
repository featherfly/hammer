
package cn.featherfly.hammer.sqldb.sql.dml;

import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.hammer.dml.BuildableConditionGroupExpression;
import cn.featherfly.hammer.dml.BuildableConditionGroupLogicExpression;
import cn.featherfly.hammer.dsl.query.TypeQueryEntity;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

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
     * @param dialect        dialect
     * @param sqlPageFactory the sql page factory
     */
    public SqlConditionGroupExpressionBuilder(Dialect dialect, SqlPageFactory sqlPageFactory) {
        this(dialect, sqlPageFactory, null, null, null);
    }

    /**
     * Instantiates a new sql condition group expression builder.
     *
     * @param dialect        dialect
     * @param sqlPageFactory the sql page factory
     * @param queryAlias     queryAlias
     */
    public SqlConditionGroupExpressionBuilder(Dialect dialect, SqlPageFactory sqlPageFactory, String queryAlias) {
        this(dialect, sqlPageFactory, queryAlias, null, null);
    }

    /**
     * Instantiates a new sql condition group expression builder.
     *
     * @param dialect        dialect
     * @param sqlPageFactory the sql page factory
     * @param queryAlias     queryAlias
     * @param classMapping   classMapping
     */
    public SqlConditionGroupExpressionBuilder(Dialect dialect, SqlPageFactory sqlPageFactory, String queryAlias,
            ClassMapping<?> classMapping) {
        this(dialect, sqlPageFactory, queryAlias, classMapping, null);
    }

    /**
     * Instantiates a new sql condition group expression builder.
     *
     * @param dialect         dialect
     * @param sqlPageFactory  the sql page factory
     * @param typeQueryEntity the type query entity
     */
    public SqlConditionGroupExpressionBuilder(Dialect dialect, SqlPageFactory sqlPageFactory,
            TypeQueryEntity typeQueryEntity) {
        this(dialect, sqlPageFactory, null, typeQueryEntity);
    }

    /**
     * Instantiates a new sql condition group expression builder.
     *
     * @param dialect         dialect
     * @param sqlPageFactory  the sql page factory
     * @param queryAlias      queryAlias
     * @param typeQueryEntity the type query entity
     */
    public SqlConditionGroupExpressionBuilder(Dialect dialect, SqlPageFactory sqlPageFactory, String queryAlias,
            TypeQueryEntity typeQueryEntity) {
        this(dialect, sqlPageFactory, queryAlias, null, typeQueryEntity);
    }

    /**
     * Instantiates a new sql condition group expression builder.
     *
     * @param dialect         dialect
     * @param sqlPageFactory  the sql page factory
     * @param queryAlias      queryAlias
     * @param classMapping    classMapping
     * @param typeQueryEntity the type query entity
     */
    public SqlConditionGroupExpressionBuilder(Dialect dialect, SqlPageFactory sqlPageFactory, String queryAlias,
            ClassMapping<?> classMapping, TypeQueryEntity typeQueryEntity) {
        this(null, dialect, sqlPageFactory, queryAlias, classMapping, typeQueryEntity);
    }

    /**
     * Instantiates a new sql condition group expression builder.
     *
     * @param dialect         dialect
     * @param parent          parent group
     * @param sqlPageFactory  the sql page factory
     * @param queryAlias      queryAlias
     * @param classMapping    classMapping
     * @param typeQueryEntity the type query entity
     */
    SqlConditionGroupExpressionBuilder(BuildableConditionGroupLogicExpression parent, Dialect dialect,
            SqlPageFactory sqlPageFactory, String queryAlias, ClassMapping<?> classMapping,
            TypeQueryEntity typeQueryEntity) {
        super(parent, dialect, sqlPageFactory, queryAlias, classMapping, typeQueryEntity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BuildableConditionGroupExpression createGroup(BuildableConditionGroupLogicExpression parent,
            String queryAlias, TypeQueryEntity typeQueryEntity) {
        return new SqlConditionGroupExpressionBuilder(parent, dialect, sqlPageFactory, queryAlias, classMapping,
                typeQueryEntity);
    }
    // ********************************************************************
    // property
    // ********************************************************************

}
