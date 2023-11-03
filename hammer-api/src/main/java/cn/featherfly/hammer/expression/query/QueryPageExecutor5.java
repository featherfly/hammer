
package cn.featherfly.hammer.expression.query;

import com.speedment.common.tuple.Tuple5;

import cn.featherfly.common.structure.page.PaginationResults;

/**
 * dsl for query page executor5 .
 *
 * @author zhongj
 */
public interface QueryPageExecutor5 extends QueryPageExecutor {

    /**
     * query for page.
     *
     * @param <E1>     the generic type
     * @param <E2>     the generic type
     * @param <E3>     the generic type
     * @param <E4>     the generic type
     * @param prefixes the prefixes
     * @param type1    the type 1
     * @param type2    the type 2
     * @param type3    the type 3
     * @param type4    the type 4
     * @return PaginationResults
     */
    <E1, E2, E3, E4, E5> PaginationResults<Tuple5<E1, E2, E3, E4, E5>> pagination(
            Tuple5<String, String, String, String, String> prefixes, Class<E1> type1, Class<E2> type2, Class<E3> type3,
            Class<E4> type4, Class<E5> type5);

    /**
     * query for page.
     *
     * @param <E1>  the generic type
     * @param <E2>  the generic type
     * @param <E3>  the generic type
     * @param <E4>  the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @param type4 the type 4
     * @return PaginationResults
     */
    default <E1, E2, E3, E4, E5> PaginationResults<Tuple5<E1, E2, E3, E4, E5>> pagination(Class<E1> type1,
            Class<E2> type2, Class<E3> type3, Class<E4> type4, Class<E5> type5) {
        return pagination(null, type1, type2, type3, type4, type5);
    }
}
