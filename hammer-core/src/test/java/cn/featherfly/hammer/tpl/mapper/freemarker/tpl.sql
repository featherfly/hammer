select id, username, password pwd, mobile_no, age from /*<<wrap*/user
    /*<where*/ where
    /*username??*/ username like /*$=:name*/'name'
    /*password??*/ and password like /*$=%:password%*/'123'
    /*??*/ and mobile_no like /*$=%:mobileNo*/'132'
    /*??*/ and mobile_no like /*$=:mobileNo%*/'132'
    /*??*/ and mobile_no like /*$=%:mobileNo%*/'132'
    
    /*?*/ and age >= :minAge
    /*?*/ and age <= :maxAge
    /*>where*/