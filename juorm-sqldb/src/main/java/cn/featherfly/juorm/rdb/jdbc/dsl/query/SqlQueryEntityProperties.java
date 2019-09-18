
package cn.featherfly.juorm.rdb.jdbc.dsl.query;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.StringUtils;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.juorm.dml.AliasManager;
import cn.featherfly.juorm.dsl.query.QueryConditionGroupExpression;
import cn.featherfly.juorm.dsl.query.QueryEntityProperties;
import cn.featherfly.juorm.expression.query.QueryExecutor;
import cn.featherfly.juorm.mapping.ClassMapping;
import cn.featherfly.juorm.mapping.MappingFactory;
import cn.featherfly.juorm.mapping.RowMapper;
import cn.featherfly.juorm.rdb.jdbc.Jdbc;
import cn.featherfly.juorm.rdb.jdbc.mapping.ClassMappingUtils;
import cn.featherfly.juorm.rdb.sql.dml.builder.basic.SqlSelectBasicBuilder;

/**
 * <p>
 * SqlQueryProperties
 * </p>
 *
 * @author zhongj
 */
public class SqlQueryEntityProperties implements SqlQueryEntity, QueryEntityProperties {

    private static final String DEFAULT_ID_NAME = "id";

    protected Jdbc jdbc;

    protected String idName;

    protected SqlSelectBasicBuilder selectBuilder;

    protected ClassMapping<?> classMapping;

    protected MappingFactory factory;

    protected AliasManager aliasManager;

    protected String tableAlias;

    /**
     * @param jdbc         jdbc
     * @param tableName    tableName
     * @param factory      MappingFactory
     * @param aliasManager aliasManager
     */
    public SqlQueryEntityProperties(Jdbc jdbc, String tableName, MappingFactory factory, AliasManager aliasManager) {
        this(jdbc, tableName, aliasManager.put(tableName), factory, aliasManager);
    }

    /**
     * @param jdbc         jdbc
     * @param classMapping classMapping
     * @param factory      MappingFactory
     * @param aliasManager aliasManager
     */
    public SqlQueryEntityProperties(Jdbc jdbc, ClassMapping<?> classMapping, MappingFactory factory,
            AliasManager aliasManager) {
        this.jdbc = jdbc;
        this.classMapping = classMapping;
        this.factory = factory;
        this.aliasManager = aliasManager;
        tableAlias = aliasManager.getAlias(classMapping.getRepositoryName());
        selectBuilder = new SqlSelectBasicBuilder(jdbc.getDialect(), classMapping, tableAlias);
    }

    /**
     * @param tableName    tableName
     * @param jdbc         jdbc
     * @param tableAlias   tableAlias
     * @param factory      MappingFactory
     * @param aliasManager aliasManager
     */
    public SqlQueryEntityProperties(Jdbc jdbc, String tableName, String tableAlias, MappingFactory factory,
            AliasManager aliasManager) {
        super();
        this.jdbc = jdbc;
        this.factory = factory;
        this.aliasManager = aliasManager;
        if (tableAlias == null) {
            tableAlias = aliasManager.put(tableName);
        }
        this.tableAlias = tableAlias;
        selectBuilder = new SqlSelectBasicBuilder(jdbc.getDialect(), tableName, tableAlias);
    }

    //    private SqlQueryEntityProperties(SqlQueryEntityProperties parent, Jdbc jdbc, ClassMapping<?> classMapping,
    //            String tableName, String tableAlias) {
    //        this.jdbc = jdbc;
    //        this.classMapping = classMapping;
    //        if (classMapping != null) {
    //            selectBuilder = new SqlSelectBasicBuilder(jdbc.getDialect(), classMapping);
    //        } else {
    //            selectBuilder = new SqlSelectBasicBuilder(jdbc.getDialect(), tableName, tableAlias);
    //        }
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryEntityProperties property(String propertyName) {
        selectBuilder.addSelectColumn(ClassMappingUtils.getColumnName(propertyName, classMapping));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryEntityProperties property(String... propertyNames) {
        selectBuilder.addSelectColumns(ClassMappingUtils.getColumnNames(classMapping, propertyNames));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryEntityProperties property(Collection<String> propertyNames) {
        selectBuilder.addSelectColumns(ClassMappingUtils.getColumnNames(classMapping, propertyNames));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> QueryEntityProperties property(
            @SuppressWarnings("unchecked") SerializableFunction<T, R>... propertyNames) {
        return property(
                Arrays.stream(propertyNames).map(LambdaUtils::getLambdaPropertyName).collect(Collectors.toList()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> QueryEntityProperties property(SerializableFunction<T, R> propertyName) {
        return property(LambdaUtils.getLambdaPropertyName(propertyName));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> QueryEntityProperties propertyAlias(SerializableFunction<T, R> propertyName, String alias) {
        selectBuilder.addSelectColumn(
                ClassMappingUtils.getColumnName(LambdaUtils.getLambdaPropertyName(propertyName), classMapping), alias);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryEntityProperties propertyAlias(String columnName, String alias) {
        selectBuilder.addSelectColumn(ClassMappingUtils.getColumnName(columnName, classMapping), alias);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryEntityProperties propertyAlias(Map<String, String> columnNameMap) {
        columnNameMap.forEach((k, v) -> {
            propertyAlias(k, v);
        });
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupExpression where() {
        return new SqlQueryExpression(jdbc, classMapping, selectBuilder);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list() {
        return new SqlQueryExpression(jdbc, classMapping, selectBuilder).list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(Class<E> type) {
        return new SqlQueryExpression(jdbc, classMapping, selectBuilder).list(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(RowMapper<E> rowMapper) {
        return new SqlQueryExpression(jdbc, classMapping, selectBuilder).list(rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryExecutor limit(Integer limit) {
        return new SqlQueryExpression(jdbc, classMapping, selectBuilder).limit(limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryExecutor limit(Integer offset, Integer limit) {
        return new SqlQueryExpression(jdbc, classMapping, selectBuilder).limit(offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryExecutor limit(Page page) {
        return new SqlQueryExpression(jdbc, classMapping, selectBuilder).limit(page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String string() {
        return new SqlQueryExpression(jdbc, classMapping, selectBuilder).string();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer integer() {
        return new SqlQueryExpression(jdbc, classMapping, selectBuilder).integer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long longInt() {
        return new SqlQueryExpression(jdbc, classMapping, selectBuilder).longInt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal decimal() {
        return new SqlQueryExpression(jdbc, classMapping, selectBuilder).decimal();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> N number(Class<N> type) {
        return new SqlQueryExpression(jdbc, classMapping, selectBuilder).number(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryEntityProperties id(String propertyName) {
        idName = propertyName;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> QueryEntityProperties id(SerializableFunction<T, R> propertyName) {
        return id(LambdaUtils.getLambdaPropertyName(propertyName));
    }

    private String getIdName() {
        return StringUtils.pickFirst(idName, DEFAULT_ID_NAME);
    }

    /**
     * 返回selectBuilder
     *
     * @return selectBuilder
     */
    SqlSelectBasicBuilder getSelectBuilder() {
        return selectBuilder;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlQueryWithOn with(String repositoryName) {
        return new SqlQueryWith(this, aliasManager, factory, selectBuilder.getTableAlias(), getIdName(), repositoryName,
                aliasManager.put(repositoryName));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> SqlQueryWithOn with(Class<T> repositoryType) {
        return new SqlQueryWith(this, aliasManager, factory, selectBuilder.getTableAlias(), getIdName(),
                repositoryType);
    }
}
