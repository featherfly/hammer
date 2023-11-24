package cn.featherfly.hammer.expression.query.sort;

import cn.featherfly.common.function.SixArgusConsumer;

/**
 * sort expression6.
 *
 * @author zhongj
 * @param <S> the generic type
 */
public interface SortExpression6<S extends SortedExpression6<S>> extends SortExpressionBase6<S> {

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