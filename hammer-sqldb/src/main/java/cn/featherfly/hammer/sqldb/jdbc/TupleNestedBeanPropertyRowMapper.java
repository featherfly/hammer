
package cn.featherfly.hammer.sqldb.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.speedment.common.tuple.Tuple;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.db.JdbcException;
import cn.featherfly.common.db.mapping.JdbcMappingException;
import cn.featherfly.common.db.mapping.SqlResultSet;
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
        implements cn.featherfly.common.repository.mapping.RowMapper<T> {

    /** Logger available to subclasses. */
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    private List<NestedBeanPropertyRowMapper<?>> rowMappers;

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
        Lang.each(mappedClasses, (mappedClass, index) -> {
            rowMappers.add(new NestedBeanPropertyRowMapper<>(mappedClass, (String) prefixes.get(index), manager,
                    checkFullyPopulated));
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T mapRow(cn.featherfly.common.repository.mapping.ResultSet res, int rowNum) {
        ResultSet rs = null;
        if (res instanceof SqlResultSet) {
            SqlResultSet sqlrs = (SqlResultSet) res;
            rs = sqlrs.getResultSet();
            AssertIllegalArgument.isNotNull(rs, "java.sql.ResultSet");
        } else {
            throw new JdbcMappingException("ResultSet is not type of SqlResultSet");
        }

        try {
            return mapRow(rs, rowNum);
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
    }

    /**
     * Extract the values for all columns in the current row.
     * <p>
     * Utilizes public setters and result set meta-data.
     *
     * @param rs        the rs
     * @param rowNumber the row number
     * @return the t
     * @throws SQLException the SQL exception
     * @see java.sql.ResultSetMetaData
     */
    @SuppressWarnings("unchecked")
    public T mapRow(ResultSet rs, int rowNumber) throws SQLException {
        List<Object> results = new ArrayList<>();
        for (NestedBeanPropertyRowMapper<?> rowMapper : rowMappers) {
            results.add(rowMapper.mapRow(rs, rowNumber));
        }
        return (T) Tuples.ofArray(results.toArray());
    }
}
