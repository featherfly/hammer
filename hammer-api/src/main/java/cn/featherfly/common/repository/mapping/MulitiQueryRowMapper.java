
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2024-05-20 01:09:20
 * @Copyright: 2024 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.common.repository.mapping;

import com.speedment.common.tuple.Tuple;

/**
 * MulitiQueryRowMapper.
 *
 * @author zhongj
 */
public interface MulitiQueryRowMapper<T extends Tuple> {

    RowMapper<?>[] getRowMappers();
}
