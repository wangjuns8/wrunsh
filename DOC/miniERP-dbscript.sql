-- ----------------------------
-- Table structure for 't_user_info'
-- ----------------------------
DROP TABLE IF EXISTS `t_user_info`;
CREATE TABLE `t_user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';


-- ----------------------------
-- Records of t_user_info
-- test/345；evan/123
-- ----------------------------
INSERT INTO `t_user_info` VALUES ('1', 'test', 'd81f9c1be2e08964bf9f24b15f0e4900');
INSERT INTO `t_user_info` VALUES ('2', 'evan', '202cb962ac59075b964b07152d234b70');

-- ----------------------------
-- Table structure for 't_table_name'
-- ----------------------------
DROP TABLE IF EXISTS `t_table_name`;
CREATE TABLE `t_table_name` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `table_name` varchar(40) NOT NULL COMMENT '表名/文件名',
  `real_table_name` varchar(64) NOT NULL COMMENT 'DB对应的真实表名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tablenameunique` (`table_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户创建的表名';

-- ----------------------------
-- Table structure for 't_title_name'
-- ----------------------------
DROP TABLE IF EXISTS `t_title_name`;
CREATE TABLE `t_title_name` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `table_id` int(11) NOT NULL COMMENT 'DB对应的表id',
  `title_name` varchar(40) NOT NULL COMMENT '字段名/列名',
  `column_name` varchar(64) NOT NULL COMMENT 'DB对应的真实列名',
  `indx` int(11) NOT NULL COMMENT 'column的排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户创建的列名';


delete * from t_table_name;
delete * from t_title_name;


create table `${realTableName}`(
	    `id` int(11) NOT NULL AUTO_INCREMENT,
	    <foreach collection="newColumns" index="index" item="item">
		`${item.columnName}` varchar(1000) COMMENT #{item.titleName},
		</foreach>
	    PRIMARY KEY (`id`)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT #{tableName};

	
INSERT INTO `${realTableName}` VALUES 
<foreach collection="dataDataList" index="index" item="item" open="('" separator="','" close="');">
    ${item}
</foreach>






