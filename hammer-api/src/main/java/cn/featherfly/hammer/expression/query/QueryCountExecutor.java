
package cn.featherfly.hammer.expression.query;

/**
 * dsl for query count number executor.
 *
 * @author zhongj
 */
public interface QueryCountExecutor {
    /**
     * count number
     *
     * @return count number
     */
    // YUFEI_TODO 后续改为long
    Long count();
}
