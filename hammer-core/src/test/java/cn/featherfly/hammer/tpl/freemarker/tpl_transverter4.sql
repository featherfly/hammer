select /*prop*/* from role
/*<where*/ where
/*birthday??*/ DATE_FORMAT(birthday,'%Y-%M-%D') = ?
/*birthday??*/ or DATE_FORMAT(birthday,"%Y-%M-%D") = ?
/*name??*/ or name like ?
/*name1??*/ or name like %:name1%
/*name2??*/ or name like :name2%
/*name3??*/ or name like %:name3
/*>where*/