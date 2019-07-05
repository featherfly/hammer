
package cn.featherfly.juorm.rdb.jdbc.operate;

import java.sql.ResultSet;

import cn.featherfly.common.bean.BeanUtils;
import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.juorm.rdb.jdbc.Jdbc;
import cn.featherfly.juorm.rdb.jdbc.mapping.ClassMapping;
import cn.featherfly.juorm.rdb.jdbc.mapping.PropertyMapping;

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
                        new Object[] { propertyMapping.getColumnName(), propertyMapping.getPropertyName(),
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
            getSql.append(" where ").append(condition);
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

    private void initSelectSql() {
        StringBuilder selectSql = new StringBuilder();
        selectSql.append("select ");
        int columnNum = 0;
        for (PropertyMapping propertyMapping : classMapping.getPropertyMappings()) {
            selectSql.append(propertyMapping.getColumnName()).append(" as ").append(propertyMapping.getPropertyName())
                    .append(",");
            columnNum++;
        }
        if (columnNum > 0) {
            selectSql.deleteCharAt(selectSql.length() - 1);
        }
        selectSql.append(" from ").append(classMapping.getTableName());
        this.selectSql = selectSql.toString();
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
