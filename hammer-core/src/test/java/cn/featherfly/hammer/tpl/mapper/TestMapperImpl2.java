
package cn.featherfly.hammer.tpl.mapper;

import org.springframework.cache.annotation.Cacheable;

import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.config.HammerConfig;

/**
 * <p>
 * TestMapperImpl
 * </p>
 *
 * @author zhongj
 */
public class TestMapperImpl2 extends BasedTplGenericHammer<User, Long> implements TestMapper2 {
    /**
     * @param hammer
     * @param type
     */
    public TestMapperImpl2(Hammer hammer, HammerConfig hammerConfig) {
        super(hammer, User.class, hammerConfig);
    }

    @Override
    @Cacheable(cacheNames = "userCache", key = "'user:' + #id ")
    public User get(Long id) {
        return super.get(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Cacheable(cacheNames = { "userCache", "userCache2" }, key = "'user:username:' + #username ")
    public User getByUsername(String username) {
        return null;
    }
}
