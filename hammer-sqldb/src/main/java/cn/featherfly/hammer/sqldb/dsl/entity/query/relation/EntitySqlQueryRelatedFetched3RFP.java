
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntitySqlQueryRelatedFetchedExpression2FF.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query
 * @Description: EntitySqlQueryRelatedFetchedExpression2FF
 * @author: zhongj
 * @date: 2023-07-14 16:04:14
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.entity.query.relation;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableUnaryOperator1;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression4;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate4RFRP;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate4RFRR;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched3RFP;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.dsl.entity.query.AbstractEntitySqlQueryFetch4;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * The Class EntitySqlQueryRelatedFetched3RFF.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> query or joined type
 * @param <R2> query or joined type
 * @param <R3> query or joined type
 */
public class EntitySqlQueryRelatedFetched3RFP<E, R1, R2, R3> extends
    AbstractEntitySqlQueryFetch4<E, R1, R2, R3, Tuple2<E, R2>> implements EntityQueryRelatedFetched3RFP<E, R1, R2, R3> {

    private EntitySqlQueryRelate3RFP<E, R1, R2, R3> proxy;

    /**
     * Instantiates a new entity sql query related fetched 3 RFF.
     *
     * @param entitySqlQueryRelate   the entity sql query relate
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    public EntitySqlQueryRelatedFetched3RFP(EntitySqlQueryRelate3RFP<E, R1, R2, R3> entitySqlQueryRelate,
        JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
        proxy = entitySqlQueryRelate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <J> EntityOnExpression4<E, R1, R2, R3, J, EntityQueryRelate4RFRR<E, R1, R2, R3, J>> join(Class<J> joinType) {
        return proxy.join(joinType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R4> EntityQueryRelate4RFRR<E, R1, R2, R3, R4> join(SerializableFunction2<R4, E> propertyName) {
        return proxy.join(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R4> EntityQueryRelate4RFRP<E, R1, R2, R3, R4> join(SerializableFunction1<E, R4> propertyName) {
        return proxy.join(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelate4RFRP<E, R1, R2, R3, E> join(SerializableUnaryOperator1<E> propertyName) {
        return proxy.join(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R4> EntityQueryRelate4RFRR<E, R1, R2, R3, R4> join2(SerializableFunction2<R4, R1> propertyName) {
        return proxy.join2(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R4> EntityQueryRelate4RFRP<E, R1, R2, R3, R4> join2(SerializableFunction1<R1, R4> propertyName) {
        return proxy.join2(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelate4RFRP<E, R1, R2, R3, R1> join2(SerializableUnaryOperator1<R1> propertyName) {
        return proxy.join2(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R4> EntityQueryRelate4RFRR<E, R1, R2, R3, R4> join3(SerializableFunction2<R4, R2> propertyName) {
        return proxy.join3(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R4> EntityQueryRelate4RFRP<E, R1, R2, R3, R4> join3(SerializableFunction1<R2, R4> propertyName) {
        return proxy.join3(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelate4RFRP<E, R1, R2, R3, R2> join3(SerializableUnaryOperator1<R2> propertyName) {
        return proxy.join3(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R4> EntityQueryRelate4RFRR<E, R1, R2, R3, R4> join4(SerializableFunction2<R4, R3> propertyName) {
        return proxy.join4(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R4> EntityQueryRelate4RFRP<E, R1, R2, R3, R4> join4(SerializableFunction1<R3, R4> propertyName) {
        return proxy.join4(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelate4RFRP<E, R1, R2, R3, R3> join4(SerializableUnaryOperator1<R3> propertyName) {
        return proxy.join4(propertyName);
    }

}
