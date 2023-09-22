
package cn.featherfly.hammer.expression.condition.property;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionsExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;

/**
 * simple String property expression.
 *
 * @author zhongj
 */
public class SimpleStringPropertyExpression<C extends ConditionsExpression<C, L>, L extends LogicExpression<C, L>>
        implements StringPropertyExpression<C, L> {

    private String name;

    private ConditionsExpression<C, L> expression;

    /**
     * @param name       name
     * @param expression expression
     */
    public SimpleStringPropertyExpression(String name, ConditionsExpression<C, L> expression) {
        super();
        this.name = name;
        this.expression = expression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String value) {
        return expression.eq(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String value, MatchStrategy matchStrategy) {
        return expression.eq(name, value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.eq(name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.eq(name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String expression() {
        return expression.expression();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String value) {
        return expression.ne(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String value, MatchStrategy matchStrategy) {
        return expression.ne(name, value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.ne(name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.ne(name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String value) {
        return expression.in(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String value, IgnoreStrategy ignoreStrategy) {
        return expression.in(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String value, Predicate<String> ignoreStrategy) {
        return expression.in(name, value, v -> ignoreStrategy.test((String) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String[] value) {
        return expression.in(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String[] value, IgnoreStrategy ignoreStrategy) {
        return expression.in(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String[] value, Predicate<String[]> ignoreStrategy) {
        return expression.in(name, value, v -> ignoreStrategy.test((String[]) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String value) {
        return expression.ni(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String value, IgnoreStrategy ignoreStrategy) {
        return expression.ni(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String value, Predicate<String> ignoreStrategy) {
        return expression.ni(name, value, v -> ignoreStrategy.test((String) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String[] value) {
        return expression.ni(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String[] value, IgnoreStrategy ignoreStrategy) {
        return expression.ni(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String[] value, Predicate<String[]> ignoreStrategy) {
        return expression.ni(name, value, v -> ignoreStrategy.test((String[]) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String value) {
        return expression.le(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String value, IgnoreStrategy ignoreStrategy) {
        return expression.le(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String value, Predicate<String> ignoreStrategy) {
        return expression.le(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String value) {
        return expression.lt(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String value, IgnoreStrategy ignoreStrategy) {
        return expression.lt(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String value, Predicate<String> ignoreStrategy) {
        return expression.lt(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String value) {
        return expression.ge(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String value, IgnoreStrategy ignoreStrategy) {
        return expression.ge(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String value, Predicate<String> ignoreStrategy) {
        return expression.ge(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String value) {
        return expression.gt(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String value, IgnoreStrategy ignoreStrategy) {
        return expression.gt(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String value, Predicate<String> ignoreStrategy) {
        return expression.gt(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String value) {
        return expression.sw(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String value, MatchStrategy matchStrategy) {
        return expression.sw(name, value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.sw(name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.sw(name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value) {
        return expression.co(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value, MatchStrategy matchStrategy) {
        return expression.co(name, value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.co(name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.co(name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value) {
        return expression.ew(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value, MatchStrategy matchStrategy) {
        return expression.ew(name, value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.ew(name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.ew(name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn() {
        return expression.isn(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn() {
        return expression.inn(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn(Boolean value) {
        return expression.isn(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn(Boolean value) {
        return expression.inn(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String value, MatchStrategy matchStrategy) {
        return expression.lk(name, value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.lk(name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.lk(name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(String min, String max) {
        return expression.ba(name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(String min, String max, IgnoreStrategy ignoreStrategy) {
        return expression.ba(name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(String min, String max, BiPredicate<String, String> ignoreStrategy) {
        return expression.ba(name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(String min, String max) {
        return expression.nba(name, min, max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(String min, String max, IgnoreStrategy ignoreStrategy) {
        return expression.nba(name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(String min, String max, BiPredicate<String, String> ignoreStrategy) {
        return expression.nba(name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(String value, MatchStrategy matchStrategy) {
        return expression.nsw(name, value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.nsw(name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.nsw(name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(String value, MatchStrategy matchStrategy) {
        return expression.nco(name, value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.nco(name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.nco(name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(String value, MatchStrategy matchStrategy) {
        return expression.newv(name, value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.newv(name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.newv(name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl(String value, MatchStrategy matchStrategy) {
        return expression.nl(name, value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.nl(name, value, matchStrategy, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
        return expression.nl(name, value, matchStrategy, ignoreStrategy);
    }

}
