package cn.featherfly.juorm.jdbc.operate;

import cn.featherfly.juorm.jdbc.Jdbc;
import cn.featherfly.juorm.jdbc.mapping.ClassMapping;
import cn.featherfly.juorm.jdbc.mapping.PropertyMapping;

/**
 * <p>
 * 删除操作
 * </p>
 *
 * @param <T> 对象类型
 * @author zhongj
 * @since 1.0
 * @version 1.0
 */
public class DeleteOperate<T> extends AbstractExecuteOperate<T> {
    /**
     * 使用给定数据源以及给定对象生成删除操作.
     *
     * @param jdbc         jdbc
     * @param classMapping classMapping
     */
    public DeleteOperate(Jdbc jdbc, ClassMapping<T> classMapping) {
        super(jdbc, classMapping);
    }

    /**
     * 使用给定数据源以及给定对象生成删除操作.
     *
     * @param jdbc         jdbc
     * @param classMapping classMapping
     * @param dataBase     具体库
     */
    public DeleteOperate(Jdbc jdbc, ClassMapping<T> classMapping, String dataBase) {
        super(jdbc, classMapping, dataBase);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initSql() {

        StringBuilder deleteSql = new StringBuilder();
        deleteSql.append("delete from ").append(classMapping.getTableName()).append(" where ");
        int columnNum = 0;
        for (PropertyMapping pm : classMapping.getPropertyMappings()) {
            if (pm.isPrimaryKey()) {
                if (columnNum > 0) {
                    deleteSql.append("and ");
                }
                deleteSql.append(pm.getColumnName()).append(" = ? ");
                columnNum++;
                propertyPositions.put(columnNum, pm.getPropertyName());
            }
        }
        sql = deleteSql.toString();
        logger.debug("sql: {}", sql);

    }
}
