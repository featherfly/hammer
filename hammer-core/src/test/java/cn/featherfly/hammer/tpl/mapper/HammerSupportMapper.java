
package cn.featherfly.hammer.tpl.mapper;

import cn.featherfly.hammer.HammerSupport;
import cn.featherfly.hammer.annotation.Mapper;

/**
 * <p>
 * TestMapper
 * </p>
 *
 * @author zhongj
 */
@Mapper
public interface HammerSupportMapper extends HammerSupport {

    default User get(Long id) {
        return getHammer().get(id, User.class);
    }

    User getByUsername(String username);
}
