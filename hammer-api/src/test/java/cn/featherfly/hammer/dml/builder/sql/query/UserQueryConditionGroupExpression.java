
package cn.featherfly.hammer.dml.builder.sql.query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.lang.function.SerializableDateSupplier;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableLocalDateSupplier;
import cn.featherfly.common.lang.function.SerializableLocalDateTimeSupplier;
import cn.featherfly.common.lang.function.SerializableLocalTimeSupplier;
import cn.featherfly.common.lang.function.SerializableNumberSupplier;
import cn.featherfly.common.lang.function.SerializableStringSupplier;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.lang.function.SerializableToDateFunction;
import cn.featherfly.common.lang.function.SerializableToEnumFunction;
import cn.featherfly.common.lang.function.SerializableToLocalDateFunction;
import cn.featherfly.common.lang.function.SerializableToLocalDateTimeFunction;
import cn.featherfly.common.lang.function.SerializableToLocalTimeFunction;
import cn.featherfly.common.lang.function.SerializableToNumberFunction;
import cn.featherfly.common.lang.function.SerializableToStringFunction;
import cn.featherfly.common.operator.LogicOperator;
import cn.featherfly.common.operator.QueryOperator.QueryPolicy;
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
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression co(String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression co(SerializableToStringFunction<T> name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression co(SerializableStringSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression ew(String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression ew(SerializableToStringFunction<T> name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression ew(SerializableStringSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression eq(String name, Object value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryConditionGroupExpression eq(SerializableFunction<T, R> name, R value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> UserQueryConditionGroupExpression eq(SerializableSupplier<R> property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryConditionGroupExpression ge(String name, N value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> UserQueryConditionGroupExpression ge(SerializableToNumberFunction<T, N> name,
            N value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryConditionGroupExpression ge(String name, D value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> UserQueryConditionGroupExpression ge(SerializableToDateFunction<T, D> name, D value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression ge(String name, LocalTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression ge(SerializableToLocalTimeFunction<T> name, LocalTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression ge(String name, LocalDate value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression ge(SerializableToLocalDateFunction<T> name, LocalDate value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression ge(String name, LocalDateTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression ge(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression ge(String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression ge(SerializableToStringFunction<T> name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> UserQueryConditionGroupExpression ge(SerializableDateSupplier<R> property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> UserQueryConditionGroupExpression ge(SerializableNumberSupplier<R> property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression ge(SerializableLocalDateSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression ge(SerializableLocalTimeSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression ge(SerializableLocalDateTimeSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression ge(SerializableStringSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryConditionGroupExpression gt(String name, N value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> UserQueryConditionGroupExpression gt(SerializableToNumberFunction<T, N> name,
            N value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryConditionGroupExpression gt(String name, D value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> UserQueryConditionGroupExpression gt(SerializableToDateFunction<T, D> name, D value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression gt(String name, LocalTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression gt(SerializableToLocalTimeFunction<T> name, LocalTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression gt(String name, LocalDate value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression gt(SerializableToLocalDateFunction<T> name, LocalDate value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression gt(String name, LocalDateTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression gt(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression gt(String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression gt(SerializableToStringFunction<T> name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> UserQueryConditionGroupExpression gt(SerializableNumberSupplier<R> property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> UserQueryConditionGroupExpression gt(SerializableDateSupplier<R> property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression gt(SerializableLocalDateSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression gt(SerializableLocalTimeSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression gt(SerializableLocalDateTimeSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression gt(SerializableStringSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression in(String name, Object value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryConditionGroupExpression in(SerializableFunction<T, R> name, Object value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> UserQueryConditionGroupExpression in(SerializableSupplier<R> property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression inn(String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryConditionGroupExpression inn(SerializableFunction<T, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression isn(String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryConditionGroupExpression isn(SerializableFunction<T, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryConditionGroupExpression le(String name, N value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> UserQueryConditionGroupExpression le(SerializableToNumberFunction<T, N> name,
            N value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryConditionGroupExpression le(String name, D value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> UserQueryConditionGroupExpression le(SerializableToDateFunction<T, D> name, D value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression le(String name, LocalTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression le(SerializableToLocalTimeFunction<T> name, LocalTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression le(String name, LocalDate value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression le(SerializableToLocalDateFunction<T> name, LocalDate value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression le(String name, LocalDateTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression le(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression le(String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression le(SerializableToStringFunction<T> name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> UserQueryConditionGroupExpression le(SerializableDateSupplier<R> property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> UserQueryConditionGroupExpression le(SerializableNumberSupplier<R> property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression le(SerializableLocalDateSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression le(SerializableLocalTimeSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression le(SerializableLocalDateTimeSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression le(SerializableStringSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryConditionGroupExpression lt(String name, N value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> UserQueryConditionGroupExpression lt(SerializableToNumberFunction<T, N> name,
            N value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryConditionGroupExpression lt(String name, D value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> UserQueryConditionGroupExpression lt(SerializableToDateFunction<T, D> name, D value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression lt(String name, LocalTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression lt(SerializableToLocalTimeFunction<T> name, LocalTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression lt(String name, LocalDate value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression lt(SerializableToLocalDateFunction<T> name, LocalDate value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression lt(String name, LocalDateTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression lt(SerializableToLocalDateTimeFunction<T> name, LocalDateTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression lt(String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression lt(SerializableToStringFunction<T> name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> UserQueryConditionGroupExpression lt(SerializableDateSupplier<R> property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> UserQueryConditionGroupExpression lt(SerializableNumberSupplier<R> property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression lt(SerializableLocalDateSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression lt(SerializableLocalTimeSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression lt(SerializableLocalDateTimeSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression lt(SerializableStringSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression ne(String name, Object value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryConditionGroupExpression ne(SerializableFunction<T, R> name, R value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> UserQueryConditionGroupExpression ne(SerializableSupplier<R> property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression nin(String name, Object value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryConditionGroupExpression nin(SerializableFunction<T, R> name, Object value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> UserQueryConditionGroupExpression nin(SerializableSupplier<R> property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression sw(String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression sw(SerializableToStringFunction<T> name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression sw(SerializableStringSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ObjectExpression<UserQueryConditionGroupExpression, UserQueryConditionGroupExpression> property(
            String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StringExpression<UserQueryConditionGroupExpression, UserQueryConditionGroupExpression> propertyString(
            String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberExpression<Number, UserQueryConditionGroupExpression,
            UserQueryConditionGroupExpression> propertyNumber(String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DateExpression<Date, UserQueryConditionGroupExpression, UserQueryConditionGroupExpression> propertyDate(
            String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> ObjectExpression<UserQueryConditionGroupExpression, UserQueryConditionGroupExpression> property(
            SerializableFunction<T, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> StringExpression<UserQueryConditionGroupExpression, UserQueryConditionGroupExpression> property(
            SerializableToStringFunction<T> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Number> NumberExpression<R, UserQueryConditionGroupExpression,
            UserQueryConditionGroupExpression> property(SerializableToNumberFunction<T, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Date> DateExpression<R, UserQueryConditionGroupExpression,
            UserQueryConditionGroupExpression> property(SerializableToDateFunction<T, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression endGroup() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression and() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression or() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression lk(String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression lk(SerializableToStringFunction<T> name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression lk(SerializableStringSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression inn(String name, Boolean value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryConditionGroupExpression inn(SerializableFunction<T, R> name, Boolean value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression isn(String name, Boolean value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryConditionGroupExpression isn(SerializableFunction<T, R> name, Boolean value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Predicate<Object> getIgnoreStrategy() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression logic(LogicOperator operator) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression expression(String expression) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression expression(String expression, Map<String, Object> params) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression expression(String expression, Object... params) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression eq(String name, Object value, QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryConditionGroupExpression eq(SerializableFunction<T, R> name, R value,
            QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> UserQueryConditionGroupExpression eq(SerializableSupplier<R> property, QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression ne(String name, Object value, QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryConditionGroupExpression ne(SerializableFunction<T, R> name, R value,
            QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> UserQueryConditionGroupExpression ne(SerializableSupplier<R> property, QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression lk(String name, String value, QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression lk(SerializableToStringFunction<T> name, String value,
            QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression lk(SerializableStringSupplier property, QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression co(String name, String value, QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression co(SerializableToStringFunction<T> name, String value,
            QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression co(SerializableStringSupplier property, QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression ew(String name, String value, QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression ew(SerializableToStringFunction<T> name, String value,
            QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression ew(SerializableStringSupplier property, QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression sw(String name, String value, QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryConditionGroupExpression sw(SerializableToStringFunction<T> name, String value,
            QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression sw(SerializableStringSupplier property, QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression group(
            Function<UserQueryConditionGroupExpression, UserQueryConditionGroupExpression> group) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression and(
            Function<UserQueryConditionGroupExpression, UserQueryConditionGroupExpression> group) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression or(
            Function<UserQueryConditionGroupExpression, UserQueryConditionGroupExpression> group) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Enum<R>> EnumExpression<R, UserQueryConditionGroupExpression,
            UserQueryConditionGroupExpression> propertyEnum(String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Enum<R>> EnumExpression<R, UserQueryConditionGroupExpression,
            UserQueryConditionGroupExpression> property(SerializableToEnumFunction<T, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression setIgnoreStrategy(Predicate<?> ignoreStrategy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int execute() {
        // YUFEI_TODO Auto-generated method stub
        return 0;
    }

}
