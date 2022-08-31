
package cn.featherfly.hammer.dml.builder.sql.query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import cn.featherfly.common.lang.function.DateSupplier;
import cn.featherfly.common.lang.function.LocalDateSupplier;
import cn.featherfly.common.lang.function.LocalDateTimeSupplier;
import cn.featherfly.common.lang.function.LocalTimeSupplier;
import cn.featherfly.common.lang.function.NumberSupplier;
import cn.featherfly.common.lang.function.ReturnDateFunction;
import cn.featherfly.common.lang.function.ReturnEnumFunction;
import cn.featherfly.common.lang.function.ReturnLocalDateFunction;
import cn.featherfly.common.lang.function.ReturnLocalDateTimeFunction;
import cn.featherfly.common.lang.function.ReturnLocalTimeFunction;
import cn.featherfly.common.lang.function.ReturnNumberFunction;
import cn.featherfly.common.lang.function.ReturnStringFunction;
import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.lang.function.SerializableSupplier;
import cn.featherfly.common.lang.function.StringSupplier;
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
        RepositoryConditionsGroupExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression>,
        RepositoryConditionGroupLogicExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> {

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
    public StringExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> name() {
        return propertyString("name");
    }

    /**
     * Age.
     *
     * @return the number expression
     */
    public NumberExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> age() {
        return propertyNumber("age");
    }

    /**
     * Pwd.
     *
     * @return the string expression
     */
    public StringExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> pwd() {
        return propertyString("pwd");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression co(String repository, String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression co(Class<T> repository, String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression co(int repositoryIndex, String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression co(String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression co(ReturnStringFunction<T> name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression co(StringSupplier property) {
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
    public UserQueryRepositoryConditionGroupExpression ew(String repository, String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ew(Class<T> repository, String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ew(int repositoryIndex, String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ew(String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ew(ReturnStringFunction<T> name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ew(StringSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression eq(String repository, String name, Object value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression eq(Class<T> repository, String name, Object value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression eq(int repositoryIndex, String name, Object value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression eq(String name, Object value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryRepositoryConditionGroupExpression eq(SerializableFunction<T, R> name, R value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> UserQueryRepositoryConditionGroupExpression eq(SerializableSupplier<R> property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression ge(String repository, String name, N value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression ge(String repository, String name, D value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(String repository, String name, LocalTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(String repository, String name, LocalDate value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(String repository, String name, LocalDateTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(String repository, String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number, T> UserQueryRepositoryConditionGroupExpression ge(Class<T> repository, String name,
            N value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date, T> UserQueryRepositoryConditionGroupExpression ge(Class<T> repository, String name,
            D value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ge(Class<T> repository, String name, LocalTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ge(Class<T> repository, String name, LocalDate value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ge(Class<T> repository, String name, LocalDateTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ge(Class<T> repository, String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression ge(int repositoryIndex, String name,
            N value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression ge(int repositoryIndex, String name, D value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(int repositoryIndex, String name, LocalTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(int repositoryIndex, String name, LocalDate value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(int repositoryIndex, String name, LocalDateTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(int repositoryIndex, String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression ge(String name, N value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> UserQueryRepositoryConditionGroupExpression ge(ReturnNumberFunction<T, N> name,
            N value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression ge(String name, D value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> UserQueryRepositoryConditionGroupExpression ge(ReturnDateFunction<T, D> name, D value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(String name, LocalTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ge(ReturnLocalTimeFunction<T> name, LocalTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(String name, LocalDate value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ge(ReturnLocalDateFunction<T> name, LocalDate value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(String name, LocalDateTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ge(ReturnLocalDateTimeFunction<T> name,
            LocalDateTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ge(ReturnStringFunction<T> name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> UserQueryRepositoryConditionGroupExpression ge(DateSupplier<R> property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> UserQueryRepositoryConditionGroupExpression ge(NumberSupplier<R> property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(LocalDateSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(LocalTimeSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(LocalDateTimeSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ge(StringSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression gt(String repository, String name, N value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression gt(String repository, String name, D value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(String repository, String name, LocalTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(String repository, String name, LocalDate value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(String repository, String name, LocalDateTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(String repository, String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number, T> UserQueryRepositoryConditionGroupExpression gt(Class<T> repository, String name,
            N value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date, T> UserQueryRepositoryConditionGroupExpression gt(Class<T> repository, String name,
            D value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression gt(Class<T> repository, String name, LocalTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression gt(Class<T> repository, String name, LocalDate value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression gt(Class<T> repository, String name, LocalDateTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression gt(Class<T> repository, String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression gt(int repositoryIndex, String name,
            N value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression gt(int repositoryIndex, String name, D value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(int repositoryIndex, String name, LocalTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(int repositoryIndex, String name, LocalDate value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(int repositoryIndex, String name, LocalDateTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(int repositoryIndex, String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression gt(String name, N value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> UserQueryRepositoryConditionGroupExpression gt(ReturnNumberFunction<T, N> name,
            N value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression gt(String name, D value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> UserQueryRepositoryConditionGroupExpression gt(ReturnDateFunction<T, D> name, D value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(String name, LocalTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression gt(ReturnLocalTimeFunction<T> name, LocalTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(String name, LocalDate value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression gt(ReturnLocalDateFunction<T> name, LocalDate value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(String name, LocalDateTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression gt(ReturnLocalDateTimeFunction<T> name,
            LocalDateTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression gt(ReturnStringFunction<T> name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> UserQueryRepositoryConditionGroupExpression gt(NumberSupplier<R> property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> UserQueryRepositoryConditionGroupExpression gt(DateSupplier<R> property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(LocalDateSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(LocalTimeSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(LocalDateTimeSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression gt(StringSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression in(String repository, String name, Object value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression in(Class<T> repository, String name, Object value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression in(int repositoryIndex, String name, Object value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression in(String name, Object value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryRepositoryConditionGroupExpression in(SerializableFunction<T, R> name, Object value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> UserQueryRepositoryConditionGroupExpression in(SerializableSupplier<R> property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression inn(String repository, String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression inn(Class<T> repository, String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression inn(int repositoryIndex, String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression inn(String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryRepositoryConditionGroupExpression inn(SerializableFunction<T, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression isn(String repository, String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression isn(Class<T> repository, String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression isn(int repositoryIndex, String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression isn(String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryRepositoryConditionGroupExpression isn(SerializableFunction<T, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression le(String repository, String name, N value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression le(String repository, String name, D value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(String repository, String name, LocalTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(String repository, String name, LocalDate value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(String repository, String name, LocalDateTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(String repository, String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number, T> UserQueryRepositoryConditionGroupExpression le(Class<T> repository, String name,
            N value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date, T> UserQueryRepositoryConditionGroupExpression le(Class<T> repository, String name,
            D value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression le(Class<T> repository, String name, LocalTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression le(Class<T> repository, String name, LocalDate value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression le(Class<T> repository, String name, LocalDateTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression le(Class<T> repository, String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression le(int repositoryIndex, String name,
            N value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression le(int repositoryIndex, String name, D value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(int repositoryIndex, String name, LocalTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(int repositoryIndex, String name, LocalDate value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(int repositoryIndex, String name, LocalDateTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(int repositoryIndex, String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression le(String name, N value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> UserQueryRepositoryConditionGroupExpression le(ReturnNumberFunction<T, N> name,
            N value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression le(String name, D value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> UserQueryRepositoryConditionGroupExpression le(ReturnDateFunction<T, D> name, D value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(String name, LocalTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression le(ReturnLocalTimeFunction<T> name, LocalTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(String name, LocalDate value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression le(ReturnLocalDateFunction<T> name, LocalDate value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(String name, LocalDateTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression le(ReturnLocalDateTimeFunction<T> name,
            LocalDateTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression le(ReturnStringFunction<T> name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> UserQueryRepositoryConditionGroupExpression le(DateSupplier<R> property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> UserQueryRepositoryConditionGroupExpression le(NumberSupplier<R> property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(LocalDateSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(LocalTimeSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(LocalDateTimeSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression le(StringSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression lt(String repository, String name, N value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression lt(String repository, String name, D value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(String repository, String name, LocalTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(String repository, String name, LocalDate value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(String repository, String name, LocalDateTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(String repository, String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number, T> UserQueryRepositoryConditionGroupExpression lt(Class<T> repository, String name,
            N value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date, T> UserQueryRepositoryConditionGroupExpression lt(Class<T> repository, String name,
            D value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression lt(Class<T> repository, String name, LocalTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression lt(Class<T> repository, String name, LocalDate value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression lt(Class<T> repository, String name, LocalDateTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression lt(Class<T> repository, String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression lt(int repositoryIndex, String name,
            N value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression lt(int repositoryIndex, String name, D value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(int repositoryIndex, String name, LocalTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(int repositoryIndex, String name, LocalDate value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(int repositoryIndex, String name, LocalDateTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(int repositoryIndex, String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> UserQueryRepositoryConditionGroupExpression lt(String name, N value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, N extends Number> UserQueryRepositoryConditionGroupExpression lt(ReturnNumberFunction<T, N> name,
            N value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> UserQueryRepositoryConditionGroupExpression lt(String name, D value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, D extends Date> UserQueryRepositoryConditionGroupExpression lt(ReturnDateFunction<T, D> name, D value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(String name, LocalTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression lt(ReturnLocalTimeFunction<T> name, LocalTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(String name, LocalDate value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression lt(ReturnLocalDateFunction<T> name, LocalDate value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(String name, LocalDateTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression lt(ReturnLocalDateTimeFunction<T> name,
            LocalDateTime value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression lt(ReturnStringFunction<T> name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Date> UserQueryRepositoryConditionGroupExpression lt(DateSupplier<R> property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R extends Number> UserQueryRepositoryConditionGroupExpression lt(NumberSupplier<R> property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(LocalDateSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(LocalTimeSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(LocalDateTimeSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lt(StringSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ne(String repository, String name, Object value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ne(Class<T> repository, String name, Object value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ne(int repositoryIndex, String name, Object value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ne(String name, Object value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryRepositoryConditionGroupExpression ne(SerializableFunction<T, R> name, R value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> UserQueryRepositoryConditionGroupExpression ne(SerializableSupplier<R> property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nin(String repository, String name, Object value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression nin(Class<T> repository, String name, Object value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nin(int repositoryIndex, String name, Object value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression nin(String name, Object value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryRepositoryConditionGroupExpression nin(SerializableFunction<T, R> name, Object value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> UserQueryRepositoryConditionGroupExpression nin(SerializableSupplier<R> property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression sw(String repository, String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression sw(Class<T> repository, String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression sw(int repositoryIndex, String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression sw(String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression sw(ReturnStringFunction<T> name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression sw(StringSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ObjectExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> property(
            String repository, String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StringExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> propertyString(
            String repository, String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> propertyNumber(
            String repository, String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DateExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> propertyDate(
            String repository, String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EnumExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> propertyEnum(
            String repository, String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> ObjectExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> property(
            Class<T> repository, String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> StringExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> propertyString(
            Class<T> repository, String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> NumberExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> propertyNumber(
            Class<T> repository, String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> DateExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> propertyDate(
            Class<T> repository, String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> EnumExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> propertyEnum(
            Class<T> repository, String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ObjectExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> property(
            int repositoryIndex, String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StringExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> propertyString(
            int repositoryIndex, String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> propertyNumber(
            int repositoryIndex, String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DateExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> propertyDate(
            int repositoryIndex, String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EnumExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> propertyEnum(
            int repositoryIndex, String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ObjectExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> property(
            String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StringExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> propertyString(
            String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> propertyNumber(
            String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DateExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> propertyDate(
            String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EnumExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> propertyEnum(
            String name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T,
            R> ObjectExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> property(
                    SerializableFunction<T, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> StringExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> property(
            ReturnStringFunction<T> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T,
            R extends Number> NumberExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> property(
                    ReturnNumberFunction<T, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T,
            R extends Date> DateExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> property(
                    ReturnDateFunction<T, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T,
            R extends Enum<?>> EnumExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> property(
                    ReturnEnumFunction<T, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> StringExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> propertyString(
            SerializableFunction<T, String> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T,
            R extends Number> NumberExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> propertyNumber(
                    SerializableFunction<T, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T,
            R extends Date> DateExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> propertyDate(
                    SerializableFunction<T, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T,
            R extends Enum<?>> EnumExpression<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> propertyEnum(
                    SerializableFunction<T, R> name) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression endGroup() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression and() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression or() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression group() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryRepositoryConditionGroupExpression eq(SerializableFunction<T, R> repository,
            SerializableFunction<T, R> property, R value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryRepositoryConditionGroupExpression eq(SerializableSupplier<T> repository,
            SerializableFunction<T, R> property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryRepositoryConditionGroupExpression ne(SerializableFunction<T, R> repository,
            SerializableFunction<T, R> property, R value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryRepositoryConditionGroupExpression ne(SerializableSupplier<T> repository,
            SerializableFunction<T, R> property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lk(String repository, String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression lk(Class<T> repository, String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lk(int repositoryIndex, String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lk(String name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression lk(ReturnStringFunction<T> name, String value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lk(StringSupplier property) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression inn(String repository, String name, Boolean value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression inn(Class<T> repository, String name, Boolean value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression inn(int repositoryIndex, String name, Boolean value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression inn(String name, Boolean value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryRepositoryConditionGroupExpression inn(SerializableFunction<T, R> name, Boolean value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression isn(String repository, String name, Boolean value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression isn(Class<T> repository, String name, Boolean value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression isn(int repositoryIndex, String name, Boolean value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression isn(String name, Boolean value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryRepositoryConditionGroupExpression isn(SerializableFunction<T, R> name, Boolean value) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression logic(LogicOperator operator) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression expression(String expression) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression expression(String expression, Map<String, Object> params) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression expression(String expression, Object... params) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression eq(String name, Object value, QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryRepositoryConditionGroupExpression eq(SerializableFunction<T, R> name, R value,
            QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> UserQueryRepositoryConditionGroupExpression eq(SerializableSupplier<R> property,
            QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ne(String name, Object value, QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryRepositoryConditionGroupExpression ne(SerializableFunction<T, R> name, R value,
            QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> UserQueryRepositoryConditionGroupExpression ne(SerializableSupplier<R> property,
            QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lk(String name, String value, QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression lk(ReturnStringFunction<T> name, String value,
            QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lk(StringSupplier property, QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression co(String name, String value, QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression co(ReturnStringFunction<T> name, String value,
            QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression co(StringSupplier property, QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ew(String name, String value, QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ew(ReturnStringFunction<T> name, String value,
            QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ew(StringSupplier property, QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression sw(String name, String value, QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression sw(ReturnStringFunction<T> name, String value,
            QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression sw(StringSupplier property, QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression co(String repository, String name, String value,
            QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression co(Class<T> repository, String name, String value,
            QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression co(int repositoryIndex, String name, String value,
            QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ew(String repository, String name, String value,
            QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ew(Class<T> repository, String name, String value,
            QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ew(int repositoryIndex, String name, String value,
            QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression eq(String repository, String name, Object value,
            QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression eq(Class<T> repository, String name, Object value,
            QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression eq(int repositoryIndex, String name, Object value,
            QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryRepositoryConditionGroupExpression eq(SerializableFunction<T, R> repository,
            SerializableFunction<T, R> property, R value, QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryRepositoryConditionGroupExpression eq(SerializableSupplier<T> repository,
            SerializableFunction<T, R> property, QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ne(String repository, String name, Object value,
            QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression ne(Class<T> repository, String name, Object value,
            QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression ne(int repositoryIndex, String name, Object value,
            QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryRepositoryConditionGroupExpression ne(SerializableFunction<T, R> repository,
            SerializableFunction<T, R> property, R value, QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> UserQueryRepositoryConditionGroupExpression ne(SerializableSupplier<T> repository,
            SerializableFunction<T, R> property, QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression sw(String repository, String name, String value,
            QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression sw(Class<T> repository, String name, String value,
            QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression sw(int repositoryIndex, String name, String value,
            QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lk(String repository, String name, String value,
            QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> UserQueryRepositoryConditionGroupExpression lk(Class<T> repository, String name, String value,
            QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression lk(int repositoryIndex, String name, String value,
            QueryPolicy queryPolicy) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression and(
            Function<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> group) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression or(
            Function<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> group) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryRepositoryConditionGroupExpression group(
            Function<UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> group) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }
}
