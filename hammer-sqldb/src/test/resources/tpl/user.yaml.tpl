selectByUsername: >
    select <@columns table='user'/> from <@wrap value='user'/> where username = :username    
selectByUsername2: >
    select <@columns table='user' alias='u'/> from ${tpl_wrap('user')} u where u.username = :username    
selectByUsernameAndPassword: >
    select username, password pwd from <@wrap value='user'/> where username = :username and password = :password
selectUser: select username, password pwd from ${tpl_wrap('user')}
selectUserList: >
    select <@prop mapping='cn.featherfly.hammer.sqldb.jdbc.vo.r.User'/> from ${tpl_wrap('user')}
selectByAge: "select <@prop/> from ${tpl_wrap('user')} where age = :age"
selectByAge2: >
    select <@prop/> from ${tpl_wrap('user')} where age = :age
selectConditions: "select id, username, password pwd, mobile_no, age from ${tpl_wrap('user')}<@where>
<@and if=username??>
    username like :username
</@and>
<@and if=password??>
    password like :password
</@and>
<@and if=mobileNo??>
    mobile_no like :mobileNo
</@and>
<@and if=minAge??>
    age >= :minAge
</@and>
<@and if=maxAge??>
    age <= :maxAge
</@and>
</@where>"
selectAvg: "select avg(age) from ${tpl_wrap('user')}"
selectSum: "select sum(age) from ${tpl_wrap('user')}"
selectCount: "select count(id) from ${tpl_wrap('user')}"
selectString: "select username from ${tpl_wrap('user')} where id = 1"
selectAvg2: "select avg(age) from ${tpl_wrap('user')} where age > :age"
selectSum2: "select sum(age) from ${tpl_wrap('user')} where age > :age"
selectString2: "select username from ${tpl_wrap('user')} where id = :id"
selectById: "select <@prop/> from ${tpl_wrap('user')} where id = :id"
selectById2: "select <@prop repo='user'/> from ${tpl_wrap('user')} where id = :id"
selectIntList: "select id from ${tpl_wrap('user')} where id < 5"
selectIntList2: "select id from ${tpl_wrap('user')} where id < :id"
selectListOrderByAge: "select age from ${tpl_wrap('user')} order by age ${sortable}"
selectListOrderByAge2: "select age from ${tpl_wrap('user')} order by age ${tpl_str(sortable)}"
selectListOrderByAge3: "select age from ${tpl_wrap('user')} order by age <@str value=sortable></@str>"
selectListOrderByAge4: "select age from ${tpl_wrap('user')} order by age <@str>${sortable}</@str>"
selectConditions2: >
    select <@prop repo='user'>*</@prop> from <@wrap>user</@wrap>
    <@where>
    <@and if=id??>id = :id</@and>
    <@and if=age??>age > :age</@and>
    <@and>
    (
        <@and if=username??>username = :username</@and>
        <@or if=password??>password = :password</@or>
        <@or if=mobile??>mobile_no = :mobile</@or>
    )
    </@and>
    </@where>
selectIn: >
    select <@columns table='user'/> from <@wrap value='user'/> 
    <@where> 
        <@and if=ids??> id in :ids </@and>
    </@where>   
selectInCount: >
    select count(*) from <@wrap value='user'/> 
    <@where> 
        <@and if=ids??> id in :ids </@and>
    </@where> 
selectInSingle: >
    select <@columns table='user'/> from <@wrap value='user'/> 
    <@where> 
        <@and if=ids??> id in :ids </@and>
    </@where>
selectIn2: >
    select <@columns table='user'/> from <@wrap value='user'/> 
    where 
        id in :ids
selectIn3:
  inParamIndexs: [0]
  paramsFormat: INDEX
  query: >
    select <@columns table='user'/> from <@wrap value='user'/> 
      where 
      id in ${_argu0}
selectIn3_2:
  inParamIndexs: 0
  paramsFormat: INDEX
  query: >
    select <@columns table='user'/> from <@wrap value='user'/> 
      where 
      id in ${_argu0}
selectIn3_3:
  inParamIndexs: 0
  paramsFormat: INDEX
  query: >
    select <@columns table='user'/> from <@wrap value='user'/> 
      where 
      id in ${_argu0}
      and age > ?
selectIn3_4:
  inParamIndexs: 0
  paramsFormat: INDEX
  query: >
    select <@columns table='user'/> from <@wrap value='user'/> 
      where 
      id in ${_argu0}
      <@and if=argu1??> age > ?</@and>
selectIn3_4:
  inParamIndexs: 0
  paramsFormat: INDEX
  query: >
    select <@columns table='user'/> from <@wrap value='user'/> 
      <@where>
      id in ${_argu0}
      <@and if=argu1?? force=true> age > ?</@and>
      </@where>