
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.util.Map;
import java.util.function.Predicate;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.Table;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.HammerException;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * SqlQueryProperties.
 *
 * @author zhongj
 * @param <E> the element type
 */
public abstract class AbstractSqlQueryEntityProperties<E extends AbstractSqlQueryEntityProperties<E>> {

    /** The jdbc. */
    protected Jdbc jdbc;

    /** The id name. */
    protected String idName;

    /** The select builder. */
    protected SqlSelectBasicBuilder selectBuilder;

    /** The sql page factory. */
    protected SqlPageFactory sqlPageFactory;

    /** The alias manager. */
    protected AliasManager aliasManager;

    /** The ignore policy. */
    protected Predicate<Object> ignorePolicy;

    /** The table alias. */
    protected String tableAlias;

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param jdbc             jdbc
     * @param databaseMetadata databaseMetadata
     * @param tableName        tableName
     * @param tableAlias       tableAlias
     * @param factory          MappingFactory
     * @param sqlPageFactory   the sql page factory
     * @param aliasManager     aliasManager
     * @param ignorePolicy     the ignore policy
     */
    public AbstractSqlQueryEntityProperties(Jdbc jdbc, DatabaseMetadata databaseMetadata, String tableName,
            String tableAlias, JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, AliasManager aliasManager,
            Predicate<Object> ignorePolicy) {
        AssertIllegalArgument.isNotNull(ignorePolicy, "ignorePolicy");
        this.ignorePolicy = ignorePolicy;
        this.jdbc = jdbc;
        this.sqlPageFactory = sqlPageFactory;
        this.aliasManager = aliasManager;
        if (tableAlias == null) {
            tableAlias = aliasManager.put(tableName);
        }
        Table tableMetadata = databaseMetadata.getTable(tableName);
        if (tableMetadata.getPrimaryColumns().size() == 1) {
            idName = tableMetadata.getPrimaryColumns().get(0).getName();
        }
        selectBuilder = new SqlSelectBasicBuilder(jdbc.getDialect(), tableName, tableAlias);

        this.tableAlias = tableAlias;
    }

    //    /**
    //     * Property.
    //     *
    //     * @param propertyName the property name
    //     * @return the e
    //     */
    //    public E property(String propertyName) {
    //        return property(false, propertyName);
    //    }

    /**
     * Property.
     *
     * @param distinct   the distinct
     * @param columnName the column name
     * @return the e
     */
    @SuppressWarnings("unchecked")
    public E property(boolean distinct, String columnName) {
        selectBuilder.addColumn(distinct, columnName);
        return (E) this;
    }

    /**
     * Property.
     *
     * @param distinct   the distinct
     * @param columnName the column name
     * @return the e
     */
    @SuppressWarnings("unchecked")
    public E property(boolean distinct, String columnName, String columnAlias) {
        selectBuilder.addColumn(distinct, columnName, columnAlias);
        return (E) this;
    }

    /**
     * Property.
     *
     * @param aggregateFunction the aggregate function
     * @param distinct          the distinct
     * @param columnName        the column name
     * @return the e
     */
    @SuppressWarnings("unchecked")
    public E property(AggregateFunction aggregateFunction, boolean distinct, String columnName) {
        selectBuilder.addColumn(aggregateFunction, distinct, columnName);
        return (E) this;
    }

    /**
     * Property.
     *
     * @param aggregateFunction the aggregate function
     * @param distinct          the distinct
     * @param columnName        the column name
     * @param columnAlias       the column alias
     * @return the e
     */
    @SuppressWarnings("unchecked")
    public E property(AggregateFunction aggregateFunction, boolean distinct, String columnName, String columnAlias) {
        selectBuilder.addColumn(aggregateFunction, distinct, columnName, columnAlias);
        return (E) this;
    }

    /**
     * Property.
     *
     * @param <T>               the generic type
     * @param <R>               the generic type
     * @param aggregateFunction the aggregate function
     * @param distinct          the distinct
     * @param propertyName      the property name
     * @return the e
     */
    public <T, R> E property(AggregateFunction aggregateFunction, boolean distinct,
            SerializableFunction<T, R> propertyName) {
        return property(aggregateFunction, distinct, LambdaUtils.getLambdaPropertyName(propertyName));
    }

    //    /**
    //     * Property.
    //     *
    //     * @param propertyNames the property names
    //     * @return the e
    //     */
    //    @SuppressWarnings("unchecked")
    //    public E property(String... propertyNames) {
    //        for (String propertyName : propertyNames) {
    //            property(propertyName);
    //        }
    //        return (E) this;
    //    }

    //    /**
    //     * Property.
    //     *
    //     * @param propertyNames the property names
    //     * @return the e
    //     */
    //    @SuppressWarnings("unchecked")
    //    public E property(Collection<String> propertyNames) {
    //        for (String propertyName : propertyNames) {
    //            property(propertyName);
    //        }
    //        return (E) this;
    //    }

    //    /**
    //     * Property.
    //     *
    //     * @param <T>           the generic type
    //     * @param <R>           the generic type
    //     * @param propertyNames the property names
    //     * @return the e
    //     */
    //    public <T, R> E property(@SuppressWarnings("unchecked") SerializableFunction<T, R>... propertyNames) {
    //        return property(
    //                Arrays.stream(propertyNames).map(LambdaUtils::getLambdaPropertyName).collect(Collectors.toList()));
    //    }

    //    /**
    //     * Property.
    //     *
    //     * @param <T>          the generic type
    //     * @param <R>          the generic type
    //     * @param propertyName the property name
    //     * @return the e
    //     */
    //    public <T, R> E property(SerializableFunction<T, R> propertyName) {
    //        return property(false, propertyName);
    //    }

    /**
     * Property.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the e
     */
    public <T, R> E property(boolean distinct, SerializableFunction<T, R> propertyName) {
        return property(distinct, LambdaUtils.getLambdaPropertyName(propertyName));
    }

    /**
     * Property alias.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName the property name
     * @param alias        the alias
     * @return the e
     */
    public <T, R> E propertyAlias(SerializableFunction<T, R> propertyName, String alias) {
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
    public E propertyAlias(String columnName, String alias) {
        selectBuilder.addColumn(columnName, alias);
        return (E) this;
    }

    /**
     * Property alias.
     *
     * @param columnNameMap the column name map
     * @return the e
     */
    @SuppressWarnings("unchecked")
    public E propertyAlias(Map<String, String> columnNameMap) {
        columnNameMap.forEach((k, v) -> {
            propertyAlias(k, v);
        });
        return (E) this;
    }

    /**
     * Id.
     *
     * @param propertyName the property name
     * @return the e
     */
    @SuppressWarnings("unchecked")
    public E id(String columnName) {
        idName = columnName;
        return (E) this;
    }

    /**
     * Id.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the e
     */
    public <T, R> E id(SerializableFunction<T, R> propertyName) {
        return id(LambdaUtils.getLambdaPropertyName(propertyName));
    }

    /**
     * Count.
     *
     * @return the e
     */
    public Long count() {
        return new SqlQueryExpression(jdbc, sqlPageFactory,
                selectBuilder.addColumn(AggregateFunction.COUNT, Chars.STAR), ignorePolicy).longInt();
    }

    /**
     * Count.
     *
     * @param distinct   the distinct
     * @param columnName the column name
     * @return the e
     */
    public E count(boolean distinct, String columnName) {
        return property(AggregateFunction.COUNT, distinct, columnName);
    }

    /**
     * Count.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the e
     */
    public <T, R> E count(boolean distinct, SerializableFunction<T, R> propertyName) {
        return count(distinct, LambdaUtils.getLambdaPropertyName(propertyName));
    }

    /**
     * Sum.
     *
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the e
     */
    public E sum(boolean distinct, String propertyName) {
        return property(AggregateFunction.SUM, distinct, propertyName);
    }

    /**
     * Sum.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the e
     */
    public <T, R> E sum(boolean distinct, SerializableFunction<T, R> propertyName) {
        return sum(distinct, LambdaUtils.getLambdaPropertyName(propertyName));
    }

    /**
     * Max.
     *
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the e
     */
    public E max(boolean distinct, String propertyName) {
        return property(AggregateFunction.MAX, distinct, propertyName);
    }

    /**
     * Max.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the e
     */
    public <T, R> E max(boolean distinct, SerializableFunction<T, R> propertyName) {
        return property(AggregateFunction.MAX, distinct, propertyName);
    }

    /**
     * Min.
     *
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the e
     */
    public E min(boolean distinct, String propertyName) {
        return property(AggregateFunction.MIN, distinct, propertyName);
    }

    /**
     * Min.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the e
     */
    public <T, R> E min(boolean distinct, SerializableFunction<T, R> propertyName) {
        return property(AggregateFunction.MIN, distinct, propertyName);
    }

    /**
     * Avg.
     *
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the e
     */
    public E avg(boolean distinct, String propertyName) {
        return property(AggregateFunction.AVG, distinct, propertyName);
    }

    /**
     * Avg.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param distinct     the distinct
     * @param propertyName the property name
     * @return the e
     */
    public <T, R> E avg(boolean distinct, SerializableFunction<T, R> propertyName) {
        return property(AggregateFunction.AVG, distinct, propertyName);
    }

    /**
     * Distinct.
     *
     * @param propertyName the property name
     * @return the e
     */
    public E distinct(String propertyName) {
        return property(true, propertyName);
    }

    /**
     * Distinct.
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the e
     */
    public <T, R> E distinct(SerializableFunction<T, R> propertyName) {
        return property(true, propertyName);
    }

    /**
     * Gets the id name.
     *
     * @return the id name
     */
    protected String getIdName() {
        if (Lang.isEmpty(idName)) {
            throw new HammerException("privary key column name is null");
        }
        return idName;
    }

    /**
     * 返回selectBuilder.
     *
     * @return selectBuilder
     */
    SqlSelectBasicBuilder getSelectBuilder() {
        return selectBuilder;
    }
}
