
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import cn.featherfly.common.bean.BeanUtils;
import cn.featherfly.common.constant.Chars;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * AbstractBatchExecuteOperate.
 *
 * @author zhongj
 * @version 0.5.25
 * @param <T> the generic type
 * @since 0.5.25
 */
public abstract class AbstractBatchExecuteOperate<T> extends AbstractExecuteOperate<T>
        implements BatchExecuteOperate<T> {

    /**
     * Instantiates a new abstract batch execute operate.
     *
     * @param jdbc                  the jdbc
     * @param classMapping          the class mapping
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param databaseMetadata      the database metadata
     */
    public AbstractBatchExecuteOperate(Jdbc jdbc, JdbcClassMapping<T> classMapping,
            SqlTypeMappingManager sqlTypeMappingManager, DatabaseMetadata databaseMetadata) {
        super(jdbc, classMapping, sqlTypeMappingManager, databaseMetadata);
    }

    /**
     * Instantiates a new abstract batch execute operate.
     *
     * @param jdbc                  the jdbc
     * @param classMapping          the class mapping
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param dataBase              the data base
     */
    public AbstractBatchExecuteOperate(Jdbc jdbc, JdbcClassMapping<T> classMapping,
            SqlTypeMappingManager sqlTypeMappingManager, String dataBase) {
        super(jdbc, classMapping, sqlTypeMappingManager, dataBase);
    }

    /**
     * Instantiates a new abstract batch execute operate.
     *
     * @param jdbc                  the jdbc
     * @param classMapping          the class mapping
     * @param sqlTypeMappingManager the sql type mapping manager
     */
    public AbstractBatchExecuteOperate(Jdbc jdbc, JdbcClassMapping<T> classMapping,
            SqlTypeMappingManager sqlTypeMappingManager) {
        super(jdbc, classMapping, sqlTypeMappingManager);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int executeBatch(final List<T> entities, int batchSize) {
        if (Lang.isEmpty(entities)) {
            return Chars.ZERO;
        }
        if (supportBatch()) {
            return doExecuteBatch(entities, batchSize);
        } else {
            int size = 0;
            for (T entity : entities) {
                size += execute(entity);
            }
            return size;
        }
    }

    /**
     * Support batch.
     *
     * @return true, if successful
     */
    abstract protected boolean supportBatch();

    /**
     * Execute batch.
     *
     * @param entities the entities
     * @return the int
     */
    abstract protected int doExecuteBatch(final List<T> entities);

    /**
     * Execute batch.
     *
     * @param entities  the entities
     * @param batchSize the batch size
     * @return the int
     */
    protected int doExecuteBatch(final List<T> entities, int batchSize) {
        if (entities.size() <= batchSize) {
            return doExecuteBatch(entities);
        } else {
            int size = 0;
            List<T> batchList = new ArrayList<>();
            for (int i = 0; i < entities.size(); i++) {
                if ((i + 1) % batchSize == 0) {
                    size += doExecuteBatch(batchList);
                    batchList.clear();
                }
                batchList.add(entities.get(i));
            }
            size += doExecuteBatch(batchList);
            return size;
        }
    }

    /**
     * Gets the batch parameters.
     *
     * @param entities          the entities
     * @param propertyPositions the property positions
     * @return the batch parameters
     */
    protected Object[] getBatchParameters(List<T> entities, Map<Integer, String> propertyPositions) {
        //        if (Lang.isEmpty(entities)) {
        //            return new Object[] {};
        //        }
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
