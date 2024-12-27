
package cn.featherfly.hammer.sqldb.dsl.repository.condition.field;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.operator.DateFunction;
import cn.featherfly.common.operator.Function;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.field.NumberFieldExpression;
import cn.featherfly.hammer.expression.condition.field.StringFieldExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryDateFieldExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.InternalMulitiCondition;
import cn.featherfly.hammer.sqldb.dsl.entity.condition.InternalMulitiEntityCondition;

/**
 * date field expression implements.
 *
 * @author zhongj
 * @param <D> the generic type
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class DateFieldExpressionMulitiRepositoryImpl<D extends Date, C extends ConditionExpression,
    L extends LogicExpression<C, L>> extends AbstractMulitiRepositoryFieldExpression<C, L>
    implements RepositoryDateFieldExpression<D, C, L> {

    /**
     * Instantiates a new date field expression impl.
     *
     * @param index the index
     * @param name the name
     * @param expression the expression
     */
    public DateFieldExpressionMulitiRepositoryImpl(int index, String name, InternalMulitiCondition<L> expression) {
        super(new AtomicInteger(index), name, expression);
    }

    /**
     * @param index
     * @param name
     * @param function
     * @param expression
     */
    public DateFieldExpressionMulitiRepositoryImpl(int index, String name, Function function,
        InternalMulitiCondition<L> expression) {
        super(index, name, function, expression);
    }

    /**
     * @param index
     * @param name
     * @param function
     * @param argus
     * @param expression
     */
    public DateFieldExpressionMulitiRepositoryImpl(int index, String name, Function function, Object[] argus,
        InternalMulitiCondition<L> expression) {
        super(index, name, function, argus, expression);
    }

    /**
     * @param index
     * @param name
     * @param function
     * @param expression
     */
    public DateFieldExpressionMulitiRepositoryImpl(AtomicInteger index, String name, Function function,
        InternalMulitiCondition<L> expression) {
        super(index, name, function, expression);
    }

    /**
     * @param index
     * @param name
     * @param function
     * @param argus
     * @param expression
     */
    public DateFieldExpressionMulitiRepositoryImpl(AtomicInteger index, String name, Function function, Object[] argus,
        InternalMulitiCondition<L> expression) {
        super(index, name, function, argus, expression);
    }

    /**
     * @param index
     * @param name
     * @param expression
     */
    public DateFieldExpressionMulitiRepositoryImpl(AtomicInteger index, String name,
        InternalMulitiCondition<L> expression) {
        super(index, name, expression);
    }

    /**
     * Instantiates a new date field expression impl.
     *
     * @param index the index
     * @param name the name
     * @param expression the expression
     */
    public DateFieldExpressionMulitiRepositoryImpl(AtomicInteger index, String name,
        InternalMulitiEntityCondition<L> expression) {
        super(index, name, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(D value) {
        return expression.eq(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(D value, IgnoreStrategy ignoreStrategy) {
        return expression.eq(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(D value, Predicate<D> ignoreStrategy) {
        return expression.eq(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(D value) {
        return expression.ne(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(D value, IgnoreStrategy ignoreStrategy) {
        return expression.ne(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(D value, Predicate<D> ignoreStrategy) {
        return expression.ne(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(D value) {
        return expression.in(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(D value, Predicate<D> ignoreStrategy) {
        return expression.in(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(D[] value) {
        return expression.in(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(D[] value, Predicate<D[]> ignoreStrategy) {
        return expression.in(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Collection<D> value, Predicate<Collection<D>> ignoreStrategy) {
        return expression.in(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(D value) {
        return expression.ni(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public L ni(D value, Predicate<D> ignoreStrategy) {
        return expression.ni(index, name, value, v -> ignoreStrategy.test((D) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(D[] value) {
        return expression.ni(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(D[] value, Predicate<D[]> ignoreStrategy) {
        return expression.ni(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Collection<D> value, Predicate<Collection<D>> ignoreStrategy) {
        return expression.ni(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(D value) {
        return expression.le(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(D value, IgnoreStrategy ignoreStrategy) {
        return expression.le(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(D value, Predicate<D> ignoreStrategy) {
        return expression.le(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(D value) {
        return expression.lt(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(D value, IgnoreStrategy ignoreStrategy) {
        return expression.lt(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(D value, Predicate<D> ignoreStrategy) {
        return expression.lt(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(D value) {
        return expression.ge(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(D value, IgnoreStrategy ignoreStrategy) {
        return expression.ge(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(D value, Predicate<D> ignoreStrategy) {
        return expression.ge(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(D value) {
        return expression.gt(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(D value, IgnoreStrategy ignoreStrategy) {
        return expression.gt(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(D value, Predicate<D> ignoreStrategy) {
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
    public L ba(D min, D max) {
        return expression.ba(index, name, min, max,
            (m1, m2) -> expression.getIgnoreStrategy().test(new Serializable[] { m1, m2 }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(D min, D max, IgnoreStrategy ignoreStrategy) {
        return expression.ba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(D min, D max, BiPredicate<D, D> ignoreStrategy) {
        return expression.ba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(D min, D max) {
        return expression.nba(index, name, min, max,
            (m1, m2) -> expression.getIgnoreStrategy().test(new Serializable[] { m1, m2 }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(D min, D max, IgnoreStrategy ignoreStrategy) {
        return expression.nba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(D min, D max, BiPredicate<D, D> ignoreStrategy) {
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
