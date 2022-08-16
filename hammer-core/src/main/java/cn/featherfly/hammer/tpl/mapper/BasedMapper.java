
package cn.featherfly.hammer.tpl.mapper;

import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.HammerSupport;

/**
 * BasedMapper.
 *
 * @author zhongj
 */
public class BasedMapper implements HammerSupport {

    /** The hammer. */
    protected Hammer hammer;

    /**
     * Instantiates a new based hammer tpl executor.
     *
     * @param hammer the hammer
     */
    public BasedMapper(Hammer hammer) {
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
