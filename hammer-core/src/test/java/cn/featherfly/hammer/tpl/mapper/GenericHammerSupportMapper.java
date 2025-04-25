
package cn.featherfly.hammer.tpl.mapper;

import javax.validation.constraints.NotNull;

import cn.featherfly.hammer.GenericHammerSupport;
import cn.featherfly.hammer.annotation.Mapper;

/**
 * TestMapper
 *
 * @author zhongj
 */
@Mapper
public interface GenericHammerSupportMapper extends GenericHammerSupport<User, Long> {

    default User get(Long id) {
        return getHammer().get(id);
    }

    default User get2(@NotNull Long id) {
        return getHammer().get(id);
    }

    default User getUser(@NotNull String username, @NotNull String password) {
        return getHammer().query().where().eq(User::getUsername, username).and().eq(User::getPassword, password)
            .single();
    }

    User getByUsername(@NotNull String username);

    User getByUsernameAndPassword(@NotNull String username, @NotNull String password);
}
