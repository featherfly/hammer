
package cn.featherfly.hammer.tpl.mapper;

import java.io.Serializable;

import cn.featherfly.hammer.GenericHammer;
import cn.featherfly.hammer.GenericHammerSupport;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.config.HammerConfig;

/**
 * The Class BasedGenericMapper.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <ID> the generic type
 */
public class BasedGenericMapper<E, ID extends Serializable> extends AbstractBasedHammer
        implements GenericHammerSupport<E, ID> {

    /** The hammer. */
    protected final GenericHammer<E, ID> hammer;

    /**
     * Instantiates a new based generic mapper.
     *
     * @param hammer       the hammer
     * @param type         the type
     * @param hammerConfig the hammer config
     */
    public BasedGenericMapper(Hammer hammer, Class<E> type, HammerConfig hammerConfig) {
        super(hammer.template(), hammerConfig);
        this.hammer = new BasedTplGenericHammer<>(hammer, type, hammerConfig);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GenericHammer<E, ID> getHammer() {
        return hammer;
    }
}
