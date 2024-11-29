/*
 *
 */
package cn.featherfly.hammer.sqldb.jdbc.operate;

import java.io.Serializable;
import java.util.List;

import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.tuple.Tuple2;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * 删除操作.
 *
 * @author zhongj
 * @param <T> 对象类型
 * @since 0.1.0
 */
public class DeleteOperate<T> extends AbstractBatchExecuteOperate<T> implements BatchExecuteOperate<T> {

    /**
     * 使用给定数据源以及给定对象生成删除操作.
     *
     * @param jdbc the jdbc
     * @param classMapping the class mapping
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param databaseMetadata the database metadata
     */
    public DeleteOperate(Jdbc jdbc, JdbcClassMapping<T> classMapping, SqlTypeMappingManager sqlTypeMappingManager,
        DatabaseMetadata databaseMetadata) {
        super(jdbc, classMapping, sqlTypeMappingManager, databaseMetadata);
    }

    /**
     * 删除指定id .
     *
     * @param id id
     * @return 操作影响的数据行数
     */
    public int delete(Serializable id) {
        return jdbc.update(sql, id);
    }

    /**
     * 删除指定ids数组 .
     *
     * @param ids id array
     * @return 操作影响的数据行数
     */
    public int[] deleteBatch(Serializable... ids) {
        return deleteBatch(ArrayUtils.toList(ids));
    }

    /**
     * 删除指定ids列表.
     *
     * @param <ID> the generic type
     * @param ids id list
     * @return 操作影响的数据行数
     */
    public <ID extends Serializable> int[] deleteBatch(List<ID> ids) {
        if (Lang.isEmpty(ids)) {
            return ArrayUtils.EMPTY_INT_ARRAY;
        }
        // ENHANCE 后续优化，只需要动态确定where 后面的内容就行了
        Tuple2<String, JdbcPropertyMapping[]> tuple = ClassMappingUtils.getDeleteSqlAndMappings(ids.size(),
            classMapping, jdbc.getDialect());

        return new int[] { jdbc.update(tuple.get0(), ids.toArray(new Serializable[ids.size()])) };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initSql() {
        Tuple2<String,
            JdbcPropertyMapping[]> tuple = ClassMappingUtils.getDeleteSqlAndMappings(classMapping, jdbc.getDialect());
        sql = tuple.get0();
        logger.debug("sql: {}", sql);
        // tuple.get1() 就是 pk JdbcPropertyMapping
        paramsPropertyAndMappings = pkProperties.toArray(new JdbcPropertyMapping[pkProperties.size()]);
        // ENHANCE 后续使用batchSql template优化，只需要替换动态参数部分
    }

    /**
     * Gets the batch parameters.
     *
     * @param entities the entities
     * @param propertyPositions the property positions
     * @return the batch parameters
     */
    @Override
    protected Serializable[] getBatchParameters(List<T> entities, JdbcPropertyMapping[] propertyPositions) {
        Serializable[] params = new Serializable[propertyPositions.length];
        int pkNum = propertyPositions.length / entities.size();
        int i = 0;
        T entity = null;
        for (JdbcPropertyMapping propertyMapping : propertyPositions) {
            if (i % pkNum == 0) {
                entity = entities.get(i / pkNum);
            }
            //            params[i] = propertyAccessor.getPropertyValue(entity, propertyMapping.getPropertyIndexes());
            params[i] = propertyMapping.getGetter().apply(entity);
            i++;
        }
        return params;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean supportBatch() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected int doSqlExecuteBatch(List<T> entities) {
        int bs = entities.size();
        // ENHANCE 后续优化，只需要动态确定where 后面的内容就行了
        Tuple2<String, JdbcPropertyMapping[]> tuple = ClassMappingUtils.getDeleteSqlAndMappings(bs, classMapping,
            jdbc.getDialect());
        return jdbc.updateBatch(tuple.get0(), bs, getBatchParameters(entities, tuple.get1()));
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
        Serializable[][] argsList = new Serializable[entities.size()][];
        Lang.each(entities, (e, i) -> argsList[i] = getParameters(e));
        return jdbc.updateBatch(sql, argsList);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getName() {
        return "deleteById";
    }
}
