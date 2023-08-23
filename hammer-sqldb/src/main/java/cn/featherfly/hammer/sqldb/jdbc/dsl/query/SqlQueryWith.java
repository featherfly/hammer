
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
import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.repository.builder.AliasManager;
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

    /** The sql page factory. */
    private SqlPageFactory sqlPageFactory;

    /** The join. */
    private Join join;

    private Predicate<Object> ignoreStrategy;

    /**
     * Instantiates a new sql query with.
     *
     * @param sqlQueryEntityProperties the sql query entity properties
     * @param aliasManager             the alias manager
     * @param sqlPageFactory           the sql page factory
     * @param selectTableAlis          the select table alis
     * @param selectTableColumn        the select table column
     * @param joinTableName            the join table name
     * @param joinTableAlias           the join table alias
     * @param ignoreStrategy           the ignore strategy
     */
    public SqlQueryWith(SqlQueryEntityProperties sqlQueryEntityProperties, AliasManager aliasManager,
            SqlPageFactory sqlPageFactory, String selectTableAlis, String selectTableColumn, String joinTableName,
            String joinTableAlias, Predicate<Object> ignoreStrategy) {
        this(sqlQueryEntityProperties, aliasManager, sqlPageFactory, selectTableAlis, selectTableColumn, joinTableName,
                joinTableAlias, Join.INNER_JOIN, ignoreStrategy);
    }

    /**
     * Instantiates a new sql query with.
     *
     * @param sqlQueryEntityProperties the sql query entity properties
     * @param aliasManager             the alias manager
     * @param sqlPageFactory           the sql page factory
     * @param selectTableAlis          the select table alis
     * @param selectTableColumn        the select table column
     * @param joinTableName            the join table name
     * @param joinTableAlias           the join table alias
     * @param join                     the join
     * @param ignoreStrategy           the ignore strategy
     */
    public SqlQueryWith(SqlQueryEntityProperties sqlQueryEntityProperties, AliasManager aliasManager,
            SqlPageFactory sqlPageFactory, String selectTableAlis, String selectTableColumn, String joinTableName,
            String joinTableAlias, Join join, Predicate<Object> ignoreStrategy) {
        super();
        AssertIllegalArgument.isNotNull(ignoreStrategy, "ignoreStrategy");
        this.sqlQueryEntityProperties = sqlQueryEntityProperties;
        this.aliasManager = aliasManager;
        this.sqlPageFactory = sqlPageFactory;
        this.selectTableAlis = selectTableAlis;
        this.selectTableColumn = selectTableColumn;
        this.joinTableName = joinTableName;
        this.joinTableAlias = joinTableAlias;
        this.join = join;
        this.ignoreStrategy = ignoreStrategy;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlQueryWithOn join(String repositoryName) {
        return new SqlQueryWith(sqlQueryEntityProperties, aliasManager, sqlPageFactory, selectTableAlis,
                selectTableColumn, repositoryName, aliasManager.put(repositoryName), ignoreStrategy);
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
        selectJoinOnBasicBuilder = sqlQueryEntityProperties.getSelectBuilder().join(join, tableAlias, tableColumn,
                joinTableName, joinTableAlias, columnName);
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
        selectJoinOnBasicBuilder.addColumn(propertyName);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlQueryWithEntity fetch(String... propertyNames) {
        selectJoinOnBasicBuilder.addColumns(propertyNames);
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
        selectJoinOnBasicBuilder.addColumns(propertyNames);
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
     * {@inheritDoc}
     */
    @Override
    public SqlQueryWithEntity fetchAlias(String columnName, String aliasName) {
        selectJoinOnBasicBuilder.addColumn(columnName, aliasName);
        return this;
    }

    /**
     * {@inheritDoc}
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
        // IMPLSOON 后续来实现，先让编译通过
        throw new NotImplementedException();
        //        return new RepositorySqlQueryExpression(sqlQueryEntityProperties.jdbc, aliasManager,
        //                sqlQueryEntityProperties.selectBuilder, sqlPageFactory, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryQueryConditionGroupExpression where(Consumer<RepositoryQueryConditionGroupExpression> consumer) {
        // IMPLSOON 后续来实现，先让编译通过
        throw new NotImplementedException();
        //        RepositorySqlQueryExpression repositorySqlQueryExpression = new RepositorySqlQueryExpression(
        //                sqlQueryEntityProperties.jdbc, aliasManager, sqlQueryEntityProperties.selectBuilder, sqlPageFactory,
        //                ignoreStrategy);
        //        if (consumer != null) {
        //            consumer.accept(repositorySqlQueryExpression);
        //        }
        //        return repositorySqlQueryExpression;
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
