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
    ui.`descp` `ui.descp`
FROM
    `user` _user0 
    JOIN `user_info` ui ON _user0.id = ui.user_id
where
    _user0.`id` = ?