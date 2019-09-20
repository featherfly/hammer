package cn.featherfly.juorm.rdb.jdbc.operate;

import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.juorm.mapping.ClassMapping;
import cn.featherfly.juorm.mapping.PropertyMapping;
import cn.featherfly.juorm.rdb.jdbc.Jdbc;

/**
 * <p>
 * 更新操作
 * </p>
 *
 * @param <T> 对象类型
 * @author zhongj
 * @since 1.0
 * @version 1.0
 */
public class UpdateOperate<T> extends AbstractExecuteOperate<T> {

    /**
     * 使用给定数据源以及给定对象生成更新操作.
     *
     * @param jdbc         jdbc
     * @param classMapping classMapping
     */
    public UpdateOperate(Jdbc jdbc, ClassMapping<T> classMapping) {
        super(jdbc, classMapping);
    }

    /**
     * 使用给定数据源以及给定对象生成更新操作.
     *
     * @param jdbc         jdbc
     * @param classMapping classMapping
     * @param dataBase     具体库
     */
    public UpdateOperate(Jdbc jdbc, ClassMapping<T> classMapping, String dataBase) {
        super(jdbc, classMapping, dataBase);
    }

    /**
     * @param jdbc
     * @param classMapping
     * @param databaseMetadata
     */
    public UpdateOperate(Jdbc jdbc, ClassMapping<T> classMapping, DatabaseMetadata databaseMetadata) {
        super(jdbc, classMapping, databaseMetadata);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initSql() {
        StringBuilder updateSql = new StringBuilder();
        updateSql.append("update ").append(classMapping.getRepositoryName()).append(" set ");
        int columnNum = 0;
        for (PropertyMapping pm : classMapping.getPropertyMappings()) {
            updateSql.append(pm.getRepositoryFiledName()).append(" = ? ,");
            columnNum++;
            propertyPositions.put(columnNum, pm.getPropertyName());
        }
        if (columnNum > 0) {
            updateSql.deleteCharAt(updateSql.length() - 1);
        }
        int pkNum = 0;
        updateSql.append("where ");
        for (PropertyMapping pm : classMapping.getPropertyMappings()) {
            if (pm.isPrimaryKey()) {
                if (pkNum > 0) {
                    updateSql.append("and ");
                }
                updateSql.append(pm.getRepositoryFiledName()).append(" = ? ");
                pkNum++;
                propertyPositions.put(columnNum + pkNum, pm.getPropertyName());
            }
        }
        sql = updateSql.toString();
        logger.debug("sql: {}", sql);
    }
}
