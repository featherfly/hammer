package cn.featherfly.hammer.expression.query.sort;

import java.util.function.BiConsumer;

import cn.featherfly.common.operator.SortOperator;

/**
 * sort expression.
 *
 * @author zhongj
 * @param <S> the generic type
 */
public interface SortExpression2<S extends SortedExpression2<S>> extends SortExpressionBase2<S> {

    /**
     * order.
     *
     * @param order the order
     * @param sortExpressions the sort expressions
     * @return the LogicExpression
     */
    default S order(SortOperator order, BiConsumer<SetSortFieldExpression, SetSortFieldExpression> sortExpressions) {
        switch (order) {
            case DESC:
                return desc(sortExpressions);
            default:
                return asc(sortExpressions);
        }
    }

    /**
     * asc.
     *
     * @param sortExpressions the sort expressions
     * @return the LogicExpression
     */
    S asc(BiConsumer<SetSortFieldExpression, SetSortFieldExpression> sortExpressions);

    /**
     * desc.
     *
     * @param sortExpressions the sort expressions
     * @return the LogicExpression
     */
    S desc(BiConsumer<SetSortFieldExpression, SetSortFieldExpression> sortExpressions);

}