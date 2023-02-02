
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

import java.util.HashSet;
import java.util.Set;

import cn.featherfly.common.lang.CollectionUtils;
import cn.featherfly.common.lang.Strings;
import cn.featherfly.common.operator.QueryOperator;
import cn.featherfly.hammer.sqldb.SqldbHammerException;
import cn.featherfly.hammer.tpl.AutoRegistTransverter;

/**
 * FuzzyQueryTransverter.
 *
 * @author zhongj
 */
public class FuzzyQueryTransverter implements AutoRegistTransverter {

    private boolean upperCase;

    private final Set<String> supports = new HashSet<>();

    /**
     * Instantiates a new fuzzy query transverter.
     */
    public FuzzyQueryTransverter() {
        this(true);
    }

    /**
     * Instantiates a new fuzzy query transverter.
     *
     * @param upperCase the upper case
     */
    public FuzzyQueryTransverter(boolean upperCase) {
        super();
        this.upperCase = upperCase;
        if (upperCase) {
            CollectionUtils.addAll(supports, QueryOperator.CO.name(), QueryOperator.SW.name(), QueryOperator.EW.name());
        } else {
            CollectionUtils.addAll(supports, QueryOperator.CO.name().toLowerCase(),
                    QueryOperator.SW.name().toLowerCase(), QueryOperator.EW.name().toLowerCase());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<String> supportOperators() {
        return supports;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object transvert(String operator, Object value) {
        //        if (Lang.isNotEmpty(operator)) {
        if (QueryOperator.CO.name().equals(operator)) {
            return "%" + value + "%";
        } else if (QueryOperator.SW.name().equals(operator)) {
            return value + "%";
        } else if (QueryOperator.EW.name().equals(operator)) {
            return "%" + value;
        } else {
            throw new SqldbHammerException(Strings.format("{0} can not transvert value with operator {1}",
                    this.getClass().getName(), operator));
        }
        //        }
        //        return value;
    }

    /**
     * get upperCase value.
     *
     * @return upperCase
     */
    public boolean isUpperCase() {
        return upperCase;
    }
}
