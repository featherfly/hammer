
package cn.featherfly.hammer.expression.condition.in;

import java.io.Serializable;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableDoubleSupplier;
import cn.featherfly.common.function.serializable.SerializableIntSupplier;
import cn.featherfly.common.function.serializable.SerializableLongSupplier;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * in supplier expression5 .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface InSupplierExpression5<C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>      the generic type
     * @param property bean property
     * @return LogicExpression
     */
    <R extends Serializable> L in5(SerializableSupplier<R> property);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param <R>            the generic type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Serializable> L in5(SerializableSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L in5(SerializableIntSupplier property);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in5(SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L in5(SerializableLongSupplier property);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in5(SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L in5(SerializableDoubleSupplier property);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in5(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property bean property
     * @return LogicExpression
     */
    default L in5(SerializableStringSupplier property) {
        return in5(property, MatchStrategy.AUTO);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in5(SerializableStringSupplier property, IgnoreStrategy ignoreStrategy) {
        return in5(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in5(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return in5(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property      bean property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L in5(SerializableStringSupplier property, MatchStrategy matchStrategy);

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property       bean property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L in5(SerializableStringSupplier property, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return in5(property, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * values in. 包含指定，sql中的in.
     *
     * @param property       bean property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L in5(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}