roleFromTemplate2: "FROM role <@where>
<@and if = name??>
    name like :name
</@and>
</@where>"