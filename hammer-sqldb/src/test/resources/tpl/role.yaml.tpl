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
  query: "select <@prop/> <#include 'roleFromTemplate@role'>"
  count: "select count(*) <#include 'roleFromTemplate@role'>"
roleFromTemplate: "from role <@where>
<@and if = name??>
    name like :name
</@and>
</@where>"
selectWithTemplate2:
  query: "select <@prop/> <@tpl name='roleFromTemplate2'/>"
  count: "select count(*) <@sql name='roleFromTemplate2'/>"
roleFromTemplate2: "from role <@where>
<@and if = name??>
    name like :name
</@and>
</@where>"
selectWithTemplate3:
  query: >
    select <@prop alias="_r"/> <@tpl name='roleFromTemplate2' namespace='role_common'/>
  count: "select count(*) <@sql name='roleFromTemplate2' namespace='role_common'/>"
selectWithTemplate4:
  query: "select * <@tpl name='roleFromTemplate4'/>"
  count: "select count(*) <@sql name='roleFromTemplate4'/>"
roleFromTemplate4: "from role <@where>
<@and if = name??>
    name like :name
</@and>
</@where>"
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
countUserInfo: >
  select count(*) from user_info
selectByName_mysql: >
    select <@prop repo='role'/>, DATE_FORMAT(create_time,:dateFormat) as dateFormat from role
    <@where>
    <@and if = name??>
        name like :name
    </@and>
    </@where>