
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

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableUnaryOperator1;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression2;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate2RP;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate2RR;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedFetched1P;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.dsl.entity.query.AbstractEntitySqlQueryFetch2;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * The Class EntitySqlQueryRelatedFetched1P.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <R1> query or joined type
 */
public class EntitySqlQueryRelatedFetched1P<E, R1> extends AbstractEntitySqlQueryFetch2<E, R1, E>
    implements EntityQueryRelatedFetched1P<E, R1> {

    private EntitySqlQueryRelate1P<E, R1> proxy;

    /**
     * Instantiates a new entity sql query related fetched 1 P.
     *
     * @param entitySqlQueryRelate   the entity sql query relate
     * @param factory                the factory
     * @param sqlPageFactory         the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    public EntitySqlQueryRelatedFetched1P(EntitySqlQueryRelate1P<E, R1> entitySqlQueryRelate,
        JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
        proxy = entitySqlQueryRelate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <J> EntityOnExpression2<E, R1, J, EntityQueryRelate2RR<E, R1, J>> join(Class<J> joinType) {
        return proxy.join(joinType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R2> EntityQueryRelate2RP<E, R1, R2> join(SerializableFunction1<E, R2> propertyName) {
        return proxy.join(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R2> EntityQueryRelate2RR<E, R1, R2> join(SerializableFunction2<R2, E> propertyName) {
        return proxy.join(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelate2RP<E, R1, E> join(SerializableUnaryOperator1<E> propertyName) {
        return proxy.join(propertyName);
    }

    // ****************************************************************************************************************

    /**
     * {@inheritDoc}
     */
    @Override
    public <R2> EntityQueryRelate2RR<E, R1, R2> join2(SerializableFunction2<R2, R1> propertyName) {
        return proxy.join2(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R2> EntityQueryRelate2RP<E, R1, R2> join2(SerializableFunction1<R1, R2> propertyName) {
        return proxy.join2(propertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelate2RP<E, R1, R1> join2(SerializableUnaryOperator1<R1> propertyName) {
        return proxy.join2(propertyName);
    }

}
