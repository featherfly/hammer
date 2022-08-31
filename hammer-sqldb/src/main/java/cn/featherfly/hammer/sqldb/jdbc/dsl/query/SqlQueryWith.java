
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import cn.featherfly.common.db.builder.dml.basic.SqlSelectJoinOnBasicBuilder;
import cn.featherfly.common.db.dialect.Join;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.MappingFactory;
import cn.featherfly.common.repository.mapping.RowMapper;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.hammer.dsl.query.QueryWith;
import cn.featherfly.hammer.dsl.query.RepositoryQueryConditionGroupExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * SqlQueryWith .
 *
 * @author zhongj
 */
public class SqlQueryWith implements QueryWith, SqlQueryWithOn, SqlQueryWithEntity {

    /** The sql query entity properties. */
    private SqlQueryEntityProperties sqlQueryEntityProperties;

    /** The alias manager. */
    private AliasManager aliasManager;

    /** The select table alis. */
    private String selectTableAlis;

    /** The select table column. */
    private String selectTableColumn;

    /** The join table name. */
    private String joinTableName;

    /** The join table alias. */
    private String joinTableAlias;

    /** The select join on basic builder. */
    private SqlSelectJoinOnBasicBuilder selectJoinOnBasicBuilder;

    /** The factory. */
    private MappingFactory factory;

    /** The sql page factory. */
    private SqlPageFactory sqlPageFactory;

    /** The class mapping. */
    private ClassMapping<?> classMapping;

    /** The join. */
    private Join join;

    private Predicate<Object> ignorePolicy;

    /**
     * Instantiates a new sql query with.
     *
     * @param sqlQueryEntityProperties the sql query entity properties
     * @param aliasManager             the alias manager
     * @param factory                  the factory
     * @param sqlPageFactory           the sql page factory
     * @param selectTableAlis          the select table alis
     * @param selectTableColumn        the select table column
     * @param joinTableName            the join table name
     * @param joinTableAlias           the join table alias
     * @param ignorePolicy             the ignore policy
     */
    public SqlQueryWith(SqlQueryEntityProperties sqlQueryEntityProperties, AliasManager aliasManager,
            MappingFactory factory, SqlPageFactory sqlPageFactory, String selectTableAlis, String selectTableColumn,
            String joinTableName, String joinTableAlias, Predicate<Object> ignorePolicy) {
        this(sqlQueryEntityProperties, aliasManager, factory, sqlPageFactory, selectTableAlis, selectTableColumn,
                joinTableName, joinTableAlias, null, ignorePolicy);
    }

    /**
     * Instantiates a new sql query with.
     *
     * @param sqlQueryEntityProperties the sql query entity properties
     * @param aliasManager             the alias manager
     * @param factory                  the factory
     * @param sqlPageFactory           the sql page factory
     * @param selectTableAlis          the select table alis
     * @param selectTableColumn        the select table column
     * @param joinTableName            the join table name
     * @param joinTableAlias           the join table alias
     * @param join                     the join
     * @param ignorePolicy             the ignore policy
     */
    public SqlQueryWith(SqlQueryEntityProperties sqlQueryEntityProperties, AliasManager aliasManager,
            MappingFactory factory, SqlPageFactory sqlPageFactory, String selectTableAlis, String selectTableColumn,
            String joinTableName, String joinTableAlias, Join join, Predicate<Object> ignorePolicy) {
        super();
        this.sqlQueryEntityProperties = sqlQueryEntityProperties;
        this.aliasManager = aliasManager;
        this.factory = factory;
        this.sqlPageFactory = sqlPageFactory;
        this.selectTableAlis = selectTableAlis;
        this.selectTableColumn = selectTableColumn;
        this.joinTableName = joinTableName;
        this.joinTableAlias = joinTableAlias;
        this.join = join;
        this.ignorePolicy = ignorePolicy;

        AssertIllegalArgument.isNotNull(ignorePolicy, "ignorePolicy");
        this.ignorePolicy = ignorePolicy;
    }

    /**
     * Instantiates a new sql query with.
     *
     * @param sqlQueryEntityProperties the sql query entity properties
     * @param aliasManager             the alias manager
     * @param factory                  the factory
     * @param sqlPageFactory           the sql page factory
     * @param selectTableAlis          the select table alis
     * @param selectTableColumn        the select table column
     * @param joinType                 the join type
     * @param ignorePolicy             the ignore policy
     */
    public SqlQueryWith(SqlQueryEntityProperties sqlQueryEntityProperties, AliasManager aliasManager,
            MappingFactory factory, SqlPageFactory sqlPageFactory, String selectTableAlis, String selectTableColumn,
            Class<?> joinType, Predicate<Object> ignorePolicy) {
        this(sqlQueryEntityProperties, aliasManager, factory, sqlPageFactory, selectTableAlis, selectTableColumn,
                joinType, null, ignorePolicy);
    }

    /**
     * Instantiates a new sql query with.
     *
     * @param sqlQueryEntityProperties the sql query entity properties
     * @param aliasManager             the alias manager
     * @param factory                  the factory
     * @param sqlPageFactory           the sql page factory
     * @param selectTableAlis          the select table alis
     * @param selectTableColumn        the select table column
     * @param joinType                 the join type
     * @param join                     the join
     * @param ignorePolicy             the ignore policy
     */
    public SqlQueryWith(SqlQueryEntityProperties sqlQueryEntityProperties, AliasManager aliasManager,
            MappingFactory factory, SqlPageFactory sqlPageFactory, String selectTableAlis, String selectTableColumn,
            Class<?> joinType, Join join, Predicate<Object> ignorePolicy) {
        super();
        this.sqlQueryEntityProperties = sqlQueryEntityProperties;
        this.aliasManager = aliasManager;
        this.factory = factory;
        this.selectTableAlis = selectTableAlis;
        this.selectTableColumn = selectTableColumn;
        this.sqlPageFactory = sqlPageFactory;
        classMapping = factory.getClassMapping(joinType);
        joinTableName = classMapping.getRepositoryName();
        joinTableAlias = aliasManager.put(classMapping.getRepositoryName());
        this.join = join;

        AssertIllegalArgument.isNotNull(ignorePolicy, "ignorePolicy");
        this.ignorePolicy = ignorePolicy;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlQueryWithOn with(String repositoryName) {
        return new SqlQueryWith(sqlQueryEntityProperties, aliasManager, factory, sqlPageFactory, selectTableAlis,
                selectTableColumn, repositoryName, aliasManager.put(repositoryName), ignorePolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> SqlQueryWithOn with(Class<T> repositoryType) {
        return new SqlQueryWith(sqlQueryEntityProperties, aliasManager, factory, sqlPageFactory, selectTableAlis,
                selectTableColumn, repositoryType, ignorePolicy);
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

    /**
     * On 2.
     *
     * @param columnName  the column name
     * @param tableAlias  the table alias
     * @param tableColumn the table column
     * @return the sql query with entity
     */
    private SqlQueryWithEntity on2(String columnName, String tableAlias, String tableColumn) {
        if (classMapping == null) {
            selectJoinOnBasicBuilder = sqlQueryEntityProperties.getSelectBuilder().join(join, tableAlias, tableColumn,
                    joinTableName, joinTableAlias, columnName);
        } else {
            selectJoinOnBasicBuilder = sqlQueryEntityProperties.getSelectBuilder().join(join, tableAlias, tableColumn,
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
        selectJoinOnBasicBuilder.addColumn(ClassMappingUtils.getColumnName(propertyName, classMapping));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlQueryWithEntity fetch(String... propertyNames) {
        selectJoinOnBasicBuilder.addColumns(ClassMappingUtils.getColumnNames(classMapping, propertyNames));
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
        selectJoinOnBasicBuilder.addColumns(ClassMappingUtils.getColumnNames(classMapping, propertyNames));
        return this;
    }

    /**
     * <p>
     * 添加select的列
     * </p>
     * .
     *
     * @param <T>          the generic type
     * @param <R>          the generic type
     * @param propertyName propertyName
     * @param aliasName    alias name
     * @return QueryEntityPropertiesExpression
     */
    @Override
    public <T, R> SqlQueryWithEntity fetchAlias(SerializableFunction<T, R> propertyName, String aliasName) {
        return fetchAlias(LambdaUtils.getLambdaPropertyName(propertyName), aliasName);
    }

    /**
     * <p>
     * 添加select的列
     * </p>
     * .
     *
     * @param columnName propertyName
     * @param aliasName  alias name
     * @return QueryEntityPropertiesExpression
     */
    @Override
    public SqlQueryWithEntity fetchAlias(String columnName, String aliasName) {
        selectJoinOnBasicBuilder.addColumn(ClassMappingUtils.getColumnName(columnName, classMapping), aliasName);
        return this;
    }

    /**
     * <p>
     * 添加select的列
     * </p>
     * .
     *
     * @param columnNameMap columnNameMap
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
        return new RepositorySqlQueryExpression(sqlQueryEntityProperties.jdbc, factory, aliasManager, sqlPageFactory,
                classMapping, sqlQueryEntityProperties.selectBuilder, ignorePolicy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionGroupExpression where(Consumer<RepositoryQueryConditionGroupExpression> consumer) {
        RepositorySqlQueryExpression repositorySqlQueryExpression = new RepositorySqlQueryExpression(
                sqlQueryEntityProperties.jdbc, factory, aliasManager, sqlPageFactory, classMapping,
                sqlQueryEntityProperties.selectBuilder, ignorePolicy);
        if (consumer != null) {
            consumer.accept(repositorySqlQueryExpression);
        }
        return repositorySqlQueryExpression;
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
    public QueryLimitExecutor limit(Integer limit) {
        return sqlQueryEntityProperties.limit(limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(Integer offset, Integer limit) {
        return sqlQueryEntityProperties.limit(offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(Page page) {
        return sqlQueryEntityProperties.limit(page);
    }
}
