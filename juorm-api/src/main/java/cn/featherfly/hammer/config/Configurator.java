
package cn.featherfly.hammer.config;

import cn.featherfly.hammer.Hammer;

/**
 * <p>
 * Configurator
 * </p>
 *
 * @author zhongj
 */
public interface Configurator {
    /**
     * get hammer from config
     *
     * @return Hammer
     */
    Hammer getHammer();
}
