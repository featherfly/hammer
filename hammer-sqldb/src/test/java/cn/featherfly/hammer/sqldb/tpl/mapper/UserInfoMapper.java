
package cn.featherfly.hammer.sqldb.tpl.mapper;

import org.springframework.cache.annotation.Cacheable;

import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.sqldb.jdbc.vo.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.UserInfo;
import cn.featherfly.hammer.tpl.annotation.Mapper;
import cn.featherfly.hammer.tpl.annotation.Param;

/**
 * <p>
 * UserMapper
 * </p>
 *
 * @author zhongj
 */
@Mapper(namespace = "user_info")
public interface UserInfoMapper extends Hammer {

    @Cacheable(key = "'userInfo:id:'+ #id", value = "userInfoCache")
    UserInfo selectById(@Param("id") Integer id);

    default User getByUsernameAndPassword(String username, String pwd) {
        return query(User.class).where().eq("username", username).and().eq("pwd", pwd).single();
    }
}
