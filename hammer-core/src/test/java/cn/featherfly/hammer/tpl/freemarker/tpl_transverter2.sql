select /*prop*/* from role
/*<where*/ where
/*??*/ name like :name
/*??*/ or name like %:name1%
/*??*/ or name like :name2%
/*??*/ or name like %:name3
/*>where*/