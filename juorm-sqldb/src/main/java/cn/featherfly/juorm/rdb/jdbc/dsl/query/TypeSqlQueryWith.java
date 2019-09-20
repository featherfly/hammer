
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
import cn.featherfly.juorm.dsl.query.TypeQueryConditionGroupExpression;
import cn.featherfly.juorm.dsl.query.TypeQueryWith;
import cn.featherfly.juorm.dsl.query.TypeQueryWithEntity;
import cn.featherfly.juorm.dsl.query.TypeQueryWithOn;
import cn.featherfly.juorm.expression.query.TypeQueryExecutor;
import cn.featherfly.juorm.mapping.ClassMapping;
import cn.featherfly.juorm.mapping.MappingFactory;
import cn.featherfly.juorm.rdb.jdbc.mapping.ClassMappingUtils;
import cn.featherfly.juorm.rdb.sql.dml.builder.basic.SqlSelectJoinOnBasicBuilder;

/**
 * <p>
 * SqlQueryWith
 * </p>
 *
 * @author zhongj
 */
public class TypeSqlQueryWith implements TypeQueryWith, TypeQueryWithOn, TypeQueryWithEntity {

    private TypeSqlQueryEntityProperties sqlQueryEntityProperties;

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
    public TypeSqlQueryWith(TypeSqlQueryEntityProperties sqlQueryEntityProperties, AliasManager aliasManager,
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
    public TypeSqlQueryWith(TypeSqlQueryEntityProperties sqlQueryEntityProperties, AliasManager aliasManager,
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
    public <T, R> TypeQueryWithOn with(SerializableFunction<T, R> propertyName) {
        return with(LambdaUtils.getLambdaPropertyName(propertyName));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryWithOn with(String repositoryName) {
        return new TypeSqlQueryWith(sqlQueryEntityProperties, aliasManager, factory, selectTableAlis, selectTableColumn,
                ClassMappingUtils.getColumnName(repositoryName, classMapping), aliasManager.put(repositoryName));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> TypeQueryWithOn with(Class<T> repositoryType) {
        return new TypeSqlQueryWith(sqlQueryEntityProperties, aliasManager, factory, selectTableAlis, selectTableColumn,
                repositoryType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryWithEntity on(String propertyName) {
        return on2(propertyName, selectTableAlis, selectTableColumn);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryWithEntity on(String propertyName, String findRepositoryPropertyName) {
        return on2(propertyName, selectTableAlis, findRepositoryPropertyName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryWithEntity on(String propertyName, String repositoryName, String repositoryPropertyName) {
        return on2(propertyName, aliasManager.getAlias(repositoryName), repositoryPropertyName);
    }

    private TypeQueryWithEntity on2(String columnName, String tableAlias, String tableColumn) {
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
    public TypeQueryWithEntity fetch(String propertyName) {
        selectJoinOnBasicBuilder.addSelectColumn(propertyName);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryWithEntity fetch(String... propertyNames) {
        selectJoinOnBasicBuilder.addSelectColumns(propertyNames);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T,
            R> TypeQueryWithEntity fetch(@SuppressWarnings("unchecked") SerializableFunction<T, R>... propertyNames) {
        return fetch(Arrays.stream(propertyNames).map(LambdaUtils::getLambdaPropertyName).collect(Collectors.toList()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> TypeQueryWithEntity fetch(SerializableFunction<T, R> propertyName) {
        return fetch(LambdaUtils.getLambdaPropertyName(propertyName));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryWithEntity fetch(Collection<String> propertyNames) {
        selectJoinOnBasicBuilder.addSelectColumns(propertyNames);
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
    public <T, R> TypeQueryWithEntity propertyAlias(SerializableFunction<T, R> propertyName, String alias) {
        return propertyAlias(LambdaUtils.getLambdaPropertyName(propertyName), alias);
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
    public TypeQueryWithEntity propertyAlias(String columnName, String alias) {
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
    public TypeQueryWithEntity propertyAlias(Map<String, String> columnNameMap) {
        columnNameMap.forEach((k, v) -> {
            propertyAlias(k, v);
        });
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryWith fetch() {
        selectJoinOnBasicBuilder.fetch();
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryConditionGroupExpression where() {
        return sqlQueryEntityProperties.where();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list() {
        return sqlQueryEntityProperties.list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryExecutor limit(Integer limit) {
        return sqlQueryEntityProperties.limit(limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryExecutor limit(Integer offset, Integer limit) {
        return sqlQueryEntityProperties.limit(offset, limit);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeQueryExecutor limit(Page page) {
        return sqlQueryEntityProperties.limit(page);
    }
}
