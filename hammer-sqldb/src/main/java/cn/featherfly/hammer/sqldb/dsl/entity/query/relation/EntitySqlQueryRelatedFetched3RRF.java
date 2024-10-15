
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

import cn.featherfly.common.tuple.Tuple2;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableUnaryOperator1;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression4;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate4RRFP;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate4RRFR;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched3RRF;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlOn4;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.dsl.entity.query.AbstractEntitySqlQueryFetch4;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * The Class EntitySqlQueryRelatedFetched2FF.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <R1> query or joined type
 * @param <R2> query or joined type
 */
public class EntitySqlQueryRelatedFetched3RRF<E, R1, R2, R3> extends
    AbstractEntitySqlQueryFetch4<E, R1, R2, R3, Tuple2<E, R3>> implements EntityQueryRelatedFetched3RRF<E, R1, R2, R3> {

    /**
     * Instantiates a new entity sql query related fetched 2 FF.
     *
     * @param hammerConfig the hammer config
     * @param factory the factory
     * @param sqlPageFactory the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    public EntitySqlQueryRelatedFetched3RRF(HammerConfig hammerConfig, JdbcMappingFactory factory,
        SqlPageFactory sqlPageFactory, EntitySqlQueryRelation entitySqlQueryRelation) {
        super(hammerConfig, factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <J> EntityOnExpression4<E, R1, R2, R3, J, EntityQueryRelate4RRFR<E, R1, R2, R3, J>> join(Class<J> joinType) {
        return new EntitySqlOn4<>(joinType,
            new EntitySqlQueryRelate4RRFR<>(hammerConfig, factory, sqlPageFactory, queryRelation), factory,
            queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R4> EntityQueryRelate4RRFR<E, R1, R2, R3, R4> join(SerializableFunction2<R4, E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, queryRelation.getEntityRelation(0).getIdName(),
            factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return new EntitySqlQueryRelate4RRFR<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R4> EntityQueryRelate4RRFP<E, R1, R2, R3, R4> join(SerializableFunction1<E, R4> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate4RRFP<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelate4RRFP<E, R1, R2, R3, E> join(SerializableUnaryOperator1<E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate4RRFP<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    // ****************************************************************************************************************
    //	join 2
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R4> EntityQueryRelate4RRFR<E, R1, R2, R3, R4> join2(SerializableFunction2<R4, R1> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, queryRelation.getEntityRelation(0).getIdName(),
            factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return new EntitySqlQueryRelate4RRFR<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R4> EntityQueryRelate4RRFP<E, R1, R2, R3, R4> join2(SerializableFunction1<R1, R4> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate4RRFP<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelate4RRFP<E, R1, R2, R3, R1> join2(SerializableUnaryOperator1<R1> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate4RRFP<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    // ****************************************************************************************************************
    //  join 3
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R4> EntityQueryRelate4RRFR<E, R1, R2, R3, R4> join3(SerializableFunction2<R4, R2> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(2, queryRelation.getEntityRelation(0).getIdName(),
            factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return new EntitySqlQueryRelate4RRFR<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R4> EntityQueryRelate4RRFP<E, R1, R2, R3, R4> join3(SerializableFunction1<R2, R4> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(2, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate4RRFP<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelate4RRFP<E, R1, R2, R3, R2> join3(SerializableUnaryOperator1<R2> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(2, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate4RRFP<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    // ****************************************************************************************************************
    //	join 4
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R4> EntityQueryRelate4RRFR<E, R1, R2, R3, R4> join4(SerializableFunction2<R4, R3> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(3, queryRelation.getEntityRelation(0).getIdName(),
            factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return new EntitySqlQueryRelate4RRFR<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R4> EntityQueryRelate4RRFP<E, R1, R2, R3, R4> join4(SerializableFunction1<R3, R4> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(3, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate4RRFP<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelate4RRFP<E, R1, R2, R3, R3> join4(SerializableUnaryOperator1<R3> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(3, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate4RRFP<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

}
