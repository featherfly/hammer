
package cn.featherfly.hammer.dml.builder.sql.query;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.repository.mapping.RowMapper;
import cn.featherfly.common.repository.operate.AggregateFunction;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.hammer.dsl.query.QuerySortExpression;
import cn.featherfly.hammer.expression.condition.ConditionGroupConfig;
import cn.featherfly.hammer.expression.query.QueryEntityPropertiesExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.expression.query.QueryWithEntityExpression;
import cn.featherfly.hammer.expression.query.QueryWithExpression;
import cn.featherfly.hammer.expression.query.QueryWithOnExpression;

/**
 * <p>
 * UserUpdate
 * </p>
 *
 * @author zhongj
 */
public class AbstractUserQueryEntity<Q extends AbstractUserQueryEntity<Q, QW, QWO, QWE>,
        QW extends QueryWithExpression<QW, QWO, QWE, UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression>,
        QWO extends QueryWithOnExpression<QW, QWO, QWE, UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression>,
        QWE extends QueryWithEntityExpression<QW, QWO, QWE, UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression>>
        implements
        QueryEntityPropertiesExpression<Q, QW, QWO, QWE, UserQueryConditionGroupExpression, UserQueryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression, UserQueryRepositoryConditionGroupExpression> {

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
    public Integer integer() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long longInt() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal decimal() {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <N extends Number> N number(Class<N> type) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> Q property(SerializableFunction<T, R>... propertyNames) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> Q property(SerializableFunction<T, R> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QWO with(String repositoryName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q id(String propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> Q id(SerializableFunction<T, R> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> QWO with(Class<T> repositoryType) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuerySortExpression sort() {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Long count() {
        // YUFEI_TODO Auto-generated method stub
        return 0l;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q property(String propertyName, AggregateFunction aggregateFunction) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> Q property(SerializableFunction<T, R> propertyName, AggregateFunction aggregateFunction) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q sum(String propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q max(String propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q min(String propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q avg(String propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q distinct(String propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Q count(String propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> Q count(SerializableFunction<T, R> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> Q sum(SerializableFunction<T, R> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> Q max(SerializableFunction<T, R> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> Q min(SerializableFunction<T, R> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> Q avg(SerializableFunction<T, R> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T, R> Q distinct(SerializableFunction<T, R> propertyName) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserQueryConditionGroupExpression where(Consumer<ConditionGroupConfig> consumer) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }

}
