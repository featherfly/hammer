
package cn.featherfly.hammer.expression.condition;

/**
 * StringIsNotNullExpression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface StringIsNotNullExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * is not null.
     *
     * @param name 参数名称
     * @return LogicExpression
     */
    default L inn(String name) {
        return inn(name, true);
    }

    /**
     * is not null.
     *
     * @param name  参数名称
     * @param value if true, is not null; if false, is null; if null, ignore
     *              this operate
     * @return LogicExpression
     */
    L inn(String name, Boolean value);
}