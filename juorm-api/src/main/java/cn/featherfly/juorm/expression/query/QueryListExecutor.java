
package cn.featherfly.juorm.expression.query;

import java.util.List;
import java.util.Map;

import cn.featherfly.juorm.mapping.RowMapper;

/**
 * <p>
 * dsl for query list executor
 * </p>
 *
 * @author zhongj
 */
public interface QueryListExecutor {
    /**
     * query for list
     *
     * @param type
     *            wrapper type
     * @return list
     */
    List<Map<String, Object>> list();

    /**
     * query for list
     *
     * @param <E>
     *            wrapper type
     * @param type
     *            wrapper type
     * @return list
     */
    <E> List<E> list(Class<E> type);

    /**
     * query for list
     * 
     * @param <E>
     *            wrapper type
     * @param rowMapper
     *            rowMapper
     * @return list
     */
    <E> List<E> list(RowMapper<E> rowMapper);
}
