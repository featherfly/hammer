selectConditions: |
    select id, username, password pwd, mobile_no, age from /*<<wrap*/user
    /*<where*/ where
    /*??*/ username like /*$=:username*/'yufei'
    /*??*/ and password like /*$=:password*/'123456'
    /*??*/ and mobile_no like /*$=:mobileNo*/'12345678901'
    /*?*/ and age >= /*$=:minAge*/5
    /*??*/ and age <= /*$=:maxAge*/40
    /*>where*/
    
selectConditions2: |
    select id, username, password pwd, mobile_no, age /*<tpl name='userFromTemplate'>*/
    
userFromTemplate: |
    from /*<<wrap*/user
    /*<where*/ where
    /*??*/ username like /*$=:username*/'yufei'
    /*??*/ and password like /*$=:password*/'123456'
    /*??*/ and mobile_no like /*$=:mobileNo*/'12345678901'
    /*?*/ and age >= /*$=:minAge*/5
    /*??*/ and age <= /*$=:maxAge*/40
    /*>where*/