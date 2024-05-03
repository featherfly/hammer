
package cn.featherfly.hammer.sqldb.dsl.type;

import java.util.List;

import cn.featherfly.hammer.expression.query.QueryExecutor;

/**
 * <p>
 * TypeQueryExecutor
 * </p>
 *
 * @author zhongj
 */
public class StaticTypeQueryExecutor<E> implements cn.featherfly.hammer.expression.type.GenericTypeQueryExecutor<E> {

    private Class<E> type;

    private QueryExecutor queryExecutor;

    /**
     * Instantiates a new type query executor.
     *
     * @param type          the type
     * @param queryExecutor the query executor
     */
    public StaticTypeQueryExecutor(Class<E> type, QueryExecutor queryExecutor) {
        super();
        this.type = type;
        this.queryExecutor = queryExecutor;
    }

    /**
     * query for list
     *
     * @return list
     */
    @Override
    public List<E> list() {
        return queryExecutor.list(type);
    }

    /**
     * query for single
     *
     * @return object
     */
    @Override
    public E single() {
        return queryExecutor.single(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E unique() {
        return queryExecutor.unique(type);
    }
}
