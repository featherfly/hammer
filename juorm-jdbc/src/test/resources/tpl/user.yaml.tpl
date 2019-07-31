selectByUsername: "select 
<@columns table='user'/> from user where username = :username"
selectByUsernameAndPassword: "select username, password pwd from user where username = :username and password = :password"
selectUser: "select username, password pwd from user"
selectByAge: "select <@prop repo='user'/> from user where age = :age"
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
</@where>
"