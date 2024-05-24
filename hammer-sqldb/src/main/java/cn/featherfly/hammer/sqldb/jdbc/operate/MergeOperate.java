package cn.featherfly.hammer.sqldb.jdbc.operate;

import com.speedment.common.tuple.Tuple3;

import cn.featherfly.common.bean.PropertyAccessor;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * 合并操作.
 *
 * @author zhongj
 * @version 0.1.0
 * @param <T> 对象类型
 * @since 0.1.0
 */
public class MergeOperate<T> extends AbstractOperate<T> implements ExecuteOperate<T> {

    /**
     * 使用给定数据源以及给定对象生成更新操作.
     *
     * @param jdbc the jdbc
     * @param classMapping the class mapping
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param databaseMetadata the database metadata
     * @param propertyAccessor the property accessor
     */
    public MergeOperate(Jdbc jdbc, JdbcClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager,
        DatabaseMetadata databaseMetadata, PropertyAccessor<T> propertyAccessor) {
        super(jdbc, classMapping, sqlTypeMappingManager, databaseMetadata, propertyAccessor);
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
     * @param entity 对象
     * @param onlyNull only null
     * @return 操作影响的数据行数
     */
    public int execute(final T entity, boolean onlyNull) {
        Tuple3<String, JdbcPropertyMapping[], Integer> tuple = ClassMappingUtils.getMergeSqlAndMappings(entity,
            classMapping, onlyNull, jdbc.getDialect());
        // 如果需要更新的参数数量为0,表示不需要更新
        if (tuple.get2() == 0) {
            return 0;
        }

        return jdbc.update(tuple.get0(), getParameters(entity, tuple.get1()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initSql() {
        // 不需要处理
        // ENHANCE 后续来优化

        //        Tuple2<String,
        //            JdbcPropertyMapping[]> tuple = ClassMappingUtils.getUpdateSqlAndMappings(classMapping, jdbc.getDialect());
        //        sql = tuple.get0();
        //        logger.debug("sql: {}", sql);
        //
        //        int i = 0;
        //        paramsPropertyAndMappings = new Tuple2[tuple.get1().length];
        //        for (JdbcPropertyMapping mapping : tuple.get1()) {
        //            paramsPropertyAndMappings[i] = Tuples.of(propertyAccessor.getProperty(mapping.getPropertyIndexes()), mapping);
        //            i++;
        //        }
    }
}
