
package cn.featherfly.hammer.expression.entity.condition.ew;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.MulitiEntityConditionExpression;

/**
 * The Interface MulitiEntityStartWithExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiEntityEndWithExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends MulitiEntityConditionExpression {

    //    /**
    //     * end with value. 以value结尾.
    //     *
    //     * @param consumer the consumer
    //     * @return LogicExpression
    //     */
    //    L ew(Consumer<EntityStartWithExpression<E, C, L>> consumer);

    /**
     * end with value. 以value结尾.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default <E> L ew(int index, SerializableFunction<E, String> name, String value) {
        return ew(index, name, value, MatchStrategy.AUTO);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E> L ew(int index, SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
        return ew(index, name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param <E>         the element type
     * @param index       the index
     * @param name        the name
     * @param value       the value
     * @param queryPolicy the query policy
     * @return the l
     */
    <E> L ew(int index, SerializableFunction<E, String> name, String value, MatchStrategy queryPolicy);

    /**
     * end with value. 以value结尾.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param queryPolicy    the query policy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    <E> L ew(int index, SerializableFunction<E, String> name, String value, MatchStrategy queryPolicy,
            Predicate<String> ignoreStrategy);

    /**
     * end with value. 以value结尾.
     *
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    default L ew(int index, SerializableSupplier<String> property) {
        return ew(index, property, MatchStrategy.AUTO);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ew(int index, SerializableSupplier<String> property, Predicate<String> ignoreStrategy) {
        return ew(index, property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * end with value. 以value结尾.
     *
     * @param index       the index
     * @param property    the property
     * @param queryPolicy the query policy
     * @return the l
     */
    L ew(int index, SerializableSupplier<String> property, MatchStrategy queryPolicy);

    /**
     * end with value. 以value结尾.
     *
     * @param index          the index
     * @param property       the property
     * @param queryPolicy    the query policy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    L ew(int index, SerializableSupplier<String> property, MatchStrategy queryPolicy, Predicate<String> ignoreStrategy);

    //  嵌套属性使用property(U1::getU2).property(U2:getV).ew(v)来设置
    //    /**
    //     * 以value开始.
    //     *
    //     * @param <R>        the generic type
    //     * @param repository the repository
    //     * @param property   the property
    //     * @param value      参数值
    //     * @return LogicExpression
    //     */
    //    <R> L ew(int index, SerializableFunction<E, R> repository, SerializableFunction<R, String> property, String value);
    //
    //    /**
    //     * 以value开始.
    //     *
    //     * @param <R>        the generic type
    //     * @param repository the repository
    //     * @param property   对象属性
    //     * @return LogicExpression
    //     */
    //    <R> L ew(int index, SerializableSupplier<R> repository, SerializableFunction<R, String> property);
}