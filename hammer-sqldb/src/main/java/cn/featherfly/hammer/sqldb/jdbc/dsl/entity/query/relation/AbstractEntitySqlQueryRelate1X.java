
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.relation;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableUnaryOperator1;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression2;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate1XBase;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate2RP;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate2RR;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlOn2;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.AbstractEntitySqlQueryFetch2;

/**
 * The Class AbstractEntitySqlQueryRelate1X.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> query or joined type
 */
public abstract class AbstractEntitySqlQueryRelate1X<E, R1> extends AbstractEntitySqlQueryFetch2<E, R1, E>
    implements EntityQueryRelate1XBase<E, R1> {

    /**
     * Instantiates a new abstract entity sql query relate 1 X.
     *
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    protected AbstractEntitySqlQueryRelate1X(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
        EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    // ****************************************************************************************************************

    /**
     * Join.
     *
     * @param <Q>      the generic type
     * @param <J>      the generic type
     * @param joinType the join type
     * @return the entity query related expression
     */
    @Override
    public <J> EntityOnExpression2<E, R1, J, EntityQueryRelate2RR<E, R1, J>> join(Class<J> joinType) {
        return new EntitySqlOn2<>(joinType, new EntitySqlQueryRelate2RR<>(factory, sqlPageFactory, queryRelation),
            factory, queryRelation);
    }

    /**
     * Join.
     *
     * @param <Q>          the generic type
     * @param <R2>         the generic type
     * @param propertyName the property name
     */
    @Override
    public <R2> EntityQueryRelate2RP<E, R1, R2> join(SerializableFunction1<E, R2> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate2RP<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * Join.
     *
     * @param <Q>          the generic type
     * @param <R2>         the generic type
     * @param propertyName the property name
     */
    @Override
    public <R2> EntityQueryRelate2RR<E, R1, R2> join(SerializableFunction2<R2, E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, queryRelation.getEntityRelationMapping(0).getIdName(),
            factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return new EntitySqlQueryRelate2RR<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * Join.
     *
     * @param <Q>          the generic type
     * @param propertyName the property name
     */
    @Override
    public EntityQueryRelate2RP<E, R1, E> join(SerializableUnaryOperator1<E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate2RP<>(factory, sqlPageFactory, queryRelation);
    }

    // ****************************************************************************************************************
    //	join 2
    // ****************************************************************************************************************

    /**
     * Join 2.
     *
     * @param <Q>          the generic type
     * @param <R2>         the generic type
     * @param propertyName the property name
     */
    @Override
    public <R2> EntityQueryRelate2RR<E, R1, R2> join2(SerializableFunction2<R2, R1> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, queryRelation.getEntityRelationMapping(0).getIdName(),
            factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return new EntitySqlQueryRelate2RR<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * Join 2.
     *
     * @param <Q>          the generic type
     * @param <R2>         the generic type
     * @param propertyName the property name
     */
    @Override
    public <R2> EntityQueryRelate2RP<E, R1, R2> join2(SerializableFunction1<R1, R2> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate2RP<>(factory, sqlPageFactory, queryRelation);
    }

    /**
     * Join 2.
     *
     * @param <Q>          the generic type
     * @param propertyName the property name
     */
    @Override
    public EntityQueryRelate2RP<E, R1, R1> join2(SerializableUnaryOperator1<R1> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(1, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate2RP<>(factory, sqlPageFactory, queryRelation);
    }

}
