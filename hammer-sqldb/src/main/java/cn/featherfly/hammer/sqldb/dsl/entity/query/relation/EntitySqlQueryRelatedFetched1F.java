
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntitySqlQueryRelatedFetched.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query
 * @Description: EntitySqlQueryRelatedFetched
 * @author: zhongj
 * @date: 2023-07-14 15:58:14
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.entity.query.relation;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableUnaryOperator1;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression2;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate2FP;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate2FR;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched1F;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlOn2;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.dsl.entity.query.AbstractEntitySqlQueryFetch2;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * The Class EntitySqlQueryRelatedFetched1F.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <R1> query or joined type
 */
public class EntitySqlQueryRelatedFetched1F<E, R1> extends AbstractEntitySqlQueryFetch2<E, R1, Tuple2<E, R1>>
    implements EntityQueryRelatedFetched1F<E, R1> {

    /**
     * Instantiates a new entity sql query related fetched 1 F.
     *
     * @param hammerConfig the hammer config
     * @param factory the factory
     * @param sqlPageFactory the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    public EntitySqlQueryRelatedFetched1F(HammerConfig hammerConfig, JdbcMappingFactory factory,
        SqlPageFactory sqlPageFactory, EntitySqlQueryRelation entitySqlQueryRelation) {
        super(hammerConfig, factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <J> EntityOnExpression2<E, R1, J, EntityQueryRelate2FR<E, R1, J>> join(Class<J> joinType) {
        return new EntitySqlOn2<>(joinType,
            new EntitySqlQueryRelate2FR<>(hammerConfig, factory, sqlPageFactory, queryRelation), factory,
            queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <Q extends EntityQueryRelate2FR<E, R1, R2>, R2> Q join(SerializableFunction2<R2, E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, queryRelation.getEntityRelation(0).getIdName(),
            factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return (Q) new EntitySqlQueryRelate2FR<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <Q extends EntityQueryRelate2FP<E, R1, R2>, R2> Q join(SerializableFunction1<E, R2> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (Q) new EntitySqlQueryRelate2FP<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <Q extends EntityQueryRelate2FP<E, R1, E>> Q join(SerializableUnaryOperator1<E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (Q) new EntitySqlQueryRelate2FP<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    // ****************************************************************************************************************
    //	join 2
    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <Q extends EntityQueryRelate2FR<E, R1, R2>, R2> Q join2(SerializableFunction2<R2, R1> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, queryRelation.getEntityRelation(0).getIdName(),
            factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return (Q) new EntitySqlQueryRelate2FR<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <Q extends EntityQueryRelate2FP<E, R1, R2>, R2> Q join2(SerializableFunction1<R1, R2> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (Q) new EntitySqlQueryRelate2FP<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <Q extends EntityQueryRelate2FP<E, R1, R1>> Q join2(SerializableUnaryOperator1<R1> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return (Q) new EntitySqlQueryRelate2FP<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }
}
