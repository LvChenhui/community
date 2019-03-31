SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for community_info_headlines
-- ----------------------------
DROP TABLE IF EXISTS `community_info_headlines`;
CREATE TABLE `community_info_headlines` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL,
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of community_info_headlines
-- ----------------------------

-- ----------------------------
-- Table structure for community_info_img
-- ----------------------------
DROP TABLE IF EXISTS `community_info_img`;
CREATE TABLE `community_info_img` (
  `id` int(11) NOT NULL,
  `image_url` varchar(512) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of community_info_img
-- ----------------------------

-- ----------------------------
-- Table structure for community_label
-- ----------------------------
DROP TABLE IF EXISTS `community_label`;
CREATE TABLE `community_label` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `details` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `posts_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6vml4ba2itmaor84892v92b1f` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of community_label
-- ----------------------------
INSERT INTO `community_label` VALUES ('1', '关于JavaSe的话题', 'JavaSe', '208');
INSERT INTO `community_label` VALUES ('2', '关于Java企业级开发的话题', 'JavaEE', '9');
INSERT INTO `community_label` VALUES ('3', '关于Java虚拟机的话题', 'JVM', '7');
INSERT INTO `community_label` VALUES ('4', '关于Spring框架的话题', 'Spring', '3');
INSERT INTO `community_label` VALUES ('5', '关于Hibernate框架的话题', 'Hibernate', '1');
INSERT INTO `community_label` VALUES ('6', '关于Scala语言的话题', 'Scala', '0');
INSERT INTO `community_label` VALUES ('8', '关于Java并发编程的话题', 'Java并发编程', '1');
INSERT INTO `community_label` VALUES ('9', '关于Android的话题', 'Android', '2');

-- ----------------------------
-- Table structure for community_mi_user
-- ----------------------------
DROP TABLE IF EXISTS `community_mi_user`;
CREATE TABLE `community_mi_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `user_id` varchar(45) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `token` varchar(45) DEFAULT NULL,
  `point` int(11) DEFAULT NULL,
  `signature` text,
  `gender` varchar(2) DEFAULT NULL,
  `image_url` varchar(512) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `revise_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of community_mi_user
-- ----------------------------
INSERT INTO `community_mi_user` VALUES ('2', '2@2.com', 'fc432fdc7eb263609ceb860398cb30de', null, '小甜', null, null, null, '小甜当爸爸了', '女', 'http://localhost:8080/community/image/getImage/2018-03-06/c75c474d-a503-4098-8e9b-8ce65db29a1a.jpeg', '2018-01-01 14:35:23', null);
INSERT INTO `community_mi_user` VALUES ('3', '3@3.com', 'fc432fdc7eb263609ceb860398cb30de', null, '小杰', null, null, null, '小杰喜欢玩神武', '女', 'http://localhost:8080/community/image/getImage/2018-03-06/08b27376-4ce3-45a7-a60a-62ae84606918.jpeg', '2018-02-13 14:35:10', null);
INSERT INTO `community_mi_user` VALUES ('4', '4@4.com', 'fc432fdc7eb263609ceb860398cb30de', null, '小康', null, null, null, '小康爱玩无主之地', '女', 'http://localhost:8080/community/image/getImage/2018-03-06/2a32ac34-db11-46d5-83b2-089f1a432491.jpeg', '2018-03-01 14:35:05', null);
INSERT INTO `community_mi_user` VALUES ('5', '5@5.com', 'fc432fdc7eb263609ceb860398cb30de', null, '弟弟', null, null, null, '弟弟很神秘', '女', 'http://localhost:8080/community/image/getImage/2018-03-06/ea9ee7cd-a2d3-43e3-a424-649fa431f32c.jpeg', '2018-02-27 14:34:55', null);
INSERT INTO `community_mi_user` VALUES ('6', '123@123.com', 'fc432fdc7eb263609ceb860398cb30de', null, '吕某', null, null, null, '自我介绍在这里', '男', 'http://localhost:8080/community/image/getImage/2018-03-06/9e19c459-d12f-4f0f-8723-f6e1f0d5f343.jpeg', '2018-01-31 21:20:20', null);
INSERT INTO `community_mi_user` VALUES ('10', '7@7.com', 'fc432fdc7eb263609ceb860398cb30de', null, '小张', null, null, null, '小张很帅', '男', 'http://localhost:8080/community/image/getImage/2018-01-30/84a5cf75-429d-4ff3-8a18-1363ef12243c.jpeg', '2018-02-03 20:53:50', null);
INSERT INTO `community_mi_user` VALUES ('11', '11@11.com', 'fc432fdc7eb263609ceb860398cb30de', null, '小雷', null, null, null, null, null, 'http://localhost:8080/community/image/getImage/2018-03-06/30946f40-12ee-4950-ad91-2af382c9c760.jpeg', '2018-03-06 14:49:03', null);
INSERT INTO `community_mi_user` VALUES ('12', '12@12.com', 'fc432fdc7eb263609ceb860398cb30de', null, '白富美', null, null, null, null, null, 'http://localhost:8080/community/image/getImage/2018-03-06/b2ee6358-af7f-4d63-a933-3c9121f847da.jpeg', '2018-03-06 14:49:43', null);
INSERT INTO `community_mi_user` VALUES ('13', '13@13.com', 'fc432fdc7eb263609ceb860398cb30de', null, '小赵', null, null, null, null, null, 'http://localhost:8080/community/image/getImage/2018-04-11/31b57fda-17db-4a1d-b60e-9ba3542fb3d8.jpeg', '2018-04-11 16:24:23', null);
INSERT INTO `community_mi_user` VALUES ('14', '14@14.com', 'fc432fdc7eb263609ceb860398cb30de', null, '小刘', null, null, null, null, null, 'http://localhost:8080/community/image/getImage/2018-04-11/d7dabeab-3280-418a-8531-03a65fbdec77.jpeg', '2018-04-11 16:26:33', null);
INSERT INTO `community_mi_user` VALUES ('15', '15@15.com', 'fc432fdc7eb263609ceb860398cb30de', null, '小新', null, null, null, null, null, 'http://localhost:8080/community/image/getImage/2018-04-11/0300bcbc-deb9-4796-adf1-0bf23e59b9a6.jpeg', '2018-04-11 16:28:20', null);
INSERT INTO `community_mi_user` VALUES ('16', '16@16.com', 'fc432fdc7eb263609ceb860398cb30de', null, '小艾', null, null, null, null, null, 'http://localhost:8080/community/image/getImage/2018-04-11/dfef37a7-5d7d-4471-b053-adb158ba7175.jpeg', '2018-04-11 16:28:47', null);
INSERT INTO `community_mi_user` VALUES ('17', '17@17.com', 'fc432fdc7eb263609ceb860398cb30de', null, '小米', null, null, null, null, null, 'http://localhost:8080/community/image/getImage/2018-04-11/5d960b6f-75c4-43a3-a35c-53ed25f1cb29.jpeg', '2018-04-11 16:29:09', null);
INSERT INTO `community_mi_user` VALUES ('18', '18@18.com', 'fc432fdc7eb263609ceb860398cb30de', null, '小锤', null, null, null, null, null, 'http://localhost:8080/community/image/getImage/2018-04-11/83e8a60c-31eb-4a20-8d54-38f2a84870e7.jpeg', '2018-04-11 16:29:31', null);
INSERT INTO `community_mi_user` VALUES ('19', '19@19.com', 'fc432fdc7eb263609ceb860398cb30de', null, '蒋蒋', null, null, null, null, null, 'http://localhost:8080/community/image/getImage/2018-04-11/ba2794b2-c8ea-498e-882d-a8a78f54787c.jpeg', '2018-04-11 16:29:56', null);
INSERT INTO `community_mi_user` VALUES ('20', '20@20.com', 'fc432fdc7eb263609ceb860398cb30de', null, '工藤新一', null, null, null, '工藤新一', null, 'http://localhost:8080/community/image/getImage/2018-04-11/0bbf5454-eb4c-472f-a2d9-3a12978a51ea.jpeg', '2018-04-11 16:34:21', null);
INSERT INTO `community_mi_user` VALUES ('21', '21@21.com', 'fc432fdc7eb263609ceb860398cb30de', null, '小兰', null, null, null, null, null, 'http://localhost:8080/community/image/getImage/2018-04-11/e2c1b74b-12b2-457a-884b-606feb6dc976.jpeg', '2018-04-11 16:34:47', null);
INSERT INTO `community_mi_user` VALUES ('22', '100@100.com', 'fc432fdc7eb263609ceb860398cb30de', null, '答辩', null, null, null, null, null, 'http://localhost:8080/community/image/getImage/2018-04-14/50c60edb-27e4-48fd-b9cc-d96b9b5b2440.jpeg', '2018-04-14 10:21:52', null);
INSERT INTO `community_mi_user` VALUES ('26', '111@111.com', 'fc432fdc7eb263609ceb860398cb30de', null, '吕晨辉', null, null, null, '吕晨辉的自我介绍', '男', 'http://localhost:8080/community/image/getImage/2018-04-19/833fa5f7-cf4c-46a2-85c6-71d0dacde713.jpeg', '2018-04-19 19:52:13', null);

-- ----------------------------
-- Table structure for community_notification
-- ----------------------------
DROP TABLE IF EXISTS `community_notification`;
CREATE TABLE `community_notification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_read` bit(1) DEFAULT NULL,
  `from_user_id` int(11) NOT NULL,
  `posts_id` int(11) NOT NULL,
  `to_user_id` int(11) NOT NULL,
  `init_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKac4wjs0b3992ohkf61jy4ilmj` (`from_user_id`),
  KEY `FKilg05a7ki3vkv7lfjnn57pdw2` (`posts_id`),
  KEY `FKquscxmtiqggsch7w833ywubux` (`to_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of community_notification
-- ----------------------------
INSERT INTO `community_notification` VALUES ('1', '', '2', '3', '6', '2018-02-03 22:35:38');
INSERT INTO `community_notification` VALUES ('24', '', '6', '219', '6', '2018-02-04 20:31:29');
INSERT INTO `community_notification` VALUES ('25', '', '6', '219', '6', '2018-02-04 20:35:07');
INSERT INTO `community_notification` VALUES ('26', '\0', '6', '4', '4', '2018-03-27 09:45:10');
INSERT INTO `community_notification` VALUES ('27', '\0', '6', '221', '11', '2018-03-27 09:45:37');
INSERT INTO `community_notification` VALUES ('28', '', '2', '224', '6', '2018-04-10 18:21:20');
INSERT INTO `community_notification` VALUES ('29', '\0', '22', '227', '3', '2018-04-14 10:23:29');
INSERT INTO `community_notification` VALUES ('30', '\0', '22', '227', '3', '2018-04-14 10:24:54');
INSERT INTO `community_notification` VALUES ('31', '\0', '26', '227', '3', '2018-04-19 19:54:06');
INSERT INTO `community_notification` VALUES ('32', '', '6', '234', '26', '2018-04-19 19:54:56');

-- ----------------------------
-- Table structure for community_nubbin_reply
-- ----------------------------
DROP TABLE IF EXISTS `community_nubbin_reply`;
CREATE TABLE `community_nubbin_reply` (
  `user_id` int(11) NOT NULL,
  `affiliate_talk_id` int(11) NOT NULL,
  `content` text,
  `Fabulous` int(11) DEFAULT '0' COMMENT '点赞',
  `create_time` datetime DEFAULT NULL,
  `revise_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`,`affiliate_talk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of community_nubbin_reply
-- ----------------------------

-- ----------------------------
-- Table structure for community_nubbin_talk
-- ----------------------------
DROP TABLE IF EXISTS `community_nubbin_talk`;
CREATE TABLE `community_nubbin_talk` (
  `talk_id` int(11) NOT NULL,
  `user_id` varchar(45) NOT NULL,
  `title` varchar(20) NOT NULL,
  `content` text,
  `create_time` datetime DEFAULT NULL,
  `revise_time` datetime DEFAULT NULL,
  `Fabulous` int(11) DEFAULT NULL COMMENT '点赞',
  PRIMARY KEY (`talk_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of community_nubbin_talk
-- ----------------------------

-- ----------------------------
-- Table structure for community_post
-- ----------------------------
DROP TABLE IF EXISTS `community_post`;
CREATE TABLE `community_post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text,
  `good` bit(1) NOT NULL,
  `init_time` datetime NOT NULL,
  `label_id` int(11) DEFAULT NULL,
  `reply_count` int(11) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `top` bit(1) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_46eh0lt2x9ftqcv9tjs8meqj8` (`title`),
  KEY `FK41ebsa5jpn18egdtjo6uiaugn` (`user_id`),
  KEY `FKnxd3qh1m3c0o6tc3ojfa8fm6o` (`label_id`),
  CONSTRAINT `FKnxd3qh1m3c0o6tc3ojfa8fm6o` FOREIGN KEY (`label_id`) REFERENCES `community_label` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=235 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of community_post
-- ----------------------------
INSERT INTO `community_post` VALUES ('1', 'hahaha hello world Java', '\0', '2017-08-26 15:33:39', '1', '32', 'Hello World', '\0', '2');
INSERT INTO `community_post` VALUES ('2', 'hahaha hello world Java', '\0', '2017-08-26 15:46:53', '1', '0', 'Hello World Scala', '\0', '2');
INSERT INTO `community_post` VALUES ('3', '<p>测试发布内容</p>', '\0', '2017-08-27 15:13:44', '1', '0', '测试发布', '\0', '2');
INSERT INTO `community_post` VALUES ('4', 'Apache Kylin™是一个开源的分布式分析引擎，提供Hadoop/Spark之上的SQL查询接口及多维分析（OLAP）能力以支持超大规模数据，最初由eBay Inc. 开发并贡献至开源社区。它能在亚秒内查询巨大的Hive表。<img src=\"http://localhost:8080/community/image/getImage/2018-03-27/15c27020-6b4b-461d-8bc6-2fbc0d47ce02.jpeg\" />', '', '2017-08-27 15:49:42', '3', '23', 'APACHE KYLIN', '', '4');
INSERT INTO `community_post` VALUES ('105', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:00', '1', '1', '测试帖子1', '\0', '2');
INSERT INTO `community_post` VALUES ('106', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:00', '1', '0', '测试帖子2', '\0', '2');
INSERT INTO `community_post` VALUES ('107', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:00', '1', '0', '测试帖子3', '\0', '2');
INSERT INTO `community_post` VALUES ('108', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:00', '1', '0', '测试帖子4', '\0', '2');
INSERT INTO `community_post` VALUES ('109', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:00', '1', '0', '测试帖子5', '\0', '2');
INSERT INTO `community_post` VALUES ('110', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:00', '1', '0', '测试帖子6', '\0', '2');
INSERT INTO `community_post` VALUES ('111', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:01', '1', '0', '测试帖子7', '\0', '2');
INSERT INTO `community_post` VALUES ('112', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:01', '1', '0', '测试帖子8', '\0', '2');
INSERT INTO `community_post` VALUES ('113', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:01', '1', '0', '测试帖子9', '\0', '2');
INSERT INTO `community_post` VALUES ('114', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:01', '1', '0', '测试帖子10', '\0', '2');
INSERT INTO `community_post` VALUES ('115', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:01', '1', '0', '测试帖子11', '\0', '2');
INSERT INTO `community_post` VALUES ('116', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:01', '1', '0', '测试帖子12', '\0', '2');
INSERT INTO `community_post` VALUES ('117', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:01', '1', '0', '测试帖子13', '\0', '2');
INSERT INTO `community_post` VALUES ('118', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:01', '1', '0', '测试帖子14', '\0', '2');
INSERT INTO `community_post` VALUES ('119', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:01', '1', '0', '测试帖子15', '\0', '2');
INSERT INTO `community_post` VALUES ('120', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:01', '1', '0', '测试帖子16', '\0', '2');
INSERT INTO `community_post` VALUES ('121', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:01', '1', '0', '测试帖子17', '\0', '2');
INSERT INTO `community_post` VALUES ('122', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:01', '1', '0', '测试帖子18', '\0', '2');
INSERT INTO `community_post` VALUES ('123', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:01', '1', '0', '测试帖子19', '\0', '2');
INSERT INTO `community_post` VALUES ('124', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:01', '1', '0', '测试帖子20', '\0', '2');
INSERT INTO `community_post` VALUES ('125', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:01', '1', '0', '测试帖子21', '\0', '2');
INSERT INTO `community_post` VALUES ('126', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:02', '1', '0', '测试帖子22', '\0', '2');
INSERT INTO `community_post` VALUES ('127', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:02', '1', '0', '测试帖子23', '\0', '2');
INSERT INTO `community_post` VALUES ('128', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:02', '1', '0', '测试帖子24', '\0', '2');
INSERT INTO `community_post` VALUES ('129', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:02', '1', '0', '测试帖子25', '\0', '2');
INSERT INTO `community_post` VALUES ('130', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:02', '1', '0', '测试帖子26', '\0', '2');
INSERT INTO `community_post` VALUES ('131', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:02', '1', '0', '测试帖子27', '\0', '2');
INSERT INTO `community_post` VALUES ('132', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:02', '1', '0', '测试帖子28', '\0', '2');
INSERT INTO `community_post` VALUES ('133', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:02', '1', '0', '测试帖子29', '\0', '2');
INSERT INTO `community_post` VALUES ('134', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:02', '1', '0', '测试帖子30', '\0', '2');
INSERT INTO `community_post` VALUES ('135', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:02', '1', '0', '测试帖子31', '\0', '2');
INSERT INTO `community_post` VALUES ('136', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:02', '1', '0', '测试帖子32', '\0', '2');
INSERT INTO `community_post` VALUES ('137', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:02', '1', '0', '测试帖子33', '\0', '2');
INSERT INTO `community_post` VALUES ('138', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:02', '1', '0', '测试帖子34', '\0', '2');
INSERT INTO `community_post` VALUES ('139', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:02', '1', '0', '测试帖子35', '\0', '2');
INSERT INTO `community_post` VALUES ('140', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:03', '1', '0', '测试帖子36', '\0', '2');
INSERT INTO `community_post` VALUES ('141', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:03', '1', '0', '测试帖子37', '\0', '2');
INSERT INTO `community_post` VALUES ('142', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:03', '1', '0', '测试帖子38', '\0', '2');
INSERT INTO `community_post` VALUES ('143', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:03', '1', '0', '测试帖子39', '\0', '2');
INSERT INTO `community_post` VALUES ('144', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:03', '1', '0', '测试帖子40', '\0', '2');
INSERT INTO `community_post` VALUES ('145', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:03', '1', '0', '测试帖子41', '\0', '2');
INSERT INTO `community_post` VALUES ('146', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:03', '1', '0', '测试帖子42', '\0', '2');
INSERT INTO `community_post` VALUES ('147', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:03', '1', '0', '测试帖子43', '\0', '2');
INSERT INTO `community_post` VALUES ('148', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:03', '1', '0', '测试帖子44', '\0', '2');
INSERT INTO `community_post` VALUES ('149', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:03', '1', '0', '测试帖子45', '\0', '2');
INSERT INTO `community_post` VALUES ('150', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:03', '1', '0', '测试帖子46', '\0', '2');
INSERT INTO `community_post` VALUES ('151', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:03', '1', '0', '测试帖子47', '\0', '2');
INSERT INTO `community_post` VALUES ('152', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:03', '1', '0', '测试帖子48', '\0', '2');
INSERT INTO `community_post` VALUES ('153', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:03', '1', '0', '测试帖子49', '\0', '2');
INSERT INTO `community_post` VALUES ('154', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:03', '1', '0', '测试帖子50', '\0', '2');
INSERT INTO `community_post` VALUES ('155', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:03', '1', '0', '测试帖子51', '\0', '2');
INSERT INTO `community_post` VALUES ('156', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:04', '1', '0', '测试帖子52', '\0', '2');
INSERT INTO `community_post` VALUES ('157', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:04', '1', '0', '测试帖子53', '\0', '2');
INSERT INTO `community_post` VALUES ('158', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:04', '1', '0', '测试帖子54', '\0', '2');
INSERT INTO `community_post` VALUES ('159', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:04', '1', '0', '测试帖子55', '\0', '2');
INSERT INTO `community_post` VALUES ('160', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:04', '1', '0', '测试帖子56', '\0', '2');
INSERT INTO `community_post` VALUES ('161', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:04', '1', '0', '测试帖子57', '\0', '2');
INSERT INTO `community_post` VALUES ('162', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:04', '1', '0', '测试帖子58', '\0', '2');
INSERT INTO `community_post` VALUES ('163', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:04', '1', '0', '测试帖子59', '\0', '2');
INSERT INTO `community_post` VALUES ('164', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:04', '1', '0', '测试帖子60', '\0', '2');
INSERT INTO `community_post` VALUES ('165', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:04', '1', '0', '测试帖子61', '\0', '2');
INSERT INTO `community_post` VALUES ('166', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:04', '1', '0', '测试帖子62', '\0', '2');
INSERT INTO `community_post` VALUES ('167', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:04', '1', '0', '测试帖子63', '\0', '2');
INSERT INTO `community_post` VALUES ('168', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:04', '1', '0', '测试帖子64', '\0', '2');
INSERT INTO `community_post` VALUES ('169', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:04', '1', '0', '测试帖子65', '\0', '2');
INSERT INTO `community_post` VALUES ('170', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:04', '1', '0', '测试帖子66', '\0', '2');
INSERT INTO `community_post` VALUES ('171', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:04', '1', '0', '测试帖子67', '\0', '2');
INSERT INTO `community_post` VALUES ('172', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:04', '1', '0', '测试帖子68', '\0', '2');
INSERT INTO `community_post` VALUES ('173', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:04', '1', '0', '测试帖子69', '\0', '2');
INSERT INTO `community_post` VALUES ('174', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:04', '1', '0', '测试帖子70', '\0', '2');
INSERT INTO `community_post` VALUES ('175', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:05', '1', '0', '测试帖子71', '\0', '2');
INSERT INTO `community_post` VALUES ('176', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:05', '1', '0', '测试帖子72', '\0', '2');
INSERT INTO `community_post` VALUES ('177', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:05', '1', '0', '测试帖子73', '\0', '2');
INSERT INTO `community_post` VALUES ('178', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:05', '1', '0', '测试帖子74', '\0', '2');
INSERT INTO `community_post` VALUES ('179', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:05', '1', '0', '测试帖子75', '\0', '2');
INSERT INTO `community_post` VALUES ('180', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:05', '1', '0', '测试帖子76', '\0', '2');
INSERT INTO `community_post` VALUES ('181', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:05', '1', '0', '测试帖子77', '\0', '2');
INSERT INTO `community_post` VALUES ('182', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:05', '1', '0', '测试帖子78', '\0', '2');
INSERT INTO `community_post` VALUES ('183', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:05', '1', '0', '测试帖子79', '\0', '2');
INSERT INTO `community_post` VALUES ('184', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:05', '1', '0', '测试帖子80', '\0', '2');
INSERT INTO `community_post` VALUES ('185', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:05', '1', '0', '测试帖子81', '\0', '2');
INSERT INTO `community_post` VALUES ('186', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:05', '1', '0', '测试帖子82', '\0', '2');
INSERT INTO `community_post` VALUES ('187', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:05', '1', '0', '测试帖子83', '\0', '2');
INSERT INTO `community_post` VALUES ('188', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:05', '1', '0', '测试帖子84', '\0', '2');
INSERT INTO `community_post` VALUES ('189', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:06', '1', '0', '测试帖子85', '\0', '2');
INSERT INTO `community_post` VALUES ('190', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:06', '1', '0', '测试帖子86', '\0', '2');
INSERT INTO `community_post` VALUES ('191', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:06', '1', '0', '测试帖子87', '\0', '2');
INSERT INTO `community_post` VALUES ('192', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:06', '1', '0', '测试帖子88', '\0', '2');
INSERT INTO `community_post` VALUES ('193', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:06', '1', '0', '测试帖子89', '\0', '2');
INSERT INTO `community_post` VALUES ('194', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:06', '1', '0', '测试帖子90', '\0', '2');
INSERT INTO `community_post` VALUES ('195', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:06', '1', '0', '测试帖子91', '\0', '2');
INSERT INTO `community_post` VALUES ('196', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:06', '1', '0', '测试帖子92', '\0', '2');
INSERT INTO `community_post` VALUES ('197', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:06', '1', '0', '测试帖子93', '\0', '2');
INSERT INTO `community_post` VALUES ('198', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:06', '1', '0', '测试帖子94', '\0', '2');
INSERT INTO `community_post` VALUES ('199', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:06', '1', '0', '测试帖子95', '\0', '2');
INSERT INTO `community_post` VALUES ('200', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:06', '1', '0', '测试帖子96', '\0', '2');
INSERT INTO `community_post` VALUES ('201', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:06', '1', '0', '测试帖子97', '\0', '2');
INSERT INTO `community_post` VALUES ('202', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:06', '1', '0', '测试帖子98', '\0', '2');
INSERT INTO `community_post` VALUES ('203', 'hahahahahahahahahaha', '\0', '2017-08-28 16:03:06', '1', '0', '测试帖子99', '\0', '2');
INSERT INTO `community_post` VALUES ('205', '<p>&lt;dependency&gt;</p><p><span>			</span>&lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;</p><p><span>			</span>&lt;artifactId&gt;spring-boot-starter-thymeleaf&lt;/artifactId&gt;</p><p>&lt;/dependency&gt;</p>', '', '2017-08-28 21:52:55', '4', '1', '在Spring boot中配置Thymeleaf', '\0', '2');
INSERT INTO `community_post` VALUES ('206', ' 在java应用程序开发中，只有被java虚拟机装载的Class类型才能在程序中使用。只要生成的字节码符合java虚拟机的指令集和文件格式，就可以在JVM上运行，这为java的跨平台性提供条件。\r\n\r\n 字节码文件的装载过程：加载 、  连接（包括三个步骤：验证  准备   解析）  、初始化，如图所示<img src=\"http://localhost:8080/community/image/getImage/2018-04-11/c0d819d0-3efb-41cc-b7ec-14b65ac31852.png\" />', '', '2017-08-28 22:46:59', '3', '1', 'Class文件装载流程', '\0', '2');
INSERT INTO `community_post` VALUES ('208', 'JVM是Java Virtual Machine（Java虚拟机）的缩写，JVM是一种用于计算设备的规范，它是一个虚构出来的计算机，是通过在实际的计算机上仿真模拟各种计算机功能来实现的。\r\nJava语言的一个非常重要的特点就是与平台的无关性。而使用Java虚拟机是实现这一特点的关键。一般的高级语言如果要在不同的平台上运行，至少需要编译成不同的目标代码。而引入Java语言虚拟机后，Java语言在不同平台上运行时不需要重新编译。Java语言使用Java虚拟机屏蔽了与具体平台相关的信息，使得Java语言编译程序只需生成在Java虚拟机上运行的目标代码（字节码），就可以在多种平台上不加修改地运行。Java虚拟机在执行字节码时，把字节码解释成具体平台上的机器指令执行。这就是Java的能够“一次编译，到处运行”的原因。', '', '2017-09-01 22:01:27', '3', '2', 'JVM', '', '2');
INSERT INTO `community_post` VALUES ('209', '<img src=\"http://localhost:8080/community/layui/images/face/11.gif\" alt=\"[爱你]\">', '\0', '2017-09-03 11:05:25', '5', '2', '探索R闪背后的奥秘', '\0', '6');
INSERT INTO `community_post` VALUES ('210', '<p><span lang=\"EN-US\">filterChainDefinitionMap.put(</span><span lang=\"EN-US\">\"/favicon.ico\"</span><span lang=\"EN-US\">,</span><span lang=\"EN-US\">\"anon\"</span><span lang=\"EN-US\">)</span><span lang=\"EN-US\">;</span><span lang=\"EN-US\">//</span><span>解决弹出</span><span lang=\"EN-US\">favicon.ico</span><span>下载</span></p><p><span><img src=\"http://127.0.0.1/images/upload/2017-09-03/ec32b602-f818-4258-86bc-ac247e0c48ec.jpeg\" alt=\"null\"><br></span></p>', '\0', '2017-09-03 11:07:21', '2', '4', 'shiro在登录的时候下载favicon.ico问题', '\0', '6');
INSERT INTO `community_post` VALUES ('211', '框架简介<br/>\r\nemsite框架是众多是基于众多优秀的开源项目，高度整合封装而成的高效，高性能，强安全性的开源Java EE分布式全自动快速开发框架平台。 本项目参照jeesite、springside、jeesz等框架思想实现并从此不再兼容jeesite所有版本。\r\nemsite目前包括以下三大模块，系统管理（SYS）模块、内容管理（CMS）模块、代码生成（GEN）模块。系统管理模块，包括组织架构（用户 管理、机构管理、区域管理）、菜单管理、角色权限管理、字典管理等功能； 内容管理模块 ，包括内容管理（文章、链接），栏目管理、站点 管理、公共留言、文件管理、前端网站展示等功能；代码生成模块，完成重复的工作。<img src=\"http://localhost:8080/community/image/getImage/2018-04-11/a8b2d05f-1afc-445c-afbb-653f5baddb79.png\"/>', '\0', '2017-09-05 10:38:27', '9', '1', 'emsite 全自动分布式开源框架发布 2.0.0 版本', '\0', '3');
INSERT INTO `community_post` VALUES ('212', '<img src=\"http://localhost:8080/community/layui/images/face/51.gif\" alt=\"[兔子]\">', '\0', '2017-09-05 10:38:59', '9', '4', '新人报到', '\0', '3');
INSERT INTO `community_post` VALUES ('213', '<p><span lang=\"EN-US\">1 </span><span>先来先服务<span lang=\"EN-US\"> - </span>时间片轮转调度<span lang=\"EN-US\"><br>\n</span>这个很简单，就是谁先来，就给谁分配时间片运行，缺点是有些紧急的任务要很久才能得到运行。</span><span lang=\"EN-US\"><o:p></o:p></span></p><p><span lang=\"EN-US\">2.&nbsp;</span><span>优先级调度<span lang=\"EN-US\"><br>\n</span>每个线程有一个优先级，<span lang=\"EN-US\">CPU</span>每次去拿优先级高的运行，优先级低的等等，为了避免优先级低的等太久，每等一定时间，就给优先级低的线程提高一个级别</span><span lang=\"EN-US\"><o:p></o:p></span></p><p><span lang=\"EN-US\">3.</span><span>最短作业优先<span lang=\"EN-US\"><br>\n</span>把线程任务量排序，每次拿处理时间短的线程运行，就像我去银行办业务一样，我的事情很快就处理完了，所以让我插队先办完，后面时间长的人先等等，时间长的人就很难得到响应了。</span><span lang=\"EN-US\"><o:p></o:p></span></p><p><span lang=\"EN-US\">4.&nbsp;</span><span>最高响应比优先<span lang=\"EN-US\"><br>\n</span>用线程的等待时间除以服务时间，得到响应比，响应比小的优先运行。这样不会造成某些任务一直得不到响应。</span><span lang=\"EN-US\"><o:p></o:p></span></p><p>\n\n\n\n\n\n\n\n</p><p><span lang=\"EN-US\">5.</span><span>多级反馈队列调度<span lang=\"EN-US\"><br>\n</span>有多个优先级不同的队列，每个队列里面有多个等待线程。<span lang=\"EN-US\"><br>\nCPU</span>每次从优先级高的遍历到低的，取队首的线程运行，运行完了放回队尾，优先级越高，时间片越短，即响应越快，时间片大小就不是固定的了。<span lang=\"EN-US\"><br>\n</span>每个队列的内部还是用先来先服务的策略。</span><span lang=\"EN-US\"><o:p></o:p></span></p>', '\0', '2017-09-07 10:21:06', '8', '6', '并发的CPU调度策略', '\0', '2');
INSERT INTO `community_post` VALUES ('214', '123123', '\0', '2018-01-21 14:50:24', '2', '0', '123123123123', '\0', '5');
INSERT INTO `community_post` VALUES ('215', '<u>1<b>23123</b></u>', '\0', '2018-01-21 14:52:28', '2', '0', 'testtest', '\0', '5');
INSERT INTO `community_post` VALUES ('216', '<img src=\"http://localhost:8080/community/layui/images/face/39.gif\" alt=\"[鼓掌]\">', '\0', '2018-01-21 14:57:26', '1', '0', '[鼓掌]', '\0', '2');
INSERT INTO `community_post` VALUES ('217', '啊实打实大所大所大', '\0', '2018-02-03 16:58:35', '4', '0', '大神快来到静安寺路口到静安寺asdasd', '\0', '6');
INSERT INTO `community_post` VALUES ('218', 'testsetsetsetsetset', '\0', '2018-02-03 19:37:28', '1', '0', 'test', '\0', '6');
INSERT INTO `community_post` VALUES ('219', '111111111111111111111111111111111', '\0', '2018-02-04 20:31:15', '3', '3', '111111111111111111111111111', '\0', '6');
INSERT INTO `community_post` VALUES ('220', '就是这样啊<img src=\"http://localhost:8080/community/image/getImage/2018-03-06/78bda7e2-0b48-4049-a848-0844578ed996.jpeg\" alt=\"undefined\">', '\0', '2018-03-06 14:25:34', '3', '1', '整体测试', '\0', '6');
INSERT INTO `community_post` VALUES ('221', '小雷登场', '\0', '2018-03-06 14:47:28', '1', '1', '小雷驾到', '\0', '11');
INSERT INTO `community_post` VALUES ('222', '<p>新新新新新新</p>', '\0', '2018-03-27 10:28:02', '1', '0', '新帖1--3月27日', '\0', '6');
INSERT INTO `community_post` VALUES ('223', '<p>新新新新新新新新新</p>', '\0', '2018-03-27 10:28:27', '3', '2', '新帖2--10月27日', '\0', '6');
INSERT INTO `community_post` VALUES ('224', '测试查看', '\0', '2018-04-10 16:35:57', '2', '1', '测试查看用例', '\0', '6');
INSERT INTO `community_post` VALUES ('225', '<p style=\"text-align: left;\"><b><i>Spring Cloud</i></b>是一系列框架的有序集合。它利用Spring Boot的开发便利性巧妙地简化了分布式系统基础设施的开发，如服务发现注册、配置中心、消息总线、负载均衡、断路器、数据监控等，都可以用Spring Boot的开发风格做到一键启动和部署。Spring并没有重复制造轮子，它只是将目前各家公司开发的比较成熟、经得起实际考验的服务框架组合起来，通过Spring Boot风格进行再封装屏蔽掉了复杂的配置和实现原理，最终给开发者留出了一套简单易懂、易部署和易维护的分布式系统开发工具包。</p><p><b><i>微服务</i></b>是可以独立部署、水平扩展、独立访问（或者有独立的数据库）的服务单元，springcloud就是这些微服务的大管家，采用了微服务这种架构之后，项目的数量会非常多，springcloud做为大管家需要管理好这些微服务，自然需要很多小弟来帮忙。</p><p>主要的小弟有：Spring Cloud Config、Spring Cloud Netflix（Eureka、Hystrix、Zuul、Archaius…）、Spring Cloud Bus、Spring Cloud for Cloud Foundry、Spring Cloud Cluster、Spring Cloud Consul、Spring Cloud Security、Spring Cloud Sleuth、Spring Cloud Data Flow、Spring Cloud Stream、Spring Cloud Task、Spring Cloud Zookeeper、Spring Cloud Connectors、Spring Cloud Starters、Spring Cloud CLI</p><p><img src=\"http://localhost:8080/community/image/getImage/2018-04-11/2ed7257a-96f8-4ef7-ba3b-69b2295701a9.png\" alt=\"undefined\"><br></p>', '\0', '2018-04-11 16:11:33', '2', '2', 'SpringCloud', '\0', '3');
INSERT INTO `community_post` VALUES ('226', '<p>服务中心又称注册中心，管理各种服务功能包括服务的注册、发现、熔断、负载、降级等，比如dubbo admin后台的各种功能。</p><p>有了服务中心调用关系会有什么变化，画几个简图来帮忙理解</p><p>项目A调用项目B</p><p>正常调用项目A请求项目B</p><p><img src=\"http://localhost:8080/community/image/getImage/2018-04-11/9d3bfd89-4b96-44e2-afc1-ddc5b62ec52b.png\" alt=\"undefined\"><br></p><p><span>有了服务中心之后，任何一个服务都不能直接去掉用，都需要通过服务中心来调用</span></p><p><span><img src=\"http://localhost:8080/community/image/getImage/2018-04-11/04c79d25-f287-4e55-b2b4-1dcdfd2d6ed1.png\" alt=\"undefined\"><br></span></p><p><span>项目A调用项目B，项目B在调用项目C</span></p><p><span><img src=\"http://localhost:8080/community/image/getImage/2018-04-11/b4a17e9a-cc00-4e5d-aea6-7407fa2be8e2.png\" alt=\"undefined\"><br></span></p><p><span>这时候调用的步骤就会为两步：第一步，项目A首先从服务中心请求项目B服务器，然后项目B在从服务中心请求项目C服务。</span></p><p><span><img src=\"http://localhost:8080/community/image/getImage/2018-04-11/be65d9fe-288d-4d17-b847-f61f24ca8315.png\" alt=\"undefined\"><br></span></p><p>上面的项目只是两三个相互之间的简单调用，但是如果项目超过20个30个呢，在15年底的时候我司分布式的项目就达到了二十几个，画一张图来描述几十个项目之间的相互调用关系全是线条，任何其中的一个项目改动，就会牵连好几个项目跟着重启，巨麻烦而且容易出错。通过服务中心来获取服务你不需要关注你调用的项目IP地址，由几台服务器组成，每次直接去服务中心获取可以使用的服务去调用既可。</p><p>由于各种服务都注册到了服务中心，就有了去做很多高级功能条件。比如几台服务提供相同服务来做均衡负载；监控服务器调用成功率来做熔断，移除服务列表中的故障点；监控服务调用时间来对不同的服务器设置不同的权重等等。</p>', '', '2018-04-11 16:17:47', '2', '0', '注册中心Eureka', '\0', '3');
INSERT INTO `community_post` VALUES ('227', '<h2 id=\"熔断器\">熔断器</h2><h3 id=\"雪崩效应\">雪崩效应</h3><p>在微服务架构中通常会有多个服务层调用，基础服务的故障可能会导致级联故障，进而造成整个系统不可用的情况，这种现象被称为服务雪崩效应。服务雪崩效应是一种因“服务提供者”的不可用导致“服务消费者”的不可用,并将不可用逐渐放大的过程。</p><p>如果下图所示：A作为服务提供者，B为A的服务消费者，C和D是B的服务消费者。A不可用引起了B的不可用，并将不可用像滚雪球一样放大到C和D时，雪崩效应就形成了。</p><p><img src=\"http://localhost:8080/community/image/getImage/2018-04-11/78d8b99e-192e-4504-a8f3-c64cf53b5c4b.png\" alt=\"undefined\"></p><h3 id=\"熔断器circuitbreaker\">熔断器（CircuitBreaker）</h3><p>熔断器的原理很简单，如同电力过载保护器。它可以实现快速失败，如果它在一段时间内侦测到许多类似的错误，会强迫其以后的多个调用快速失败，不再访问远程服务器，从而防止应用程序不断地尝试执行可能会失败的操作，使得应用程序继续执行而不用等待修正错误，或者浪费CPU时间去等到长时间的超时产生。熔断器也可以使应用程序能够诊断错误是否已经修正，如果已经修正，应用程序会再次尝试调用操作。</p><p>熔断器模式就像是那些容易导致错误的操作的一种代理。这种代理能够记录最近调用发生错误的次数，然后决定使用允许操作继续，或者立即返回错误。 熔断器开关相互转换的逻辑如下图：</p><p><img src=\"http://localhost:8080/community/image/getImage/2018-04-11/5a0453fb-7481-4c48-86aa-7cfe30754143.png\" alt=\"undefined\"></p><p><span>熔断器就是保护服务高可用的最后一道防线。</span></p>', '', '2018-04-11 16:21:03', '2', '4', '熔断器Hystrix', '\0', '3');
INSERT INTO `community_post` VALUES ('228', '作品答辩测试<a target=\"_self\" href=\"http://www.baidu.com\">http://www.baidu.com</a>', '\0', '2018-04-14 08:26:08', '1', '0', '测试', '\0', '6');
INSERT INTO `community_post` VALUES ('229', '<p>帖子内容</p><p><img src=\"http://localhost:8080/community/image/getImage/2018-04-14/dcf6ea8a-041a-4a57-8eaf-419bb3625ab9.jpeg\" alt=\"undefined\"><br></p>', '\0', '2018-04-14 10:25:37', '3', '0', '答辩测试出帖子', '\0', '22');
INSERT INTO `community_post` VALUES ('234', '<p>吕晨辉的第一个帖子<img src=\"http://localhost:8080/community/image/getImage/2018-04-19/ab21365f-ebbb-4201-9d7a-660178473585.jpeg\" alt=\"undefined\"></p>', '\0', '2018-04-19 19:53:25', '2', '2', '吕晨辉的第一个帖子', '\0', '26');

-- ----------------------------
-- Table structure for community_reply
-- ----------------------------
DROP TABLE IF EXISTS `community_reply`;
CREATE TABLE `community_reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `init_time` datetime DEFAULT NULL,
  `up` int(11) unsigned zerofill NOT NULL,
  `posts_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnr6a7xtk9rm31ptn6gchi9113` (`posts_id`),
  KEY `FKnt12hb9oqfm5eamjpg27bkpvv` (`user_id`),
  CONSTRAINT `FKnr6a7xtk9rm31ptn6gchi9113` FOREIGN KEY (`posts_id`) REFERENCES `community_post` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of community_reply
-- ----------------------------
INSERT INTO `community_reply` VALUES ('1', '回复在这里', '2017-08-29 10:17:39', '00000000012', '1', '2');
INSERT INTO `community_reply` VALUES ('2', '回复', '2017-08-29 10:35:46', '00000000000', '1', '5');
INSERT INTO `community_reply` VALUES ('3', '测试回复1', '2017-08-29 11:36:08', '00000000000', '1', '2');
INSERT INTO `community_reply` VALUES ('4', '测试回复2', '2017-08-29 11:36:08', '00000000000', '1', '2');
INSERT INTO `community_reply` VALUES ('5', '测试回复3', '2017-08-29 11:36:08', '00000000000', '1', '2');
INSERT INTO `community_reply` VALUES ('8', '测试回复6', '2017-08-29 11:36:08', '00000000000', '1', '2');
INSERT INTO `community_reply` VALUES ('9', '测试回复7', '2017-08-29 11:36:08', '00000000000', '1', '2');
INSERT INTO `community_reply` VALUES ('10', '测试回复8', '2017-08-29 11:36:08', '00000000000', '1', '2');
INSERT INTO `community_reply` VALUES ('11', '测试回复9', '2017-08-29 11:36:08', '00000000000', '1', '2');
INSERT INTO `community_reply` VALUES ('12', '测试回复10', '2017-08-29 11:36:08', '00000000000', '1', '2');
INSERT INTO `community_reply` VALUES ('13', '测试回复11', '2017-08-29 11:36:08', '00000000000', '1', '2');
INSERT INTO `community_reply` VALUES ('14', '测试回复12', '2017-08-29 11:36:08', '00000000000', '1', '2');
INSERT INTO `community_reply` VALUES ('15', '测试回复13', '2017-08-29 11:36:09', '00000000000', '1', '2');
INSERT INTO `community_reply` VALUES ('17', '测试回复15', '2017-08-29 11:36:09', '00000000000', '1', '2');
INSERT INTO `community_reply` VALUES ('18', '测试回复16', '2017-08-29 11:36:09', '00000000000', '1', '2');
INSERT INTO `community_reply` VALUES ('19', '测试回复17', '2017-08-29 11:36:09', '00000000000', '1', '2');
INSERT INTO `community_reply` VALUES ('20', '测试回复18', '2017-08-29 11:36:09', '00000000000', '1', '2');
INSERT INTO `community_reply` VALUES ('21', '测试回复19', '2017-08-29 11:36:09', '00000000000', '1', '2');
INSERT INTO `community_reply` VALUES ('22', '测试回复20', '2017-08-29 11:36:09', '00000000000', '1', '2');
INSERT INTO `community_reply` VALUES ('23', '测试回复21', '2017-08-29 11:36:09', '00000000000', '1', '2');
INSERT INTO `community_reply` VALUES ('24', '测试回复22', '2017-08-29 11:36:09', '00000000000', '1', '2');
INSERT INTO `community_reply` VALUES ('25', '测试回复23', '2017-08-29 11:36:09', '00000000000', '1', '2');
INSERT INTO `community_reply` VALUES ('26', '测试回复24', '2017-08-29 11:36:09', '00000000000', '1', '2');
INSERT INTO `community_reply` VALUES ('27', '测试回复25', '2017-08-29 11:36:09', '00000000000', '1', '2');
INSERT INTO `community_reply` VALUES ('28', '测试回复26', '2017-08-29 11:36:09', '00000000000', '1', '2');
INSERT INTO `community_reply` VALUES ('29', '测试回复27', '2017-08-29 11:36:09', '00000000000', '1', '2');
INSERT INTO `community_reply` VALUES ('30', '测试回复28', '2017-08-29 11:36:09', '00000000000', '1', '2');
INSERT INTO `community_reply` VALUES ('31', '测试回复29', '2017-08-29 11:36:09', '00000000000', '1', '2');
INSERT INTO `community_reply` VALUES ('32', '测试回复30', '2017-08-29 11:36:09', '00000000000', '1', '2');
INSERT INTO `community_reply` VALUES ('33', '我就试试', '2017-08-30 22:39:07', '00000000000', '4', '2');
INSERT INTO `community_reply` VALUES ('34', '我就试试', '2017-08-30 22:42:07', '00000000000', '4', '2');
INSERT INTO `community_reply` VALUES ('35', '希鲁鲁', '2017-08-30 22:42:38', '00000000000', '4', '2');
INSERT INTO `community_reply` VALUES ('36', '测试', '2017-08-30 22:44:50', '00000000000', '105', '2');
INSERT INTO `community_reply` VALUES ('37', '不错啊不错哇', '2017-08-30 22:45:31', '00000000000', '4', '2');
INSERT INTO `community_reply` VALUES ('38', '不错啊不错哇', '2017-08-30 22:47:36', '00000000000', '206', '2');
INSERT INTO `community_reply` VALUES ('39', '好剧，谢谢推荐<img src=\"http://localhost:8080/community/layui/images/face/47.gif\" alt=\"[心]\">', '2017-08-30 23:20:37', '00000000000', '4', '2');
INSERT INTO `community_reply` VALUES ('40', '<p>垃圾哥乱入</p>', '2017-08-30 23:25:33', '00000000000', '4', '2');
INSERT INTO `community_reply` VALUES ('41', '不错', '2017-08-30 23:26:34', '00000000000', '4', '2');
INSERT INTO `community_reply` VALUES ('42', '哈哈', '2017-08-30 23:27:55', '00000000000', '4', '2');
INSERT INTO `community_reply` VALUES ('43', '铁打的父母流水的孩子~<img src=\"http://localhost:8080/community/layui/images/face/8.gif\" alt=\"[挤眼]\">', '2017-08-30 23:29:51', '00000000000', '4', '2');
INSERT INTO `community_reply` VALUES ('44', '<p><img src=\"http://localhost:8080/community/layui/images/face/16.gif\" alt=\"[太开心]\"><img src=\"http://localhost:8080/community/layui/images/face/16.gif\" alt=\"[太开心]\"><img src=\"http://localhost:8080/community/layui/images/face/16.gif\" alt=\"[太开心]\"><img src=\"http://localhost:8080/community/layui/images/face/16.gif\" alt=\"[太开心]\">好看</p>', '2017-08-31 14:57:03', '00000000000', '4', '2');
INSERT INTO `community_reply` VALUES ('45', '好好好', '2017-08-31 15:05:10', '00000000000', '4', '2');
INSERT INTO `community_reply` VALUES ('46', '牛逼<img src=\"http://localhost:8080/community/layui/images/face/0.gif\" alt=\"[微笑]\">', '2017-08-31 15:35:15', '00000000000', '4', '2');
INSERT INTO `community_reply` VALUES ('47', '不错，很清晰<img src=\"http://localhost:8080/community/layui/images/face/49.gif\" alt=\"[猪头]\">', '2017-09-01 22:01:43', '00000000000', '208', '2');
INSERT INTO `community_reply` VALUES ('48', '厉害啊<img src=\"http://localhost:8080/community/layui/images/face/36.gif\" alt=\"[酷]\">', '2017-09-03 11:32:23', '00000000000', '210', '2');
INSERT INTO `community_reply` VALUES ('49', '<img src=\"http://localhost:8080/community/layui/images/face/26.gif\" alt=\"[怒]\">', '2017-09-05 10:26:14', '00000000000', '209', '2');
INSERT INTO `community_reply` VALUES ('50', '有意思', '2017-09-05 10:32:42', '00000000000', '210', '72');
INSERT INTO `community_reply` VALUES ('51', '很清晰<img src=\"http://localhost:8080/community/layui/images/face/11.gif\" alt=\"[爱你]\">', '2017-09-05 10:39:18', '00000000000', '211', '2');
INSERT INTO `community_reply` VALUES ('52', '?', '2017-09-06 15:43:18', '00000000000', '212', '2');
INSERT INTO `community_reply` VALUES ('53', '不错嘛', '2017-09-06 15:45:58', '00000000000', '205', '2');
INSERT INTO `community_reply` VALUES ('54', '新人爆照<img src=\"http://localhost:8080/community/layui/images/face/30.gif\" alt=\"[思考]\">', '2017-09-06 16:27:28', '00000000000', '212', '2');
INSERT INTO `community_reply` VALUES ('55', '希鲁鲁鲁<img src=\"http://localhost:8080/community/layui/images/face/36.gif\" alt=\"[酷]\">', '2017-09-06 16:36:25', '00000000000', '212', '10');
INSERT INTO `community_reply` VALUES ('56', '希鲁鲁鲁<img src=\"http://localhost:8080/community/layui/images/face/36.gif\" alt=\"[酷]\">', '2017-09-06 16:36:26', '00000000000', '212', '10');
INSERT INTO `community_reply` VALUES ('57', '不错嘛<br>', '2017-09-06 20:22:16', '00000000000', '4', '10');
INSERT INTO `community_reply` VALUES ('58', '对啊', '2017-09-06 20:28:36', '00000000000', '210', '2');
INSERT INTO `community_reply` VALUES ('59', '不错', '2017-09-06 20:36:17', '00000000000', '4', '2');
INSERT INTO `community_reply` VALUES ('60', '居然自问自答，呵呵<br>', '2017-09-06 20:36:32', '00000000000', '4', '10');
INSERT INTO `community_reply` VALUES ('61', '再看看自问自答是否修复了', '2017-09-06 20:41:01', '00000000000', '4', '2');
INSERT INTO `community_reply` VALUES ('62', '很强势啊，试试推送功能', '2017-09-06 20:41:42', '00000000000', '208', '10');
INSERT INTO `community_reply` VALUES ('63', '测试推送？<img src=\"http://localhost:8080/community/layui/images/face/0.gif\" alt=\"[微笑]\">', '2017-09-07 10:03:03', '00000000000', '210', '2');
INSERT INTO `community_reply` VALUES ('64', '很实用<br>', '2017-09-07 10:21:23', '00000000000', '213', '10');
INSERT INTO `community_reply` VALUES ('65', '简直无解<img src=\"http://localhost:8082/layui/images/face/16.gif\" alt=\"[太开心]\"><img src=\"http://localhost:8082/layui/images/face/16.gif\" alt=\"[太开心]\"><img src=\"http://localhost:8082/layui/images/face/25.gif\" alt=\"[抱抱]\">', '2017-09-07 10:21:47', '00000000000', '213', '10');
INSERT INTO `community_reply` VALUES ('66', '很好', '2017-09-07 10:22:19', '00000000000', '213', '10');
INSERT INTO `community_reply` VALUES ('67', '测试推送', '2017-09-07 10:24:43', '00000000000', '213', '10');
INSERT INTO `community_reply` VALUES ('68', '测试测试测试', '2017-09-07 10:25:30', '00000000000', '213', '10');
INSERT INTO `community_reply` VALUES ('69', '测试推送', '2017-09-07 10:27:51', '00000000000', '213', '10');
INSERT INTO `community_reply` VALUES ('70', '<img src=\"http://localhost:8082/layui/images/face/42.gif\" alt=\"[抓狂]\">', '2017-09-07 10:39:33', '00000000000', '209', '2');
INSERT INTO `community_reply` VALUES ('71', '测试推送<br>', '2017-09-07 11:02:23', '00000000000', '4', '10');
INSERT INTO `community_reply` VALUES ('72', '测试推送', '2017-09-07 11:04:15', '00000000000', '4', '10');
INSERT INTO `community_reply` VALUES ('73', '测试推送<br>', '2017-09-07 11:12:22', '00000000000', '4', '10');
INSERT INTO `community_reply` VALUES ('74', '我再测试推送', '2017-09-07 11:18:50', '00000000000', '4', '10');
INSERT INTO `community_reply` VALUES ('75', '最后一次测试推送了', '2017-09-07 11:19:01', '00000000000', '4', '10');
INSERT INTO `community_reply` VALUES ('76', '真.最后一次测试了', '2017-09-07 11:22:23', '00000000000', '4', '10');
INSERT INTO `community_reply` VALUES ('77', '好像成功了啊！！！！<img src=\"http://localhost:8080/community/layui/images/face/0.gif\" alt=\"[微笑]\">', '2018-02-02 16:01:21', '00000000000', '1', '6');
INSERT INTO `community_reply` VALUES ('78', '最后试一次！！<img src=\"http://localhost:8080/community/layui/images/face/0.gif\" alt=\"[微笑]\">', '2018-02-02 16:04:55', '00000000000', '1', '6');
INSERT INTO `community_reply` VALUES ('79', '1111111111111111111111111111111111', '2018-02-04 20:31:29', '00000000000', '219', '6');
INSERT INTO `community_reply` VALUES ('80', '222222222222222222222', '2018-02-04 20:35:07', '00000000000', '219', '6');
INSERT INTO `community_reply` VALUES ('81', '33333333333333333333333333', '2018-02-04 20:36:15', '00000000000', '219', '6');
INSERT INTO `community_reply` VALUES ('82', '111111', '2018-03-06 14:25:57', '00000000000', '220', '6');
INSERT INTO `community_reply` VALUES ('83', '<img src=\"http://localhost:8080/community/layui/images/face/0.gif\" alt=\"[微笑]\">', '2018-03-27 09:45:10', '00000000000', '4', '6');
INSERT INTO `community_reply` VALUES ('84', '123<img src=\"http://localhost:8080/community/layui/images/face/0.gif\" alt=\"[微笑]\">', '2018-03-27 09:45:37', '00000000000', '221', '6');
INSERT INTO `community_reply` VALUES ('85', '123', '2018-04-10 16:35:23', '00000000000', '223', '6');
INSERT INTO `community_reply` VALUES ('86', 'test', '2018-04-10 18:19:51', '00000000000', '223', '6');
INSERT INTO `community_reply` VALUES ('87', '没错', '2018-04-10 18:21:20', '00000000000', '224', '2');
INSERT INTO `community_reply` VALUES ('88', '赞<img src=\"http://localhost:8080/community/layui/images/face/47.gif\" alt=\"[心]\">', '2018-04-11 16:12:06', '00000000000', '225', '3');
INSERT INTO `community_reply` VALUES ('89', '顶一个', '2018-04-11 16:12:19', '00000000000', '225', '3');
INSERT INTO `community_reply` VALUES ('90', '很不粗！<img src=\"http://localhost:8080/community/layui/images/face/51.gif\" alt=\"[兔子]\">', '2018-04-11 16:21:32', '00000000000', '227', '3');
INSERT INTO `community_reply` VALUES ('91', '<b>回复</b>', '2018-04-14 10:23:29', '00000000000', '227', '22');
INSERT INTO `community_reply` VALUES ('92', '<img src=\"http://localhost:8080/community/image/getImage/2018-04-14/6ec12b9d-0023-4322-87ab-615b36810aa6.png\" alt=\"undefined\">', '2018-04-14 10:24:54', '00000000000', '227', '22');
INSERT INTO `community_reply` VALUES ('93', '顶一个！<img src=\"http://localhost:8080/community/layui/images/face/0.gif\" alt=\"[微笑]\">', '2018-04-19 19:53:36', '00000000000', '234', '26');
INSERT INTO `community_reply` VALUES ('94', '很赞', '2018-04-19 19:54:06', '00000000000', '227', '26');
INSERT INTO `community_reply` VALUES ('95', '你好新人<img alt=\"undefined\" src=\"http://localhost:8080/community/image/getImage/2018-04-19/c3322e4f-b2c0-4414-bceb-501e43c339b6.jpeg\"><img alt=\"[熊猫]\" src=\"http://localhost:8080/community/layui/images/face/50.gif\">', '2018-04-19 19:54:56', '00000000000', '234', '6');
