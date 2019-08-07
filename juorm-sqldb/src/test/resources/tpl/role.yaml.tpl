selectByName: "select <@prop repo='role'/> from role
<@where>
    <@and if = name??>
        name like :name
    </@and>
</@where> 
"