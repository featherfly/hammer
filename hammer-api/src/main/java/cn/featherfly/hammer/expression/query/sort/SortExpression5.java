package cn.featherfly.hammer.expression.query.sort;

import cn.featherfly.common.function.FiConsumer;
import cn.featherfly.common.operator.SortOperator;

/**
 * sort expression5.
 *
 * @author zhongj
 * @param <S> the generic type
 */
public interface SortExpression5<S extends SortedExpression5<S>> extends SortExpressionBase5<S> {

    /**
     * order.
     *
     * @param order the order
     * @param sortExpressions the sort expressions
     * @return the LogicExpression
     */
    default S order(SortOperator order, FiConsumer<SetSortFieldExpression, SetSortFieldExpression,
        SetSortFieldExpression, SetSortFieldExpression, SetSortFieldExpression> sortExpressions) {
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
    S asc(FiConsumer<SetSortFieldExpression, SetSortFieldExpression, SetSortFieldExpression,
        SetSortFieldExpression, SetSortFieldExpression> sortExpressions);

    /**
     * desc.
     *
     * @param sortExpressions the sort expressions
     * @return the LogicExpression
     */
    S desc(FiConsumer<SetSortFieldExpression, SetSortFieldExpression, SetSortFieldExpression,
        SetSortFieldExpression, SetSortFieldExpression> sortExpressions);

}