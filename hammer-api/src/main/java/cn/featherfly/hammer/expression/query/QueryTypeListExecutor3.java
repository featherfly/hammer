
package cn.featherfly.hammer.expression.query;

import java.util.List;

import com.speedment.common.tuple.Tuple3;

/**
 * query type list executor3.
 *
 * @author zhongj
 */
public interface QueryTypeListExecutor3 extends QueryTypeListExecutor {

    /**
     * query for list.
     *
     * @param <E1>     the generic type
     * @param <E2>     the generic type
     * @param <E3>     the generic type
     * @param prefixes the prefixes
     * @param type1    the type 1
     * @param type2    the type 2
     * @param type3    the type 3
     * @return list
     */
    <E1, E2, E3> List<Tuple3<E1, E2, E3>> list(Tuple3<String, String, String> prefixes, Class<E1> type1,
            Class<E2> type2, Class<E3> type3);

    /**
     * query for list.
     *
     * @param <E1>  the generic type
     * @param <E2>  the generic type
     * @param <E3>  the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @return list
     */
    default <E1, E2, E3> List<Tuple3<E1, E2, E3>> list(Class<E1> type1, Class<E2> type2, Class<E3> type3) {
        return list(null, type1, type2, type3);
    }
}
