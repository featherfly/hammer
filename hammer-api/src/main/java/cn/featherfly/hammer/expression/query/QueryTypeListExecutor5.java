/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-11-27 15:56:27
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.expression.query;

import java.util.List;

import cn.featherfly.common.tuple.Tuple5;

/**
 * query type list executor5.
 *
 * @author zhongj
 */
public interface QueryTypeListExecutor5 extends QueryTypeListExecutor {

    /**
     * query for list.
     *
     * @param <E1>     the generic type
     * @param <E2>     the generic type
     * @param <E3>     the generic type
     * @param <E4>     the generic type
     * @param <E5>     the generic type
     * @param prefixes the prefixes
     * @param type1    the type 1
     * @param type2    the type 2
     * @param type3    the type 3
     * @param type4    the type 4
     * @param type5    the type 5
     * @return list
     */
    <E1, E2, E3, E4, E5> List<Tuple5<E1, E2, E3, E4, E5>> list(Tuple5<String, String, String, String, String> prefixes,
            Class<E1> type1, Class<E2> type2, Class<E3> type3, Class<E4> type4, Class<E5> type5);

    /**
     * query for list.
     *
     * @param <E1>  the generic type
     * @param <E2>  the generic type
     * @param <E3>  the generic type
     * @param <E4>  the generic type
     * @param <E5>  the generic type
     * @param type1 the type 1
     * @param type2 the type 2
     * @param type3 the type 3
     * @param type4 the type 4
     * @param type5 the type 5
     * @return list
     */
    default <E1, E2, E3, E4, E5> List<Tuple5<E1, E2, E3, E4, E5>> list(Class<E1> type1, Class<E2> type2,
            Class<E3> type3, Class<E4> type4, Class<E5> type5) {
        return list(null, type1, type2, type3, type4, type5);
    }
}
