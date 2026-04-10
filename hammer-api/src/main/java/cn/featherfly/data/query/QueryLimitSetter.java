
package cn.featherfly.data.query;

import cn.featherfly.common.structure.page.Limit;
import cn.featherfly.common.structure.page.Page;

/**
 * query limit setter.
 *
 * @author zhongj
 * @param <Q> the generic type
 */
public interface QueryLimitSetter<Q> {

    /**
     * limit.
     *
     * @param limit limit rows
     * @return QueryExecutor
     */
    default Q limit(int limit) {
        return limit(0, limit);
    }

    /**
     * limit.
     *
     * @param offset start index offset
     * @param limit limit rows
     * @return QueryExecutor
     */
    default Q limit(int offset, int limit) {
        return limit(new Limit(offset, limit));
    }

    /**
     * limit.
     *
     * @param page params for pagination
     * @return QueryExecutor
     */
    default Q limit(Page page) {
        return limit(new Limit(page));
    }

    /**
     * limit.
     *
     * @param limit the limit
     * @return QueryExecutor
     */
    Q limit(Limit limit);
}
