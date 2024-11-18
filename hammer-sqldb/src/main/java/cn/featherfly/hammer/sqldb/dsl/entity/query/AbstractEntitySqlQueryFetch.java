
package cn.featherfly.hammer.sqldb.dsl.entity.query;

import cn.featherfly.common.db.dialect.Join;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableUnaryOperator1;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression1;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate1P;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate1R;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelateBase;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlOn1;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.dsl.entity.query.relation.EntitySqlQueryRelate1P;
import cn.featherfly.hammer.sqldb.dsl.entity.query.relation.EntitySqlQueryRelate1R;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * The Class AbstractEntitySqlQueryFetch.
 *
 * @author zhongj
 * @param <E> the query entity type
 */
public abstract class AbstractEntitySqlQueryFetch<E> extends AbstractEntitySqlQuery<E>
    implements EntityQueryRelateBase<E> {

    /**
     * Instantiates a new abstract entity sql query fetched.
     *
     * @param hammerConfig the hammer config
     * @param factory the factory
     * @param sqlPageFactory the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    protected AbstractEntitySqlQueryFetch(HammerConfig hammerConfig, JdbcMappingFactory factory,
        SqlPageFactory sqlPageFactory, EntitySqlQueryRelation entitySqlQueryRelation) {
        super(hammerConfig, factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <J> EntityOnExpression1<E, J, EntityQueryRelate1R<E, J>> join(Class<J> joinType) {
        return new EntitySqlOn1<>(joinType,
            new EntitySqlQueryRelate1R<>(hammerConfig, factory, sqlPageFactory, queryRelation), factory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryRelate1P<E, R> join(SerializableFunction1<E, R> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(Join.LEFT_JOIN, 0, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate1P<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryRelate1R<E, R> join(SerializableFunction2<R, E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(Join.LEFT_JOIN, 0, queryRelation.getEntityRelation(0).getIdName(),
            factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return new EntitySqlQueryRelate1R<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelate1P<E, E> join(SerializableUnaryOperator1<E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(Join.LEFT_JOIN, 0, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate1P<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }
}
