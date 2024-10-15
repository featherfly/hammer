
package cn.featherfly.hammer.expression.query;

import cn.featherfly.common.tuple.Tuple2;

import cn.featherfly.common.structure.page.PaginationResults;

/**
 * dsl for query page executor2 .
 *
 * @author zhongj
 */
public interface QueryPageExecutor2 extends QueryPageExecutor {

    /**
     * query for page.
     *
     * @param <E1>     the generic type
     * @param <E2>     the generic type
     * @param prefixes the prefixes
     * @param type1    the type 1
     * @param type2    the type 2
     * @return PaginationResults
     */
    <E1, E2> PaginationResults<Tuple2<E1, E2>> pagination(Tuple2<String, String> prefixes, Class<E1> type1,
            Class<E2> type2);

    /**
     * query for page.
     *
     * @param <E1>  the generic type
     * @param <E2>  the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @return PaginationResults
     */
    default <E1, E2> PaginationResults<Tuple2<E1, E2>> pagination(Class<E1> type1, Class<E2> type2) {
        return pagination(null, type1, type2);
    }
}
