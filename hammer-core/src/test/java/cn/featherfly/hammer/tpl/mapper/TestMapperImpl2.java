
package cn.featherfly.hammer.tpl.mapper;

import org.springframework.cache.annotation.Cacheable;

import cn.featherfly.hammer.Hammer;

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
    public TestMapperImpl2(Hammer hammer) {
        super(hammer, User.class);
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
    public User getByUsername(String username) {
        // YUFEI_TODO Auto-generated method stub
        return null;
    }
}
