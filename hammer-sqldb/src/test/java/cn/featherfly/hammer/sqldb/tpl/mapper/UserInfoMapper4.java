
package cn.featherfly.hammer.sqldb.tpl.mapper;

import javax.validation.constraints.NotNull;

import cn.featherfly.hammer.GenericHammerSupport;
import cn.featherfly.hammer.annotation.Mapper;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo2;

/**
 * UserInfoMapper3.
 *
 * @author zhongj
 */
@Mapper(namespace = "user_info")
public interface UserInfoMapper4 extends GenericHammerSupport<UserInfo2, Long> {

    default UserInfo2 get(Long id) {
        return getHammer().get(id);
    }

    default int save(@NotNull UserInfo2 userInfo2) {
        return getHammer().save(userInfo2);
    }

    default int update(@NotNull UserInfo2 userInfo2) {
        return getHammer().update(userInfo2);
    }
}
