package cn.featherfly.hammer.expression.query.sort;

import cn.featherfly.common.function.FiveArgusConsumer;

/**
 * sort expression5.
 *
 * @author zhongj
 * @param <S> the generic type
 */
public interface SortExpression5<S extends SortedExpression5<S>> extends SortExpressionBase5<S> {

    /**
     * asc.
     *
     * @param sortExpressions the sort expressions
     * @return the LogicExpression
     */
    S asc(FiveArgusConsumer<SetSortFieldExpression, SetSortFieldExpression, SetSortFieldExpression,
            SetSortFieldExpression, SetSortFieldExpression> sortExpressions);

    /**
     * desc.
     *
     * @param sortExpressions the sort expressions
     * @return the LogicExpression
     */
    S desc(FiveArgusConsumer<SetSortFieldExpression, SetSortFieldExpression, SetSortFieldExpression,
            SetSortFieldExpression, SetSortFieldExpression> sortExpressions);

}