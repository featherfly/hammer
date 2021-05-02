selectByName: |
    select /*prop*/* from role
    /*<where*/ where
    /*??*/ name like :name
    /*>where*/
selectByNameCo: |
    select /*prop*/* from role
    /*<where*/ where
    /*??*/ name like /*$=%:name%*/me\\_
    /*>where*/
selectByNameSw: |
    select /*prop*/* from role
    /*<where*/ where
    /*??*/ name like /*$=:name%*/me\\_
    /*>where*/
selectByNameEw: |
    select /*prop*/* from role
    /*<where*/ where
    /*??*/ name like /*$=%:name*/me\\_
    /*>where*/