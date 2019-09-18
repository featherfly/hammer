
package cn.featherfly.juorm.rdb.jdbc.dsl.query;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.juorm.dsl.query.TypeQueryConditionGroupExpression;
import cn.featherfly.juorm.dsl.query.TypeQueryEntityProperties;
import cn.featherfly.juorm.expression.query.TypeQueryExecutor;
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
public class TypeSqlQueryEntityProperties implements TypeSqlQueryEntity, TypeQueryEntityProperties {

    private Jdbc jdbc;

    private SqlSelectBasicBuilder selectBuilder;

    private ClassMapping<?> classMapping;

    /**
     * @param tableName tableName
     * @param jdbc      jdbc
     */
    public TypeSqlQueryEntityProperties(String tableName, Jdbc jdbc) {
        this(tableName, jdbc, null);
    }

    /**
     * @param classMapping classMapping
     * @param jdbc         jdbc
     */
    public TypeSqlQueryEntityProperties(ClassMapping<?> classMapping, Jdbc jdbc) {
        this.jdbc = jdbc;
        this.classMapping = classMapping;
        selectBuilder = new SqlSelectBasicBuilder(jdbc.getDialect(), classMapping);
    }

    /**
     * @param tableName  tableName
     * @param jdbc       jdbc
     * @param tableAlias tableAlias
     */
    public TypeSqlQueryEntityProperties(String tableName, Jdbc jdbc, String tableAlias) {
        super();
        this.jdbc = jdbc;
        selectBuilder = new SqlSelectBasicBuilder(jdbc.getDialect(), tableName, tableAlias);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryEntityProperties property(String propertyName) {
        selectBuilder.addSelectColumn(ClassMappingUtils.getColumnName(propertyName, classMapping));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryEntityProperties property(String... propertyNames) {
        selectBuilder.addSelectColumns(ClassMappingUtils.getColumnNames(classMapping, propertyNames));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryEntityProperties property(Collection<String> propertyNames) {
        selectBuilder.addSelectColumns(ClassMappingUtils.getColumnNames(classMapping, propertyNames));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryEntityProperties propertyAlias(String columnName, String alias) {
        selectBuilder.addSelectColumn(ClassMappingUtils.getColumnName(columnName, classMapping), alias);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryEntityProperties propertyAlias(Map<String, String> columnNameMap) {
        columnNameMap.forEach((k, v) -> {
            propertyAlias(k, v);
        });
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryConditionGroupExpression where() {
        return new TypeSqlQueryExpression(jdbc, classMapping, selectBuilder);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list() {
        return new TypeSqlQueryExpression(jdbc, classMapping, selectBuilder).list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryExecutor limit(Integer limit) {
        return new TypeSqlQueryExpression(jdbc, classMapping, selectBuilder).limit(limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryExecutor limit(Integer offset, Integer limit) {
        return new TypeSqlQueryExpression(jdbc, classMapping, selectBuilder).limit(offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryExecutor limit(Page page) {
        return new TypeSqlQueryExpression(jdbc, classMapping, selectBuilder).limit(page);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryEntityProperties property(
            @SuppressWarnings("unchecked") SerializableFunction<T, R>... propertyNames) {
        return property(
                Arrays.stream(propertyNames).map(LambdaUtils::getLambdaPropertyName).collect(Collectors.toList()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryEntityProperties property(SerializableFunction<T, R> propertyName) {
        return property(LambdaUtils.getLambdaPropertyName(propertyName));
    }
}
