package cn.featherfly.hammer.sqldb.jdbc.operate;

import java.io.Serializable;
import java.util.List;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.bean.BeanDescriptor;
import cn.featherfly.common.bean.BeanUtils;
import cn.featherfly.common.bean.PropertyAccessor;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.reflect.Type;
import cn.featherfly.hammer.sqldb.jdbc.GeneratedKeyHolder;
import cn.featherfly.hammer.sqldb.jdbc.GeneratedKeysHolder;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * 插入操作.
 *
 * @author zhongj
 * @param <T> 对象类型
 * @since 0.1.0
 */
public class InsertOperate<T> extends AbstractBatchExecuteOperate<T> {

    //    /**
    //     * 使用给定数据源以及给定对象生成插入操作.
    //     *
    //     * @param jdbc                  jdbc
    //     * @param classMapping          classMapping
    //     * @param sqlTypeMappingManager the sql type mapping manager
    //     */
    //    public InsertOperate(Jdbc jdbc, JdbcClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager) {
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
    //    public InsertOperate(Jdbc jdbc, JdbcClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager,
    //            String dataBase) {
    //        super(jdbc, classMapping, sqlTypeMappingManager, dataBase);
    //    }

    /**
     * 使用给定数据源以及给定对象生成插入操作.
     *
     * @param jdbc the jdbc
     * @param classMapping the class mapping
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param databaseMetadata the database metadata
     * @param propertyAccessor the property accessor
     */
    public InsertOperate(Jdbc jdbc, JdbcClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager,
        DatabaseMetadata databaseMetadata, PropertyAccessor<T> propertyAccessor) {
        super(jdbc, classMapping, sqlTypeMappingManager, databaseMetadata, propertyAccessor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected int doSqlExecuteBatch(final List<T> entities) {
        List<JdbcPropertyMapping> pks = classMapping.getPrivaryKeyPropertyMappings();
        Tuple2<String, JdbcPropertyMapping[]> tuple = ClassMappingUtils.getInsertBatchSqlAndMappings(entities.size(),
            classMapping, jdbc.getDialect());
        String sql = tuple.get0();
        if (pks.size() == 1) {
            return jdbc.updateBatch(sql, entities.size(), createGeneratedKeysHolder(entities, pks),
                getBatchParameters(entities, tuple.get1()));
        } else {
            return jdbc.updateBatch(sql, entities.size(), getBatchParameters(entities, tuple.get1()));
        }
    }

    //    private int _executeBatch(final List<T> entities, int batchSize) {
    //        if (entities.size() <= batchSize) {
    //            return _executeBatch(entities);
    //        } else {
    //            int size = 0;
    //            List<T> batchList = new ArrayList<>();
    //            for (int i = 0; i < entities.size(); i++) {
    //                if ((i + 1) % batchSize == 0) {
    //                    size += _executeBatch(batchList);
    //                    batchList.clear();
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
                public void acceptKey(Serializable key) {
                    // YUFEI_TEST 需要更多测试各种情况是否正确
                    if (BeanUtils.getProperty(entity, pks.get(0).getPropertyName()) == null) {
                        BeanUtils.setProperty(entity, pks.get(0).getPropertyName(), key);
                    }
                }

                @Override
                public Type<Serializable> getType() {
                    return BeanDescriptor.getBeanDescriptor(classMapping.getType())
                        .getBeanProperty(pks.get(0).getPropertyName());
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
    protected int[] doJdbcExecuteBatch(List<T> entities) {
        List<JdbcPropertyMapping> pks = classMapping.getPrivaryKeyPropertyMappings();
        //        List<Object[]> argsList = new ArrayList<>(entities.size());
        //        for (T entity : entities) {
        //            argsList.add(getParameters(entity));
        //        }
        Object[][] argsList = new Object[entities.size()][];
        Lang.each(entities, (e, i) -> argsList[i] = getParameters(e));
        int[] results;
        if (pks.size() == 1) {
            results = jdbc.updateBatch(sql, createGeneratedKeysHolder(entities, pks), argsList);
        } else {
            results = jdbc.updateBatch(sql, argsList);
        }
        return results;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean supportBatch() {
        return jdbc.getDialect().supportInsertBatch();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initSql() {
        Tuple2<String,
            JdbcPropertyMapping[]> tuple = ClassMappingUtils.getInsertSqlAndMappings(classMapping, jdbc.getDialect());
        sql = tuple.get0();
        logger.debug("sql: {}", sql);

        setParamsPropertyAndMappings(tuple.get1());
    }

    private GeneratedKeysHolder<Serializable> createGeneratedKeysHolder(List<T> entities,
        List<JdbcPropertyMapping> pks) {
        return new GeneratedKeysHolder<Serializable>() {
            public void acceptKey(Serializable key, int row) {
                // YUFEI_TEST 需要更多测试各种情况是否正确
                if (BeanUtils.getProperty(entities.get(row), pks.get(0).getPropertyName()) == null) {
                    BeanUtils.setProperty(entities.get(row), pks.get(0).getPropertyName(), key);
                }
            }

            @Override
            public Type<Serializable> getType() {
                return BeanDescriptor.getBeanDescriptor(classMapping.getType())
                    .getBeanProperty(pks.get(0).getPropertyName());
            }

            @Override
            public void acceptKey(List<Serializable> keys) {
                for (int i = 0; i < keys.size(); i++) {
                    acceptKey(keys.get(i), i);
                }
            }
        };
    }

    //    /**
    //     * Gets the batch parameters.
    //     *
    //     * @param entities          the entities
    //     * @param propertyPositions the property positions
    //     * @return the batch parameters
    //     */
    //    protected Object[] getBatchParameters(List<T> entities, Map<Integer, String> propertyPositions) {
    //        //        if (Lang.isEmpty(entities)) {
    //        //            return new Object[] {};
    //        //        }
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
