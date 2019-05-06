-- ----------------------------
-- Table structure for T_PERMISSION
-- ----------------------------
CREATE TABLE SYS_PERMISSION (
   ID NUMBER(10) NOT NULL PRIMARY KEY,
   URL VARCHAR(256) NULL COMMENT 'url 地址' ,
   NAME VARCHAR(64) NULL COMMENT 'url描述',
);
--COMMENT ON COLUMN T_PERMISSION.URL IS 'url地址';
--COMMENT ON COLUMN T_PERMISSION.NAME IS 'url描述';
-- ----------------------------
-- Records of T_PERMISSION
-- ----------------------------
INSERT INTO SYS_PERMISSION VALUES ('1', 'user:user', '/user');
INSERT INTO SYS_PERMISSION VALUES ('2', 'user:add', '/user/add');
INSERT INTO SYS_PERMISSION VALUES ('3', 'user:delete', '/user/delete');
-- ----------------------------
-- Table structure for T_ROLE
-- ----------------------------
CREATE TABLE SYS_ROLE (
   ID NUMBER NOT NULL ,
   NAME VARCHAR(32) NULL COMMENT '角色名称' ,
   MEMO VARCHAR(32) NULL COMMENT '角色描述'
);
--COMMENT ON COLUMN T_ROLE.NAME IS '角色名称';
--COMMENT ON COLUMN T_ROLE.MEMO IS '角色描述';
-- ----------------------------
-- Records of T_ROLE
-- ----------------------------
INSERT INTO sys_ROLE VALUES ('1', '超级管理员', 'admin');
INSERT INTO sys_ROLE VALUES ('2', '测试账户', 'test');
-- ----------------------------
-- Table structure for T_ROLE_PERMISSION
-- ----------------------------
CREATE TABLE SYS_ROLE_PERMISSION (
   RID NUMBER(10) NULL COMMENT ,
   PID NUMBER(10) NULL 
);
COMMENT ON COLUMN T_ROLE_PERMISSION.RID IS '角色id';
COMMENT ON COLUMN T_ROLE_PERMISSION.PID IS '权限id';
-- ----------------------------
-- Records of T_ROLE_PERMISSION
-- ----------------------------
INSERT INTO sys_role_role_permission VALUES ('1', '2');
INSERT INTO sys_role_role_permission VALUES ('1', '3');
INSERT INTO sys_role_role_permission VALUES ('2', '1');
INSERT INTO sys_role_role_permission VALUES ('1', '1');
-- ----------------------------
-- Table structure for T_USER
-- ----------------------------
CREATE TABLE T_USER (
   ID NUMBER NOT NULL ,
   USERNAME VARCHAR2(20 BYTE) NOT NULL ,
   PASSWD VARCHAR2(128 BYTE) NOT NULL ,
   CREATE_TIME DATE NULL ,
   STATUS CHAR(1 BYTE) NOT NULL 
);
COMMENT ON COLUMN T_USER.USERNAME IS '用户名';
COMMENT ON COLUMN T_USER.PASSWD IS '密码';
COMMENT ON COLUMN T_USER.CREATE_TIME IS '创建时间';
COMMENT ON COLUMN T_USER.STATUS IS '是否有效 1：有效  0：锁定';
-- ----------------------------
-- Records of T_USER
-- ----------------------------
INSERT INTO T_USER VALUES ('2', 'tester', '243e29429b340192700677d48c09d992', TO_DATE('2017-12-11 17:20:21', 'YYYY-MM-DD HH24:MI:SS'), '1');
INSERT INTO T_USER VALUES ('1', 'mrbird', '42ee25d1e43e9f57119a00d0a39e5250', TO_DATE('2017-12-11 10:52:48', 'YYYY-MM-DD HH24:MI:SS'), '1');
-- ----------------------------
-- Table structure for T_USER_ROLE
-- ----------------------------
CREATE TABLE T_USER_ROLE (
   USER_ID NUMBER(10) NULL ,
   RID NUMBER(10) NULL 
);
COMMENT ON COLUMN T_USER_ROLE.USER_ID IS '用户id';
COMMENT ON COLUMN T_USER_ROLE.RID IS '角色id';
-- ----------------------------
-- Records of T_USER_ROLE
-- ----------------------------
INSERT INTO T_USER_ROLE VALUES ('1', '1');
INSERT INTO T_USER_ROLE VALUES ('2', '2');