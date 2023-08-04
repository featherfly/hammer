
package cn.featherfly.hammer.sqldb.tpl;

import java.util.List;
import java.util.Map;

import cn.featherfly.common.structure.page.Page;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.GenericHammer;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;
import cn.featherfly.hammer.tpl.annotation.Mapper;
import cn.featherfly.hammer.tpl.annotation.Param;
import cn.featherfly.hammer.tpl.annotation.ParamType;
import cn.featherfly.hammer.tpl.annotation.Template;

/**
 * <p>
 * UserMapper
 * </p>
 *
 * @author zhongj
 */
@Mapper(namespace = "user")
public interface UserMapper3WithoutParamName extends GenericHammer<User, Integer> {

    User selectByUsername(String username);

    Map<String, Object> selectByUsername2(String username);

    User selectByUsernameAndPassword(String username, String password);

    Integer selectAvg();

    String selectString();

    List<User> selectByAge2(Integer age);

    @Template
    List<User> selectByAge2(Integer age, @Param(type = ParamType.PAGE_OFFSET) int offset,
            @Param(type = ParamType.PAGE_LIMIT) int limit);

    @Template
    List<User> selectByAge2(Integer age, Page page);

    @Template(name = "selectByAge2")
    PaginationResults<User> selectByAge2Page(Integer age, @Param(type = ParamType.PAGE_OFFSET) int offset,
            @Param(type = ParamType.PAGE_LIMIT) int limit);

    @Template(name = "selectByAge2")
    PaginationResults<User> selectByAge2Page(Integer age, Page page);

    List<User> selectById(Integer id);

    Integer selectAvg2(Integer age);

    String selectString2(Integer id);

    @Template(namespace = "user_info")
    List<Map<String, Object>> select2();

    @Template(namespace = "user_info", name = "select2")
    List<Map<String, Object>> select2(@Param(type = ParamType.PAGE_OFFSET) int offset,
            @Param(type = ParamType.PAGE_LIMIT) int limit);

    @Template(namespace = "user_info", name = "select2")
    List<Map<String, Object>> select2(Page page);

    @Template(namespace = "user_info", name = "select2")
    PaginationResults<Map<String, Object>> select2Page(@Param(type = ParamType.PAGE_OFFSET) int offset,
            @Param(type = ParamType.PAGE_LIMIT) int limit);

    @Template(namespace = "user_info", name = "select2")
    PaginationResults<Map<String, Object>> select2Page(Page page);

    @Template(namespace = "user_info", name = "selectById")
    List<Map<String, Object>> selectById2(Integer id);

    default User getByUsernameAndPassword(String username, String pwd) {
        //        return query().where().eq("username", username).and().eq("pwd", pwd).single();
        return query().where().eq(User::getUsername, username).and().eq(User::getPwd, pwd).single();
    }

    default User getByUsernameAndPassword2(String username, String pwd) {
        //        return query().where().eq("username", username).and().eq("password", pwd).single();
        return query().where().eq(User::getUsername, username).and().eq(User::getPwd, pwd).single();
    }

    default User getByUsernameAndPassword3(String username, String pwd) {
        //        return query().where().property("username").eq(username).and().property("pwd").eq(pwd).single();
        return query().where().property(User::getUsername).eq(username).and().property(User::getPwd).eq(pwd).single();
    }

    default int updatePasswordByUsername(String username, String pwd) {
        //return update().set("password", pwd).where().eq("username", username).execute();
        return update().set(User::getPwd, pwd).where().eq(User::getUsername, username).execute();
    }

    default int deleteByUsername(String username) {
        //return delete().where().eq("username", username);
        return delete().where().eq(User::getUsername, username).execute();
    }
}