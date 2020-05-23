selectByName: "select <@prop repo='role'/> from role
<@where>
    <@and if = name??>
        name like :name
    </@and>
</@where>"
selectWithTemplate:
  query: "select <@prop/> <#include '/tpl/role@roleFromTemplate'>"
  count: "select count(*) <#include '/tpl/role@roleFromTemplate'>"
roleFromTemplate: "from role <@where>
<@and if = name??>
    name like :name
</@and>
</@where>"
selectWithTemplate2:
  query: "select <@prop/> <@tpl id='roleFromTemplate2'/>"
  count: "select count(*) <@sql id='roleFromTemplate2'/>"
roleFromTemplate2: "from role <@where>
<@and if = name??>
    name like :name
</@and>
</@where>"
selectWithTemplate3:
  query: >
    select <@prop alias="_r"/> <@tpl id='roleFromTemplate2' namespace='tpl/role_common'/>
  count: "select count(*) <@sql id='roleFromTemplate2' namespace='tpl/role_common'/>"
insertRole: >
  insert into role(name, descp) values(:name, :descp)
updateRoleByName: >
  update role set descp = :descp where name = :name
deleteRoleByName: >
  delete from role where name = :name
getByName: >
  select <@prop repo='role'/> from role where name = :name
countRole: >
  select count(*) from role