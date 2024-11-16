
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntitySqlQueryRelate3FF.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query
 * @Description: EntitySqlQueryRelate3FF
 * @author: zhongj
 * @date: 2023-07-14 16:01:14
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.dsl.entity.query.relation;

import cn.featherfly.common.db.dialect.Join;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableUnaryOperator1;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.common.tuple.Tuple2;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression5;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate4FRRXBase;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate5FRRRP;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate5FRRRR;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlOn5;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.dsl.entity.query.AbstractEntitySqlQueryFetch5;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * @param <E> query type
 * @param <R1> query or joined type
 * @param <R2> query or joined type
 * @param <R3> query or joined type
 * @param <R4> query or joined type
 */
public abstract class AbstractEntitySqlQueryRelate4FRRX<E, R1, R2, R3, R4>
    extends AbstractEntitySqlQueryFetch5<E, R1, R2, R3, R4, Tuple2<E, R1>>
    implements EntityQueryRelate4FRRXBase<E, R1, R2, R3, R4> {

    /**
     * Instantiates a new abstract entity sql query relate 4 FRRX.
     *
     * @param hammerConfig the hammer config
     * @param factory the factory
     * @param sqlPageFactory the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    protected AbstractEntitySqlQueryRelate4FRRX(HammerConfig hammerConfig, JdbcMappingFactory factory,
        SqlPageFactory sqlPageFactory, EntitySqlQueryRelation entitySqlQueryRelation) {
        super(hammerConfig, factory, sqlPageFactory, entitySqlQueryRelation);
    }

    @Override
    public <J> EntityOnExpression5<E, R1, R2, R3, R4, J, EntityQueryRelate5FRRRR<E, R1, R2, R3, R4, J>> join(
        Class<J> joinType) {
        return new EntitySqlOn5<>(joinType,
            new EntitySqlQueryRelate5FRRRR<>(hammerConfig, factory, sqlPageFactory, queryRelation), factory,
            queryRelation);
    }

    @Override
    public <R5> EntityQueryRelate5FRRRR<E, R1, R2, R3, R4, R5> join(SerializableFunction2<R5, E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(Join.LEFT_JOIN, 0, queryRelation.getEntityRelation(0).getIdName(),
            factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return new EntitySqlQueryRelate5FRRRR<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    @Override
    public <R5> EntityQueryRelate5FRRRP<E, R1, R2, R3, R4, R5> join(SerializableFunction1<E, R5> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(Join.LEFT_JOIN, 0, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate5FRRRP<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    @Override
    public EntityQueryRelate5FRRRP<E, R1, R2, R3, R4, E> join(SerializableUnaryOperator1<E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(Join.LEFT_JOIN, 0, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate5FRRRP<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    // ****************************************************************************************************************
    //  join 2
    // ****************************************************************************************************************

    @Override
    public <R5> EntityQueryRelate5FRRRR<E, R1, R2, R3, R4, R5> join2(SerializableFunction2<R5, R1> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, queryRelation.getEntityRelation(0).getIdName(),
            factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return new EntitySqlQueryRelate5FRRRR<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    @Override
    public <R5> EntityQueryRelate5FRRRP<E, R1, R2, R3, R4, R5> join2(SerializableFunction1<R1, R5> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate5FRRRP<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    @Override
    public EntityQueryRelate5FRRRP<E, R1, R2, R3, R4, R1> join2(SerializableUnaryOperator1<R1> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate5FRRRP<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    // ****************************************************************************************************************
    //  join 3
    // ****************************************************************************************************************

    @Override
    public <R5> EntityQueryRelate5FRRRR<E, R1, R2, R3, R4, R5> join3(SerializableFunction2<R5, R2> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(2, queryRelation.getEntityRelation(0).getIdName(),
            factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return new EntitySqlQueryRelate5FRRRR<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    @Override
    public <R5> EntityQueryRelate5FRRRP<E, R1, R2, R3, R4, R5> join3(SerializableFunction1<R2, R5> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(2, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate5FRRRP<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    @Override
    public EntityQueryRelate5FRRRP<E, R1, R2, R3, R4, R2> join3(SerializableUnaryOperator1<R2> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(2, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate5FRRRP<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    // ****************************************************************************************************************
    //  join 4
    // ****************************************************************************************************************

    @Override
    public <R5> EntityQueryRelate5FRRRR<E, R1, R2, R3, R4, R5> join4(SerializableFunction2<R5, R3> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(3, queryRelation.getEntityRelation(0).getIdName(),
            factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return new EntitySqlQueryRelate5FRRRR<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    @Override
    public <R5> EntityQueryRelate5FRRRP<E, R1, R2, R3, R4, R5> join4(SerializableFunction1<R3, R5> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(3, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate5FRRRP<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    @Override
    public EntityQueryRelate5FRRRP<E, R1, R2, R3, R4, R3> join4(SerializableUnaryOperator1<R3> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(3, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate5FRRRP<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    // ****************************************************************************************************************
    //  join 5
    // ****************************************************************************************************************

    @Override
    public <R5> EntityQueryRelate5FRRRR<E, R1, R2, R3, R4, R5> join5(SerializableFunction2<R5, R4> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(4, queryRelation.getEntityRelation(0).getIdName(),
            factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return new EntitySqlQueryRelate5FRRRR<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    @Override
    public <R5> EntityQueryRelate5FRRRP<E, R1, R2, R3, R4, R5> join5(SerializableFunction1<R4, R5> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(4, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate5FRRRP<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    @Override
    public EntityQueryRelate5FRRRP<E, R1, R2, R3, R4, R4> join5(SerializableUnaryOperator1<R4> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(4, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate5FRRRP<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }
}
