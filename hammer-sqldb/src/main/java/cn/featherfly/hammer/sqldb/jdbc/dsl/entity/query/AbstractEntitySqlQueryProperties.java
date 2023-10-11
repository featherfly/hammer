
package cn.featherfly.hammer.sqldb.jdbc.dsl.entity.query;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.hammer.expression.entity.query.EntityQueryPropertiesExpression;
import cn.featherfly.hammer.expression.query.QueryValueExecutor;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.dsl.entity.EntitySqlRelation.EntityRelationMapping;
import cn.featherfly.hammer.sqldb.jdbc.dsl.query.SqlQueryExpression;

/**
 * abstract entity sql query entity properties.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <P> the generic type
 */
public abstract class AbstractEntitySqlQueryProperties<E, P extends EntityQueryPropertiesExpression<E, P>>
        extends AbstractEntitySqlQuery<E> implements EntityQueryPropertiesExpression<E, P>, QueryValueExecutor {

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param entitySqlQueryRelation the entity sql query relation
     * @param classMapping           the class mapping
     */
    protected AbstractEntitySqlQueryProperties(JdbcMappingFactory factory, SqlPageFactory sqlPageFactory,
            EntitySqlQueryRelation entitySqlQueryRelation) {
        super(factory, sqlPageFactory, entitySqlQueryRelation);
    }

    /**
     * Property.
     *
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the e
     */
    @SuppressWarnings("unchecked")
    public P property(boolean distinct, String propertyName) {
        Tuple2<String, String> columnAndProperty = ClassMappingUtils.getColumnAndPropertyName(propertyName,
                queryRelation.getEntityRelationMappingTuple().getOrNull0().getClassMapping());
        if (Lang.isEmpty(columnAndProperty.get1())) {
            queryRelation.getBuilder().addColumn(distinct, columnAndProperty.get0());
        } else {
            queryRelation.getBuilder().addColumn(distinct, columnAndProperty.get0(), columnAndProperty.get1());
        }
        return (P) this;
    }

    /**
     * Property.
     *
     * @param aggregateFunction the aggregate function
     * @param distinct          the distinct
     * @param propertyName      the property name
     * @return the e
     */
    @SuppressWarnings("unchecked")
    public P property(AggregateFunction aggregateFunction, boolean distinct, String propertyName) {
        Tuple2<String, String> columnAndProperty = ClassMappingUtils.getColumnAndPropertyName(propertyName,
                queryRelation.getEntityRelationMappingTuple().getOrNull0().getClassMapping());
        if (Lang.isEmpty(columnAndProperty.get1())) {
            queryRelation.getBuilder().addColumn(aggregateFunction, distinct, columnAndProperty.get0());
        } else {
            queryRelation.getBuilder().addColumn(aggregateFunction, distinct, columnAndProperty.get0(),
                    columnAndProperty.get1());
        }
        return (P) this;
    }

    /**
     * Property.
     *
     * @param <R>               the generic type
     * @param aggregateFunction the aggregate function
     * @param distinct          the distinct
     * @param propertyName      the property name
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
     * @param <R>          the generic type
     * @param distinct     the distinct
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
     * @param <R>          the generic type
     * @param propertyName the property name
     * @param alias        the alias
     * @return the e
     */
    public <R> P propertyAlias(SerializableFunction<E, R> propertyName, String alias) {
        return propertyAlias(LambdaUtils.getLambdaPropertyName(propertyName), alias);
    }

    /**
     * Property alias.
     *
     * @param columnName the column name
     * @param alias      the alias
     * @return the e
     */
    @SuppressWarnings("unchecked")
    public P propertyAlias(String columnName, String alias) {
        queryRelation.getBuilder().addColumn(ClassMappingUtils.getColumnName(columnName,
                queryRelation.getEntityRelationMappingTuple().getOrNull0().getClassMapping()), alias);
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
        EntityRelationMapping<?> erm = queryRelation.getEntityRelationMappingTuple().getOrNull0();
        erm.setIdName(ClassMappingUtils.getColumnName(propertyName, erm.getClassMapping()));
        //        queryRelation.getEntityRelationMappingTuple().getOrNull0().idName =
        //                ClassMappingUtils.getColumnName(propertyName, queryRelation.getEntityRelationMappingTuple().getOrNull0().classMapping);
        return (P) this;
    }

    /**
     * Id.
     *
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the e
     */
    public <R> P id(SerializableFunction<E, R> propertyName) {
        return id(LambdaUtils.getLambdaPropertyName(propertyName));
    }

    //  /**
    //     * Count.
    //     *
    //     * @param distinct     the distinct
    //     * @param propertyName the property name
    //     * @return the e
    //     */
    //    public P count(boolean distinct, String propertyName) {
    //        return property(AggregateFunction.COUNT, distinct, propertyName);
    //    }
    //
    //    /**
    //     * Count.
    //     *
    //     * @param <R>          the generic type
    //     * @param distinct     the distinct
    //     * @param propertyName the property name
    //     * @return the e
    //     */
    //    public <R> P count(boolean distinct, SerializableFunction<E, R> propertyName) {
    //        return property(AggregateFunction.COUNT, distinct, propertyName);
    //    }

    //    /**
    //     * Sum.
    //     *
    //     * @param distinct     the distinct
    //     * @param propertyName the property name
    //     * @return the e
    //     */
    //    public P sum(boolean distinct, String propertyName) {
    //        return property(AggregateFunction.SUM, distinct, propertyName);
    //    }
    //
    //    /**
    //     * Sum.
    //     *
    //     * @param <R>          the generic type
    //     * @param distinct     the distinct
    //     * @param propertyName the property name
    //     * @return the e
    //     */
    //    public <R> P sum(boolean distinct, SerializableFunction<E, R> propertyName) {
    //        return property(AggregateFunction.SUM, distinct, propertyName);
    //    }
    //
    //    /**
    //     * Max.
    //     *
    //     * @param distinct     the distinct
    //     * @param propertyName the property name
    //     * @return the e
    //     */
    //    public P max(boolean distinct, String propertyName) {
    //        return property(AggregateFunction.MAX, distinct, propertyName);
    //    }
    //
    //    /**
    //     * Max.
    //     *
    //     * @param <R>          the generic type
    //     * @param distinct     the distinct
    //     * @param propertyName the property name
    //     * @return the e
    //     */
    //    public <R> P max(boolean distinct, SerializableFunction<E, R> propertyName) {
    //        return property(AggregateFunction.MAX, distinct, propertyName);
    //    }
    //
    //    /**
    //     * Min.
    //     *
    //     * @param distinct     the distinct
    //     * @param propertyName the property name
    //     * @return the e
    //     */
    //    public P min(boolean distinct, String propertyName) {
    //        return property(AggregateFunction.MIN, distinct, propertyName);
    //    }
    //
    //    /**
    //     * Min.
    //     *
    //     * @param <R>          the generic type
    //     * @param distinct     the distinct
    //     * @param propertyName the property name
    //     * @return the e
    //     */
    //    public <R> P min(boolean distinct, SerializableFunction<E, R> propertyName) {
    //        return property(AggregateFunction.MIN, distinct, propertyName);
    //    }
    //
    //    /**
    //     * Avg.
    //     *
    //     * @param distinct     the distinct
    //     * @param propertyName the property name
    //     * @return the e
    //     */
    //    public P avg(boolean distinct, String propertyName) {
    //        return property(AggregateFunction.AVG, distinct, propertyName);
    //    }
    //
    //    /**
    //     * Avg.
    //     *
    //     * @param <R>          the generic type
    //     * @param distinct     the distinct
    //     * @param propertyName the property name
    //     * @return the e
    //     */
    //    public <R> P avg(boolean distinct, SerializableFunction<E, R> propertyName) {
    //        return property(AggregateFunction.AVG, distinct, propertyName);
    //    }
    //
    //    /**
    //     * Distinct.
    //     *
    //     * @param propertyName the property name
    //     * @return the e
    //     */
    //    public P distinct(String propertyName) {
    //        return property(true, propertyName);
    //    }
    //
    //    /**
    //     * Distinct.
    //     *
    //     * @param <R>          the generic type
    //     * @param propertyName the property name
    //     * @return the e
    //     */
    //    public <R> P distinct(SerializableFunction<E, R> propertyName) {
    //        return property(true, propertyName);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String string() {
        return new SqlQueryExpression(queryRelation.getJdbc(), sqlPageFactory, queryRelation.getBuilder(),
                queryRelation.getIgnorePolicy()).string();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date date() {
        return new SqlQueryExpression(queryRelation.getJdbc(), sqlPageFactory, queryRelation.getBuilder(),
                queryRelation.getIgnorePolicy()).date();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDate localDate() {
        return new SqlQueryExpression(queryRelation.getJdbc(), sqlPageFactory, queryRelation.getBuilder(),
                queryRelation.getIgnorePolicy()).localDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime localDateTime() {
        return new SqlQueryExpression(queryRelation.getJdbc(), sqlPageFactory, queryRelation.getBuilder(),
                queryRelation.getIgnorePolicy()).localDateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalTime localTime() {
        return new SqlQueryExpression(queryRelation.getJdbc(), sqlPageFactory, queryRelation.getBuilder(),
                queryRelation.getIgnorePolicy()).localTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp timestamp() {
        return new SqlQueryExpression(queryRelation.getJdbc(), sqlPageFactory, queryRelation.getBuilder(),
                queryRelation.getIgnorePolicy()).timestamp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] bytes() {
        return new SqlQueryExpression(queryRelation.getJdbc(), sqlPageFactory, queryRelation.getBuilder(),
                queryRelation.getIgnorePolicy()).bytes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Clob clob() {
        return new SqlQueryExpression(queryRelation.getJdbc(), sqlPageFactory, queryRelation.getBuilder(),
                queryRelation.getIgnorePolicy()).clob();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Blob blob() {
        return new SqlQueryExpression(queryRelation.getJdbc(), sqlPageFactory, queryRelation.getBuilder(),
                queryRelation.getIgnorePolicy()).blob();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean bool() {
        return new SqlQueryExpression(queryRelation.getJdbc(), sqlPageFactory, queryRelation.getBuilder(),
                queryRelation.getIgnorePolicy()).bool();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte byteValue() {
        return new SqlQueryExpression(queryRelation.getJdbc(), sqlPageFactory, queryRelation.getBuilder(),
                queryRelation.getIgnorePolicy()).byteValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public short shortValue() {
        return new SqlQueryExpression(queryRelation.getJdbc(), sqlPageFactory, queryRelation.getBuilder(),
                queryRelation.getIgnorePolicy()).shortValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int intValue() {
        return new SqlQueryExpression(queryRelation.getJdbc(), sqlPageFactory, queryRelation.getBuilder(),
                queryRelation.getIgnorePolicy()).intValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long longValue() {
        return new SqlQueryExpression(queryRelation.getJdbc(), sqlPageFactory, queryRelation.getBuilder(),
                queryRelation.getIgnorePolicy()).longValue();
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Long longInt() {
    //        return new SqlQueryExpression(queryRelation.getJdbc(), sqlPageFactory, queryRelation.getBuilder(),
    //                queryRelation.getIgnorePolicy()).longInt();
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Integer integer() {
    //        return new SqlQueryExpression(queryRelation.getJdbc(), sqlPageFactory, queryRelation.getBuilder(),
    //                queryRelation.getIgnorePolicy()).integer();
    //    }
    //
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public BigDecimal decimal() {
    //        return new SqlQueryExpression(queryRelation.getJdbc(), sqlPageFactory, queryRelation.getBuilder(),
    //                queryRelation.getIgnorePolicy()).decimal();
    //    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <N extends Number> N number(Class<N> type) {
    //        return new SqlQueryExpression(queryRelation.getJdbc(), sqlPageFactory, queryRelation.getBuilder(),
    //                queryRelation.getIgnorePolicy()).number(type);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T value(Class<T> type) {
        return new SqlQueryExpression(queryRelation.getJdbc(), sqlPageFactory, queryRelation.getBuilder(),
                queryRelation.getIgnorePolicy()).value(type);
    }
}
