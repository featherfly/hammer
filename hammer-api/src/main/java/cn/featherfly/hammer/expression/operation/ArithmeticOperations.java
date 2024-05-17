
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-17 16:40:17
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.operation;

/**
 * Arithmetic.
 *
 * @author zhongj
 */
public interface ArithmeticOperations<N extends Number, R> extends Add<N, R>, Subtract<N, R>, Multiply<N, R>, Divide<N, R> {

}
