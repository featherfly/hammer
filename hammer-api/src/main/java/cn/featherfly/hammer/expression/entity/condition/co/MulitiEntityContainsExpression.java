
package cn.featherfly.hammer.expression.entity.condition.co;

import java.util.function.Predicate;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.entity.condition.MulitiEntityConditionExpression;

/**
 * The Interface MulitiEntityContainsExpression.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface MulitiEntityContainsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends MulitiEntityConditionExpression {

    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param consumer the consumer
    //     * @return LogicExpression
    //     */
    //    <E> L co(Consumer<EntityContainsExpression<E, C, L>> consumer);

    /**
     * contains value. 包含value.
     *
     * @param <E>   the element type
     * @param index the index
     * @param name  参数名称
     * @param value 参数值
     * @return LogicExpression
     */
    default <E> L co(int index, SerializableFunction<E, String> name, String value) {
        return co(index, name, value, QueryPolicy.AUTO);
    }

    /**
     * contains value. 包含value.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           参数名称
     * @param value          参数值
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <E> L co(int index, SerializableFunction<E, String> name, String value, Predicate<String> ignoreStrategy) {
        return co(index, name, value, QueryPolicy.AUTO, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param <E>         the element type
     * @param index       the index
     * @param name        the name
     * @param value       the value
     * @param queryPolicy the query policy
     * @return the l
     */
    <E> L co(int index, SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy);

    /**
     * contains value. 包含value.
     *
     * @param <E>            the element type
     * @param index          the index
     * @param name           the name
     * @param value          the value
     * @param queryPolicy    the query policy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    <E> L co(int index, SerializableFunction<E, String> name, String value, QueryPolicy queryPolicy,
            Predicate<String> ignoreStrategy);

    /**
     * contains value. 包含value.
     *
     * @param index    the index
     * @param property 对象属性
     * @return LogicExpression
     */
    default L co(int index, SerializableSupplier<String> property) {
        return co(index, property, QueryPolicy.AUTO);
    }

    /**
     * contains value. 包含value.
     *
     * @param index          the index
     * @param property       对象属性
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L co(int index, SerializableSupplier<String> property, Predicate<String> ignoreStrategy) {
        return co(index, property, QueryPolicy.AUTO, ignoreStrategy);
    }

    /**
     * contains value. 包含value.
     *
     * @param index       the index
     * @param property    the property
     * @param queryPolicy the query policy
     * @return the l
     */
    L co(int index, SerializableSupplier<String> property, QueryPolicy queryPolicy);

    /**
     * contains value. 包含value.
     *
     * @param index          the index
     * @param property       the property
     * @param queryPolicy    the query policy
     * @param ignoreStrategy the ignore strategy
     * @return the l
     */
    L co(int index, SerializableSupplier<String> property, QueryPolicy queryPolicy, Predicate<String> ignoreStrategy);

    //    嵌套属性使用property(U1::getU2).property(U2:getV).co(v)来设置
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param <R>                 the generic type
    //     * @param fetchEntity         the fetch entity
    //     * @param fetchEntityProperty the fetch entity property
    //     * @param value               参数值
    //     * @return LogicExpression
    //     */
    //    <R> <E> L co(int index, SerializableFunction<E, R> fetchEntity, SerializableFunction<R, String> fetchEntityProperty, String value);
    //
    //    /**
    //     * contains value. 包含value.
    //     *
    //     * @param <R>                 the generic type
    //     * @param fetchEntityValue    the fetch entity value
    //     * @param fetchEntityProperty the fetch entity property
    //     * @return LogicExpression
    //     */
    //    <R> <E> L co(SerializableSupplier<R> fetchEntityValue, SerializableFunction<R, String> fetchEntityProperty);
}