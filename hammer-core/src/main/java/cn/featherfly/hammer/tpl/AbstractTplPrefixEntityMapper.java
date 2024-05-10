
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2022-05-10 18:29:10
 * @Copyright: 2022 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.tpl;

import java.util.Map;

import com.speedment.common.tuple.Tuple;

/**
 * TplPrefixEntityMapper2.
 *
 * @author      zhongj
 * @param  <T1> prefixes type
 */
public abstract class AbstractTplPrefixEntityMapper<T1 extends Tuple>
    extends AbstractPrefixEntityMapper<TplExecutor, TplExecuteId, Map<String, Object>, T1> {

    /**
     * Instantiates a new abstract tpl prefix entity mapper.
     *
     * @param executor  the executor
     * @param execution the execution
     * @param params    the params
     * @param prefixes  the prefixes
     */
    protected AbstractTplPrefixEntityMapper(TplExecutor executor, TplExecuteId execution, Map<String, Object> params,
        T1 prefixes) {
        super(executor, execution, params, prefixes);
    }
}
