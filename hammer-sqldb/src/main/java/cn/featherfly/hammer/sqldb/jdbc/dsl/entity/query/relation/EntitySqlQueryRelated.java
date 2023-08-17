
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
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.common.lang.function.SerializableFunction1;
import cn.featherfly.common.lang.function.SerializableFunction2;
import cn.featherfly.hammer.expression.api.entity.QueryRelate;
import cn.featherfly.hammer.expression.entity.query.relation.EntityQueryRelatedExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;

/**
 * EntitySqlQueryRelated.
 *
 * @author zhongj
 * @param <E>   the element type
 * @param <R>   the generic type
 * @param <QR>  the generic type
 * @param <QRF> the generic type
 */
public class EntitySqlQueryRelated<E, R, QR extends QueryRelate<QRF>, QRF>
        //        extends AbstractEntitySqlQueryRelated<E, R>
        implements EntityQueryRelatedExpression<E, R, QR, QRF> {

    private QR queryRelate;

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
    public EntitySqlQueryRelated(QR queryRelate, JdbcMappingFactory factory, EntitySqlQueryRelation queryRelation,
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
    public <P> QR on(SerializableFunction1<E, P> propertyName) {
        queryRelation.join(index, getPropertyName(propertyName), factory.getClassMapping(joinType));
        return queryRelate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <JP> QR on(SerializableFunction2<R, JP> joinTypePropertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
        queryRelation.join(index, factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())),
                info.getPropertyName());
        return queryRelate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <P> QR on(SerializableFunction1<E, P> propertyName, SerializableFunction2<R, P> joinTypePropertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
        queryRelation.join(index, getPropertyName(propertyName),
                factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return queryRelate;
    }

    private String getPropertyName(Serializable property) {
        return LambdaUtils.getLambdaPropertyName(property);
    }
}
