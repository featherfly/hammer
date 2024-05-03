
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.relation;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableUnaryOperator1;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression3;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate2RXBase;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate3RRP;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate3RRR;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlOn3;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.AbstractEntitySqlQueryFetch3;

/**
 * The Class AbstractEntitySqlQueryRelate2RX.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> query or joined type
 * @param <R2> query or joined type
 */
public abstract class AbstractEntitySqlQueryRelate2RX<E, R1, R2> extends AbstractEntitySqlQueryFetch3<E, R1, R2, E>
    implements EntityQueryRelate2RXBase<E, R1, R2> {

    /**
     * Instantiates a new abstract entity sql query relate 2 RX.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    protected AbstractEntitySqlQueryRelate2RX(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
        EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    @Override
    public <J> EntityOnExpression3<E, R1, R2, J, EntityQueryRelate3RRR<E, R1, R2, J>> join(Class<J> joinType) {
        return new EntitySqlOn3<>(joinType, new EntitySqlQueryRelate3RRR<>(factory, sqlPageFactory, queryRelation),
            factory, queryRelation);
    }

    @Override
    public <R3> EntityQueryRelate3RRP<E, R1, R2, R3> join(SerializableFunction1<E, R3> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate3RRP<>(factory, sqlPageFactory, queryRelation);
    }

    @Override
    public <R3> EntityQueryRelate3RRR<E, R1, R2, R3> join(SerializableFunction2<R3, E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, queryRelation.getEntityRelation(0).getIdName(),
            factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return new EntitySqlQueryRelate3RRR<>(factory, sqlPageFactory, queryRelation);
    }

    @Override
    public EntityQueryRelate3RRP<E, R1, R2, E> join(SerializableUnaryOperator1<E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate3RRP<>(factory, sqlPageFactory, queryRelation);
    }

    // ****************************************************************************************************************
    //	join 2
    // ****************************************************************************************************************

    @Override
    public <R3> EntityQueryRelate3RRP<E, R1, R2, R3> join2(SerializableFunction1<R1, R3> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate3RRP<>(factory, sqlPageFactory, queryRelation);
    }

    @Override
    public <R3> EntityQueryRelate3RRR<E, R1, R2, R3> join2(SerializableFunction2<R3, R1> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, queryRelation.getEntityRelation(0).getIdName(),
            factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return new EntitySqlQueryRelate3RRR<>(factory, sqlPageFactory, queryRelation);
    }

    @Override
    public EntityQueryRelate3RRP<E, R1, R2, R1> join2(SerializableUnaryOperator1<R1> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate3RRP<>(factory, sqlPageFactory, queryRelation);
    }

    // ****************************************************************************************************************
    //	join 3
    // ****************************************************************************************************************

    @Override
    public <R3> EntityQueryRelate3RRP<E, R1, R2, R3> join3(SerializableFunction1<R2, R3> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(2, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate3RRP<>(factory, sqlPageFactory, queryRelation);
    }

    @Override
    public <R3> EntityQueryRelate3RRR<E, R1, R2, R3> join3(SerializableFunction2<R3, R2> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(2, queryRelation.getEntityRelation(0).getIdName(),
            factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return new EntitySqlQueryRelate3RRR<>(factory, sqlPageFactory, queryRelation);
    }

    @Override
    public EntityQueryRelate3RRP<E, R1, R2, R2> join3(SerializableUnaryOperator1<R2> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(2, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate3RRP<>(factory, sqlPageFactory, queryRelation);
    }

}
