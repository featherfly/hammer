
package cn.featherfly.hammer.expression.condition.field;

import java.util.function.Predicate;

import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * field equals expression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 * @param <V> the value type
 */
public interface FieldEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>, V>
    extends ConditionExpression {

    /**
     * equals. 等于.
     *
     * @param value the value
     * @return LogicExpression
     */
    L eq(V value);

    /**
     * equals. 等于.
     *
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L eq(V value, IgnoreStrategy ignoreStrategy) {
        return eq(value, (Predicate<V>) ignoreStrategy::test);
    }

    /**
     * equals. 等于.
     *
     * @param value the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L eq(V value, Predicate<V> ignoreStrategy);

    /**
     * equals. 等于.
     *
     * @param field the field
     * @return LogicExpression
     */
    L eq(Field field);

    /**
     * equals. 等于.
     *
     * @param expression the expression
     * @return LogicExpression
     */
    L eq(FieldExpression expression);

    //    IMPLSOON 后续来加入这个，效果和eq(FieldExpression expression)一样，只是使用就不那么繁琐了
    //  on((e1,e2) -> e1.property(UserInfo::getUserId).eq(e2.property(User::getId))
    //  on((e1,e2) -> e1.property(UserInfo::getUserId).eq(User::getId)
    //    /**
    //     * equals. 等于.
    //     *
    //     * @param property the property
    //     * @return LogicExpression
    //     */
    //    L eq(SerializableFunction<?, V> property);
}