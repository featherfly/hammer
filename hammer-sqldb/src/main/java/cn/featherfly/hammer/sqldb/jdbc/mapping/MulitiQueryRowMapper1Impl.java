
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2022-02-20 01:28:20
 * @Copyright: 2022 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.mapping;

import java.util.Map;

import cn.featherfly.common.bean.InstantiatorFactory;
import cn.featherfly.common.repository.mapping.MulitiQueryRowMapper1;
import cn.featherfly.common.repository.mapping.MulitiQueryRowMapper2;
import cn.featherfly.common.repository.mapping.RowMapper;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;
import cn.featherfly.hammer.sqldb.jdbc.MapRowMapper;
import cn.featherfly.hammer.sqldb.jdbc.NestedBeanPropertyRowMapper;

/**
 * MulitiQueryRowMapper1.
 *
 * @author zhongj
 * @param <T1> the generic type
 */
public class MulitiQueryRowMapper1Impl<T1> extends AbstractMulitiQueryRowMapper implements MulitiQueryRowMapper1<T1> {

    private RowMapper<T1> rowMapper;

    /**
     * Instantiates a new muliti query row mapper 1 impl.
     *
     * @param rowMapper the row mapper
     * @param jdbc the jdbc
     * @param instantiatorFactory the instantiator factory
     */
    public MulitiQueryRowMapper1Impl(RowMapper<T1> rowMapper, Jdbc jdbc, InstantiatorFactory instantiatorFactory) {
        super(new RowMapper[] { rowMapper }, jdbc, instantiatorFactory);
        this.rowMapper = rowMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MulitiQueryRowMapper2<T1, Map<String, Object>> map() {
        return map(new MapRowMapper(jdbc.getSqlTypeMappingManager()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T2> MulitiQueryRowMapper2<T1, T2> map(Class<T2> mappingType) {
        return map(new NestedBeanPropertyRowMapper<>(instantiatorFactory.create(mappingType),
            jdbc.getSqlTypeMappingManager()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T2> MulitiQueryRowMapper2<T1, T2> map(RowMapper<T2> rowMapper) {
        return new MulitiQueryRowMapper2Impl<>(new RowMapper[] { this.rowMapper, rowMapper }, jdbc,
            instantiatorFactory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RowMapper<T1> getRowMapper1() {
        return rowMapper;
    }

}
