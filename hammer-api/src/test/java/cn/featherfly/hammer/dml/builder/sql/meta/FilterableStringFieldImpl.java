
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-10 16:15:10
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.dml.builder.sql.meta;

import java.util.Collection;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.repository.Field;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.hammer.dsl.repository.query.RepositoryQueryConditionsGroup;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.condition.LogicExpression;
import cn.featherfly.hammer.expression.condition.field.FieldExpression;

/**
 * StringFieldImpl.
 *
 * @author zhongj
 */
public class FilterableStringFieldImpl<C extends ConditionExpression, L extends LogicExpression<C, L>> extends FieldImpl
    implements FilterableStringField<C, L>, FilterableStringAliasField<C, L> {

    private RepositoryQueryConditionsGroup queryCondition;

    /**
     * @param name
     */
    public FilterableStringFieldImpl(String name, RepositoryQueryConditionsGroup queryCondition) {
        this(name, null, queryCondition);
    }

    /**
     * @param name
     */
    public FilterableStringFieldImpl(String name, String alias, RepositoryQueryConditionsGroup queryCondition) {
        super(name, alias);
        this.queryCondition = queryCondition;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String value, MatchStrategy matchStrategy) {
        return (L) queryCondition.eq(name(), value, matchStrategy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ne(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(String min, String max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(String min, String max, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ba(String min, String max, BiPredicate<String, String> ignoreStrategy) {

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
    public L nba(String min, String max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(String min, String max, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nba(String min, String max, BiPredicate<String, String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String[] value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String value, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String[] value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(String[] value, Predicate<String[]> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String[] value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String value, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String[] value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(String[] value, Predicate<String[]> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L le(String value, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lt(String value, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ge(String value, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L gt(String value, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L sw(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(String value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nsw(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L co(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(String value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nco(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ew(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(String value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L newv(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L lk(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl(String value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl(String value, MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L nl(String value, MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L isn(Boolean value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L inn(Boolean value) {

        return null;
    }

    //    @Override
    //    public FilterableStringAliasField<C, L> alias(String alias) {
    //        return new FilterableStringFieldImpl<>(name(), alias, queryCondition);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(Field field) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L eq(FieldExpression expression) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L in(Collection<String> value, Predicate<Collection<String>> ignoreStrategy) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public L ni(Collection<String> value, Predicate<Collection<String>> ignoreStrategy) {
        return null;
    }
}
