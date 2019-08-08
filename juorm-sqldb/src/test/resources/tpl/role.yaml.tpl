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