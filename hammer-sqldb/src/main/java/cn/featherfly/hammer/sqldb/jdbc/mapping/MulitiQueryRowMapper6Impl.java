
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-20 01:38:20
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.jdbc.mapping;

import cn.featherfly.common.bean.InstantiatorFactory;
import cn.featherfly.common.repository.mapping.MulitiQueryRowMapper6;
import cn.featherfly.common.repository.mapping.RowMapper;
import cn.featherfly.hammer.sqldb.jdbc.Jdbc;

/**
 * MulitiQueryRowMapper6.
 *
 * @author zhongj
 * @param <T1> the generic type
 * @param <T2> the generic type
 * @param <T3> the generic type
 * @param <T4> the generic type
 * @param <T5> the generic type
 * @param <T6> the generic type
 */
public class MulitiQueryRowMapper6Impl<T1, T2, T3, T4, T5, T6> extends AbstractMulitiQueryRowMapper
    implements MulitiQueryRowMapper6<T1, T2, T3, T4, T5, T6> {

    /**
     * Instantiates a new muliti query row mapper 6 impl.
     *
     * @param rowMappers the row mappers
     * @param jdbc the jdbc
     * @param instantiatorFactory the instantiator factory
     */
    public MulitiQueryRowMapper6Impl(RowMapper<?>[] rowMappers, Jdbc jdbc, InstantiatorFactory instantiatorFactory) {
        super(rowMappers, jdbc, instantiatorFactory);
    }
}
