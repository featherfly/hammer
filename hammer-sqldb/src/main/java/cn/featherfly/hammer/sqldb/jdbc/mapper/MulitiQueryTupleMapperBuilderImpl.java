
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-20 01:07:20
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.mapper;

import java.io.Serializable;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

import cn.featherfly.common.repository.mapper.MulitiQueryRowMapper1;
import cn.featherfly.common.repository.mapper.MulitiQueryTupleMapperBuilder;
import cn.featherfly.common.repository.mapper.PrefixedBeanMapper;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.common.repository.mapper.TupleRowMapperBuilder;

/**
 * ArrayParamMulitiQueryTupleMapperBuilder.
 *
 * @author zhongj
 */
public class MulitiQueryTupleMapperBuilderImpl implements MulitiQueryTupleMapperBuilder {

    private final BiFunction<Class<?>, String, RowMapper<?>> getRowMapper;

    /**
     * Instantiates a new muliti query tuple mapper builder impl.
     *
     * @param getRowMapper the get row mapper
     */
    public MulitiQueryTupleMapperBuilderImpl(BiFunction<Class<?>, String, RowMapper<?>> getRowMapper) {
        super();
        this.getRowMapper = getRowMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MulitiQueryRowMapper1<Map<String, Serializable>> mapper() {
        return mapper(PrefixedBeanMapper.MAP_TYPE);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T1> MulitiQueryRowMapper1<T1> mapper(Class<T1> mappingType) {
        return mapper((RowMapper<T1>) getRowMapper.apply(mappingType, null));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1> MulitiQueryRowMapper1<T1> mapper(RowMapper<T1> rowMapper) {
        return new MulitiQueryRowMapper1Impl<>(rowMapper, getRowMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1> MulitiQueryRowMapper1<T1> mapper(Function<TupleRowMapperBuilder, RowMapper<T1>> rowMapper) {
        return mapper(rowMapper.apply(new TupleRowMapperBuilderImpl(getRowMapper)));
    }

}
