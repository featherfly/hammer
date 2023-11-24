
package cn.featherfly.hammer.expression.query;

/**
 * query relate expression.
 *
 * @author zhongj
 * @param <Q> the generic type
 */
public interface QueryRelateExpression<Q> {
    /**
     * 添加查询出来的所有属性.
     *
     * @return QueryRelateExpression
     */
    Q fetch();
}
