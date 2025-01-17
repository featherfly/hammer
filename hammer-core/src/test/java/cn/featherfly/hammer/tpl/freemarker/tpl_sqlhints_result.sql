/*+ this is sql hints */select id, username, password pwd, mobile_no, age from <@wrap>user</@wrap>
    <@where> /*+ this is sql hints2 */
    <@and if=username?? && username?length gt 0 name="username"> username like :username</@and>
    <@and if=password?? && password?length gt 0 name="password">password like :password</@and>
    <@and if=mobileNo?? && mobileNo?length gt 0 name="mobileNo">mobile_no like :mobileNo</@and>
    <@and if=minAge?? name="minAge">age >= :minAge</@and>
    <@and if=maxAge?? name="maxAge">age <= :maxAge</@and>
    </@where>
    /*+ this is sql hints3 */
    /* this is sql comment */
    /* 
        this is sql comment2
     */