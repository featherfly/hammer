
package cn.featherfly.hammer.sqldb.tpl.mapper;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import cn.featherfly.common.structure.ChainMapImpl;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.UserInfo;

/**
 * UserInfoMapper2.
 *
 * @author zhongj
 */
@Repository
public class UserInfoMapper2 {

    @Resource
    Hammer hammer;

    /**
     * @param hammer
     */
    public UserInfoMapper2() {
        super();
    }

    @Cacheable(key = "'userInfo:id:'+ #id", value = "userInfoCache")
    public UserInfo selectById(Integer id) {
        return hammer.template().single("user_info@selectById", UserInfo.class,
            new ChainMapImpl<String, Object>().putChain("id", id));
    }
}
