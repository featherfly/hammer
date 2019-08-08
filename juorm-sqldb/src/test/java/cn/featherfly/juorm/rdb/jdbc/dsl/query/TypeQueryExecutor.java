
package cn.featherfly.juorm.rdb.jdbc.dsl.query;

import java.util.List;

import cn.featherfly.juorm.expression.query.QueryExecutor;

/**
 * <p>
 * TypeQueryExecutor
 * </p>
 * 
 * @author zhongj
 */
public class TypeQueryExecutor<E> {

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
     * @param rowMapper
     *            rowMapper
     * @return list
     */
    public List<E> list() {
        return queryExecutor.list(type);
    }

    /**
     * query for single
     *
     * @return object
     */
    public E single() {
        return queryExecutor.single(type);
    }
}
