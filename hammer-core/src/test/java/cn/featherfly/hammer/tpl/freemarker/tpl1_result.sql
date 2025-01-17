select id, username, password pwd, mobile_no, age from <@wrap>user</@wrap>
    <@where>
    <@and if=username?? && username?length gt 0 name="username"> username like :name</@and>
    <@and if=password?? && password?length gt 0 transverter='CO' name="password">password like :password</@and>
    <@and if=mobileNo?? && mobileNo?length gt 0 transverter='EW' name="mobileNo">mobile_no like :mobileNo</@and>
    <@and if=mobileNo?? && mobileNo?length gt 0 transverter='SW' name="mobileNo">mobile_no like :mobileNo</@and>
    <@and if=mobileNo?? && mobileNo?length gt 0 transverter='CO' name="mobileNo">mobile_no like :mobileNo</@and>
    
    <@and if=minAge?? name="minAge">age >= :minAge</@and>
    <@and if=maxAge?? name="maxAge">age <= :maxAge</@and>
    </@where>