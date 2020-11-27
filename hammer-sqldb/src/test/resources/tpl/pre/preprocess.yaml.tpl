selectConditions: >
    select id, username, password pwd, mobile_no, age from /*<<wrap*/user
    /*<where*/ where
    /*??*/ username like /*$=:username*/'admin'
    /*??*/ and password like /*$=:password*/'123456'
    /*??*/ and mobile_no like /*$=:mobileNo*/'123456'
    /*??*/ and age >= /*$=:minAge*/5
    /*??*/ and mobile_no <= /*$=:maxAge*/40
    /*>where*/
selectConditions2: >
    select /*<<prop alias='r'*/* from /*<<wrap*/user
    /*<where*/ where
        /*id??*/id = /*$=:id*/1
        /*name??*/and name like /*$=:name*/'name'
        /*gender??*/ and gender = /*$=:gender*/1
        /*<?*/ and
        (
            /*??*/ username = /*$=:username*/'admin'
            /*??*/ or email = /*$=:email*/'featherfly@foxmail.com'
            /*??*/ or mobile = /*$=:mobile*/13212345678
        )
        /*>?*/
    /*>where*/