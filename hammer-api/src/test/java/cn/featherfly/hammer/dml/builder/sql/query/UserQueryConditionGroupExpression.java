
package cn.featherfly.hammer.dml.builder.sql.query;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
import cn.featherfly.common.operator.LogicOperator;
import cn.featherfly.common.repository.IgnoreStrategy;
import cn.featherfly.common.repository.mapping.RowMapper;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.hammer.dsl.query.QueryConditionGroupExpression;
import cn.featherfly.hammer.dsl.query.QueryConditionGroupLogicExpression;
import cn.featherfly.hammer.dsl.query.QuerySortExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.repository.condition.property.NumberPropertyExpression;
import cn.featherfly.hammer.expression.repository.condition.property.StringPropertyExpression;

/**
 * The Class UserQueryConditionGroupExpression.
 *
 * @author zhongj
 */
public class UserQueryConditionGroupExpression
        implements QueryConditionGroupExpression, QueryConditionGroupLogicExpression {

    /**
     * Instantiates a new user query condition group expression.
     */
    public UserQueryConditionGroupExpression() {
    }

    /**
     * Name.
     *
     * @return the string expression
     */
    public StringPropertyExpression<QueryConditionGroupExpression, QueryConditionGroupLogicExpression> name() {
        //        return property("name");
        return null;
    }

    /**
     * Age.
     *
     * @return the number expression
     */
    public NumberPropertyExpression<Integer, QueryConditionGroupExpression, QueryConditionGroupLogicExpression> age() {
        //        return propertyNumber("age");
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression group() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression co(String name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> QueryConditionGroupLogicExpression ba(String name, N min, N max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> QueryConditionGroupLogicExpression ba(String name, N min, N max,
            IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> QueryConditionGroupLogicExpression ba(String name, N min, N max,
            BiPredicate<N, N> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> QueryConditionGroupLogicExpression ba(String name, D min, D max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> QueryConditionGroupLogicExpression ba(String name, D min, D max,
            IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> QueryConditionGroupLogicExpression ba(String name, D min, D max,
            BiPredicate<D, D> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ba(String name, LocalTime min, LocalTime max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ba(String name, LocalTime min, LocalTime max,
            IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ba(String name, LocalTime min, LocalTime max,
            BiPredicate<LocalTime, LocalTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ba(String name, LocalDate min, LocalDate max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ba(String name, LocalDate min, LocalDate max,
            IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ba(String name, LocalDate min, LocalDate max,
            BiPredicate<LocalDate, LocalDate> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ba(String name, LocalDateTime min, LocalDateTime max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ba(String name, LocalDateTime min, LocalDateTime max,
            IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ba(String name, LocalDateTime min, LocalDateTime max,
            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ba(String name, String min, String max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ba(String name, String min, String max, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ba(String name, String min, String max,
            BiPredicate<String, String> ignoreStrategy) {

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
    public <N extends Number> QueryConditionGroupLogicExpression nba(String name, N min, N max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> QueryConditionGroupLogicExpression nba(String name, N min, N max,
            IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> QueryConditionGroupLogicExpression nba(String name, N min, N max,
            BiPredicate<N, N> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> QueryConditionGroupLogicExpression nba(String name, D min, D max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> QueryConditionGroupLogicExpression nba(String name, D min, D max,
            IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> QueryConditionGroupLogicExpression nba(String name, D min, D max,
            BiPredicate<D, D> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression nba(String name, LocalTime min, LocalTime max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression nba(String name, LocalTime min, LocalTime max,
            IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression nba(String name, LocalTime min, LocalTime max,
            BiPredicate<LocalTime, LocalTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression nba(String name, LocalDate min, LocalDate max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression nba(String name, LocalDate min, LocalDate max,
            IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression nba(String name, LocalDate min, LocalDate max,
            BiPredicate<LocalDate, LocalDate> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression nba(String name, LocalDateTime min, LocalDateTime max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression nba(String name, LocalDateTime min, LocalDateTime max,
            IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression nba(String name, LocalDateTime min, LocalDateTime max,
            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression nba(String name, String min, String max) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression nba(String name, String min, String max, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression nba(String name, String min, String max,
            BiPredicate<String, String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression co(String name, String value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression co(String name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression co(String name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression nco(String name, String value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression nco(String name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression nco(String name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ew(String name, String value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ew(String name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ew(String name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression newv(String name, String value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression newv(String name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression newv(String name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression eq(String name, Object value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> QueryConditionGroupLogicExpression eq(String name, R value, MatchStrategy matchStrategy,
            Predicate<R> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ne(String name, Object value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> QueryConditionGroupLogicExpression ne(String name, R value, MatchStrategy matchStrategy,
            Predicate<R> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> QueryConditionGroupLogicExpression ge(String name, N value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> QueryConditionGroupLogicExpression ge(String name, N value,
            IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> QueryConditionGroupLogicExpression ge(String name, N value, Predicate<N> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> QueryConditionGroupLogicExpression ge(String name, D value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> QueryConditionGroupLogicExpression ge(String name, D value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> QueryConditionGroupLogicExpression ge(String name, D value, Predicate<D> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ge(String name, LocalTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ge(String name, LocalTime value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ge(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ge(String name, LocalDate value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ge(String name, LocalDate value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ge(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ge(String name, LocalDateTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ge(String name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ge(String name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ge(String name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ge(String name, String value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ge(String name, String value, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> QueryConditionGroupLogicExpression gt(String name, N value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> QueryConditionGroupLogicExpression gt(String name, N value,
            IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> QueryConditionGroupLogicExpression gt(String name, N value, Predicate<N> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> QueryConditionGroupLogicExpression gt(String name, D value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> QueryConditionGroupLogicExpression gt(String name, D value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> QueryConditionGroupLogicExpression gt(String name, D value, Predicate<D> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression gt(String name, LocalTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression gt(String name, LocalTime value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression gt(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression gt(String name, LocalDate value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression gt(String name, LocalDate value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression gt(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression gt(String name, LocalDateTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression gt(String name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression gt(String name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression gt(String name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression gt(String name, String value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression gt(String name, String value, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression in(String name, int... values) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression in(String name, int[] values, Predicate<int[]> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression in(String name, long... value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression in(String name, long[] values, Predicate<long[]> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression in(String name, double... values) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression in(String name, double[] values, Predicate<double[]> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression in(String name, String[] values, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression in(String name, String[] values, MatchStrategy matchStrategy,
            Predicate<String[]> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> QueryConditionGroupLogicExpression in(String name, R... values) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> QueryConditionGroupLogicExpression in(String name, R value, Predicate<R> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ni(String name, int... values) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ni(String name, int[] values, Predicate<int[]> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ni(String name, long... value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ni(String name, long[] values, Predicate<long[]> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ni(String name, double... values) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ni(String name, double[] values, Predicate<double[]> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ni(String name, String[] values, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression ni(String name, String[] values, MatchStrategy matchStrategy,
            Predicate<String[]> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> QueryConditionGroupLogicExpression ni(String name, R... values) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <R> QueryConditionGroupLogicExpression ni(String name, R value, Predicate<R> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression inn(String name, Boolean value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression isn(String name, Boolean value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> QueryConditionGroupLogicExpression le(String name, N value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> QueryConditionGroupLogicExpression le(String name, N value,
            IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> QueryConditionGroupLogicExpression le(String name, N value, Predicate<N> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> QueryConditionGroupLogicExpression le(String name, D value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> QueryConditionGroupLogicExpression le(String name, D value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> QueryConditionGroupLogicExpression le(String name, D value, Predicate<D> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression le(String name, LocalTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression le(String name, LocalTime value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression le(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression le(String name, LocalDate value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression le(String name, LocalDate value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression le(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression le(String name, LocalDateTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression le(String name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression le(String name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression le(String name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression le(String name, String value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression le(String name, String value, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> QueryConditionGroupLogicExpression lt(String name, N value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> QueryConditionGroupLogicExpression lt(String name, N value,
            IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> QueryConditionGroupLogicExpression lt(String name, N value, Predicate<N> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> QueryConditionGroupLogicExpression lt(String name, D value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> QueryConditionGroupLogicExpression lt(String name, D value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <D extends Date> QueryConditionGroupLogicExpression lt(String name, D value, Predicate<D> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression lt(String name, LocalTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression lt(String name, LocalTime value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression lt(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression lt(String name, LocalDate value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression lt(String name, LocalDate value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression lt(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression lt(String name, LocalDateTime value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression lt(String name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression lt(String name, LocalDateTime value,
            Predicate<LocalDateTime> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression lt(String name, String value) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression lt(String name, String value, IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression lt(String name, String value, Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression sw(String name, String value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression sw(String name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression sw(String name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression nsw(String name, String value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression nsw(String name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression nsw(String name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression lk(String name, String value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression lk(String name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression lk(String name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression nl(String name, String value, MatchStrategy matchStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression nl(String name, String value, MatchStrategy matchStrategy,
            IgnoreStrategy ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression nl(String name, String value, MatchStrategy matchStrategy,
            Predicate<String> ignoreStrategy) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression expression(String expression, Map<String, Object> params) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression expression(String expression, Object... params) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression group(
            Function<QueryConditionGroupExpression, QueryConditionGroupLogicExpression> group) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(Integer limit) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(Integer offset, Integer limit) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryLimitExecutor limit(Page page) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(Class<E> type) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(RowMapper<E> rowMapper) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> single() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> unique() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(Class<E> type) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E unique(Class<E> type) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(RowMapper<E> rowMapper) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E unique(RowMapper<E> rowMapper) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String string() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date date() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDate localDate() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime localDateTime() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalTime localTime() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp timestamp() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] bytes() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Clob clob() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Blob blob() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean bool() {

        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte byteValue() {

        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public short shortValue() {

        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int intValue() {

        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long longValue() {

        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T value(Class<T> type) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T value() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long count() {

        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression endGroup() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupExpression logic(LogicOperator operator) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupExpression and() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression and(
            Function<QueryConditionGroupExpression, QueryConditionGroupLogicExpression> group) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupExpression or() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryConditionGroupLogicExpression or(
            Function<QueryConditionGroupExpression, QueryConditionGroupLogicExpression> group) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuerySortExpression sort() {

        return null;
    }

}
