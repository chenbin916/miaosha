/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 29/09/2020 17:08:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;


-- ----------------------------
-- Table structure for tb_miaosha
-- ----------------------------
DROP TABLE IF EXISTS `tb_miaosha`;
CREATE TABLE `tb_miaosha`  (
  `goods_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `goods_nums` int(255) DEFAULT NULL,
  PRIMARY KEY (`goods_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_miaosha
-- ----------------------------
INSERT INTO `tb_miaosha` VALUES ('bike', 62);

-- ----------------------------
-- Table structure for tb_records
-- ----------------------------
DROP TABLE IF EXISTS `tb_records`;
CREATE TABLE `tb_records`  (
  `records_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `user_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`records_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_records
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
