
package cn.featherfly.hammer.expression.query;

/**
 * query relate fetch field expression.
 *
 * @author zhongj
 * @param <Q> the generic type
 */
public interface QueryRelateFetchFieldExpression<Q> extends QueryRelateExpression<Q>, QueryFetchFieldExpression<Q, Q> {
    // YUFEI_TODO 后续再看是否需要把单值fetch单独处理
}
