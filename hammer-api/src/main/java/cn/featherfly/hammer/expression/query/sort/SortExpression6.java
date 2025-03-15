package cn.featherfly.hammer.expression.query.sort;

import cn.featherfly.common.function.SixArgusConsumer;
import cn.featherfly.common.operator.SortOperator;

/**
 * sort expression6.
 *
 * @author zhongj
 * @param <S> the generic type
 */
public interface SortExpression6<S extends SortedExpression6<S>> extends SortExpressionBase6<S> {

    /**
     * order.
     *
     * @param order the order
     * @param sortExpressions the sort expressions
     * @return the LogicExpression
     */
    default S order(SortOperator order,
        SixArgusConsumer<SetSortFieldExpression, SetSortFieldExpression, SetSortFieldExpression, SetSortFieldExpression,
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
    S asc(SixArgusConsumer<SetSortFieldExpression, SetSortFieldExpression, SetSortFieldExpression,
        SetSortFieldExpression, SetSortFieldExpression, SetSortFieldExpression> sortExpressions);

    /**
     * desc.
     *
     * @param sortExpressions the sort expressions
     * @return the LogicExpression
     */
    S desc(SixArgusConsumer<SetSortFieldExpression, SetSortFieldExpression, SetSortFieldExpression,
        SetSortFieldExpression, SetSortFieldExpression, SetSortFieldExpression> sortExpressions);

}