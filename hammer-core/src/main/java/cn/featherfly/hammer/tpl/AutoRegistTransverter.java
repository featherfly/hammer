
/*
 * All rights Reserved, Designed By zhongj
 * @Title: AutoRegistTransverter.java
 * @Package cn.featherfly.hammer.tpl
 * @Description: AutoRegistTransverter
 * @author: zhongj
 * @date: 2023-01-29 15:30:29
 * @Copyright: 2023 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.tpl;

import java.util.Set;

/**
 * AutoRegistTransverter.
 *
 * @author zhongj
 */
public interface AutoRegistTransverter extends Transverter {

    /**
     * Supports.
     *
     * @return the support set
     */
    Set<String> supportOperators();
}
