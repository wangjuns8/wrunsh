-- ----------------------------
-- Table structure for 't_user_info'
-- ----------------------------
DROP TABLE IF EXISTS `t_user_info`;
CREATE TABLE `t_user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) NOT NULL COMMENT '�û���',
  `password` varchar(255) NOT NULL COMMENT '����',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�û���Ϣ��';


-- ----------------------------
-- Records of t_user_info
-- test/345��evan/123
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
  `table_name` varchar(40) NOT NULL COMMENT '����/�ļ���',
  `real_table_name` varchar(64) NOT NULL COMMENT 'DB��Ӧ����ʵ����',
  PRIMARY KEY (`id`),
  UNIQUE KEY `tablenameunique` (`table_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�û������ı���';

-- ----------------------------
-- Table structure for 't_title_name'
-- ----------------------------
DROP TABLE IF EXISTS `t_title_name`;
CREATE TABLE `t_title_name` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `table_id` int(11) NOT NULL COMMENT 'DB��Ӧ�ı�id',
  `title_name` varchar(40) NOT NULL COMMENT '�ֶ���/����',
  `column_name` varchar(64) NOT NULL COMMENT 'DB��Ӧ����ʵ����',
  `indx` int(11) NOT NULL COMMENT 'column������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�û�����������';


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






