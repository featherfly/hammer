
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-20 01:38:20
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.mapper;

import java.io.Serializable;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.apache.commons.lang3.ArrayUtils;

import cn.featherfly.common.repository.mapper.MulitiQueryRowMapper5;
import cn.featherfly.common.repository.mapper.MulitiQueryRowMapper6;
import cn.featherfly.common.repository.mapper.PrefixedBeanMapper;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.repository.mapper.TupleRowMapperBuilder;

/**
 * MulitiQueryRowMapper5.
 *
 * @author zhongj
 * @param <T1> the generic type
 * @param <T2> the generic type
 * @param <T3> the generic type
 * @param <T4> the generic type
 * @param <T5> the generic type
 */
public class MulitiQueryRowMapper5Impl<T1, T2, T3, T4, T5> extends AbstractMulitiQueryRowMapper
    implements MulitiQueryRowMapper5<T1, T2, T3, T4, T5> {

    /**
     * Instantiates a new muliti query row mapper 5 impl.
     *
     * @param rowMappers the row mappers
     * @param getRowMapper the get row mapper
     */
    public MulitiQueryRowMapper5Impl(RowMapper<?>[] rowMappers,
        BiFunction<Class<?>, String, RowMapper<?>> getRowMapper) {
        super(rowMappers, getRowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MulitiQueryRowMapper6<T1, T2, T3, T4, T5, Map<String, Serializable>> mapper() {
        return mapper(getRowMapper(PrefixedBeanMapper.MAP_TYPE));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T6> MulitiQueryRowMapper6<T1, T2, T3, T4, T5, T6> mapper(Class<T6> mappingType) {
        return mapper(getRowMapper(mappingType));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T6> MulitiQueryRowMapper6<T1, T2, T3, T4, T5, T6> mapper(RowMapper<T6> rowMapper) {
        return new MulitiQueryRowMapper6Impl<>(ArrayUtils.add(getRowMappers(), rowMapper),
            getRowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T6> MulitiQueryRowMapper6<T1, T2, T3, T4, T5, T6> mapper(
        Function<TupleRowMapperBuilder, RowMapper<T6>> rowMapper) {
        return mapper(rowMapper.apply(new TupleRowMapperBuilderImpl(getRowMapper)));
    }

}
