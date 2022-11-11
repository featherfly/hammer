
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
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.MappingFactory;
import cn.featherfly.hammer.HammerException;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * <p>
 * SqlQueryProperties
 * </p>
 * .
 *
 * @author zhongj
 * @param <E> the element type
 * @param <P> the generic type
 */
public abstract class AbstractEntitySqlQueryEntityProperties<E,
        P extends AbstractEntitySqlQueryEntityProperties<E, P>> {

    /** The jdbc. */
    protected Jdbc jdbc;

    /** The id name. */
    protected String idName;

    /** The select builder. */
    protected SqlSelectBasicBuilder selectBuilder;

    /** The class mapping. */
    protected ClassMapping<?> classMapping;

    /** The factory. */
    protected MappingFactory factory;

    /** The sql page factory. */
    protected SqlPageFactory sqlPageFactory;

    /** The alias manager. */
    protected AliasManager aliasManager;

    /** The ignore policy. */
    protected Predicate<Object> ignorePolicy;

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
    public AbstractEntitySqlQueryEntityProperties(Jdbc jdbc, ClassMapping<?> classMapping, MappingFactory factory,
            SqlPageFactory sqlPageFactory, AliasManager aliasManager, Predicate<Object> ignorePolicy) {
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
            String tableAlias, MappingFactory factory, SqlPageFactory sqlPageFactory, AliasManager aliasManager,
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
    }

    /**
     * Property.
     *
     * @param propertyName the property name
     * @return the e
     */
    @SuppressWarnings("unchecked")
    public P property(String propertyName) {
        Tuple2<String, String> columnAndProperty = ClassMappingUtils.getColumnAndPropertyName(propertyName,
                classMapping);
        if (Lang.isEmpty(columnAndProperty.get1())) {
            selectBuilder.addColumn(columnAndProperty.get0());
        } else {
            selectBuilder.addColumn(columnAndProperty.get0(), columnAndProperty.get1());
        }
        return (P) this;
    }

    /**
     * Property.
     *
     * @param propertyName      the property name
     * @param aggregateFunction the aggregate function
     * @return the e
     */
    @SuppressWarnings("unchecked")
    public P property(String propertyName, AggregateFunction aggregateFunction) {
        Tuple2<String, String> columnAndProperty = ClassMappingUtils.getColumnAndPropertyName(propertyName,
                classMapping);
        if (Lang.isEmpty(columnAndProperty.get1())) {
            selectBuilder.addColumn(aggregateFunction, columnAndProperty.get0());
        } else {
            selectBuilder.addColumn(aggregateFunction, columnAndProperty.get1(), columnAndProperty.get0());
        }
        return (P) this;
    }

    /**
     * Property.
     *
     * @param <R>               the generic type
     * @param propertyName      the property name
     * @param aggregateFunction the aggregate function
     * @return the e
     */
    public <R> P property(SerializableFunction<E, R> propertyName, AggregateFunction aggregateFunction) {
        return property(LambdaUtils.getLambdaPropertyName(propertyName), aggregateFunction);
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
    public <R> P property(@SuppressWarnings("unchecked") SerializableFunction<E, R>... propertyNames) {
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
    public <R> P property(SerializableFunction<E, R> propertyName) {
        return property(LambdaUtils.getLambdaPropertyName(propertyName));
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
    public Long count() {
        return new SqlQueryExpression(jdbc, sqlPageFactory, classMapping,
                selectBuilder.addColumn(AggregateFunction.COUNT, Chars.STAR), ignorePolicy).longInt();
    }

    /**
     * Count.
     *
     * @param propertyName the property name
     * @return the e
     */
    public P count(String propertyName) {
        return property(propertyName, AggregateFunction.COUNT);
    }

    /**
     * Count.
     *
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the e
     */
    public <R> P count(SerializableFunction<E, R> propertyName) {
        return property(propertyName, AggregateFunction.COUNT);
    }

    /**
     * Sum.
     *
     * @param propertyName the property name
     * @return the e
     */
    public P sum(String propertyName) {
        return property(propertyName, AggregateFunction.SUM);
    }

    /**
     * Sum.
     *
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the e
     */
    public <R> P sum(SerializableFunction<E, R> propertyName) {
        return property(propertyName, AggregateFunction.SUM);
    }

    /**
     * Max.
     *
     * @param propertyName the property name
     * @return the e
     */
    public P max(String propertyName) {
        return property(propertyName, AggregateFunction.MAX);
    }

    /**
     * Max.
     *
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the e
     */
    public <R> P max(SerializableFunction<E, R> propertyName) {
        return property(propertyName, AggregateFunction.MAX);
    }

    /**
     * Min.
     *
     * @param propertyName the property name
     * @return the e
     */
    public P min(String propertyName) {
        return property(propertyName, AggregateFunction.MIN);
    }

    /**
     * Min.
     *
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the e
     */
    public <R> P min(SerializableFunction<E, R> propertyName) {
        return property(propertyName, AggregateFunction.MIN);
    }

    /**
     * Avg.
     *
     * @param propertyName the property name
     * @return the e
     */
    public P avg(String propertyName) {
        return property(propertyName, AggregateFunction.AVG);
    }

    /**
     * Avg.
     *
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the e
     */
    public <R> P avg(SerializableFunction<E, R> propertyName) {
        return property(propertyName, AggregateFunction.AVG);
    }

    /**
     * Distinct.
     *
     * @param propertyName the property name
     * @return the e
     */
    public P distinct(String propertyName) {
        return property(propertyName, AggregateFunction.DISTINCT);
    }

    /**
     * Distinct.
     *
     * @param <R>          the generic type
     * @param propertyName the property name
     * @return the e
     */
    public <R> P distinct(SerializableFunction<E, R> propertyName) {
        return property(propertyName, AggregateFunction.DISTINCT);
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
