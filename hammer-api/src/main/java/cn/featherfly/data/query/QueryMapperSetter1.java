
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-04-04 17:26:04
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.data.query;

/**
 * query mapper setter1.
 *
 * @author zhongj
 */
public interface QueryMapperSetter1 extends QueryMapperSetter0 {

    /**
     * mapper.
     *
     * @param <T> the generic type
     * @param type the type
     * @return the generic type query executor
     */
    <T> QueryExecutor<T> mapper(Class<T> type);
}