
package cn.featherfly.hammer.expression.query;

import cn.featherfly.common.tuple.Tuple3;

/**
 * dsl for query single executor3 .
 *
 * @author zhongj
 */
public interface QuerySingleExecutor3 extends QuerySingleExecutor {

    /**
     * query for single, return null when not found.
     *
     * @param <E1>     the generic type
     * @param <E2>     the generic type
     * @param <E3>     the generic type
     * @param prefixes the prefixes
     * @param type1    the type 1
     * @param type2    the type 2
     * @param type3    the type 3
     * @return object
     */
    <E1, E2, E3> Tuple3<E1, E2, E3> single(Tuple3<String, String, String> prefixes, Class<E1> type1, Class<E2> type2,
            Class<E3> type3);

    /**
     * query for single, return null when not found.
     *
     * @param <E1>  the generic type
     * @param <E2>  the generic type
     * @param <E3>  the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @return object
     */
    default <E1, E2, E3> Tuple3<E1, E2, E3> single(Class<E1> type1, Class<E2> type2, Class<E3> type3) {
        return single(null, type1, type2, type3);
    }

    /**
     * query for single, return null when not found.
     *
     * @param <E1>     the generic type
     * @param <E2>     the generic type
     * @param <E3>     the generic type
     * @param prefixes the prefixes
     * @param types    the types
     * @return object
     */
    default <E1, E2, E3> Tuple3<E1, E2, E3> single(Tuple3<String, String, String> prefixes,
            Tuple3<Class<E1>, Class<E2>, Class<E3>> types) {
        return single(prefixes, types.get0(), types.get1(), types.get2());
    }

    /**
     * query for single, return null when not found.
     *
     * @param <E1>  the generic type
     * @param <E2>  the generic type
     * @param <E3>  the generic type
     * @param types the types
     * @return object
     */
    default <E1, E2, E3> Tuple3<E1, E2, E3> single(Tuple3<Class<E1>, Class<E2>, Class<E3>> types) {
        return single(null, types);
    }

    // ----------------------------------------------------------------------------------------------------------------

    /**
     * query for unique, throw exception when not found.
     *
     * @param <E1>     the generic type
     * @param <E2>     the generic type
     * @param <E3>     the generic type
     * @param prefixes the prefixes
     * @param type1    the type 1
     * @param type2    the type 2
     * @param type3    the type 3
     * @return the e
     */
    <E1, E2, E3> Tuple3<E1, E2, E3> unique(Tuple3<String, String, String> prefixes, Class<E1> type1, Class<E2> type2,
            Class<E3> type3);

    /**
     * query for unique, throw exception when not found.
     *
     * @param <E1>  the generic type
     * @param <E2>  the generic type
     * @param <E3>  the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @return the e
     */
    default <E1, E2, E3> Tuple3<E1, E2, E3> unique(Class<E1> type1, Class<E2> type2, Class<E3> type3) {
        return unique(null, type1, type2, type3);
    }

    /**
     * query for unique, throw exception when not found.
     *
     * @param <E1>     the generic type
     * @param <E2>     the generic type
     * @param <E3>     the generic type
     * @param prefixes the prefixes
     * @param types    the types
     * @return the tuple 3
     */
    default <E1, E2, E3> Tuple3<E1, E2, E3> unique(Tuple3<String, String, String> prefixes,
            Tuple3<Class<E1>, Class<E2>, Class<E3>> types) {
        return unique(prefixes, types.get0(), types.get1(), types.get2());
    }

    /**
     * query for unique, throw exception when not found.
     *
     * @param <E1>  the generic type
     * @param <E2>  the generic type
     * @param <E3>  the generic type
     * @param types the types
     * @return object
     */
    default <E1, E2, E3> Tuple3<E1, E2, E3> unique(Tuple3<Class<E1>, Class<E2>, Class<E3>> types) {
        return unique(null, types);
    }
}
