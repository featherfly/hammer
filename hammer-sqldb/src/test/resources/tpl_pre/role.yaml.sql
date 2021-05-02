selectByName: |
    select /*prop*/* from role
    /*<where*/ where
    /*??*/ name like :name
    /*>where*/
    order by id
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

selectByNameCo2: |
    select /*prop*/* from role
    /*<where*/ where
    /*??*/ name like %:name%
    /*>where*/
selectByNameSw2: |
    select /*prop*/* from role
    /*<where*/ where
    /*??*/ name like :name%
    /*>where*/
selectByNameEw2: |
    select /*prop*/* from role
    /*<where*/ where
    /*??*/ name like %:name
    /*>where*/
    
selectByNameCo3: |
    select /*prop*/* from role
    /*<where*/ where
    /*name??*/ name like %:name%
    /*>where*/
selectByNameSw3: |
    select /*prop*/* from role
    /*<where*/ where
    /*name??*/ name like :name%
    /*>where*/
selectByNameEw3: |
    select /*prop*/* from role
    /*<where*/ where
    /*name??*/ name like %:name
    /*>where*/