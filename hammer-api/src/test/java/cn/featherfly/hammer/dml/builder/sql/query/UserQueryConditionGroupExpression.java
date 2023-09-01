
package cn.featherfly.hammer.dml.builder.sql.query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.function.serializable.SerializableDateSupplier;
import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.function.serializable.SerializableLocalDateSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalDateTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableLocalTimeSupplier;
import cn.featherfly.common.function.serializable.SerializableNumberSupplier;
import cn.featherfly.common.function.serializable.SerializableStringSupplier;
import cn.featherfly.common.function.serializable.SerializableSupplier;
import cn.featherfly.common.function.serializable.SerializableToDateFunction;
import cn.featherfly.common.function.serializable.SerializableToEnumFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToLocalTimeFunction;
import cn.featherfly.common.function.serializable.SerializableToNumberFunction;
import cn.featherfly.common.function.serializable.SerializableToStringFunction;
import cn.featherfly.common.operator.LogicOperator;
import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.hammer.expression.condition.property.DateExpression;
import cn.featherfly.hammer.expression.condition.property.EnumExpression;
import cn.featherfly.hammer.expression.condition.property.NumberExpression;
import cn.featherfly.hammer.expression.condition.property.ObjectExpression;
import cn.featherfly.hammer.expression.condition.property.StringExpression;
import cn.featherfly.hammer.expression.execute.ExecutableConditionGroupExpression;
import cn.featherfly.hammer.expression.execute.ExecutableConditionGroupLogicExpression;

/**
 * The Class UserQueryConditionGroupExpression.
 *
 * @author zhongj
 */
public class UserQueryConditionGroupExpression implements
        ExecutableConditionGroupExpression<UserQueryConditionGroupExpression, UserQueryConditionGroupExpression>,
        ExecutableConditionGroupLogicExpression<UserQueryConditionGroupExpression, UserQueryConditionGroupExpression> {

    /**
     * Instantiates a new user query condition group expression.
     */
    public UserQueryConditionGroupExpression() {
    }

    /**
     * Name.
     *
     * @return the string expression
     */
    public StringExpression<UserQueryConditionGroupExpression, UserQueryConditionGroupExpression> name() {
        return propertyString("name");
    }

    /**
     * Age.
     *
     * @return the number expression
     */
    public NumberExpression<Number, UserQueryConditionGroupExpression, UserQueryConditionGroupExpression> age() {
        return propertyNumber("age");
    }

    /**
     * Pwd.
     *
     * @return the string expression
     */
    public StringExpression<UserQueryConditionGroupExpression, UserQueryConditionGroupExpression> pwd() {
        return propertyString("pwd");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression group() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression co(String name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression co(SerializableToStringFunction<T> name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression co(SerializableStringSupplier property) {

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
    public UserQueryConditionGroupExpression ew(String name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression ew(SerializableToStringFunction<T> name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression ew(SerializableStringSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression eq(String name, Object value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryConditionGroupExpression eq(SerializableFunction<T, R> name, R value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> UserQueryConditionGroupExpression eq(SerializableSupplier<R> property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryConditionGroupExpression ge(String name, N value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> UserQueryConditionGroupExpression ge(SerializableToNumberFunction<T, N> name,
            N value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryConditionGroupExpression ge(String name, D value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> UserQueryConditionGroupExpression ge(SerializableToDateFunction<T, D> name, D value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression ge(String name, LocalTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression ge(SerializableToLocalTimeFunction<T> name, LocalTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression ge(String name, LocalDate value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression ge(SerializableToLocalDateFunction<T> name, LocalDate value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression ge(String name, LocalDateTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression ge(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression ge(String name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression ge(SerializableToStringFunction<T> name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> UserQueryConditionGroupExpression ge(SerializableDateSupplier<R> property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> UserQueryConditionGroupExpression ge(SerializableNumberSupplier<R> property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression ge(SerializableLocalDateSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression ge(SerializableLocalTimeSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression ge(SerializableLocalDateTimeSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression ge(SerializableStringSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryConditionGroupExpression gt(String name, N value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> UserQueryConditionGroupExpression gt(SerializableToNumberFunction<T, N> name,
            N value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryConditionGroupExpression gt(String name, D value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> UserQueryConditionGroupExpression gt(SerializableToDateFunction<T, D> name, D value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression gt(String name, LocalTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression gt(SerializableToLocalTimeFunction<T> name, LocalTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression gt(String name, LocalDate value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression gt(SerializableToLocalDateFunction<T> name, LocalDate value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression gt(String name, LocalDateTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression gt(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression gt(String name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression gt(SerializableToStringFunction<T> name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> UserQueryConditionGroupExpression gt(SerializableNumberSupplier<R> property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> UserQueryConditionGroupExpression gt(SerializableDateSupplier<R> property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression gt(SerializableLocalDateSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression gt(SerializableLocalTimeSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression gt(SerializableLocalDateTimeSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression gt(SerializableStringSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression in(String name, Object value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryConditionGroupExpression in(SerializableFunction<T, R> name, Object value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> UserQueryConditionGroupExpression in(SerializableSupplier<R> property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression inn(String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryConditionGroupExpression inn(SerializableFunction<T, R> name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression isn(String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryConditionGroupExpression isn(SerializableFunction<T, R> name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryConditionGroupExpression le(String name, N value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> UserQueryConditionGroupExpression le(SerializableToNumberFunction<T, N> name,
            N value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryConditionGroupExpression le(String name, D value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> UserQueryConditionGroupExpression le(SerializableToDateFunction<T, D> name, D value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression le(String name, LocalTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression le(SerializableToLocalTimeFunction<T> name, LocalTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression le(String name, LocalDate value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression le(SerializableToLocalDateFunction<T> name, LocalDate value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression le(String name, LocalDateTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression le(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression le(String name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression le(SerializableToStringFunction<T> name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> UserQueryConditionGroupExpression le(SerializableDateSupplier<R> property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> UserQueryConditionGroupExpression le(SerializableNumberSupplier<R> property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression le(SerializableLocalDateSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression le(SerializableLocalTimeSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression le(SerializableLocalDateTimeSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression le(SerializableStringSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryConditionGroupExpression lt(String name, N value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> UserQueryConditionGroupExpression lt(SerializableToNumberFunction<T, N> name,
            N value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryConditionGroupExpression lt(String name, D value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> UserQueryConditionGroupExpression lt(SerializableToDateFunction<T, D> name, D value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression lt(String name, LocalTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression lt(SerializableToLocalTimeFunction<T> name, LocalTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression lt(String name, LocalDate value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression lt(SerializableToLocalDateFunction<T> name, LocalDate value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression lt(String name, LocalDateTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression lt(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression lt(String name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression lt(SerializableToStringFunction<T> name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> UserQueryConditionGroupExpression lt(SerializableDateSupplier<R> property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> UserQueryConditionGroupExpression lt(SerializableNumberSupplier<R> property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression lt(SerializableLocalDateSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression lt(SerializableLocalTimeSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression lt(SerializableLocalDateTimeSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression lt(SerializableStringSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression ne(String name, Object value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryConditionGroupExpression ne(SerializableFunction<T, R> name, R value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> UserQueryConditionGroupExpression ne(SerializableSupplier<R> property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression nin(String name, Object value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryConditionGroupExpression nin(SerializableFunction<T, R> name, Object value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> UserQueryConditionGroupExpression nin(SerializableSupplier<R> property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression sw(String name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression sw(SerializableToStringFunction<T> name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression sw(SerializableStringSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ObjectExpression<UserQueryConditionGroupExpression, UserQueryConditionGroupExpression> property(
            String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StringExpression<UserQueryConditionGroupExpression, UserQueryConditionGroupExpression> propertyString(
            String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberExpression<Number, UserQueryConditionGroupExpression,
            UserQueryConditionGroupExpression> propertyNumber(String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DateExpression<Date, UserQueryConditionGroupExpression, UserQueryConditionGroupExpression> propertyDate(
            String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> ObjectExpression<UserQueryConditionGroupExpression, UserQueryConditionGroupExpression> property(
            SerializableFunction<T, R> name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> StringExpression<UserQueryConditionGroupExpression, UserQueryConditionGroupExpression> property(
            SerializableToStringFunction<T> name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Number> NumberExpression<R, UserQueryConditionGroupExpression,
            UserQueryConditionGroupExpression> property(SerializableToNumberFunction<T, R> name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Date> DateExpression<R, UserQueryConditionGroupExpression,
            UserQueryConditionGroupExpression> property(SerializableToDateFunction<T, R> name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression endGroup() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression and() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression or() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression lk(String name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression lk(SerializableToStringFunction<T> name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression lk(SerializableStringSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression inn(String name, Boolean value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryConditionGroupExpression inn(SerializableFunction<T, R> name, Boolean value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression isn(String name, Boolean value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryConditionGroupExpression isn(SerializableFunction<T, R> name, Boolean value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Predicate<Object> getIgnoreStrategy() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression logic(LogicOperator operator) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression expression(String expression) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression expression(String expression, Map<String, Object> params) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression expression(String expression, Object... params) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression eq(String name, Object value, MatchStrategy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryConditionGroupExpression eq(SerializableFunction<T, R> name, R value,
            MatchStrategy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> UserQueryConditionGroupExpression eq(SerializableSupplier<R> property, MatchStrategy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression ne(String name, Object value, MatchStrategy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryConditionGroupExpression ne(SerializableFunction<T, R> name, R value,
            MatchStrategy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> UserQueryConditionGroupExpression ne(SerializableSupplier<R> property, MatchStrategy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression lk(String name, String value, MatchStrategy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression lk(SerializableToStringFunction<T> name, String value,
            MatchStrategy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression lk(SerializableStringSupplier property, MatchStrategy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression co(String name, String value, MatchStrategy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression co(SerializableToStringFunction<T> name, String value,
            MatchStrategy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression co(SerializableStringSupplier property, MatchStrategy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression ew(String name, String value, MatchStrategy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression ew(SerializableToStringFunction<T> name, String value,
            MatchStrategy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression ew(SerializableStringSupplier property, MatchStrategy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression sw(String name, String value, MatchStrategy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression sw(SerializableToStringFunction<T> name, String value,
            MatchStrategy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression sw(SerializableStringSupplier property, MatchStrategy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression group(
            Function<UserQueryConditionGroupExpression, UserQueryConditionGroupExpression> group) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression and(
            Function<UserQueryConditionGroupExpression, UserQueryConditionGroupExpression> group) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression or(
            Function<UserQueryConditionGroupExpression, UserQueryConditionGroupExpression> group) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Enum<R>> EnumExpression<R, UserQueryConditionGroupExpression,
            UserQueryConditionGroupExpression> propertyEnum(String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Enum<R>> EnumExpression<R, UserQueryConditionGroupExpression,
            UserQueryConditionGroupExpression> property(SerializableToEnumFunction<T, R> name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression setIgnoreStrategy(Predicate<?> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute() {

        return 0;
    }

}
