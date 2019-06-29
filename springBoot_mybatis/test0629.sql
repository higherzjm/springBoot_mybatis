/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50623
Source Host           : localhost:3306
Source Database       : test0629

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2019-06-29 14:22:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `college`
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college` (
  `college_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学院id',
  `colege_name` varchar(255) DEFAULT NULL COMMENT '学院名称',
  PRIMARY KEY (`college_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of college
-- ----------------------------
INSERT INTO `college` VALUES ('1', '计算机学院');
INSERT INTO `college` VALUES ('2', '法学院');
INSERT INTO `college` VALUES ('3', '金融学院');
INSERT INTO `college` VALUES ('4', '外语学院');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生id',
  `student_no` varchar(255) DEFAULT NULL COMMENT '学号',
  `student_name` varchar(255) DEFAULT NULL COMMENT '学生姓名',
  `teacher_id` int(11) NOT NULL COMMENT '教师id',
  `college_id` int(11) DEFAULT NULL COMMENT '学院id',
  PRIMARY KEY (`student_id`),
  KEY `teacher_id` (`teacher_id`) USING BTREE,
  KEY `college_id` (`college_id`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `student_ibfk_2` FOREIGN KEY (`college_id`) REFERENCES `college` (`college_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('4', '10001', '李四1', '7', '1');
INSERT INTO `student` VALUES ('5', '10002', '李四2', '7', '1');
INSERT INTO `student` VALUES ('6', '10003', '李四3', '9', '2');
INSERT INTO `student` VALUES ('7', '10004', '李四4', '10', '3');
INSERT INTO `student` VALUES ('8', '10005', '李四5', '11', '1');
INSERT INTO `student` VALUES ('9', '10006', '李四6', '8', '4');
INSERT INTO `student` VALUES ('10', '10007', '李四7', '13', '2');
INSERT INTO `student` VALUES ('11', '10008', '李四8', '7', '2');
INSERT INTO `student` VALUES ('13', '10009', '李四9', '7', '1');
INSERT INTO `student` VALUES ('14', '1000988', '李四99945', '7', '1');
INSERT INTO `student` VALUES ('15', '1000910', '李四910', '7', '1');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacher_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '教师id',
  `teacher_name` varchar(255) DEFAULT '' COMMENT '教师姓名',
  `city` varchar(255) DEFAULT NULL,
  `college_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`teacher_id`),
  KEY `college_id` (`college_id`),
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`college_id`) REFERENCES `college` (`college_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('7', '张三1', '龙岩市', '1');
INSERT INTO `teacher` VALUES ('8', '张三2', '龙岩市', '1');
INSERT INTO `teacher` VALUES ('9', '张三3', '泉州市', '2');
INSERT INTO `teacher` VALUES ('10', '张三4', '泉州市', '1');
INSERT INTO `teacher` VALUES ('11', '张三5', '厦门市', '3');
INSERT INTO `teacher` VALUES ('12', '张三6', '漳州市', '4');
INSERT INTO `teacher` VALUES ('13', '张三7', '龙岩市', '2');
