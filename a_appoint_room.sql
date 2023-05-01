/*
 Navicat MySQL Data Transfer

 Source Server         : taobishe
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : 1.116.117.222:3306
 Source Schema         : a_appoint_room

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 22/02/2023 12:45:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for appoint_advert
-- ----------------------------
DROP TABLE IF EXISTS `appoint_advert`;
CREATE TABLE `appoint_advert`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pic_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片地址',
  `enable` tinyint(4) NULL DEFAULT NULL COMMENT '是否启用，0：禁用，1：启用',
  `link` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '链接',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '广告' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of appoint_advert
-- ----------------------------
INSERT INTO `appoint_advert` VALUES (2, 'http://192.168.31.220:8080/img/banner-2.jpg', 1, NULL, 2, '2020-10-31 13:45:13');
INSERT INTO `appoint_advert` VALUES (5, 'http://192.168.31.220:8080/img/banner-1.jpg', 1, NULL, 1, '2021-02-12 16:16:25');

-- ----------------------------
-- Table structure for appoint_category
-- ----------------------------
DROP TABLE IF EXISTS `appoint_category`;
CREATE TABLE `appoint_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `pic_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '分类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of appoint_category
-- ----------------------------
INSERT INTO `appoint_category` VALUES (18, '物理', NULL, 1, '2021-05-22 11:35:45');
INSERT INTO `appoint_category` VALUES (19, '化学', NULL, 2, '2021-05-22 11:35:55');

-- ----------------------------
-- Table structure for appoint_order
-- ----------------------------
DROP TABLE IF EXISTS `appoint_order`;
CREATE TABLE `appoint_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '订单编号',
  `room_id` int(11) NULL DEFAULT NULL COMMENT '会议室id',
  `room_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '房间名称',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户',
  `appoint_time` datetime(0) NULL DEFAULT NULL COMMENT '预约时间',
  `time_id` int(11) NULL DEFAULT NULL,
  `time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '时间段',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '状态',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '预约' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of appoint_order
-- ----------------------------
INSERT INTO `appoint_order` VALUES (35, '20220623475479', 5, NULL, 1, '2022-06-23 00:00:00', 34, '08:00~09:00', 1, '2022-06-23 15:36:18');
INSERT INTO `appoint_order` VALUES (36, '20220623854470', 5, NULL, 1, '2022-06-23 00:00:00', 32, '13:00~14:00', 1, '2022-06-23 15:36:42');
INSERT INTO `appoint_order` VALUES (37, '20220623786547', 5, NULL, 1, '2022-06-24 00:00:00', 35, '14:00~15:00', 2, '2022-06-23 15:38:51');
INSERT INTO `appoint_order` VALUES (38, '20221111084840', 5, NULL, 1, '2022-11-11 00:00:00', 50, '08:00~09:00', 2, '2022-11-11 08:27:50');
INSERT INTO `appoint_order` VALUES (39, '20221122913846', 5, NULL, 1, '2022-11-22 00:00:00', 54, '08:00~09:00', 1, '2022-11-22 12:21:24');
INSERT INTO `appoint_order` VALUES (40, '20221122519318', 5, NULL, 1, '2022-11-22 00:00:00', 54, '08:00~09:00', 1, '2022-11-22 12:41:14');
INSERT INTO `appoint_order` VALUES (41, '20221122765205', 5, NULL, 1, '2022-11-22 00:00:00', 54, '08:00~09:00', 2, '2022-11-22 12:46:49');

-- ----------------------------
-- Table structure for appoint_room
-- ----------------------------
DROP TABLE IF EXISTS `appoint_room`;
CREATE TABLE `appoint_room`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '房间名称',
  `pic_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '图片',
  `category_id` int(11) NULL DEFAULT NULL COMMENT '分类id',
  `remark` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '备注',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '房间' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of appoint_room
-- ----------------------------
INSERT INTO `appoint_room` VALUES (3, '化学实验室', 'http://192.168.31.220:8080/img/room-1.jpg', 19, '<p><img src=\"http://192.168.31.220:8080/img/detail.jpg\"></p>', '2021-02-24 17:17:42');
INSERT INTO `appoint_room` VALUES (4, '物理实验室', 'http://192.168.31.220:8080/img/room-2.jpg', 19, '<p><img src=\"http://localhost:8080/img/detail.jpg\"></p>', '2021-04-02 19:51:24');
INSERT INTO `appoint_room` VALUES (5, '数学会议室', 'http://192.168.31.220:8080/img/room-3.jpg', 18, '<p><img src=\"http://localhost:8080/img/detail.jpg\"></p>', '2021-04-02 19:51:43');

-- ----------------------------
-- Table structure for appoint_setting
-- ----------------------------
DROP TABLE IF EXISTS `appoint_setting`;
CREATE TABLE `appoint_setting`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room_id` int(11) NULL DEFAULT NULL COMMENT '房间id',
  `start_time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '结束时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '预约设置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of appoint_setting
-- ----------------------------
INSERT INTO `appoint_setting` VALUES (10, 5, '08:00', '09:00');
INSERT INTO `appoint_setting` VALUES (11, 5, '10:00', '11:00');
INSERT INTO `appoint_setting` VALUES (12, 5, '13:00', '14:00');
INSERT INTO `appoint_setting` VALUES (13, 5, '14:00', '15:00');

-- ----------------------------
-- Table structure for appoint_time
-- ----------------------------
DROP TABLE IF EXISTS `appoint_time`;
CREATE TABLE `appoint_time`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room_id` int(11) NULL DEFAULT NULL COMMENT '房间id',
  `appoint_date` date NULL DEFAULT NULL COMMENT '预约日期',
  `start_time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '结束时间',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '预约时间' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of appoint_time
-- ----------------------------
INSERT INTO `appoint_time` VALUES (31, 5, '2022-06-23', '14:00', '15:00', 1);
INSERT INTO `appoint_time` VALUES (32, 5, '2022-06-23', '13:00', '14:00', 1);
INSERT INTO `appoint_time` VALUES (33, 5, '2022-06-23', '10:00', '11:00', 1);
INSERT INTO `appoint_time` VALUES (34, 5, '2022-06-23', '08:00', '09:00', 1);
INSERT INTO `appoint_time` VALUES (35, 5, '2022-06-24', '14:00', '15:00', 1);
INSERT INTO `appoint_time` VALUES (36, 5, '2022-06-24', '13:00', '14:00', 1);
INSERT INTO `appoint_time` VALUES (37, 5, '2022-06-24', '10:00', '11:00', 1);
INSERT INTO `appoint_time` VALUES (38, 5, '2022-06-24', '08:00', '09:00', 1);
INSERT INTO `appoint_time` VALUES (39, 5, '2022-06-27', '14:00', '15:00', 1);
INSERT INTO `appoint_time` VALUES (40, 5, '2022-06-27', '13:00', '14:00', 1);
INSERT INTO `appoint_time` VALUES (41, 5, '2022-06-27', '10:00', '11:00', 1);
INSERT INTO `appoint_time` VALUES (42, 5, '2022-06-27', '08:00', '09:00', 1);
INSERT INTO `appoint_time` VALUES (43, 5, '2022-07-08', '14:00', '15:00', 1);
INSERT INTO `appoint_time` VALUES (44, 5, '2022-07-08', '13:00', '14:00', 1);
INSERT INTO `appoint_time` VALUES (45, 5, '2022-07-08', '10:00', '11:00', 1);
INSERT INTO `appoint_time` VALUES (46, 5, '2022-07-08', '08:00', '09:00', 1);
INSERT INTO `appoint_time` VALUES (47, 5, '2022-11-11', '14:00', '15:00', 1);
INSERT INTO `appoint_time` VALUES (48, 5, '2022-11-11', '13:00', '14:00', 1);
INSERT INTO `appoint_time` VALUES (49, 5, '2022-11-11', '10:00', '11:00', 1);
INSERT INTO `appoint_time` VALUES (50, 5, '2022-11-11', '08:00', '09:00', 1);
INSERT INTO `appoint_time` VALUES (51, 5, '2022-11-22', '14:00', '15:00', 1);
INSERT INTO `appoint_time` VALUES (52, 5, '2022-11-22', '13:00', '14:00', 1);
INSERT INTO `appoint_time` VALUES (53, 5, '2022-11-22', '10:00', '11:00', 1);
INSERT INTO `appoint_time` VALUES (54, 5, '2022-11-22', '08:00', '09:00', 1);

-- ----------------------------
-- Table structure for base_member
-- ----------------------------
DROP TABLE IF EXISTS `base_member`;
CREATE TABLE `base_member`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `avatar_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `gender` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `real_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `mobile` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `login_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录账号',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '会员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of base_member
-- ----------------------------
INSERT INTO `base_member` VALUES (1, '清风', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK3JVibuZg8wiaKG9ExyVJJT2R4s398eropw2qU7GhJEwgwNB8Y56GWh4dDHPSYTNcJXgmkvz4809SA/132', '1', '微服汇', '18112907714', 'test', '123456', '2022-05-04 17:10:30');
INSERT INTO `base_member` VALUES (2, '微服汇', 'https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK3JVibuZg8wiaKG9ExyVJJT2R4s398eropw2qU7GhJEwgwNB8Y56GWh4dDHPSYTNcJXgmkvz4809SA/132', NULL, '李老师', NULL, 'qwer', '123456', '2022-06-16 16:18:11');

-- ----------------------------
-- Table structure for base_member_auth
-- ----------------------------
DROP TABLE IF EXISTS `base_member_auth`;
CREATE TABLE `base_member_auth`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `openid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT 'openid',
  `auth_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '授权类型',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `OPENID_UNIQUE`(`openid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '授权' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of base_member_auth
-- ----------------------------
INSERT INTO `base_member_auth` VALUES (1, 1, 'o1HEb0bbQgdd1aPNyr2ZXvutSU8U', 'wechat', '2022-05-04 17:10:30');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '21232f297a57a5a743894a0e4a801fc3', '2803180149@qq.com', '18021418906', 1, '2021-08-06 11:11:11');

SET FOREIGN_KEY_CHECKS = 1;
