/*
 * All rights Reserved, Designed By zhongj
 * @Title: SerializableFieldExpressionImpl.java
 * @Package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field
 * @Description: todo (用一句话描述该文件做什么)
 * @author: zhongj
 * @date: 2024年3月28日 下午5:52:02
 * @version V1.0
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */

package cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field;

import java.io.Serializable;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.repository.condition.field.RepositorySerializableFieldExpression;
import cn.featherfly.hammer.sqldb.jdbc.dsl.condition.AbstractSqlConditionsExpression;

/**
 * object field expression implements.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <L> the generic type
 */
public class SerializableFieldExpressionImpl<C extends ConditionExpression, L extends LogicExpression<C, L>>
        extends AbstractRepositoryFieldExpression<C, L> implements RepositorySerializableFieldExpression<C, L> {

    /**
     * Instantiates a new object field expression impl.
     *
     * @param name       the name
     * @param expression the expression
     */
    public SerializableFieldExpressionImpl(String name, AbstractSqlConditionsExpression<C, L, ?> expression) {
        super(name, expression);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(Field field) {
        return expression.eq(name, field);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(Serializable value) {
        return expression.eq(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(Serializable value, IgnoreStrategy ignoreStrategy) {
        return expression.eq(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(Serializable value, Predicate<Serializable> ignoreStrategy) {
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
    public L in(Serializable value) {
        return expression.in(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Serializable value, Predicate<Serializable> ignoreStrategy) {
        return expression.in(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Serializable[] value) {
        return expression.in(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Serializable[] value, Predicate<Serializable[]> ignoreStrategy) {
        return expression.in(name, value, v -> ignoreStrategy.test(v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(Serializable value) {
        return expression.ne(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(Serializable value, IgnoreStrategy ignoreStrategy) {
        return expression.ne(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(Serializable value, Predicate<Serializable> ignoreStrategy) {
        return expression.ne(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Serializable value) {
        return expression.ni(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Serializable value, Predicate<Serializable> ignoreStrategy) {
        return expression.ni(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Serializable[] value) {
        return expression.ni(name, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Serializable[] value, Predicate<Serializable[]> ignoreStrategy) {
        return expression.ni(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(Serializable value) {
        return expression.le0(name, value, expression.getIgnoreStrategy());
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
        return expression.le0(name, value, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(Serializable value) {
        return expression.lt0(name, value, expression.getIgnoreStrategy());
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
        return expression.lt0(name, value, v -> ignoreStrategy.test((Serializable) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(Serializable value) {
        return expression.ge0(name, value, expression.getIgnoreStrategy());
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
        return expression.ge0(name, value, v -> ignoreStrategy.test((Serializable) v));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(Serializable value) {
        return expression.gt0(name, value, expression.getIgnoreStrategy());
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
        return expression.gt0(name, value, v -> ignoreStrategy.test((Serializable) v));
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
    public L ba(Serializable min, Serializable max) {
        return nba(min, max, (m1, m2) -> expression.getIgnoreStrategy().test(new Serializable[] { m1, m2 }));
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
        return expression.ba0(name, min, max, ignoreStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(Serializable min, Serializable max) {
        return nba(min, max, (m1, m2) -> expression.getIgnoreStrategy().test(new Serializable[] { m1, m2 }));
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
        return expression.nba0(name, min, max, ignoreStrategy);
    }
}
