
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

import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * AbstractBatchExecuteOperate.
 *
 * @author zhongj
 * @param <T> the generic type
 */
public abstract class AbstractBatchExecuteOperate<T> extends AbstractExecuteOperate<T> {

    /**
     * Instantiates a new abstract batch execute operate.
     *
     * @param jdbc                  the jdbc
     * @param classMapping          the class mapping
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param databaseMetadata      the database metadata
     */
    public AbstractBatchExecuteOperate(Jdbc jdbc, ClassMapping<T> classMapping,
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
    public AbstractBatchExecuteOperate(Jdbc jdbc, ClassMapping<T> classMapping,
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
    public AbstractBatchExecuteOperate(Jdbc jdbc, ClassMapping<T> classMapping,
            SqlTypeMappingManager sqlTypeMappingManager) {
        super(jdbc, classMapping, sqlTypeMappingManager);
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
    public abstract int executeBatch(final List<T> entities);
}
