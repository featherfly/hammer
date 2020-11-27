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