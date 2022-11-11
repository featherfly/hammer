package cn.featherfly.hammer.sqldb.jdbc.operate;

import java.util.Map;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * 合并操作.
 *
 * @author zhongj
 * @version 0.1.0
 * @since 0.1.0
 * @param <T> 对象类型
 */
public class MergeOperate<T> extends AbstractOperate<T> implements ExecuteOperate<T> {

    /**
     * 使用给定数据源以及给定对象生成更新操作.
     *
     * @param jdbc                  jdbc
     * @param classMapping          classMapping
     * @param sqlTypeMappingManager the sql type mapping manager
     */
    public MergeOperate(Jdbc jdbc, ClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager) {
        super(jdbc, classMapping, sqlTypeMappingManager);
    }

    /**
     * 使用给定数据源以及给定对象生成更新操作.
     *
     * @param jdbc                  jdbc
     * @param classMapping          classMapping
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param dataBase              具体库
     */
    public MergeOperate(Jdbc jdbc, ClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager,
            String dataBase) {
        super(jdbc, classMapping, sqlTypeMappingManager, dataBase);
    }

    /**
     * 使用给定数据源以及给定对象生成更新操作.
     *
     * @param jdbc                  the jdbc
     * @param classMapping          the class mapping
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param databaseMetadata      the database metadata
     */
    public MergeOperate(Jdbc jdbc, ClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager,
            DatabaseMetadata databaseMetadata) {
        super(jdbc, classMapping, sqlTypeMappingManager, databaseMetadata);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute(T entity) {
        return execute(entity, false);
    }

    /**
     * 合并操作，将传入对象的非空字段更新进数据库（忽略null）.
     *
     * @param entity   对象
     * @param onlyNull only null
     * @return 操作影响的数据行数
     */
    public int execute(final T entity, boolean onlyNull) {
        Tuple3<String, Map<Integer, String>, Integer> tuple = ClassMappingUtils.getMergeSqlAndParamPositions(entity,
                classMapping, onlyNull, jdbc.getDialect());
        // 如果需要更新的参数数量为0,表示不需要更新
        if (tuple.get2() == 0) {
            return 0;
        }
        return jdbc.update(tuple.get0(), getParameters(entity, tuple.get1()));
        //        return jdbc.execute((con, manager) -> {
        //            try (PreparedStatement prep = con.prepareStatement(tuple.get0())) {
        //                Object[] params = setParameters(entity, tuple.get1(), prep, manager);
        //                if (logger.isDebugEnabled()) {
        //                    logger.debug("execute sql: {} \n params: {}", tuple.get0(), ArrayUtils.toString(params));
        //                }
        //                int result = prep.executeUpdate();
        //                return result;
        //            }
        //        });

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initSql() {
        // 不需要实现
    }
}
