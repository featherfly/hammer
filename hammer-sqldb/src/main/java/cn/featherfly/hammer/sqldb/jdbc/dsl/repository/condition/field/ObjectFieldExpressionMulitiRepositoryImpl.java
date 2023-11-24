
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.field.ObjectFieldExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.condition.InternalMulitiCondition;

/**
 * object field expression implements.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class ObjectFieldExpressionMulitiRepositoryImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractMulitiRepositoryFieldExpression<C, L> implements ObjectFieldExpression<C, L> {

    /**
     * Instantiates a new simple object property expression.
     *
     * @param index              the index
     * @param name               the name
     * @param expression         the expression
     * @param repositoryRelation the repository relation
     */
    public ObjectFieldExpressionMulitiRepositoryImpl(int index, String name, InternalMulitiCondition<L> expression) {
        super(new AtomicInteger(index), name, expression);
    }

    /**
     * Instantiates a new simple object property expression.
     *
     * @param index              the index
     * @param name               the name
     * @param expression         the expression
     * @param repositoryRelation the repository relation
     */
    public ObjectFieldExpressionMulitiRepositoryImpl(AtomicInteger index, String name, InternalMulitiCondition<L> expression) {
        super(index, name, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(Object value) {
        return expression.eq(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(Object value, IgnoreStrategy ignoreStrategy) {
        return expression.eq(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(Object value, Predicate<Object> ignoreStrategy) {
        return expression.eq(index, name, value, ignoreStrategy);
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
        return expression.in(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Object value, Predicate<Object> ignoreStrategy) {
        return expression.in(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Object[] value) {
        return expression.in(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Object[] value, Predicate<Object[]> ignoreStrategy) {
        return expression.in(index, name, value, v -> ignoreStrategy.test((Object[]) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(Object value) {
        return expression.ne(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(Object value, IgnoreStrategy ignoreStrategy) {
        return expression.ne(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(Object value, Predicate<Object> ignoreStrategy) {
        return expression.ne(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Object value) {
        return expression.ni(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Object value, Predicate<Object> ignoreStrategy) {
        return expression.ni(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Object[] value) {
        return expression.ni(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Object[] value, Predicate<Object[]> ignoreStrategy) {
        return expression.ni(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(Object value) {
        return expression.le(index, name, value, expression.getIgnoreStrategy());
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
        return expression.le(index, name, value, ignoreStrategy::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(Object value) {
        return expression.lt(index, name, value, expression.getIgnoreStrategy());
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
        return expression.lt(index, name, value, ignoreStrategy::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(Object value) {
        return expression.ge(index, name, value, expression.getIgnoreStrategy());
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
        return expression.ge(index, name, value, ignoreStrategy::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(Object value) {
        return expression.gt(index, name, value, expression.getIgnoreStrategy());
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
        return expression.gt(index, name, value, ignoreStrategy::test);
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
    public L sw(String value, MatchStrategy matchStrategy) {
        return expression.sw(index, name, value, matchStrategy, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
        return expression.sw(index, name, value, matchStrategy, ignoreStrategy);
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
    public L ba(Object min, Object max) {
        return expression.ba(index, name, min, max, expression.getIgnoreStrategy());
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
        return expression.ba(index, name, min, max, ignoreStrategy::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(Object min, Object max) {
        return expression.nba(index, name, min, max, expression.getIgnoreStrategy());
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
        return expression.nba(index, name, min, max, ignoreStrategy::test);
    }
}
