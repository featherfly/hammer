select id, username, password pwd, mobile_no, age from /*<<wrap*/user
    /*<where*/ where
    /*??*/ username like :username
    /*??*/ and password like :password
    /*??*/ and mobile_no like :mobileNo
    /*?*/ and age >= :minAge
    /*?*/ and age <= :maxAge
    /*>where*/