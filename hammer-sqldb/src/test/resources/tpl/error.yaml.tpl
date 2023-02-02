wrapError: >
    select username, password pwd from ${tpl_wrap('user', 'user_info')}
wrapError2: >
    select username, password pwd from <@wrap value=true/>}
    
logicError: >
    select <@prop alias='r'>*</@prop> from <@wrap>user</@wrap> <@where>
    <@and if='username'>username like :username</@and>
    </@where>
logicError2: >
    select <@prop alias='r'>*</@prop> from <@wrap>user</@wrap> <@where>
    <@and if=true name=true>username like :username</@and>
    </@where>    
logicError3: >
    select <@prop alias='r'>*</@prop> from <@wrap>user</@wrap> <@where>
    <@and if=true name='username' transverter=true>username like :username</@and>
    </@where>
logicError4: >
    select <@prop alias='r'>*</@prop> from <@wrap>user</@wrap> <@where>
    <@and unknowParam=true>username like :username</@and>
    </@where>
    
includeError:
  query: "select * <@tpl />"
  count: "select count(*) <@sql />"  
includeError2:
  query: "select * <@tpl id=true/>"
  count: "select count(*) <@sql id=true/>"
includeError3:
  query: "select * <@tpl id='roleFromTemplate2' namespace=true/>"
  count: "select count(*) <@sql id='roleFromTemplate2' namespace=true/>"
  
propError:
  select <@prop alias=true>*</@prop> from ${tpl_wrap('user')}
propError2:
  select <@prop mapping=true/> from ${tpl_wrap('user')}
propError3:
  select <@prop mapping='cn.featherfly.hammer.sqldb.jdbc.vo.User1111'/> from ${tpl_wrap('user')}
propError4:
  select <@prop unknowParam=true/> from ${tpl_wrap('user')}
propError5:
  select <@prop repo=true/> from ${tpl_wrap('user')}
propError6:
  select <@prop /> from ${tpl_wrap('user')}