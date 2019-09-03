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
  query: "select <@prop/> <@tpl id='roleFromTemplate2' file='tpl/role_common'/>"
  count: "select count(*) <@sql id='roleFromTemplate2' file='tpl/role_common'/>"