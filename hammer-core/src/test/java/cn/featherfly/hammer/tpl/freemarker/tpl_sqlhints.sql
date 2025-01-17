/*+ this is sql hints */select id, username, password pwd, mobile_no, age from /*<<wrap*/user
    /*<where*/ where /*+ this is sql hints2 */
    /*??*/ username like :username
    /*??*/ and password like :password
    /*??*/ and mobile_no like :mobileNo
    /*?*/ and age >= :minAge
    /*?*/ and age <= :maxAge
    /*>where*/
    /*+ this is sql hints3 */
    /* this is sql comment */
    /* 
        this is sql comment2
     */