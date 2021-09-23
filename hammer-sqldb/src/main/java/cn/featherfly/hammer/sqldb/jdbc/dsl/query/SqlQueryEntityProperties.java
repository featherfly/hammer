
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.dialect.Join;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.MappingFactory;
import cn.featherfly.common.repository.mapping.RowMapper;
import cn.featherfly.common.repository.operate.AggregateFunction;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.hammer.dsl.query.QueryConditionGroupExpression;
import cn.featherfly.hammer.dsl.query.QueryEntityProperties;
import cn.featherfly.hammer.dsl.query.QuerySortExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * <p>
 * SqlQueryProperties
 * </p>
 * .
 *
 * @author zhongj
 */
public class SqlQueryEntityProperties extends AbstractSqlQueryEntityProperties<SqlQueryEntityProperties>
        implements SqlQueryEntity, QueryEntityProperties {

    /**
     * Instantiates a new sql query entity properties.
     *
     * @param jdbc             jdbc
     * @param databaseMetadata the database metadata
     * @param tableName        tableName
     * @param factory          MappingFactory
     * @param sqlPageFactory   the sql page factory
     * @param aliasManager     aliasManager
     */
    public SqlQueryEntityProperties(Jdbc jdbc, DatabaseMetadata databaseMetadata, String tableName,
            MappingFactory factory, SqlPageFactory sqlPageFactory, AliasManager aliasManager) {
        this(jdbc, databaseMetadata, tableName, aliasManager.put(tableName), factory, sqlPageFactory, aliasManager);
    }

    /**
     * Instantiates a new sql query entity properties.
     *
     * @param jdbc           jdbc
     * @param classMapping   classMapping
     * @param factory        MappingFactory
     * @param sqlPageFactory the sql page factory
     * @param aliasManager   aliasManager
     */
    public SqlQueryEntityProperties(Jdbc jdbc, ClassMapping<?> classMapping, MappingFactory factory,
            SqlPageFactory sqlPageFactory, AliasManager aliasManager) {
        super(jdbc, classMapping, factory, sqlPageFactory, aliasManager);
    }

    /**
     * Instantiates a new sql query entity properties.
     *
     * @param jdbc             jdbc
     * @param databaseMetadata databaseMetadata
     * @param tableName        tableName
     * @param tableAlias       tableAlias
     * @param factory          MappingFactory
     * @param sqlPageFactory   the sql page factory
     * @param aliasManager     aliasManager
     */
    public SqlQueryEntityProperties(Jdbc jdbc, DatabaseMetadata databaseMetadata, String tableName, String tableAlias,
            MappingFactory factory, SqlPageFactory sqlPageFactory, AliasManager aliasManager) {
        super(jdbc, databaseMetadata, tableName, tableAlias, factory, sqlPageFactory, aliasManager);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupExpression where() {
        return new SqlQueryExpression(jdbc, sqlPageFactory, classMapping, selectBuilder);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list() {
        return new SqlQueryExpression(jdbc, sqlPageFactory, classMapping, selectBuilder).list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(Class<E> type) {
        return new SqlQueryExpression(jdbc, sqlPageFactory, classMapping, selectBuilder).list(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(RowMapper<E> rowMapper) {
        return new SqlQueryExpression(jdbc, sqlPageFactory, classMapping, selectBuilder).list(rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(Integer limit) {
        return new SqlQueryExpression(jdbc, sqlPageFactory, classMapping, selectBuilder).limit(limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(Integer offset, Integer limit) {
        return new SqlQueryExpression(jdbc, sqlPageFactory, classMapping, selectBuilder).limit(offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(Page page) {
        return new SqlQueryExpression(jdbc, sqlPageFactory, classMapping, selectBuilder).limit(page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String string() {
        return new SqlQueryExpression(jdbc, sqlPageFactory, classMapping, selectBuilder).string();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer integer() {
        return new SqlQueryExpression(jdbc, sqlPageFactory, classMapping, selectBuilder).integer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long longInt() {
        return new SqlQueryExpression(jdbc, sqlPageFactory, classMapping, selectBuilder).longInt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal decimal() {
        return new SqlQueryExpression(jdbc, sqlPageFactory, classMapping, selectBuilder).decimal();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> N number(Class<N> type) {
        return new SqlQueryExpression(jdbc, sqlPageFactory, classMapping, selectBuilder).number(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long count() {
        return new SqlQueryExpression(jdbc, sqlPageFactory, classMapping,
                selectBuilder.addSelectColumn(Chars.STAR, AggregateFunction.COUNT)).longInt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlQueryWithOn with(String repositoryName) {
        return join(repositoryName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlQueryWithOn join(String repositoryName) {
        return join(Join.INNER_JOIN, repositoryName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlQueryWithOn join(Join join, String repositoryName) {
        return new SqlQueryWith(this, aliasManager, factory, sqlPageFactory, selectBuilder.getTableAlias(), getIdName(),
                repositoryName, aliasManager.put(repositoryName), join);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> SqlQueryWithOn with(Class<T> repositoryType) {
        return join(repositoryType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> SqlQueryWithOn join(Class<T> repositoryType) {
        return join(Join.INNER_JOIN, repositoryType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> SqlQueryWithOn join(Join join, Class<T> repositoryType) {
        return new SqlQueryWith(this, aliasManager, factory, sqlPageFactory, selectBuilder.getTableAlias(), getIdName(),
                repositoryType, join);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuerySortExpression sort() {
        return new SqlQueryExpression(jdbc, sqlPageFactory, classMapping, selectBuilder).sort();
    }
}
