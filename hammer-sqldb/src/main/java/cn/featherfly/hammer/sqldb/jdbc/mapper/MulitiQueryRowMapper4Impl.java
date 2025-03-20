
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-04-20 01:38:20
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.mapper;

import java.io.Serializable;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.apache.commons.lang3.ArrayUtils;

import cn.featherfly.common.repository.mapper.MulitiQueryRowMapper4;
import cn.featherfly.common.repository.mapper.MulitiQueryRowMapper5;
import cn.featherfly.common.repository.mapper.PrefixedBeanMapper;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.repository.mapper.TupleRowMapperBuilder;

/**
 * MulitiQueryRowMapper4.
 *
 * @author zhongj
 * @param <T1> the generic type
 * @param <T2> the generic type
 * @param <T3> the generic type
 * @param <T4> the generic type
 */
public class MulitiQueryRowMapper4Impl<T1, T2, T3, T4> extends AbstractMulitiQueryRowMapper
    implements MulitiQueryRowMapper4<T1, T2, T3, T4> {

    /**
     * Instantiates a new muliti query row mapper 4 impl.
     *
     * @param rowMappers the row mappers
     * @param getRowMapper the get row mapper
     */
    public MulitiQueryRowMapper4Impl(RowMapper<?>[] rowMappers,
        BiFunction<Class<?>, String, RowMapper<?>> getRowMapper) {
        super(rowMappers, getRowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MulitiQueryRowMapper5<T1, T2, T3, T4, Map<String, Serializable>> mapper() {
        return mapper(getRowMapper(PrefixedBeanMapper.MAP_TYPE));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T5> MulitiQueryRowMapper5<T1, T2, T3, T4, T5> mapper(Class<T5> mappingType) {
        return mapper(getRowMapper(mappingType));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T5> MulitiQueryRowMapper5<T1, T2, T3, T4, T5> mapper(RowMapper<T5> rowMapper) {
        return new MulitiQueryRowMapper5Impl<>(ArrayUtils.add(getRowMappers(), rowMapper),
            getRowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <
        T5> MulitiQueryRowMapper5<T1, T2, T3, T4, T5> mapper(Function<TupleRowMapperBuilder, RowMapper<T5>> rowMapper) {
        return mapper(rowMapper.apply(new TupleRowMapperBuilderImpl(getRowMapper)));
    }

}
