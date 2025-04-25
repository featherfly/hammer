
package cn.featherfly.hammer.sqldb.tpl.validation;

import javax.validation.constraints.NotNull;

import cn.featherfly.hammer.HammerSupport;
import cn.featherfly.hammer.annotation.Mapper;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;

/**
 * UserMapper.
 *
 * @author zhongj
 */
@Mapper(namespace = "user")
public interface UserMapperValidationApi extends HammerSupport {

    User selectByUsername(@NotNull String username);

    default User getByUsername(@NotNull String username) {
        return getHammer().query(User.class).where().eq(User::getUsername, username).single();
    }

    User selectByUsernameAndPassword(@NotNull String username, @NotNull String pwd);

}
