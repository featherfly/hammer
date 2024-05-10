
package cn.featherfly.hammer.tpl.mapper;

import java.util.List;

import cn.featherfly.common.structure.ChainMapImpl;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.tpl.TplExecuteIdFileImpl;

/**
 * <p>
 * TestMapper
 * </p>
 *
 * @author zhongj
 */
public class TMapperImpl3 extends BasedMapper implements TMapper3 {

    /**
     * @param hammer
     */
    public TMapperImpl3(Hammer hammer, HammerConfig hammerConfig) {
        super(hammer, hammerConfig);
    }

    @Override
    public List<User> getGtAge(int age) {
        return tplExecutor.list(new TplExecuteIdFileImpl("getGtAge", "TMapper", parser), User.class,
                new ChainMapImpl<String, Object>().putChain("age", age));
    }
}
