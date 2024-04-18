
package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositorySerializableFieldExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.condition.InternalMulitiCondition;

/**
 * object field expression implements.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class SerializableFieldExpressionMulitiRepositoryImpl<C extends ConditionExpression,
    L extends LogicExpression<C, L>> extends AbstractMulitiRepositoryFieldExpression<C, L>
    implements RepositorySerializableFieldExpression<C, L> {

    /**
     * Instantiates a new simple object property expression.
     *
     * @param index              the index
     * @param name               the name
     * @param expression         the expression
     * @param repositoryRelation the repository relation
     */
    public SerializableFieldExpressionMulitiRepositoryImpl(int index, String name,
        InternalMulitiCondition<L> expression) {
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
    public SerializableFieldExpressionMulitiRepositoryImpl(AtomicInteger index, String name,
        InternalMulitiCondition<L> expression) {
        super(index, name, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(Serializable value) {
        return expression.eq(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(Serializable value, IgnoreStrategy ignoreStrategy) {
        return expression.eq(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(Serializable value, Predicate<Serializable> ignoreStrategy) {
        return expression.eq(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Serializable value) {
        return expression.in(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Serializable value, Predicate<Serializable> ignoreStrategy) {
        return expression.in(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Serializable[] value) {
        return expression.in(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Serializable[] value, Predicate<Serializable[]> ignoreStrategy) {
        return expression.in(index, name, value, v -> ignoreStrategy.test((Serializable[]) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(Serializable value) {
        return expression.ne(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(Serializable value, IgnoreStrategy ignoreStrategy) {
        return expression.ne(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(Serializable value, Predicate<Serializable> ignoreStrategy) {
        return expression.ne(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Serializable value) {
        return expression.ni(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Serializable value, Predicate<Serializable> ignoreStrategy) {
        return expression.ni(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Serializable[] value) {
        return expression.ni(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Serializable[] value, Predicate<Serializable[]> ignoreStrategy) {
        return expression.ni(index, name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(Serializable value) {
        return expression.le(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(Serializable value, IgnoreStrategy ignoreStrategy) {
        return le(value, ignoreStrategy::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(Serializable value, Predicate<Serializable> ignoreStrategy) {
        return expression.le(index, name, value, v -> ignoreStrategy.test((Serializable) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(Serializable value) {
        return expression.lt(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(Serializable value, IgnoreStrategy ignoreStrategy) {
        return lt(value, ignoreStrategy::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(Serializable value, Predicate<Serializable> ignoreStrategy) {
        return expression.lt(index, name, value, v -> ignoreStrategy.test((Serializable) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(Serializable value) {
        return expression.ge(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(Serializable value, IgnoreStrategy ignoreStrategy) {
        return ge(value, ignoreStrategy::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(Serializable value, Predicate<Serializable> ignoreStrategy) {
        return expression.ge(index, name, value, v -> ignoreStrategy.test((Serializable) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(Serializable value) {
        return expression.gt(index, name, value, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(Serializable value, IgnoreStrategy ignoreStrategy) {
        return gt(value, ignoreStrategy::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(Serializable value, Predicate<Serializable> ignoreStrategy) {
        return expression.gt(index, name, value, v -> ignoreStrategy.test((Serializable) v));
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
    public L ba(Serializable min, Serializable max) {
        return expression.ba(index, name, min, max, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(Serializable min, Serializable max, IgnoreStrategy ignoreStrategy) {
        return ba(min, max, (s, l) -> ignoreStrategy.test(new Serializable[] { s, l }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(Serializable min, Serializable max, BiPredicate<Serializable, Serializable> ignoreStrategy) {
        return expression.ba(index, name, min, max, ignoreStrategy::test);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(Serializable min, Serializable max) {
        return expression.nba(index, name, min, max, expression.getIgnoreStrategy());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(Serializable min, Serializable max, IgnoreStrategy ignoreStrategy) {
        return nba(min, max, (s, l) -> ignoreStrategy.test(new Serializable[] { s, l }));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(Serializable min, Serializable max, BiPredicate<Serializable, Serializable> ignoreStrategy) {
        return expression.nba(index, name, min, max, ignoreStrategy::test);
    }
}
