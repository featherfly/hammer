
package cn.featherfly.juorm.rdb.jdbc.dsl.type;

import java.util.List;

import cn.featherfly.juorm.expression.query.QueryExecutor;

/**
 * <p>
 * TypeQueryExecutor
 * </p>
 *
 * @author zhongj
 */
public class TypeQueryExecutor<E> implements cn.featherfly.juorm.expression.query.TypeQueryExecutor<E> {

    private Class<E> type;

    private QueryExecutor queryExecutor;

    /**
     * @param type
     * @param queryExecutor
     */
    public TypeQueryExecutor(Class<E> type, QueryExecutor queryExecutor) {
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
}
