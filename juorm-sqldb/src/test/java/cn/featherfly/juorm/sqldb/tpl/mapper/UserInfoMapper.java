
package cn.featherfly.juorm.sqldb.tpl.mapper;

import org.springframework.cache.annotation.Cacheable;

import cn.featherfly.juorm.Juorm;
import cn.featherfly.juorm.sqldb.jdbc.vo.User;
import cn.featherfly.juorm.sqldb.jdbc.vo.UserInfo;
import cn.featherfly.juorm.tpl.annotation.Mapper;
import cn.featherfly.juorm.tpl.annotation.TplParam;

/**
 * <p>
 * UserMapper
 * </p>
 *
 * @author zhongj
 */
@Mapper(namespace = "user_info")
public interface UserInfoMapper extends Juorm {

    @Cacheable(key = "'userInfo:id:'+ #id", value = "userInfoCache")
    UserInfo selectById(@TplParam("id") Integer id);

    default User getByUsernameAndPassword(String username, String pwd) {
        return query(User.class).where().eq("username", username).and().eq("pwd", pwd).single();
    }
}
