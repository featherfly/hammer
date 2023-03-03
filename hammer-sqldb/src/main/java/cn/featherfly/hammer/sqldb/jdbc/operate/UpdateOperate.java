package cn.featherfly.hammer.sqldb.jdbc.operate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.exception.UnsupportedException;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * 更新操作.
 *
 * @author zhongj
 * @param <T> 对象类型
 * @since 0.1.0
 */
public class UpdateOperate<T> extends AbstractBatchExecuteOperate<T> {

    //    /**
    //     * 使用给定数据源以及给定对象生成更新操作.
    //     *
    //     * @param jdbc                  jdbc
    //     * @param classMapping          classMapping
    //     * @param sqlTypeMappingManager the sql type mapping manager
    //     */
    //    public UpdateOperate(Jdbc jdbc, JdbcClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager) {
    //        super(jdbc, classMapping, sqlTypeMappingManager);
    //    }
    //
    //    /**
    //     * 使用给定数据源以及给定对象生成更新操作.
    //     *
    //     * @param jdbc                  jdbc
    //     * @param classMapping          classMapping
    //     * @param sqlTypeMappingManager the sql type mapping manager
    //     * @param dataBase              具体库
    //     */
    //    public UpdateOperate(Jdbc jdbc, JdbcClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager,
    //            String dataBase) {
    //        super(jdbc, classMapping, sqlTypeMappingManager, dataBase);
    //    }

    /**
     * 使用给定数据源以及给定对象生成更新操作.
     *
     * @param jdbc                  the jdbc
     * @param classMapping          the class mapping
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param databaseMetadata      the database metadata
     */
    public UpdateOperate(Jdbc jdbc, JdbcClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager,
            DatabaseMetadata databaseMetadata) {
        super(jdbc, classMapping, sqlTypeMappingManager, databaseMetadata);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initSql() {
        Tuple2<String, Map<Integer, JdbcPropertyMapping>> tuple = ClassMappingUtils
                .getUpdateSqlAndParamPositions(classMapping, jdbc.getDialect());
        sql = tuple.get0();
        propertyPositions.putAll(tuple.get1());
        logger.debug("sql: {}", sql);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean supportBatch() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected int doExecuteBatch(List<T> entities) {
        throw new UnsupportedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected int[] doExecute(List<T> entities) {
        List<Object[]> argsList = new ArrayList<>(entities.size());
        for (T entity : entities) {
            argsList.add(getParameters(entity));
        }
        return jdbc.updateBatch(sql, argsList);
    }
}
