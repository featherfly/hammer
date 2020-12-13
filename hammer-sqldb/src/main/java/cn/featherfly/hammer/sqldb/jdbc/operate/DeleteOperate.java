/*
 *
 */
package cn.featherfly.hammer.sqldb.jdbc.operate;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
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
     * 使用给定数据源以及给定对象生成删除操作.
     *
     * @param jdbc             the jdbc
     * @param classMapping     the class mapping
     * @param databaseMetadata the database metadata
     */
    public DeleteOperate(Jdbc jdbc, ClassMapping<T> classMapping, DatabaseMetadata databaseMetadata) {
        super(jdbc, classMapping, databaseMetadata);
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
        return jdbc.execute((con, manager) -> {
            PreparedStatement prep = null;
            prep = con.prepareStatement(sql);
            setParameter(prep, id, manager);
            logger.debug("execute sql: {}", sql);
            int result = prep.executeUpdate();
            prep.close();
            return result;
        });
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
    public int deleteBatch(List<Serializable> ids) {
        if (Lang.isEmpty(ids)) {
            return Chars.ZERO;
        }
        return jdbc.execute((con, manager) -> {
            Tuple2<String, Map<Integer, String>> tuple = ClassMappingUtils.getDeleteSqlAndParamPositions(ids.size(),
                    classMapping, jdbc.getDialect());
            try (PreparedStatement prep = con.prepareStatement(tuple.get0())) {
                int index = 1;
                for (Serializable id : ids) {
                    manager.set(prep, index, id, pkProperties.get(index - 1));
                    //                    JdbcUtils.setParameter(prep, index, id);
                    index++;
                }
                logger.debug("execute sql: {} \n params: {}", sql, ids);
                int result = prep.executeUpdate();
                return result;
            }
        });
    }

    /**
     * Execute batch.
     *
     * @param entities the entities
     * @return the int
     */
    public int executeBatch(final T[] entities) {
        return executeBatch(ArrayUtils.toList(entities));
    }

    /**
     * Execute batch.
     *
     * @param entities the entity
     * @return the int
     */
    public int executeBatch(final List<T> entities) {
        if (Lang.isEmpty(entities)) {
            return Chars.ZERO;
        }
        Tuple2<String, Map<Integer, String>> tuple = ClassMappingUtils.getDeleteSqlAndParamPositions(entities.size(),
                classMapping, jdbc.getDialect());
        //        return jdbc.update(tuple.get0(), getBatchParameters(entities, tuple.get1()));
        return jdbc.execute((con, manager) -> {
            try (PreparedStatement prep = con.prepareStatement(tuple.get0())) {
                Object[] params = setBatchParameters(entities, tuple.get1(), prep, manager);
                if (logger.isDebugEnabled()) {
                    logger.debug("execute sql: {} \n params: {}", sql, ArrayUtils.toString(params));
                }
                int result = prep.executeUpdate();
                return result;
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initSql() {
        Tuple2<String, Map<Integer, String>> tuple = ClassMappingUtils.getDeleteSqlAndParamPositions(classMapping,
                jdbc.getDialect());
        sql = tuple.get0();
        propertyPositions.putAll(tuple.get1());
        logger.debug("sql: {}", sql);

        // TODO 后续使用batchSql template优化，只需要替换动态参数部分
    }
}
