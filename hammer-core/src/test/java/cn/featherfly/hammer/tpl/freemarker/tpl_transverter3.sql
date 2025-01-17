select /*prop*/* from role
/*<where*/ where
/*name??*/ name like :name
/*name1??*/ or name like %:name1%
/*name2??*/ or name like :name2%
/*name3??*/ or name like %:name3
/*>where*/

select /*prop*/* from role
/*<where*/ where
/*name??*/ name like ?
/*name1??*/ or name like %?%
/*name2??*/ or name like ?%
/*name3??*/ or name like %?
/*>where*/