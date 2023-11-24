//
//package cn.featherfly.hammer.dml.builder.sql.query;
//
//import java.sql.Blob;
//import java.sql.Clob;
//import java.sql.Timestamp;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//import java.util.function.BiPredicate;
//import java.util.function.Function;
//import java.util.function.Predicate;
//
//import cn.featherfly.common.function.serializable.SerializableDateSupplier;
//import cn.featherfly.common.function.serializable.SerializableLocalDateSupplier;
//import cn.featherfly.common.function.serializable.SerializableLocalDateTimeSupplier;
//import cn.featherfly.common.function.serializable.SerializableLocalTimeSupplier;
//import cn.featherfly.common.function.serializable.SerializableNumberSupplier;
//import cn.featherfly.common.function.serializable.SerializableStringSupplier;
//import cn.featherfly.common.function.serializable.SerializableSupplier;
//import cn.featherfly.common.operator.ComparisonOperator.MatchStrategy;
//import cn.featherfly.common.operator.LogicOperator;
//import cn.featherfly.common.repository.IgnoreStrategy;
//import cn.featherfly.common.repository.mapping.RowMapper;
//import cn.featherfly.common.structure.page.Page;
//import cn.featherfly.hammer.dsl.query.QueryConditionsGroupExpression;
//import cn.featherfly.hammer.dsl.query.QueryConditionsGroupLogicExpression;
//import cn.featherfly.hammer.dsl.query.QuerySortExpression;
//import cn.featherfly.hammer.expression.condition.field.NumberFieldExpression;
//import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
//import cn.featherfly.hammer.sqldb.jdbc.dsl.repository.condition.field.StringPropertyExpression;
//
///**
// * The Class UserQueryConditionGroupExpression.
// *
// * @author zhongj
// */
//public class UserQueryConditionGroupExpression
//        implements QueryConditionsGroupExpression, QueryConditionsGroupLogicExpression {
//
//    /**
//     * Instantiates a new user query condition group expression.
//     */
//    public UserQueryConditionGroupExpression() {
//    }
//
//    /**
//     * Name.
//     *
//     * @return the string expression
//     */
//    public StringFieldExpression<QueryConditionsGroupExpression, QueryConditionsGroupLogicExpression> name() {
//        //        return property("name");
//        return null;
//    }
//
//    /**
//     * Age.
//     *
//     * @return the number expression
//     */
//    public NumberFieldExpression<Integer, QueryConditionsGroupExpression, QueryConditionsGroupLogicExpression> age() {
//        //        return propertyNumber("age");
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public UserQueryConditionGroupExpression group() {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public UserQueryConditionGroupExpression co(String name, String value) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <N extends Number> QueryConditionsGroupLogicExpression ba(String name, N min, N max) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <N extends Number> QueryConditionsGroupLogicExpression ba(String name, N min, N max,
//            IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <N extends Number> QueryConditionsGroupLogicExpression ba(String name, N min, N max,
//            BiPredicate<N, N> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <D extends Date> QueryConditionsGroupLogicExpression ba(String name, D min, D max) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <D extends Date> QueryConditionsGroupLogicExpression ba(String name, D min, D max,
//            IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <D extends Date> QueryConditionsGroupLogicExpression ba(String name, D min, D max,
//            BiPredicate<D, D> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ba(String name, LocalTime min, LocalTime max) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ba(String name, LocalTime min, LocalTime max,
//            IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ba(String name, LocalTime min, LocalTime max,
//            BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ba(String name, LocalDate min, LocalDate max) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ba(String name, LocalDate min, LocalDate max,
//            IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ba(String name, LocalDate min, LocalDate max,
//            BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ba(String name, LocalDateTime min, LocalDateTime max) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ba(String name, LocalDateTime min, LocalDateTime max,
//            IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ba(String name, LocalDateTime min, LocalDateTime max,
//            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ba(String name, String min, String max) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ba(String name, String min, String max, IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ba(String name, String min, String max,
//            BiPredicate<String, String> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public String expression() {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <N extends Number> QueryConditionsGroupLogicExpression nba(String name, N min, N max) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <N extends Number> QueryConditionsGroupLogicExpression nba(String name, N min, N max,
//            IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <N extends Number> QueryConditionsGroupLogicExpression nba(String name, N min, N max,
//            BiPredicate<N, N> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <D extends Date> QueryConditionsGroupLogicExpression nba(String name, D min, D max) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <D extends Date> QueryConditionsGroupLogicExpression nba(String name, D min, D max,
//            IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <D extends Date> QueryConditionsGroupLogicExpression nba(String name, D min, D max,
//            BiPredicate<D, D> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression nba(String name, LocalTime min, LocalTime max) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression nba(String name, LocalTime min, LocalTime max,
//            IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression nba(String name, LocalTime min, LocalTime max,
//            BiPredicate<LocalTime, LocalTime> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression nba(String name, LocalDate min, LocalDate max) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression nba(String name, LocalDate min, LocalDate max,
//            IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression nba(String name, LocalDate min, LocalDate max,
//            BiPredicate<LocalDate, LocalDate> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression nba(String name, LocalDateTime min, LocalDateTime max) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression nba(String name, LocalDateTime min, LocalDateTime max,
//            IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression nba(String name, LocalDateTime min, LocalDateTime max,
//            BiPredicate<LocalDateTime, LocalDateTime> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression nba(String name, String min, String max) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression nba(String name, String min, String max, IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression nba(String name, String min, String max,
//            BiPredicate<String, String> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression co(String name, String value, MatchStrategy matchStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression co(String name, String value, MatchStrategy matchStrategy,
//            IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression co(String name, String value, MatchStrategy matchStrategy,
//            Predicate<String> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression nco(String name, String value, MatchStrategy matchStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression nco(String name, String value, MatchStrategy matchStrategy,
//            IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression nco(String name, String value, MatchStrategy matchStrategy,
//            Predicate<String> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ew(String name, String value, MatchStrategy matchStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ew(String name, String value, MatchStrategy matchStrategy,
//            IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ew(String name, String value, MatchStrategy matchStrategy,
//            Predicate<String> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression newv(String name, String value, MatchStrategy matchStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression newv(String name, String value, MatchStrategy matchStrategy,
//            IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression newv(String name, String value, MatchStrategy matchStrategy,
//            Predicate<String> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression eq(String name, Object value, MatchStrategy matchStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <R> QueryConditionsGroupLogicExpression eq(String name, R value, MatchStrategy matchStrategy,
//            Predicate<R> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ne(String name, Object value, MatchStrategy matchStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <R> QueryConditionsGroupLogicExpression ne(String name, R value, MatchStrategy matchStrategy,
//            Predicate<R> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <N extends Number> QueryConditionsGroupLogicExpression ge(String name, N value) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <N extends Number> QueryConditionsGroupLogicExpression ge(String name, N value,
//            IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <N extends Number> QueryConditionsGroupLogicExpression ge(String name, N value, Predicate<N> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <D extends Date> QueryConditionsGroupLogicExpression ge(String name, D value) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <D extends Date> QueryConditionsGroupLogicExpression ge(String name, D value, IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <D extends Date> QueryConditionsGroupLogicExpression ge(String name, D value, Predicate<D> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ge(String name, LocalTime value) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ge(String name, LocalTime value, IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ge(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ge(String name, LocalDate value) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ge(String name, LocalDate value, IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ge(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ge(String name, LocalDateTime value) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ge(String name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ge(String name, LocalDateTime value,
//            Predicate<LocalDateTime> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ge(String name, String value) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ge(String name, String value, IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ge(String name, String value, Predicate<String> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <N extends Number> QueryConditionsGroupLogicExpression gt(String name, N value) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <N extends Number> QueryConditionsGroupLogicExpression gt(String name, N value,
//            IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <N extends Number> QueryConditionsGroupLogicExpression gt(String name, N value, Predicate<N> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <D extends Date> QueryConditionsGroupLogicExpression gt(String name, D value) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <D extends Date> QueryConditionsGroupLogicExpression gt(String name, D value, IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <D extends Date> QueryConditionsGroupLogicExpression gt(String name, D value, Predicate<D> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression gt(String name, LocalTime value) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression gt(String name, LocalTime value, IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression gt(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression gt(String name, LocalDate value) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression gt(String name, LocalDate value, IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression gt(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression gt(String name, LocalDateTime value) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression gt(String name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression gt(String name, LocalDateTime value,
//            Predicate<LocalDateTime> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression gt(String name, String value) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression gt(String name, String value, IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression gt(String name, String value, Predicate<String> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression in(String name, int... values) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression in(String name, int[] values, Predicate<int[]> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression in(String name, long... value) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression in(String name, long[] values, Predicate<long[]> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression in(String name, double... values) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression in(String name, double[] values, Predicate<double[]> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression in(String name, String[] values, MatchStrategy matchStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression in(String name, String[] values, MatchStrategy matchStrategy,
//            Predicate<String[]> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <R> QueryConditionsGroupLogicExpression in(String name, R... values) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <R> QueryConditionsGroupLogicExpression in(String name, R value, Predicate<R> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ni(String name, int... values) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ni(String name, int[] values, Predicate<int[]> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ni(String name, long... value) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ni(String name, long[] values, Predicate<long[]> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ni(String name, double... values) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ni(String name, double[] values, Predicate<double[]> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ni(String name, String[] values, MatchStrategy matchStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ni(String name, String[] values, MatchStrategy matchStrategy,
//            Predicate<String[]> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <R> QueryConditionsGroupLogicExpression ni(String name, R... values) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <R> QueryConditionsGroupLogicExpression ni(String name, R value, Predicate<R> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression inn(String name, Boolean value) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression isn(String name, Boolean value) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <N extends Number> QueryConditionsGroupLogicExpression le(String name, N value) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <N extends Number> QueryConditionsGroupLogicExpression le(String name, N value,
//            IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <N extends Number> QueryConditionsGroupLogicExpression le(String name, N value, Predicate<N> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <D extends Date> QueryConditionsGroupLogicExpression le(String name, D value) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <D extends Date> QueryConditionsGroupLogicExpression le(String name, D value, IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <D extends Date> QueryConditionsGroupLogicExpression le(String name, D value, Predicate<D> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression le(String name, LocalTime value) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression le(String name, LocalTime value, IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression le(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression le(String name, LocalDate value) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression le(String name, LocalDate value, IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression le(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression le(String name, LocalDateTime value) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression le(String name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression le(String name, LocalDateTime value,
//            Predicate<LocalDateTime> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression le(String name, String value) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression le(String name, String value, IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression le(String name, String value, Predicate<String> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <N extends Number> QueryConditionsGroupLogicExpression lt(String name, N value) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <N extends Number> QueryConditionsGroupLogicExpression lt(String name, N value,
//            IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <N extends Number> QueryConditionsGroupLogicExpression lt(String name, N value, Predicate<N> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <D extends Date> QueryConditionsGroupLogicExpression lt(String name, D value) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <D extends Date> QueryConditionsGroupLogicExpression lt(String name, D value, IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <D extends Date> QueryConditionsGroupLogicExpression lt(String name, D value, Predicate<D> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression lt(String name, LocalTime value) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression lt(String name, LocalTime value, IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression lt(String name, LocalTime value, Predicate<LocalTime> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression lt(String name, LocalDate value) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression lt(String name, LocalDate value, IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression lt(String name, LocalDate value, Predicate<LocalDate> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression lt(String name, LocalDateTime value) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression lt(String name, LocalDateTime value, IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression lt(String name, LocalDateTime value,
//            Predicate<LocalDateTime> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression lt(String name, String value) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression lt(String name, String value, IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression lt(String name, String value, Predicate<String> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression sw(String name, String value, MatchStrategy matchStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression sw(String name, String value, MatchStrategy matchStrategy,
//            IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression sw(String name, String value, MatchStrategy matchStrategy,
//            Predicate<String> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression nsw(String name, String value, MatchStrategy matchStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression nsw(String name, String value, MatchStrategy matchStrategy,
//            IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression nsw(String name, String value, MatchStrategy matchStrategy,
//            Predicate<String> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression lk(String name, String value, MatchStrategy matchStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression lk(String name, String value, MatchStrategy matchStrategy,
//            IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression lk(String name, String value, MatchStrategy matchStrategy,
//            Predicate<String> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression nl(String name, String value, MatchStrategy matchStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression nl(String name, String value, MatchStrategy matchStrategy,
//            IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression nl(String name, String value, MatchStrategy matchStrategy,
//            Predicate<String> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression expression(String expression, Map<String, Object> params) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression expression(String expression, Object... params) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression group(
//            Function<QueryConditionsGroupExpression, QueryConditionsGroupLogicExpression> group) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryLimitExecutor limit(Integer limit) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryLimitExecutor limit(Integer offset, Integer limit) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryLimitExecutor limit(Page page) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public List<Map<String, Object>> list() {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <E> List<E> list(Class<E> type) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <E> List<E> list(RowMapper<E> rowMapper) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public Map<String, Object> single() {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public Map<String, Object> unique() {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <E> E single(Class<E> type) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <E> E unique(Class<E> type) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <E> E single(RowMapper<E> rowMapper) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <E> E unique(RowMapper<E> rowMapper) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public String string() {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public Date date() {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public LocalDate localDate() {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public LocalDateTime localDateTime() {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public LocalTime localTime() {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public Timestamp timestamp() {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public byte[] bytes() {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public Clob clob() {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public Blob blob() {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public boolean bool() {
//
//        return false;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public byte byteValue() {
//
//        return 0;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public short shortValue() {
//
//        return 0;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public int intValue() {
//
//        return 0;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public long longValue() {
//
//        return 0;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T> T value(Class<T> type) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <T> T value() {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public long count() {
//
//        return 0;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression endGroup() {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupExpression logic(LogicOperator operator) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupExpression and() {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression and(
//            Function<QueryConditionsGroupExpression, QueryConditionsGroupLogicExpression> group) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupExpression or() {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression or(
//            Function<QueryConditionsGroupExpression, QueryConditionsGroupLogicExpression> group) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QuerySortExpression sort() {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression co(SerializableStringSupplier propertyValue,
//            MatchStrategy matchStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression co(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
//            IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression co(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
//            Predicate<String> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression nco(SerializableStringSupplier propertyValue,
//            MatchStrategy matchStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression nco(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
//            IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression nco(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
//            Predicate<String> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ew(SerializableStringSupplier propertyValue,
//            MatchStrategy matchStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ew(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
//            Predicate<String> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression newv(SerializableStringSupplier propertyValue,
//            MatchStrategy matchStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression newv(SerializableStringSupplier propertyValue,
//            MatchStrategy matchStrategy, IgnoreStrategy ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression newv(SerializableStringSupplier propertyValue,
//            MatchStrategy matchStrategy, Predicate<String> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <R> QueryConditionsGroupLogicExpression eq(SerializableSupplier<R> property, MatchStrategy matchStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <R> QueryConditionsGroupLogicExpression eq(SerializableSupplier<R> property, MatchStrategy matchStrategy,
//            Predicate<R> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <R> QueryConditionsGroupLogicExpression ne(SerializableSupplier<R> property, MatchStrategy matchStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <R> QueryConditionsGroupLogicExpression ne(SerializableSupplier<R> property, MatchStrategy matchStrategy,
//            Predicate<R> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <N extends Number> QueryConditionsGroupLogicExpression ge(SerializableNumberSupplier<N> property) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <N extends Number> QueryConditionsGroupLogicExpression ge(SerializableNumberSupplier<N> property,
//            Predicate<N> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <D extends Date> QueryConditionsGroupLogicExpression ge(SerializableDateSupplier<D> property) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <D extends Date> QueryConditionsGroupLogicExpression ge(SerializableDateSupplier<D> property,
//            Predicate<D> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ge(SerializableLocalTimeSupplier property) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ge(SerializableLocalTimeSupplier property,
//            Predicate<LocalTime> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ge(SerializableLocalDateSupplier property) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ge(SerializableLocalDateSupplier property,
//            Predicate<LocalDate> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ge(SerializableLocalDateTimeSupplier property) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ge(SerializableLocalDateTimeSupplier property,
//            Predicate<LocalDateTime> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ge(SerializableStringSupplier property) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression ge(SerializableStringSupplier property,
//            Predicate<String> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <N extends Number> QueryConditionsGroupLogicExpression gt(SerializableNumberSupplier<N> property) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <N extends Number> QueryConditionsGroupLogicExpression gt(SerializableNumberSupplier<N> property,
//            Predicate<N> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <D extends Date> QueryConditionsGroupLogicExpression gt(SerializableDateSupplier<D> property) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <D extends Date> QueryConditionsGroupLogicExpression gt(SerializableDateSupplier<D> property,
//            Predicate<D> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression gt(SerializableLocalTimeSupplier property) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression gt(SerializableLocalTimeSupplier property,
//            Predicate<LocalTime> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression gt(SerializableLocalDateSupplier property) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression gt(SerializableLocalDateSupplier property,
//            Predicate<LocalDate> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression gt(SerializableLocalDateTimeSupplier property) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression gt(SerializableLocalDateTimeSupplier property,
//            Predicate<LocalDateTime> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression gt(SerializableStringSupplier property) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression gt(SerializableStringSupplier property,
//            Predicate<String> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <N extends Number> QueryConditionsGroupLogicExpression le(SerializableNumberSupplier<N> property) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <N extends Number> QueryConditionsGroupLogicExpression le(SerializableNumberSupplier<N> property,
//            Predicate<N> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <D extends Date> QueryConditionsGroupLogicExpression le(SerializableDateSupplier<D> property) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <D extends Date> QueryConditionsGroupLogicExpression le(SerializableDateSupplier<D> property,
//            Predicate<D> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression le(SerializableLocalTimeSupplier property) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression le(SerializableLocalTimeSupplier property,
//            Predicate<LocalTime> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression le(SerializableLocalDateSupplier property) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression le(SerializableLocalDateSupplier property,
//            Predicate<LocalDate> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression le(SerializableLocalDateTimeSupplier property) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression le(SerializableLocalDateTimeSupplier property,
//            Predicate<LocalDateTime> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression le(SerializableStringSupplier property) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression le(SerializableStringSupplier property,
//            Predicate<String> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <N extends Number> QueryConditionsGroupLogicExpression lt(SerializableNumberSupplier<N> property) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <N extends Number> QueryConditionsGroupLogicExpression lt(SerializableNumberSupplier<N> property,
//            Predicate<N> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <D extends Date> QueryConditionsGroupLogicExpression lt(SerializableDateSupplier<D> property) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public <D extends Date> QueryConditionsGroupLogicExpression lt(SerializableDateSupplier<D> property,
//            Predicate<D> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression lt(SerializableLocalTimeSupplier property) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression lt(SerializableLocalTimeSupplier property,
//            Predicate<LocalTime> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression lt(SerializableLocalDateSupplier property) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression lt(SerializableLocalDateSupplier property,
//            Predicate<LocalDate> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression lt(SerializableLocalDateTimeSupplier property) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression lt(SerializableLocalDateTimeSupplier property,
//            Predicate<LocalDateTime> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression lt(SerializableStringSupplier property) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression lt(SerializableStringSupplier property,
//            Predicate<String> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression sw(SerializableStringSupplier propertyValue,
//            MatchStrategy matchStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression sw(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
//            Predicate<String> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression nsw(SerializableStringSupplier propertyValue,
//            MatchStrategy matchStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression nsw(SerializableStringSupplier propertyValue, MatchStrategy matchStrategy,
//            Predicate<String> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression lk(SerializableStringSupplier property, MatchStrategy matchStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression lk(SerializableStringSupplier property, MatchStrategy matchStrategy,
//            Predicate<String> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression nl(SerializableStringSupplier property, MatchStrategy matchStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public QueryConditionsGroupLogicExpression nl(SerializableStringSupplier property, MatchStrategy matchStrategy,
//            Predicate<String> ignoreStrategy) {
//
//        return null;
//    }
//
//    /**
//     * {@inheritDoc}
//     */
//    @Override
//    public double doubleValue() {
//        // YUFEI_TODO Auto-generated method stub
//        return 0;
//    }
//
//}
