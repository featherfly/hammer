
package cn.featherfly.hammer.expression.condition;

/**
 * <p>
 * 带参数的表达式
 * </p>
 * 
 * @author zhongj
 */
public interface ParamedExpression extends Expression {
    /**
     * <p>
     * 返回参数值
     * </p>
     * 
     * @return 参数
     */
    Object getParam();
}
