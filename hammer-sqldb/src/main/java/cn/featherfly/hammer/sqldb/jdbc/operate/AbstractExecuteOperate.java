
package cn.featherfly.hammer.sqldb.jdbc.operate;

import cn.featherfly.common.bean.PropertyAccessor;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * 数据库操作的抽象类.
 *
 * @author zhongj
 * @param <T> the generic type
 * @since 0.1.0
 */
public abstract class AbstractExecuteOperate<T> extends AbstractOperate<T> implements ExecuteOperate<T> {

    //    /**
    //     * 使用给定数据源以及给定对象生成其相应的操作.
    //     *
    //     * @param jdbc                  jdbc
    //     * @param classMapping          classMapping
    //     * @param sqlTypeMappingManager the sql type mapping manager
    //     */
    //    public AbstractExecuteOperate(Jdbc jdbc, JdbcClassMapping<T> classMapping,
    //            SqlTypeMappingManager sqlTypeMappingManager) {
    //        super(jdbc, classMapping, sqlTypeMappingManager);
    //    }
    //
    //    /**
    //     * 使用给定数据源以及给定对象生成其相应的操作.
    //     *
    //     * @param jdbc                  jdbc
    //     * @param classMapping          classMapping
    //     * @param sqlTypeMappingManager the sql type mapping manager
    //     * @param dataBase              具体库
    //     */
    //    public AbstractExecuteOperate(Jdbc jdbc, JdbcClassMapping<T> classMapping,
    //            SqlTypeMappingManager sqlTypeMappingManager, String dataBase) {
    //        super(jdbc, classMapping, sqlTypeMappingManager, dataBase);
    //    }

    /**
     * 使用给定数据源以及给定对象生成其相应的操作.
     *
     * @param jdbc the jdbc
     * @param classMapping the class mapping
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param databaseMetadata the database metadata
     * @param propertyAccessor the property accessor
     */
    protected AbstractExecuteOperate(Jdbc jdbc, JdbcClassMapping<T> classMapping,
        SqlTypeMappingManager sqlTypeMappingManager, DatabaseMetadata databaseMetadata,
        PropertyAccessor<T> propertyAccessor) {
        super(jdbc, classMapping, sqlTypeMappingManager, databaseMetadata, propertyAccessor);
    }

    /**
     * <p>
     * 执行操作. 操作的类型由具体子类构造的不同SQL来区分.
     * </p>
     *
     * @param entity the entity
     * @return 操作影响的数据行数
     */
    @Override
    public int execute(final T entity) {
        return jdbc.update(sql, getParameters(entity));
    }

    // ********************************************************************
    //	property
    // ********************************************************************

}
