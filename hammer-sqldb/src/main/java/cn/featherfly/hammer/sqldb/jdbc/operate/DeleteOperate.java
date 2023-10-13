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
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * 删除操作.
 *
 * @author zhongj
 * @version 0.4.8
 * @since 0.1.0
 * @param <T> 对象类型
 */
public class DeleteOperate<T> extends AbstractBatchExecuteOperate<T> implements BatchExecuteOperate<T> {

    //    /**
    //     * 使用给定数据源以及给定对象生成删除操作.
    //     *
    //     * @param jdbc                  jdbc
    //     * @param classMapping          classMapping
    //     * @param sqlTypeMappingManager the sql type mapping manager
    //     */
    //    public DeleteOperate(Jdbc jdbc, JdbcClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager) {
    //        super(jdbc, classMapping, sqlTypeMappingManager);
    //    }
    //
    //    /**
    //     * 使用给定数据源以及给定对象生成删除操作.
    //     *
    //     * @param jdbc                  jdbc
    //     * @param classMapping          classMapping
    //     * @param sqlTypeMappingManager the sql type mapping manager
    //     * @param dataBase              具体库
    //     */
    //    public DeleteOperate(Jdbc jdbc, JdbcClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager,
    //            String dataBase) {
    //        super(jdbc, classMapping, sqlTypeMappingManager, dataBase);
    //    }

    /**
     * 使用给定数据源以及给定对象生成删除操作.
     *
     * @param jdbc                  the jdbc
     * @param classMapping          the class mapping
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param databaseMetadata      the database metadata
     */
    public DeleteOperate(Jdbc jdbc, JdbcClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager,
            DatabaseMetadata databaseMetadata) {
        super(jdbc, classMapping, sqlTypeMappingManager, databaseMetadata);
    }

    /**
     * 删除指定id .
     *
     * @param id id
     * @return 操作影响的数据行数
     */
    public int delete(Serializable id) {
        return jdbc.update(sql, id);
    }

    /**
     * 删除指定ids数组 .
     *
     * @param ids id array
     * @return 操作影响的数据行数
     */
    public int[] deleteBatch(Serializable... ids) {
        return deleteBatch(ArrayUtils.toList(ids));
    }

    /**
     * 删除指定ids列表.
     *
     * @param <ID> the generic type
     * @param ids  id list
     * @return 操作影响的数据行数
     */
    public <ID extends Serializable> int[] deleteBatch(List<ID> ids) {
        if (Lang.isEmpty(ids)) {
            return ArrayUtils.EMPTY_INT_ARRAY;
        }
        Tuple2<String, Map<Integer, JdbcPropertyMapping>> tuple = ClassMappingUtils
                .getDeleteSqlAndParamPositions(ids.size(), classMapping, jdbc.getDialect());

        return new int[] { jdbc.update(tuple.get0(), ids.toArray()) };
    }

    //    @Override
    //    public int[] executeBatch(final List<T> entities, int batchSize) {
    //        if (Lang.isEmpty(entities)) {
    //            return ArrayUtils.EMPTY_INT_ARRAY;
    //        }
    //        if (entities.size() <= batchSize) {
    //            return new int[] { _executeBatch(entities, batchSize) };
    //        } else {
    //            int times = entities.size() / batchSize;
    //            if (entities.size() % batchSize == 0) {
    //                times++;
    //            }
    //            int results[] = new int[times];
    //            for (int i = 0; i < times; i++) {
    //                results[i] = _executeBatch(entities.subList(i * batchSize, batchSize), batchSize);
    //            }
    //            return results;
    //            //            return executeBatch(entities.subList(0, batchSize), batchSize)
    //            //                    + executeBatch(entities.subList(batchSize, entities.size()), batchSize);
    //        }
    //    }

    //    private int _executeBatch(final List<T> entities, int batchSize) {
    //        if (Lang.isEmpty(entities)) {
    //            return Chars.ZERO;
    //        }
    //        if (entities.size() <= batchSize) {
    //            int bs = entities.size();
    //            Tuple2<String, Map<Integer, JdbcPropertyMapping>> tuple = ClassMappingUtils
    //                    .getDeleteSqlAndParamPositions(bs, classMapping, jdbc.getDialect());
    //            return jdbc.updateBatch(tuple.get0(), bs, getBatchParameters(entities, tuple.get1()));
    //        } else {
    //            return _executeBatch(entities.subList(0, batchSize), batchSize)
    //                    + _executeBatch(entities.subList(batchSize, entities.size()), batchSize);
    //        }
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initSql() {
        Tuple2<String, Map<Integer, JdbcPropertyMapping>> tuple = ClassMappingUtils
                .getDeleteSqlAndParamPositions(classMapping, jdbc.getDialect());
        sql = tuple.get0();
        propertyPositions.putAll(tuple.get1());
        logger.debug("sql: {}", sql);

        // ENHANCE 后续使用batchSql template优化，只需要替换动态参数部分
    }

    /**
     * Gets the batch parameters.
     *
     * @param entities          the entities
     * @param propertyPositions the property positions
     * @return the batch parameters
     */
    @Override
    protected Object[] getBatchParameters(List<T> entities, Map<Integer, JdbcPropertyMapping> propertyPositions) {
        //        if (Lang.isEmpty(entities)) {
        //            return new Object[] {};
        //        }
        Object[] params = new Object[propertyPositions.size()];
        int pkNum = propertyPositions.size() / entities.size();
        int i = 0;
        T entity = null;
        for (Entry<Integer, JdbcPropertyMapping> propertyPosition : propertyPositions.entrySet()) {
            if (i % pkNum == 0) {
                entity = entities.get(i / pkNum);
            }
            params[i] = BeanUtils.getProperty(entity, propertyPosition.getValue().getPropertyFullName());
            i++;
        }
        return params;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean supportBatch() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected int doExecuteBatch(List<T> entities) {
        int bs = entities.size();
        Tuple2<String, Map<Integer, JdbcPropertyMapping>> tuple = ClassMappingUtils.getDeleteSqlAndParamPositions(bs,
                classMapping, jdbc.getDialect());
        return jdbc.updateBatch(tuple.get0(), bs, getBatchParameters(entities, tuple.get1()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected int[] doExecute(List<T> entities) {
        //        List<Object[]> argsList = new ArrayList<>(entities.size());
        //        for (T entity : entities) {
        //            argsList.add(getParameters(entity));
        //        }
        Object[][] argsList = new Object[entities.size()][];
        Lang.each(entities, (e, i) -> argsList[i] = getParameters(e));
        return jdbc.updateBatch(sql, argsList);
    }
}
