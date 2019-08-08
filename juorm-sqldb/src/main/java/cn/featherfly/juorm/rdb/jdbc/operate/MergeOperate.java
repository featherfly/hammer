package cn.featherfly.juorm.rdb.jdbc.operate;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import cn.featherfly.common.bean.BeanUtils;
import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.lang.LangUtils;
import cn.featherfly.juorm.rdb.jdbc.Jdbc;
import cn.featherfly.juorm.rdb.jdbc.mapping.ClassMapping;
import cn.featherfly.juorm.rdb.jdbc.mapping.PropertyMapping;

/**
 * <p>
 * 合并操作
 * </p>
 *
 * @param <T> 对象类型
 * @author zhongj
 * @since 1.0
 * @version 1.0
 */
public class MergeOperate<T> extends AbstractOperate<T> {
    /**
     * 使用给定数据源以及给定对象生成更新操作.
     *
     * @param jdbc         jdbc
     * @param classMapping classMapping
     */
    public MergeOperate(Jdbc jdbc, ClassMapping<T> classMapping) {
        super(jdbc, classMapping);
    }

    /**
     * 使用给定数据源以及给定对象生成更新操作.
     *
     * @param jdbc         jdbc
     * @param classMapping classMapping
     * @param dataBase     具体库
     */
    public MergeOperate(Jdbc jdbc, ClassMapping<T> classMapping, String dataBase) {
        super(jdbc, classMapping, dataBase);
    }

    /**
     * <p>
     * 合并操作，将传入对象的非空字段更新进数据库（忽略null）.
     * </p>
     *
     * @param entity 对象
     * @return 操作影响的数据行数
     */
    public int execute(final T entity, boolean onlyNull) {
        return jdbc.execute(conn -> {
            Map<Integer, String> propertyPositions = new HashMap<>();
            String sql = getDynamicSql(entity, propertyPositions, onlyNull);
            logger.debug("execute sql: {}", sql);
            PreparedStatement prep = conn.prepareStatement(sql);
            for (Entry<Integer, String> propertyPosition : propertyPositions.entrySet()) {
                JdbcUtils.setParameter(prep, propertyPosition.getKey(),
                        BeanUtils.getProperty(entity, propertyPosition.getValue()));
            }
            int result = prep.executeUpdate();
            prep.close();
            return result;
        });
    }

    private String getDynamicSql(T entity, Map<Integer, String> propertyPositions, boolean onlyNull) {
        StringBuilder updateSql = new StringBuilder();
        updateSql.append("update ").append(classMapping.getTableName()).append(" set ");
        int columnNum = 0;
        for (PropertyMapping pm : classMapping.getPropertyMappings()) {
            // 如果为空忽略 ignore when null
            if (onlyNull) {
                if (BeanUtils.getProperty(entity, pm.getPropertyName()) == null) {
                    continue;
                }
            } else {
                if (LangUtils.isEmpty(BeanUtils.getProperty(entity, pm.getPropertyName()))) {
                    continue;
                }
            }
            updateSql.append(pm.getColumnName()).append(" = ? ,");
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
                updateSql.append(pm.getColumnName()).append(" = ? ");
                pkNum++;
                propertyPositions.put(columnNum + pkNum, pm.getPropertyName());
            }
        }
        sql = updateSql.toString();
        return updateSql.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initSql() {
        // 不需要实现
    }
}
