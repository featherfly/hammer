package cn.featherfly.hammer.sqldb.jdbc.operate;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.bean.BeanUtils;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.hammer.sqldb.jdbc.GeneratedKeyHolder;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * upsert.
 *
 * @author zhongj
 * @param <T> 对象类型
 * @since 0.6.1
 */
public class UpsertOperate<T> extends AbstractBatchExecuteOperate<T> {

    //    /**
    //     * 使用给定数据源以及给定对象生成插入操作.
    //     *
    //     * @param jdbc                  jdbc
    //     * @param classMapping          classMapping
    //     * @param sqlTypeMappingManager the sql type mapping manager
    //     */
    //    public UpsertOperate(Jdbc jdbc, JdbcClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager) {
    //        super(jdbc, classMapping, sqlTypeMappingManager);
    //    }
    //
    //    /**
    //     * 使用给定数据源以及给定对象生成插入操作.
    //     *
    //     * @param jdbc                  jdbc
    //     * @param classMapping          classMapping
    //     * @param sqlTypeMappingManager the sql type mapping manager
    //     * @param dataBase              具体库
    //     */
    //    public UpsertOperate(Jdbc jdbc, JdbcClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager,
    //            String dataBase) {
    //        super(jdbc, classMapping, sqlTypeMappingManager, dataBase);
    //    }

    /**
     * 使用给定数据源以及给定对象生成插入操作.
     *
     * @param jdbc                  the jdbc
     * @param classMapping          the class mapping
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param databaseMetadata      the database metadata
     */
    public UpsertOperate(Jdbc jdbc, JdbcClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager,
            DatabaseMetadata databaseMetadata) {
        super(jdbc, classMapping, sqlTypeMappingManager, databaseMetadata);
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public int executeBatch(final List<T> entities, int batchSize) {
    //        if (Lang.isEmpty(entities)) {
    //            return Chars.ZERO;
    //        }
    //        if (jdbc.getDialect().supportUpsertBatch()) {
    //            return _executeBatch(entities, batchSize);
    //        } else {
    //            int size = 0;
    //            for (T entity : entities) {
    //                size += execute(entity);
    //            }
    //            return size;
    //        }
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean supportBatch() {
        return jdbc.getDialect().supportUpsertBatch();
    }

    @Override
    protected int doExecuteBatch(final List<T> entities) {
        List<JdbcPropertyMapping> pks = classMapping.getPrivaryKeyPropertyMappings();
        Tuple2<String, Map<Integer, String>> tuple = ClassMappingUtils
                .getUpsertBatchSqlAndParamPositions(entities.size(), classMapping, jdbc.getDialect());
        String sql = tuple.get0();
        return jdbc.updateBatch(sql, entities.size(), new GeneratedKeyHolder<Serializable>() {
            @Override
            public void acceptKey(Serializable key, int row) {
                if (row < entities.size()) {
                    // YUFEI_TODO 需要更多测试各种情况是否正确
                    if (BeanUtils.getProperty(entities.get(row), pks.get(0).getPropertyName()) == null) {
                        BeanUtils.setProperty(entities.get(row), pks.get(0).getPropertyName(), key);
                    }
                }
            }

            @Override
            public Type<Serializable> getType() {
                return BeanDescriptor.getBeanDescriptor(classMapping.getType())
                        .getBeanProperty(pks.get(0).getPropertyName());
            }

            @Override
            public void acceptKey(List<Serializable> keys) {
                if (keys.size() == entities.size()) {
                    for (int i = 0; i < keys.size(); i++) {
                        acceptKey(keys.get(i), i);
                    }
                } else {
                    logger.warn("entities.size[{}] != genereteKeys.size[{}], can not set generate key to entity object",
                            entities.size(), keys.size());
                }
            }
        }, getBatchParameters(entities, tuple.get1()));
        // TODO 批量upsert时， 返回值不确定，所以无法设置自动生成的id值，后续再研究
    }

    //    private int _executeBatch(final List<T> entities, int batchSize) {
    //        if (entities.size() <= batchSize) {
    //            return _executeBatch(entities);
    //        } else {
    //            int size = 0;
    //            List<T> batchList = new ArrayList<>();
    //            for (int i = 0; i < entities.size(); i++) {
    //                if (i % batchSize == 0) {
    //                    batchList.clear();
    //                    size += _executeBatch(batchList);
    //                }
    //                batchList.add(entities.get(i));
    //            }
    //            size += _executeBatch(batchList);
    //            return size;
    //        }
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute(final T entity) {
        List<JdbcPropertyMapping> pks = classMapping.getPrivaryKeyPropertyMappings();
        if (pks.size() == 1) {
            return jdbc.update(sql, new GeneratedKeyHolder<Serializable>() {
                @Override
                public void acceptKey(Serializable key, int row) {
                    // YUFEI_TODO 需要更多测试各种情况是否正确
                    if (BeanUtils.getProperty(entity, pks.get(0).getPropertyName()) == null) {
                        BeanUtils.setProperty(entity, pks.get(0).getPropertyName(), key);
                    }
                }

                @Override
                public Type<Serializable> getType() {
                    return BeanDescriptor.getBeanDescriptor(classMapping.getType())
                            .getBeanProperty(pks.get(0).getPropertyName());
                }

                @Override
                public void acceptKey(List<Serializable> keys) {
                    acceptKey(keys.get(0), 0);
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
        Tuple2<String, Map<Integer, String>> tuple = ClassMappingUtils.getUpsertSqlAndParamPositions(classMapping,
                jdbc.getDialect());
        sql = tuple.get0();
        propertyPositions.putAll(tuple.get1());
        logger.debug("sql: {}", sql);
    }

    //    /**
    //     * Gets the batch parameters.
    //     *
    //     * @param entities          the entities
    //     * @param propertyPositions the property positions
    //     * @return the batch parameters
    //     */
    //    protected Object[] getBatchParameters(List<T> entities, Map<Integer, String> propertyPositions) {
    //        if (Lang.isEmpty(entities)) {
    //            return new Object[] {};
    //        }
    //        Object[] params = new Object[propertyPositions.size() * entities.size()];
    //        for (int i = 0; i < entities.size(); i++) {
    //            T entity = entities.get(i);
    //            int index = 0;
    //            for (Entry<Integer, String> propertyPosition : propertyPositions.entrySet()) {
    //                params[i * propertyPositions.size() + index] = BeanUtils.getProperty(entity,
    //                        propertyPosition.getValue());
    //                index++;
    //            }
    //        }
    //        return params;
    //    }
}
