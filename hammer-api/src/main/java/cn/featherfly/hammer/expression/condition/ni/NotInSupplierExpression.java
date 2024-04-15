
package cn.featherfly.hammer.expression.condition.ni;

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
 * not in supplier expression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotInSupplierExpression<C extends ConditionExpression, L extends LogicExpression<C, L>> {

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>      the generic type
     * @param property bean property
     * @return LogicExpression
     */
    <R extends Serializable> L ni(SerializableSupplier<R> property);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param <R>            the generic type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R extends Serializable> L ni(SerializableSupplier<R> property, Predicate<R> ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L ni(SerializableIntSupplier property);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(SerializableIntSupplier property, IntPredicate ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L ni(SerializableLongSupplier property);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(SerializableLongSupplier property, LongPredicate ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property bean property
     * @return LogicExpression
     */
    L ni(SerializableDoubleSupplier property);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(SerializableDoubleSupplier property, DoublePredicate ignoreStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property      bean property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L ni(SerializableStringSupplier property) {
        return ni(property, MatchStrategy.AUTO);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property      bean property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L ni(SerializableStringSupplier property, IgnoreStrategy ignoreStrategy) {
        return ni(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property      bean property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L ni(SerializableStringSupplier property, Predicate<String> ignoreStrategy) {
        return ni(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property      bean property
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    L ni(SerializableStringSupplier property, MatchStrategy matchStrategy);

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property       bean property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default L ni(SerializableStringSupplier property, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return ni(property, matchStrategy, (Predicate<String>) ignoreStrategy::test);
    }

    /**
     * values not in. 不包含指定，sql中的not in.
     *
     * @param property       bean property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    L ni(SerializableStringSupplier property, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy);
}