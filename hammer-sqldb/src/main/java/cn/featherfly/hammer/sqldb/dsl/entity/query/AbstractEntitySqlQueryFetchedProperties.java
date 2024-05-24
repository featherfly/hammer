
package cn.featherfly.hammer.sqldb.dsl.entity.query;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableFunction1;
import cn.featherfly.common.function.serializable.SerializableFunction2;
import cn.featherfly.common.function.serializable.SerializableUnaryOperator1;
import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LambdaUtils.SerializedLambdaInfo;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.dsl.entity.EntityOnExpression1;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate1P;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelate1R;
import cn.featherfly.hammer.dsl.entity.query.relation.EntityQueryRelateBase;
import cn.featherfly.hammer.expression.entity.query.EntityQueryFetchedPropertiesExpression;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlOn1;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.dsl.entity.EntitySqlRelation.EntityRelation;
import cn.featherfly.hammer.sqldb.dsl.entity.query.relation.EntitySqlQueryRelate1P;
import cn.featherfly.hammer.sqldb.dsl.entity.query.relation.EntitySqlQueryRelate1R;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * abstract entity sql query entity properties.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <P> the generic type
 * @param <L> the generic type
 */
public abstract class AbstractEntitySqlQueryFetchedProperties<E, P extends EntityQueryFetchedPropertiesExpression<E, P>,
    L> extends AbstractEntitySqlQueryBase<E, L>
    implements EntityQueryFetchedPropertiesExpression<E, P>, EntityQueryRelateBase<E> {
    // FIXME join后返回参数就不对了

    /**
     * Instantiates a new abstract entity sql query fetched.
     *
     * @param hammerConfig the hammer config
     * @param factory the factory
     * @param sqlPageFactory the sql page factory
     * @param entitySqlQueryRelation the entity sql query relation
     */
    protected AbstractEntitySqlQueryFetchedProperties(HammerConfig hammerConfig, JdbcMappingFactory factory,
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
        queryRelation.join(0, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate1P<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> EntityQueryRelate1R<E, R> join(SerializableFunction2<R, E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, queryRelation.getEntityRelation(0).getIdName(),
            factory.getClassMapping(ClassUtils.forName(info.getMethodInstanceClassName())), info.getPropertyName());
        return new EntitySqlQueryRelate1R<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityQueryRelate1P<E, E> join(SerializableUnaryOperator1<E> propertyName) {
        SerializedLambdaInfo info = LambdaUtils.getLambdaInfo(propertyName);
        queryRelation.join(0, info.getPropertyName(), factory.getClassMapping(info.getPropertyType()));
        return new EntitySqlQueryRelate1P<>(hammerConfig, factory, sqlPageFactory, queryRelation);
    }

    /**
     * Property.
     *
     * @param propertyNames the property names
     * @return the e
     */
    @SuppressWarnings("unchecked")
    public P property(String... propertyNames) {
        for (String propertyName : propertyNames) {
            property(false, propertyName);
        }
        return (P) this;
    }

    /**
     * Property.
     *
     * @param propertyNames the property names
     * @return the e
     */
    @SuppressWarnings("unchecked")
    public P property(Collection<String> propertyNames) {
        for (String propertyName : propertyNames) {
            property(false, propertyName);
        }
        return (P) this;
    }

    /**
     * Property.
     *
     * @param propertyNames the property names
     * @return the e
     */
    @Override
    public P property(@SuppressWarnings("unchecked") SerializableFunction<E, ?>... propertyNames) {
        return property(
            Arrays.stream(propertyNames).map(LambdaUtils::getLambdaPropertyName).collect(Collectors.toList()));
    }

    /**
     * Property.
     *
     * @param distinct the distinct
     * @param propertyName the property name
     * @return the e
     */
    @SuppressWarnings("unchecked")
    public P property(boolean distinct, String propertyName) {
        //        Tuple2<String, String> columnAndProperty = ClassMappingUtils.getColumnAndPropertyName(propertyName,
        //            queryRelation.getEntityRelationTuple().getOrNull0().getClassMapping());
        //        if (Lang.isEmpty(columnAndProperty.get1())) {
        //            queryRelation.getBuilder().addColumn(distinct, columnAndProperty.get0());
        //        } else {
        //            queryRelation.getBuilder().addColumn(distinct, columnAndProperty.get0(), columnAndProperty.get1());
        //        }
        queryRelation.fetchProperty(0, distinct, propertyName);
        return (P) this;
    }

    /**
     * Property.
     *
     * @param aggregateFunction the aggregate function
     * @param distinct the distinct
     * @param propertyName the property name
     * @return the e
     */
    @SuppressWarnings("unchecked")
    public P property(AggregateFunction aggregateFunction, boolean distinct, String propertyName) {
        queryRelation.fetchProperty(0, aggregateFunction, distinct, propertyName);
        //        Tuple2<String, String> columnAndProperty = ClassMappingUtils.getColumnAndPropertyName(propertyName,
        //            queryRelation.getEntityRelationTuple().getOrNull0().getClassMapping());
        //        if (Lang.isEmpty(columnAndProperty.get1())) {
        //            queryRelation.getBuilder().addColumn(aggregateFunction, distinct, columnAndProperty.get0());
        //        } else {
        //            queryRelation.getBuilder().addColumn(aggregateFunction, distinct, columnAndProperty.get0(),
        //                columnAndProperty.get1());
        //        }
        return (P) this;
    }

    /**
     * Property.
     *
     * @param <R> the generic type
     * @param aggregateFunction the aggregate function
     * @param distinct the distinct
     * @param propertyName the property name
     * @return the e
     */
    @Override
    public <R> P property(AggregateFunction aggregateFunction, boolean distinct,
        SerializableFunction<E, R> propertyName) {
        return property(aggregateFunction, distinct, LambdaUtils.getLambdaPropertyName(propertyName));
    }

    /**
     * Property.
     *
     * @param <R> the generic type
     * @param distinct the distinct
     * @param propertyName the property name
     * @return the e
     */
    @Override
    public <R> P property(boolean distinct, SerializableFunction<E, R> propertyName) {
        return property(distinct, LambdaUtils.getLambdaPropertyName(propertyName));
    }

    /**
     * Property alias.
     *
     * @param <R> the generic type
     * @param propertyName the property name
     * @param alias the alias
     * @return the e
     */
    public <R> P propertyAlias(SerializableFunction<E, R> propertyName, String alias) {
        return propertyAlias(LambdaUtils.getLambdaPropertyName(propertyName), alias);
    }

    /**
     * Property alias.
     *
     * @param propertyName the column name
     * @param alias the alias
     * @return the e
     */
    @SuppressWarnings("unchecked")
    public P propertyAlias(String propertyName, String alias) {
        //        queryRelation.getBuilder().addColumn(ClassMappingUtils.getColumnName(columnName,
        //            queryRelation.getEntityRelationTuple().getOrNull0().getClassMapping()), alias);
        queryRelation.fetchProperty(0, propertyName);
        return (P) this;
    }

    /**
     * Property alias.
     *
     * @param columnNameMap the column name map
     * @return the e
     */
    @SuppressWarnings("unchecked")
    public P propertyAlias(Map<String, String> columnNameMap) {
        columnNameMap.forEach((k, v) -> {
            propertyAlias(k, v);
        });
        return (P) this;
    }

    /**
     * Id.
     *
     * @param propertyName the property name
     * @return the e
     */
    @SuppressWarnings("unchecked")
    public P id(String propertyName) {
        EntityRelation<?> erm = queryRelation.getEntityRelationTuple().getOrNull0();
        erm.setIdName(ClassMappingUtils.getColumnName(propertyName, erm.getClassMapping()));
        //        queryRelation.getEntityRelationMappingTuple().getOrNull0().idName =
        //                ClassMappingUtils.getColumnName(propertyName, queryRelation.getEntityRelationMappingTuple().getOrNull0().classMapping);
        return (P) this;
    }

    /**
     * Id.
     *
     * @param <R> the generic type
     * @param propertyName the property name
     * @return the e
     */
    public <R> P id(SerializableFunction<E, R> propertyName) {
        return id(LambdaUtils.getLambdaPropertyName(propertyName));
    }
}
