
package cn.featherfly.hammer.dml.builder.sql.query;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.DoublePredicate;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.function.CharPredicate;
import cn.featherfly.common.function.serializable.SerializableDateSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableNumberSupplier;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableToDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.operator.LogicOperator;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.GroupEndExpression;
import cn.featherfly.hammer.expression.condition.GroupExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.field.FieldExpression;
import cn.featherfly.hammer.expression.condition.field.NumberFieldExpression;
import cn.featherfly.hammer.expression.condition.field.StringFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupExpression;
import cn.featherfly.hammer.expression.repository.condition.RepositoryConditionsGroupLogicExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryDateFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryEnumFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryLocalDateFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryLocalDateTimeFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryLocalTimeFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryNumberFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositorySerializableFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryStringFieldExpression;

/**
 * The Class UserQueryRepositoryConditionGroupExpression.
 *
 * @author zhongj
 */
public class UserQueryRepositoryConditionGroupExpression implements
    RepositoryConditionsGroupExpression<UserQueryRepositoryConditionGroupExpression,
        UserQueryRepositoryConditionGroupExpression>,
    RepositoryConditionsGroupLogicExpression<UserQueryRepositoryConditionGroupExpression,
        UserQueryRepositoryConditionGroupExpression> {

    /**
     * Instantiates a new user query repository condition group expression.
     */
    public UserQueryRepositoryConditionGroupExpression() {
    }

    /**
     * Name.
     *
     * @return the string expression
     */
    public StringFieldExpression<UserQueryRepositoryConditionGroupExpression,
        UserQueryRepositoryConditionGroupExpression> name() {
        return fieldAsString("name");
    }

    /**
     * Age.
     *
     * @return the number expression
     */
    public NumberFieldExpression<Number, UserQueryRepositoryConditionGroupExpression,
        UserQueryRepositoryConditionGroupExpression> age() {
        return fieldAsNumber("age");
    }

    /**
     * Pwd.
     *
     * @return the string expression
     */
    public StringFieldExpression<UserQueryRepositoryConditionGroupExpression,
        UserQueryRepositoryConditionGroupExpression> pwd() {
        return fieldAsString("pwd");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression co(String name, String value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression co(SerializableToStringFunction<T> name, String value,
        MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression co(SerializableStringSupplier property,
        MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression le(String name, N value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> UserQueryRepositoryConditionGroupExpression le(SerializableToNumberFunction<T, N> name,
        N value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression le(String name, D value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> UserQueryRepositoryConditionGroupExpression le(SerializableToDateFunction<T, D> name,
        D value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(String name, LocalTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression le(SerializableToLocalTimeFunction<T> name,
        LocalTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(String name, LocalDate value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression le(SerializableToLocalDateFunction<T> name,
        LocalDate value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(String name, LocalDateTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression le(SerializableToLocalDateTimeFunction<T> name,
        LocalDateTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(String name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression le(SerializableToStringFunction<T> name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> UserQueryRepositoryConditionGroupExpression le(SerializableDateSupplier<R> property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> UserQueryRepositoryConditionGroupExpression le(SerializableNumberSupplier<R> property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(SerializableLocalDateSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(SerializableLocalTimeSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(SerializableLocalDateTimeSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(SerializableStringSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression lt(String name, N value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> UserQueryRepositoryConditionGroupExpression lt(SerializableToNumberFunction<T, N> name,
        N value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression lt(String name, D value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> UserQueryRepositoryConditionGroupExpression lt(SerializableToDateFunction<T, D> name,
        D value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(String name, LocalTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression lt(SerializableToLocalTimeFunction<T> name,
        LocalTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(String name, LocalDate value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression lt(SerializableToLocalDateFunction<T> name,
        LocalDate value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(String name, LocalDateTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression lt(SerializableToLocalDateTimeFunction<T> name,
        LocalDateTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(String name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression lt(SerializableToStringFunction<T> name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> UserQueryRepositoryConditionGroupExpression lt(SerializableDateSupplier<R> property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> UserQueryRepositoryConditionGroupExpression lt(SerializableNumberSupplier<R> property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(SerializableLocalDateSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(SerializableLocalTimeSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(SerializableLocalDateTimeSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(SerializableStringSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression sw(String name, String value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression sw(SerializableToStringFunction<T> name, String value,
        MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression sw(SerializableStringSupplier property,
        MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lk(String name, String value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression lk(SerializableToStringFunction<T> name, String value,
        MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lk(SerializableStringSupplier property,
        MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression expression(String expression, Map<String, Serializable> params) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression expression(String expression, Serializable... params) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression group() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression group(
        Function<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> group) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression endGroup() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression logic(LogicOperator operator) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression and() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression and(
        Function<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> group) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression or() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression or(
        Function<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> group) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression co(String name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression co(SerializableToStringFunction<T> name, String value,
        MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression co(SerializableStringSupplier propertyValue,
        MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ew(String name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ew(SerializableToStringFunction<T> name, String value,
        MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ew(SerializableStringSupplier propertyValue,
        MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression le(String name, N value,
        Predicate<N> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> UserQueryRepositoryConditionGroupExpression le(SerializableToNumberFunction<T, N> name,
        N value, Predicate<N> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression le(String name, D value,
        Predicate<D> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> UserQueryRepositoryConditionGroupExpression le(SerializableToDateFunction<T, D> name,
        D value, Predicate<D> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(String name, LocalTime value,
        Predicate<LocalTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression le(SerializableToLocalTimeFunction<T> name, LocalTime value,
        Predicate<LocalTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(String name, LocalDate value,
        Predicate<LocalDate> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression le(SerializableToLocalDateFunction<T> name, LocalDate value,
        Predicate<LocalDate> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(String name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression le(SerializableToLocalDateTimeFunction<T> name,
        LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(String name, String value, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression le(SerializableToStringFunction<T> name, String value,
        Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> UserQueryRepositoryConditionGroupExpression le(SerializableDateSupplier<R> propertyValue,
        Predicate<R> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> UserQueryRepositoryConditionGroupExpression le(
        SerializableNumberSupplier<R> propertyValue, Predicate<R> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(SerializableLocalDateSupplier propertyValue,
        Predicate<LocalDate> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(SerializableLocalTimeSupplier propertyValue,
        Predicate<LocalTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(SerializableLocalDateTimeSupplier propertyValue,
        Predicate<LocalDateTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(SerializableStringSupplier propertyValue,
        Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression sw(String name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression sw(SerializableToStringFunction<T> propertyName,
        String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression sw(SerializableStringSupplier propertyValue,
        MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lk(String name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression lk(SerializableToStringFunction<T> name, String value,
        MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lk(SerializableStringSupplier property,
        MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression co(String name, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression co(SerializableToStringFunction<T> name, String value,
        MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression co(SerializableStringSupplier propertyValue,
        MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ew(String name, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ew(SerializableToStringFunction<T> name, String value,
        MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ew(SerializableStringSupplier propertyValue,
        MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression ge(String name, N value,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression ge(String name, N value,
        Predicate<N> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> UserQueryRepositoryConditionGroupExpression ge(SerializableToNumberFunction<T, N> name,
        N value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> UserQueryRepositoryConditionGroupExpression ge(SerializableToNumberFunction<T, N> name,
        N value, Predicate<N> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression ge(SerializableNumberSupplier<N> property,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression ge(SerializableNumberSupplier<N> property,
        Predicate<N> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression ge(String name, D value,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression ge(String name, D value,
        Predicate<D> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> UserQueryRepositoryConditionGroupExpression ge(SerializableToDateFunction<T, D> name,
        D value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> UserQueryRepositoryConditionGroupExpression ge(SerializableToDateFunction<T, D> name,
        D value, Predicate<D> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression ge(SerializableDateSupplier<D> property,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression ge(SerializableDateSupplier<D> property,
        Predicate<D> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(String name, LocalTime value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(String name, LocalTime value,
        Predicate<LocalTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ge(SerializableToLocalTimeFunction<T> name, LocalTime value,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ge(SerializableToLocalTimeFunction<T> name, LocalTime value,
        Predicate<LocalTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(SerializableLocalTimeSupplier property,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(SerializableLocalTimeSupplier property,
        Predicate<LocalTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(String name, LocalDate value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(String name, LocalDate value,
        Predicate<LocalDate> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ge(SerializableToLocalDateFunction<T> name, LocalDate value,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ge(SerializableToLocalDateFunction<T> name, LocalDate value,
        Predicate<LocalDate> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(SerializableLocalDateSupplier property,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(SerializableLocalDateSupplier property,
        Predicate<LocalDate> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(String name, LocalDateTime value,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(String name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ge(SerializableToLocalDateTimeFunction<T> name,
        LocalDateTime value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ge(SerializableToLocalDateTimeFunction<T> name,
        LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(SerializableLocalDateTimeSupplier property,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(SerializableLocalDateTimeSupplier property,
        Predicate<LocalDateTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(String name, String value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(String name, String value, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ge(SerializableToStringFunction<T> name, String value,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ge(SerializableToStringFunction<T> name, String value,
        Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(SerializableStringSupplier property,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(SerializableStringSupplier property,
        Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression gt(String name, N value,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression gt(String name, N value,
        Predicate<N> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> UserQueryRepositoryConditionGroupExpression gt(SerializableToNumberFunction<T, N> name,
        N value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> UserQueryRepositoryConditionGroupExpression gt(SerializableToNumberFunction<T, N> name,
        N value, Predicate<N> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression gt(SerializableNumberSupplier<N> property,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression gt(SerializableNumberSupplier<N> property,
        Predicate<N> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression gt(String name, D value,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression gt(String name, D value,
        Predicate<D> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> UserQueryRepositoryConditionGroupExpression gt(SerializableToDateFunction<T, D> name,
        D value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> UserQueryRepositoryConditionGroupExpression gt(SerializableToDateFunction<T, D> name,
        D value, Predicate<D> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression gt(SerializableDateSupplier<D> property,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression gt(SerializableDateSupplier<D> property,
        Predicate<D> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(String name, LocalTime value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(String name, LocalTime value,
        Predicate<LocalTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression gt(SerializableToLocalTimeFunction<T> name, LocalTime value,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression gt(SerializableToLocalTimeFunction<T> name, LocalTime value,
        Predicate<LocalTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(SerializableLocalTimeSupplier property,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(SerializableLocalTimeSupplier property,
        Predicate<LocalTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(String name, LocalDate value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(String name, LocalDate value,
        Predicate<LocalDate> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression gt(SerializableToLocalDateFunction<T> name, LocalDate value,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression gt(SerializableToLocalDateFunction<T> name, LocalDate value,
        Predicate<LocalDate> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(SerializableLocalDateSupplier property,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(SerializableLocalDateSupplier property,
        Predicate<LocalDate> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(String name, LocalDateTime value,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(String name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression gt(SerializableToLocalDateTimeFunction<T> name,
        LocalDateTime value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression gt(SerializableToLocalDateTimeFunction<T> name,
        LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(SerializableLocalDateTimeSupplier property,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(SerializableLocalDateTimeSupplier property,
        Predicate<LocalDateTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(String name, String value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(String name, String value, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression gt(SerializableToStringFunction<T> name, String value,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression gt(SerializableToStringFunction<T> name, String value,
        Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(SerializableStringSupplier property,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(SerializableStringSupplier property,
        Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression le(String name, N value,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> UserQueryRepositoryConditionGroupExpression le(SerializableToNumberFunction<T, N> name,
        N value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression le(SerializableNumberSupplier<N> property,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression le(String name, D value,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> UserQueryRepositoryConditionGroupExpression le(SerializableToDateFunction<T, D> name,
        D value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression le(SerializableDateSupplier<D> property,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(String name, LocalTime value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression le(SerializableToLocalTimeFunction<T> name, LocalTime value,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(SerializableLocalTimeSupplier property,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(String name, LocalDate value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression le(SerializableToLocalDateFunction<T> name, LocalDate value,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(SerializableLocalDateSupplier property,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(String name, LocalDateTime value,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression le(SerializableToLocalDateTimeFunction<T> name,
        LocalDateTime value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(SerializableLocalDateTimeSupplier property,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(String name, String value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression le(SerializableToStringFunction<T> name, String value,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(SerializableStringSupplier property,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression lt(String name, N value,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression lt(String name, N value,
        Predicate<N> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> UserQueryRepositoryConditionGroupExpression lt(SerializableToNumberFunction<T, N> name,
        N value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> UserQueryRepositoryConditionGroupExpression lt(SerializableToNumberFunction<T, N> name,
        N value, Predicate<N> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression lt(SerializableNumberSupplier<N> property,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression lt(SerializableNumberSupplier<N> property,
        Predicate<N> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression lt(String name, D value,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression lt(String name, D value,
        Predicate<D> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> UserQueryRepositoryConditionGroupExpression lt(SerializableToDateFunction<T, D> name,
        D value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> UserQueryRepositoryConditionGroupExpression lt(SerializableToDateFunction<T, D> name,
        D value, Predicate<D> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression lt(SerializableDateSupplier<D> property,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression lt(SerializableDateSupplier<D> property,
        Predicate<D> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(String name, LocalTime value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(String name, LocalTime value,
        Predicate<LocalTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression lt(SerializableToLocalTimeFunction<T> name, LocalTime value,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression lt(SerializableToLocalTimeFunction<T> name, LocalTime value,
        Predicate<LocalTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(SerializableLocalTimeSupplier property,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(SerializableLocalTimeSupplier property,
        Predicate<LocalTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(String name, LocalDate value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(String name, LocalDate value,
        Predicate<LocalDate> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression lt(SerializableToLocalDateFunction<T> name, LocalDate value,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression lt(SerializableToLocalDateFunction<T> name, LocalDate value,
        Predicate<LocalDate> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(SerializableLocalDateSupplier property,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(SerializableLocalDateSupplier property,
        Predicate<LocalDate> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(String name, LocalDateTime value,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(String name, LocalDateTime value,
        Predicate<LocalDateTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression lt(SerializableToLocalDateTimeFunction<T> name,
        LocalDateTime value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression lt(SerializableToLocalDateTimeFunction<T> name,
        LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(SerializableLocalDateTimeSupplier property,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(SerializableLocalDateTimeSupplier property,
        Predicate<LocalDateTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(String name, String value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(String name, String value, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression lt(SerializableToStringFunction<T> name, String value,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression lt(SerializableToStringFunction<T> name, String value,
        Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(SerializableStringSupplier property,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(SerializableStringSupplier property,
        Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression sw(String name, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression sw(SerializableToStringFunction<T> propertyName,
        String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression sw(SerializableStringSupplier propertyValue,
        MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lk(String name, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression lk(SerializableToStringFunction<T> name, String value,
        MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lk(SerializableStringSupplier property,
        MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression ba(String name, N min, N max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression ba(String name, N min, N max,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression ba(String name, N min, N max,
        BiPredicate<N, N> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> UserQueryRepositoryConditionGroupExpression ba(SerializableToNumberFunction<T, N> name,
        N min, N max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> UserQueryRepositoryConditionGroupExpression ba(SerializableToNumberFunction<T, N> name,
        N min, N max, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> UserQueryRepositoryConditionGroupExpression ba(SerializableToNumberFunction<T, N> name,
        N min, N max, BiPredicate<N, N> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression ba(String name, D min, D max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression ba(String name, D min, D max,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression ba(String name, D min, D max,
        BiPredicate<D, D> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> UserQueryRepositoryConditionGroupExpression ba(SerializableToDateFunction<T, D> name,
        D min, D max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> UserQueryRepositoryConditionGroupExpression ba(SerializableToDateFunction<T, D> name,
        D min, D max, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> UserQueryRepositoryConditionGroupExpression ba(SerializableToDateFunction<T, D> name,
        D min, D max, BiPredicate<D, D> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ba(String name, LocalTime min, LocalTime max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ba(String name, LocalTime min, LocalTime max,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ba(String name, LocalTime min, LocalTime max,
        BiPredicate<LocalTime, LocalTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ba(SerializableToLocalTimeFunction<T> name, LocalTime min,
        LocalTime max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ba(SerializableToLocalTimeFunction<T> name, LocalTime min,
        LocalTime max, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ba(SerializableToLocalTimeFunction<T> name, LocalTime min,
        LocalTime max, BiPredicate<LocalTime, LocalTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ba(String name, LocalDate min, LocalDate max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ba(String name, LocalDate min, LocalDate max,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ba(String name, LocalDate min, LocalDate max,
        BiPredicate<LocalDate, LocalDate> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ba(SerializableToLocalDateFunction<T> name, LocalDate min,
        LocalDate max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ba(SerializableToLocalDateFunction<T> name, LocalDate min,
        LocalDate max, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ba(SerializableToLocalDateFunction<T> name, LocalDate min,
        LocalDate max, BiPredicate<LocalDate, LocalDate> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ba(String name, LocalDateTime min, LocalDateTime max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ba(String name, LocalDateTime min, LocalDateTime max,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ba(String name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ba(SerializableToLocalDateTimeFunction<T> name,
        LocalDateTime min, LocalDateTime max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ba(SerializableToLocalDateTimeFunction<T> name,
        LocalDateTime min, LocalDateTime max, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ba(SerializableToLocalDateTimeFunction<T> name,
        LocalDateTime min, LocalDateTime max, BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ba(String name, String min, String max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ba(String name, String min, String max,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ba(String name, String min, String max,
        BiPredicate<String, String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ba(SerializableToStringFunction<T> name, String min,
        String max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ba(SerializableToStringFunction<T> name, String min,
        String max, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ba(SerializableToStringFunction<T> name, String min,
        String max, BiPredicate<String, String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression nba(String name, N min, N max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression nba(String name, N min, N max,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression nba(String name, N min, N max,
        BiPredicate<N, N> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> UserQueryRepositoryConditionGroupExpression nba(
        SerializableToNumberFunction<T, N> name, N min, N max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> UserQueryRepositoryConditionGroupExpression nba(
        SerializableToNumberFunction<T, N> name, N min, N max, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> UserQueryRepositoryConditionGroupExpression nba(
        SerializableToNumberFunction<T, N> name, N min, N max, BiPredicate<N, N> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression nba(String name, D min, D max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression nba(String name, D min, D max,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression nba(String name, D min, D max,
        BiPredicate<D, D> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> UserQueryRepositoryConditionGroupExpression nba(SerializableToDateFunction<T, D> name,
        D min, D max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> UserQueryRepositoryConditionGroupExpression nba(SerializableToDateFunction<T, D> name,
        D min, D max, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> UserQueryRepositoryConditionGroupExpression nba(SerializableToDateFunction<T, D> name,
        D min, D max, BiPredicate<D, D> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nba(String name, LocalTime min, LocalTime max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nba(String name, LocalTime min, LocalTime max,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nba(String name, LocalTime min, LocalTime max,
        BiPredicate<LocalTime, LocalTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression nba(SerializableToLocalTimeFunction<T> name, LocalTime min,
        LocalTime max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression nba(SerializableToLocalTimeFunction<T> name, LocalTime min,
        LocalTime max, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression nba(SerializableToLocalTimeFunction<T> name, LocalTime min,
        LocalTime max, BiPredicate<LocalTime, LocalTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nba(String name, LocalDate min, LocalDate max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nba(String name, LocalDate min, LocalDate max,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nba(String name, LocalDate min, LocalDate max,
        BiPredicate<LocalDate, LocalDate> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression nba(SerializableToLocalDateFunction<T> name, LocalDate min,
        LocalDate max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression nba(SerializableToLocalDateFunction<T> name, LocalDate min,
        LocalDate max, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression nba(SerializableToLocalDateFunction<T> name, LocalDate min,
        LocalDate max, BiPredicate<LocalDate, LocalDate> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nba(String name, LocalDateTime min, LocalDateTime max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nba(String name, LocalDateTime min, LocalDateTime max,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nba(String name, LocalDateTime min, LocalDateTime max,
        BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression nba(SerializableToLocalDateTimeFunction<T> name,
        LocalDateTime min, LocalDateTime max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression nba(SerializableToLocalDateTimeFunction<T> name,
        LocalDateTime min, LocalDateTime max, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression nba(SerializableToLocalDateTimeFunction<T> name,
        LocalDateTime min, LocalDateTime max, BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nba(String name, String min, String max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nba(String name, String min, String max,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nba(String name, String min, String max,
        BiPredicate<String, String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression nba(SerializableToStringFunction<T> name, String min,
        String max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression nba(SerializableToStringFunction<T> name, String min,
        String max, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression nba(SerializableToStringFunction<T> name, String min,
        String max, BiPredicate<String, String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression nco(SerializableToStringFunction<T> name, String value,
        MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression nco(SerializableToStringFunction<T> name, String value,
        MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression nco(SerializableToStringFunction<T> name, String value,
        MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nco(SerializableStringSupplier propertyValue,
        MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nco(SerializableStringSupplier propertyValue,
        MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nco(SerializableStringSupplier propertyValue,
        MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nco(String name, String value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nco(String name, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nco(String name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression newv(SerializableToStringFunction<T> name, String value,
        MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression newv(SerializableToStringFunction<T> name, String value,
        MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression newv(SerializableToStringFunction<T> name, String value,
        MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression newv(SerializableStringSupplier propertyValue,
        MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression newv(SerializableStringSupplier propertyValue,
        MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression newv(SerializableStringSupplier propertyValue,
        MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression newv(String name, String value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression newv(String name, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression newv(String name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression nsw(SerializableToStringFunction<T> propertyName,
        String value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression nsw(SerializableToStringFunction<T> propertyName,
        String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression nsw(SerializableToStringFunction<T> propertyName,
        String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nsw(SerializableStringSupplier propertyValue,
        MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nsw(SerializableStringSupplier propertyValue,
        MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nsw(SerializableStringSupplier propertyValue,
        MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nsw(String name, String value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nsw(String name, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nsw(String name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression nl(SerializableToStringFunction<T> name, String value,
        MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression nl(SerializableToStringFunction<T> name, String value,
        MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression nl(SerializableToStringFunction<T> name, String value,
        MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nl(SerializableStringSupplier property,
        MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nl(SerializableStringSupplier property,
        MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nl(SerializableStringSupplier property,
        MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nl(String name, String value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nl(String name, String value, MatchStrategy matchStrategy,
        IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nl(String name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression in(String name, int... values) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression in(String name, int[] values, Predicate<int[]> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression in(String name, long... value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression in(String name, long[] values,
        Predicate<long[]> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression in(String name, double... values) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression in(String name, double[] values,
        Predicate<double[]> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression in(String name, String[] values, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression in(String name, String[] values, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ew(String name, String value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression eq(String name, boolean value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression eq(String name, char value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression eq(String name, char value, CharPredicate ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression eq(String name, int value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression eq(String name, int value, IntPredicate ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression eq(String name, long value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression eq(String name, long value, LongPredicate ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression eq(String name, double value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression eq(String name, double value, DoublePredicate ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression eq(String name, String value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression eq(String name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> UserQueryRepositoryConditionGroupExpression eq(String name, R value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> UserQueryRepositoryConditionGroupExpression eq(String name, R value,
        Predicate<R> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ne(String name, boolean value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ne(String name, char value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ne(String name, char value, CharPredicate ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ne(String name, int value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ne(String name, int value, IntPredicate ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ne(String name, long value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ne(String name, long value, LongPredicate ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ne(String name, double value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ne(String name, double value, DoublePredicate ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ne(String name, String value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ne(String name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> UserQueryRepositoryConditionGroupExpression ne(String name, R value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> UserQueryRepositoryConditionGroupExpression ne(String name, R value,
        Predicate<R> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(String name, int value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(String name, int value, IntPredicate ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(String name, long value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(String name, long value, LongPredicate ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(String name, double value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(String name, double value, DoublePredicate ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> UserQueryRepositoryConditionGroupExpression ge(String name, E value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> UserQueryRepositoryConditionGroupExpression ge(String name, E value,
        Predicate<E> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression ge(String name, N value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression ge(String name, D value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(String name, LocalTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(String name, LocalDate value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(String name, LocalDateTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(String name, String value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(String name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(String name, int value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(String name, int value, IntPredicate ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(String name, long value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(String name, long value, LongPredicate ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(String name, double value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(String name, double value, DoublePredicate ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> UserQueryRepositoryConditionGroupExpression gt(String name, E value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> UserQueryRepositoryConditionGroupExpression gt(String name, E value,
        Predicate<E> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression gt(String name, N value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression gt(String name, D value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(String name, LocalTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(String name, LocalDate value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(String name, LocalDateTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(String name, String value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(String name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> UserQueryRepositoryConditionGroupExpression in(String name,
        @SuppressWarnings("unchecked") R... values) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> UserQueryRepositoryConditionGroupExpression in(String name, R value,
        Predicate<R> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ni(String name, int... values) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ni(String name, int[] values, Predicate<int[]> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ni(String name, long... value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ni(String name, long[] values,
        Predicate<long[]> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ni(String name, double... values) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ni(String name, double[] values,
        Predicate<double[]> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ni(String name, String[] values, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ni(String name, String[] values, MatchStrategy matchStrategy,
        Predicate<String[]> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> UserQueryRepositoryConditionGroupExpression ni(String name,
        @SuppressWarnings("unchecked") R... values) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Serializable> UserQueryRepositoryConditionGroupExpression ni(String name, R value,
        Predicate<R> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression inn(String name, Boolean value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression isn(String name, Boolean value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(String name, int value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(String name, int value, IntPredicate ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(String name, long value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(String name, long value, LongPredicate ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(String name, double value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(String name, double value, DoublePredicate ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> UserQueryRepositoryConditionGroupExpression le(String name, E value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> UserQueryRepositoryConditionGroupExpression le(String name, E value,
        Predicate<E> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(String name, String value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(String name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(String name, int value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(String name, int value, IntPredicate ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(String name, long value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(String name, long value, LongPredicate ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(String name, double value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(String name, double value, DoublePredicate ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> UserQueryRepositoryConditionGroupExpression lt(String name, E value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> UserQueryRepositoryConditionGroupExpression lt(String name, E value,
        Predicate<E> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(String name, String value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(String name, String value, MatchStrategy matchStrategy,
        Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression logic(LogicOperator operator,
        LogicExpression<?, ?> logicExpression) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression logic(LogicOperator operator,
        Function<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> group) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression and(LogicExpression<?, ?> logicExpression) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression or(LogicExpression<?, ?> logicExpression) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryLocalDateTimeFieldExpression<UserQueryRepositoryConditionGroupExpression,
        UserQueryRepositoryConditionGroupExpression> fieldAsLocalDateTime(String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryLocalTimeFieldExpression<UserQueryRepositoryConditionGroupExpression,
        UserQueryRepositoryConditionGroupExpression> fieldAsLocalTime(String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryLocalDateFieldExpression<UserQueryRepositoryConditionGroupExpression,
        UserQueryRepositoryConditionGroupExpression> fieldAsLocalDate(String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositorySerializableFieldExpression<UserQueryRepositoryConditionGroupExpression,
        UserQueryRepositoryConditionGroupExpression> field(String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RepositoryStringFieldExpression<UserQueryRepositoryConditionGroupExpression,
        UserQueryRepositoryConditionGroupExpression> fieldAsString(String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> RepositoryNumberFieldExpression<N, UserQueryRepositoryConditionGroupExpression,
        UserQueryRepositoryConditionGroupExpression> fieldAsNumber(String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Enum<R>> RepositoryEnumFieldExpression<R, UserQueryRepositoryConditionGroupExpression,
        UserQueryRepositoryConditionGroupExpression> fieldAsEnum(String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> RepositoryDateFieldExpression<D, UserQueryRepositoryConditionGroupExpression,
        UserQueryRepositoryConditionGroupExpression> fieldAsDate(String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression eq(String name, FieldExpression value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression eq(String name, Field value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <G extends GroupExpression<GC, GL>, GC extends ConditionExpression,
        GL extends GroupEndExpression<GC, GL>> G and(G conditionExpression) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <G extends GroupExpression<GC, GL>, GC extends ConditionExpression,
        GL extends GroupEndExpression<GC, GL>> G or(G conditionExpression) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

}
