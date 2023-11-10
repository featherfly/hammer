
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntitySqlQueryRelated.java
 * @Description: EntitySqlQueryRelated
 * @author: zhongj
 * @date: 2023-08-11 16:23:11
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query.relation;

import java.io.Serializable;

import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelatedExpression;
import cn.featherfly.hammer.expression.query.QueryRelateExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;

/**
 * EntitySqlQueryRelated.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <R> the generic type
 * @param <Q> the generic type
 * @param <F> the generic type
 */
public class EntitySqlQueryRelated<E, R, Q extends QueryRelateExpression<F>, F>
        //        extends AbstractEntitySqlQueryRelated<E, R>
        implements EntityQueryRelatedExpression<E, R, Q, F> {

    private Q queryRelate;

    private int index;

    private EntitySqlQueryRelation queryRelation;

    private JdbcMappingFactory factory;

    private Class<R> joinType;

    /**
     * Instantiates a new entity sql query related.
     *
     * @param queryRelate   the query relate
     * @param factory       the factory
     * @param queryRelation the query relation
     * @param joinType      the join type
     * @param index         the index
     */
    public EntitySqlQueryRelated(Q queryRelate, JdbcMappingFactory factory, EntitySqlQueryRelation queryRelation,
            Class<R> joinType, int index) {
        this.factory = factory;
        this.queryRelation = queryRelation;
        this.joinType = joinType;
        this.queryRelate = queryRelate;
        this.index = index;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <P> Q on(SerializableFunction1<E, P> propertyName) {
        queryRelation.join(index, getPropertyName(propertyName), factory.getClassMapping(joinType), true);
        return queryRelate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <J> Q on(SerializableFunction2<R, J> joinTypePropertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
        queryRelation.join(index, factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())),
                info.getPropertyName(), true);
        return queryRelate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <P> Q on(SerializableFunction1<E, P> propertyName, SerializableFunction2<R, P> joinTypePropertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
        queryRelation.join(index, getPropertyName(propertyName),
                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName(),
                true);
        return queryRelate;
    }

    private String getPropertyName(Serializable property) {
        return LambdaUtils.getLambdaPropertyName(property);
    }
}
