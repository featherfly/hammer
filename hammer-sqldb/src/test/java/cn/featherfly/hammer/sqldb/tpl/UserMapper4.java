
package cn.featherfly.hammer.sqldb.tpl;

import cn.featherfly.hammer.GenericHammer;
import cn.featherfly.hammer.sqldb.jdbc.vo.User;
import cn.featherfly.hammer.tpl.annotation.Mapper;

/**
 * <p>
 * UserMapper
 * </p>
 *
 * @author zhongj
 */
@Mapper(namespace = "user")
public interface UserMapper4 extends GenericHammer<User, Integer> {

    @Override
    User get(Integer id);

    default User getById(int id) {
        return query().where().eq(User::getId, id).single();
    }
}
