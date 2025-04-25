
package cn.featherfly.hammer.tpl.mapper;

import javax.validation.constraints.NotNull;

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

    User getByUsername(@NotNull String username);
}
