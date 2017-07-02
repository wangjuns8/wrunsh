-- ----------------------------
-- Table structure for 'user_t'
-- ----------------------------
DROP TABLE IF EXISTS `user_t`;
CREATE TABLE `user_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) NOT NULL COMMENT '”√ªß√˚',
  `password` varchar(255) NOT NULL COMMENT '√‹¬Î',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Records of user_t
-- ----------------------------
INSERT INTO `user_t` VALUES ('1', 'test', '345');
INSERT INTO `user_t` VALUES ('2', 'evan', '123');