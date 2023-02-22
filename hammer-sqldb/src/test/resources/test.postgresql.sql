DROP SEQUENCE IF EXISTS globl_id_seq CASCADE;
CREATE SEQUENCE globl_id_seq START 1000;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS "role" CASCADE;
CREATE TABLE "public"."role" (
  -- "id" serial NOT NULL ,
  "id" int4 NOT NULL DEFAULT nextval('globl_id_seq'),
  "name" varchar(20) COLLATE "pg_catalog"."default",
  "descp" varchar(36) COLLATE "pg_catalog"."default",
  "create_time" timestamp,
  CONSTRAINT "role_pkey" PRIMARY KEY ("id")
)
;

ALTER TABLE "public"."role" 
  OWNER TO "postgres";

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO "role" VALUES ('1', 'n_init_1', 'descp_1', now());
INSERT INTO "role" VALUES ('2', 'n_init_2', 'descp_2', now());
INSERT INTO "role" VALUES ('3', 'n_init_3', 'descp_3', now());
INSERT INTO "role" VALUES ('4', 'n_init_4', 'descp_4', now());
INSERT INTO "role" VALUES ('5', 'n_init_7', 'descp_5', now());
INSERT INTO "role" VALUES ('6', 'n_init_11', 'descp_64', now());
INSERT INTO "role" VALUES ('7', 'name_init_98', 'descp_79', now());
INSERT INTO "role" VALUES ('8', 'name_init_21', 'descp_5', now());
INSERT INTO "role" VALUES ('9', 'name_init_96', 'descp_98', now());
INSERT INTO "role" VALUES ('10', 'n_96', 'descp_29', now());
INSERT INTO "role" VALUES ('11', 'n_42', 'descp_54', now());
INSERT INTO "role" VALUES ('12', 'n_12', 'descp_65', now());

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS "user" CASCADE;
CREATE TABLE "public"."user" (
  "id" int4 NOT NULL DEFAULT nextval('globl_id_seq'),
  "username" varchar(255) COLLATE "pg_catalog"."default",
  "password" varchar(255) COLLATE "pg_catalog"."default",
  "mobile_no" varchar(11) COLLATE "pg_catalog"."default",
  "age" int4,
  CONSTRAINT "user_pkey" PRIMARY KEY ("id"),
  CONSTRAINT "USER_NAME_UQ" UNIQUE ("username"),
  CONSTRAINT "MOBILE_NO_UQ" UNIQUE ("mobile_no")
)
;

ALTER TABLE "public"."user" 
  OWNER TO "postgres";

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO "user" VALUES ('1', 'yufei', '123456', '12345678901', '5');
INSERT INTO "user" VALUES ('2', 'featherfly', '654321', '98765432101', '5');
INSERT INTO "user" VALUES ('3', 'yufei15', '123456', '15345678915', '15');
INSERT INTO "user" VALUES ('4', 'yufei25', '123456', '25345678925', '25');
INSERT INTO "user" VALUES ('5', 'yufei35', '123456', '35345678935', '35');
INSERT INTO "user" VALUES ('6', 'yufei45', '123456', '45345678945', '45');
INSERT INTO "user" VALUES ('7', 'yufei55', '123456', '55345678955', '55');
INSERT INTO "user" VALUES ('8', 'featherfly10', '654321', '10765432110', '10');
INSERT INTO "user" VALUES ('9', 'featherfly20', '654321', '20765432120', '20');
INSERT INTO "user" VALUES ('10', 'featherfly30', '654321', '30765432130', '30');
INSERT INTO "user" VALUES ('11', 'featherfly40', '654321', '40765432140', '40');
INSERT INTO "user" VALUES ('12', 'featherfly50', '654321', '50765432150', '50');
INSERT INTO "user" VALUES ('13', 'featherfly10-2', '654321', '10765432112', '10');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS "user_role" CASCADE;
CREATE TABLE "user_role" (
  "user_id" int4 NOT NULL,
  "role_id" int4 NOT NULL,
  "descp" varchar(255),
  "descp2" varchar(255),
  CONSTRAINT "user_role_pkey" PRIMARY KEY ("user_id","role_id")
);

ALTER TABLE "public"."user_role" 
  OWNER TO "postgres";

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO "user_role" VALUES ('1', '2', null, null);
INSERT INTO "user_role" VALUES ('2', '2', 'descp','descp2');
INSERT INTO "user_role" VALUES ('3', '3', 'descp401', null);
INSERT INTO "user_role" VALUES ('4', '4', 'descp446', 'descp2_update_37');
INSERT INTO "user_role" VALUES ('5', '5', 'descp866', null);
INSERT INTO "user_role" VALUES ('6', '6', 'descp848', null);
INSERT INTO "user_role" VALUES ('7', '7', 'descp489', null);
INSERT INTO "user_role" VALUES ('8', '8', 'descp581', null);
INSERT INTO "user_role" VALUES ('9', '9', 'descp581', null);
INSERT INTO "user_role" VALUES ('10', '10', 'descp581', null);


-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS "user_info" CASCADE;
CREATE TABLE "user_info" (
  "id" int4 NOT NULL DEFAULT nextval('globl_id_seq'),
  "user_id" int4 NULL,
  "name" varchar(255) ,
  "descp" varchar(255) ,
  "province" varchar(255) ,
  "city" varchar(255) ,
  "district" varchar(255) ,
  CONSTRAINT "user_info_pkey" PRIMARY KEY ("id")
) ;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------

INSERT INTO "user_info" ("id", "user_id", "name", "descp", "province", "city", "district") VALUES ('1', '1', '羽飞', '羽飞描述', '四川', '成都', '金牛');
INSERT INTO "user_info" ("id", "user_id", "name", "descp", "province", "city", "district") VALUES ('2', '2', '翼', '翼描述', '广东', '深圳', '罗湖');

DROP TABLE IF EXISTS "cms_article" CASCADE;
CREATE TABLE "cms_article" (
  "id" int4 NOT NULL DEFAULT nextval('globl_id_seq'),
  "title" varchar(255) DEFAULT NULL,
  "content" varchar(255) DEFAULT NULL,
  CONSTRAINT "cms_article_pkey" PRIMARY KEY ("id")
);

DROP TABLE IF EXISTS "tree" CASCADE;
CREATE TABLE "tree" (
  "id" int4 NOT NULL DEFAULT nextval('globl_id_seq'),
  "parent_id" int4 DEFAULT NULL,
  "name" varchar(255) DEFAULT NULL,
  CONSTRAINT "tree_pkey" PRIMARY KEY ("id")
);

INSERT INTO "tree"("id", "parent_id", "name") VALUES (1, NULL, 'node_1');
INSERT INTO "tree"("id", "parent_id", "name") VALUES (2, 1, 'node_21');
INSERT INTO "tree"("id", "parent_id", "name") VALUES (3, 1, 'node_22');
INSERT INTO "tree"("id", "parent_id", "name") VALUES (4, 2, 'node_211');
INSERT INTO "tree"("id", "parent_id", "name") VALUES (5, 2, 'node_212');
INSERT INTO "tree"("id", "parent_id", "name") VALUES (6, 5, 'node_2121');
INSERT INTO "tree"("id", "parent_id", "name") VALUES (7, 6, 'node_21211');


DROP TABLE IF EXISTS "app";
CREATE TABLE "app"  (
  "id" int4 NOT NULL DEFAULT nextval('globl_id_seq'),
  "code" varchar(64)  NULL DEFAULT NULL,
  "name" varchar(255)  NULL DEFAULT NULL,
  "descp" varchar(255)  NULL DEFAULT NULL,
  "platform" int2 NULL DEFAULT NULL,
  "last_version" int4 NULL DEFAULT NULL,
  CONSTRAINT "app_pk" PRIMARY KEY ("id")
);

CREATE UNIQUE INDEX "code_platform_unique" ON "app" (
  "code",
  "platform"
);

INSERT INTO "app" VALUES (1, 'cn.featherfly.surveillance.camera', '监控摄像头', NULL, 101, 2);

DROP TABLE IF EXISTS "app_version";
CREATE TABLE "app_version"  (
  "id" int4 NOT NULL DEFAULT nextval('globl_id_seq'),
  "app_id" int4 NOT NULL,
  "platform" int4 NULL DEFAULT NULL,
  "version" int4 NULL DEFAULT NULL,
  "version_code" varchar(255)  NULL DEFAULT NULL,
  "descp" varchar(255)  NULL DEFAULT NULL,
  "url" varchar(255)  NULL DEFAULT NULL,
  "store_key" varchar(255)  NULL DEFAULT NULL,
  "release_date" timestamp NULL DEFAULT NULL,
  CONSTRAINT "app_version_pk" PRIMARY KEY ("id")
);

INSERT INTO "app_version" VALUES (1, 1, 101, 1, '0.1.0', NULL, 'http://www.baidu.com', NULL, '2021-11-27 17:18:36');
INSERT INTO "app_version" VALUES (2, 1, 101, 2, '0.2.0', NULL, 'http://www.baidu.com', NULL, '2021-11-29 15:18:36');



DROP TABLE IF EXISTS "order";
CREATE TABLE "order"  (
"id" int4 NOT NULL DEFAULT nextval('globl_id_seq'),
"no" varchar(255)  NOT NULL,
"app_id" varchar(255)  NULL DEFAULT NULL,
"app_key" varchar(255)  NULL DEFAULT NULL,
"wx_package" varchar(255)  NULL DEFAULT NULL,
"wx_package_expire_time" timestamp NULL DEFAULT NULL,
"alipay_trade_no" varchar(255)  NULL DEFAULT NULL,
"parent_id" int4 NULL DEFAULT NULL,
"create_user" int4 NULL DEFAULT NULL,
"update_user" int4 NULL DEFAULT NULL,
"user1" int4 NULL DEFAULT NULL,
"user2" int4 NULL DEFAULT NULL,
"user3" int4 NULL DEFAULT NULL,
"user_info" int4 NULL DEFAULT NULL,
CONSTRAINT "order_pk" PRIMARY KEY ("id")
);

INSERT INTO "order" ("id", "no", "app_id", "app_key", "wx_package", "wx_package_expire_time", "alipay_trade_no", "parent_id", "create_user", "update_user", "user1", "user2", "user3", "user_info") 
    VALUES (1, 'no:1', 'app_id', 'app_key', 'wx_package', now(), 'alipay_trade_no', null, 1, 1, 1, 1, 1, 1);
INSERT INTO "order" ("id", "no", "app_id", "app_key", "wx_package", "wx_package_expire_time", "alipay_trade_no", "parent_id", "create_user", "update_user", "user1", "user2", "user3", "user_info") 
    VALUES (2, 'no:2', 'app_id', 'app_key', 'wx_package', now(), 'alipay_trade_no', 1, 2, 2, 2, 2, 2, 2);

DROP TABLE IF EXISTS "order_info";
CREATE TABLE "order_info"  (
"id" int4 NOT NULL DEFAULT nextval('globl_id_seq'),
"descp" varchar(255)  NOT NULL,
"order_id" int4 NULL DEFAULT NULL,
"create_user" int4 NULL DEFAULT NULL,
"update_user" int4 NULL DEFAULT NULL,
"user1" int4 NULL DEFAULT NULL,
"user2" int4 NULL DEFAULT NULL,
"user3" int4 NULL DEFAULT NULL,
"user_info" int4 NULL DEFAULT NULL,
CONSTRAINT "order_info_pk" PRIMARY KEY ("id")
);

INSERT INTO "order_info" ("id", "descp", "order_id", "create_user", "update_user","user1", "user2", "user3", "user_info") 
    VALUES (1, 'descp1', 1, 1, 1, 1, 1, 1, 1);
INSERT INTO "order_info" ("id", "descp", "order_id", "create_user", "update_user","user1", "user2", "user3", "user_info") 
    VALUES (2, 'descp2', 2, 2, 2, 2, 2, 2, 2);
