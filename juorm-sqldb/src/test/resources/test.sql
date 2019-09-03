create database juorm_jdbc;

CREATE TABLE `juorm_jdbc`.`user` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID，由于此表数据不用上传，所以直接使用自动递增',
  `USERNAME` varchar(255) DEFAULT NULL COMMENT '用户名，登陆系统用，单一数据库保证唯一',
  `PASSWORD` varchar(255) DEFAULT NULL COMMENT '密码，保存加密后的密码',
  `MOBILE_NO` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `AGE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `USER_NAME_UQ` (`USERNAME`),
  UNIQUE KEY `MOBILE_NO_UQ` (`MOBILE_NO`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统用户';



CREATE TABLE `juorm_jdbc`.`role` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID，由于此表数据不用上传，所以直接使用自动递增',
  `NAME` varchar(20) DEFAULT NULL,
  `DESCP` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户';

CREATE TABLE `juorm_jdbc`.`user_role` (
  `user_id` int(10) unsigned NOT NULL,
  `role_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户';