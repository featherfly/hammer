
package cn.featherfly.hammer.dml.builder.sql.query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

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
import cn.featherfly.hammer.expression.RepositoryConditionGroupLogicExpression;
import cn.featherfly.hammer.expression.condition.RepositoryConditionsGroupExpression;
import cn.featherfly.hammer.expression.condition.property.DateExpression;
import cn.featherfly.hammer.expression.condition.property.EnumExpression;
import cn.featherfly.hammer.expression.condition.property.NumberExpression;
import cn.featherfly.hammer.expression.condition.property.ObjectExpression;
import cn.featherfly.hammer.expression.condition.property.StringExpression;

/**
 * The Class UserQueryRepositoryConditionGroupExpression.
 *
 * @author zhongj
 */
public class UserQueryRepositoryConditionGroupExpression implements
        RepositoryConditionsGroupExpression<UserQueryRepositoryConditionGroupExpression,
                UserQueryRepositoryConditionGroupExpression>,
        RepositoryConditionGroupLogicExpression<UserQueryRepositoryConditionGroupExpression,
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
    public StringExpression<UserQueryRepositoryConditionGroupExpression,
            UserQueryRepositoryConditionGroupExpression> name() {
        return propertyString("name");
    }

    /**
     * Age.
     *
     * @return the number expression
     */
    public NumberExpression<Number, UserQueryRepositoryConditionGroupExpression,
            UserQueryRepositoryConditionGroupExpression> age() {
        return propertyNumber("age");
    }

    /**
     * Pwd.
     *
     * @return the string expression
     */
    public StringExpression<UserQueryRepositoryConditionGroupExpression,
            UserQueryRepositoryConditionGroupExpression> pwd() {
        return propertyString("pwd");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression co(String repository, String name, String value,
            QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression co(int repositoryIndex, String name, String value,
            QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression co(String name, String value, QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression co(SerializableToStringFunction<T> name, String value,
            QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression co(SerializableStringSupplier property,
            QueryPolicy queryPolicy) {

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
    public UserQueryRepositoryConditionGroupExpression ew(String repository, String name, String value,
            QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ew(int repositoryIndex, String name, String value,
            QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ew(String name, String value, QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ew(SerializableToStringFunction<T> name, String value,
            QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ew(SerializableStringSupplier property,
            QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression eq(String repository, String name, Object value,
            QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression eq(int repositoryIndex, String name, Object value,
            QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryRepositoryConditionGroupExpression eq(SerializableFunction<T, R> repository,
            SerializableFunction<T, R> property, R value, QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryRepositoryConditionGroupExpression eq(SerializableSupplier<T> repository,
            SerializableFunction<T, R> property, QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression eq(String name, Object value, QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryRepositoryConditionGroupExpression eq(SerializableFunction<T, R> name, R value,
            QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> UserQueryRepositoryConditionGroupExpression eq(SerializableSupplier<R> property,
            QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression ge(String repository, String name, N value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression ge(String repository, String name, D value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(String repository, String name, LocalTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(String repository, String name, LocalDate value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(String repository, String name, LocalDateTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(String repository, String name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression ge(int repositoryIndex, String name,
            N value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression ge(int repositoryIndex, String name, D value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(int repositoryIndex, String name, LocalTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(int repositoryIndex, String name, LocalDate value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(int repositoryIndex, String name, LocalDateTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(int repositoryIndex, String name, String value) {

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
    public <T, N extends Number> UserQueryRepositoryConditionGroupExpression ge(SerializableToNumberFunction<T, N> name,
            N value) {

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
    public <T, D extends Date> UserQueryRepositoryConditionGroupExpression ge(SerializableToDateFunction<T, D> name,
            D value) {

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
    public <T> UserQueryRepositoryConditionGroupExpression ge(SerializableToLocalTimeFunction<T> name,
            LocalTime value) {

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
    public <T> UserQueryRepositoryConditionGroupExpression ge(SerializableToLocalDateFunction<T> name,
            LocalDate value) {

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
    public <T> UserQueryRepositoryConditionGroupExpression ge(SerializableToLocalDateTimeFunction<T> name,
            LocalDateTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(String name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ge(SerializableToStringFunction<T> name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> UserQueryRepositoryConditionGroupExpression ge(SerializableDateSupplier<R> property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> UserQueryRepositoryConditionGroupExpression ge(SerializableNumberSupplier<R> property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(SerializableLocalDateSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(SerializableLocalTimeSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(SerializableLocalDateTimeSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(SerializableStringSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression gt(String repository, String name, N value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression gt(String repository, String name, D value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(String repository, String name, LocalTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(String repository, String name, LocalDate value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(String repository, String name, LocalDateTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(String repository, String name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression gt(int repositoryIndex, String name,
            N value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression gt(int repositoryIndex, String name, D value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(int repositoryIndex, String name, LocalTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(int repositoryIndex, String name, LocalDate value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(int repositoryIndex, String name, LocalDateTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(int repositoryIndex, String name, String value) {

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
    public <T, N extends Number> UserQueryRepositoryConditionGroupExpression gt(SerializableToNumberFunction<T, N> name,
            N value) {

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
    public <T, D extends Date> UserQueryRepositoryConditionGroupExpression gt(SerializableToDateFunction<T, D> name,
            D value) {

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
    public <T> UserQueryRepositoryConditionGroupExpression gt(SerializableToLocalTimeFunction<T> name,
            LocalTime value) {

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
    public <T> UserQueryRepositoryConditionGroupExpression gt(SerializableToLocalDateFunction<T> name,
            LocalDate value) {

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
    public <T> UserQueryRepositoryConditionGroupExpression gt(SerializableToLocalDateTimeFunction<T> name,
            LocalDateTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(String name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression gt(SerializableToStringFunction<T> name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> UserQueryRepositoryConditionGroupExpression gt(SerializableNumberSupplier<R> property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> UserQueryRepositoryConditionGroupExpression gt(SerializableDateSupplier<R> property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(SerializableLocalDateSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(SerializableLocalTimeSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(SerializableLocalDateTimeSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(SerializableStringSupplier property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression in(String repository, String name, Object value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression in(int repositoryIndex, String name, Object value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression in(String name, Object value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryRepositoryConditionGroupExpression in(SerializableFunction<T, R> name, Object value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> UserQueryRepositoryConditionGroupExpression in(SerializableSupplier<R> property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression inn(String repository, String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression inn(int repositoryIndex, String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression inn(String repository, String name, Boolean value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression inn(int repositoryIndex, String name, Boolean value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression inn(String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryRepositoryConditionGroupExpression inn(SerializableFunction<T, R> name) {

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
    public <T, R> UserQueryRepositoryConditionGroupExpression inn(SerializableFunction<T, R> name, Boolean value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression isn(String repository, String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression isn(int repositoryIndex, String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression isn(String repository, String name, Boolean value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression isn(int repositoryIndex, String name, Boolean value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression isn(String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryRepositoryConditionGroupExpression isn(SerializableFunction<T, R> name) {

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
    public <T, R> UserQueryRepositoryConditionGroupExpression isn(SerializableFunction<T, R> name, Boolean value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression le(String repository, String name, N value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression le(String repository, String name, D value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(String repository, String name, LocalTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(String repository, String name, LocalDate value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(String repository, String name, LocalDateTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(String repository, String name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression le(int repositoryIndex, String name,
            N value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression le(int repositoryIndex, String name, D value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(int repositoryIndex, String name, LocalTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(int repositoryIndex, String name, LocalDate value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(int repositoryIndex, String name, LocalDateTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(int repositoryIndex, String name, String value) {

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
    public <N extends Number> UserQueryRepositoryConditionGroupExpression lt(String repository, String name, N value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression lt(String repository, String name, D value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(String repository, String name, LocalTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(String repository, String name, LocalDate value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(String repository, String name, LocalDateTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(String repository, String name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression lt(int repositoryIndex, String name,
            N value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression lt(int repositoryIndex, String name, D value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(int repositoryIndex, String name, LocalTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(int repositoryIndex, String name, LocalDate value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(int repositoryIndex, String name, LocalDateTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(int repositoryIndex, String name, String value) {

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
    public UserQueryRepositoryConditionGroupExpression ne(String repository, String name, Object value,
            QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ne(int repositoryIndex, String name, Object value,
            QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryRepositoryConditionGroupExpression ne(SerializableFunction<T, R> repository,
            SerializableFunction<T, R> property, R value, QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryRepositoryConditionGroupExpression ne(SerializableSupplier<T> repository,
            SerializableFunction<T, R> property, QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ne(String name, Object value, QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryRepositoryConditionGroupExpression ne(SerializableFunction<T, R> name, R value,
            QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> UserQueryRepositoryConditionGroupExpression ne(SerializableSupplier<R> property,
            QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nin(String repository, String name, Object value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nin(int repositoryIndex, String name, Object value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nin(String name, Object value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryRepositoryConditionGroupExpression nin(SerializableFunction<T, R> name, Object value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> UserQueryRepositoryConditionGroupExpression nin(SerializableSupplier<R> property) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression sw(String repository, String name, String value,
            QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression sw(int repositoryIndex, String name, String value,
            QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression sw(String name, String value, QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression sw(SerializableToStringFunction<T> name, String value,
            QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression sw(SerializableStringSupplier property,
            QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lk(String repository, String name, String value,
            QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lk(int repositoryIndex, String name, String value,
            QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lk(String name, String value, QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression lk(SerializableToStringFunction<T> name, String value,
            QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lk(SerializableStringSupplier property,
            QueryPolicy queryPolicy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ObjectExpression<UserQueryRepositoryConditionGroupExpression,
            UserQueryRepositoryConditionGroupExpression> property(String repository, String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StringExpression<UserQueryRepositoryConditionGroupExpression,
            UserQueryRepositoryConditionGroupExpression> propertyString(String repository, String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> NumberExpression<N, UserQueryRepositoryConditionGroupExpression,
            UserQueryRepositoryConditionGroupExpression> propertyNumber(String repository, String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> DateExpression<D, UserQueryRepositoryConditionGroupExpression,
            UserQueryRepositoryConditionGroupExpression> propertyDate(String repository, String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> EnumExpression<E, UserQueryRepositoryConditionGroupExpression,
            UserQueryRepositoryConditionGroupExpression> propertyEnum(String repository, String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ObjectExpression<UserQueryRepositoryConditionGroupExpression,
            UserQueryRepositoryConditionGroupExpression> property(int repositoryIndex, String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StringExpression<UserQueryRepositoryConditionGroupExpression,
            UserQueryRepositoryConditionGroupExpression> propertyString(int repositoryIndex, String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> NumberExpression<N, UserQueryRepositoryConditionGroupExpression,
            UserQueryRepositoryConditionGroupExpression> propertyNumber(int repositoryIndex, String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> DateExpression<D, UserQueryRepositoryConditionGroupExpression,
            UserQueryRepositoryConditionGroupExpression> propertyDate(int repositoryIndex, String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E extends Enum<E>> EnumExpression<E, UserQueryRepositoryConditionGroupExpression,
            UserQueryRepositoryConditionGroupExpression> propertyEnum(int repositoryIndex, String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ObjectExpression<UserQueryRepositoryConditionGroupExpression,
            UserQueryRepositoryConditionGroupExpression> property(String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StringExpression<UserQueryRepositoryConditionGroupExpression,
            UserQueryRepositoryConditionGroupExpression> propertyString(String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> NumberExpression<N, UserQueryRepositoryConditionGroupExpression,
            UserQueryRepositoryConditionGroupExpression> propertyNumber(String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> DateExpression<D, UserQueryRepositoryConditionGroupExpression,
            UserQueryRepositoryConditionGroupExpression> propertyDate(String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Enum<R>> EnumExpression<R, UserQueryRepositoryConditionGroupExpression,
            UserQueryRepositoryConditionGroupExpression> propertyEnum(String name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> ObjectExpression<UserQueryRepositoryConditionGroupExpression,
            UserQueryRepositoryConditionGroupExpression> property(SerializableFunction<T, R> name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> StringExpression<UserQueryRepositoryConditionGroupExpression,
            UserQueryRepositoryConditionGroupExpression> property(SerializableToStringFunction<T> name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Number> NumberExpression<R, UserQueryRepositoryConditionGroupExpression,
            UserQueryRepositoryConditionGroupExpression> property(SerializableToNumberFunction<T, R> name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Date> DateExpression<R, UserQueryRepositoryConditionGroupExpression,
            UserQueryRepositoryConditionGroupExpression> property(SerializableToDateFunction<T, R> name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R extends Enum<R>> EnumExpression<R, UserQueryRepositoryConditionGroupExpression,
            UserQueryRepositoryConditionGroupExpression> property(SerializableToEnumFunction<T, R> name) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression expression(String expression, Map<String, Object> params) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression expression(String expression, Object... params) {

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

}
