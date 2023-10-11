
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

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableUnaryOperator1;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate3FRP;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate3FRR;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedExpression;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched2FP;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched3FRF;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.AbstractEntitySqlQueryFetch3;

/**
 * The Class EntitySqlQueryRelatedFetched2RF.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> the generic type
 * @param <R2> the generic type
 */
public class EntitySqlQueryRelatedFetched2FP<E, R1, R2> extends AbstractEntitySqlQueryFetch3<E, R1, R2, Tuple2<E, R1>>
        implements EntityQueryRelatedFetched2FP<E, R1, R2> {

    private EntitySqlQueryRelate2FP<E, R1, R2> proxy;

    /**
     * Instantiates a new entity sql query related fetched 2 RF.
     *
     * @param entitySqlQueryRelate   the entity sql query relate
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    public EntitySqlQueryRelatedFetched2FP(EntitySqlQueryRelate2FP<E, R1, R2> entitySqlQueryRelate,
            JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
        proxy = entitySqlQueryRelate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R3> EntityQueryRelatedExpression<E, R3, EntityQueryRelate3FRR<E, R1, R2, R3>,
            EntityQueryRelatedFetched3FRF<E, R1, R2, R3>> join(Class<R3> joinType) {
        return proxy.join(joinType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R3> EntityQueryRelate3FRP<E, R1, R2, R3> join(SerializableFunction1<E, R3> propertyName) {
        return proxy.join(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R3> EntityQueryRelate3FRR<E, R1, R2, R3> join(SerializableFunction2<R3, E> propertyName) {
        return proxy.join(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelate3FRP<E, R1, R2, E> join(SerializableUnaryOperator1<E> propertyName) {
        return proxy.join(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R3> EntityQueryRelatedExpression<R1, R3, EntityQueryRelate3FRR<E, R1, R2, R3>,
            EntityQueryRelatedFetched3FRF<E, R1, R2, R3>> join2(Class<R3> joinType) {
        return proxy.join2(joinType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R3> EntityQueryRelate3FRP<E, R1, R2, R3> join2(SerializableFunction1<R1, R3> propertyName) {
        return proxy.join2(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R3> EntityQueryRelate3FRR<E, R1, R2, R3> join2(SerializableFunction2<R3, R1> propertyName) {
        return proxy.join2(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelate3FRP<E, R1, R2, R1> join2(SerializableUnaryOperator1<R1> propertyName) {
        return proxy.join2(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R3> EntityQueryRelatedExpression<R2, R3, EntityQueryRelate3FRR<E, R1, R2, R3>,
            EntityQueryRelatedFetched3FRF<E, R1, R2, R3>> join3(Class<R3> joinType) {
        return proxy.join3(joinType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R3> EntityQueryRelate3FRP<E, R1, R2, R3> join3(SerializableFunction1<R2, R3> propertyName) {
        return proxy.join3(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R3> EntityQueryRelate3FRR<E, R1, R2, R3> join3(SerializableFunction2<R3, R2> propertyName) {
        return proxy.join3(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelate3FRP<E, R1, R2, R2> join3(SerializableUnaryOperator1<R2> propertyName) {
        return proxy.join3(propertyName);
    }

}
