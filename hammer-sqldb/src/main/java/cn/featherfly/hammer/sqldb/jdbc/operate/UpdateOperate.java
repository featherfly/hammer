package cn.featherfly.hammer.sqldb.jdbc.operate;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.exception.UnsupportedException;
import cn.featherfly.common.tuple.Tuple2;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * 更新操作.
 *
 * @author zhongj
 * @param <T> 对象类型
 * @since 0.1.0
 */
public class UpdateOperate<T> extends AbstractBatchExecuteOperate<T> {

    /**
     * 使用给定数据源以及给定对象生成更新操作.
     *
     * @param jdbc the jdbc
     * @param classMapping the class mapping
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param databaseMetadata the database metadata
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
        Tuple2<String,
            JdbcPropertyMapping[]> tuple = ClassMappingUtils.getUpdateSqlAndMappings(classMapping, jdbc.getDialect());
        sql = tuple.get0();
        logger.debug("sql: {}", sql);

        setParamsPropertyAndMappings(tuple.get1());
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
    protected int doSqlExecuteBatch(List<T> entities) {
        throw new UnsupportedException();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected int[] doJdbcExecuteBatch(List<T> entities) {
        //        List<Object[]> argsList = new ArrayList<>(entities.size());
        //        for (T entity : entities) {
        //            argsList.add(getParameters(entity));
        //        }
        //        Object[][] argsList = new Object[entities.size()][];
        //        Lang.each(entities, (e, i) -> argsList[i] = getParameters(e));
        //        return jdbc.updateBatch(sql, argsList);

        return jdbc.updateBatch(sql, () -> new Iterator<Serializable[]>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return entities.size() > index;
            }

            @Override
            public Serializable[] next() {
                return getParameters(entities.get(index++));
            }
        });

        // YUFEI_TEST 性能没有明显变化，后续再测试
        // return jdbc.updateBatch(sql, (prep, setArgs) -> setBatchParameters(entities, paramsPropertyAndMappings, prep, setArgs));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getName() {
        return "updateById";
    }
}
