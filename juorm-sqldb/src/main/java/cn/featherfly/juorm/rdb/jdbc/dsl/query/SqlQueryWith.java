
package cn.featherfly.juorm.rdb.jdbc.dsl.query;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.juorm.dml.AliasManager;
import cn.featherfly.juorm.dsl.query.QueryWith;
import cn.featherfly.juorm.dsl.query.RepositoryQueryConditionGroupExpression;
import cn.featherfly.juorm.expression.query.QueryExecutor;
import cn.featherfly.juorm.mapping.ClassMapping;
import cn.featherfly.juorm.mapping.MappingFactory;
import cn.featherfly.juorm.mapping.RowMapper;
import cn.featherfly.juorm.rdb.jdbc.mapping.ClassMappingUtils;
import cn.featherfly.juorm.rdb.sql.dml.builder.basic.SqlSelectJoinOnBasicBuilder;

/**
 * <p>
 * SqlQueryWith
 * </p>
 *
 * @author zhongj
 */
public class SqlQueryWith implements QueryWith, SqlQueryWithOn, SqlQueryWithEntity {

    private SqlQueryEntityProperties sqlQueryEntityProperties;

    private AliasManager aliasManager;

    private String selectTableAlis;

    private String selectTableColumn;

    private String joinTableName;

    private String joinTableAlias;

    private SqlSelectJoinOnBasicBuilder selectJoinOnBasicBuilder;

    private MappingFactory factory;

    private ClassMapping<?> classMapping;

    /**
     * @param sqlQueryEntityProperties
     * @param aliasManager
     * @param factory
     * @param selectTableAlis
     * @param selectTableColumn
     * @param joinTableName
     * @param joinTableAlias
     */
    public SqlQueryWith(SqlQueryEntityProperties sqlQueryEntityProperties, AliasManager aliasManager,
            MappingFactory factory, String selectTableAlis, String selectTableColumn, String joinTableName,
            String joinTableAlias) {
        super();
        this.sqlQueryEntityProperties = sqlQueryEntityProperties;
        this.aliasManager = aliasManager;
        this.factory = factory;
        this.selectTableAlis = selectTableAlis;
        this.selectTableColumn = selectTableColumn;
        this.joinTableName = joinTableName;
        this.joinTableAlias = joinTableAlias;
    }

    /**
     * @param sqlQueryEntityProperties
     * @param aliasManager
     * @param factory
     * @param selectTableAlis
     * @param selectTableColumn
     * @param joinType
     */
    public SqlQueryWith(SqlQueryEntityProperties sqlQueryEntityProperties, AliasManager aliasManager,
            MappingFactory factory, String selectTableAlis, String selectTableColumn, Class<?> joinType) {
        super();
        this.sqlQueryEntityProperties = sqlQueryEntityProperties;
        this.aliasManager = aliasManager;
        this.factory = factory;
        this.selectTableAlis = selectTableAlis;
        this.selectTableColumn = selectTableColumn;
        classMapping = factory.getClassMapping(joinType);
        joinTableName = classMapping.getRepositoryName();
        joinTableAlias = aliasManager.put(classMapping.getRepositoryName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlQueryWithOn with(String repositoryName) {
        return new SqlQueryWith(sqlQueryEntityProperties, aliasManager, factory, selectTableAlis, selectTableColumn,
                repositoryName, aliasManager.put(repositoryName));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> SqlQueryWithOn with(Class<T> repositoryType) {
        return new SqlQueryWith(sqlQueryEntityProperties, aliasManager, factory, selectTableAlis, selectTableColumn,
                repositoryType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlQueryWithEntity on(String propertyName) {
        return on2(propertyName, selectTableAlis, selectTableColumn);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlQueryWithEntity on(String propertyName, String findRepositoryPropertyName) {
        return on2(propertyName, selectTableAlis, findRepositoryPropertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlQueryWithEntity on(String propertyName, String repositoryName, String repositoryPropertyName) {
        return on2(propertyName, aliasManager.getAlias(repositoryName), repositoryPropertyName);
    }

    private SqlQueryWithEntity on2(String columnName, String tableAlias, String tableColumn) {
        if (classMapping == null) {
            selectJoinOnBasicBuilder = sqlQueryEntityProperties.getSelectBuilder().join(tableAlias, tableColumn,
                    joinTableName, joinTableAlias, columnName);
        } else {
            selectJoinOnBasicBuilder = sqlQueryEntityProperties.getSelectBuilder().join(tableAlias, tableColumn,
                    classMapping, joinTableAlias, columnName);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> SqlQueryWithEntity fetch(SerializableFunction<T, R> propertyName) {
        return fetch(LambdaUtils.getLambdaPropertyName(propertyName));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlQueryWithEntity fetch(String propertyName) {
        selectJoinOnBasicBuilder.addSelectColumn(ClassMappingUtils.getColumnName(propertyName, classMapping));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlQueryWithEntity fetch(String... propertyNames) {
        selectJoinOnBasicBuilder.addSelectColumns(ClassMappingUtils.getColumnNames(classMapping, propertyNames));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> SqlQueryWithEntity fetch(@SuppressWarnings("unchecked") SerializableFunction<T, R>... propertyNames) {
        return fetch(Arrays.stream(propertyNames).map(LambdaUtils::getLambdaPropertyName).collect(Collectors.toList()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlQueryWithEntity fetch(Collection<String> propertyNames) {
        selectJoinOnBasicBuilder.addSelectColumns(ClassMappingUtils.getColumnNames(classMapping, propertyNames));
        return this;
    }

    /**
     * <p>
     * 添加select的列
     * </p>
     *
     * @param columnName propertyName
     * @param asName     alias name
     * @return QueryEntityPropertiesExpression
     */
    @Override
    public <T, R> SqlQueryWithEntity fetchAlias(SerializableFunction<T, R> propertyName, String alias) {
        return fetchAlias(LambdaUtils.getLambdaPropertyName(propertyName), alias);
    }

    /**
     * <p>
     * 添加select的列
     * </p>
     *
     * @param columnName propertyName
     * @param asName     alias name
     * @return QueryEntityPropertiesExpression
     */
    @Override
    public SqlQueryWithEntity fetchAlias(String columnName, String alias) {
        selectJoinOnBasicBuilder.addSelectColumn(ClassMappingUtils.getColumnName(columnName, classMapping), alias);
        return this;
    }

    /**
     * <p>
     * 添加select的列
     * </p>
     *
     * @param columnName propertyName
     * @param asName     alias name
     * @return QueryEntityPropertiesExpression
     */
    @Override
    public SqlQueryWithEntity fetchAlias(Map<String, String> columnNameMap) {
        columnNameMap.forEach((k, v) -> {
            fetchAlias(k, v);
        });
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryWith fetch() {
        selectJoinOnBasicBuilder.fetch();
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionGroupExpression where() {
        //        return sqlQueryEntityProperties.where();
        return new RepositorySqlQueryExpression(sqlQueryEntityProperties.jdbc, factory, aliasManager, classMapping,
                sqlQueryEntityProperties.selectBuilder);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list() {
        return sqlQueryEntityProperties.list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(Class<E> type) {
        return sqlQueryEntityProperties.list(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(RowMapper<E> rowMapper) {
        return sqlQueryEntityProperties.list(rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryExecutor limit(Integer limit) {
        return sqlQueryEntityProperties.limit(limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryExecutor limit(Integer offset, Integer limit) {
        return sqlQueryEntityProperties.limit(offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryExecutor limit(Page page) {
        return sqlQueryEntityProperties.limit(page);
    }

}
