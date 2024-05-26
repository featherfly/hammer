
/*
 * All rights Reserved, Designed By zhongj
 * @Title: AbstractBatchExecuteOperate.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.operate
 * @Description: AbstractBatchExecuteOperate
 * @author: zhongj
 * @date: 2021-12-03 20:23:03
 * @Copyright: 2021 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.operate;

import java.util.List;

import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * AbstractBatchExecuteOperate.
 *
 * @author zhongj
 * @param <T> the generic type
 * @since 0.5.25
 */
public abstract class AbstractBatchExecuteOperate<T> extends AbstractExecuteOperate<T>
    implements BatchExecuteOperate<T> {

    /**
     * Instantiates a new abstract batch execute operate.
     *
     * @param jdbc the jdbc
     * @param classMapping the class mapping
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param databaseMetadata the database metadata
     */
    protected AbstractBatchExecuteOperate(Jdbc jdbc, JdbcClassMapping<T> classMapping,
        SqlTypeMappingManager sqlTypeMappingManager, DatabaseMetadata databaseMetadata) {
        super(jdbc, classMapping, sqlTypeMappingManager, databaseMetadata);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int[] executeBatch(final List<T> entities, int batchSize) {
        if (Lang.isEmpty(entities)) {
            return ArrayUtils.EMPTY_INT_ARRAY;
        }
        if (databaseMetadata.getFeatures().supportsBatchUpdates()) {
            return doJdbcExecuteBatch(entities, batchSize);
        } else if (supportBatch()) {
            return doSqlExecuteBatch(entities, batchSize);
        } else {
            int[] results = new int[entities.size()];
            for (int i = 0; i < entities.size(); i++) {
                results[i] = execute(entities.get(i));
            }
            return results;
        }
    }

    /**
     * Support batch.
     *
     * @return true, if successful
     */
    protected abstract boolean supportBatch();

    /**
     * Execute batch. single sql.
     *
     * @param entities the entities
     * @return the int
     */
    protected abstract int doSqlExecuteBatch(final List<T> entities);

    /**
     * Execute batch. single sql.
     *
     * @param entities the entities
     * @param batchSize the batch size
     * @return the int
     */
    protected int[] doSqlExecuteBatch(final List<T> entities, int batchSize) {
        if (entities.size() <= batchSize) {
            return new int[] { doSqlExecuteBatch(entities) };
        } else {
            int times = entities.size() / batchSize;
            if (entities.size() % batchSize != 0) {
                times++;
            }
            int[] results = new int[times];
            for (int i = 0; i < times; i++) {
                int start = i * batchSize;
                int end = start + batchSize;
                results[i] = doSqlExecuteBatch(entities.subList(start, end > entities.size() ? entities.size() : end));
            }
            return results;
        }
    }

    /**
     * execute. mulity sql.
     *
     * @param entities the entities
     * @param batchSize the batch size
     * @return the int
     */
    protected int[] doJdbcExecuteBatch(final List<T> entities, int batchSize) {
        if (entities.size() <= batchSize) {
            return doJdbcExecuteBatch(entities);
        } else {
            int times = entities.size() / batchSize;
            if (entities.size() % batchSize != 0) {
                times++;
            }
            int[] results = new int[entities.size()];
            for (int i = 0; i < times; i++) {
                int start = i * batchSize;
                int end = start + batchSize;
                int[] rs = doJdbcExecuteBatch(entities.subList(start, end > entities.size() ? entities.size() : end));
                for (int j = 0; j < rs.length; j++) {
                    results[i * batchSize + j] = rs[j];
                }
            }
            return results;
        }
    }

    /**
     * execute. mulity sql.
     *
     * @param entities the entities
     * @return the int
     */
    protected abstract int[] doJdbcExecuteBatch(final List<T> entities);

    /**
     * Gets the batch parameters.
     *
     * @param entities the entities
     * @param propertyPositions the property positions
     * @return the batch parameters
     */
    protected Object[] getBatchParameters(List<T> entities, JdbcPropertyMapping[] propertyPositions) {
        Object[] params = new Object[propertyPositions.length * entities.size()];
        for (int i = 0; i < entities.size(); i++) {
            T entity = entities.get(i);
            int columnNum = 0;
            for (JdbcPropertyMapping propertyMapping : propertyPositions) {
                //                params[i * propertyPositions.length + index] = propertyAccessor.getPropertyValue(entity,
                //                    propertyMapping.getPropertyIndexes());
                params[i * propertyPositions.length + columnNum] = propertyMapping.getGetter().apply(entity);
                columnNum++;
            }
        }
        return params;
    }
}
