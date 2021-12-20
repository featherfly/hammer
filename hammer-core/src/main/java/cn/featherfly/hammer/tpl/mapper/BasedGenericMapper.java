
package cn.featherfly.hammer.tpl.mapper;

import java.io.Serializable;

import cn.featherfly.hammer.GenericHammer;
import cn.featherfly.hammer.GenericHammerSupport;
import cn.featherfly.hammer.Hammer;

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
     * @param type   the type
     */
    public BasedGenericMapper(Hammer hammer, Class<E> type) {
        this.hammer = new BasedTplGenericHammer<>(hammer, type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GenericHammer<E, ID> getHammer() {
        return hammer;
    }
}
