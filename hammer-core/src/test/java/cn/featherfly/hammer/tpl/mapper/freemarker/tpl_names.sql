select id, username, password pwd, mobile_no, age from /*<<wrap*/user
    /*<where*/ where
    /*username??*/ username like /*$=:username*/'name'
    /*password??*/ and password like /*$=%:password%*/'123'
    /*??*/ and mobile_no like /*$=%:mobileNo*/'132'
    /*??*/ and mobile_no like /*$=:mobileNo%*/'132'
    /*??*/ and mobile_no like /*$=%:mobileNo%*/'132'
    /*??*/ and id in /*$=%:ids%*/(1,2)
    and age >= :minAge
    and age <= :maxAge
    and id in :ids2
    and DATE_FORMAT(birthday,"%Y-%M-%D %H:%i:%S") = :birthday
    /*>where*/
    and id in :ids3
    and gender = :gender
    and DATE_FORMAT(birthday,"%H:%i:%S") = :birthday
    /*?? force=true*/ and email like :email
    /*?? force=true*/ and mobile like :mobile
    /*?? force=true*/ and id in :ids4
