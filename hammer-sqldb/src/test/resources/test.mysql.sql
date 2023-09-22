drop database hammer_jdbc;
create database hammer_jdbc;
use hammer_jdbc;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
CREATE TABLE `role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `descp` varchar(36) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'n_init_1', 'descp_1', now());
INSERT INTO `role` VALUES ('2', 'n_init_2', 'descp_2', now());
INSERT INTO `role` VALUES ('3', 'n_init_3', 'descp_3', now());
INSERT INTO `role` VALUES ('4', 'n_init_4', 'descp_4', now());
INSERT INTO `role` VALUES ('5', 'n_init_5', 'descp_5', now());
INSERT INTO `role` VALUES ('6', 'n_init_11', 'descp_64', now());
INSERT INTO `role` VALUES ('7', 'name_init_98', 'descp_79', now());
INSERT INTO `role` VALUES ('8', 'name_init_21', 'descp_5', now());
INSERT INTO `role` VALUES ('9', 'name_init_96', 'descp_98', now());
INSERT INTO `role` VALUES ('10', 'n_96', 'descp_29', now());
INSERT INTO `role` VALUES ('11', 'n_42', 'descp_54', now());
INSERT INTO `role` VALUES ('12', 'n_12', 'descp_65', now());

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT ,
  `username` varchar(255) DEFAULT NULL ,
  `password` varchar(255) DEFAULT NULL ,
  `mobile_no` varchar(11) DEFAULT NULL ,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `USER_NAME_UQ` (`username`),
  UNIQUE KEY `MOBILE_NO_UQ` (`mobile_no`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'yufei', '123456', '12345678901', '5');
INSERT INTO `user` VALUES ('2', 'featherfly', '654321', '98765432101', '5');
INSERT INTO `user` VALUES ('3', 'yufei15', '123456', '15345678915', '15');
INSERT INTO `user` VALUES ('4', 'yufei25', '123456', '25345678925', '25');
INSERT INTO `user` VALUES ('5', 'yufei35', '123456', '35345678935', '35');
INSERT INTO `user` VALUES ('6', 'yufei45', '123456', '45345678945', '45');
INSERT INTO `user` VALUES ('7', 'yufei55', '123456', '55345678955', '55');
INSERT INTO `user` VALUES ('8', 'featherfly10', '654321', '10765432110', '10');
INSERT INTO `user` VALUES ('9', 'featherfly20', '654321', '20765432120', '20');
INSERT INTO `user` VALUES ('10', 'featherfly30', '654321', '30765432130', '30');
INSERT INTO `user` VALUES ('11', 'featherfly40', '654321', '40765432140', '40');
INSERT INTO `user` VALUES ('12', 'featherfly50', '654321', '50765432150', '50');
INSERT INTO `user` VALUES ('13', 'featherfly10-2', '654321', '10765432112', '10');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `user_id` int(10) unsigned NOT NULL,
  `role_id` int(10) unsigned NOT NULL,
  `descp` varchar(255) DEFAULT NULL,
  `descp2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '2', null,null);
INSERT INTO `user_role` VALUES ('2', '2', 'descp','descp2');
INSERT INTO `user_role` VALUES ('3', '3', 'descp401',null);
INSERT INTO `user_role` VALUES ('4', '4', 'descp446','descp2_update_37');
INSERT INTO `user_role` VALUES ('5', '5', 'descp866',null);
INSERT INTO `user_role` VALUES ('6', '6', 'descp848',null);
INSERT INTO `user_role` VALUES ('7', '7', 'descp489',null);
INSERT INTO `user_role` VALUES ('8', '8', 'descp581',null);


-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT ,
  `user_id` int(10) unsigned NULL,
  `name` varchar(255) DEFAULT NULL,
  `descp` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `street_no` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------

INSERT INTO `user_info` (`id`, `user_id`, `name`, `descp`, `province`, `city`, `district`, `street`, `street_no`) VALUES (1, 1, '羽飞', '羽飞描述', '四川', '成都', '金牛', '沙湾路', 66);
INSERT INTO `user_info` (`id`, `user_id`, `name`, `descp`, `province`, `city`, `district`, `street`, `street_no`) VALUES (2, 2, '翼', '翼描述', '广东', '深圳', '罗湖', '测试地址', 112);
INSERT INTO `user_info` (`id`, `user_id`, `name`, `descp`, `province`, `city`, `district`, `street`, `street_no`) VALUES (3, 3, '飞', '飞描述', '四川', '成都', '武侯', '天府三街', 88);
INSERT INTO `user_info` (`id`, `user_id`, `name`, `descp`, `province`, `city`, `district`, `street`, `street_no`) VALUES (4, 4, '张三', '张三描述', '四川', '成都', '武侯', '天府三街', 99);

DROP TABLE IF EXISTS `cms_article`;
CREATE TABLE `cms_article` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT ,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tree`;
CREATE TABLE `tree` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `tree`(`id`, `parent_id`, `name`) VALUES (1, NULL, 'node_1');
INSERT INTO `tree`(`id`, `parent_id`, `name`) VALUES (2, 1, 'node_21');
INSERT INTO `tree`(`id`, `parent_id`, `name`) VALUES (3, 1, 'node_22');
INSERT INTO `tree`(`id`, `parent_id`, `name`) VALUES (4, 2, 'node_211');
INSERT INTO `tree`(`id`, `parent_id`, `name`) VALUES (5, 2, 'node_212');
INSERT INTO `tree`(`id`, `parent_id`, `name`) VALUES (6, 5, 'node_2121');
INSERT INTO `tree`(`id`, `parent_id`, `name`) VALUES (7, 6, 'node_21211');

DROP TABLE IF EXISTS `cms_article2`;
CREATE TABLE `cms_article2` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID，由于此表数据不用上传，所以直接使用自动递增',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `content2` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `content3` json DEFAULT NULL,
  `content4` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;


DROP TABLE IF EXISTS `app`;
CREATE TABLE `app`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `descp` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `platform` tinyint(4) NULL DEFAULT NULL,
  `last_version` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `code_platform_unique`(`code`, `platform`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

INSERT INTO `app` VALUES (1, 'cn.featherfly.surveillance.camera', '监控摄像头', NULL, 101, 2);

DROP TABLE IF EXISTS `app_version`;
CREATE TABLE `app_version`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `app_id` bigint(20) NOT NULL,
  `platform` tinyint(4) NULL DEFAULT NULL,
  `version` bigint(20) NULL DEFAULT NULL,
  `version_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `descp` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `store_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `release_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4;

-- ----------------------------
-- Records of app_version
-- ----------------------------
INSERT INTO `app_version` VALUES (1, 1, 101, 1, '0.1.0', NULL, 'http://www.baidu.com', NULL, '2021-11-27 17:18:36');
INSERT INTO `app_version` VALUES (2, 1, 101, 2, '0.2.0', NULL, 'http://www.baidu.com', NULL, '2021-11-29 15:18:36');


DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
`id` int(0) NOT NULL AUTO_INCREMENT,
`no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '订单编号',
`app_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
`app_key` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
`wx_package` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
`wx_package_expire_time` datetime(0) NULL DEFAULT NULL,
`alipay_trade_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
`parent_id` int(10) unsigned NULL DEFAULT NULL,
`create_user` int(10) unsigned NULL DEFAULT NULL,
`update_user` int(10) unsigned NULL DEFAULT NULL,
`user1` int(10) unsigned NULL DEFAULT NULL,
`user2` int(10) unsigned NULL DEFAULT NULL,
`user3` int(10) unsigned NULL DEFAULT NULL,
`user_info` int(10) unsigned NULL DEFAULT NULL,
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB  CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

INSERT INTO `order` (`id`, `no`, `app_id`, `app_key`, `wx_package`, `wx_package_expire_time`, `alipay_trade_no`, `parent_id`, `create_user`, `update_user`, `user1`, `user2`, `user3`, `user_info`) 
    VALUES (1, 'no:1', 'app_id', 'app_key', 'wx_package', now(), 'alipay_trade_no', null, 1, 1, 1, 2, 3, 1);
INSERT INTO `order` (`id`, `no`, `app_id`, `app_key`, `wx_package`, `wx_package_expire_time`, `alipay_trade_no`, `parent_id`, `create_user`, `update_user`, `user1`, `user2`, `user3`, `user_info`) 
    VALUES (2, 'no:2', 'app_id', 'app_key', 'wx_package', now(), 'alipay_trade_no', 1, 2, 2, 1, 2, 3, 2);
INSERT INTO `order` (`id`, `no`, `app_id`, `app_key`, `wx_package`, `wx_package_expire_time`, `alipay_trade_no`, `parent_id`, `create_user`, `update_user`, `user1`, `user2`, `user3`, `user_info`) 
    VALUES (3, 'no:3', 'app_id', 'app_key', 'wx_package', now(), 'alipay_trade_no', 1, 2, 3, 4, 5, 6, 1);

DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info`  (
`id` int(0) NOT NULL AUTO_INCREMENT,
`descp` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '描述',
`order_id` int(10) unsigned NULL DEFAULT NULL,
`create_user` int(10) unsigned NULL DEFAULT NULL,
`update_user` int(10) unsigned NULL DEFAULT NULL,
`user1` int(10) unsigned NULL DEFAULT NULL,
`user2` int(10) unsigned NULL DEFAULT NULL,
`user3` int(10) unsigned NULL DEFAULT NULL,
`user_info` int(10) unsigned NULL DEFAULT NULL,
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB  CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

INSERT INTO `order_info` (`id`, `descp`, `order_id`, `create_user`, `update_user`,`user1`, `user2`, `user3`, `user_info`) 
    VALUES (1, 'descp1', 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `order_info` (`id`, `descp`, `order_id`, `create_user`, `update_user`,`user1`, `user2`, `user3`, `user_info`) 
    VALUES (2, 'descp2', 2, 2, 2, 2, 2, 2, 2);
INSERT INTO `order_info` (`id`, `descp`, `order_id`, `create_user`, `update_user`,`user1`, `user2`, `user3`, `user_info`) 
    VALUES (3, 'descp2', 3, 1, 2, 3, 4, 5, 6);

-- 存储过程
DROP PROCEDURE if EXISTS `call_query_user`;
CREATE DEFINER=`root`@`localhost` PROCEDURE `call_query_user`(IN `arg_username` varchar(255))
BEGIN
    select * from user where username like arg_username;
END; 

DROP PROCEDURE if EXISTS `call_query_user_by_id` ;
CREATE DEFINER=`root`@`localhost` PROCEDURE `call_query_user_by_id`(INOUT `arg_id` varchar(255))
BEGIN
    select * from user where id = arg_id;
    set arg_id = arg_id + 1;
END;

DROP PROCEDURE if EXISTS `call_update_user_one` ;
CREATE DEFINER=`root`@`localhost` PROCEDURE `call_update_user_one`(IN `arg_id` int(0), IN `arg_username` varchar(255), OUT `out_row_count` int(0))
BEGIN   
    update user set username = arg_username where id = arg_id;  
    set out_row_count = ROW_COUNT();
END;

DROP PROCEDURE if EXISTS `call_update_role_more` ;
CREATE DEFINER=`root`@`localhost` PROCEDURE `call_update_role_more`(IN `q_name` varchar(255), IN `u_descp` varchar(255), OUT `out_row_count` int(0))
BEGIN   
    update role set `descp` = u_descp where `name` like q_name;
    set out_row_count = ROW_COUNT();
END;

SET FOREIGN_KEY_CHECKS=0;