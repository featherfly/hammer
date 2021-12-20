
package cn.featherfly.hammer.tpl.mapper;

import org.springframework.cache.annotation.Cacheable;

import cn.featherfly.hammer.GenericHammer;
import cn.featherfly.hammer.tpl.annotation.Mapper;

/**
 * <p>
 * TestMapper
 * </p>
 *
 * @author zhongj
 */
@Mapper
public interface TestMapper2 extends GenericHammer<User, Long> {

    @Override
    @Cacheable(cacheNames = "userCache", key = "'user:' + #id ")
    User get(Long id);

    User getByUsername(String username);
}
