
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import cn.featherfly.common.db.builder.dml.basic.SqlSelectJoinOnBasicBuilder;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.common.lang.function.SerializableFunction3;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.MappingFactory;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.hammer.dsl.query.EntityQueryConditionGroupExpression;
import cn.featherfly.hammer.dsl.query.EntityQueryWith;
import cn.featherfly.hammer.dsl.query.EntityQueryWithEntity;
import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.expression.query.EntityQueryLimitExecutor;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * @author zhongj
 */
public class EntitySqlQueryWith<E> implements EntityQueryWith<E>, EntityQueryWithEntity<E> {

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
    protected MappingFactory factory;

    /** The sql page factory. */
    protected SqlPageFactory sqlPageFactory;

    /** The condition type class mapping. */
    protected ClassMapping<?> conditionTypeClassMapping;

    /** The join type class mapping. */
    protected ClassMapping<?> joinTypeClassMapping;

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
    public EntitySqlQueryWith(EntitySqlQueryEntityProperties<E> sqlQueryEntityProperties, AliasManager aliasManager,
            MappingFactory factory, SqlPageFactory sqlPageFactory, ClassMapping<?> conditionTypeClassMapping,
            String conditionTableAlias, String conditionTableColumn, ClassMapping<?> joinTypeClassMapping,
            String joinTableColumn, Predicate<Object> ignorePolicy) {
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
    public EntitySqlQueryWith(EntitySqlQueryEntityProperties<E> sqlQueryEntityProperties, AliasManager aliasManager,
            MappingFactory factory, SqlPageFactory sqlPageFactory, ClassMapping<?> conditionTypeClassMapping,
            String conditionTableAlias, String conditionTableColumn, ClassMapping<?> joinTypeClassMapping,
            String joinTableColumn, String fetchProperty, Predicate<Object> ignorePolicy) {
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

    private EntityQueryWithEntity<E> on() {
        selectJoinOnBasicBuilder = sqlQueryEntityProperties.getSelectBuilder().join(conditionTableAlias,
                conditionTableColumn, joinTypeClassMapping, joinTableAlias, joinTableColumn);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryWithEntity<E> with(SerializableFunction<E, R> propertyName) {
        return sqlQueryEntityProperties.with(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryWithEntity<E> with(SerializableFunction<E, R> propertyName, int index) {
        return sqlQueryEntityProperties.with(propertyName, index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryWithEntity<E> with(SerializableFunction2<R, E> propertyName) {
        // IMPLSOON Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryWithEntity<E> with(SerializableFunction3<E, E> propertyName) {
        // IMPLSOON Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryWith<E> fetch() {
        if (Lang.isEmpty(fetchProperty)) {
            // ENHANCE 后续细化描述
            throw new SqldbHammerException("can not fetch because there is no relation for find type");
        }
        selectJoinOnBasicBuilder.fetch(fetchProperty, fetchPropertyAlias);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryConditionGroupExpression<E> where() {
        //        return new RepositoryTypeSqlQueryExpression(sqlQueryEntityProperties.jdbc, factory, sqlPageFactory,
        //                sqlQueryEntityProperties.aliasManager, sqlQueryEntityProperties.classMapping,
        //                sqlQueryEntityProperties.selectBuilder, ignorePolicy);
        // IMPLSOON 未实现
        return null;
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
