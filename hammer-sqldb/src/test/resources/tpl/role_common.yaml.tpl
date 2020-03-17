roleFromTemplate2: "FROM role _r <@where>
<@and if = name??>
    name like :name
</@and>
</@where>"