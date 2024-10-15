
package cn.featherfly.hammer.expression.query;

import java.util.List;

import cn.featherfly.common.tuple.Tuple2;

/**
 * query type list executor2.
 *
 * @author zhongj
 */
public interface QueryTypeListExecutor2 extends QueryTypeListExecutor {

    /**
     * query for list.
     *
     * @param <E1>     the generic type
     * @param <E2>     the generic type
     * @param prefixes the prefixes
     * @param type1    the type 1
     * @param type2    the type 2
     * @return list
     */
    <E1, E2> List<Tuple2<E1, E2>> list(Tuple2<String, String> prefixes, Class<E1> type1, Class<E2> type2);

    /**
     * query for list.
     *
     * @param <E1>  the generic type
     * @param <E2>  the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @return list
     */
    default <E1, E2> List<Tuple2<E1, E2>> list(Class<E1> type1, Class<E2> type2) {
        return list(null, type1, type2);
    }
}
