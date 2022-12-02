
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.common.db.builder.dml.basic.SqlSelectJoinOnBasicBuilder;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroupExpression;
import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.expression.query.type.EntityQueryLimitExecutor;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * The Class AbstractEntitySqlQueryRelation.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 */
public class AbstractEntitySqlQueryRelation<E, R1, R2> implements EntitySqlQuery<E> {

    /** The sql query entity properties. */
    protected EntitySqlQueryEntityProperties<E> sqlQueryEntityProperties;

    /** The condition table alias. */
    protected String conditionTableAlias;

    /** The condition table column. */
    protected String conditionTableColumn;

    /** The join table alias. */
    protected String joinTableAlias;

    /** The join table column. */
    protected String joinTableColumn;

    /** The select join on basic builder. */
    protected SqlSelectJoinOnBasicBuilder selectJoinOnBasicBuilder;

    /** The factory. */
    protected JdbcMappingFactory factory;

    /** The sql page factory. */
    protected SqlPageFactory sqlPageFactory;

    /** The alias manager. */
    protected AliasManager aliasManager;

    /** The condition type class mapping. */
    protected JdbcClassMapping<R1> conditionTypeClassMapping;

    /** The join type class mapping. */
    protected JdbcClassMapping<R2> joinTypeClassMapping;

    /** The fetch property. */
    protected String fetchProperty;

    /** The ignore policy. */
    protected Predicate<Object> ignorePolicy;

    //    /**
    //     * Instantiates a new type sql query with.
    //     *
    //     * @param sqlQueryEntityProperties  the sql query entity properties
    //     * @param conditionTypeClassMapping the condition type class mapping
    //     * @param conditionTableAlias       the condition table alias
    //     * @param conditionTableColumn      the condition table column
    //     * @param joinTypeClassMapping      the join type class mapping
    //     * @param joinTableColumn           the join table column
    //     * @param ignorePolicy              the ignore policy
    //     */
    //    public AbstractEntitySqlQueryRelation(EntitySqlQueryEntityProperties<E> sqlQueryEntityProperties,
    //            JdbcClassMapping<E> conditionTypeClassMapping, String conditionTableAlias, String conditionTableColumn,
    //            JdbcClassMapping<R1> joinTypeClassMapping, String joinTableColumn, Predicate<Object> ignorePolicy) {
    //        this(sqlQueryEntityProperties, conditionTypeClassMapping, conditionTableAlias, conditionTableColumn,
    //                joinTypeClassMapping, joinTableColumn, null, ignorePolicy);
    //    }

    /**
     * Instantiates a new type sql query with.
     *
     * @param sqlQueryEntityProperties  the sql query entity properties
     * @param conditionTypeClassMapping the condition type class mapping
     * @param conditionTableAlias       the condition table alias
     * @param conditionTableColumn      the condition table column
     * @param joinTypeClassMapping      the join type class mapping
     * @param joinTableColumn           the join table column
     * @param fetchProperty             the fetch property
     * @param ignorePolicy              the ignore policy
     */
    public AbstractEntitySqlQueryRelation(EntitySqlQueryEntityProperties<E> sqlQueryEntityProperties,
            JdbcClassMapping<R1> conditionTypeClassMapping, String conditionTableAlias, String conditionTableColumn,
            JdbcClassMapping<R2> joinTypeClassMapping, String joinTableColumn, String fetchProperty,
            Predicate<Object> ignorePolicy) {
        super();
        AssertIllegalArgument.isNotNull(sqlQueryEntityProperties, "sqlQueryEntityProperties");
        AssertIllegalArgument.isNotNull(ignorePolicy, "ignorePolicy");
        this.sqlQueryEntityProperties = sqlQueryEntityProperties;
        this.factory = this.sqlQueryEntityProperties.factory;
        this.sqlPageFactory = this.sqlQueryEntityProperties.sqlPageFactory;
        this.aliasManager = this.sqlQueryEntityProperties.aliasManager;
        this.conditionTypeClassMapping = conditionTypeClassMapping;
        this.conditionTableAlias = conditionTableAlias;
        this.conditionTableColumn = conditionTableColumn;
        joinTableAlias = aliasManager.put(joinTypeClassMapping.getRepositoryName());
        this.joinTableColumn = joinTableColumn;
        this.joinTypeClassMapping = joinTypeClassMapping;
        this.fetchProperty = fetchProperty;
        //        fetchPropertyAlias = aliasManager.put(fetchProperty);
        this.ignorePolicy = ignorePolicy;
        this.sqlQueryEntityProperties.sqlQueryRelations.add(this);
        on();
    }

    private AbstractEntitySqlQueryRelation<E, R1, R2> on() {
        selectJoinOnBasicBuilder = sqlQueryEntityProperties.getSelectBuilder().join(conditionTableAlias,
                conditionTableColumn, joinTypeClassMapping, joinTableAlias, joinTableColumn);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroupExpression<E> where() {
        return sqlQueryEntityProperties.where();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroupExpression<E> where(
            Consumer<ConditionGroupConfig<EntityQueryConditionGroupExpression<E>>> consumer) {
        return sqlQueryEntityProperties.where(consumer);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<E> list() {
        return sqlQueryEntityProperties.list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long count() {
        return sqlQueryEntityProperties.count();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryLimitExecutor<E> limit(Integer limit) {
        return sqlQueryEntityProperties.limit(limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryLimitExecutor<E> limit(Integer offset, Integer limit) {
        return sqlQueryEntityProperties.limit(offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryLimitExecutor<E> limit(Page page) {
        return sqlQueryEntityProperties.limit(page);
    }

    protected void fetch0() {
        if (Lang.isEmpty(fetchProperty)) {
            // ENHANCE 后续细化描述
            throw new SqldbHammerException("can not fetch because there is no relation for find type");
        }
        for (JdbcPropertyMapping pm : joinTypeClassMapping.getPropertyMappings()) {
            switch (pm.getMode()) {
                case EMBEDDED:
                    for (JdbcPropertyMapping spm : pm.getPropertyMappings()) {
                        selectJoinOnBasicBuilder.addColumn(spm.getRepositoryFieldName(),
                                fetchProperty + "." + spm.getPropertyFullName());
                    }
                    //                case MANY_TO_ONE:
                    //                    selectJoinOnBasicBuilder.addColumn(pm.getRepositoryFieldName(),
                    //                            aliasManager.put(pm.getRepositoryFieldName()));
                default:
                    selectJoinOnBasicBuilder.addColumn(pm.getRepositoryFieldName(),
                            fetchProperty + "." + pm.getPropertyFullName());
            }
        }
    }
}
