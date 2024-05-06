
package cn.featherfly.hammer.sqldb.tpl;

import java.util.List;
import java.util.Map;

import cn.featherfly.common.structure.page.Page;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.annotation.Mapper;
import cn.featherfly.hammer.annotation.Param;
import cn.featherfly.hammer.annotation.ParamType;
import cn.featherfly.hammer.annotation.Template;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.User;

/**
 * <p>
 * UserMapper
 * </p>
 *
 * @author zhongj
 */
@Mapper(namespace = "user")
public interface UserMapper2 extends Hammer {
    User selectByUsername(@Param("username") String username);

    Map<String, Object> selectByUsername2(@Param("username") String username);

    User selectByUsernameAndPassword(@Param("username") String username, @Param("password") String pwd);

    Integer selectAvg();

    String selectString();

    List<User> selectByAge2(@Param("age") Integer age);

    @Template
    List<User> selectByAge2(@Param("age") Integer age, @Param(type = ParamType.PAGE_OFFSET) int offset,
            @Param(type = ParamType.PAGE_LIMIT) int limit);

    @Template
    List<User> selectByAge2(@Param("age") Integer age, Page page);

    @Template(name = "selectByAge2")
    PaginationResults<User> selectByAge2Page(@Param("age") Integer age,
            @Param(type = ParamType.PAGE_OFFSET) int offset, @Param(type = ParamType.PAGE_LIMIT) int limit);

    @Template(name = "selectByAge2")
    PaginationResults<User> selectByAge2Page(@Param("age") Integer age, Page page);

    List<User> selectById(@Param("id") Integer id);

    Integer selectAvg2(@Param("age") Integer age);

    String selectString2(@Param("id") Integer id);

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
    List<Map<String, Object>> selectById2(@Param("id") Integer id);
}
