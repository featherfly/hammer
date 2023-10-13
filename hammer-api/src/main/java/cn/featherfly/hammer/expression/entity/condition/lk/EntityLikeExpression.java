
package cn.featherfly.hammer.expression.entity.condition.lk;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * The Interface EntityLikeExpression.
 *
 * @author zhongj
 * @param <E> the element type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface EntityLikeExpression<E, C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {
    //    /**
    //     * like value.
    //     *
    //     * @param consumer the consumer
    //     * @return LogicExpression
    //     */
    //    L lk(Consumer<EntityLikeExpression<E, C, L>> consumer);

    /**
     * like value.
     *
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default L lk(SerializableFunction<E, String> name, String value) {
        return lk(name, value, MatchStrategy.AUTO);
    }

    /**
     * like value.
     *
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
        return lk(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param name        the name 参数名称
     * @param value       the value
     * @param queryPolicy the query policy
     * @return the l
     */
    L lk(SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy);

    /**
     * like value.
     *
     * @param name           the name 参数名称
     * @param value          the value
     * @param queryPolicy    the query policy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    L lk(SerializableFunction<E, String> name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy);

    /**
     * like value.
     *
     * @param property 对象属性
     * @return LogicExpression
     */
    default L lk(SerializableStringSupplier property) {
        return lk(property, MatchStrategy.AUTO);
    }

    /**
     * like value.
     *
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L lk(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return lk(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * like value.
     *
     * @param property    the property 对象属性
     * @param queryPolicy the query policy
     * @return the l
     */
    L lk(SerializableStringSupplier property, MatchStrategy matchStrategy);

    /**
     * like value.
     *
     * @param property       the property 对象属性
     * @param queryPolicy    the query policy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    L lk(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);

    //  嵌套属性使用property(U1::getU2).property(U2:getV).lk(v)来设置
    //    /**
    //     * like value.
    //     *
    //     * @param <R>        the generic type
    //     * @param repository the repository
    //     * @param property   the property
    //     * @param value      参数值
    //     * @return LogicExpression
    //     */
    //    <R> L lk(SerializableFunction<E, R> repository, SerializableFunction<R, String> property, String value);
    //
    //    /**
    //     * like value.
    //     *
    //     * @param <R>        the generic type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <R> L lk(SerializableSupplier<R> repository, SerializableFunction<R, String> property);
}