package cn.featherfly.hammer.expression.query.sort;

import cn.featherfly.common.function.FourArgusConsumer;
import cn.featherfly.common.operator.SortOperator;

/**
 * sort expression4.
 *
 * @author zhongj
 * @param <S> the generic type
 */
public interface SortExpression4<S extends SortedExpression4<S>> extends SortExpressionBase4<S> {

    /**
     * order.
     *
     * @param order the order
     * @param sortExpressions the sort expressions
     * @return the LogicExpression
     */
    default S order(SortOperator order, FourArgusConsumer<SetSortFieldExpression, SetSortFieldExpression,
        SetSortFieldExpression, SetSortFieldExpression> sortExpressions) {
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
    S asc(FourArgusConsumer<SetSortFieldExpression, SetSortFieldExpression, SetSortFieldExpression,
        SetSortFieldExpression> sortExpressions);

    /**
     * desc.
     *
     * @param sortExpressions the sort expressions
     * @return the LogicExpression
     */
    S desc(FourArgusConsumer<SetSortFieldExpression, SetSortFieldExpression, SetSortFieldExpression,
        SetSortFieldExpression> sortExpressions);

}