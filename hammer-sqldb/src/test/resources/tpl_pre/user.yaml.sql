selectByUsername: >
    select /*<<columns table='user'*/* from /*<<wrap*/user where username = :username
selectByUsername2: >
    select /*<<columns table='user'*/* from /*<<wrap*/user where username = :username    
selectByUsernameAndPassword: >
    select username, password pwd from /*<<wrap*/user where username = :username and password = :password
selectUser: select username, password pwd from /*<<wrap*/user
selectByAge: >
    select /*<<prop*/* from /*<<wrap*/user where age = :age
selectByAge2: >
    select /*<<prop*/* from /*<<wrap*/user where age = :age
selectConditions: |
    select id, username, password pwd, mobile_no, age from /*<<wrap*/user
    /*<where*/ where
    /*??*/ username like :username
    /*??*/ and password like :password
    /*??*/ and mobile_no like :mobileNo
    /*?*/ and age >= :minAge
    /*?*/ and age <= :maxAge
    /*>where*/
selectAvg: select avg(age) from /*<<wrap*/user
selectString: select username from /*<<wrap*/user where id = 1
selectAvg2: select avg(age) from /*<<wrap*/user where age > :age
selectString2: select username from /*<<wrap*/user where id = :id
selectById: select /*<<prop*/* from /*<<wrap*/user where id = :id
selectConditions2: |
    select /*<<prop alias='r'*/* from /*<<wrap*/user
    /*<where*/ where
    /*?*/ id = :id
    /*??*/ and name like :name
    /*?*/ and gender = :gender
    /*<?*/ and
    (
        /*??*/ username = :username
        /*??*/ or email = :email
        /*??*/ or mobile = :mobile
    )
    /*>?*/
    /*>where*/