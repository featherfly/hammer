
package cn.featherfly.hammer.expression.condition;

/**
 * 带参数的表达式. .
 *
 * @author zhongj
 */
public interface ParamedExpression extends Expression {

    /**
     * 返回参数值.
     *
     * @return 参数
     */
    Object getParam();
}
