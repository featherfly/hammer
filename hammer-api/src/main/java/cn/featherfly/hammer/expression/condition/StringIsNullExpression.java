
package cn.featherfly.hammer.expression.condition;

/**
 * StringIsNullExpression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface StringIsNullExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * is null.
     *
     * @param name 参数名称
     * @return LogicExpression
     */
    default L isn(String name) {
        return isn(name, true);
    }

    /**
     * is null.
     *
     * @param name  参数名称
     * @param value if true, is null; if false, is not null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    L isn(String name, Boolean value);
}