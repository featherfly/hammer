select /*prop*/* from role
/*<where*/ where
/*??*/ name like /*$=:name*/me\\_
/*??*/ or name like /*$=%:name1%*/me\\_
/*??*/ or name like /*$=:name2%*/me\\_
/*??*/ or name like /*$=%:name3*/me\\_
/*>where*/

select /*prop*/* from role
/*<where*/ where
/*name??*/ name like /*$=:name*/me\\_
/*name1??*/ or name like /*$=%:name1%*/me\\_
/*name2??*/ or name like /*$=:name2%*/me\\_
/*name3??*/ or name like /*$=%:name3*/me\\_
/*>where*/