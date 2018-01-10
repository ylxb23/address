CREATE TABLE `area` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `area_code` varchar(15) NOT NULL COMMENT '地区编码',
  `name` varchar(45) NOT NULL COMMENT '地区名称',
  `alia_name` varchar(45) NOT NULL COMMENT '地区别名',
  `parent_code` varchar(8) NOT NULL COMMENT '父级地区编码',
  `level` tinyint(4) NOT NULL COMMENT '地区级别(大陆:1-省,2-市,3-区/县)',
  `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '类型(0-一般,1-双地名,2-双地名,3-旧地址合并)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7028 DEFAULT CHARSET=utf8 COMMENT='地区(市/区/县/州)';