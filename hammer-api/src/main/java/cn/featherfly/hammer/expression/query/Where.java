
package cn.featherfly.hammer.expression.query;

/**
 * WhereExpression .
 *
 * @author zhongj
 * @param <C> the generic type
 */
public interface Where<C> {
    /**
     * gets the filter expression. 获取筛选条件表达式.
     *
     * @return filter expression
     */
    default C filter() {
        return where();
    }

    /**
     * filter alias. More user-friendly for users familiar with sql.
     *
     * @return filter expression
     */
    C where();
}
