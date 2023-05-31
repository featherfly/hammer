
package cn.featherfly.hammer.sqldb.tpl;

import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.tpl.annotation.Mapper;
import cn.featherfly.hammer.tpl.annotation.Template;

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
