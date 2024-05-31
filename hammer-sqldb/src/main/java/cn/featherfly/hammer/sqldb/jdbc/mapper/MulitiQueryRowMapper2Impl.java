
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

import org.apache.commons.lang3.ArrayUtils;

import cn.featherfly.common.bean.InstantiatorFactory;
import cn.featherfly.common.repository.mapper.MulitiQueryRowMapper2;
import cn.featherfly.common.repository.mapper.MulitiQueryRowMapper3;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.MapRowMapper;
import cn.featherfly.hammer.sqldb.jdbc.NestedBeanPropertyRowMapper;

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
     * @param jdbc the jdbc
     * @param instantiatorFactory the instantiator factory
     */
    public MulitiQueryRowMapper2Impl(RowMapper<?>[] rowMappers, Jdbc jdbc, InstantiatorFactory instantiatorFactory) {
        super(rowMappers, jdbc, instantiatorFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MulitiQueryRowMapper3<T1, T2, Map<String, Serializable>> map() {
        return map(new MapRowMapper(jdbc.getSqlTypeMappingManager()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T3> MulitiQueryRowMapper3<T1, T2, T3> map(Class<T3> mappingType) {
        return map(new NestedBeanPropertyRowMapper<>(instantiatorFactory.create(mappingType),
            jdbc.getSqlTypeMappingManager()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T3> MulitiQueryRowMapper3<T1, T2, T3> map(RowMapper<T3> rowMapper) {
        return new MulitiQueryRowMapper3Impl<>(ArrayUtils.add(getRowMappers(), rowMapper), jdbc, instantiatorFactory);
    }

}