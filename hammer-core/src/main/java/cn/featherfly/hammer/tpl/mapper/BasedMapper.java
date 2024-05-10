
package cn.featherfly.hammer.tpl.mapper;

import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.HammerSupport;
import cn.featherfly.hammer.config.HammerConfig;

/**
 * BasedMapper.
 *
 * @author zhongj
 */
public class BasedMapper extends AbstractBasedHammer implements HammerSupport {

    /** The hammer. */
    protected Hammer hammer;

    /**
     * Instantiates a new based hammer tpl executor.
     *
     * @param hammer       the hammer
     * @param hammerConfig the hammer config
     */
    public BasedMapper(Hammer hammer, HammerConfig hammerConfig) {
        super(hammer.template(), hammerConfig);
        this.hammer = hammer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Hammer getHammer() {
        return hammer;
    }
}
