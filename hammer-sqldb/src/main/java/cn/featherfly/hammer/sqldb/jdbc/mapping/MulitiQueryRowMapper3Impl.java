
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2023-03-20 01:38:20
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.mapping;

import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

import cn.featherfly.common.bean.InstantiatorFactory;
import cn.featherfly.common.repository.mapping.MulitiQueryRowMapper3;
import cn.featherfly.common.repository.mapping.MulitiQueryRowMapper4;
import cn.featherfly.common.repository.mapping.RowMapper;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.MapRowMapper;
import cn.featherfly.hammer.sqldb.jdbc.NestedBeanPropertyRowMapper;

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
     * @param jdbc the jdbc
     * @param instantiatorFactory the instantiator factory
     */
    public MulitiQueryRowMapper3Impl(RowMapper<?>[] rowMappers, Jdbc jdbc, InstantiatorFactory instantiatorFactory) {
        super(rowMappers, jdbc, instantiatorFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MulitiQueryRowMapper4<T1, T2, T3, Map<String, Object>> map() {
        return map(new MapRowMapper(jdbc.getSqlTypeMappingManager()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T4> MulitiQueryRowMapper4<T1, T2, T3, T4> map(Class<T4> mappingType) {
        return map(new NestedBeanPropertyRowMapper<>(instantiatorFactory.create(mappingType),
            jdbc.getSqlTypeMappingManager()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T4> MulitiQueryRowMapper4<T1, T2, T3, T4> map(RowMapper<T4> rowMapper) {
        return new MulitiQueryRowMapper4Impl<>(ArrayUtils.add(getRowMappers(), rowMapper), jdbc, instantiatorFactory);
    }

}
