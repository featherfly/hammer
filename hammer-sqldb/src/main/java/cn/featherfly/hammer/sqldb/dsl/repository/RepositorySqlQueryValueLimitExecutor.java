package cn.featherfly.hammer.sqldb.dsl.repository;

import java.util.List;

import cn.featherfly.common.repository.RowIterable;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.data.query.QueryLimitExecutor;
import cn.featherfly.hammer.sqldb.dsl.repository.query.AbstractMulitiRepositorySqlQueryValueConditionsGroupExpression;

/**
 * The Class RepositorySqlQueryValueLimitExecutor.
 *
 * @param <T> the generic rowMapper
 */
public class RepositorySqlQueryValueLimitExecutor<T> implements QueryLimitExecutor<T> {

    private final RowMapper<T> rowMapper;

    private final AbstractMulitiRepositorySqlQueryValueConditionsGroupExpression exp;

    /**
     * Instantiates a new repository sql query value limit executor.
     *
     * @param exp the exp
     * @param rowMapper the rowMapper
     */
    public RepositorySqlQueryValueLimitExecutor(AbstractMulitiRepositorySqlQueryValueConditionsGroupExpression exp,
        RowMapper<T> rowMapper) {
        this.exp = exp;
        this.rowMapper = rowMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> list() {
        return exp.list(rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RowIterable<T> each() {
        return exp.each(rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T single() {
        return exp.single(rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T unique() {
        return exp.unique(rowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaginationResults<T> pagination() {
        return exp.pagination(rowMapper);
    }
}