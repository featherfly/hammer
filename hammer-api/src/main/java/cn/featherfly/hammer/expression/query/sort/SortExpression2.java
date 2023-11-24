package cn.featherfly.hammer.expression.query.sort;

import java.util.function.BiConsumer;

/**
 * sort expression.
 *
 * @author zhongj
 * @param <S> the generic type
 */
public interface SortExpression2<S extends SortedExpression2<S>> extends SortExpressionBase2<S> {

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