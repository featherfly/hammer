
package cn.featherfly.hammer.tpl.mapper;

import java.util.List;

import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.annotation.Mapper;
import cn.featherfly.hammer.annotation.Template;

/**
 * <p>
 * TestMapper
 * </p>
 *
 * @author zhongj
 */
@Mapper
public interface TMapper extends Hammer {

    //    @Template(name = "get", namespace = "namespace")
    //    User get();
    //
    //    @Template(name = "get_1", namespace = "namespace")
    //    User get(@Param("username") String username);
    //
    //    @Template(name = "get_2", namespace = "namespace")
    //    User get(@Param("username") String username, @Param("password") String password);
    //
    //    @Template(name = "get_3", namespace = "namespace")
    //    User get(@Param("username") String username, @Param("password") String password, @Param("age") Integer age);
    //
    //    @Template("get2")
    //    User get2();
    //
    //    @Template("get2_")
    //    User get2(String username, String password, Integer age);
    //
    //    Map<String, Object> getMap();
    //
    //    Map<String, Object> getMap(String username, String password, Integer age);
    //
    //    Map<String, Object> getMap2();
    //
    //    Map<String, Object> getMap2(String username, String password, Integer age);
    //
    //    @Template(namespace = "namespace")
    //    void update();
    //
    //    @Template(value = "merge", isTemplate = false)
    //    void merge();
    //
    //    @Template("merge")
    //    void merge(@Param("name") String name, @Param("pass") String pass);
    //
    //    @Template("merge")
    //    int merge2(@Param("name") String name, @Param("pass") String pass);
    //
    //    String getName();
    //
    //    String getName(Long id);
    //
    //    String getName2();
    //
    //    String getName2(Long id);
    //
    //    @Template(name = "getInt", namespace = "namespace", type = TplType.QUERY)
    //    int getInt();
    //
    //    @Template(name = "getInt_1", namespace = "namespace", type = TplType.QUERY)
    //    int getInt(Long id);
    //
    //    @Template(value = "getInit2", type = TplType.QUERY)
    //    int getInt2();
    //
    //    @Template(value = "getInit2_1", type = TplType.QUERY)
    //    int getInt2(Long id);
    //
    //    @Template(name = "getLong", namespace = "namespace")
    //    long getLong();
    //
    //    @Template(name = "getLong_1", namespace = "namespace")
    //    long getLong(Long id);
    //
    //    @Template("getLong2")
    //    long getLong2();
    //
    //    @Template("getLong2_1")
    //    long getLong2(Long id);
    //
    //    @Template(name = "getDouble", namespace = "namespace")
    //    double getDouble();
    //
    //    @Template(name = "getDouble_1", namespace = "namespace")
    //    double getDouble(Long id);
    //
    //    @Template("getDouble2")
    //    double getDouble2();
    //
    //    @Template("getDouble2_1")
    //    double getDouble2(Long id);
    //
    //    @Template(name = "getInteger", namespace = "namespace")
    //    Integer getInteger();
    //
    //    @Template(name = "getInteger_1", namespace = "namespace")
    //    Integer getInteger(Long id);
    //
    //    @Template("getInteger2")
    //    Integer getInteger2();
    //
    //    @Template("getInteger2_1")
    //    Integer getInteger2(Long id);
    //
    //    @Template(name = "findUserList", namespace = "namespace")
    //    List<User> findUserList();
    //
    //    @Template(name = "findUserList_1", namespace = "namespace")
    //    List<User> findUserList(String name);
    //
    //    @Template("findUserList2")
    //    List<User> findUserList2();
    //
    //    @Template("findUserList2_1")
    //    List<User> findUserList2(String name);
    //
    //    @Template(name = "findMapList", namespace = "namespace")
    //    List<Map<String, Object>> findMapList();
    //
    //    @Template(name = "findMapList_1", namespace = "namespace")
    //    List<Map<String, Object>> findMapList(String name);
    //
    //    @Template("findMapList2")
    //    List<Map<String, Object>> findMapList2();
    //
    //    @Template("findMapList2_1")
    //    List<Map<String, Object>> findMapList2(String name);
    //
    //    @Template(name = "findMapPage", namespace = "namespace")
    //    PaginationResults<Map<String, Object>> findMapPage(Page page);
    //
    //    @Template(name = "findMapPage_1", namespace = "namespace")
    //    PaginationResults<Map<String, Object>> findMapPage(String name, Page page);
    //
    //    @Template("findMapPage2")
    //    PaginationResults<Map<String, Object>> findMapPage2(Page page);
    //
    //    @Template("findMapPage2_1")
    //    PaginationResults<Map<String, Object>> findMapPage2(String name, Page page);
    //
    //    @Template(name = "findUserPage", namespace = "namespace")
    //    PaginationResults<User> findUserPage(Page page);
    //
    //    @Template(name = "findUserPage_1", namespace = "namespace")
    //    PaginationResults<User> findUserPage(String name, Page page);
    //
    //    @Template("findUserPage2")
    //    PaginationResults<User> findUserPage2(Page page);
    //
    //    @Template("findUserPage2_1")
    //    PaginationResults<User> findUserPage2(String name, Page page);
    //
    //    @Template("testPosition")
    //    PaginationResults<Map<String, Object>> testPosition(@Param(type = ParamType.PAGE_OFFSET) int offset,
    //            @Param(type = ParamType.PAGE_LIMIT) int limit, String name, String pass);
    //
    //    @Template("testPosition_1")
    //    PaginationResults<Map<String, Object>> testPosition(String name, @Param(type = ParamType.PAGE_LIMIT) int limit,
    //            String pass);
    //
    //    @Template("testPosition2")
    //    PaginationResults<User> testPosition2(@Param(type = ParamType.PAGE_OFFSET) int offset,
    //            @Param(type = ParamType.PAGE_LIMIT) int limit, String name, String pass);
    //
    //    @Template("testPosition2_1")
    //    PaginationResults<User> testPosition2(String name, @Param(type = ParamType.PAGE_LIMIT) int limit, String pass);
    //
    //    @Template("testPositionPage2")
    //    PaginationResults<User> testPosition2(Page page, String name, String pass);
    //
    //    @Template("testPositionPage")
    //    PaginationResults<Map<String, Object>> testPosition(Page page, String name, String pass);
    //
    //    @Template("findUserListPage")
    //    List<User> findUserList(Page page);
    //
    //    @Template("findUserListPage2")
    //    List<User> findUserList2(String name, Page page);
    //
    //    @Template("findUserListLimit")
    //    List<User> findUserList(@Param(type = ParamType.PAGE_OFFSET) int offset,
    //            @Param(type = ParamType.PAGE_LIMIT) int limit);
    //
    //    @Template("findUserListLimit")
    //    List<User> findUserList2(String name, @Param(type = ParamType.PAGE_OFFSET) int offset,
    //            @Param(type = ParamType.PAGE_LIMIT) int limit);
    //
    //    @Template("findMapListPage")
    //    List<Map<String, Object>> findMapList(Page page);
    //
    //    @Template("findMapListPage2")
    //    List<Map<String, Object>> findMapList2(String name, Page page);
    //
    //    @Template("findMapListLimit")
    //    List<Map<String, Object>> findMapList(@Param(type = ParamType.PAGE_OFFSET) int offset,
    //            @Param(type = ParamType.PAGE_LIMIT) int limit);
    //
    //    @Template("findMapListLimit")
    //    List<Map<String, Object>> findMapList2(String name, @Param(type = ParamType.PAGE_OFFSET) int offset,
    //            @Param(type = ParamType.PAGE_LIMIT) int limit);

    @Template("getGtAge")
    List<User> getGtAge(int age);

    //    int count();
    //
    //    User getByUsernameAndPassword(String username, String password);
    //
    //    User get(String username, String password, Integer age);

    //    <U extends User> List<U> findUser(String name);
}
