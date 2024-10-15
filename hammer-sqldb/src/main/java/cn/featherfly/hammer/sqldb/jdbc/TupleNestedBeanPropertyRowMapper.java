
package cn.featherfly.hammer.sqldb.jdbc;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.featherfly.common.tuple.Tuple;
import cn.featherfly.common.tuple.Tuples;

import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.JdbcUtils;
import cn.featherfly.common.db.mapper.SqlResultSet;
import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
import cn.featherfly.common.lang.AssertIllegalArgument;
import cn.featherfly.common.lang.Lang;

/**
 * The Class TupleNestedBeanPropertyRowMapper.
 *
 * @author zhongj
 * @param <T> the result tuple type
 * @since 0.7.0
 */
public class TupleNestedBeanPropertyRowMapper<T extends Tuple>
    implements cn.featherfly.common.repository.mapper.RowMapper<T> {

    /** Logger available to subclasses. */
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    private List<NestedBeanPropertyRowMapper<?>> rowMappers;

    private List<Class<?>> mappedClasses;

    private boolean checkFullyPopulated;

    private SqlTypeMappingManager manager;

    /**
     * Instantiates a new tuple nested bean property row mapper.
     *
     * @param mappedClasses the mapped classes
     * @param manager       the manager
     */
    public TupleNestedBeanPropertyRowMapper(List<Class<?>> mappedClasses, SqlTypeMappingManager manager) {
        this(mappedClasses, null, manager);
    }

    /**
     * Instantiates a new tuple nested bean property row mapper.
     *
     * @param mappedClasses the mapped classes
     * @param prefixes      the prefixes
     * @param manager       the manager
     */
    public TupleNestedBeanPropertyRowMapper(List<Class<?>> mappedClasses, Tuple prefixes,
        SqlTypeMappingManager manager) {
        this(mappedClasses, prefixes, manager, false);
    }

    /**
     * Instantiates a new tuple nested bean property row mapper.
     *
     * @param mappedClasses       the mapped classes
     * @param prefixes            the prefixes
     * @param manager             the manager
     * @param checkFullyPopulated the check fully populated
     */
    public TupleNestedBeanPropertyRowMapper(List<Class<?>> mappedClasses, Tuple prefixes, SqlTypeMappingManager manager,
        boolean checkFullyPopulated) {
        rowMappers = new ArrayList<>(mappedClasses.size());
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
                // IMPLSOON 后续来实现对象映射和值映射的混合模式
                rowMappers.add(new NestedBeanPropertyRowMapper<>(mappedClass, manager, (String) prefixes.get(index),
                    checkFullyPopulated));
            });
        } else {
            this.mappedClasses = mappedClasses;
            this.checkFullyPopulated = checkFullyPopulated;
            this.manager = manager;
        }
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public T mapRow(cn.featherfly.common.repository.mapper.ResultSet res, int rowNum) {
        List<Object> results = new ArrayList<>();
        if (rowMappers.size() > 0) {
            // ENHANCE 后续再进行优化，不需要多次映射
            // Map<String, Class> prefixMap 使用prefix映射类型，再mapRow方法中，进行一次循环，多个对象都映射
            for (NestedBeanPropertyRowMapper<?> rowMapper : rowMappers) {
                results.add(rowMapper.mapRow(res, rowNum));
            }
            return (T) Tuples.ofArray(results.toArray());
        } else {
            ResultSet rs = null;
            if (res instanceof SqlResultSet) {
                SqlResultSet sqlrs = (SqlResultSet) res;
                rs = sqlrs.getResultSet();
                AssertIllegalArgument.isNotNull(rs, "java.sql.ResultSet");
            } else {
                throw new JdbcException("ResultSet is not type of SqlResultSet");
            }

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
                    rowMappers.add(new NestedBeanPropertyRowMapper<>(mappedClasses.get(index), manager, prefix + ".",
                        checkFullyPopulated));
                });

                // rowMappers 初始化完成，重新进行mapRow
                return mapRow(res, rowNum);
            } catch (SQLException e) {
                throw new JdbcException(e);
            }
        }
    }
}
