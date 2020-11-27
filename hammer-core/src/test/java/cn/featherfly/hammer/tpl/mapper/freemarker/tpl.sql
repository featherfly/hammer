select /*<<prop*/* from /*<<wrap*/user
/*<where*/ where
    /*id?*/id = /*$=:id*/1
    /*name??*/and name like /*$=:name*/'name'
    /*gender??*/ and gender in /*$=:gender*/1
    /*<?*/ and
    (
        /*??*/ username = /*$=:username*/'admin'
        /*??*/ or email = /*$=:email*/'featherfly@foxmail.com'
        /*??*/ or mobile = /*$=:mobile*/13212345678
    )
    /*>?*/
/*>where*/
/*<sql id='roleFromTemplate'>*/