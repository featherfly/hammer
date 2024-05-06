
package cn.featherfly.hammer.sqldb.tpl;

import cn.featherfly.hammer.annotation.Mapper;
import cn.featherfly.hammer.annotation.Template;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;

/**
 * UserMapper.
 *
 * @author zhongj
 */
@Mapper(namespace = "hammer/user")
public interface UserMapper5 {

    @Template("select /*<<prop*/* from user where username = :username")
    User getByUsername(String username); // 此方法测试java编译时开启-paramaeter参数
}
