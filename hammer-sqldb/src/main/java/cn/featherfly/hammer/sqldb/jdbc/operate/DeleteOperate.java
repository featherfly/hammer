/*
 *
 */
package cn.featherfly.hammer.sqldb.jdbc.operate;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.bean.BeanUtils;
import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * <p>
 * 删除操作
 * </p>
 * .
 *
 * @author zhongj
 * @version 1.0
 * @param <T> 对象类型
 * @since 1.0
 */
public class DeleteOperate<T> extends AbstractBatchExecuteOperate<T> {

    /**
     * 使用给定数据源以及给定对象生成删除操作.
     *
     * @param jdbc                  jdbc
     * @param classMapping          classMapping
     * @param sqlTypeMappingManager the sql type mapping manager
     */
    public DeleteOperate(Jdbc jdbc, ClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager) {
        super(jdbc, classMapping, sqlTypeMappingManager);
    }

    /**
     * 使用给定数据源以及给定对象生成删除操作.
     *
     * @param jdbc                  jdbc
     * @param classMapping          classMapping
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param dataBase              具体库
     */
    public DeleteOperate(Jdbc jdbc, ClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager,
            String dataBase) {
        super(jdbc, classMapping, sqlTypeMappingManager, dataBase);
    }

    /**
     * 使用给定数据源以及给定对象生成删除操作.
     *
     * @param jdbc                  the jdbc
     * @param classMapping          the class mapping
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param databaseMetadata      the database metadata
     */
    public DeleteOperate(Jdbc jdbc, ClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager,
            DatabaseMetadata databaseMetadata) {
        super(jdbc, classMapping, sqlTypeMappingManager, databaseMetadata);
    }

    /**
     * <p>
     * 删除指定id
     * </p>
     * .
     *
     * @param id id
     * @return 操作影响的数据行数
     */
    public int delete(Serializable id) {
        return jdbc.update(sql, id);
    }

    /**
     * <p>
     * 删除指定ids数组
     * </p>
     * .
     *
     * @param ids id array
     * @return 操作影响的数据行数
     */
    public int deleteBatch(Serializable... ids) {
        return deleteBatch(ArrayUtils.toList(ids));
    }

    /**
     * <p>
     * 删除指定ids列表
     * </p>
     * .
     *
     * @param ids id list
     * @return 操作影响的数据行数
     */
    public <ID extends Serializable> int deleteBatch(List<ID> ids) {
        if (Lang.isEmpty(ids)) {
            return Chars.ZERO;
        }
        Tuple2<String, Map<Integer, String>> tuple = ClassMappingUtils.getDeleteSqlAndParamPositions(ids.size(),
                classMapping, jdbc.getDialect());

        return jdbc.update(tuple.get0(), ids.toArray());
    }

    /**
     * Execute batch.
     *
     * @param entities the entity
     * @return the int
     */
    @Override
    public int executeBatch(final List<T> entities) {
        if (Lang.isEmpty(entities)) {
            return Chars.ZERO;
        }
        Tuple2<String, Map<Integer, String>> tuple = ClassMappingUtils.getDeleteSqlAndParamPositions(entities.size(),
                classMapping, jdbc.getDialect());
        return jdbc.update(tuple.get0(), getBatchParameters(entities, tuple.get1()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initSql() {
        Tuple2<String, Map<Integer, String>> tuple = ClassMappingUtils.getDeleteSqlAndParamPositions(classMapping,
                jdbc.getDialect());
        sql = tuple.get0();
        propertyPositions.putAll(tuple.get1());
        logger.debug("sql: {}", sql);

        // TODO 后续使用batchSql template优化，只需要替换动态参数部分
    }

    protected Object[] getBatchParameters(List<T> entities, Map<Integer, String> propertyPositions) {
        if (Lang.isEmpty(entities)) {
            return new Object[] {};
        }
        Object[] params = new Object[propertyPositions.size()];
        int pkNum = propertyPositions.size() / entities.size();
        int i = 0;
        T entity = null;
        for (Entry<Integer, String> propertyPosition : propertyPositions.entrySet()) {
            if (i % pkNum == 0) {
                entity = entities.get(i / pkNum);
            }
            params[i] = BeanUtils.getProperty(entity, propertyPosition.getValue());
            i++;
        }
        return params;
    }

}
