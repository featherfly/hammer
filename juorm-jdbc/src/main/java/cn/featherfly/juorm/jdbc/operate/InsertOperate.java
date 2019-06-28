package cn.featherfly.juorm.jdbc.operate;

import cn.featherfly.juorm.jdbc.Jdbc;
import cn.featherfly.juorm.jdbc.mapping.ClassMapping;
import cn.featherfly.juorm.jdbc.mapping.PropertyMapping;

/**
 * <p>
 * 插入操作
 * </p>
 *
 * @param <T> 对象类型
 * @author zhongj
 * @since 1.0
 * @version 1.0
 */
public class InsertOperate<T> extends AbstractExecuteOperate<T> {

    /**
     * 使用给定数据源以及给定对象生成更新操作.
     *
     * @param jdbc         jdbc
     * @param classMapping classMapping
     */
    public InsertOperate(Jdbc jdbc, ClassMapping<T> classMapping) {
        super(jdbc, classMapping);
    }

    /**
     * 使用给定数据源以及给定对象生成更新操作.
     *
     * @param jdbc         jdbc
     * @param classMapping classMapping
     * @param dataBase     具体库
     */
    public InsertOperate(Jdbc jdbc, ClassMapping<T> classMapping, String dataBase) {
        super(jdbc, classMapping, dataBase);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initSql() {
        StringBuilder insertSql = new StringBuilder();
        insertSql.append("insert into ").append(classMapping.getTableName()).append(" ( ");
        int columnNum = 0;
        for (PropertyMapping pm : classMapping.getPropertyMappings()) {
            insertSql.append(pm.getColumnName()).append(",");
            columnNum++;
            propertyPositions.put(columnNum, pm.getPropertyName());
        }
        if (columnNum > 0) {
            insertSql.deleteCharAt(insertSql.length() - 1);
        }
        insertSql.append(" ) values( ");
        for (int i = 0; i < columnNum; i++) {
            insertSql.append("?").append(",");
        }
        if (columnNum > 0) {
            insertSql.deleteCharAt(insertSql.length() - 1);
        }
        insertSql.append(" )");
        sql = insertSql.toString();
        logger.debug("sql: {}", sql);
    }
}
