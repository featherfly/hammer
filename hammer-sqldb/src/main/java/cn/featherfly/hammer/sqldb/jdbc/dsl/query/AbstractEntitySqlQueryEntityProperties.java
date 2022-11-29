
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.Table;
import cn.featherfly.common.db.builder.dml.basic.SqlSelectBasicBuilder;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcMappingFactory;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.hammer.HammerException;
import cn.featherfly.hammer.dsl.query.type.EntityQueryEntityProperties;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * abstract entity sql query entity properties.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <P> the generic type
 */
public abstract class AbstractEntitySqlQueryEntityProperties<E, P extends AbstractEntitySqlQueryEntityProperties<E, P>>
        implements EntityQueryEntityProperties<E> {

    /** The jdbc. */
    protected Jdbc jdbc;

    /** The id name. */
    protected String idName;

    /** The select builder. */
    protected SqlSelectBasicBuilder selectBuilder;

    /** The class mapping. */
    protected JdbcClassMapping<E> classMapping;

    /** The factory. */
    protected JdbcMappingFactory factory;

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
     * @param jdbc           jdbc
     * @param classMapping   classMapping
     * @param factory        MappingFactory
     * @param sqlPageFactory the sql page factory
     * @param aliasManager   aliasManager
     * @param ignorePolicy   the ignore policy
     */
    public AbstractEntitySqlQueryEntityProperties(Jdbc jdbc, JdbcClassMapping<E> classMapping,
            JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, AliasManager aliasManager,
            Predicate<Object> ignorePolicy) {
        AssertIllegalArgument.isNotNull(ignorePolicy, "ignorePolicy");
        this.ignorePolicy = ignorePolicy;
        this.jdbc = jdbc;
        this.classMapping = classMapping;
        this.factory = factory;
        this.sqlPageFactory = sqlPageFactory;
        this.aliasManager = aliasManager;
        String tableAlias = aliasManager.getAlias(classMapping.getRepositoryName());
        if (tableAlias == null) {
            tableAlias = aliasManager.put(classMapping.getRepositoryName());
        }
        if (classMapping.getPrivaryKeyPropertyMappings().size() == 1) {
            idName = classMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName();
        }
        selectBuilder = new SqlSelectBasicBuilder(jdbc.getDialect(), classMapping, tableAlias);

        this.tableAlias = tableAlias;
    }

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
    public AbstractEntitySqlQueryEntityProperties(Jdbc jdbc, DatabaseMetadata databaseMetadata, String tableName,
            String tableAlias, JdbcMappingFactory factory, SqlPageFactory sqlPageFactory, AliasManager aliasManager,
            Predicate<Object> ignorePolicy) {
        AssertIllegalArgument.isNotNull(ignorePolicy, "ignorePolicy");
        this.ignorePolicy = ignorePolicy;
        this.jdbc = jdbc;
        this.factory = factory;
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

    /**
     * Property.
     *
     * @param propertyName the property name
     * @return the e
     */
    @SuppressWarnings("unchecked")
    public P property(boolean distinct, String propertyName) {
        Tuple2<String, String> columnAndProperty = ClassMappingUtils.getColumnAndPropertyName(propertyName,
                classMapping);
        if (Lang.isEmpty(columnAndProperty.get1())) {
            selectBuilder.addColumn(distinct, columnAndProperty.get0());
        } else {
            selectBuilder.addColumn(distinct, columnAndProperty.get0(), columnAndProperty.get1());
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
                classMapping);
        if (Lang.isEmpty(columnAndProperty.get1())) {
            selectBuilder.addColumn(aggregateFunction, distinct, columnAndProperty.get0());
        } else {
            selectBuilder.addColumn(aggregateFunction, distinct, columnAndProperty.get0(), columnAndProperty.get1());
        }
        return (P) this;
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
            property(propertyName);
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
            property(propertyName);
        }
        return (P) this;
    }

    /**
     * Property.
     *
     * @param <R>           the generic type
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
        selectBuilder.addColumn(ClassMappingUtils.getColumnName(columnName, classMapping), alias);
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
        idName = ClassMappingUtils.getColumnName(propertyName, classMapping);
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

    /**
     * Count.
     *
     * @return the e
     */
    @Override
    public Long count() {
        return new SqlQueryExpression(jdbc, sqlPageFactory,
                selectBuilder.addColumn(AggregateFunction.COUNT, Chars.STAR), ignorePolicy).longInt();
    }

    /**
     * Count.
     *
     * @param propertyName the property name
     * @return the e
     */
    public P count(boolean distinct, String propertyName) {
        return property(AggregateFunction.COUNT, distinct, propertyName);
    }

    /**
     * Count.
     *
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the e
     */
    @Override
    public <R> P count(boolean distinct, SerializableFunction<E, R> propertyName) {
        return property(AggregateFunction.COUNT, distinct, propertyName);
    }

    /**
     * Sum.
     *
     * @param propertyName the property name
     * @return the e
     */
    public P sum(boolean distinct, String propertyName) {
        return property(AggregateFunction.SUM, distinct, propertyName);
    }

    /**
     * Sum.
     *
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the e
     */
    @Override
    public <R> P sum(boolean distinct, SerializableFunction<E, R> propertyName) {
        return property(AggregateFunction.SUM, distinct, propertyName);
    }

    /**
     * Max.
     *
     * @param propertyName the property name
     * @return the e
     */
    public P max(boolean distinct, String propertyName) {
        return property(AggregateFunction.MAX, distinct, propertyName);
    }

    /**
     * Max.
     *
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the e
     */
    @Override
    public <R> P max(boolean distinct, SerializableFunction<E, R> propertyName) {
        return property(AggregateFunction.MAX, distinct, propertyName);
    }

    /**
     * Min.
     *
     * @param propertyName the property name
     * @return the e
     */
    public P min(boolean distinct, String propertyName) {
        return property(AggregateFunction.MIN, distinct, propertyName);
    }

    /**
     * Min.
     *
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the e
     */
    @Override
    public <R> P min(boolean distinct, SerializableFunction<E, R> propertyName) {
        return property(AggregateFunction.MIN, distinct, propertyName);
    }

    /**
     * Avg.
     *
     * @param propertyName the property name
     * @return the e
     */
    public P avg(boolean distinct, String propertyName) {
        return property(AggregateFunction.AVG, distinct, propertyName);
    }

    /**
     * Avg.
     *
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the e
     */
    @Override
    public <R> P avg(boolean distinct, SerializableFunction<E, R> propertyName) {
        return property(AggregateFunction.AVG, distinct, propertyName);
    }

    /**
     * Distinct.
     *
     * @param propertyName the property name
     * @return the e
     */
    public P distinct(String propertyName) {
        return property(true, propertyName);
    }

    /**
     * Distinct.
     *
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the e
     */
    @Override
    public <R> P distinct(SerializableFunction<E, R> propertyName) {
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
