package cn.featherfly.common.repository.mapping;

import com.speedment.common.tuple.Tuple5;

import cn.featherfly.common.repository.ParamedMappedExecutor;

/**
 * prefixed bean mapper5.
 *
 * @param <T1> the generic type
 * @param <T2> the generic type
 * @param <T3> the generic type
 * @param <T4> the generic type
 * @param <T5> the generic type
 */
public interface PrefixedBeanMapper5<T1, T2, T3, T4, T5> extends ParamedMappedExecutor<Tuple5<T1, T2, T3, T4, T5>> {

    /**
     * Map.
     *
     * @param <T6>   the generic type
     * @param prefix the prefix
     * @param type   the type
     * @return the prefix bean property mapper 6
     */
    <T6> PrefixedBeanMapper6<T1, T2, T3, T4, T5, T6> map(String prefix, Class<T6> type);
}