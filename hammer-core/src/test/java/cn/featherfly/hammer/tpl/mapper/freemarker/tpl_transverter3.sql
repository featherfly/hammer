select /*prop*/* from role
/*<where*/ where
/*name??*/ name like ?
/*name1??*/ or name like %?%
/*name2??*/ or name like ?%
/*name3??*/ or name like %?
/*>where*/