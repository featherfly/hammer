
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-03-20 01:38:20
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.mapper;

import java.io.Serializable;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.apache.commons.lang3.ArrayUtils;

import cn.featherfly.common.repository.mapper.MulitiQueryRowMapper3;
import cn.featherfly.common.repository.mapper.MulitiQueryRowMapper4;
import cn.featherfly.common.repository.mapper.PrefixedBeanMapper;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.repository.mapper.TupleRowMapperBuilder;

/**
 * MulitiQueryRowMapper3.
 *
 * @author zhongj
 * @param <T1> the generic type
 * @param <T2> the generic type
 * @param <T3> the generic type
 */
public class MulitiQueryRowMapper3Impl<T1, T2, T3> extends AbstractMulitiQueryRowMapper
    implements MulitiQueryRowMapper3<T1, T2, T3> {

    /**
     * Instantiates a new muliti query row mapper 3 impl.
     *
     * @param rowMappers the row mappers
     * @param getRowMapper the get row mapper
     */
    public MulitiQueryRowMapper3Impl(RowMapper<?>[] rowMappers,
        BiFunction<Class<?>, String, RowMapper<?>> getRowMapper) {
        super(rowMappers, getRowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MulitiQueryRowMapper4<T1, T2, T3, Map<String, Serializable>> mapper() {
        return mapper(getRowMapper(PrefixedBeanMapper.MAP_TYPE));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T4> MulitiQueryRowMapper4<T1, T2, T3, T4> mapper(Class<T4> mappingType) {
        return mapper(getRowMapper(mappingType));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T4> MulitiQueryRowMapper4<T1, T2, T3, T4> mapper(RowMapper<T4> rowMapper) {
        return new MulitiQueryRowMapper4Impl<>(ArrayUtils.add(getRowMappers(), rowMapper),
            getRowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T4> MulitiQueryRowMapper4<T1, T2, T3, T4> mapper(Function<TupleRowMapperBuilder, RowMapper<T4>> rowMapper) {
        return mapper(rowMapper.apply(new TupleRowMapperBuilderImpl(getRowMapper)));
    }

}
