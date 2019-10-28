
package cn.featherfly.juorm.rdb.jdbc.dsl.query;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.db.metadata.TableMetadata;
import cn.featherfly.common.lang.LambdaUtils;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.juorm.JuormException;
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

    protected Jdbc jdbc;

    protected String idName;

    protected SqlSelectBasicBuilder selectBuilder;

    protected ClassMapping<?> classMapping;

    protected MappingFactory factory;

    protected AliasManager aliasManager;

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
        String tableAlias = aliasManager.getAlias(classMapping.getRepositoryName());
        if (tableAlias == null) {
            tableAlias = aliasManager.put(classMapping.getRepositoryName());
        }
        if (classMapping.getPrivaryKeyPropertyMappings().size() == 1) {
            idName = classMapping.getPrivaryKeyPropertyMappings().get(0).getRepositoryFieldName();
        }
        selectBuilder = new SqlSelectBasicBuilder(jdbc.getDialect(), classMapping, tableAlias, factory);
    }

    /**
     * @param jdbc             jdbc
     * @param databaseMetadata databaseMetadata
     * @param tableName        tableName
     * @param tableAlias       tableAlias
     * @param factory          MappingFactory
     * @param aliasManager     aliasManager
     */
    public AbstractSqlQueryEntityProperties(Jdbc jdbc, DatabaseMetadata databaseMetadata, String tableName,
            String tableAlias, MappingFactory factory, AliasManager aliasManager) {
        super();
        this.jdbc = jdbc;
        this.factory = factory;
        this.aliasManager = aliasManager;
        if (tableAlias == null) {
            tableAlias = aliasManager.put(tableName);
        }
        TableMetadata tableMetadata = databaseMetadata.getTable(tableName);
        if (tableMetadata.getPrimaryColumns().size() == 1) {
            idName = tableMetadata.getPrimaryColumns().get(0).getName();
        }
        selectBuilder = new SqlSelectBasicBuilder(jdbc.getDialect(), tableName, tableAlias);
    }

    @SuppressWarnings("unchecked")
    public E property(String propertyName) {
        Tuple2<String, String> columnAndProperty = ClassMappingUtils.getColumnAndPropertyName(propertyName,
                classMapping);
        if (LangUtils.isEmpty(columnAndProperty.get1())) {
            selectBuilder.addSelectColumn(columnAndProperty.get0());
        } else {
            selectBuilder.addSelectColumn(columnAndProperty.get0(), columnAndProperty.get1());
        }
        return (E) this;
    }

    @SuppressWarnings("unchecked")
    public E property(String... propertyNames) {
        for (String propertyName : propertyNames) {
            property(propertyName);
        }
        return (E) this;
    }

    @SuppressWarnings("unchecked")
    public E property(Collection<String> propertyNames) {
        for (String propertyName : propertyNames) {
            property(propertyName);
        }
        return (E) this;
    }

    public <T, R> E property(@SuppressWarnings("unchecked") SerializableFunction<T, R>... propertyNames) {
        return property(
                Arrays.stream(propertyNames).map(LambdaUtils::getLambdaPropertyName).collect(Collectors.toList()));
    }

    public <T, R> E property(SerializableFunction<T, R> propertyName) {
        return property(LambdaUtils.getLambdaPropertyName(propertyName));
    }

    public <T, R> E propertyAlias(SerializableFunction<T, R> propertyName, String alias) {
        return propertyAlias(LambdaUtils.getLambdaPropertyName(propertyName), alias);
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
        idName = ClassMappingUtils.getColumnName(propertyName, classMapping);
        return (E) this;
    }

    public <T, R> E id(SerializableFunction<T, R> propertyName) {
        return id(LambdaUtils.getLambdaPropertyName(propertyName));
    }

    protected String getIdName() {
        if (LangUtils.isEmpty(idName)) {
            throw new JuormException("privary key column name is null");
        }
        return idName;
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
