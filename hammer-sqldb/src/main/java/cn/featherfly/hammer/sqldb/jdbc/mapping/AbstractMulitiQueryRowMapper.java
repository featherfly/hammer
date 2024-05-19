
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2022-02-20 01:28:20
 * @Copyright: 2022 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.mapping;

import cn.featherfly.common.bean.InstantiatorFactory;
import cn.featherfly.common.repository.mapping.RowMapper;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * AbstractMulitiQueryRowMapper.
 *
 * @author zhongj
 */
public abstract class AbstractMulitiQueryRowMapper {

    private final RowMapper<?>[] rowMappers;

    /** The jdbc. */
    protected final Jdbc jdbc;

    /** The instantiator factory. */
    protected final InstantiatorFactory instantiatorFactory;

    /**
     * Instantiates a new abstract muliti query row mapper.
     *
     * @param rowMappers the row mappers
     * @param jdbc the jdbc
     * @param instantiatorFactory the instantiator factory
     */
    protected AbstractMulitiQueryRowMapper(RowMapper<?>[] rowMappers, Jdbc jdbc,
        InstantiatorFactory instantiatorFactory) {
        this.rowMappers = rowMappers;
        this.jdbc = jdbc;
        this.instantiatorFactory = instantiatorFactory;
    }

    /**
     * Gets the row mappers.
     *
     * @return the row mappers
     */
    public RowMapper<?>[] getRowMappers() {
        return rowMappers;
    }
}
