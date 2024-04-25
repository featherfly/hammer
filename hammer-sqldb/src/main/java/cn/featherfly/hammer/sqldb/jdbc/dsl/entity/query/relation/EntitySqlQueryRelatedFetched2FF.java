
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

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableUnaryOperator1;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression3;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate3FFP;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate3FFR;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched2FF;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlOn3;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.AbstractEntitySqlQueryFetch3;

/**
 * The Class EntitySqlQueryRelatedFetched2FF.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> query or joined type
 * @param <R2> query or joined type
 */
public class EntitySqlQueryRelatedFetched2FF<E, R1, R2> extends
    AbstractEntitySqlQueryFetch3<E, R1, R2, Tuple3<E, R1, R2>> implements EntityQueryRelatedFetched2FF<E, R1, R2> {

    /**
     * Instantiates a new entity sql query related fetched 2 FF.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    public EntitySqlQueryRelatedFetched2FF(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
        EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <J> EntityOnExpression3<E, R1, R2, J, EntityQueryRelate3FFR<E, R1, R2, J>> join(Class<J> joinType) {
        return new EntitySqlOn3<>(joinType, new EntitySqlQueryRelate3FFR<>(factory, sqlPageFactory, queryRelation),
            factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R3> EntityQueryRelate3FFR<E, R1, R2, R3> join(SerializableFunction2<R3, E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, queryRelation.getEntityRelationMapping(0).getIdName(),
            factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return new EntitySqlQueryRelate3FFR<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R3> EntityQueryRelate3FFP<E, R1, R2, R3> join(SerializableFunction1<E, R3> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate3FFP<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelate3FFP<E, R1, R2, E> join(SerializableUnaryOperator1<E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate3FFP<>(factory, sqlPageFactory, queryRelation);
    }

    // ****************************************************************************************************************
    //	2
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R3> EntityQueryRelate3FFR<E, R1, R2, R3> join2(SerializableFunction2<R3, R1> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, queryRelation.getEntityRelationMapping(0).getIdName(),
            factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return new EntitySqlQueryRelate3FFR<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R3> EntityQueryRelate3FFP<E, R1, R2, R3> join2(SerializableFunction1<R1, R3> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate3FFP<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelate3FFP<E, R1, R2, R1> join2(SerializableUnaryOperator1<R1> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate3FFP<>(factory, sqlPageFactory, queryRelation);
    }

    // ****************************************************************************************************************
    //	3
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R3> EntityQueryRelate3FFR<E, R1, R2, R3> join3(SerializableFunction2<R3, R2> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(2, queryRelation.getEntityRelationMapping(0).getIdName(),
            factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return new EntitySqlQueryRelate3FFR<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R3> EntityQueryRelate3FFP<E, R1, R2, R3> join3(SerializableFunction1<R2, R3> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(2, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate3FFP<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelate3FFP<E, R1, R2, R2> join3(SerializableUnaryOperator1<R2> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(2, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate3FFP<>(factory, sqlPageFactory, queryRelation);
    }

}
