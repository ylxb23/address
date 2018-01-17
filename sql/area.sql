CREATE TABLE `area` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `area_code` varchar(15) NOT NULL COMMENT '地区编码',
  `name` varchar(45) NOT NULL COMMENT '地区名称',
  `alia_name` varchar(200) NOT NULL COMMENT '地区别名',
  `parent_code` varchar(8) NOT NULL COMMENT '父级地区编码',
  `level` tinyint(4) NOT NULL COMMENT '地区级别(大陆:1-省,2-市,3-区/县)',
  `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '类型(0-一般,1-双地名,2-双地名,3-旧地址合并)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54214 DEFAULT CHARSET=utf8 COMMENT='地区(市/区/县/州)';

CREATE TABLE `country` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `code` varchar(8) NOT NULL DEFAULT '' COMMENT '编号',
  `name` varchar(30) NOT NULL DEFAULT '' COMMENT '名称',
  `alia_name` varchar(30) NOT NULL DEFAULT '' COMMENT '繁体名称',
  `english_name` varchar(50) NOT NULL DEFAULT '' COMMENT '英文名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=245 DEFAULT CHARSET=utf8 COMMENT='国家表';