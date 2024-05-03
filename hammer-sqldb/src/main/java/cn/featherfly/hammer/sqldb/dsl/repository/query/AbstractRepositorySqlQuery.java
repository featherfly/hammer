
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.util.List;
import java.util.Map;

import cn.featherfly.common.repository.mapping.RowMapper;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.expression.query.QueryLimitExecutor;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * AbstractRepositorySqlQuery.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <Q> the generic type
 */
public abstract class AbstractRepositorySqlQuery<C extends ConditionExpression, Q>
        extends AbstractRepositorySqlQueryBase<C, Q> implements QueryLimitExecutor {

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractRepositorySqlQuery(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        this(1, queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param index          the index
     * @param queryRelation  the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractRepositorySqlQuery(int index, RepositorySqlQueryRelation queryRelation,
            SqlPageFactory sqlPageFactory) {
        super(index, queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param repositorySqlQueryFetch the repository sql query fetch
     */
    protected AbstractRepositorySqlQuery(AbstractRepositorySqlQueryBase<?, ?> repositorySqlQueryFetch) {
        super(repositorySqlQueryFetch);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Object>> list() {
        return new RepositorySqlQueryExpression(queryRelation, sqlPageFactory).limit(limit).list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(RowMapper<E> rowMapper) {
        return new RepositorySqlQueryExpression(queryRelation, sqlPageFactory).limit(limit).list(rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> List<E> list(Class<E> type) {
        return new RepositorySqlQueryExpression(queryRelation, sqlPageFactory).limit(limit).list(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> single() {
        return new RepositorySqlQueryExpression(queryRelation, sqlPageFactory).limit(limit).single();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(Class<E> type) {
        return new RepositorySqlQueryExpression(queryRelation, sqlPageFactory).limit(limit).single(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E single(RowMapper<E> rowMapper) {
        return new RepositorySqlQueryExpression(queryRelation, sqlPageFactory).limit(limit).single(rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Object> unique() {
        return new RepositorySqlQueryExpression(queryRelation, sqlPageFactory).limit(limit).unique();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E unique(Class<E> type) {
        return new RepositorySqlQueryExpression(queryRelation, sqlPageFactory).limit(limit).unique(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> E unique(RowMapper<E> rowMapper) {
        return new RepositorySqlQueryExpression(queryRelation, sqlPageFactory).limit(limit).unique(rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Object>> pagination() {
        return new RepositorySqlQueryExpression(queryRelation, sqlPageFactory).limit(limit).pagination();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(Class<E> type) {
        return new RepositorySqlQueryExpression(queryRelation, sqlPageFactory).limit(limit).pagination(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <E> PaginationResults<E> pagination(RowMapper<E> rowMapper) {
        return new RepositorySqlQueryExpression(queryRelation, sqlPageFactory).limit(limit).pagination(rowMapper);
    }
}
