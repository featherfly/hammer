
package cn.featherfly.hammer.sqldb.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.speedment.common.tuple.Tuple;
import com.speedment.common.tuple.Tuples;

import cn.featherfly.common.db.mapping.SqlTypeMappingManager;
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
    @SuppressWarnings("unchecked")
    @Override
    public T mapRow(cn.featherfly.common.repository.mapping.ResultSet res, int rowNum) {
        List<Object> results = new ArrayList<>();
        for (NestedBeanPropertyRowMapper<?> rowMapper : rowMappers) {
            results.add(rowMapper.mapRow(res, rowNum));
        }
        return (T) Tuples.ofArray(results.toArray());
    }
}
