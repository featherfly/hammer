
package cn.featherfly.hammer.expression.query;

import java.util.List;
import java.util.Map;

import cn.featherfly.common.repository.mapper.RowMapper;

/**
 * query list executor.
 *
 * @author zhongj
 */
public interface QueryListExecutor extends QueryTypeListExecutor {
    /**
     * query for list
     *
     * @return list
     */
    List<Map<String, Object>> list();

    /**
     * query for list
     *
     * @param <E> mapping type
     * @param rowMapper rowMapper
     * @return list
     */
    <E> List<E> list(RowMapper<E> rowMapper);
}
