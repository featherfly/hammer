
package cn.featherfly.hammer.expression.entity.condition.nl;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityNotLikeExpressionBase2.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <E2> the generic type
 * @param <C>  the generic type
 * @param <L>  the generic type
 */
public interface EntityNotLikeExpressionBase2<E, E2, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends EntityNotLikeExpression<E, C, L> {

    /**
     * not like value.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L nl2(SerializableFunction<E2, String> name, String value) {
        return nl2(name, value, MatchStrategy.AUTO);
    }

    /**
     * not like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl2(SerializableFunction<E2, String> name, String value, Predicate<String> ignoreStrategy) {
        return nl2(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L nl2(SerializableFunction<E2, String> name, String value, MatchStrategy matchStrategy);

    /**
     * not like value.
     *
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nl2(SerializableFunction<E2, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);

    /**
     * not like value.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    default L nl2(SerializableStringSupplier property) {
        return nl2(property, MatchStrategy.AUTO);
    }

    /**
     * not like value.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L nl2(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return nl2(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not like value.
     *
     * @param property      the property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L nl2(SerializableStringSupplier property, MatchStrategy matchStrategy);

    /**
     * not like value.
     *
     * @param property       the property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L nl2(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

}