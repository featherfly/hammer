
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2022-02-20 01:28:20
 * @Copyright: 2022 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.mapper;

import java.io.Serializable;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.apache.commons.lang3.ArrayUtils;

import cn.featherfly.common.repository.mapper.MulitiQueryRowMapper2;
import cn.featherfly.common.repository.mapper.MulitiQueryRowMapper3;
import cn.featherfly.common.repository.mapper.PrefixedBeanMapper;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.repository.mapper.TupleRowMapperBuilder;

/**
 * MulitiQueryRowMapper2.
 *
 * @author zhongj
 * @param <T1> the generic type
 * @param <T2> the generic type
 */
public class MulitiQueryRowMapper2Impl<T1, T2> extends AbstractMulitiQueryRowMapper
    implements MulitiQueryRowMapper2<T1, T2> {

    /**
     * Instantiates a new muliti query row mapper 2 impl.
     *
     * @param rowMappers the row mappers
     * @param getRowMapper the get row mapper
     */
    public MulitiQueryRowMapper2Impl(RowMapper<?>[] rowMappers,
        BiFunction<Class<?>, String, RowMapper<?>> getRowMapper) {
        super(rowMappers, getRowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MulitiQueryRowMapper3<T1, T2, Map<String, Serializable>> mapper() {
        return mapper(getRowMapper(PrefixedBeanMapper.MAP_TYPE));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T3> MulitiQueryRowMapper3<T1, T2, T3> mapper(Class<T3> mappingType) {
        return mapper(getRowMapper(mappingType));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T3> MulitiQueryRowMapper3<T1, T2, T3> mapper(RowMapper<T3> rowMapper) {
        return new MulitiQueryRowMapper3Impl<>(ArrayUtils.add(getRowMappers(), rowMapper),
            getRowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T3> MulitiQueryRowMapper3<T1, T2, T3> mapper(Function<TupleRowMapperBuilder, RowMapper<T3>> rowMapper) {
        return mapper(rowMapper.apply(new TupleRowMapperBuilderImpl(getRowMapper)));
    }

}