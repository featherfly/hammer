
package cn.featherfly.hammer.expression.execute;

/**
 * UpdateExpression.
 *
 * @author zhongj
 * @param <U>  the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 * @param <V>  the value type
 * @param <VN> the generic type
 */
public interface UpdateExpression<U extends ExecutableUpdateExpression<U, C, L, V, VN>,
        C extends ExecutableConditionGroupExpression<C, L>, L extends ExecutableConditionGroupLogicExpression<C, L>,
        V extends UpdateValueExpression<U, C, L, Object, V, VN>,
        VN extends UpdateNumberValueExpression<U, C, L, Number, V, VN>>
        extends PropertyUpdateExpression<U, C, L, V, VN>, UpdateSetExpression<U, C, L> {

}
