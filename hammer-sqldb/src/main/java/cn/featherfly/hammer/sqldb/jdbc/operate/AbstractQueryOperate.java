
package cn.featherfly.hammer.sqldb.jdbc.operate;

import java.sql.ResultSet;

import cn.featherfly.common.bean.BeanProperty;
import cn.featherfly.common.bean.BeanUtils;
import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.SqlResultSet;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.MappingDebugMessage;

/**
 * 数据库操作的抽象类.
 *
 * @author zhongj
 * @version 0.1.0
 * @since 0.1.0
 * @param <T> 对象类型
 */
public abstract class AbstractQueryOperate<T> extends AbstractOperate<T> implements QueryOperate<T> {

    /**
     * 使用给定数据源以及给定对象生成其相应的操作.
     *
     * @param jdbc                  jdbc
     * @param classMapping          classMapping
     * @param sqlTypeMappingManager the sql type mapping manager
     */
    public AbstractQueryOperate(Jdbc jdbc, ClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager) {
        super(jdbc, classMapping, sqlTypeMappingManager);
    }

    /**
     * 使用给定数据源以及给定对象生成其相应的操作.
     *
     * @param jdbc                  jdbc
     * @param classMapping          classMapping
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param dataBase              具体库
     */
    public AbstractQueryOperate(Jdbc jdbc, ClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager,
            String dataBase) {
        super(jdbc, classMapping, sqlTypeMappingManager, dataBase);
    }

    /**
     * 使用给定数据源以及给定对象生成其相应的操作.
     *
     * @param jdbc                  the jdbc
     * @param classMapping          the class mapping
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param databaseMetadata      the database metadata
     */
    public AbstractQueryOperate(Jdbc jdbc, ClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager,
            DatabaseMetadata databaseMetadata) {
        super(jdbc, classMapping, sqlTypeMappingManager, databaseMetadata);
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
    protected T mapRow(cn.featherfly.common.repository.mapping.ResultSet rs, int rowNumber) {
        @SuppressWarnings("unchecked")
        T mappedObject = (T) BeanUtils.instantiateClass(classMapping.getType());
        int index = 1;
        ResultSet resultSet = null;
        if (rs instanceof SqlResultSet) {
            SqlResultSet sqlrs = (SqlResultSet) rs;
            resultSet = sqlrs.getResultSet();
        }
        MappingDebugMessage mappingDebugMessage = new MappingDebugMessage();
        for (PropertyMapping propertyMapping : classMapping.getPropertyMappings()) {
            if (propertyMapping.getPropertyMappings().isEmpty()) {
                BeanProperty<?> bp = getBeanProperty(propertyMapping, rowNumber);
                Object value = sqlTypeMappingManager.get(resultSet, index, bp);
                index = setProperty(rowNumber, mappedObject, index, propertyMapping, value, mappingDebugMessage);
            } else {
                for (PropertyMapping subPropertyMapping : propertyMapping.getPropertyMappings()) {
                    // TODO 还没有测试
                    BeanProperty<?> bp = getBeanProperty(subPropertyMapping, rowNumber);
                    Object value = sqlTypeMappingManager.get(resultSet, index, bp);
                    //                    Object value = getColumnValue(rs, index, subPropertyMapping.getPropertyType());
                    index = setProperty(rowNumber, mappedObject, index, subPropertyMapping, value, mappingDebugMessage);
                }
            }
        }
        if (rowNumber == 0 && logger.isDebugEnabled()) {
            StringBuilder debugMessage = new StringBuilder();
            debugMessage.append("\n---------- Map " + classMapping.getType().getName() + " Start ----------\n")
                    .append(mappingDebugMessage.toString())
                    .append("---------- Map " + classMapping.getType().getName() + " End ----------");
            logger.debug(debugMessage.toString());
        }
        return mappedObject;
    }

    private BeanProperty<?> getBeanProperty(PropertyMapping propertyMapping, int rowNumber) {
        String propertyName = ClassMappingUtils.getPropertyAliasName(propertyMapping);
        return beanDescriptor.getChildBeanProperty(propertyName);
    }

    private int setProperty(int rowNumber, T mappedObject, int index, PropertyMapping propertyMapping, Object value,
            MappingDebugMessage mappingDebugMessage) {
        String propertyName = ClassMappingUtils.getPropertyAliasName(propertyMapping);
        if (logger.isDebugEnabled() && rowNumber == 0) {
            mappingDebugMessage.addMapping(propertyMapping.getRepositoryFieldName(), propertyName,
                    propertyMapping.getPropertyType().getName());
        }
        BeanUtils.setProperty(mappedObject, propertyName, value);
        index++;
        return index;
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
        if (Lang.isNotEmpty(condition)) {
            getSql.append(Chars.SPACE).append(jdbc.getDialect().getKeywords().where()).append(Chars.SPACE)
                    .append(condition);
        }
        sql = getSql.toString();
        logger.debug("sql: {}", sql);
    }

    /**
     * Inits the condition.
     *
     * @return the string
     */
    protected abstract String initCondition();

    // ********************************************************************
    //
    // ********************************************************************

    //    private Object getColumnValue(ResultSet rs, int index, Class<?> propertyType) {
    //        return JdbcUtils.getResultSetValue(rs, index, propertyType);
    //    }

    //    private Object getColumnValue(cn.featherfly.common.repository.mapping.ResultSet rs, int index,
    //            Class<?> propertyType) {
    //        return JdbcUtils.getResultSetValue(((SqlResultSet) rs).getResultSet(), index, propertyType);
    //    }

    private void initSelectSql() {
        this.selectSql = ClassMappingUtils.getSelectSql(classMapping, jdbc.getDialect());
    }

    // ********************************************************************
    //
    // ********************************************************************

    private String selectSql;

    /**
     * 返回selectSql.
     *
     * @return selectSql
     */
    public String getSelectSql() {
        return selectSql;
    }
}
