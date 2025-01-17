select id, username, password pwd, mobile_no, age from <@wrap>user</@wrap>
<@where>
<@and if=minAge?? name="minAge"> age >= :minAge</@and>
<@and if=maxAge?? name="maxAge">age < :maxAge</@and>
</@where>
UNION ALL 
select id, username, password pwd, mobile_no, age from <@wrap>user</@wrap>
<@where>
<@and if=minAge2?? name="minAge2"> age >= :minAge2</@and>
<@and if=maxAge2?? name="maxAge2">age < :maxAge2</@and>
</@where>