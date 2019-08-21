
package cn.featherfly.juorm.tpl.mapper;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import cn.featherfly.common.structure.HashChainMap;
import cn.featherfly.juorm.Juorm;
import cn.featherfly.juorm.rdb.jdbc.vo.UserInfo;

/**
 * <p>
 * UserMapper
 * </p>
 * <p>
 * 2019-08-14
 * </p>
 *
 * @author zhongj
 */
@Repository
public class UserInfoMapper2 {

    @Resource
    Juorm juorm;

    /**
     * @param juorm
     */
    public UserInfoMapper2() {
        super();
    }

    @Cacheable(key = "'userInfo:id:'+ #id", value = "userInfoCache")
    public UserInfo selectById(Integer id) {
        return juorm.single("user_info@selectById", UserInfo.class,
                new HashChainMap<String, Object>().putChain("id", id));
    }
}
