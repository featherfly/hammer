
package cn.featherfly.juorm.config;

import cn.featherfly.juorm.Juorm;

/**
 * <p>
 * Configurator
 * </p>
 *
 * @author zhongj
 */
public interface Configurator {
    /**
     * get juorm from config
     *
     * @return Juorm
     */
    Juorm getJuorm();
}
