
/*
 * All rights Reserved, Designed By zhongj
 * @Title: HammerSupport.java
 * @Package cn.featherfly.hammer
 * @Description: HammerSupport
 * @author: zhongj
 * @date: 2021-12-19 19:34:19
 * @Copyright: 2021 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer;

import cn.featherfly.hammer.config.HammerConfig;

/**
 * HammerSupport.
 *
 * @author zhongj
 */
public interface HammerSupport {

    /**
     * Gets the hammer.
     *
     * @return the hammer
     */
    Hammer getHammer();

    /**
     * Gets the hammer config.
     *
     * @return the hammer config
     */
    HammerConfig getHammerConfig();
}
