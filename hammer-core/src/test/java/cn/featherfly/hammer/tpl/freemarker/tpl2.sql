select /*<<prop alias='r'*/* from /*<<wrap*/user
/*<where*/ where
    /*?*/id = /*$=:id*/1
    /*??*/and name like /*$=:name*/'name'
    /*?*/ and gender = /*$=:gender*/1
    /*??*/ and tag in /*$=:tag*/(1,2,3)
    /*<?*/ and
    (
        /*username??*/ username = /*$=:username*/'admin'
        /*email??*/ or email = /*$=:email*/'featherfly@foxmail.com'
        /*mobile??*/ or mobile = /*$=:mobile*/13212345678
    )
    /*>?*/
/*>where*/