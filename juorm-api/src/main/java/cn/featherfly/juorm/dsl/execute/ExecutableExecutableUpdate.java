
package cn.featherfly.juorm.dsl.execute;

/**
 * <p>
 * Updator
 * </p>
 *
 * @author zhongj
 */
public interface ExecutableExecutableUpdate<U extends ExecutableExecutableUpdate<U>>
        extends Update<U>, Executor {

    /**
     * <p>
     * 进入条件表达式
     * </p>
     *
     * @return QueryCondition
     */
    ExecutableConditionGroupExpression where();
}
