
package cn.featherfly.hammer.sqldb.dsl.repository.query;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import cn.featherfly.common.repository.RowIterable;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.repository.mapper.TupleRowMapperBuilder;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.data.query.QueryExecutor;
import cn.featherfly.data.query.QueryLimitExecutor;
import cn.featherfly.data.query.QueryMapperSetter1;
import cn.featherfly.hammer.expression.condition.ConditionExpression;
import cn.featherfly.hammer.sqldb.dsl.repository.RepositorySqlQueryRelation;
import cn.featherfly.hammer.sqldb.jdbc.SqlPageFactory;

/**
 * AbstractRepositorySqlQuery.
 *
 * @author zhongj
 * @param <C> the generic type
 * @param <Q> the generic type
 */
public abstract class AbstractRepositorySqlQuery<C extends ConditionExpression, Q> extends
    AbstractRepositorySqlQueryBase<C, Q> implements QueryLimitExecutor<Map<String, Serializable>>, QueryMapperSetter1 {

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param queryRelation the query relation
     * @param sqlPageFactory the sql page factory
     */
    protected AbstractRepositorySqlQuery(RepositorySqlQueryRelation queryRelation, SqlPageFactory sqlPageFactory) {
        this(1, queryRelation, sqlPageFactory);
    }

    /**
     * Instantiates a new abstract sql query entity properties.
     *
     * @param index the index
     * @param queryRelation the query relation
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
    public <T> QueryExecutor<T> mapper(RowMapper<T> rowMapper) {
        return new RepositorySqlQueryExpression(queryRelation, sqlPageFactory).mapper(rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> QueryExecutor<T> mapper(Class<T> type) {
        return new RepositorySqlQueryExpression(queryRelation, sqlPageFactory).mapper(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> QueryExecutor<T> mapper(Function<TupleRowMapperBuilder, RowMapper<T>> mapperBuilderFunction) {
        return new RepositorySqlQueryExpression(queryRelation, sqlPageFactory).mapper(mapperBuilderFunction);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Map<String, Serializable>> list() {
        return new RepositorySqlQueryExpression(queryRelation, sqlPageFactory).limit(limit).list();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RowIterable<Map<String, Serializable>> each() {
        return new RepositorySqlQueryExpression(queryRelation, sqlPageFactory).limit(limit).each();
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <E> List<E> list(RowMapper<E> rowMapper) {
    //        return new RepositorySqlQueryExpression(queryRelation, sqlPageFactory).limit(limit).list(rowMapper);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <E> List<E> list(Class<E> type) {
    //        return new RepositorySqlQueryExpression(queryRelation, sqlPageFactory).limit(limit).list(type);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Serializable> single() {
        return new RepositorySqlQueryExpression(queryRelation, sqlPageFactory).limit(limit).single();
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <E> E single(Class<E> type) {
    //        return new RepositorySqlQueryExpression(queryRelation, sqlPageFactory).limit(limit).single(type);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <E> E single(RowMapper<E> rowMapper) {
    //        return new RepositorySqlQueryExpression(queryRelation, sqlPageFactory).limit(limit).single(rowMapper);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Serializable> unique() {
        return new RepositorySqlQueryExpression(queryRelation, sqlPageFactory).limit(limit).unique();
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <E> E unique(Class<E> type) {
    //        return new RepositorySqlQueryExpression(queryRelation, sqlPageFactory).limit(limit).unique(type);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <E> E unique(RowMapper<E> rowMapper) {
    //        return new RepositorySqlQueryExpression(queryRelation, sqlPageFactory).limit(limit).unique(rowMapper);
    //    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<Map<String, Serializable>> pagination() {
        return new RepositorySqlQueryExpression(queryRelation, sqlPageFactory).limit(limit).pagination();
    }

    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <E> PaginationResults<E> pagination(Class<E> type) {
    //        return new RepositorySqlQueryExpression(queryRelation, sqlPageFactory).limit(limit).pagination(type);
    //    }
    //
    //    /**
    //     * {@inheritDoc}
    //     */
    //    @Override
    //    public <E> PaginationResults<E> pagination(RowMapper<E> rowMapper) {
    //        return new RepositorySqlQueryExpression(queryRelation, sqlPageFactory).limit(limit).pagination(rowMapper);
    //    }
}
