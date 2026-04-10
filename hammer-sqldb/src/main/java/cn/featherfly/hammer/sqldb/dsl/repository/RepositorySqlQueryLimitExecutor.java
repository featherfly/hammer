package cn.featherfly.hammer.sqldb.dsl.repository;

import java.util.List;

import cn.featherfly.common.repository.RowIterable;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.data.query.QueryLimitExecutor;

/**
 * The Class RepositorySqlQueryLimitExecutor.
 *
 * @param <T> the generic type
 */
public class RepositorySqlQueryLimitExecutor<T> implements QueryLimitExecutor<T> {

    private final RowMapper<T> rowMapper;

    private final RepositorySqlQueryConditionGroupQuery repositorySqlQueryConditionGroupQuery;

    /**
     * Instantiates a new repository sql query limit executor.
     *
     * @param repositorySqlQueryConditionGroupQuery the repository sql query condition group query
     * @param rowMapper the row mapper
     */
    public RepositorySqlQueryLimitExecutor(RepositorySqlQueryConditionGroupQuery repositorySqlQueryConditionGroupQuery,
        RowMapper<T> rowMapper) {
        this.repositorySqlQueryConditionGroupQuery = repositorySqlQueryConditionGroupQuery;
        this.rowMapper = rowMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> list() {
        return repositorySqlQueryConditionGroupQuery.list(rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RowIterable<T> each() {
        return repositorySqlQueryConditionGroupQuery.each(rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T single() {
        return repositorySqlQueryConditionGroupQuery.single(rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T unique() {
        return repositorySqlQueryConditionGroupQuery.unique(rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<T> pagination() {
        return repositorySqlQueryConditionGroupQuery.pagination(rowMapper);
    }
}