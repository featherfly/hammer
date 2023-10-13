
package cn.featherfly.hammer.expression.api.entity;

/**
 * The Interface QueryRelate.
 *
 * @author zhongj
 * @param <QR> the generic type
 */
public interface QueryRelate<QR> {
    /**
     * 添加查询出来的所有属性.
     *
     * @return QueryWithExpression
     */
    QR fetch();
}
