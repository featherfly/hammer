
package cn.featherfly.hammer.sqldb.jdbc.operate;

import java.sql.ResultSet;
import java.util.function.BiConsumer;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.bean.PropertyAccessor;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.db.mapping.SqlResultSet;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.db.metadata.DatabaseMetadata;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.debug.MappingDebugMessage;

/**
 * 数据库操作的抽象类.
 *
 * @author zhongj
 * @param <T> 对象类型
 * @since 0.1.0
 */
public abstract class AbstractQueryOperate<T> extends AbstractOperate<T> implements QueryOperate<T> {

    /** The entity property mappings order by sql select. */
    protected Tuple2<BiConsumer<T, Object>, JdbcPropertyMapping>[] fetchPropertyMappings;

    /**
     * 使用给定数据源以及给定对象生成其相应的操作.
     *
     * @param jdbc the jdbc
     * @param classMapping the class mapping
     * @param sqlTypeMappingManager the sql type mapping manager
     * @param databaseMetadata the database metadata
     * @param propertyAccessor the property accessor
     */
    @SuppressWarnings("unchecked")
    public AbstractQueryOperate(Jdbc jdbc, JdbcClassMapping<T> classMapping,
        SqlTypeMappingManager sqlTypeMappingManager, DatabaseMetadata databaseMetadata,
        PropertyAccessor<T> propertyAccessor) {
        super(jdbc, classMapping, sqlTypeMappingManager, databaseMetadata, propertyAccessor);

        Tuple2<String, JdbcPropertyMapping[]> tuple = ClassMappingUtils.getSelectColumnsSqlAndMappings(classMapping,
            null, jdbc.getDialect());
        fetchPropertyMappings = new Tuple2[tuple.get1().length];
        int i = 0;
        for (JdbcPropertyMapping mapping : tuple.get1()) {
            if (mapping.getPropertyIndexes().length > 1) {
                fetchPropertyMappings[i] = Tuples.of(
                    (entity, value) -> propertyAccessor.setPropertyValue(entity, mapping.getPropertyIndexes(), value),
                    mapping);
            } else {
                fetchPropertyMappings[i] = Tuples.of(propertyAccessor.getProperty(mapping.getPropertyIndex())::set,
                    mapping);
            }
            i++;
        }
    }

    /**
     * 每条记录映射为对象.
     *
     * @param rs 结果集
     * @param rowNumber 行数
     * @return 映射后的对象
     */
    protected T mapRow(cn.featherfly.common.repository.mapping.ResultSet rs, int rowNumber) {
        if (rs instanceof SqlResultSet) {
            SqlResultSet sqlrs = (SqlResultSet) rs;
            return mapRow(sqlrs.getResultSet(), rowNumber);
        }
        return null;
    }

    /**
     * 每条记录映射为对象.
     *
     * @param resultSet 结果集
     * @param rowNumber 行数
     * @return 映射后的对象
     */
    protected T mapRow(ResultSet resultSet, int rowNumber) {
        int index = 1;
        T mappedObject = propertyAccessor.instantiate();
        MappingDebugMessage mappingDebugMessage = new MappingDebugMessage(isDebug());
        for (Tuple2<BiConsumer<T, Object>, JdbcPropertyMapping> param : fetchPropertyMappings) {
            //
            if (logger.isDebugEnabled() && rowNumber == 0) {
                mappingDebugMessage
                    .debug(m -> m.addMapping(param.get1().getRepositoryFieldName(), param.get1().getPropertyFullName(),
                        param.get1().getPropertyFullName(), param.get1().getPropertyType().getName()));
            }
            //
            Object value = param.get1().getJavaTypeSqlTypeOperator().get(resultSet, index);
            param.get0().accept(mappedObject, value);
            index++;
        }

        if (rowNumber == 0 && logger.isDebugEnabled()) {
            StringBuilder debugMessage = new StringBuilder();
            debugMessage.append("\n---------- Mapping " + classMapping.getType().getName() + " Start ----------\n")
                .append(mappingDebugMessage.toString())
                .append("---------- Mapping " + classMapping.getType().getName() + " End ----------\n");
            logger.debug(debugMessage.toString());
        }
        return mappedObject;
    }

    // ********************************************************************
    //
    // ********************************************************************

}
