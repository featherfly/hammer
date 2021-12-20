
package cn.featherfly.hammer.tpl.mapper;

import cn.featherfly.hammer.GenericHammerSupport;
import cn.featherfly.hammer.tpl.annotation.Mapper;

/**
 * <p>
 * TestMapper
 * </p>
 *
 * @author zhongj
 */
@Mapper
public interface GenericHammerSupportMapper extends GenericHammerSupport<User, Long> {

    default User get(Long id) {
        return getHammer().get(id);
    }

    User getByUsername(String username);
}
