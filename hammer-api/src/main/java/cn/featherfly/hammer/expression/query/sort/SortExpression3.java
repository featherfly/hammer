package cn.featherfly.hammer.expression.query.sort;

import cn.featherfly.common.function.ThreeArgusConsumer;
import cn.featherfly.common.operator.SortOperator;

/**
 * sort expression3.
 *
 * @author zhongj
 * @param <S> the generic type
 */
public interface SortExpression3<S extends SortedExpression3<S>> extends SortExpressionBase3<S> {

    /**
     * order.
     *
     * @param order the order
     * @param sortExpressions the sort expressions
     * @return the LogicExpression
     */
    default S order(SortOperator order,
        ThreeArgusConsumer<SetSortFieldExpression, SetSortFieldExpression, SetSortFieldExpression> sortExpressions) {
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
    S asc(ThreeArgusConsumer<SetSortFieldExpression, SetSortFieldExpression, SetSortFieldExpression> sortExpressions);

    /**
     * desc.
     *
     * @param sortExpressions the sort expressions
     * @return the LogicExpression
     */
    S desc(ThreeArgusConsumer<SetSortFieldExpression, SetSortFieldExpression, SetSortFieldExpression> sortExpressions);

}