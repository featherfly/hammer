
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2026-11-23 23:48:23
 * @Copyright: 2026 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.tpl.mapper;

import java.util.List;

import javax.validation.Validation;
import javax.validation.constraints.NotNull;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.hammer.GenericHammer;
import cn.featherfly.hammer.HammerValidateException;
import cn.featherfly.hammer.config.HammerConfig;
import cn.featherfly.hammer.config.HammerConfigImpl;
import cn.featherfly.hammer.config.validator.ValidatorConfigImpl;
import cn.featherfly.validation.JavaxValidator;

/**
 * OverloadUpdateMapper2Impl.
 *
 * @author zhongj
 */
public class OverloadUpdateMapper2Test {

    HammerConfigImpl hammerConfig;

    @BeforeClass
    public void before() {
        hammerConfig = new HammerConfigImpl(true);
        hammerConfig.setValidatorConfig(new ValidatorConfigImpl(
            new JavaxValidator(Validation.byDefaultProvider().configure().buildValidatorFactory().getValidator(),
                HammerValidateException::new)));
    }

    @Test(expectedExceptions = HammerValidateException.class)
    public void testUpdateEntity() {
        OverloadUpdateMapper2 m = new OverloadUpdateMapper2Impl(hammerConfig);
        m.update((User) null);
    }

    @Test(expectedExceptions = HammerValidateException.class)
    public void testUpdateList() {
        OverloadUpdateMapper2 m = new OverloadUpdateMapper2Impl(hammerConfig);
        m.update((List<User>) null);
    }
}

class OverloadUpdateMapper2Impl implements OverloadUpdateMapper2 {

    HammerConfig config;

    public OverloadUpdateMapper2Impl(HammerConfig config) {
        this.config = config;
    }

    @Override
    public int update(@NotNull User entity) {
        getHammerConfig().getValidatorConfig().getExecutableValidator().validateParametersThrow(this,
            ClassUtils.getMethod(OverloadUpdateMapper2.class, "update", User.class), new Object[] { entity });
        return 1;
    }

    @Override
    public int update(@NotNull List<User> entities) {
        getHammerConfig().getValidatorConfig().getExecutableValidator().validateParametersThrow(this,
            ClassUtils.getMethod(OverloadUpdateMapper2.class, "update", List.class), new Object[] { entities });
        return entities.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GenericHammer<User, Long> getHammer() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HammerConfig getHammerConfig() {
        return config;
    }
}