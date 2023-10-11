
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntitySqlQueryRelatedFetchedExpression2FF.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query
 * @Description: EntitySqlQueryRelatedFetchedExpression2FF
 * @author: zhongj
 * @date: 2023-07-14 16:04:14
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.relation;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableUnaryOperator1;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate4RRRP;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate4RRRR;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedExpression;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched3RRP;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched4RRRF;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.AbstractEntitySqlQueryFetch4;

/**
 * The Class EntitySqlQueryRelatedFetched3RRP.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 * @param <R3> the generic type
 */
public class EntitySqlQueryRelatedFetched3RRP<E, R1, R2, R3> extends AbstractEntitySqlQueryFetch4<E, R1, R2, R3, E>
        implements EntityQueryRelatedFetched3RRP<E, R1, R2, R3> {

    private EntitySqlQueryRelate3RRP<E, R1, R2, R3> proxy;

    /**
     * Instantiates a new entity sql query related fetched 2 FF.
     *
     * @param entitySqlQueryRelate   the entity sql query relate
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    public EntitySqlQueryRelatedFetched3RRP(EntitySqlQueryRelate3RRP<E, R1, R2, R3> entitySqlQueryRelate,
            JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
        proxy = entitySqlQueryRelate;
    }

    @Override
    public <R4> EntityQueryRelatedExpression<E, R4, EntityQueryRelate4RRRR<E, R1, R2, R3, R4>,
            EntityQueryRelatedFetched4RRRF<E, R1, R2, R3, R4>> join(Class<R4> joinType) {
        return proxy.join(joinType);
    }

    @Override
    public <R4> EntityQueryRelate4RRRR<E, R1, R2, R3, R4> join(SerializableFunction2<R4, E> propertyName) {
        return proxy.join(propertyName);
    }

    @Override
    public <R4> EntityQueryRelate4RRRP<E, R1, R2, R3, R4> join(SerializableFunction1<E, R4> propertyName) {
        return proxy.join(propertyName);
    }

    @Override
    public EntityQueryRelate4RRRP<E, R1, R2, R3, E> join(SerializableUnaryOperator1<E> propertyName) {
        return proxy.join(propertyName);
    }

    @Override
    public <R4> EntityQueryRelatedExpression<R1, R4, EntityQueryRelate4RRRR<E, R1, R2, R3, R4>,
            EntityQueryRelatedFetched4RRRF<E, R1, R2, R3, R4>> join2(Class<R4> joinType) {
        return proxy.join2(joinType);
    }

    @Override
    public <R4> EntityQueryRelate4RRRR<E, R1, R2, R3, R4> join2(SerializableFunction2<R4, R1> propertyName) {
        return proxy.join2(propertyName);
    }

    @Override
    public <R4> EntityQueryRelate4RRRP<E, R1, R2, R3, R4> join2(SerializableFunction1<R1, R4> propertyName) {
        return proxy.join2(propertyName);
    }

    @Override
    public EntityQueryRelate4RRRP<E, R1, R2, R3, R1> join2(SerializableUnaryOperator1<R1> propertyName) {
        return proxy.join2(propertyName);
    }

    @Override
    public <R4> EntityQueryRelatedExpression<R2, R4, EntityQueryRelate4RRRR<E, R1, R2, R3, R4>,
            EntityQueryRelatedFetched4RRRF<E, R1, R2, R3, R4>> join3(Class<R4> joinType) {
        return proxy.join3(joinType);
    }

    @Override
    public <R4> EntityQueryRelate4RRRR<E, R1, R2, R3, R4> join3(SerializableFunction2<R4, R2> propertyName) {
        return proxy.join3(propertyName);
    }

    @Override
    public <R4> EntityQueryRelate4RRRP<E, R1, R2, R3, R4> join3(SerializableFunction1<R2, R4> propertyName) {
        return proxy.join3(propertyName);
    }

    @Override
    public EntityQueryRelate4RRRP<E, R1, R2, R3, R2> join3(SerializableUnaryOperator1<R2> propertyName) {
        return proxy.join3(propertyName);
    }

    @Override
    public <R4> EntityQueryRelatedExpression<R3, R4, EntityQueryRelate4RRRR<E, R1, R2, R3, R4>,
            EntityQueryRelatedFetched4RRRF<E, R1, R2, R3, R4>> join4(Class<R4> joinType) {
        return proxy.join4(joinType);
    }

    @Override
    public <R4> EntityQueryRelate4RRRR<E, R1, R2, R3, R4> join4(SerializableFunction2<R4, R3> propertyName) {
        return proxy.join4(propertyName);
    }

    @Override
    public <R4> EntityQueryRelate4RRRP<E, R1, R2, R3, R4> join4(SerializableFunction1<R3, R4> propertyName) {
        return proxy.join4(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelate4RRRP<E, R1, R2, R3, R3> join4(SerializableUnaryOperator1<R3> propertyName) {
        return proxy.join4(propertyName);
    }

}
