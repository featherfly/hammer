
package cn.featherfly.hammer.expression.condition.ne;

import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.AliasField;
import cn.featherfly.common.repository.Field;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * not equals expression .
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public interface NotEqualsExpression<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends ConditionExpression {

    /**
     * not equals. 不等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ne(Field field, Object value) {
        return ne(field.name(), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ne(Field field, R value, Predicate<R> ignoreStrategy) {
        return ne(field.name(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L ne(Field field, Object value, MatchStrategy matchStrategy) {
        return ne(field.name(), value, matchStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ne(Field field, R value, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy) {
        return ne(field.name(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param name  the name
     * @param value the value
     * @return LogicExpression
     */
    default L ne(String name, Object value) {
        return ne(name, value, MatchStrategy.AUTO);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ne(String name, R value, Predicate<R> ignoreStrategy) {
        return ne(name, value, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param name          the name
     * @param value         the value
     * @param matchStrategy the query policy
     * @return LogicExpression
     */
    L ne(String name, Object value, MatchStrategy matchStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param name           the name
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ne(String name, R value, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy);

    /**
     * not equals. 不等于.
     *
     * @param field the field
     * @param value the value
     * @return LogicExpression
     */
    default L ne(AliasField field, Object value) {
        return ne(field.getAliasOrName(), value);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param field          the field
     * @param value          the value
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ne(AliasField field, R value, Predicate<R> ignoreStrategy) {
        return ne(field.getAliasOrName(), value, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param field         the field
     * @param value         the value
     * @param matchStrategy the match strategy
     * @return LogicExpression
     */
    default L ne(AliasField field, Object value, MatchStrategy matchStrategy) {
        return ne(field.getAliasOrName(), value, matchStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param field          the field
     * @param value          the value
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ne(AliasField field, R value, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy) {
        return ne(field.getAliasOrName(), value, matchStrategy, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R>      the generic type
     * @param property bean property
     * @return LogicExpression
     */
    default <R> L ne(SerializableSupplier<R> property) {
        return ne(property, MatchStrategy.AUTO);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param property       bean property
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    default <R> L ne(SerializableSupplier<R> property, Predicate<R> ignoreStrategy) {
        return ne(property, MatchStrategy.AUTO, ignoreStrategy);
    }

    /**
     * not equals. 不等于.
     *
     * @param <R>           the generic type
     * @param property      bean property
     * @param matchStrategy the query policy
     * @return LogicExpression
     */
    <R> L ne(SerializableSupplier<R> property, MatchStrategy matchStrategy);

    /**
     * not equals. 不等于.
     *
     * @param <R>            the generic type
     * @param property       bean property
     * @param matchStrategy  the match strategy
     * @param ignoreStrategy the ignore strategy
     * @return LogicExpression
     */
    <R> L ne(SerializableSupplier<R> property, MatchStrategy matchStrategy, Predicate<R> ignoreStrategy);
}