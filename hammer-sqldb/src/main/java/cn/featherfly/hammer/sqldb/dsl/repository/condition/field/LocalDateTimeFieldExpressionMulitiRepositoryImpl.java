
package cn.featherfly.hammer.sqldb.dsl.repository.condition.field;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.operator.DateFunction;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.field.NumberFieldExpression;
import cn.featherfly.hammer.expression.condition.field.StringFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryLocalDateTimeFieldExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.InternalMulitiCondition;

/**
 * :LocalDateTime field expression implements.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class LocalDateTimeFieldExpressionMulitiRepositoryImpl<C extends ConditionExpression,
    L extends LogicExpression<C, L>> extends AbstractMulitiRepositoryFieldExpression<C, L>
    implements RepositoryLocalDateTimeFieldExpression<C, L> {

    /**
     * Instantiates a new simple local date time property expression.
     *
     * @param index the index
     * @param name the name
     * @param expression the expression
     */
    public LocalDateTimeFieldExpressionMulitiRepositoryImpl(AtomicInteger index, String name,
        InternalMulitiCondition<L> expression) {
        super(index, name, expression);
    }

    /**
     * Instantiates a new simple local date time property expression.
     *
     * @param index the index
     * @param name the name
     * @param expression the expression
     */
    public LocalDateTimeFieldExpressionMulitiRepositoryImpl(int index, String name,
        InternalMulitiCondition<L> expression) {
        super(index, name, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(LocalDateTime value) {
        return expression.eq(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return expression.eq(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return expression.eq(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(LocalDateTime value) {
        return expression.ne(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return expression.ne(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return expression.ne(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(LocalDateTime value) {
        return expression.in(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return expression.in(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(LocalDateTime[] value) {
        return expression.in(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(LocalDateTime[] value, Predicate<LocalDateTime[]> ignoreStrategy) {
        return expression.in(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Collection<LocalDateTime> value, Predicate<Collection<LocalDateTime>> ignoreStrategy) {
        return expression.in(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(LocalDateTime value) {
        return expression.ni(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return expression.ni(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(LocalDateTime[] value) {
        return expression.ni(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(LocalDateTime[] value, Predicate<LocalDateTime[]> ignoreStrategy) {
        return expression.ni(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Collection<LocalDateTime> value, Predicate<Collection<LocalDateTime>> ignoreStrategy) {
        return expression.ni(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(LocalDateTime value) {
        return expression.le(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return expression.le(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return expression.le(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(LocalDateTime value) {
        return expression.lt(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return expression.lt(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return expression.lt(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(LocalDateTime value) {
        return expression.ge(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return expression.ge(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return expression.ge(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(LocalDateTime value) {
        return expression.gt(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(LocalDateTime value, IgnoreStrategy ignoreStrategy) {
        return expression.gt(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(LocalDateTime value, Predicate<LocalDateTime> ignoreStrategy) {
        return expression.gt(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn() {
        return expression.isn(index, name, true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn() {
        return expression.inn(index, name, true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn(Boolean value) {
        return expression.isn(index, name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn(Boolean value) {
        return expression.inn(index, name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(LocalDateTime min, LocalDateTime max) {
        return expression.ba(index, name, min, max, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(LocalDateTime min, LocalDateTime max, IgnoreStrategy ignoreStrategy) {
        return expression.ba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(LocalDateTime min, LocalDateTime max, BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return expression.ba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(LocalDateTime min, LocalDateTime max) {
        return expression.nba(index, name, min, max, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(LocalDateTime min, LocalDateTime max, IgnoreStrategy ignoreStrategy) {
        return expression.nba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(LocalDateTime min, LocalDateTime max, BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
        return expression.nba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberFieldExpression<Integer, C, L> getYear() {
        return new NumberFieldExpressionMulitiRepositoryImpl<>(index, name, DateFunction.GET_YEAR, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberFieldExpression<Integer, C, L> getMonth() {
        return new NumberFieldExpressionMulitiRepositoryImpl<>(index, name, DateFunction.GET_MONTH, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberFieldExpression<Integer, C, L> getDayOfMonth() {
        return new NumberFieldExpressionMulitiRepositoryImpl<>(index, name, DateFunction.GET_DAY_OF_MONTH, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StringFieldExpression<C, L> format(String format) {
        return new StringFieldExpressionMulitiRepositoryImpl<>(index, name, DateFunction.DATE_FORMAT,
            new Object[] { format }, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberFieldExpression<Integer, C, L> getHour() {
        return new NumberFieldExpressionMulitiRepositoryImpl<>(index, name, DateFunction.GET_HOUR, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberFieldExpression<Integer, C, L> getMinute() {
        return new NumberFieldExpressionMulitiRepositoryImpl<>(index, name, DateFunction.GET_MINUTE, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberFieldExpression<Integer, C, L> getSecond() {
        return new NumberFieldExpressionMulitiRepositoryImpl<>(index, name, DateFunction.GET_SECOND, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberFieldExpression<Integer, C, L> getWeekDay() {
        return new NumberFieldExpressionMulitiRepositoryImpl<>(index, name, DateFunction.GET_WEEKDAY, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberFieldExpression<Integer, C, L> getWeekOfYear() {
        return new NumberFieldExpressionMulitiRepositoryImpl<>(index, name, DateFunction.GET_WEEK_OF_YEAR, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberFieldExpression<Integer, C, L> getDayOfYear() {
        return new NumberFieldExpressionMulitiRepositoryImpl<>(index, name, DateFunction.GET_DAY_OF_YEAR, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NumberFieldExpression<Integer, C, L> getQuarter() {
        return new NumberFieldExpressionMulitiRepositoryImpl<>(index, name, DateFunction.GET_QUARTER, expression);
    }
}
