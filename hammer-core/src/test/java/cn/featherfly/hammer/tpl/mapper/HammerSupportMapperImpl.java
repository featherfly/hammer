
package cn.featherfly.hammer.tpl.mapper;

import cn.featherfly.common.repository.Params;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.tpl.TplExecuteIdFileImpl;

/**
 * @author zhongj
 */
public class HammerSupportMapperImpl extends BasedMapper implements HammerSupportMapper {

    /**
     * @param hammer
     * @param hammerConfig
     */
    public HammerSupportMapperImpl(Hammer hammer, HammerConfig hammerConfig) {
        super(hammer, hammerConfig);
    }

    @Override
    public User getByUsername(String username) {
        return tplExecutor.single(new TplExecuteIdFileImpl("getByUsername", "HammerSupport", parser), User.class,
            new Params().set("username", username));
    }

}
