
/*
 * All rights Reserved, Designed By zhongj
 * @Title: FuzzyQueryTransverter.java
 * @Package cn.featherfly.hammer.sqldb.tpl
 * @Description: 模糊查询转换器
 * @author: zhongj
 * @date: 2021-08-17 15:03:17
 * @Copyright: 2021 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.sqldb.tpl.transverter;

import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.repository.operate.QueryOperator;
import cn.featherfly.hammer.tpl.Transverter;

/**
 * FuzzyQueryTransverter.
 *
 * @author zhongj
 */
public class FuzzyQueryTransverter implements Transverter {

    /**
     * {@inheritDoc}
     */
    @Override
    public Object transvert(String operator, Object value) {
        if (Lang.isNotEmpty(operator)) {
            try {
                if (QueryOperator.CO.name().equals(operator)) {
                    return "%" + value + "%";
                } else if (QueryOperator.SW.name().equals(operator)) {
                    return value + "%";
                } else if (QueryOperator.EW.name().equals(operator)) {
                    return "%" + value;
                }
            } catch (Exception e) {
            }
        }
        return value;
    }
}
