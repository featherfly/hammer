
/*
 * All rights Reserved, Designed By zhongj
 * @Title: Entities.java
 * @Package cn.featherfly.hammer.expression.entity.condition.eq
 * @Description: Entities
 * @author: zhongj
 * @date: 2023-07-18 14:44:18
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.entity.condition;

/**
 * The Interface EqualsNotEqualsEntityExpression.
 *
 * @author zhongj
 * @param <T> the element type
 */
public interface EqualsOrNotEqualsEntityPropertyExpression<T> extends EqualsOrNotEqualsEntityExpression<T>,
        EqualsOrNotEqualsEntityValuePropertyExpression<T>, CompareEntityPropertyExpression<T> {

}
