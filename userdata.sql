/*
Navicat MySQL Data Transfer

Source Server         : user
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : userdata

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-07-25 14:15:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for categorytable
-- ----------------------------
DROP TABLE IF EXISTS `categorytable`;
CREATE TABLE `categorytable` (
  `categoryId` int(11) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`categoryId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of categorytable
-- ----------------------------
INSERT INTO `categorytable` VALUES ('1', '计算机视觉');
INSERT INTO `categorytable` VALUES ('2', '虚拟现实');

-- ----------------------------
-- Table structure for filetable
-- ----------------------------
DROP TABLE IF EXISTS `filetable`;
CREATE TABLE `filetable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fileFileName` varchar(255) DEFAULT NULL,
  `fileContentType` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `categoryId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `categoryId` (`categoryId`),
  CONSTRAINT `categoryId` FOREIGN KEY (`categoryId`) REFERENCES `categorytable` (`categoryId`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of filetable
-- ----------------------------
INSERT INTO `filetable` VALUES ('19', '2-20170725120709.jpg', 'image/jpeg', 'E:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\webTest\\2-20170725120709.jpg', '1');
INSERT INTO `filetable` VALUES ('20', 'wplog-20170725121317.txt', 'text/plain', 'E:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\webTest\\wplog-20170725121317.txt', '1');
INSERT INTO `filetable` VALUES ('21', '2-20170725121727.jpg', 'image/jpeg', 'E:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\webTest\\2-20170725121727.jpg', '1');
INSERT INTO `filetable` VALUES ('23', '5-20170725122141.bmp', 'image/bmp', 'E:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\webTest\\5-20170725122141.bmp', '1');
INSERT INTO `filetable` VALUES ('24', '5-20170725122555.bmp', 'image/bmp', 'E:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\webTest\\5-20170725122555.bmp', '1');
INSERT INTO `filetable` VALUES ('26', '5-20170725122916.bmp', 'image/bmp', 'E:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\webTest\\5-20170725122916.bmp', '1');
INSERT INTO `filetable` VALUES ('27', '1-20170725123101.jpg', 'image/jpeg', 'E:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\webTest\\1-20170725123101.jpg', '1');
INSERT INTO `filetable` VALUES ('28', '1-20170725123126.jpg', 'image/jpeg', 'E:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\webTest\\1-20170725123126.jpg', '1');
INSERT INTO `filetable` VALUES ('29', '1-20170725123329.jpg', 'image/jpeg', 'E:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\webTest\\1-20170725123329.jpg', '1');
INSERT INTO `filetable` VALUES ('30', 'cameraman-20170725123621.tif', 'image/tiff', 'E:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\webTest\\cameraman-20170725123621.tif', '1');
INSERT INTO `filetable` VALUES ('31', '1-20170725123626.jpg', 'image/jpeg', 'E:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\webTest\\1-20170725123626.jpg', '1');
INSERT INTO `filetable` VALUES ('32', '5-20170725123635.bmp', 'image/bmp', 'E:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\webTest\\5-20170725123635.bmp', '1');
INSERT INTO `filetable` VALUES ('33', '5-20170725123734.bmp', 'image/bmp', 'E:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\webTest\\5-20170725123734.bmp', '1');

-- ----------------------------
-- Table structure for usertable
-- ----------------------------
DROP TABLE IF EXISTS `usertable`;
CREATE TABLE `usertable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `userPassword` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usertable
-- ----------------------------
INSERT INTO `usertable` VALUES ('1', 'jack', '81dc9bdb52d04dc20036dbd8313ed055');
INSERT INTO `usertable` VALUES ('2', 'jack1', '12345');
INSERT INTO `usertable` VALUES ('3', 'jack2', '123456');
