
package cn.featherfly.hammer.sqldb.jdbc.operate;

import java.sql.ResultSet;

import cn.featherfly.common.bean.PropertyAccessor;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.mapper.EntityRowMapper;

/**
 * 数据库操作的抽象类.
 *
 * @author zhongj
 * @param <T> 对象类型
 * @since 0.1.0
 */
public abstract class AbstractQueryOperate<T> extends AbstractOperate<T> {

    //    /** The entity property mappings order by sql select. */
    //    protected List<JdbcPropertyMapping> fetchPropertyMappings = new ArrayList<>(0);
    //
    //    /** The instantiator. */
    //    protected final Instantiator<T> instantiator;

    /** The mapper. */
    protected final EntityRowMapper<T> mapper;

    /**
     * 使用给定数据源以及给定对象生成其相应的操作.
     *
     * @param jdbc the jdbc
     * @param classMapping the class mapping
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param databaseMetadata the database metadata
     * @param propertyAccessor the property accessor
     */
    protected AbstractQueryOperate(Jdbc jdbc, JdbcClassMapping<T> classMapping,
        SqlTypeMappingManager sqlTypeMappingManager, DatabaseMetadata databaseMetadata,
        PropertyAccessor<T> propertyAccessor) {
        super(jdbc, classMapping, sqlTypeMappingManager, databaseMetadata);
        //        Tuple2<String, JdbcPropertyMapping[]> tuple = ClassMappingUtils.getSelectColumnsSqlAndMappings(classMapping,
        //            null, jdbc.getDialect());
        mapper = new EntityRowMapper<>(propertyAccessor, jdbc.getDialect(), classMapping);
    }

    /**
     * 每条记录映射为对象.
     *
     * @param rs 结果集
     * @param rowNumber 行数
     * @return 映射后的对象
     */
    protected T mapRow(cn.featherfly.common.repository.mapper.ResultSet rs, int rowNumber) {
        return mapper.mapRow(rs, rowNumber);
    }

    /**
     * 每条记录映射为对象.
     *
     * @param rs 结果集
     * @param rowNumber 行数
     * @return 映射后的对象
     */
    protected T mapRow(ResultSet rs, int rowNumber) {
        return mapper.mapRow(rs, rowNumber);
    }

    // ********************************************************************
    //
    // ********************************************************************

}
