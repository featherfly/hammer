mulitiWhere: |
    select id, username, password pwd, mobile_no, age from /*<<wrap*/user
    /*<where*/ where
    /*?*/ age >= :minAge
    /*?*/ and age < :maxAge
    /*>where*/
    UNION ALL 
    select id, username, password pwd, mobile_no, age from /*<<wrap*/user
    /*<where*/ where
    /*?*/ age >= :minAge2
    /*?*/ and age < :maxAge2
    /*>where*/