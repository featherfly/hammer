
package cn.featherfly.hammer.tpl.mapper;

import java.io.Serializable;

import cn.featherfly.hammer.GenericHammer;
import cn.featherfly.hammer.GenericHammerSupport;

/**
 * The Class BasedGenericMapper.
 *
 * @author zhongj
 * @param <E>  the element type
 * @param <ID> the generic type
 */
public class BasedGenericMapper<E, ID extends Serializable> implements GenericHammerSupport<E, ID> {

    /** The hammer. */
    protected GenericHammer<E, ID> hammer;

    /**
     * Instantiates a new based generic mapper.
     *
     * @param hammer the hammer
     */
    public BasedGenericMapper(GenericHammer<E, ID> hammer) {
        this.hammer = hammer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GenericHammer<E, ID> getHammer() {
        return hammer;
    }
}
