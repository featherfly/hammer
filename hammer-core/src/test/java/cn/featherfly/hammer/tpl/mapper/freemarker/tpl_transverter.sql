select /*prop*/* from role
/*<where*/ where
/*??*/ name like /*$=:name*/me\\_
/*??*/ or name like /*$=%:name1%*/me\\_
/*??*/ or name like /*$=:name2%*/me\\_
/*??*/ or name like /*$=%:name3*/me\\_
/*>where*/