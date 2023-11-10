
package cn.featherfly.hammer.expression.query;

import java.util.List;

import com.speedment.common.tuple.Tuple4;

/**
 * query type list executor4.
 *
 * @author zhongj
 */
public interface QueryTypeListExecutor4 extends QueryTypeListExecutor {

    /**
     * query for list.
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
     * @return list
     */
    <E1, E2, E3, E4> List<Tuple4<E1, E2, E3, E4>> list(Tuple4<String, String, String, String> prefixes, Class<E1> type1,
            Class<E2> type2, Class<E3> type3, Class<E4> type4);

    /**
     * query for list.
     *
     * @param <E1>  the generic type
     * @param <E2>  the generic type
     * @param <E3>  the generic type
     * @param <E4>  the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @param type4 the type 4
     * @return list
     */
    default <E1, E2, E3, E4> List<Tuple4<E1, E2, E3, E4>> list(Class<E1> type1, Class<E2> type2, Class<E3> type3,
            Class<E4> type4) {
        return list(null, type1, type2, type3, type4);
    }
}
