DROP TABLE IF EXISTS `role`;
CREATE TABLE "role" (
  "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  "name" text(20),
  "descp" TEXT(36),
  "create_time" INTEGER
);

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'n_init_1', 'descp_1', strftime('%s','now'));
INSERT INTO `role` VALUES ('2', 'n_init_2', 'descp_2', strftime('%s','now'));
INSERT INTO `role` VALUES ('3', 'n_init_3', 'descp_3', strftime('%s','now'));
INSERT INTO `role` VALUES ('4', 'n_init_4', 'descp_4', strftime('%s','now'));
INSERT INTO `role` VALUES ('5', 'n_init_5', 'descp_5', strftime('%s','now'));
INSERT INTO `role` VALUES ('6', 'n_init_11', 'descp_64', strftime('%s','now'));
INSERT INTO `role` VALUES ('7', 'name_init_98', 'descp_79', strftime('%s','now'));
INSERT INTO `role` VALUES ('8', 'name_init_21', 'descp_5', strftime('%s','now'));
INSERT INTO `role` VALUES ('9', 'name_init_96', 'descp_98', strftime('%s','now'));
INSERT INTO `role` VALUES ('10', 'n_96', 'descp_29', strftime('%s','now'));
INSERT INTO `role` VALUES ('11', 'n_42', 'descp_54', strftime('%s','now'));
INSERT INTO `role` VALUES ('12', 'n_12', 'descp_65', strftime('%s','now'));

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  `username` text(255) DEFAULT NULL,
  `password` text(255) DEFAULT NULL,
  `mobile_no` text(11) DEFAULT NULL,
  `age` INTEGER DEFAULT NULL,
  UNIQUE ("USERNAME"),
  UNIQUE ("MOBILE_NO")
);

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
  `user_id` INTEGER NOT NULL,
  `role_id` INTEGER NOT NULL,
  `descp` text(255) DEFAULT NULL,
  `descp2` text(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
);

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '2', null, null);
INSERT INTO `user_role` VALUES ('2', '2', 'descp','descp2');
INSERT INTO `user_role` VALUES ('3', '3', 'descp401', null);
INSERT INTO `user_role` VALUES ('4', '4', 'descp446', 'descp2_update_37');
INSERT INTO `user_role` VALUES ('5', '5', 'descp866', null);
INSERT INTO `user_role` VALUES ('6', '6', 'descp848', null);
INSERT INTO `user_role` VALUES ('7', '7', 'descp489', null);
INSERT INTO `user_role` VALUES ('8', '8', 'descp581', null);
INSERT INTO `user_role` VALUES ('9', '10', 'descp581', null);
INSERT INTO `user_role` VALUES ('10', '10', 'descp581', null);


-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  `user_id` INTEGER NULL,
  `name` text(255) DEFAULT NULL,
  `descp` text(255) DEFAULT NULL,
  `province` text(255) DEFAULT NULL,
  `city` text(255) DEFAULT NULL,
  `district` text(255) DEFAULT NULL,
  `street` text(255) DEFAULT NULL,
  `street_no` INTEGER DEFAULT NULL
);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------

INSERT INTO `user_info` (`id`, `user_id`, `name`, `descp`, `province`, `city`, `district`, `street`, `street_no`) VALUES (1, 1, '羽飞', '羽飞描述', '四川', '成都', '金牛', '沙湾路', 66);
INSERT INTO `user_info` (`id`, `user_id`, `name`, `descp`, `province`, `city`, `district`, `street`, `street_no`) VALUES (2, 2, '翼', '翼描述', '广东', '深圳', '罗湖', '测试地址', 112);
INSERT INTO `user_info` (`id`, `user_id`, `name`, `descp`, `province`, `city`, `district`, `street`, `street_no`) VALUES (3, 3, '飞', '飞描述', '四川', '成都', '武侯', '天府三街', 88);
INSERT INTO `user_info` (`id`, `user_id`, `name`, `descp`, `province`, `city`, `district`, `street`, `street_no`) VALUES (4, 4, '张三', '张三描述', '四川', '成都', '武侯', '天府三街', 99);
INSERT INTO `user_info` (`id`, `user_id`, `name`, `descp`, `province`, `city`, `district`, `street`, `street_no`) VALUES (5, 5, '李四', '李四描述', '四川', '成都', '青羊', '红星路一段', null);
INSERT INTO `user_info` (`id`, `user_id`, `name`, `descp`, `province`, `city`, `district`, `street`, `street_no`) VALUES (6, 6, 'yufei45', 'yufei45描述', '四川', '成都', '金牛', '沙湾路', 66);
INSERT INTO `user_info` (`id`, `user_id`, `name`, `descp`, `province`, `city`, `district`, `street`, `street_no`) VALUES (7, 7, 'yufei55', 'yufei55描述', '张三描述', '四川', '成都', '武侯', '天府三街', 99);

DROP TABLE IF EXISTS `cms_article`;
CREATE TABLE `cms_article` (
  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  `title` text(255) DEFAULT NULL,
  `content` text(255) DEFAULT NULL
);

DROP TABLE IF EXISTS `cms_article2`;
CREATE TABLE `cms_article2` (
  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  `title` text(255) DEFAULT NULL,
  `content` text(255) DEFAULT NULL,
  `content2` text(2000) DEFAULT NULL,
  `content3` text(2000) DEFAULT NULL,
  `content4` text(2000) DEFAULT NULL
);

DROP TABLE IF EXISTS `tree`;
CREATE TABLE `tree` (
  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  `parent_id` INTEGER DEFAULT NULL,
  `name` text(255) DEFAULT NULL
);

INSERT INTO `tree`(`id`, `parent_id`, `name`) VALUES (1, NULL, 'node_1');
INSERT INTO `tree`(`id`, `parent_id`, `name`) VALUES (2, 1, 'node_21');
INSERT INTO `tree`(`id`, `parent_id`, `name`) VALUES (3, 1, 'node_22');
INSERT INTO `tree`(`id`, `parent_id`, `name`) VALUES (4, 2, 'node_211');
INSERT INTO `tree`(`id`, `parent_id`, `name`) VALUES (5, 2, 'node_212');
INSERT INTO `tree`(`id`, `parent_id`, `name`) VALUES (6, 5, 'node_2121');
INSERT INTO `tree`(`id`, `parent_id`, `name`) VALUES (7, 6, 'node_21211');

DROP TABLE IF EXISTS `app`;
CREATE TABLE `app`  (
  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  `code` text(64) NULL DEFAULT NULL,
  `name` text(255) NULL DEFAULT NULL,
  `descp` text(255) NULL DEFAULT NULL,
  `platform` INTEGER NULL DEFAULT NULL,
  `last_version` INTEGER NULL DEFAULT NULL
);

INSERT INTO `app` VALUES (1, 'cn.featherfly.surveillance.camera', '监控摄像头', NULL, 101, 2);

-- ----------------------------
-- Table structure for app_version
-- ----------------------------
DROP TABLE IF EXISTS `app_version`;
CREATE TABLE `app_version`  (
  `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  `app_id` INTEGER NOT NULL,
  `platform` INTEGER NULL DEFAULT NULL,
  `version` INTEGER NULL DEFAULT NULL,
  `version_code` text(255)  NULL DEFAULT NULL,
  `descp` text(255)  NULL DEFAULT NULL,
  `url` text(255)  NULL DEFAULT NULL,
  `store_key` text(255) NULL DEFAULT NULL,
  `release_date` datetime(0) NULL DEFAULT NULL
) ;

INSERT INTO `app_version` VALUES (1, 1, 101, 1, '0.1.0', NULL, 'http://www.baidu.com', NULL, '2021-11-27 17:18:36');
INSERT INTO `app_version` VALUES (2, 1, 101, 2, '0.2.0', NULL, 'http://www.baidu.com', NULL, '2021-11-29 15:18:36');

DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
`no` text(255) NOT NULL ,
`app_id` text(255) NULL DEFAULT NULL,
`app_key` text(255) NULL DEFAULT NULL,
`wx_package` text(255) NULL DEFAULT NULL,
`wx_package_expire_time` datetime(0) NULL DEFAULT NULL,
`alipay_trade_no` text(255) NULL DEFAULT NULL,
`parent_id` INTEGER unsigned NULL DEFAULT NULL,
`create_user` INTEGER unsigned NULL DEFAULT NULL,
`update_user` INTEGER unsigned NULL DEFAULT NULL,
`user1` INTEGER unsigned NULL DEFAULT NULL,
`user2` INTEGER unsigned NULL DEFAULT NULL,
`user3` INTEGER unsigned NULL DEFAULT NULL,
`user_info` INTEGER unsigned NULL DEFAULT NULL
);

INSERT INTO `order` (`id`, `no`, `app_id`, `app_key`, `wx_package`, `wx_package_expire_time`, `alipay_trade_no`, `parent_id`, `create_user`, `update_user`, `user1`, `user2`, `user3`, `user_info`) 
    VALUES (1, 'no:1', 'app_id', 'app_key', 'wx_package', strftime('%s','now'), 'alipay_trade_no', null, 1, 1, 1, 2, 3, 1);
INSERT INTO `order` (`id`, `no`, `app_id`, `app_key`, `wx_package`, `wx_package_expire_time`, `alipay_trade_no`, `parent_id`, `create_user`, `update_user`, `user1`, `user2`, `user3`, `user_info`) 
    VALUES (2, 'no:2', 'app_id', 'app_key', 'wx_package', strftime('%s','now'), 'alipay_trade_no', 1, 2, 2, 1, 2, 3, 2);
INSERT INTO `order` (`id`, `no`, `app_id`, `app_key`, `wx_package`, `wx_package_expire_time`, `alipay_trade_no`, `parent_id`, `create_user`, `update_user`, `user1`, `user2`, `user3`, `user_info`) 
    VALUES (3, 'no:3', 'app_id', 'app_key', 'wx_package', strftime('%s','now'), 'alipay_trade_no', 1, 2, 3, 4, 5, 6, 1);

DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info`  (
`id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
`descp` text(255) NOT NULL ,
`order_id` INTEGER unsigned NULL DEFAULT NULL,
`create_user` INTEGER unsigned NULL DEFAULT NULL,
`update_user` INTEGER unsigned NULL DEFAULT NULL,
`user1` INTEGER unsigned NULL DEFAULT NULL,
`user2` INTEGER unsigned NULL DEFAULT NULL,
`user3` INTEGER unsigned NULL DEFAULT NULL,
`user_info` INTEGER unsigned NULL DEFAULT NULL
);

INSERT INTO `order_info` (`id`, `descp`, `order_id`, `create_user`, `update_user`,`user1`, `user2`, `user3`, `user_info`) 
    VALUES (1, 'descp1', 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `order_info` (`id`, `descp`, `order_id`, `create_user`, `update_user`,`user1`, `user2`, `user3`, `user_info`) 
    VALUES (2, 'descp2', 2, 2, 2, 2, 2, 2, 2);
INSERT INTO `order_info` (`id`, `descp`, `order_id`, `create_user`, `update_user`,`user1`, `user2`, `user3`, `user_info`) 
    VALUES (3, 'descp2', 3, 1, 2, 3, 4, 5, 6);
