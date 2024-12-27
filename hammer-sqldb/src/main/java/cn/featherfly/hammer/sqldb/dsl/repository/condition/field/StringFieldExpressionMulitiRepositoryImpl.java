
package cn.featherfly.hammer.sqldb.dsl.repository.condition.field;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.operator.Function;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositoryStringFieldExpression;
import cn.featherfly.hammer.sqldb.dsl.condition.InternalMulitiCondition;

/**
 * String field expression implements.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class StringFieldExpressionMulitiRepositoryImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
    extends AbstractMulitiRepositoryFieldExpression<C, L> implements RepositoryStringFieldExpression<C, L> {

    /**
     * Instantiates a new simple string property expression.
     *
     * @param index the index
     * @param name the name
     * @param expression the expression
     */
    public StringFieldExpressionMulitiRepositoryImpl(AtomicInteger index, String name,
        InternalMulitiCondition<L> expression) {
        super(index, name, expression);
    }

    /**
     * Instantiates a new string field expression muliti repository impl.
     *
     * @param index the index
     * @param name the name
     * @param function the function
     * @param expression the expression
     */
    public StringFieldExpressionMulitiRepositoryImpl(AtomicInteger index, String name, Function function,
        InternalMulitiCondition<L> expression) {
        super(index, name, function, expression);
    }

    /**
     * Instantiates a new string field expression muliti repository impl.
     *
     * @param index the index
     * @param name the name
     * @param function the function
     * @param argus the argus
     * @param expression the expression
     */
    public StringFieldExpressionMulitiRepositoryImpl(AtomicInteger index, String name, Function function,
        Object[] argus, InternalMulitiCondition<L> expression) {
        super(index, name, function, argus, expression);
    }

    /**
     * Instantiates a new string field expression muliti repository impl.
     *
     * @param index the index
     * @param name the name
     * @param function the function
     * @param expression the expression
     */
    public StringFieldExpressionMulitiRepositoryImpl(int index, String name, Function function,
        InternalMulitiCondition<L> expression) {
        super(index, name, function, expression);
    }

    /**
     * Instantiates a new string field expression muliti repository impl.
     *
     * @param index the index
     * @param name the name
     * @param function the function
     * @param argus the argus
     * @param expression the expression
     */
    public StringFieldExpressionMulitiRepositoryImpl(int index, String name, Function function, Object[] argus,
        InternalMulitiCondition<L> expression) {
        super(index, name, function, argus, expression);
    }

    /**
     * Instantiates a new simple string property expression.
     *
     * @param index the index
     * @param name the name
     * @param expression the expression
     */
    public StringFieldExpressionMulitiRepositoryImpl(int index, String name, InternalMulitiCondition<L> expression) {
        super(index, name, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String value) {
        return expression.eq(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String value, MatchStrategy matchStrategy) {
        return expression.eq(index, name, value, matchStrategy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.eq(index, name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.eq(index, name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String value) {
        return expression.ne(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String value, MatchStrategy matchStrategy) {
        return expression.ne(index, name, value, matchStrategy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.ne(index, name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.ne(index, name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String value) {
        return expression.in(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String value, IgnoreStrategy ignoreStrategy) {
        return expression.in(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String value, Predicate<String> ignoreStrategy) {
        return expression.in(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String[] value) {
        return expression.in(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String[] value, IgnoreStrategy ignoreStrategy) {
        return expression.in(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String[] value, Predicate<String[]> ignoreStrategy) {
        return expression.in(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Collection<String> value, Predicate<Collection<String>> ignoreStrategy) {
        return expression.in(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String value) {
        return expression.ni(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String value, IgnoreStrategy ignoreStrategy) {
        return expression.ni(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String value, Predicate<String> ignoreStrategy) {
        return expression.ni(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String[] value) {
        return expression.ni(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String[] value, IgnoreStrategy ignoreStrategy) {
        return expression.ni(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String[] value, Predicate<String[]> ignoreStrategy) {
        return expression.ni(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Collection<String> value, Predicate<Collection<String>> ignoreStrategy) {
        return expression.ni(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String value) {
        return expression.le(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String value, IgnoreStrategy ignoreStrategy) {
        return expression.le(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String value, Predicate<String> ignoreStrategy) {
        return expression.le(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String value) {
        return expression.lt(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String value, IgnoreStrategy ignoreStrategy) {
        return expression.lt(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String value, Predicate<String> ignoreStrategy) {
        return expression.lt(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String value) {
        return expression.ge(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String value, IgnoreStrategy ignoreStrategy) {
        return expression.ge(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String value, Predicate<String> ignoreStrategy) {
        return expression.ge(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String value) {
        return expression.gt(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String value, IgnoreStrategy ignoreStrategy) {
        return expression.gt(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String value, Predicate<String> ignoreStrategy) {
        return expression.gt(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String value, MatchStrategy matchStrategy) {
        return expression.sw(index, name, value, matchStrategy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.sw(index, name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value) {
        return expression.co(index, name, value, MatchStrategy.AUTO, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value, MatchStrategy matchStrategy) {
        return expression.co(index, name, value, matchStrategy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.co(index, name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.co(index, name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value) {
        return expression.ew(index, name, value, MatchStrategy.AUTO, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value, MatchStrategy matchStrategy) {
        return expression.ew(index, name, value, matchStrategy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.ew(index, name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.ew(index, name, value, matchStrategy, ignoreStrategy);
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
    public L lk(String value, MatchStrategy matchStrategy) {
        return expression.lk(index, name, value, matchStrategy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.lk(index, name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.lk(index, name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(String min, String max) {
        return expression.ba(index, name, min, max, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(String min, String max, IgnoreStrategy ignoreStrategy) {
        return expression.ba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(String min, String max, BiPredicate<String, String> ignoreStrategy) {
        return expression.ba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(String min, String max) {
        return expression.nba(index, name, min, max, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(String min, String max, IgnoreStrategy ignoreStrategy) {
        return expression.nba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(String min, String max, BiPredicate<String, String> ignoreStrategy) {
        return expression.nba(index, name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(String value, MatchStrategy matchStrategy) {
        return expression.nsw(index, name, value, matchStrategy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.nsw(index, name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.nsw(index, name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(String value, MatchStrategy matchStrategy) {
        return expression.nco(index, name, value, matchStrategy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.nco(index, name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.nco(index, name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(String value, MatchStrategy matchStrategy) {
        return expression.newv(index, name, value, matchStrategy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.newv(index, name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.newv(index, name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl(String value, MatchStrategy matchStrategy) {
        return expression.nl(index, name, value, matchStrategy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.nl(index, name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.nl(index, name, value, matchStrategy, ignoreStrategy);
    }
}
