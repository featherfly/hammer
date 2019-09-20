
package cn.featherfly.juorm.rdb.jdbc.dsl.query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import cn.featherfly.common.structure.page.Page;
import cn.featherfly.juorm.dml.AliasManager;
import cn.featherfly.juorm.dsl.query.QueryConditionGroupExpression;
import cn.featherfly.juorm.dsl.query.QueryEntityProperties;
import cn.featherfly.juorm.expression.query.QueryExecutor;
import cn.featherfly.juorm.mapping.ClassMapping;
import cn.featherfly.juorm.mapping.MappingFactory;
import cn.featherfly.juorm.mapping.RowMapper;
import cn.featherfly.juorm.rdb.jdbc.Jdbc;

/**
 * <p>
 * SqlQueryProperties
 * </p>
 *
 * @author zhongj
 */
public class SqlQueryEntityProperties extends AbstractSqlQueryEntityProperties<SqlQueryEntityProperties>
        implements SqlQueryEntity, QueryEntityProperties {

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
        super(jdbc, classMapping, factory, aliasManager);
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
        super(jdbc, tableName, tableAlias, factory, aliasManager);
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
