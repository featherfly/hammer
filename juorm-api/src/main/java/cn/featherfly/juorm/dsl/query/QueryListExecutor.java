
package cn.featherfly.juorm.dsl.query;

import java.util.List;

import cn.featherfly.juorm.orm.RowMapper;

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
    <E> List<E> list(Class<E> type);

    /**
     * query for list
     *
     * @param rowMapper
     *            rowMapper
     * @return list
     */
    <E, D> List<E> list(RowMapper<E, D> rowMapper);
}
