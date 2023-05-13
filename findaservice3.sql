/*
Navicat MySQL Data Transfer

Source Server         : SQW
Source Server Version : 50514
Source Host           : localhost:3306
Source Database       : findaservice3

Target Server Type    : MYSQL
Target Server Version : 50514
File Encoding         : 65001

Date: 2023-05-13 13:29:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` varchar(55) NOT NULL,
  `admin_pwd` varchar(55) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin1', 'admin1');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `service_id` int(11) NOT NULL,
  `review_id` int(11) DEFAULT NULL,
  `user_id` varchar(100) NOT NULL,
  `order_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `order_status` int(11) NOT NULL,
  `detail_time` varchar(100) NOT NULL,
  `detail_add` varchar(100) DEFAULT NULL,
  `order_detail1` varchar(1000) DEFAULT NULL,
  `order_detail2` varchar(1000) DEFAULT NULL,
  `order_detail3` varchar(1000) DEFAULT NULL,
  `order_detail4` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FK_have` (`service_id`),
  KEY `FK_include2` (`review_id`),
  KEY `FK_place` (`user_id`),
  CONSTRAINT `FK_have` FOREIGN KEY (`service_id`) REFERENCES `services` (`service_id`),
  CONSTRAINT `FK_include2` FOREIGN KEY (`review_id`) REFERENCES `review` (`review_id`),
  CONSTRAINT `FK_place` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '1', null, 'user1@gmail.com', '2023-05-12 14:52:39', '-1', '4pm/10/5/2023', 'lo140ge', null, null, null, null);
INSERT INTO `orders` VALUES ('2', '2', null, 'user2@gmail.com', '2023-05-12 15:19:13', '-1', '4pm/10/5/2023', 'so14 0ge', null, null, null, null);
INSERT INTO `orders` VALUES ('3', '2', null, 'user3@gmail.com', '2023-05-12 20:12:44', '0', '4pm/10/5/2023', null, 'dfghjfcsldvnls', 'test2', 'test3', 'test4');
INSERT INTO `orders` VALUES ('5', '1', null, 'user3@gmail.com', '2023-05-12 22:28:01', '6', '4pm/10/5/2023', null, 'cfvbnmcdsvjhbdvabkdjvn;akdsvn;alkdlvk', 'test2/4', 'test3', 'test2/4');
INSERT INTO `orders` VALUES ('10', '2', null, 'user3@gmail.com', '2023-05-11 19:26:45', '1', '4pm/10/5/2023', null, null, null, null, null);
INSERT INTO `orders` VALUES ('12', '2', null, 'user3@gmail.com', '2023-05-11 19:27:16', '1', '4pm/10/5/2023', null, null, null, null, null);
INSERT INTO `orders` VALUES ('14', '2', null, 'user3@gmail.com', '2023-05-11 19:37:17', '1', '4pm/10/5/2023', null, null, null, null, null);
INSERT INTO `orders` VALUES ('17', '2', null, 'user3@gmail.com', '2023-05-11 19:38:10', '1', '4pm/10/5/2023', null, null, null, null, null);
INSERT INTO `orders` VALUES ('19', '2', null, 'user3@gmail.com', '2023-05-11 19:41:42', '1', '4pm/10/5/2023', null, null, null, null, null);
INSERT INTO `orders` VALUES ('20', '2', null, 'user3@gmail.com', '2023-05-12 18:19:20', '1', '4pm/10/5/2023', null, 'test', null, null, null);
INSERT INTO `orders` VALUES ('21', '2', null, 'user3@gmail.com', '2023-05-13 13:28:44', '1', '4pm/10/5/2023', null, 'test1', 'test2', 'test3', 'test4');

-- ----------------------------
-- Table structure for review
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review` (
  `review_id` int(11) NOT NULL AUTO_INCREMENT,
  `service_id` int(11) DEFAULT NULL,
  `user_id` varchar(100) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `score` int(11) NOT NULL,
  `content` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`review_id`),
  KEY `FK_belong` (`service_id`),
  KEY `FK_give` (`user_id`),
  KEY `FK_include` (`order_id`),
  CONSTRAINT `FK_belong` FOREIGN KEY (`service_id`) REFERENCES `services` (`service_id`),
  CONSTRAINT `FK_give` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FK_include` FOREIGN KEY (`order_id`) REFERENCES `orders` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of review
-- ----------------------------
INSERT INTO `review` VALUES ('2', '2', 'user1@gmail.com', '3', '4', 'good');

-- ----------------------------
-- Table structure for serviceprovider
-- ----------------------------
DROP TABLE IF EXISTS `serviceprovider`;
CREATE TABLE `serviceprovider` (
  `provider_id` varchar(30) NOT NULL,
  `provider_pwd` varchar(16) NOT NULL,
  `provider_add` varchar(50) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `verified` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`provider_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of serviceprovider
-- ----------------------------
INSERT INTO `serviceprovider` VALUES ('provider1@gmail.com', 'provider1', 'so14 0ge', 'provider1', '2');
INSERT INTO `serviceprovider` VALUES ('provider2@gmail.com', 'provider2', 'so14 0gf', 'provider2', '0');
INSERT INTO `serviceprovider` VALUES ('provider3@gmail.com', 'provider3', 'so14 0gg', 'provider3', '0');

-- ----------------------------
-- Table structure for services
-- ----------------------------
DROP TABLE IF EXISTS `services`;
CREATE TABLE `services` (
  `service_id` int(11) NOT NULL AUTO_INCREMENT,
  `provider_id` varchar(100) DEFAULT NULL,
  `service_description` varchar(1000) NOT NULL,
  `service_photo` varchar(100) DEFAULT NULL,
  `price` float NOT NULL,
  `service_area` varchar(55) NOT NULL,
  `availability` varchar(55) NOT NULL,
  `verified` tinyint(1) NOT NULL DEFAULT '0',
  `provider_email` varchar(100) NOT NULL,
  `service_category` varchar(50) NOT NULL,
  PRIMARY KEY (`service_id`),
  KEY `FK_provide` (`provider_id`),
  CONSTRAINT `FK_provide` FOREIGN KEY (`provider_id`) REFERENCES `serviceprovider` (`provider_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of services
-- ----------------------------
INSERT INTO `services` VALUES ('1', 'provider1@gmail.com', 'room_cleaning_service', null, '100', 'London', ' weekdays', '1', 'provider1@gmail.com', 'Cleaning');
INSERT INTO `services` VALUES ('2', 'provider1@gmail.com', 'babysitting_service', null, '99', 'Southampton', ' 24/7', '1', 'provider1@gmail.com', 'Baby Sitting');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `user_pwd` varchar(16) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('user1@gmail.com', null, 'user1');
INSERT INTO `users` VALUES ('user2@gmail.com', null, 'user2/modi');
INSERT INTO `users` VALUES ('user3@gmail.com', null, 'user3');
