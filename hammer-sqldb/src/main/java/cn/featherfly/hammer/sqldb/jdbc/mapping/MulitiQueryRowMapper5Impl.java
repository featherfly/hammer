
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-20 01:38:20
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.mapping;

import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

import cn.featherfly.common.bean.InstantiatorFactory;
import cn.featherfly.common.repository.mapping.MulitiQueryRowMapper5;
import cn.featherfly.common.repository.mapping.MulitiQueryRowMapper6;
import cn.featherfly.common.repository.mapping.RowMapper;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.MapRowMapper;
import cn.featherfly.hammer.sqldb.jdbc.NestedBeanPropertyRowMapper;

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
     * @param jdbc the jdbc
     * @param instantiatorFactory the instantiator factory
     */
    public MulitiQueryRowMapper5Impl(RowMapper<?>[] rowMappers, Jdbc jdbc, InstantiatorFactory instantiatorFactory) {
        super(rowMappers, jdbc, instantiatorFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MulitiQueryRowMapper6<T1, T2, T3, T4, T5, Map<String, Object>> map() {
        return map(new MapRowMapper(jdbc.getSqlTypeMappingManager()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T6> MulitiQueryRowMapper6<T1, T2, T3, T4, T5, T6> map(Class<T6> mappingType) {
        return map(new NestedBeanPropertyRowMapper<>(instantiatorFactory.create(mappingType),
            jdbc.getSqlTypeMappingManager()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T6> MulitiQueryRowMapper6<T1, T2, T3, T4, T5, T6> map(RowMapper<T6> rowMapper) {
        return new MulitiQueryRowMapper6Impl<>(ArrayUtils.add(getRowMappers(), rowMapper), jdbc, instantiatorFactory);
    }

}
