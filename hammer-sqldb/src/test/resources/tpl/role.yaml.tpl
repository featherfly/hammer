selectByName: "select <@prop repo='role'/> from role
<@where>
    <@and if = name??>
        name like :name
    </@and>
</@where>"
selectByNameCo: >
    select <@prop repo='role'/> from role
    <@where>
        <@and if = name?? transverter="CO">
            name like :name
        </@and>
    </@where>
selectByNameSw: "select <@prop repo='role'/> from role
<@where>
    <@and if = name?? transverter='SW'>
        name like :name
    </@and>
</@where>"
selectByNameEw: "select <@prop repo='role'/> from role
<@where>
    <@and if = name?? transverter='EW'>
        name like :name
    </@and>
</@where>"
selectWithTemplate:
  query: "select <@prop/> <#include 'role@roleFromTemplate'>"
  count: "select count(*) <#include 'role@roleFromTemplate'>"
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
    select <@prop alias="_r"/> <@tpl id='roleFromTemplate2' namespace='role_common'/>
  count: "select count(*) <@sql id='roleFromTemplate2' namespace='role_common'/>"
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
selectByName_mysql: >
    select <@prop repo='role'/>, DATE_FORMAT(create_time,:dateFormat) as dateFormat from role
    <@where>
    <@and if = name??>
        name like :name
    </@and>
    </@where>