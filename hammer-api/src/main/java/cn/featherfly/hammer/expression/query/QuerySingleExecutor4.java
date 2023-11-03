
package cn.featherfly.hammer.expression.query;

import com.speedment.common.tuple.Tuple4;

/**
 * dsl for query single executor4 .
 *
 * @author zhongj
 */
public interface QuerySingleExecutor4 extends QuerySingleExecutor {

    /**
     * query for single, return null when not found.
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
     * @return object
     */
    <E1, E2, E3, E4> Tuple4<E1, E2, E3, E4> single(Tuple4<String, String, String, String> prefixes, Class<E1> type1,
            Class<E2> type2, Class<E3> type3, Class<E4> type4);

    /**
     * query for single, return null when not found.
     *
     * @param <E1>  the generic type
     * @param <E2>  the generic type
     * @param <E3>  the generic type
     * @param <E4>  the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @param type4 the type 4
     * @return object
     */
    default <E1, E2, E3, E4> Tuple4<E1, E2, E3, E4> single(Class<E1> type1, Class<E2> type2, Class<E3> type3,
            Class<E4> type4) {
        return single(null, type1, type2, type3, type4);
    }

    /**
     * query for single, return null when not found.
     *
     * @param <E1>     the generic type
     * @param <E2>     the generic type
     * @param <E3>     the generic type
     * @param <E4>     the generic type
     * @param prefixes the prefixes
     * @param types    the types
     * @return object
     */
    default <E1, E2, E3, E4> Tuple4<E1, E2, E3, E4> single(Tuple4<String, String, String, String> prefixes,
            Tuple4<Class<E1>, Class<E2>, Class<E3>, Class<E4>> types) {
        return single(prefixes, types.get0(), types.get1(), types.get2(), types.get3());
    }

    /**
     * query for single, return null when not found.
     *
     * @param <E1>  the generic type
     * @param <E2>  the generic type
     * @param <E3>  the generic type
     * @param <E4>  the generic type
     * @param types the types
     * @return object
     */
    default <E1, E2, E3, E4> Tuple4<E1, E2, E3, E4> single(Tuple4<Class<E1>, Class<E2>, Class<E3>, Class<E4>> types) {
        return single(null, types);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * query for unique, throw exception when not found.
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
     * @return the e
     */
    <E1, E2, E3, E4> Tuple4<E1, E2, E3, E4> unique(Tuple4<String, String, String, String> prefixes, Class<E1> type1,
            Class<E2> type2, Class<E3> type3, Class<E4> type4);

    /**
     * query for unique, throw exception when not found.
     *
     * @param <E1>  the generic type
     * @param <E2>  the generic type
     * @param <E3>  the generic type
     * @param <E4>  the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @param type4 the type 4
     * @return the e
     */
    default <E1, E2, E3, E4> Tuple4<E1, E2, E3, E4> unique(Class<E1> type1, Class<E2> type2, Class<E3> type3,
            Class<E4> type4) {
        return unique(null, type1, type2, type3, type4);
    }

    /**
     * query for unique, throw exception when not found.
     *
     * @param <E1>     the generic type
     * @param <E2>     the generic type
     * @param <E3>     the generic type
     * @param <E4>     the generic type
     * @param prefixes the prefixes
     * @param types    the types
     * @return the tuple 3
     */
    default <E1, E2, E3, E4> Tuple4<E1, E2, E3, E4> unique(Tuple4<String, String, String, String> prefixes,
            Tuple4<Class<E1>, Class<E2>, Class<E3>, Class<E4>> types) {
        return unique(prefixes, types.get0(), types.get1(), types.get2(), types.get3());
    }

    /**
     * query for unique, throw exception when not found.
     *
     * @param <E1>  the generic type
     * @param <E2>  the generic type
     * @param <E3>  the generic type
     * @param <E4>  the generic type
     * @param types the types
     * @return object
     */
    default <E1, E2, E3, E4> Tuple4<E1, E2, E3, E4> unique(Tuple4<Class<E1>, Class<E2>, Class<E3>, Class<E4>> types) {
        return unique(null, types);
    }
}
