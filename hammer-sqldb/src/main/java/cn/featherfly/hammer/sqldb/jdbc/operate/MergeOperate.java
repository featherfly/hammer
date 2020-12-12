package cn.featherfly.hammer.sqldb.jdbc.operate;

import java.sql.PreparedStatement;
import java.util.Map;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.repository.mapping.ClassMapping;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * <p>
 * 合并操作
 * </p>
 *
 * @param <T> 对象类型
 * @author zhongj
 * @since 1.0
 * @version 1.0
 */
public class MergeOperate<T> extends AbstractOperate<T> {
    /**
     * 使用给定数据源以及给定对象生成更新操作.
     *
     * @param jdbc         jdbc
     * @param classMapping classMapping
     */
    public MergeOperate(Jdbc jdbc, ClassMapping<T> classMapping) {
        super(jdbc, classMapping);
    }

    /**
     * 使用给定数据源以及给定对象生成更新操作.
     *
     * @param jdbc         jdbc
     * @param classMapping classMapping
     * @param dataBase     具体库
     */
    public MergeOperate(Jdbc jdbc, ClassMapping<T> classMapping, String dataBase) {
        super(jdbc, classMapping, dataBase);
    }

    /**
     * 使用给定数据源以及给定对象生成更新操作.
     *
     * @param jdbc             the jdbc
     * @param classMapping     the class mapping
     * @param databaseMetadata the database metadata
     */
    public MergeOperate(Jdbc jdbc, ClassMapping<T> classMapping, DatabaseMetadata databaseMetadata) {
        super(jdbc, classMapping, databaseMetadata);
    }

    /**
     * <p>
     * 合并操作，将传入对象的非空字段更新进数据库（忽略null）.
     * </p>
     *
     * @param entity   对象
     * @param onlyNull only null
     * @return 操作影响的数据行数
     */
    public int execute(final T entity, boolean onlyNull) {
        Tuple2<String, Map<Integer, String>> tuple = ClassMappingUtils.getMergeSqlAndParamPositions(entity,
                classMapping, onlyNull, jdbc.getDialect());
        return jdbc.execute((con, manager) -> {
            try (PreparedStatement prep = con.prepareStatement(tuple.get0())) {
                Object[] params = setParameters(entity, tuple.get1(), prep, manager);
                if (logger.isDebugEnabled()) {
                    logger.debug("execute sql: {} \n params: {}", sql, ArrayUtils.toString(params));
                }
                int result = prep.executeUpdate();
                return result;
            }
        });
        //        return jdbc.update(tuple.get0(), getParameters(entity, tuple.get1()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initSql() {
        // 不需要实现
    }
}
