package cn.featherfly.hammer.sqldb.jdbc.operate;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.bean.BeanUtils;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * <p>
 * 插入操作
 * </p>
 * .
 *
 * @author zhongj
 * @version 1.0
 * @param <T> 对象类型
 * @since 1.0
 */
public class InsertOperate<T> extends AbstractExecuteOperate<T> {

    /**
     * 使用给定数据源以及给定对象生成插入操作.
     *
     * @param jdbc         jdbc
     * @param classMapping classMapping
     */
    public InsertOperate(Jdbc jdbc, ClassMapping<T> classMapping) {
        super(jdbc, classMapping);
    }

    /**
     * 使用给定数据源以及给定对象生成插入操作.
     *
     * @param jdbc         jdbc
     * @param classMapping classMapping
     * @param dataBase     具体库
     */
    public InsertOperate(Jdbc jdbc, ClassMapping<T> classMapping, String dataBase) {
        super(jdbc, classMapping, dataBase);
    }

    /**
     * 使用给定数据源以及给定对象生成插入操作.
     *
     * @param jdbc             the jdbc
     * @param classMapping     the class mapping
     * @param databaseMetadata the database metadata
     */
    public InsertOperate(Jdbc jdbc, ClassMapping<T> classMapping, DatabaseMetadata databaseMetadata) {
        super(jdbc, classMapping, databaseMetadata);
    }

    /**
     * insert batch.
     *
     * @param entities the entities
     * @return insert success amount
     */
    public int executeBatch(final T[] entities) {
        return executeBatch(ArrayUtils.toList(entities));
    }

    /**
     * insert batch.
     *
     * @param entities the entities
     * @return insert success amount
     */
    public int executeBatch(final List<T> entities) {
        return executeBatch(entities, true);
    }

    /**
     * insert batch.
     *
     * @param entities          entity list
     * @param autoSetGenerateId 自动设置自动生成的id值
     * @return 操作影响的数据行数
     */
    public int executeBatch(final List<T> entities, boolean autoSetGenerateId) {
        if (jdbc.getDialect().isInsertBatch()) {
            return jdbc.execute((con, manager) -> {
                Tuple2<String, Map<Integer, String>> tuple = ClassMappingUtils
                        .getInsertBatchSqlAndParamPositions(entities.size(), classMapping, jdbc.getDialect());
                String sql = tuple.get0();
                List<PropertyMapping> pks = classMapping.getPrivaryKeyPropertyMappings();
                PreparedStatement prep = null;
                if (pks.size() == 1 && autoSetGenerateId) {
                    prep = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                } else {
                    prep = con.prepareStatement(sql);
                }
                int index = 0;
                for (T entity : entities) {
                    setParameter(prep, entity, index, manager);
                    index++;
                }

                logger.debug("execute sql: {}", sql);
                int result = prep.executeUpdate();

                if (pks.size() == 1 && autoSetGenerateId) {
                    PropertyMapping pm = pks.get(0);
                    ResultSet res = prep.getGeneratedKeys();
                    StringBuilder msg = null;
                    if (logger.isDebugEnabled()) {
                        msg = new StringBuilder("自动生成的键值 : ");
                    }
                    index = 0;
                    while (res.next()) {
                        Object value = manager.get(res, 1, pkProperties.get(0));
                        //                        Object value = JdbcUtils.getResultSetValue(res, 1, pm.getPropertyType());
                        if (logger.isDebugEnabled()) {
                            msg.append(" ").append(value).append(", ");
                        }
                        BeanUtils.setProperty(entities.get(index), pm.getPropertyName(), value);
                        index++;
                    }
                    if (logger.isDebugEnabled()) {
                        logger.debug(msg.toString());
                    }
                }
                prep.close();
                return result;
            });
        } else {
            int size = 0;
            for (T entity : entities) {
                size += execute(entity);
            }
            return size;
        }
    }

    /**
     * <p>
     * insert
     * </p>
     *
     * @param entity 对象
     * @return 操作影响的数据行数
     */
    @Override
    public int execute(final T entity) {
        return jdbc.execute((con, manager) -> {
            List<PropertyMapping> pks = classMapping.getPrivaryKeyPropertyMappings();
            PreparedStatement prep = null;
            if (pks.size() == 1) {
                prep = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            } else {
                prep = con.prepareStatement(sql);
            }
            setParameter(prep, entity, manager);
            logger.debug("execute sql: {}", sql);
            int result = prep.executeUpdate();

            if (pks.size() == 1) {
                PropertyMapping pm = pks.get(0);
                ResultSet res = prep.getGeneratedKeys();
                StringBuilder msg = null;
                if (logger.isDebugEnabled()) {
                    msg = new StringBuilder("自动生成的键值 : ");
                }
                if (res.next()) {
                    Object value = manager.get(res, 1, pkProperties.get(0));
                    //                    Object value = JdbcUtils.getResultSetValue(res, 1, pm.getPropertyType());
                    if (logger.isDebugEnabled()) {
                        msg.append(" ").append(value).append(", ");
                    }
                    BeanUtils.setProperty(entity, pm.getPropertyName(), value);
                }
                if (logger.isDebugEnabled()) {
                    logger.debug(msg.toString());
                }
            }
            prep.close();
            return result;
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initSql() {
        Tuple2<String, Map<Integer, String>> tuple = ClassMappingUtils.getInsertSqlAndParamPositions(classMapping,
                jdbc.getDialect());
        sql = tuple.get0();
        propertyPositions.putAll(tuple.get1());
        logger.debug("sql: {}", sql);
    }
}
