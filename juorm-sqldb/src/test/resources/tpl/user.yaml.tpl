selectByUsername: >
    select <@columns table='user'/> from <@wrap value='user'/> where username = :username    
selectByUsername2: >
    select <@columns table='user'/> from ${tpl_wrap("user")}  where username = :username    
selectByUsernameAndPassword: >
    select username, password pwd from <@wrap value="user"/> where username = :username and password = :password
selectUser: select username, password pwd from user
selectByAge: "select <@prop/> from user where age = :age"
selectByAge2: >
    select <@prop/> from user where age = :age
selectConditions: "select id, username, password pwd, mobile_no, age from user<@where>
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
selectAvg: "select avg(age) from user"
selectString: "select username from user where id = 1"
selectAvg2: "select avg(age) from user where age > :age"
selectString2: "select username from user where id = :id"
selectById: "select <@prop/> from user where id = :id"