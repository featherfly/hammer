package cn.featherfly.hammer.sqldb.jdbc.operate;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.bean.BeanUtils;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.GenericType;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.reflect.GenericClass;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.common.repository.mapping.PropertyMapping;
import cn.featherfly.hammer.sqldb.jdbc.GeneratedKeyHolder;
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
public class InsertOperate<T> extends AbstractBatchExecuteOperate<T> {

    /**
     * 使用给定数据源以及给定对象生成插入操作.
     *
     * @param jdbc                  jdbc
     * @param classMapping          classMapping
     * @param sqlTypeMappingManager the sql type mapping manager
     */
    public InsertOperate(Jdbc jdbc, ClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager) {
        super(jdbc, classMapping, sqlTypeMappingManager);
    }

    /**
     * 使用给定数据源以及给定对象生成插入操作.
     *
     * @param jdbc                  jdbc
     * @param classMapping          classMapping
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param dataBase              具体库
     */
    public InsertOperate(Jdbc jdbc, ClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager,
            String dataBase) {
        super(jdbc, classMapping, sqlTypeMappingManager, dataBase);
    }

    /**
     * 使用给定数据源以及给定对象生成插入操作.
     *
     * @param jdbc                  the jdbc
     * @param classMapping          the class mapping
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param databaseMetadata      the database metadata
     */
    public InsertOperate(Jdbc jdbc, ClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager,
            DatabaseMetadata databaseMetadata) {
        super(jdbc, classMapping, sqlTypeMappingManager, databaseMetadata);
    }

    /**
     * insert batch.
     *
     * @param entities the entities
     * @return insert success amount
     */
    @Override
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
            Tuple2<String, Map<Integer, String>> tuple = ClassMappingUtils
                    .getInsertBatchSqlAndParamPositions(entities.size(), classMapping, jdbc.getDialect());
            String sql = tuple.get0();
            List<PropertyMapping> pks = classMapping.getPrivaryKeyPropertyMappings();
            if (pks.size() == 1) {
                return jdbc.update(sql, new GeneratedKeyHolder<Serializable>() {
                    @Override
                    public void acceptKey(Serializable key, int row) {
                        BeanUtils.setProperty(entities.get(row), pks.get(0).getPropertyName(), key);
                    }

                    @SuppressWarnings("unchecked")
                    @Override
                    public GenericType<Serializable> getType() {
                        return (GenericClass<Serializable>) new GenericClass<>(pks.get(0).getPropertyType());
                    }
                }, getBatchParameters(entities, tuple.get1()));
            } else {
                return jdbc.update(sql, getBatchParameters(entities, tuple.get1()));
            }
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
     * .
     *
     * @param entity 对象
     * @return 操作影响的数据行数
     */
    @Override
    public int execute(final T entity) {
        List<PropertyMapping> pks = classMapping.getPrivaryKeyPropertyMappings();
        if (pks.size() == 1) {
            return jdbc.update(sql, new GeneratedKeyHolder<Serializable>() {
                @Override
                public void acceptKey(Serializable key, int row) {
                    BeanUtils.setProperty(entity, pks.get(0).getPropertyName(), key);
                }

                @SuppressWarnings("unchecked")
                @Override
                public GenericType<Serializable> getType() {
                    return (GenericClass<Serializable>) new GenericClass<>(pks.get(0).getPropertyType());
                }
            }, getParameters(entity));
        } else {
            return jdbc.update(sql, getParameters(entity));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initSql() {
        Tuple2<String, Map<Integer, String>> tuple = ClassMappingUtils.getInsertSqlAndParamPositions(classMapping,
                jdbc.getDialect());
        sql = tuple.get0();
        propertyPositions.putAll(tuple.get1());
        logger.debug("sql: {}", sql);
    }

    /**
     * Gets the batch parameters.
     *
     * @param entities          the entities
     * @param propertyPositions the property positions
     * @return the batch parameters
     */
    protected Object[] getBatchParameters(List<T> entities, Map<Integer, String> propertyPositions) {
        if (Lang.isEmpty(entities)) {
            return new Object[] {};
        }
        Object[] params = new Object[propertyPositions.size() * entities.size()];
        for (int i = 0; i < entities.size(); i++) {
            T entity = entities.get(i);
            int index = 0;
            for (Entry<Integer, String> propertyPosition : propertyPositions.entrySet()) {
                params[i * propertyPositions.size() + index] = BeanUtils.getProperty(entity,
                        propertyPosition.getValue());
                index++;
            }
        }
        return params;
    }
}
