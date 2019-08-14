
package cn.featherfly.juorm.rdb.tpl;

import java.util.List;
import java.util.Map;

import cn.featherfly.common.structure.page.Page;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.juorm.rdb.jdbc.vo.User;
import cn.featherfly.juorm.tpl.annotation.TplExecution;
import cn.featherfly.juorm.tpl.annotation.TplParam;
import cn.featherfly.juorm.tpl.annotation.TplParamType;

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
@TplExecution(namesapce = "user")
public interface UserMapper {

    User selectByUsername(@TplParam("username") String username);

    Map<String, Object> selectByUsername2(@TplParam("username") String username);

    User selectByUsernameAndPassword(@TplParam("username") String username, @TplParam("password") String pwd);

    Integer selectAvg();

    String selectString();

    List<User> selectByAge2(@TplParam("age") Integer age);

    @TplExecution
    List<User> selectByAge2(@TplParam("age") Integer age, @TplParam(type = TplParamType.PAGE_OFFSET) int offset,
            @TplParam(type = TplParamType.PAGE_LIMIT) int limit);

    @TplExecution
    List<User> selectByAge2(@TplParam("age") Integer age, Page page);

    @TplExecution(name = "selectByAge2")
    PaginationResults<User> selectByAge2Page(@TplParam("age") Integer age,
            @TplParam(type = TplParamType.PAGE_OFFSET) int offset, @TplParam(type = TplParamType.PAGE_LIMIT) int limit);

    @TplExecution(name = "selectByAge2")
    PaginationResults<User> selectByAge2Page(@TplParam("age") Integer age, Page page);

    List<User> selectById(@TplParam("id") Integer id);

    Integer selectAvg2(@TplParam("age") Integer age);

    String selectString2(@TplParam("id") Integer id);

    @TplExecution(namesapce = "user_info")
    List<Map<String, Object>> select2();

    @TplExecution(namesapce = "user_info", name = "select2")
    List<Map<String, Object>> select2(@TplParam(type = TplParamType.PAGE_OFFSET) int offset,
            @TplParam(type = TplParamType.PAGE_LIMIT) int limit);

    @TplExecution(namesapce = "user_info", name = "select2")
    List<Map<String, Object>> select2(Page page);

    @TplExecution(namesapce = "user_info", name = "select2")
    PaginationResults<Map<String, Object>> select2Page(@TplParam(type = TplParamType.PAGE_OFFSET) int offset,
            @TplParam(type = TplParamType.PAGE_LIMIT) int limit);

    @TplExecution(namesapce = "user_info", name = "select2")
    PaginationResults<Map<String, Object>> select2Page(Page page);

    @TplExecution(namesapce = "user_info", name = "selectById")
    List<Map<String, Object>> selectById2(@TplParam("id") Integer id);
}
