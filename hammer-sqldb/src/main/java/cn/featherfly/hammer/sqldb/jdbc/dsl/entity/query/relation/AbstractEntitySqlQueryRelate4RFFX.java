
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntitySqlQueryRelate3FF.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query
 * @Description: EntitySqlQueryRelate3FF
 * @author: zhongj
 * @date: 2023-07-14 16:01:14
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
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate4RFFXBase;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate5RFFRP;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate5RFFRR;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched5RFFRF;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedExpression;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.AbstractEntitySqlQueryFetch5;

/**
 * The Class AbstractEntitySqlQueryRelate4RFFX.
 *
 * @author zhongj
 * @param <E>   the element type
 * @param <R1>  the generic type
 * @param <R2>  the generic type
 * @param <R3>  the generic type
 * @param <R4>  the generic type
 * @param <RES> the generic type
 */
public abstract class AbstractEntitySqlQueryRelate4RFFX<E, R1, R2, R3, R4>
        extends AbstractEntitySqlQueryFetch5<E, R1, R2, R3, R4, Tuple3<E, R2, R3>>
        implements EntityQueryRelate4RFFXBase<E, R1, R2, R3, R4> {

    /**
     * Instantiates a new abstract entity sql query relate 4 RFFX.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    protected AbstractEntitySqlQueryRelate4RFFX(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    @Override
    public <R5> EntityQueryRelatedExpression<E, R5, EntityQueryRelate5RFFRR<E, R1, R2, R3, R4, R5>,
            EntityQueryRelatedFetched5RFFRF<E, R1, R2, R3, R4, R5>> join(Class<R5> joinType) {
        return new EntitySqlQueryRelated<>(new EntitySqlQueryRelate5RFFRR<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 0);
    }

    @Override
    public <R5> EntityQueryRelate5RFFRR<E, R1, R2, R3, R4, R5> join(SerializableFunction2<R5, E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, queryRelation.getEntityRelationMapping(0).getIdName(),
                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return new EntitySqlQueryRelate5RFFRR<>(factory, sqlPageFactory, queryRelation);
    }

    @Override
    public <R5> EntityQueryRelate5RFFRP<E, R1, R2, R3, R4, R5> join(SerializableFunction1<E, R5> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate5RFFRP<>(factory, sqlPageFactory, queryRelation);
    }

    @Override
    public EntityQueryRelate5RFFRP<E, R1, R2, R3, R4, E> join(SerializableUnaryOperator1<E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate5RFFRP<>(factory, sqlPageFactory, queryRelation);
    }

    // ****************************************************************************************************************
    //	join 2
    // ****************************************************************************************************************

    @Override
    public <R5> EntityQueryRelatedExpression<R1, R5, EntityQueryRelate5RFFRR<E, R1, R2, R3, R4, R5>,
            EntityQueryRelatedFetched5RFFRF<E, R1, R2, R3, R4, R5>> join2(Class<R5> joinType) {
        return new EntitySqlQueryRelated<>(new EntitySqlQueryRelate5RFFRR<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 1);
    }

    @Override
    public <R5> EntityQueryRelate5RFFRR<E, R1, R2, R3, R4, R5> join2(SerializableFunction2<R5, R1> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, queryRelation.getEntityRelationMapping(0).getIdName(),
                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return new EntitySqlQueryRelate5RFFRR<>(factory, sqlPageFactory, queryRelation);
    }

    @Override
    public <R5> EntityQueryRelate5RFFRP<E, R1, R2, R3, R4, R5> join2(SerializableFunction1<R1, R5> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate5RFFRP<>(factory, sqlPageFactory, queryRelation);
    }

    @Override
    public EntityQueryRelate5RFFRP<E, R1, R2, R3, R4, R1> join2(SerializableUnaryOperator1<R1> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate5RFFRP<>(factory, sqlPageFactory, queryRelation);
    }

    // ****************************************************************************************************************
    //	join 3
    // ****************************************************************************************************************

    @Override
    public <R5> EntityQueryRelatedExpression<R2, R5, EntityQueryRelate5RFFRR<E, R1, R2, R3, R4, R5>,
            EntityQueryRelatedFetched5RFFRF<E, R1, R2, R3, R4, R5>> join3(Class<R5> joinType) {
        return new EntitySqlQueryRelated<>(new EntitySqlQueryRelate5RFFRR<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 2);
    }

    @Override
    public <R5> EntityQueryRelate5RFFRR<E, R1, R2, R3, R4, R5> join3(SerializableFunction2<R5, R2> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(2, queryRelation.getEntityRelationMapping(0).getIdName(),
                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return new EntitySqlQueryRelate5RFFRR<>(factory, sqlPageFactory, queryRelation);
    }

    @Override
    public <R5> EntityQueryRelate5RFFRP<E, R1, R2, R3, R4, R5> join3(SerializableFunction1<R2, R5> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(2, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate5RFFRP<>(factory, sqlPageFactory, queryRelation);
    }

    @Override
    public EntityQueryRelate5RFFRP<E, R1, R2, R3, R4, R2> join3(SerializableUnaryOperator1<R2> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(2, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate5RFFRP<>(factory, sqlPageFactory, queryRelation);
    }

    // ****************************************************************************************************************
    //	4
    // ****************************************************************************************************************

    @Override
    public <R5> EntityQueryRelatedExpression<R3, R5, EntityQueryRelate5RFFRR<E, R1, R2, R3, R4, R5>,
            EntityQueryRelatedFetched5RFFRF<E, R1, R2, R3, R4, R5>> join4(Class<R5> joinType) {
        return new EntitySqlQueryRelated<>(new EntitySqlQueryRelate5RFFRR<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 3);
    }

    @Override
    public <R5> EntityQueryRelate5RFFRR<E, R1, R2, R3, R4, R5> join4(SerializableFunction2<R5, R3> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(3, queryRelation.getEntityRelationMapping(0).getIdName(),
                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return new EntitySqlQueryRelate5RFFRR<>(factory, sqlPageFactory, queryRelation);
    }

    @Override
    public <R5> EntityQueryRelate5RFFRP<E, R1, R2, R3, R4, R5> join4(SerializableFunction1<R3, R5> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(3, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate5RFFRP<>(factory, sqlPageFactory, queryRelation);
    }

    @Override
    public EntityQueryRelate5RFFRP<E, R1, R2, R3, R4, R3> join4(SerializableUnaryOperator1<R3> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(3, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate5RFFRP<>(factory, sqlPageFactory, queryRelation);
    }

    @Override
    public <R5> EntityQueryRelatedExpression<R4, R5, EntityQueryRelate5RFFRR<E, R1, R2, R3, R4, R5>,
            EntityQueryRelatedFetched5RFFRF<E, R1, R2, R3, R4, R5>> join5(Class<R5> joinType) {
        return new EntitySqlQueryRelated<>(new EntitySqlQueryRelate5RFFRR<>(factory, sqlPageFactory, queryRelation),
                factory, queryRelation, joinType, 4);
    }

    @Override
    public <R5> EntityQueryRelate5RFFRR<E, R1, R2, R3, R4, R5> join5(SerializableFunction2<R5, R4> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(4, queryRelation.getEntityRelationMapping(0).getIdName(),
                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return new EntitySqlQueryRelate5RFFRR<>(factory, sqlPageFactory, queryRelation);
    }

    @Override
    public <R5> EntityQueryRelate5RFFRP<E, R1, R2, R3, R4, R5> join5(SerializableFunction1<R4, R5> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(4, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate5RFFRP<>(factory, sqlPageFactory, queryRelation);
    }

    @Override
    public EntityQueryRelate5RFFRP<E, R1, R2, R3, R4, R4> join5(SerializableUnaryOperator1<R4> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(4, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate5RFFRP<>(factory, sqlPageFactory, queryRelation);
    }

}
