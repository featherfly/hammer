
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
import java.util.List;
import java.util.function.BiConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.speedment.common.tuple.Tuple2;

import cn.featherfly.common.bean.Instantiator;
import cn.featherfly.common.db.dialect.Dialect;
import cn.featherfly.common.db.mapper.SqlResultSet;
import cn.featherfly.common.db.mapping.JavaTypeSqlTypeOperator;
import cn.featherfly.common.db.mapping.JdbcClassMapping;
import cn.featherfly.common.lang.CollectionUtils;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.hammer.sqldb.jdbc.debug.MappingDebugMessage;

/**
 * EntityRowMapper.
 *
 * @author zhongj
 * @param <T> the entity type
 */
public class ProperotySetRowMapper<T> implements RowMapper<T> {

    /** The logger. */
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /** The fetch property mappings. */
    protected final List<
        Tuple2<BiConsumer<T, Object>, JavaTypeSqlTypeOperator<Object>>> fetchProperties = new ArrayList<>(0);

    private final Instantiator<T> instantiator;

    /** The class mapping. */
    protected final JdbcClassMapping<T> classMapping;

    /**
     * Instantiates a new entity mapper.
     *
     * @param instantiator the instantiator
     * @param dialect the dialect
     * @param classMapping the class mapping
     * @param fetchPropertyMappings the fetch property mappings
     */
    public ProperotySetRowMapper(Instantiator<T> instantiator, Dialect dialect, JdbcClassMapping<T> classMapping,
        Tuple2<BiConsumer<T, Object>, JavaTypeSqlTypeOperator<Object>>[] fetchPropertys) {
        super();
        this.instantiator = instantiator;
        this.classMapping = classMapping;
        CollectionUtils.addAll(fetchProperties, fetchPropertys);
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
        T mappedObject = instantiator.instantiate();

        int index = 1;
        MappingDebugMessage mappingDebugMessage = logger.isDebugEnabled()
            ? mappingDebugMessage = new MappingDebugMessage(logger.isDebugEnabled())
            : null;
        for (Tuple2<BiConsumer<T, Object>, JavaTypeSqlTypeOperator<Object>> tuple : fetchProperties) {
            //            if (logger.isDebugEnabled() && rowNumber == 0) {
            //                mappingDebugMessage.debug(m -> m.addMapping(tuple.getRepositoryFieldName(), tuple.getPropertyFullName(),
            //                    tuple.getPropertyFullName(), tuple.getPropertyType().getName()));
            //            }
            Object value = tuple.get1().get(resultSet, index);
            tuple.get0().accept(mappedObject, value);
            index++;
        }

        if (logger.isDebugEnabled() && rowNumber == 0) {
            StringBuilder debugMessage = new StringBuilder();
            debugMessage.append("\n---------- Mapping " + classMapping.getType().getName() + " Start ----------\n")
                .append(mappingDebugMessage.toString())
                .append("---------- Mapping " + classMapping.getType().getName() + " End ----------\n");
            logger.debug(debugMessage.toString());
        }
        return mappedObject;
    }

}
