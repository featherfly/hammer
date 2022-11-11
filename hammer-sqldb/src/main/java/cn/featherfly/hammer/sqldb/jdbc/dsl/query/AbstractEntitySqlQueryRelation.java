
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.common.db.builder.dml.basic.SqlSelectJoinOnBasicBuilder;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.hammer.dsl.query.type.EntityQueryConditionGroupExpression;
import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.expression.query.type.EntityQueryLimitExecutor;
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

    /** The condition type class mapping. */
    protected JdbcClassMapping<E> conditionTypeClassMapping;

    /** The join type class mapping. */
    protected JdbcClassMapping<R1> joinTypeClassMapping;

    /** The fetch property. */
    protected String fetchProperty;

    /** The fetch property alias. */
    protected String fetchPropertyAlias;

    /** The ignore policy. */
    protected Predicate<Object> ignorePolicy;

    /**
     * Instantiates a new type sql query with.
     *
     * @param sqlQueryEntityProperties  the sql query entity properties
     * @param aliasManager              the alias manager
     * @param factory                   the factory
     * @param sqlPageFactory            the sql page factory
     * @param conditionTypeClassMapping the condition type class mapping
     * @param conditionTableAlias       the condition table alias
     * @param conditionTableColumn      the condition table column
     * @param joinTypeClassMapping      the join type class mapping
     * @param joinTableColumn           the join table column
     * @param ignorePolicy              the ignore policy
     */
    public AbstractEntitySqlQueryRelation(EntitySqlQueryEntityProperties<E> sqlQueryEntityProperties,
            AliasManager aliasManager, JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            JdbcClassMapping<E> conditionTypeClassMapping, String conditionTableAlias, String conditionTableColumn,
            JdbcClassMapping<R1> joinTypeClassMapping, String joinTableColumn, Predicate<Object> ignorePolicy) {
        this(sqlQueryEntityProperties, aliasManager, factory, sqlPageFactory, conditionTypeClassMapping,
                conditionTableAlias, conditionTableColumn, joinTypeClassMapping, joinTableColumn, null, ignorePolicy);
    }

    /**
     * Instantiates a new type sql query with.
     *
     * @param sqlQueryEntityProperties  the sql query entity properties
     * @param aliasManager              the alias manager
     * @param factory                   the factory
     * @param sqlPageFactory            the sql page factory
     * @param conditionTypeClassMapping the condition type class mapping
     * @param conditionTableAlias       the condition table alias
     * @param conditionTableColumn      the condition table column
     * @param joinTypeClassMapping      the join type class mapping
     * @param joinTableColumn           the join table column
     * @param fetchProperty             the fetch property
     * @param ignorePolicy              the ignore policy
     */
    public AbstractEntitySqlQueryRelation(EntitySqlQueryEntityProperties<E> sqlQueryEntityProperties,
            AliasManager aliasManager, JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            JdbcClassMapping<E> conditionTypeClassMapping, String conditionTableAlias, String conditionTableColumn,
            JdbcClassMapping<R1> joinTypeClassMapping, String joinTableColumn, String fetchProperty,
            Predicate<Object> ignorePolicy) {
        super();
        this.sqlQueryEntityProperties = sqlQueryEntityProperties;
        this.factory = factory;
        this.sqlPageFactory = sqlPageFactory;
        this.conditionTypeClassMapping = conditionTypeClassMapping;
        this.conditionTableAlias = conditionTableAlias;
        this.conditionTableColumn = conditionTableColumn;
        joinTableAlias = aliasManager.put(joinTypeClassMapping.getRepositoryName());
        this.joinTableColumn = joinTableColumn;
        this.joinTypeClassMapping = joinTypeClassMapping;
        this.fetchProperty = fetchProperty;
        fetchPropertyAlias = joinTableAlias;
        AssertIllegalArgument.isNotNull(ignorePolicy, "ignorePolicy");
        this.ignorePolicy = ignorePolicy;
        on();
    }

    private AbstractEntitySqlQueryRelation<E, R1, R2> on() {
        selectJoinOnBasicBuilder = sqlQueryEntityProperties.getSelectBuilder().join(conditionTableAlias,
                conditionTableColumn, joinTypeClassMapping, joinTableAlias, joinTableColumn);
        return this;
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <RE extends EntityQueryRelationEntityExpression2<E, R1, R2, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
    //            R2> RE join(SerializableFunction<E, R2> propertyName, int index) {
    //        return sqlQueryEntityProperties.join(propertyName, index);
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <RE extends EntityQueryRelationEntityExpression2<E, R1, R2, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
    //            QR extends EntityQueryRelationExpression2<E, R1, R2, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
    //            R2> RE join(SerializableFunction2<R2, E> propertyName) {
    //        // IMPLSOON Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <RE extends EntityQueryRelationEntityExpression2<E, R1, R2, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
    //            QR extends EntityQueryRelationExpression2<E, R1, R2, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
    //            R2> RE join(SerializableFunction<E, R2> propertyName) {
    //        return sqlQueryEntityProperties.join(propertyName);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <RE extends EntityQueryRelationEntityExpression2<E, R1, E, EntityQueryEntityProperties<E>, QR, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>,
    //            QR extends EntityQueryRelationExpression2<E, R1, E, EntityQueryEntityProperties<E>, EntityQueryConditionGroupExpression<E>, EntityQueryConditionGroupLogicExpression<E>>> RE join(
    //                    SerializableFunction3<E, E> propertyName) {
    //        // IMPLSOON Auto-generated method stub
    //        return null;
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public AbstractEntitySqlQueryRelation<E, R1> fetch() {
    //        if (Lang.isEmpty(fetchProperty)) {
    //            // ENHANCE 后续细化描述
    //            throw new SqldbHammerException("can not fetch because there is no relation for find type");
    //        }
    //        selectJoinOnBasicBuilder.fetch(fetchProperty, fetchPropertyAlias);
    //        return this;
    //    }
    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroupExpression<E> where() {
        // IMPLSOON 未实现
        //        return new RepositoryTypeSqlQueryExpression(sqlQueryEntityProperties.jdbc, factory, sqlPageFactory,
        //                sqlQueryEntityProperties.aliasManager, sqlQueryEntityProperties.classMapping,
        //                sqlQueryEntityProperties.selectBuilder, ignorePolicy);

        //        Jdbc jdbc, JdbcClassMapping<E> classMapping, EntityQuery<E> entityQueryEntity,
        //        JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, AliasManager aliasManager,
        //        SqlSelectBasicBuilder selectBuilder, Predicate<Object> ignorePolicy

        return new EntitySqlQueryExpression<>(sqlQueryEntityProperties.jdbc, sqlQueryEntityProperties.classMapping,
                this, factory, sqlPageFactory, sqlQueryEntityProperties.aliasManager,
                sqlQueryEntityProperties.selectBuilder, ignorePolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroupExpression<E> where(
            Consumer<ConditionGroupConfig<EntityQueryConditionGroupExpression<E>>> consumer) {
        //        RepositoryTypeSqlQueryExpression repositorySqlQueryExpression = new RepositoryTypeSqlQueryExpression(
        //                sqlQueryEntityProperties.jdbc, factory, sqlPageFactory, sqlQueryEntityProperties.aliasManager,
        //                sqlQueryEntityProperties.classMapping, sqlQueryEntityProperties.selectBuilder, ignorePolicy);
        //        if (consumer != null) {
        //            consumer.accept(repositorySqlQueryExpression);
        //        }
        //        return repositorySqlQueryExpression;
        // IMPLSOON 未实现
        return null;
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
}
