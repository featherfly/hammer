
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

import cn.featherfly.common.repository.mapper.MulitiQueryRowMapper1;
import cn.featherfly.common.repository.mapper.MulitiQueryRowMapper2;
import cn.featherfly.common.repository.mapper.PrefixedBeanMapper;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.repository.mapper.TupleRowMapperBuilder;

/**
 * MulitiQueryRowMapper1.
 *
 * @author zhongj
 * @param <T1> the generic type
 */
public class MulitiQueryRowMapper1Impl<T1> extends AbstractMulitiQueryRowMapper implements MulitiQueryRowMapper1<T1> {

    /**
     * Instantiates a new muliti query row mapper 1 impl.
     *
     * @param rowMapper the row mapper
     * @param getRowMapper the get row mapper
     */
    public MulitiQueryRowMapper1Impl(RowMapper<T1> rowMapper,
        BiFunction<Class<?>, String, RowMapper<?>> getRowMapper) {
        super(new RowMapper[] { rowMapper }, getRowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MulitiQueryRowMapper2<T1, Map<String, Serializable>> mapper() {
        return mapper(getRowMapper(PrefixedBeanMapper.MAP_TYPE));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T2> MulitiQueryRowMapper2<T1, T2> mapper(Class<T2> mappingType) {
        return mapper(getRowMapper(mappingType));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T2> MulitiQueryRowMapper2<T1, T2> mapper(RowMapper<T2> rowMapper) {
        return new MulitiQueryRowMapper2Impl<>(new RowMapper[] { getRowMappers()[0], rowMapper }, getRowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T2> MulitiQueryRowMapper2<T1, T2> mapper(Function<TupleRowMapperBuilder, RowMapper<T2>> rowMapper) {
        return mapper(rowMapper.apply(new TupleRowMapperBuilderImpl(getRowMapper)));
    }

}
