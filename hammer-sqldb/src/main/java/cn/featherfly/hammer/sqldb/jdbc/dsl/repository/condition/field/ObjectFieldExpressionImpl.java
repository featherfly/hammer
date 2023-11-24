
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.field.ObjectFieldExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.condition.AbstractSqlConditionsExpression;

/**
 * object field expression implements.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class ObjectFieldExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractRepositoryFieldExpression<C, L> implements ObjectFieldExpression<C, L> {

    /**
     * Instantiates a new object field expression impl.
     *
     * @param name       the name
     * @param expression the expression
     */
    public ObjectFieldExpressionImpl(String name, AbstractSqlConditionsExpression<C, L, ?> expression) {
        super(name, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(Object value) {
        return expression.eq(name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(Object value, IgnoreStrategy ignoreStrategy) {
        return expression.eq(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(Object value, Predicate<Object> ignoreStrategy) {
        return expression.eq(name, value, ignoreStrategy);
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
    public L in(Object value) {
        return expression.in(name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Object value, Predicate<Object> ignoreStrategy) {
        return expression.in(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Object[] value) {
        return expression.in(name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Object[] value, Predicate<Object[]> ignoreStrategy) {
        return expression.in(name, value, v -> ignoreStrategy.test(v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(Object value) {
        return expression.ne(name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(Object value, IgnoreStrategy ignoreStrategy) {
        return expression.ne(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(Object value, Predicate<Object> ignoreStrategy) {
        return expression.ne(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Object value) {
        return expression.ni(name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Object value, Predicate<Object> ignoreStrategy) {
        return expression.ni(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Object[] value) {
        return expression.ni(name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Object[] value, Predicate<Object[]> ignoreStrategy) {
        return expression.ni(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(Object value) {
        return expression.le0(name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(Object value, IgnoreStrategy ignoreStrategy) {
        return le(value, (Predicate<Object>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(Object value, Predicate<Object> ignoreStrategy) {
        return expression.le0(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(Object value) {
        return expression.lt0(name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(Object value, IgnoreStrategy ignoreStrategy) {
        return lt(value, (Predicate<Object>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(Object value, Predicate<Object> ignoreStrategy) {
        return expression.lt0(name, value, ignoreStrategy::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(Object value) {
        return expression.ge0(name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(Object value, IgnoreStrategy ignoreStrategy) {
        return ge(value, (Predicate<Object>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(Object value, Predicate<Object> ignoreStrategy) {
        return expression.ge0(name, value, ignoreStrategy::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(Object value) {
        return expression.gt0(name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(Object value, IgnoreStrategy ignoreStrategy) {
        return gt(value, (Predicate<Object>) ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(Object value, Predicate<Object> ignoreStrategy) {
        return expression.gt0(name, value, ignoreStrategy::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value, MatchStrategy matchStrategy) {
        return expression.co(name, value, matchStrategy, expression.getIgnoreStrategy()::test);
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
        return expression.ew(name, value, MatchStrategy.AUTO, expression.getIgnoreStrategy()::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value, MatchStrategy matchStrategy) {
        return expression.ew(name, value, matchStrategy, expression.getIgnoreStrategy()::test);
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
        return expression.isn(name, true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn() {
        return expression.inn(name, true);
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
    public L sw(String value, MatchStrategy matchStrategy) {
        return expression.sw(name, value, matchStrategy, expression.getIgnoreStrategy()::test);
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
    public L lk(String value, MatchStrategy matchStrategy) {
        return expression.lk(name, value, matchStrategy, expression.getIgnoreStrategy()::test);
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
    public L ba(Object min, Object max) {
        return nba(min, max, (m1, m2) -> expression.getIgnoreStrategy().test(new Object[] { m1, m2 }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(Object min, Object max, IgnoreStrategy ignoreStrategy) {
        return ba(min, max, (s, l) -> ignoreStrategy.test(new Object[] { s, l }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(Object min, Object max, BiPredicate<Object, Object> ignoreStrategy) {
        return expression.ba0(name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(Object min, Object max) {
        return nba(min, max, (m1, m2) -> expression.getIgnoreStrategy().test(new Object[] { m1, m2 }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(Object min, Object max, IgnoreStrategy ignoreStrategy) {
        return nba(min, max, (s, l) -> ignoreStrategy.test(new Object[] { s, l }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(Object min, Object max, BiPredicate<Object, Object> ignoreStrategy) {
        return expression.nba0(name, min, max, ignoreStrategy);
    }
}
