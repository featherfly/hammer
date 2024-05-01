
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;

import java.util.List;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.expression.entity.query.EntityQueryConditionLimit;
import cn.featherfly.hammer.expression.entity.query.EntityQueryLimitExecutor;
import cn.featherfly.hammer.expression.query.QueryCountExecutor;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.query.RepositorySqlQueryValueExpression;

/**
 * abstract entity sql query entity properties.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <L> the generic type
 */
public abstract class AbstractEntitySqlQueryBase<E, L>
        implements EntityQueryConditionLimit<L>, EntityQueryLimitExecutor<E>, QueryCountExecutor {

    /** The factory. */
    protected final JdbcMappingFactory factory;

    /** The sql page factory. */
    protected final SqlPageFactory sqlPageFactory;

    /** The query relation. */
    protected final EntitySqlQueryRelation queryRelation;

    /** The limit. */
    protected Limit limit;

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    protected AbstractEntitySqlQueryBase(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        //        this(factory, sqlPageFactory, entitySqlQueryRelation, null);
        AssertIllegalArgument.isNotNull(entitySqlQueryRelation, "entitySqlQueryRelation");
        queryRelation = entitySqlQueryRelation;
        this.factory = factory;
        this.sqlPageFactory = sqlPageFactory;
    }

    //    /**
    //     * Instantiates a new abstract sql query entity properties.
    //     *
    //     * @param <E>                    the element type
    //     * @param factory                the factory
    //     * @param sqlPageFactory         the sql page factory
    //     * @param entitySqlQueryRelation the entity sql query relation
    //     */
    //    protected AbstractEntitySqlQuery(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
    //            EntitySqlQueryRelation entitySqlQueryRelation, Class<E> valueType) {
    //        AssertIllegalArgument.isNotNull(entitySqlQueryRelation, "entitySqlQueryRelation");
    //        queryRelation = entitySqlQueryRelation;
    //        this.factory = factory;
    //        this.sqlPageFactory = sqlPageFactory;
    //        //        this.valueType = valueType;
    //    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L limit(Limit limit) {
        this.limit = limit;
        return (L) this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<E> list() {
        return new EntitySqlQueryExpression<E>(factory, sqlPageFactory, queryRelation).limit(limit).list();
        //        if (valueType != null) {
        //            return new EntitySqlQueryValueExpression<>(factory, sqlPageFactory, queryRelation, valueType).limit(limit)
        //                    .list();
        //        } else {
        //            return new EntitySqlQueryExpression<V>(factory, sqlPageFactory, queryRelation).limit(limit).list();
        //        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E single() {
        return new EntitySqlQueryExpression<E>(factory, sqlPageFactory, queryRelation).limit(limit).single();
        //        if (valueType != null) {
        //            return new EntitySqlQueryValueExpression<>(factory, sqlPageFactory, queryRelation, valueType).limit(limit)
        //                    .single();
        //        } else {
        //            return new EntitySqlQueryExpression<V>(factory, sqlPageFactory, queryRelation).limit(limit).single();
        //        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E unique() {
        return new EntitySqlQueryExpression<E>(factory, sqlPageFactory, queryRelation).limit(limit).unique();
        //        if (valueType != null) {
        //            return new EntitySqlQueryValueExpression<>(factory, sqlPageFactory, queryRelation, valueType).limit(limit)
        //                    .unique();
        //        } else {
        //            return new EntitySqlQueryExpression<V>(factory, sqlPageFactory, queryRelation).limit(limit).unique();
        //        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<E> pagination() {
        return new EntitySqlQueryExpression<E>(factory, sqlPageFactory, queryRelation).limit(limit).pagination();
        //        if (valueType != null) {
        //            return new EntitySqlQueryValueExpression<>(factory, sqlPageFactory, queryRelation, valueType).limit(limit)
        //                    .pagination();
        //        } else {
        //            return new EntitySqlQueryExpression<V>(factory, sqlPageFactory, queryRelation).limit(limit).pagination();
        //        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long count() {
        return new RepositorySqlQueryValueExpression(new RepositorySqlQueryRelation(queryRelation.getJdbc(),
                new AliasManager(), factory.getMetadata(), queryRelation.getConfig())
                        .query(queryRelation.getEntityRelationMapping(0).getClassMapping().getRepositoryName())
                        .fetch(0),
                sqlPageFactory).count();
    }
}
