
package cn.featherfly.juorm.rdb.jdbc.dsl.query;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.StringUtils;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.juorm.dml.AliasManager;
import cn.featherfly.juorm.mapping.ClassMapping;
import cn.featherfly.juorm.mapping.MappingFactory;
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
public abstract class AbstractSqlQueryEntityProperties<E extends AbstractSqlQueryEntityProperties<E>> {

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
     * @param classMapping classMapping
     * @param factory      MappingFactory
     * @param aliasManager aliasManager
     */
    public AbstractSqlQueryEntityProperties(Jdbc jdbc, ClassMapping<?> classMapping, MappingFactory factory,
            AliasManager aliasManager) {
        this.jdbc = jdbc;
        this.classMapping = classMapping;
        this.factory = factory;
        this.aliasManager = aliasManager;
        tableAlias = aliasManager.getAlias(classMapping.getRepositoryName());
        if (tableAlias == null) {
            tableAlias = aliasManager.put(classMapping.getRepositoryName());
        }
        selectBuilder = new SqlSelectBasicBuilder(jdbc.getDialect(), classMapping, tableAlias);
    }

    /**
     * @param tableName    tableName
     * @param jdbc         jdbc
     * @param tableAlias   tableAlias
     * @param factory      MappingFactory
     * @param aliasManager aliasManager
     */
    public AbstractSqlQueryEntityProperties(Jdbc jdbc, String tableName, String tableAlias, MappingFactory factory,
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

    @SuppressWarnings("unchecked")
    public E property(String propertyName) {
        selectBuilder.addSelectColumn(ClassMappingUtils.getColumnName(propertyName, classMapping));
        return (E) this;
    }

    @SuppressWarnings("unchecked")
    public E property(String... propertyNames) {
        selectBuilder.addSelectColumns(ClassMappingUtils.getColumnNames(classMapping, propertyNames));
        return (E) this;
    }

    @SuppressWarnings("unchecked")
    public E property(Collection<String> propertyNames) {
        selectBuilder.addSelectColumns(ClassMappingUtils.getColumnNames(classMapping, propertyNames));
        return (E) this;
    }

    public <T, R> E property(@SuppressWarnings("unchecked") SerializableFunction<T, R>... propertyNames) {
        return property(
                Arrays.stream(propertyNames).map(LambdaUtils::getLambdaPropertyName).collect(Collectors.toList()));
    }

    public <T, R> E property(SerializableFunction<T, R> propertyName) {
        return property(LambdaUtils.getLambdaPropertyName(propertyName));
    }

    @SuppressWarnings("unchecked")
    public <T, R> E propertyAlias(SerializableFunction<T, R> propertyName, String alias) {
        selectBuilder.addSelectColumn(
                ClassMappingUtils.getColumnName(LambdaUtils.getLambdaPropertyName(propertyName), classMapping), alias);
        return (E) this;
    }

    @SuppressWarnings("unchecked")
    public E propertyAlias(String columnName, String alias) {
        selectBuilder.addSelectColumn(ClassMappingUtils.getColumnName(columnName, classMapping), alias);
        return (E) this;
    }

    @SuppressWarnings("unchecked")
    public E propertyAlias(Map<String, String> columnNameMap) {
        columnNameMap.forEach((k, v) -> {
            propertyAlias(k, v);
        });
        return (E) this;
    }

    @SuppressWarnings("unchecked")
    public E id(String propertyName) {
        idName = propertyName;
        return (E) this;
    }

    public <T, R> E id(SerializableFunction<T, R> propertyName) {
        return id(LambdaUtils.getLambdaPropertyName(propertyName));
    }

    protected String getIdName() {
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
}
