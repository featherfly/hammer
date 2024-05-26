
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-26 22:15:26
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.mapper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.bean.Instantiator;
import cn.featherfly.common.bean.PropertyAccessor;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapper.SqlResultSet;
import cn.featherfly.common.db.mapping.ClassMappingUtils;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.db.mapping.JdbcPropertyMapping;
import cn.featherfly.common.lang.CollectionUtils;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.hammer.sqldb.jdbc.debug.MappingDebugMessage;

/**
 * EntityRowMapper.
 *
 * @author zhongj
 * @param <T> the entity type
 */
public class EntityRowMapper<T> implements RowMapper<T> {

    /** The logger. */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final List<Tuple2<BiConsumer<T, Object>, JdbcPropertyMapping>> fetchProperties = new ArrayList<>(0);

    private final Instantiator<T> instantiator;

    private final JdbcClassMapping<T> classMapping;

    /**
     * Instantiates a new entity mapper.
     *
     * @param propertyAccessor the property accessor
     * @param dialect the dialect
     * @param classMapping the class mapping
     */
    @SuppressWarnings("unchecked")
    public EntityRowMapper(PropertyAccessor<T> propertyAccessor, Dialect dialect, JdbcClassMapping<T> classMapping) {
        super();
        instantiator = propertyAccessor;
        this.classMapping = classMapping;

        for (JdbcPropertyMapping mapping : ClassMappingUtils.getSelectColumnsSqlAndMappings(classMapping, null, dialect)
            .get1()) {
            if (mapping.getParent() != null) {
                fetchProperties.add(Tuples.of(
                    (obj, value) -> propertyAccessor.setPropertyValue(obj, mapping.getPropertyIndexes(), value),
                    mapping));
            } else {
                fetchProperties.add(Tuples.of((BiConsumer<T, Object>) mapping.getSetter(), mapping));
            }
        }
    }

    /**
     * Instantiates a new entity mapper.
     *
     * @param instantiator the instantiator
     * @param dialect the dialect
     * @param classMapping the class mapping
     * @param fetchPropertyMappings the fetch property mappings
     */
    public EntityRowMapper(Instantiator<T> instantiator, Dialect dialect, JdbcClassMapping<T> classMapping,
        Tuple2<BiConsumer<T, Object>, JdbcPropertyMapping>[] fetchPropertyMappings) {
        super();
        this.instantiator = instantiator;
        this.classMapping = classMapping;
        CollectionUtils.addAll(fetchProperties, fetchPropertyMappings);
    }

    /**
     * Instantiates a new entity mapper.
     *
     * @param propertyAccessor the property accessor
     * @param dialect the dialect
     * @param classMapping the class mapping
     * @param fetchPropertyMappings the fetch property mappings
     */
    public EntityRowMapper(PropertyAccessor<T> propertyAccessor, Dialect dialect, JdbcClassMapping<T> classMapping,
        Collection<Tuple2<int[], JdbcPropertyMapping>> fetchPropertyMappings) {
        super();
        instantiator = propertyAccessor;
        this.classMapping = classMapping;

        for (Tuple2<int[], JdbcPropertyMapping> tuple : fetchPropertyMappings) {
            if (tuple.get0().length == 1) {
                fetchProperties
                    .add(Tuples.of((obj, value) -> tuple.get1().getSetter().accept(obj, value), tuple.get1()));
            } else {
                fetchProperties.add(Tuples
                    .of((obj, value) -> propertyAccessor.setPropertyValue(obj, tuple.get0(), value), tuple.get1()));
            }
        }
    }

    /**
     * 每条记录映射为对象.
     *
     * @param rs 结果集
     * @param rowNumber 行数
     * @return 映射后的对象
     */
    @Override
    public T mapRow(cn.featherfly.common.repository.mapper.ResultSet rs, int rowNumber) {
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
    public T mapRow(ResultSet resultSet, int rowNumber) {
        return mapRow(resultSet, rowNumber, new AtomicInteger(1));
    }

    /**
     * 每条记录映射为对象.
     *
     * @param resultSet 结果集
     * @param rowNumber 行数
     * @return 映射后的对象
     */
    public T mapRow(ResultSet resultSet, int rowNumber, final AtomicInteger columnStart) {
        T mappedObject = instantiator.instantiate();

        int columnIndex = columnStart.get();
        MappingDebugMessage mappingDebugMessage = logger.isDebugEnabled()
            ? mappingDebugMessage = new MappingDebugMessage(logger.isDebugEnabled())
            : null;
        for (Tuple2<BiConsumer<T, Object>, JdbcPropertyMapping> tuple : fetchProperties) {
            if (logger.isDebugEnabled() && rowNumber == 0) {
                mappingDebugMessage
                    .debug(m -> m.addMapping(tuple.get1().getRepositoryFieldName(), tuple.get1().getPropertyFullName(),
                        tuple.get1().getPropertyFullName(), tuple.get1().getPropertyType().getName()));
            }
            //
            Object value = tuple.get1().getJavaTypeSqlTypeOperator().get(resultSet, columnIndex);
            tuple.get0().accept(mappedObject, value);
            columnIndex++;
        }
        columnStart.set(columnIndex);

        if (logger.isDebugEnabled() && rowNumber == 0) {
            StringBuilder debugMessage = new StringBuilder();
            debugMessage
                .append("\n---------- Mapping " + classMapping.getType().getName() + " Start at ResultSet column index["
                    + columnStart.get() + "] ----------\n")
                .append(mappingDebugMessage.toString()) //
                .append("---------- Mapping " + classMapping.getType().getName() + " End  at ResultSet column index ["
                    + (columnIndex - 1) + "]----------\n");
            logger.debug(debugMessage.toString());
        }
        return mappedObject;
    }

}
