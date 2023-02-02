
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import cn.featherfly.common.db.builder.dml.basic.SqlSelectJoinOnBasicBuilder;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroupExpression;
import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.expression.query.type.EntityQueryLimitExecutor;

/**
 * The Class AbstractEntitySqlQueryRelation.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 */
public class AbstractEntitySqlQueryRelation<E, R1, R2> implements EntitySqlQuery<E> {

    /** The relation part. */
    protected EntitySqlQueryRelationPart<R1, R2> relationPart;

    /** The relation parts. */
    protected List<EntitySqlQueryRelationPart<?, ?>> relationParts = new ArrayList<>(0);

    /** The sql query entity properties. */
    protected EntitySqlQueryEntityProperties<E> sqlQueryEntityProperties;

    //    /** The condition table alias. */
    //    protected String conditionTableAlias;
    //
    //    /** The condition table column. */
    //    protected String conditionTableColumn;
    //
    //    /** The join table alias. */
    //    protected String joinTableAlias;
    //
    //    /** The join table column. */
    //    protected String joinTableColumn;

    /** The select join on basic builder. */
    protected SqlSelectJoinOnBasicBuilder selectJoinOnBasicBuilder;

    /** The factory. */
    protected JdbcMappingFactory factory;

    /**
     * The sql page factory.
     *
     * @param sqlQueryEntityProperties  the sql query entity properties
     * @param conditionTypeClassMapping the condition type class mapping
     * @param conditionTableAlias       the condition table alias
     * @param conditionTableColumn      the condition table column
     * @param joinTypeClassMapping      the join type class mapping
     * @param joinTableColumn           the join table column
     * @param fetchProperty             the fetch property
     * @param relationParts             the relation parts
     */
    //    protected SqlPageFactory sqlPageFactory;

    /** The alias manager. */
    //    protected AliasManager aliasManager;

    /** The condition type class mapping. */
    //    protected JdbcClassMapping<R1> conditionTypeClassMapping;

    /** The join type class mapping. */
    //    protected JdbcClassMapping<R2> joinTypeClassMapping;

    //    /** The fetch property. */
    //    protected String fetchProperty;

    /** The ignore policy. */
    //    protected Predicate<Object> ignorePolicy;

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
     * <pre>
     * <code>
     *  select * from user u join userinfo ui on u.id = ui.user_id
     *  conditionTypeClassMapping&lt;UserInfo&gt;
     *  joinTypeClassMapping&lt;User&gt;
     * </code>
     * </pre>
     *
     * @param sqlQueryEntityProperties  the sql query entity properties
     * @param conditionTypeClassMapping the condition type class mapping
     * @param conditionTableAlias       the condition table alias
     * @param conditionTableColumn      the condition table column
     * @param joinTypeClassMapping      the join type class mapping
     * @param joinTableColumn           the join table column
     * @param fetchProperty             the query object fetch property
     * @param relationParts             relation parts
     */
    public AbstractEntitySqlQueryRelation(EntitySqlQueryEntityProperties<E> sqlQueryEntityProperties,
            JdbcClassMapping<R1> conditionTypeClassMapping, String conditionTableAlias, String conditionTableColumn,
            JdbcClassMapping<R2> joinTypeClassMapping, String joinTableColumn, String fetchProperty,
            List<EntitySqlQueryRelationPart<?, ?>> relationParts) {
        super();
        AssertIllegalArgument.isNotNull(sqlQueryEntityProperties, "sqlQueryEntityProperties");
        //        AssertIllegalArgument.isNotNull(ignorePolicy, "ignorePolicy");
        this.sqlQueryEntityProperties = sqlQueryEntityProperties;
        relationPart = new EntitySqlQueryRelationPart<>(sqlQueryEntityProperties.getSelectBuilder(),
                conditionTypeClassMapping, conditionTableAlias, conditionTableColumn, joinTypeClassMapping,
                joinTableColumn, sqlQueryEntityProperties.aliasManager.put(joinTypeClassMapping.getRepositoryName()),
                fetchProperty);
        this.relationParts = relationParts;
        this.relationParts.add(relationPart);
        factory = this.sqlQueryEntityProperties.factory;
        //        sqlPageFactory = this.sqlQueryEntityProperties.sqlPageFactory;
        //        aliasManager = this.sqlQueryEntityProperties.aliasManager;
        //        this.conditionTypeClassMapping = conditionTypeClassMapping;
        //        this.conditionTableAlias = conditionTableAlias;
        //        this.conditionTableColumn = conditionTableColumn;
        //        joinTableAlias = aliasManager.put(joinTypeClassMapping.getRepositoryName());
        //        this.joinTableColumn = joinTableColumn;
        //        this.joinTypeClassMapping = joinTypeClassMapping;
        //        this.fetchProperty = fetchProperty;
        //        fetchProperties = fetchProperties;
        //        fetchProperties.add(fetchProperty);
        //        fetchPropertyAlias = aliasManager.put(fetchProperty);
        //        this.ignorePolicy = ignorePolicy;
        this.sqlQueryEntityProperties.sqlQueryRelations.add(this);
        //        on();
    }

    //    private AbstractEntitySqlQueryRelation<E, R1, R2> on() {
    //        selectJoinOnBasicBuilder = sqlQueryEntityProperties.getSelectBuilder().join(conditionTableAlias,
    //                conditionTableColumn, joinTypeClassMapping, joinTableAlias, joinTableColumn);
    //        return this;
    //    }

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

    /**
     * Fetch property.
     *
     * @param index         the index
     * @param fetchProperty the fetch property
     * @return the string
     */
    protected String fetchProperty(int index, String fetchProperty) {
        String fp = relationParts.get(index - 1).fetchProperty;
        return fp == null ? null : fp + "." + fetchProperty;
    }

    /**
     * Fetch 0.
     */
    protected void fetch0() {
        relationPart.fetch();
        //        if (Lang.isEmpty(fetchProperty)) {
        //            // ENHANCE 后续细化描述
        //            throw new SqldbHammerException("can not fetch because there is no relation for find type");
        //        }
        //        for (JdbcPropertyMapping pm : joinTypeClassMapping.getPropertyMappings()) {
        //            if (pm.isPrimaryKey()) {
        //                continue; // join表的主键不需要，因为在关联的表中就有外键存在
        //            }
        //            switch (pm.getMode()) {
        //                case EMBEDDED:
        //                    for (JdbcPropertyMapping spm : pm.getPropertyMappings()) {
        //                        selectJoinOnBasicBuilder.addColumn(spm.getRepositoryFieldName(),
        //                                fetchProperty + "." + spm.getPropertyFullName());
        //                    }
        //                    break;
        //                case MANY_TO_ONE:
        //                    for (JdbcPropertyMapping spm : pm.getPropertyMappings()) {
        //                        selectJoinOnBasicBuilder.addColumn(pm.getRepositoryFieldName(),
        //                                fetchProperty + "." + spm.getPropertyFullName());
        //                    }
        //                    break;
        //                default:
        //                    selectJoinOnBasicBuilder.addColumn(pm.getRepositoryFieldName(),
        //                            fetchProperty + "." + pm.getPropertyFullName());
        //            }
        //        }
    }
}
