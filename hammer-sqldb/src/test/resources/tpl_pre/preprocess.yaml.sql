selectConditions: |
    select id, username, password pwd, mobile_no, age from /*<<wrap*/user
    /*<where*/ where
    /*??*/ username like /*$=:username*/'admin'
    /*??*/ and password like /*$=:password*/'123456'
    /*??*/ and mobile_no like /*$=:mobileNo*/'123456'
    /*?*/ and age >= /*$=:minAge*/5
    /*??*/ and mobile_no <= /*$=:maxAge*/40
    /*>where*/