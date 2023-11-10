
package cn.featherfly.hammer.expression.condition.field.value;

/**
 * The Interface SetValueIsNullOrIsNotNullExpression.
 *
 * @author zhongj
 */
public interface SetValueIsNullOrIsNotNullExpression {

    /**
     * Value.
     */
    default void value() {
        value(true);
    }

    /**
     * Value.
     *
     * @param value the value
     */
    void value(Boolean value);
}
