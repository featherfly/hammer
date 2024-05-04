SELECT
    _user0.`id` `_user0.id`,
    _user0.`username` `_user0.username`,
    _user0.`password` `_user0.pwd`,
    _user0.`mobile_no` `_user0.mobileNo`,
    _user0.`age` `_user0.age`,
    ui.`province` `ui.division.province`,
    ui.`city` `ui.division.city`,
    ui.`district` `ui.division.district`,
    ui.`id` `ui.id`,
    ui.`user_id` `ui.user.id`,
    ui.`name` `ui.name`,
    ui.`descp` `ui.descp`,
    ur.`user_id` `ur.userId`,
    ur.`role_id` `ur.roleId`,
    ur.`descp` `ur.descp`,
    ur.`descp2` `ur.descp2`,
    r.`id` `r.id`,
    r.`name` `r.name`,
    r.`descp` `r.descp`,
    r.`create_time` `r.createTime`,
    o.`id` `o.id`,
    o.`app_id` `o.appId`,
    o.`create_user` `o.createUser.id`
FROM
    `user` _user0 
    JOIN `user_info` ui ON _user0.id = ui.user_id 
    JOIN `user_role` ur ON _user0.id = ur.user_id
    JOIN `role` r ON ur.role_id = r.id
    JOIN `order` o ON _user0.id = o.create_user
where
    _user0.`id` > ?