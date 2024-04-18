
/*
 * All rights Reserved, Designed By zhongj
 * @Title: EntitySqlQueryRelated.java
 * @Description: EntitySqlQueryRelated
 * @author: zhongj
 * @date: 2023-08-11 16:23:11
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity;

import java.io.Serializable;

import cn.featherfly.common.db.builder.SqlBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression;

/**
 * EntitySqlQueryRelated.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <J> the generic type
 * @param <Q> the generic type
 * @param <R> the generic type
 * @param <B> the generic type
 */
public class AbstractEntitySqlOn<E, J, Q, R extends EntitySqlRelation<R, B>, B extends SqlBuilder>
    implements EntityOnExpression<E, J, Q> {

    /** The on result. */
    protected final Q onResult;

    /** The index. */
    //    protected final int index;

    /** The sql relation. */
    protected final R sqlRelation;

    /** The factory. */
    protected final JdbcMappingFactory factory;

    /** The join type. */
    protected final Class<J> joinType;

    /**
     * Instantiates a new entity sql query related.
     *
     * @param joinType    the join type
     * @param onResult    the query relate
     * @param factory     the factory
     * @param sqlRelation the query relation
     */
    public AbstractEntitySqlOn(Class<J> joinType, Q onResult, JdbcMappingFactory factory, R sqlRelation) {
        this.factory = factory;
        this.sqlRelation = sqlRelation;
        this.joinType = joinType;
        this.onResult = onResult;
    }
    //    public AbstractEntitySqlOn(Q onResult, JdbcMappingFactory factory, R sqlRelation, Class<J> joinType, int index) {
    //        this.factory = factory;
    //        this.sqlRelation = sqlRelation;
    //        this.joinType = joinType;
    //        this.onResult = onResult;
    //        this.index = index;
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <P> Q on(SerializableFunction1<E, P> propertyName) {
        sqlRelation.join(0, getPropertyName(propertyName), factory.getClassMapping(joinType), true);
        return onResult;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <P> Q on(SerializableFunction2<J, P> joinTypePropertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
        sqlRelation.join(0, factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())),
            info.getPropertyName(), true);
        return onResult;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <P> Q on(SerializableFunction1<E, P> propertyName, SerializableFunction2<J, P> joinTypePropertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(joinTypePropertyName);
        sqlRelation.join(0, getPropertyName(propertyName),
            factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName(),
            true);
        return onResult;
    }

    /**
     * Gets the property name.
     *
     * @param property the property
     * @return the property name
     */
    protected String getPropertyName(Serializable property) {
        return LambdaUtils.getLambdaPropertyName(property);
    }
}
