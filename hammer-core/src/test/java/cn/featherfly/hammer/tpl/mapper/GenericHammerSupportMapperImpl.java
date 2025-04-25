
package cn.featherfly.hammer.tpl.mapper;

import java.io.Serializable;
import java.lang.reflect.Method;

import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.structure.ChainMapImpl;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.tpl.TplExecuteIdFileImpl;

/**
 * @author zhongj
 */
public class GenericHammerSupportMapperImpl extends BasedGenericMapper<User, Long>
    implements GenericHammerSupportMapper {

    private static final Method $getByUsername_String =
        ClassUtils.getMethod(GenericHammerSupportMapper.class, "getByUsername", String.class);

    private static final Method $getByUsernameAndPassword_String_String =
        ClassUtils.getMethod(GenericHammerSupportMapper.class, "getByUsernameAndPassword", String.class, String.class);

    private static final Method $get2_long =
        ClassUtils.getMethod(GenericHammerSupportMapper.class, "get2", Long.class);

    private static final Method $getUser_String_String =
        ClassUtils.getMethod(GenericHammerSupportMapper.class, "getByUsername", String.class);

    /**
     * @param hammer
     * @param hammerConfig
     */
    public GenericHammerSupportMapperImpl(Hammer hammer, HammerConfig hammerConfig) {
        super(hammer, User.class, hammerConfig);
    }

    @Override
    public User get2(Long id) {
        hammerConfig.getValidatorConfig().validateParameters(this, $get2_long, new Object[] { id });
        return GenericHammerSupportMapper.super.get2(id);
    }

    @Override
    public User getUser(String username, String password) {
        hammerConfig.getValidatorConfig().validateParameters(this, $getUser_String_String,
            new Object[] { username, password });
        return GenericHammerSupportMapper.super.getUser(username, password);
    }

    @Override
    public User getByUsername(String username) {
        hammerConfig.getValidatorConfig().validateParameters(this, $getByUsername_String, new Object[] { username });
        return tplExecutor.single(new TplExecuteIdFileImpl("getByUsername", "GenericHammerSupportMapper", parser),
            User.class, new ChainMapImpl<String, Serializable>().putChain("username", username));
    }

    @Override
    public User getByUsernameAndPassword(String username, String password) {
        hammerConfig.getValidatorConfig().validateParameters(this, $getByUsernameAndPassword_String_String,
            new Object[] { username, password });
        return tplExecutor.single(
            new TplExecuteIdFileImpl("getByUsernameAndPassword", "GenericHammerSupportMapper", parser),
            User.class, new ChainMapImpl<String, Serializable>() //
                .putChain("username", username) //
                .putChain("password", password));
    }

}
