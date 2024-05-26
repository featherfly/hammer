
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-04-20 01:38:20
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.mapper;

import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

import cn.featherfly.common.bean.InstantiatorFactory;
import cn.featherfly.common.repository.mapper.MulitiQueryRowMapper4;
import cn.featherfly.common.repository.mapper.MulitiQueryRowMapper5;
import cn.featherfly.common.repository.mapper.RowMapper;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.MapRowMapper;
import cn.featherfly.hammer.sqldb.jdbc.NestedBeanPropertyRowMapper;

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
     * @param jdbc the jdbc
     * @param instantiatorFactory the instantiator factory
     */
    public MulitiQueryRowMapper4Impl(RowMapper<?>[] rowMappers, Jdbc jdbc, InstantiatorFactory instantiatorFactory) {
        super(rowMappers, jdbc, instantiatorFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MulitiQueryRowMapper5<T1, T2, T3, T4, Map<String, Object>> map() {
        return map(new MapRowMapper(jdbc.getSqlTypeMappingManager()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T5> MulitiQueryRowMapper5<T1, T2, T3, T4, T5> map(Class<T5> mappingType) {
        return map(new NestedBeanPropertyRowMapper<>(instantiatorFactory.create(mappingType),
            jdbc.getSqlTypeMappingManager()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T5> MulitiQueryRowMapper5<T1, T2, T3, T4, T5> map(RowMapper<T5> rowMapper) {
        return new MulitiQueryRowMapper5Impl<>(ArrayUtils.add(getRowMappers(), rowMapper), jdbc, instantiatorFactory);
    }

}
