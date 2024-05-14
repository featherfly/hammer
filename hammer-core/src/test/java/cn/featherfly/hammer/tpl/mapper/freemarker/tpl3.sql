select o.*,s.code,g.name from trade_order o
    LEFT JOIN shelf s on s.id = o.shelf_id
    LEFT JOIN organization g on g.id = o.organization_id
/*<where*/ where
    /*?*/o.shelf_id = /*$=:shelfId*/1
    /*??*/and o.create_time like /*$=:time*/'2021%'
    /*??*/and o.status = /*$=:status*/1
    /*??*/and o.process_goods_status = /*$=:processGoodsStatus*/1
/*>where*/
order by o.create_time desc