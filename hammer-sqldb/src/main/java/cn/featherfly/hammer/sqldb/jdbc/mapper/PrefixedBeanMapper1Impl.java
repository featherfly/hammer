
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2025-03-19 01:19:19
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.mapper;

import java.util.function.BiFunction;

import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.mapper.PrefixedBeanMapper1;
import cn.featherfly.common.repository.mapper.PrefixedBeanMapper2;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.tuple.Tuples;

/**
 * PrefixedBeanMapper1Impl.
 *
 * @author zhongj
 */
public class PrefixedBeanMapper1Impl<T1> implements PrefixedBeanMapper1<T1> {

    private final Class<T1> type;

    private final BiFunction<Class<?>, String, RowMapper<?>> getRowMapper;

    private final String prefix;

    /**
     * Instantiates a new prefixed bean mapper 1 impl.
     *
     * @param manager the manager
     * @param prefix the prefix
     * @param type the type
     * @param getRowMapper the get row mapper
     */
    public PrefixedBeanMapper1Impl(String prefix, Class<T1> type,
        BiFunction<Class<?>, String, RowMapper<?>> getRowMapper) {
        super();
        this.prefix = prefix;
        this.type = type;
        this.getRowMapper = getRowMapper;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public RowMapper<T1> mapper() {
        return (RowMapper<T1>) getRowMapper.apply(type, prefix);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T2> PrefixedBeanMapper2<T1, T2> map(String prefix, Class<T2> type) {
        return new PrefixedBeanMapper2Impl<>(Lang.list(this.type, type), Tuples.of(this.prefix, prefix), getRowMapper);
    }

}
