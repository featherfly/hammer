
package cn.featherfly.juorm.dml.builder.sql.query;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import cn.featherfly.common.lang.function.SerializableFunction;
import cn.featherfly.common.structure.page.Page;
import cn.featherfly.juorm.expression.query.QueryEntityPropertiesExpression;
import cn.featherfly.juorm.expression.query.QueryExecutor;
import cn.featherfly.juorm.expression.query.QueryWithEntityExpression;
import cn.featherfly.juorm.expression.query.QueryWithExpression;
import cn.featherfly.juorm.expression.query.QueryWithOnExpression;
import cn.featherfly.juorm.mapping.RowMapper;

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
    public QueryExecutor limit(Integer limit) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryExecutor limit(Integer offset, Integer limit) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QueryExecutor limit(Page page) {

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

}
