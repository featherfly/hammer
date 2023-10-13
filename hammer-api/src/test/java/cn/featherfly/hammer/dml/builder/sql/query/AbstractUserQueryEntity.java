
package cn.featherfly.hammer.dml.builder.sql.query;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import cn.featherfly.common.function.serializable.SerializableFunction;
import cn.featherfly.common.operator.AggregateFunction;
import cn.featherfly.common.repository.mapping.RowMapper;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.hammer.dsl.query.QuerySortExpression;
import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.expression.query.QueryEntityPropertiesExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.query.QueryRelateEntityExpression;
import cn.featherfly.hammer.expression.query.QueryRelateExpression;
import cn.featherfly.hammer.expression.query.QueryRelateOnExpression;

/**
 * The Class AbstractUserQueryEntity.
 *
 * @author zhongj
 * @param <Q>   the generic type
 * @param <QW>  the generic type
 * @param <QWO> the generic type
 * @param <QWE> the generic type
 */
public class AbstractUserQueryEntity<Q extends AbstractUserQueryEntity<Q, QW, QWO, QWE>,
        QW extends QueryRelateExpression<QW, QWO, QWE, UserQueryRepositoryConditionGroupExpression,
                UserQueryRepositoryConditionGroupExpression>,
        QWO extends QueryRelateOnExpression<QW, QWO, QWE, UserQueryRepositoryConditionGroupExpression,
                UserQueryRepositoryConditionGroupExpression>,
        QWE extends QueryRelateEntityExpression<QW, QWO, QWE, UserQueryRepositoryConditionGroupExpression,
                UserQueryRepositoryConditionGroupExpression>>
        implements
        QueryEntityPropertiesExpression<Q, QW, QWO, QWE, UserQueryConditionGroupExpression,
                UserQueryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression,
                UserQueryRepositoryConditionGroupExpression> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Q property(String propertyName) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q property(String... propertyNames) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q property(Collection<String> propertyNames) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression where() {

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
    public String string() {

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
    @SuppressWarnings("unchecked")
    @Override
    public <T, R> Q property(SerializableFunction<T, R>... propertyNames) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> Q property(SerializableFunction<T, R> propertyName) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q id(String propertyName) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> Q id(SerializableFunction<T, R> propertyName) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuerySortExpression sort() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long count() {

        return 0l;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q sum(String propertyName) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q max(String propertyName) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q min(String propertyName) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q avg(String propertyName) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q count(String propertyName) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> Q count(SerializableFunction<T, R> propertyName) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> Q sum(SerializableFunction<T, R> propertyName) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> Q max(SerializableFunction<T, R> propertyName) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> Q min(SerializableFunction<T, R> propertyName) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> Q avg(SerializableFunction<T, R> propertyName) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> Q distinct(SerializableFunction<T, R> propertyName) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression where(
            Consumer<ConditionGroupConfig<UserQueryConditionGroupExpression>> consumer) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> Q count(boolean distinct, SerializableFunction<T, R> propertyName) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q sum(boolean distinct, String propertyName) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> Q sum(boolean distinct, SerializableFunction<T, R> propertyName) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q max(boolean distinct, String propertyName) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> Q max(boolean distinct, SerializableFunction<T, R> propertyName) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q min(boolean distinct, String propertyName) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> Q min(boolean distinct, SerializableFunction<T, R> propertyName) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q avg(boolean distinct, String propertyName) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> Q avg(boolean distinct, SerializableFunction<T, R> propertyName) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q property(boolean distinct, String propertyName) {
        System.out.println("boolean distinct, String propertyName");
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q property(AggregateFunction aggregateFunction, boolean distinct, String propertyName) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> Q property(boolean distinct, SerializableFunction<T, R> propertyName) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> Q property(AggregateFunction aggregateFunction, boolean distinct,
            SerializableFunction<T, R> propertyName) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QWO join(String repositoryName) {

        return null;
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
    public Date date() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDate localDate() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime localDateTime() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalTime localTime() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp timestamp() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] bytes() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Clob clob() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Blob blob() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean bool() {
        // YUFEI_TODO Auto-generated method stub
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte byteValue() {
        // YUFEI_TODO Auto-generated method stub
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public short shortValue() {
        // YUFEI_TODO Auto-generated method stub
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T value(Class<T> type) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

}
