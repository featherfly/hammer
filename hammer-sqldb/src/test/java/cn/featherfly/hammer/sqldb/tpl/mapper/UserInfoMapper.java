
package cn.featherfly.hammer.sqldb.tpl.mapper;

import java.io.Serializable;

import org.springframework.cache.annotation.Cacheable;

import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.annotation.Mapper;
import cn.featherfly.hammer.annotation.Param;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo;

/**
 * UserInfoMapper.
 *
 * @author zhongj
 */
@Mapper(namespace = "user_info")
public interface UserInfoMapper extends Hammer {

    /** The cache name. */
    String CACHE_NAME = "userInfo:id:";

    /**
     * Gets the.
     *
     * @param id the id
     * @return the user info
     */
    @Cacheable(key = "'" + CACHE_NAME + "' + #id", cacheNames = "userInfoCache")
    default UserInfo get(Integer id) {
        return get(id, UserInfo.class);
    }

    /**
     * Gets the 2.
     *
     * @param id the id
     * @return the 2
     */
    @Cacheable(key = "'userInfo:id:'+ #id", value = "userInfoCache")
    default UserInfo get2(Serializable id) {
        return get(id, UserInfo.class);
    }

    /**
     * Select by id.
     *
     * @param id the id
     * @return the user info
     */
    @Cacheable(key = "'userInfo:id:'+ #id", value = "userInfoCache")
    UserInfo selectById(@Param("id") Integer id);

    /**
     * Gets the by username and password.
     *
     * @param username the username
     * @param pwd      the pwd
     * @return the by username and password
     */
    default User getByUsernameAndPassword(String username, String pwd) {
        //        return query(User.class).where().eq("username", username).and().eq("pwd", pwd).single();
        return query(User.class).where().eq(User::getUsername, username).and().eq(User::getPwd, pwd).single();
    }
}
