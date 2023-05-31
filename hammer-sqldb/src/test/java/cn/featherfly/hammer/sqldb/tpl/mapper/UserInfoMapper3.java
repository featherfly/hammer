
package cn.featherfly.hammer.sqldb.tpl.mapper;

import org.springframework.cache.annotation.Cacheable;

import cn.featherfly.hammer.GenericHammer;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo2;
import cn.featherfly.hammer.tpl.annotation.Mapper;
import cn.featherfly.hammer.tpl.annotation.Param;

/**
 * UserInfoMapper3.
 *
 * @author zhongj
 */
@Mapper(namespace = "user_info")
public interface UserInfoMapper3 extends GenericHammer<UserInfo2, Long> {

    @Override
    @Cacheable(key = "'userInfo2:id:'+ #id", value = "userInfoCache")
    UserInfo2 get(@Param("id") Long id);

    @Cacheable(key = "'userInfo2:id:'+ #id", value = "userInfoCache")
    UserInfo2 selectById(@Param("id") Long id);
}
