
package cn.featherfly.juorm.rdb.jdbc.dsl.query;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import cn.featherfly.common.structure.page.Page;
import cn.featherfly.juorm.dsl.query.QueryConditionGroupExpression;
import cn.featherfly.juorm.dsl.query.QueryEntityProperties;
import cn.featherfly.juorm.expression.query.QueryExecutor;
import cn.featherfly.juorm.mapping.RowMapper;
import cn.featherfly.juorm.rdb.jdbc.Jdbc;
import cn.featherfly.juorm.rdb.jdbc.mapping.ClassMapping;
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

    private Jdbc jdbc;

    private SqlSelectBasicBuilder selectBuilder;

    private ClassMapping<?> classMapping;

    /**
     * @param tableName
     * @param jdbc
     */
    public SqlQueryEntityProperties(String tableName, Jdbc jdbc) {
        this(tableName, jdbc, null);
    }

    /**
     * @param classMapping
     * @param jdbc
     */
    public SqlQueryEntityProperties(ClassMapping<?> classMapping, Jdbc jdbc) {
        this.jdbc = jdbc;
        this.classMapping = classMapping;
        selectBuilder = new SqlSelectBasicBuilder(jdbc.getDialect(), classMapping.getTableName(), null);
    }

    /**
     * @param tableName
     * @param jdbc
     */
    public SqlQueryEntityProperties(String tableName, Jdbc jdbc, String tableAlias) {
        super();
        this.jdbc = jdbc;
        selectBuilder = new SqlSelectBasicBuilder(jdbc.getDialect(), tableName, tableAlias);
    }

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
}
