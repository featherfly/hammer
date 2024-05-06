
package cn.featherfly.hammer.sqldb.tpl;

import java.util.List;

import cn.featherfly.hammer.GenericHammer;
import cn.featherfly.hammer.annotation.Mapper;
import cn.featherfly.hammer.annotation.Param;
import cn.featherfly.hammer.annotation.Template;
import cn.featherfly.hammer.sqldb.jdbc.vo.r.Role;

/**
 * RoleMapperDefineTemplates.
 *
 * @author zhongj
 */
@Mapper(namespace = "role2")
@Template(name = "selectIdList", value = "select id from role order by id")
@Template(name = "selectList", value = "select <@prop repo='role'/> from role")
@Template(name = "roleFromTemplate", value = "FROM role _r <@where><@and if = name??> name like :name </@and></@where>")
@Template(name = "selectWithTemplate", value = "select <@prop alias=\"_r\"/> <@tpl id='roleFromTemplate'/>")
@Template(name = "selectWithTemplate2",
        value = "select <@prop alias='_r'/> <@tpl id='roleFromTemplate' namespace='role2'/>")
@Template(name = "selectWithTemplate3", value = "select /*<<prop alias=\"_r\"*/* /*<tpl id='roleFromTemplate' >*/")
@Template(name = "selectWithTemplate4",
        value = "select /*<<prop alias='_r'*/* /*<tpl id='roleFromTemplate' namespace='role2' >*/")
@Template(name = "selectWithTemplate5", value = "select /*prop alias=\"_r\"*/* /*<tpl id='roleFromTemplate' >*/")
public interface RoleMapperDefineTemplates extends GenericHammer<Role, Integer> {

    @Template(name = "selectIdList")
    List<Long> idList();

    @Template(name = "selectList")
    List<Role> list();

    @Template(name = "selectWithTemplate")
    List<Role> selectWithTemplate(@Param("name") String name);

    @Template // name="selectWithTemplate2"
    List<Role> selectWithTemplate2(@Param("name") String name);

    @Template // name="selectWithTemplate3"
    List<Role> selectWithTemplate3(@Param("name") String name);

    @Template // name="selectWithTemplate4"
    List<Role> selectWithTemplate4(@Param("name") String name);

    @Template // name="selectWithTemplate5"
    List<Role> selectWithTemplate5(@Param("name") String name);

    @Template("select <@prop alias=\"_r\"/> <@tpl id='roleFromTemplate' />")
    List<Role> selectWithTemplate6(@Param("name") String name);

    @Template("select <@prop alias='_r'/> <@tpl id='roleFromTemplate' namespace='role2' />")
    List<Role> selectWithTemplate7(@Param("name") String name);

    @Template("select /*<<prop alias=\"_r\"*/* /*<tpl id='roleFromTemplate' >*/")
    List<Role> selectWithTemplate8(@Param("name") String name);

    @Template("select /*<<prop alias='_r'*/* /*<tpl id='roleFromTemplate' namespace='role2' >*/")
    List<Role> selectWithTemplate9(@Param("name") String name);

    @Template("select /*prop alias=\"_r\"*/* /*<tpl id='roleFromTemplate' >*/")
    List<Role> selectWithTemplate10(@Param("name") String name);
}
