
package cn.featherfly.hammer.sqldb.jdbc.dsl.query;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import cn.featherfly.common.db.dialect.Join;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.repository.builder.AliasManager;
import cn.featherfly.common.repository.mapping.RowMapper;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.hammer.config.dsl.QueryConfig;
import cn.featherfly.hammer.dsl.query.QueryConditionGroupExpression;
import cn.featherfly.hammer.dsl.query.QueryEntityProperties;
import cn.featherfly.hammer.dsl.query.QuerySortExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * SqlQueryProperties.
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
     * @param sqlPageFactory   the sql page factory
     * @param aliasManager     aliasManager
     * @param ignoreStrategy   the ignore strategy
     */
    public SqlQueryEntityProperties(Jdbc jdbc, DatabaseMetadata databaseMetadata, String tableName,
            SqlPageFactory sqlPageFactory, AliasManager aliasManager, QueryConfig queryConfig) {
        this(jdbc, databaseMetadata, tableName, aliasManager.put(tableName), sqlPageFactory, aliasManager, queryConfig);
    }

    /**
     * Instantiates a new sql query entity properties.
     *
     * @param jdbc             jdbc
     * @param databaseMetadata databaseMetadata
     * @param tableName        tableName
     * @param tableAlias       tableAlias
     * @param sqlPageFactory   the sql page factory
     * @param aliasManager     aliasManager
     * @param ignoreStrategy   the ignore strategy
     */
    public SqlQueryEntityProperties(Jdbc jdbc, DatabaseMetadata databaseMetadata, String tableName, String tableAlias,
            SqlPageFactory sqlPageFactory, AliasManager aliasManager, QueryConfig queryConfig) {
        super(jdbc, databaseMetadata, tableName, tableAlias, sqlPageFactory, aliasManager, queryConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupExpression where() {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupExpression where(Consumer<QueryConditionGroupExpression> consumer) {
        SqlQueryExpression sqlQueryExpression = new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder,
                queryConfig);
        if (consumer != null) {
            consumer.accept(sqlQueryExpression);
        }
        return sqlQueryExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list() {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(Class<E> type) {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).list(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(RowMapper<E> rowMapper) {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).list(rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(Integer limit) {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).limit(limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(Integer offset, Integer limit) {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).limit(offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(Page page) {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).limit(page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String string() {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).string();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date date() {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).date();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDate localDate() {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).localDate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime localDateTime() {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).localDateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalTime localTime() {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).localTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp timestamp() {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).timestamp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] bytes() {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).bytes();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Clob clob() {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).clob();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Blob blob() {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).blob();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean bool() {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).bool();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte byteValue() {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).byteValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public short shortValue() {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).shortValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int intValue() {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).intValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long longValue() {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).longValue();
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Integer integer() {
    //        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).integer();
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Long longInt() {
    //        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).longInt();
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public BigDecimal decimal() {
    //        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).decimal();
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <N extends Number> N number(Class<N> type) {
    //        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).number(type);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T value(Class<T> type) {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).value(type);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public Long count() {
    //        return new SqlQueryExpression(jdbc, sqlPageFactory, classMapping,
    //                selectBuilder.addColumn(Chars.STAR, AggregateFunction.COUNT), queryConfig).longInt();
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SqlQueryWithOn join(Join join, String repositoryName) {
        //        return new SqlQueryWith(this, aliasManager, factory, sqlPageFactory, selectBuilder.getTableAlias(), getIdName(),
        //                repositoryName, aliasManager.put(repositoryName), join, queryConfig);
        //        SqlQueryEntityProperties sqlQueryEntityProperties, AliasManager aliasManager,
        //        SqlPageFactory sqlPageFactory, String selectTableAlis, String selectTableColumn, String joinTableName,
        //        String joinTableAlias, Join join, Predicate<?> ignoreStrategy
        return new SqlQueryWith(this, aliasManager, sqlPageFactory, tableAlias, getIdName(), repositoryName,
                aliasManager.put(repositoryName), join, queryConfig.getIgnoreStrategy());
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <T> SqlQueryWithOn join(Join join, Class<T> repositoryType) {
    //        //        return new SqlQueryWith(this, aliasManager, factory, sqlPageFactory, selectBuilder.getTableAlias(), getIdName(),
    //        //                repositoryType, join, queryConfig);
    //        return new SqlQueryWith(this, aliasManager, sqlPageFactory, tableAlias, getIdName(), join, queryConfig);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuerySortExpression sort() {
        return new SqlQueryExpression(jdbc, sqlPageFactory, selectBuilder, queryConfig).sort();
    }

}
