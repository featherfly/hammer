    select /*<<prop repo='user'*/* from /*<<wrap*/user
    /*<where*/ where
    /*?*/ id = :id
    /*??*/ age > :age
    /*<?*/ and
    (
        /*username??*/ username = :username
        /*??*/ or password = :password
        /*??*/ or mobile_no = :mobile
    )
    /*>?*/
    /*>where*/