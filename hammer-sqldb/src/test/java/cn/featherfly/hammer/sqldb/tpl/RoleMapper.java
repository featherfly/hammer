
package cn.featherfly.hammer.sqldb.tpl;

import java.util.List;

import cn.featherfly.common.structure.page.Page;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.GenericHammer;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Role;
import cn.featherfly.hammer.tpl.TplType;
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
@Mapper(namespace = "role")
public interface RoleMapper extends GenericHammer<Role, Integer> {

    @Template("select id from role order by id")
    List<Long> idList();

    @Template("select <@prop repo='role'/> from role")
    List<Role> list();

    @Template("select <@prop repo='role'/> from role")
    List<Role> list(Page page);

    @Template("select <@prop repo='role'/> from role")
    List<Role> list(@Param(type = ParamType.PAGE_OFFSET) int offset, @Param(type = ParamType.PAGE_LIMIT) int limit);

    @Template("select <@prop repo='role'/> from role")
    PaginationResults<Role> page(Page page);

    @Template("select <@prop repo='role'/> from role")
    PaginationResults<Role> page(@Param(type = ParamType.PAGE_OFFSET) int offset,
            @Param(type = ParamType.PAGE_LIMIT) int limit);

    @Template("select <@prop repo='role'/> from role <@where><@and if = name??>name like :name</@and></@where>")
    List<Role> selectByName2(@Param("name") String name);

    @Template("select <@prop repo='role'/> from role <@where><@and if = name??>name like ?</@and></@where>")
    List<Role> selectByName3(@Param("name") String name);

    @Template
    List<Role> selectByName(@Param("name") String name);

    @Template
    List<Role> selectByNameCo(@Param("name") String name);

    @Template
    List<Role> selectByNameSw(@Param("name") String name);

    @Template
    List<Role> selectByNameEw(@Param("name") String name);

    @Template
    List<Role> selectByNameCo2(@Param("name") String name);

    @Template
    List<Role> selectByNameSw2(@Param("name") String name);

    @Template
    List<Role> selectByNameEw2(@Param("name") String name);

    @Template
    List<Role> selectByNameCo3(@Param("name") String name);

    @Template
    List<Role> selectByNameSw3(@Param("name") String name);

    @Template
    List<Role> selectByNameEw3(@Param("name") String name);

    @Template
    List<Role> selectByNameCo4(@Param("name") String name);

    @Template("select <@prop alias=\"_r\"/> <@tpl id='roleFromTemplate2' namespace='role_common'/>")
    List<Role> selectWithTemplate(@Param("name") String name);

    @Template("insert into role(name, descp) values(:name, :descp)")
    int insertRole(@Param("name") String name, @Param("descp") String descp);

    @Template("update role set descp = :descp where name = :name")
    int updateRoleByName(@Param("name") String name, @Param("descp") String descp);

    @Template("delete from role where name = :name")
    int deleteRoleByName(@Param("name") String name);

    @Template("select <@prop repo='role'/> from role where name = :name")
    Role getByName(@Param("name") String name);

    @Template(value = "select count(*) from role", type = TplType.QUERY)
    int countRole();

    @Template("select count(*) from role")
    Integer countRole2();

    @Template("select count(*) from role")
    long countRole3();
}
