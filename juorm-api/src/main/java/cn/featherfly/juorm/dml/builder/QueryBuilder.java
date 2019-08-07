
package cn.featherfly.juorm.dml.builder;

/**
 * <p>
 * query builder
 * </p>
 *
 * @author zhongj
 */
public interface QueryBuilder extends Builder {

    /**
     * <p>
     * 进入条件表达式
     * </p>
     *
     * @param target target
     * @return ExpressionBuilder
     */
    FindBuilder find(String target);

    /**
     * <p>
     * 进入条件表达式
     * </p>
     *
     * @param target target
     * @param alias  alias
     * @return ExpressionBuilder
     */
    FindBuilder find(String target, String alias);

    //    /**
    //     * <p>
    //     * 进入条件表达式
    //     * </p>
    //     * 
    //     * @return ConditionBuilder
    //     */
    //    ConditionBuilder where();
    //
    //    /**
    //     * 结束当前条件并进入排序器
    //     * 
    //     * @return SortBuilder
    //     */
    //    SortBuilder sort();
}
