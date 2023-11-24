
package cn.featherfly.hammer.expression.query;

import com.speedment.common.tuple.Tuple2;

/**
 * dsl for query single executor2 .
 *
 * @author zhongj
 */
public interface QuerySingleExecutor2 extends QuerySingleExecutor {

    /**
     * query for single, return null when not found.
     *
     * @param <E1>  the generic type
     * @param <E2>  the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @return object
     */
    <E1, E2> Tuple2<E1, E2> single(Tuple2<String, String> prefixes, Class<E1> type1, Class<E2> type2);

    /**
     * query for single, return null when not found.
     *
     * @param <E1>  the generic type
     * @param <E2>  the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @return object
     */
    default <E1, E2> Tuple2<E1, E2> single(Class<E1> type1, Class<E2> type2) {
        return single(null, type1, type2);
    }

    /**
     * query for unique, throw exception when not found.
     *
     * @param <E1>  the generic type
     * @param <E2>  the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @return the e
     */
    <E1, E2> Tuple2<E1, E2> unique(Tuple2<String, String> prefixes, Class<E1> type1, Class<E2> type2);

    /**
     * query for unique, throw exception when not found.
     *
     * @param <E1>  the generic type
     * @param <E2>  the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @return the e
     */
    default <E1, E2> Tuple2<E1, E2> unique(Class<E1> type1, Class<E2> type2) {
        return unique(null, type1, type2);
    }
}
