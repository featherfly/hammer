
/*
 * All rights Reserved, Designed By zhongj
 * @Title: HammerSupport.java
 * @Package cn.featherfly.hammer
 * @Description: GenericHammerSupport
 * @author: zhongj
 * @date: 2021-12-19 19:34:19
 * @Copyright: 2021 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer;

import java.io.Serializable;

import cn.featherfly.hammer.config.HammerConfig;

/**
 * GenericHammerSupport.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <ID> the generic type
 */
public interface GenericHammerSupport<E, ID extends Serializable> {

    /**
     * Gets the hammer.
     *
     * @return the hammer
     */
    GenericHammer<E, ID> getHammer();

    /**
     * Gets the hammer config.
     *
     * @return the hammer config
     */
    HammerConfig getHammerConfig();
}
