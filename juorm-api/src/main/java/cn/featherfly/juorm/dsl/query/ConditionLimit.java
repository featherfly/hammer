
package cn.featherfly.juorm.dsl.query;

/**
 * <p>
 * limit condition
 * </p>
 *
 * @author zhongj
 */
public interface ConditionLimit {
    /**
     * limit
     *
     * @param limit
     *            limit rows
     * @return QueryExecutor
     */
    QueryExecutor limit(Integer limit);

    /**
     * limit
     *
     * @param offset
     *            start index offset
     * @param limit
     *            limit rows
     * @return QueryExecutor
     */
    QueryExecutor limit(Integer offset, Integer limit);
}
