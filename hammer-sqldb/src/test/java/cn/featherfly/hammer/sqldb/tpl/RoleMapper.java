
package cn.featherfly.hammer.sqldb.tpl;

import java.util.List;

import cn.featherfly.common.structure.page.Page;
import cn.featherfly.common.structure.page.PaginationResults;
import cn.featherfly.hammer.sqldb.jdbc.vo.Role;
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
public interface RoleMapper {

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

    @Template("select <@prop alias=\"_r\"/> <@tpl id='roleFromTemplate2' file='tpl/role_common'/>")
    List<Role> selectWithTemplate(@Param("name") String name);
}
