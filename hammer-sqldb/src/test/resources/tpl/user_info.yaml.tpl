select: "select <@prop/> from user_info"

select2: "select id,user_id as ${tpl_wrap('user.id')}, name, descp
, province ${tpl_wrap('division.province')}, city ${tpl_wrap('division.city')}, district ${tpl_wrap('division.district')}
 from user_info"
 
selectById: "select <@prop repo='user_info'/> from user_info where id = :id"

selectUserInfoByUserId: >
    select <@prop alias="ui"/>,<@prop alias="u"/> 
    from user_info ui 
    join user u on 
    ui.user_id = u.id 
    where u.id = :userId
    
selectUserInfoAndUserList: >
    select <@prop alias="ui"/>,<@prop alias="u"/> 
    from user_info ui 
    join user u on 
    ui.user_id = u.id  