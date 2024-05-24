
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

import cn.featherfly.common.bean.InstantiatorFactory;
import cn.featherfly.common.repository.mapper.MulitiQueryRowMapper1;
import cn.featherfly.common.repository.mapper.MulitiQueryTupleMapperBuilder;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.MapRowMapper;
import cn.featherfly.hammer.sqldb.jdbc.NestedBeanPropertyRowMapper;

/**
 * ArrayParamMulitiQueryTupleMapperBuilder.
 *
 * @author zhongj
 */
public class MulitiQueryTupleMapperBuilderImpl implements MulitiQueryTupleMapperBuilder {

    private final Jdbc jdbc;

    private final InstantiatorFactory instantiatorFactory;

    /**
     * Instantiates a new muliti query tuple mapper builder impl.
     *
     * @param jdbc the jdbc
     * @param instantiatorFactory the instantiator factory
     */
    public MulitiQueryTupleMapperBuilderImpl(Jdbc jdbc, InstantiatorFactory instantiatorFactory) {
        super();
        this.jdbc = jdbc;
        this.instantiatorFactory = instantiatorFactory;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MulitiQueryRowMapper1<Map<String, Serializable>> map() {
        return map(new MapRowMapper(jdbc.getSqlTypeMappingManager()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1> MulitiQueryRowMapper1<T1> map(Class<T1> mappingType) {
        return map(new NestedBeanPropertyRowMapper<>(instantiatorFactory.create(mappingType),
            jdbc.getSqlTypeMappingManager()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T1> MulitiQueryRowMapper1<T1> map(RowMapper<T1> rowMapper) {
        return new MulitiQueryRowMapper1Impl<>(rowMapper, jdbc, instantiatorFactory);
    }

}
