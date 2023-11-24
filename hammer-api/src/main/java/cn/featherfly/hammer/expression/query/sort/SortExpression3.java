package cn.featherfly.hammer.expression.query.sort;

import cn.featherfly.common.function.ThreeArgusConsumer;

/**
 * sort expression3.
 *
 * @author zhongj
 * @param <S> the generic type
 */
public interface SortExpression3<S extends SortedExpression3<S>> extends SortExpressionBase3<S> {

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