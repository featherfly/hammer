DROP TABLE IF EXISTS `role`;
CREATE TABLE "role" (
  "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  "name" text(20),
  "descp" TEXT(36)
);

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'n_init_1', 'descp_1');
INSERT INTO `role` VALUES ('2', 'n_init_2', 'descp_2');
INSERT INTO `role` VALUES ('3', 'n_init_3', 'descp_3');
INSERT INTO `role` VALUES ('4', 'n_init_4', 'descp_4');
INSERT INTO `role` VALUES ('5', 'n_init_5', 'descp_5');
INSERT INTO `role` VALUES ('6', 'n_init_11', 'descp_64');
INSERT INTO `role` VALUES ('7', 'name_init_98', 'descp_79');
INSERT INTO `role` VALUES ('8', 'name_init_21', 'descp_5');
INSERT INTO `role` VALUES ('9', 'name_init_96', 'descp_98');
INSERT INTO `role` VALUES ('10', 'n_96', 'descp_29');
INSERT INTO `role` VALUES ('11', 'n_42', 'descp_54');
INSERT INTO `role` VALUES ('12', 'n_12', 'descp_65');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  `USERNAME` text(255) DEFAULT NULL,
  `PASSWORD` text(255) DEFAULT NULL,
  `MOBILE_NO` text(11) DEFAULT NULL,
  `AGE` INTEGER DEFAULT NULL,
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
  `ID` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  `user_id` INTEGER NOT NULL,
  `name` text(255) DEFAULT NULL,
  `descp` text(255) DEFAULT NULL,
  `province` text(255) DEFAULT NULL,
  `city` text(255) DEFAULT NULL,
  `district` text(255) DEFAULT NULL
);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------

INSERT INTO `user_info` (`ID`, `user_id`, `name`, `descp`, `province`, `city`, `district`) VALUES ('1', '1', '羽飞', '羽飞描述', '四川', '成都', '金牛');
INSERT INTO `user_info` (`ID`, `user_id`, `name`, `descp`, `province`, `city`, `district`) VALUES ('2', '2', '翼', '翼描述', '广东', '深圳', '罗湖');

DROP TABLE IF EXISTS `cms_article`;
CREATE TABLE `cms_article` (
  `ID` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  `title` text(255) DEFAULT NULL,
  `content` text(255) DEFAULT NULL
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