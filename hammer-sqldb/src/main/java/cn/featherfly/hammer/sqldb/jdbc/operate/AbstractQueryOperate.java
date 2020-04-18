
package cn.featherfly.hammer.sqldb.jdbc.operate;

import java.sql.ResultSet;

import cn.featherfly.common.bean.BeanUtils;
import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.SqlResultSet;

/**
 * <p>
 * 数据库操作的抽象类
 * </p>
 *
 * @param <T> 对象类型
 * @author zhongj
 * @since 1.0
 * @version 1.0
 */
public abstract class AbstractQueryOperate<T> extends AbstractOperate<T> {

    /**
     * 使用给定数据源以及给定对象生成其相应的操作.
     *
     * @param jdbc         jdbc
     * @param classMapping classMapping
     */
    public AbstractQueryOperate(Jdbc jdbc, ClassMapping<T> classMapping) {
        super(jdbc, classMapping);
    }

    /**
     * 使用给定数据源以及给定对象生成其相应的操作.
     *
     * @param jdbc         jdbc
     * @param classMapping classMapping
     * @param dataBase     具体库
     */
    public AbstractQueryOperate(Jdbc jdbc, ClassMapping<T> classMapping, String dataBase) {
        super(jdbc, classMapping, dataBase);
    }

    /**
     * 使用给定数据源以及给定对象生成其相应的操作.
     *
     * @param jdbc             the jdbc
     * @param classMapping     the class mapping
     * @param databaseMetadata the database metadata
     */
    public AbstractQueryOperate(Jdbc jdbc, ClassMapping<T> classMapping, DatabaseMetadata databaseMetadata) {
        super(jdbc, classMapping, databaseMetadata);
    }

    /**
     * <p>
     * 每条记录映射为对象.
     * </p>
     *
     * @param rs        结果集
     * @param rowNumber 行数
     * @return 映射后的对象
     */
    protected T mapRow(cn.featherfly.hammer.mapping.ResultSet rs, int rowNumber) {
        @SuppressWarnings("unchecked")
        T mappedObject = (T) BeanUtils.instantiateClass(classMapping.getType());
        int index = 1;
        for (PropertyMapping propertyMapping : classMapping.getPropertyMappings()) {
            if (propertyMapping.getPropertyMappings().isEmpty()) {
                Object value = getColumnValue(rs, index, propertyMapping.getPropertyType());
                index = setProperty(rowNumber, mappedObject, index, propertyMapping, value);
            } else {
                for (PropertyMapping subPropertyMapping : propertyMapping.getPropertyMappings()) {
                    Object value = getColumnValue(rs, index, subPropertyMapping.getPropertyType());
                    index = setProperty(rowNumber, mappedObject, index, subPropertyMapping, value);
                }
            }
        }
        return mappedObject;
    }

    private int setProperty(int rowNumber, T mappedObject, int index, PropertyMapping propertyMapping, Object value) {
        String propertyName = ClassMappingUtils.getPropertyAliasName(propertyMapping);
        if (logger.isDebugEnabled() && rowNumber == 0) {
            logger.debug("Mapping column '{}' to property '{}' of type {}", new Object[] {
                    propertyMapping.getRepositoryFieldName(), propertyName, propertyMapping.getPropertyType() });
        }
        BeanUtils.setProperty(mappedObject, propertyName, value);
        index++;
        return index;
    }

    /**
     * <p>
     * 每条记录映射为对象.
     * </p>
     *
     * @param rs        结果集
     * @param rowNumber 行数
     * @return 映射后的对象
     */
    protected T mapRow(ResultSet rs, int rowNumber) {
        @SuppressWarnings("unchecked")
        T mappedObject = (T) BeanUtils.instantiateClass(classMapping.getType());
        int index = 1;
        for (PropertyMapping propertyMapping : classMapping.getPropertyMappings()) {
            Object value = getColumnValue(rs, index, propertyMapping.getPropertyType());
            if (logger.isDebugEnabled() && rowNumber == 0) {
                logger.debug("Mapping column '{}' to property '{}' of type {}",
                        new Object[] { propertyMapping.getRepositoryFieldName(), propertyMapping.getPropertyName(),
                                propertyMapping.getPropertyType() });
            }
            BeanUtils.setProperty(mappedObject, propertyMapping.getPropertyName(), value);
            index++;
        }
        return mappedObject;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initSql() {
        initSelectSql();
        StringBuilder getSql = new StringBuilder();
        getSql.append(getSelectSql());
        String condition = initCondition();
        if (LangUtils.isNotEmpty(condition)) {
            getSql.append(Chars.SPACE).append(jdbc.getDialect().getKeywords().where()).append(Chars.SPACE)
                    .append(condition);
        }
        sql = getSql.toString();
        logger.debug("sql: {}", sql);
    }

    protected abstract String initCondition();

    // ********************************************************************
    //
    // ********************************************************************

    private Object getColumnValue(ResultSet rs, int index, Class<?> propertyType) {
        return JdbcUtils.getResultSetValue(rs, index, propertyType);
    }

    private Object getColumnValue(cn.featherfly.hammer.mapping.ResultSet rs, int index, Class<?> propertyType) {
        return JdbcUtils.getResultSetValue(((SqlResultSet) rs).getResultSet(), index, propertyType);
    }

    private void initSelectSql() {
        this.selectSql = ClassMappingUtils.getSelectSql(classMapping, jdbc.getDialect());
    }

    // ********************************************************************
    //
    // ********************************************************************

    private String selectSql;

    /**
     * 返回selectSql
     *
     * @return selectSql
     */
    public String getSelectSql() {
        return selectSql;
    }
}
