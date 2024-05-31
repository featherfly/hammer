
package cn.featherfly.hammer.tpl.mapper;

import java.io.Serializable;

import cn.featherfly.common.structure.ChainMapImpl;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.tpl.TplExecuteIdFileImpl;

/**
 * @author zhongj
 */
public class GenericHammerSupportMapperImpl extends BasedGenericMapper<User, Long>
    implements GenericHammerSupportMapper {

    /**
     * @param hammer
     * @param hammerConfig
     */
    public GenericHammerSupportMapperImpl(Hammer hammer, HammerConfig hammerConfig) {
        super(hammer, User.class, hammerConfig);
    }

    @Override
    public User getByUsername(String username) {
        return tplExecutor.single(new TplExecuteIdFileImpl("getByUsername", "GenericHammerSupportMapper", parser),
            User.class, new ChainMapImpl<String, Serializable>().putChain("username", username));
    }

}
