
package cn.featherfly.hammer.sqldb.jdbc.operate;

import java.sql.ResultSet;

import cn.featherfly.common.bean.BeanUtils;
import cn.featherfly.common.bean.Instantiator;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.db.mapping.SqlResultSet;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.debug.MappingDebugMessage;

/**
 * 数据库操作的抽象类.
 *
 * @author zhongj
 * @since 0.1.0
 * @param <T> 对象类型
 */
public abstract class AbstractQueryOperate<T> extends AbstractOperate<T> implements QueryOperate<T> {

    private final Instantiator<T> instantiator;

    /**
     * 使用给定数据源以及给定对象生成其相应的操作.
     *
     * @param jdbc the jdbc
     * @param classMapping the class mapping
     * @param instantiator the instantiator
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param databaseMetadata the database metadata
     */
    public AbstractQueryOperate(Jdbc jdbc, JdbcClassMapping<T> classMapping, Instantiator<T> instantiator,
        SqlTypeMappingManager sqlTypeMappingManager, DatabaseMetadata databaseMetadata) {
        super(jdbc, classMapping, sqlTypeMappingManager, databaseMetadata);
        this.instantiator = instantiator;
    }

    /**
     * 每条记录映射为对象.
     *
     * @param rs 结果集
     * @param rowNumber 行数
     * @return 映射后的对象
     */
    protected T mapRow(cn.featherfly.common.repository.mapping.ResultSet rs, int rowNumber) {
        if (rs instanceof SqlResultSet) {
            SqlResultSet sqlrs = (SqlResultSet) rs;
            return mapRow(sqlrs.getResultSet(), rowNumber);
        }
        return instantiator.instantiate();
    }

    /**
     * 每条记录映射为对象.
     *
     * @param resultSet 结果集
     * @param rowNumber 行数
     * @return 映射后的对象
     */
    protected T mapRow(ResultSet resultSet, int rowNumber) {
        int index = 1;
        T mappedObject = instantiator.instantiate();
        MappingDebugMessage mappingDebugMessage = new MappingDebugMessage(isDebug());
        for (JdbcPropertyMapping propertyMapping : classMapping.getPropertyMappings()) {
            if (propertyMapping.getPropertyMappings().isEmpty()) {
                // YUFEI_TEST 后续来测试
                Object value = propertyMapping.getJavaTypeSqlTypeOperator().get(resultSet, index);
                index = setProperty(rowNumber, mappedObject, index, propertyMapping, value, mappingDebugMessage);
                //                BeanProperty<?> bp = getBeanProperty(propertyMapping, rowNumber);
                //                Object value = sqlTypeMappingManager.get(resultSet, index, bp);
                //                index = setProperty(rowNumber, mappedObject, index, propertyMapping, value, mappingDebugMessage);
            } else {
                for (JdbcPropertyMapping subPropertyMapping : propertyMapping.getPropertyMappings()) {
                    //                    BeanProperty<?> bp = getBeanProperty(subPropertyMapping, rowNumber);
                    //                    Object value = sqlTypeMappingManager.get(resultSet, index, bp);
                    //                    //                    Object value = getColumnValue(rs, index, subPropertyMapping.getPropertyType());
                    //                    index = setProperty(rowNumber, mappedObject, index, subPropertyMapping, value, mappingDebugMessage);
                    // YUFEI_TEST 后续来测试
                    Object value = subPropertyMapping.getJavaTypeSqlTypeOperator().get(resultSet, index);
                    index = setProperty(rowNumber, mappedObject, index, subPropertyMapping, value, mappingDebugMessage);
                }
            }
        }
        if (rowNumber == 0 && logger.isDebugEnabled()) {
            StringBuilder debugMessage = new StringBuilder();
            debugMessage.append("\n---------- Mapping " + classMapping.getType().getName() + " Start ----------\n")
                .append(mappingDebugMessage.toString())
                .append("---------- Mapping " + classMapping.getType().getName() + " End ----------\n");
            logger.debug(debugMessage.toString());
        }
        return mappedObject;
    }

    //    private BeanProperty<?> getBeanProperty(PropertyMapping propertyMapping, int rowNumber) {
    //        String propertyName = ClassMappingUtils.getPropertyAliasName(propertyMapping);
    //        return beanDescriptor.getChildBeanProperty(propertyName);
    //    }

    private int setProperty(int rowNumber, T mappedObject, int index, JdbcPropertyMapping propertyMapping, Object value,
        MappingDebugMessage mappingDebugMessage) {
        String propertyName = ClassMappingUtils.getPropertyAliasName(propertyMapping);
        if (logger.isDebugEnabled() && rowNumber == 0) {
            mappingDebugMessage.debug(m -> m.addMapping(propertyMapping.getRepositoryFieldName(), propertyName,
                propertyName, propertyMapping.getPropertyType().getName()));
        }
        BeanUtils.setProperty(mappedObject, propertyName, value);
        index++;
        return index;
    }

    // ********************************************************************
    //
    // ********************************************************************

}
