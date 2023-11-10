package cn.featherfly.hammer.expression.query.sort;

import cn.featherfly.common.function.FourArgusConsumer;

/**
 * sort expression4.
 *
 * @author zhongj
 * @param <S> the generic type
 */
public interface SortExpression4<S extends SortedExpression4<S>> extends SortExpressionBase4<S> {

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