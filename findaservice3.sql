/*
Navicat MySQL Data Transfer

Source Server         : SQW
Source Server Version : 50514
Source Host           : localhost:3306
Source Database       : findaservice3

Target Server Type    : MYSQL
Target Server Version : 50514
File Encoding         : 65001

Date: 2023-05-16 13:32:18
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
  `order_status` varchar(30) NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '1', null, 'user1@gmail.com', '2023-05-16 12:58:25', 'rejected', '4pm/10/5/2023', 'London', 'Hello, I need cleaning service.', '', null, null);
INSERT INTO `orders` VALUES ('2', '2', null, 'user2@gmail.com', '2023-05-16 12:57:53', 'rejected', '4pm/10/5/2023', 'Southampton', 'hello, I need babysitting service.', null, null, null);
INSERT INTO `orders` VALUES ('3', '2', '13', 'user1@gmail.com', '2023-05-16 13:17:48', 'completed', '4pm/10/5/2023', 'Southampton', 'hello, I need babysitting service.', 'hi, ok.', '', '');
INSERT INTO `orders` VALUES ('5', '1', '14', 'user2@gmail.com', '2023-05-16 13:18:34', 'completed', '4pm/10/5/2023', 'London', 'Hello, I need cleaning service.', 'hi, ok.', 'please come to LO140GE.', 'ok.');
INSERT INTO `orders` VALUES ('10', '2', null, 'user1@gmail.com', '2023-05-16 13:04:38', 'accepted', '4pm/20/5/2023', 'Southampton', 'hello, I need babysitting service.', null, null, null);
INSERT INTO `orders` VALUES ('12', '2', '15', 'user1@gmail.com', '2023-05-16 13:19:25', 'completed', '4pm/10/5/2023', 'Southampton', 'hello, I need babysitting service.', 'hi, ok.', null, null);
INSERT INTO `orders` VALUES ('14', '2', null, 'user2@gmail.com', '2023-05-16 13:04:45', 'accepted', '4pm/20/5/2023', 'Southampton', 'hello, I need babysitting service.', 'hi, ok.', null, null);
INSERT INTO `orders` VALUES ('17', '2', '16', 'user2@gmail.com', '2023-05-16 13:20:00', 'completed', '4pm/10/5/2023', 'Southampton', null, null, null, null);
INSERT INTO `orders` VALUES ('20', '2', '17', 'user1@gmail.com', '2023-05-16 13:20:47', 'completed', '4pm/10/5/2023', 'Southampton', 'hello, I need babysitting service.', 'ok.', null, null);
INSERT INTO `orders` VALUES ('21', '2', null, 'user2@gmail.com', '2023-05-16 13:05:46', 'completed', '4pm/10/5/2023', 'Southampton', 'hello, I need babysitting service.', 'ok.', '', '');
INSERT INTO `orders` VALUES ('22', '2', null, 'user1@gmail.com', '2023-05-16 13:06:59', 'accepted', '4pm/17/5/2023', 'Southampton', 'hello, I need babysitting service.', 'ok.', null, null);
INSERT INTO `orders` VALUES ('23', '2', null, 'user2@gmail.com', '2023-05-16 13:07:02', 'accepted', '4pm/17/5/2023', 'Southampton', 'hello, I need babysitting service.', 'ok.', null, null);
INSERT INTO `orders` VALUES ('24', '2', null, 'user1@gmail.com', '2023-05-16 13:10:19', 'pending', '4pm/20/5/2023', 'Southampton', 'hi, I need babysitting service.', 'can you give more details?', null, null);
INSERT INTO `orders` VALUES ('25', '2', null, 'user2@gmail.com', '2023-05-16 13:10:21', 'pending', '4pm/20/5/2023', 'Southampton', 'hi, I need babysitting service.', 'can you give more details?', null, null);
INSERT INTO `orders` VALUES ('26', '1', null, 'user1@gmail.com', '2023-05-16 13:10:56', 'pending', '4pm/20/5/2023', 'London', 'hi, I need cleaning service.', 'can you give more details?', null, null);
INSERT INTO `orders` VALUES ('27', '1', null, 'user2@gmail.com', '2023-05-16 13:10:58', 'pending', '4pm/20/5/2023', 'London', 'hi, I need cleaning service.', 'can you give more details?', null, null);
INSERT INTO `orders` VALUES ('28', '3', null, 'user1@gmail.com', '2023-05-16 13:14:26', 'pending', '4pm/20/5/2023', 'Southampton', 'hi, I need plumbing service.', 'can you give more details?', null, null);
INSERT INTO `orders` VALUES ('29', '3', null, 'user2@gmail.com', '2023-05-16 13:14:28', 'pending', '4pm/20/5/2023', 'Southampton', 'hi, I need plumbing service.', 'can you give more details?', null, null);

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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of review
-- ----------------------------
INSERT INTO `review` VALUES ('2', '2', 'user1@gmail.com', '3', '4', 'good');
INSERT INTO `review` VALUES ('9', '2', 'user1@gmail.com', '12', '4', 'good');
INSERT INTO `review` VALUES ('10', '1', 'user1@gmail.com', '21', '4', 'fine');
INSERT INTO `review` VALUES ('13', '2', 'user1@gmail.com', '3', '4', 'good!');
INSERT INTO `review` VALUES ('14', '1', 'user2@gmail.com', '5', '3', 'normal.');
INSERT INTO `review` VALUES ('15', '2', 'user1@gmail.com', '12', '5', 'very good!');
INSERT INTO `review` VALUES ('16', '2', 'user2@gmail.com', '17', '3', 'normal.');
INSERT INTO `review` VALUES ('17', '2', 'user1@gmail.com', '20', '3', 'normal.');
INSERT INTO `review` VALUES ('18', '2', 'user2@gmail.com', '21', '5', 'very good!');

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
  `avg_score` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`provider_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of serviceprovider
-- ----------------------------
INSERT INTO `serviceprovider` VALUES ('provider1@gmail.com', 'provider1', 'London', 'provider1', '1', '2.6666666666666665');
INSERT INTO `serviceprovider` VALUES ('provider2@gmail.com', 'provider2', 'Southampton', 'provider2', '1', '0');
INSERT INTO `serviceprovider` VALUES ('provider3@gmail.com', 'provider3', 'London', 'provider3', '1', '0');
INSERT INTO `serviceprovider` VALUES ('provider4@gmail.com', 'provider4', 'Southampton', 'provider4', '0', '0');

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
  `avg_score` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`service_id`),
  KEY `FK_provide` (`provider_id`),
  CONSTRAINT `FK_provide` FOREIGN KEY (`provider_id`) REFERENCES `serviceprovider` (`provider_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of services
-- ----------------------------
INSERT INTO `services` VALUES ('1', 'provider1@gmail.com', 'room_cleaning_service', null, '100', 'London', ' weekdays', '1', 'provider1@gmail.com', 'Cleaning', '4');
INSERT INTO `services` VALUES ('2', 'provider1@gmail.com', 'babysitting_service', null, '99', 'Southampton', ' 24/7', '1', 'provider1@gmail.com', 'Baby Sitting', '4');
INSERT INTO `services` VALUES ('3', 'provider2@gmail.com', 'very_good_plumbing', null, '100', 'Southampton', '7/24', '1', 'provider2@gmail.com', 'Plumbing', '0');
INSERT INTO `services` VALUES ('4', 'provider1@gmail.com', 'pest_control_service!', null, '55', 'London', 'weekdays', '1', 'provider1@gmail.com', 'Pest Control', '0');
INSERT INTO `services` VALUES ('5', 'provider2@gmail.com', 'electrical_repairs_magic', null, '80', 'Southampton', '7/24', '1', 'provider2@gmail.com', 'Electrical Repairs', '0');
INSERT INTO `services` VALUES ('6', 'provider1@gmail.com', 'beauty_magic', null, '79', 'London', 'weekdays', '1', 'provider1@gmail.com', 'Beauty', '0');

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
INSERT INTO `users` VALUES ('user2@gmail.com', null, 'user2');
INSERT INTO `users` VALUES ('user3@gmail.com', null, 'user3');
