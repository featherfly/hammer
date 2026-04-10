
package cn.featherfly.hammer.sqldb.jdbc;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.exception.NotImplementedException;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.tuple.Tuple;
import cn.featherfly.common.tuple.Tuples;

/**
 * The Class TupleNestedBeanPropertyRowMapper.
 *
 * @author zhongj
 * @param <T> the result tuple type
 * @since 0.7.0
 */
public class TupleNestedBeanPropertyRowMapper<T extends Tuple> extends AbstractRowMapper<T> {

    /** Logger available to subclasses. */
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    private List<RowMapper<?>> rowMappers;

    private List<Class<?>> mappedClasses;

    private final BiFunction<Class<?>, String, RowMapper<?>> getRowMapper;

    /**
     * Instantiates a new tuple nested bean property row mapper.
     *
     * @param mappedClasses the mapped classes
     * @param getRowMapper the get row mapper
     */
    public TupleNestedBeanPropertyRowMapper(List<Class<?>> mappedClasses,
        BiFunction<Class<?>, String, RowMapper<?>> getRowMapper) {
        this(mappedClasses, null, getRowMapper);
    }

    /**
     * Instantiates a new tuple nested bean property row mapper.
     *
     * @param mappedClasses the mapped classes
     * @param prefixes the prefixes
     * @param getRowMapper the get row mapper
     */
    public TupleNestedBeanPropertyRowMapper(List<Class<?>> mappedClasses, Tuple prefixes,
        BiFunction<Class<?>, String, RowMapper<?>> getRowMapper) {
        rowMappers = new ArrayList<>(mappedClasses.size());
        this.getRowMapper = getRowMapper;
        if (prefixes != null) {
            Lang.each(mappedClasses, (mappedClass, index) -> {
                //                SQLType sqlType = manager.getSqlType(mappedClass);
                //                RowMapper<?> rowMapper = null;
                //                if (sqlType == null) {
                //                    rowMapper = new NestedBeanPropertyRowMapper<>(mappedClass, (String) prefixes.get(index), manager,
                //                            checkFullyPopulated);
                //                } else {
                //                    rowMapper = new SingleColumnRowMapper<>(mappedClass, manager);
                //                    IMPLSOON 值映射的混合映射未实现
                //                }
                // IMPLSOON 后续来实现对象映射和值映射的混合模式，以及Map和对象的混合映射
                rowMappers.add(getRowMapper.apply(mappedClass, (String) prefixes.get(index)));
            });
        } else {
            this.mappedClasses = mappedClasses;
        }
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public T mapRow(cn.featherfly.common.repository.mapper.ResultSet res, int rowNum) {
        List<Object> results = new ArrayList<>();
        if (!rowMappers.isEmpty()) {
            // ENHANCE 后续再进行优化，不需要多次映射
            // Map<String, Class> prefixMap 使用prefix映射类型，再mapRow方法中，进行一次循环，多个对象都映射
            for (RowMapper<?> rowMapper : rowMappers) {
                results.add(rowMapper.mapRow(res, rowNum));
            }
            return (T) Tuples.ofArray(results.toArray());
        }

        ResultSet rs = getResultSet(res);
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            Set<String> prefixes = new LinkedHashSet<>();
            for (int index = 1; index <= columnCount; index++) {
                String fieldName = JdbcUtils.lookupColumnName(rsmd, index, true);
                String[] names = fieldName.split("\\.");
                if (names.length > 1) {
                    prefixes.add(names[0]);
                }
            }

            if (prefixes.isEmpty()) {
                throw new JdbcException("prefixes is empty");
            }

            // ENHANCE 后续让优化每一个对象对应的mapper获取对应的字段
            // 因为不同prefix已经定义好了映射的对象
            // new NestedBeanPropertyRowMapper(.... , new int[]{field1Index, fieldXIndex});
            // 可以定义一个元数据对象，包含name, alias, index 等信息，在MAPPER中直接循环此元数据数组就行了
            // 不需要再从ResultSetMetaData中去读元数据，因为这里已经读取并分配好了
            Lang.each(prefixes, (prefix, index) -> {
                rowMappers.add(getRowMapper.apply(mappedClasses.get(index), prefix + "."));
            });

            // rowMappers 初始化完成，重新进行mapRow
            return mapRow(res, rowNum);
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T mapRow(ResultSet res, int rowNum) {
        throw new NotImplementedException();
    }

}
