
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

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableUnaryOperator1;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression3;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate3RRP;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate3RRR;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched2RP;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.dsl.entity.query.AbstractEntitySqlQueryFetch3;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * The Class EntitySqlQueryRelatedFetched2RF.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> query or joined type
 * @param <R2> query or joined type
 */
public class EntitySqlQueryRelatedFetched2RP<E, R1, R2> extends AbstractEntitySqlQueryFetch3<E, R1, R2, E>
    implements EntityQueryRelatedFetched2RP<E, R1, R2> {

    private EntitySqlQueryRelate2RP<E, R1, R2> proxy;

    /**
     * Instantiates a new entity sql query related fetched 2 RF.
     *
     * @param entitySqlQueryRelate   the entity sql query relate
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    public EntitySqlQueryRelatedFetched2RP(EntitySqlQueryRelate2RP<E, R1, R2> entitySqlQueryRelate,
        JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
        proxy = entitySqlQueryRelate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <J> EntityOnExpression3<E, R1, R2, J, EntityQueryRelate3RRR<E, R1, R2, J>> join(Class<J> joinType) {
        return proxy.join(joinType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R3> EntityQueryRelate3RRP<E, R1, R2, R3> join(SerializableFunction1<E, R3> propertyName) {
        return proxy.join(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R3> EntityQueryRelate3RRR<E, R1, R2, R3> join(SerializableFunction2<R3, E> propertyName) {
        return proxy.join(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelate3RRP<E, R1, R2, E> join(SerializableUnaryOperator1<E> propertyName) {
        return proxy.join(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R3> EntityQueryRelate3RRP<E, R1, R2, R3> join2(SerializableFunction1<R1, R3> propertyName) {
        return proxy.join2(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R3> EntityQueryRelate3RRR<E, R1, R2, R3> join2(SerializableFunction2<R3, R1> propertyName) {
        return proxy.join2(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelate3RRP<E, R1, R2, R1> join2(SerializableUnaryOperator1<R1> propertyName) {
        return proxy.join2(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R3> EntityQueryRelate3RRP<E, R1, R2, R3> join3(SerializableFunction1<R2, R3> propertyName) {
        return proxy.join3(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R3> EntityQueryRelate3RRR<E, R1, R2, R3> join3(SerializableFunction2<R3, R2> propertyName) {
        return proxy.join3(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelate3RRP<E, R1, R2, R2> join3(SerializableUnaryOperator1<R2> propertyName) {
        return proxy.join3(propertyName);
    }

}
