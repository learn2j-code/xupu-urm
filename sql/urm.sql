CREATE DATABASE  IF NOT EXISTS `user_manage`  DEFAULT CHARACTER SET utf8 ;

USE `user_manage`;

/*用户信息表*/
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(255) DEFAULT NULL COMMENT '昵称',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色名字',
  `gender` int(2) DEFAULT NULL COMMENT '性别',
  `phone` varchar(50) DEFAULT NULL COMMENT '手机号码',
  `identity_card` varchar(20) DEFAULT NULL COMMENT '身份证',
  `head_image` varchar(1024) DEFAULT NULL COMMENT '用户头像地址',
  `third_code` varchar(50) DEFAULT NULL COMMENT '第三方唯一码',
  `third_source` varchar(50) DEFAULT NULL COMMENT '第三方登陆来源',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间' ,
  `status` int(11) DEFAULT NULL COMMENT '登录状态',
  `user_from` int(4) DEFAULT NULL COMMENT '用户来源，1：家族管理系统',
  PRIMARY KEY (`id`)
) COMMENT = '用户信息表'  ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*角色表*/
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `role_detail` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `role_code` varchar(255) DEFAULT NULL COMMENT '角色编码',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间' ,
  PRIMARY KEY (`id`)
) COMMENT = '角色表'  ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*系统信息表*/
DROP TABLE IF EXISTS `system_info`;
CREATE TABLE `system_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统id',
  `system_name` varchar(255) DEFAULT NULL COMMENT '系统名称',
  `system_address` varchar(1024) DEFAULT NULL COMMENT '系统地址',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间' ,
  PRIMARY KEY (`id`)
) COMMENT = '系统信息表'  ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*模块信息表*/
DROP TABLE IF EXISTS `module_info`;
CREATE TABLE `module_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '模块id',
  `module_name` varchar(255) DEFAULT NULL COMMENT '模块名称',
  `system_id` int(11) DEFAULT NULL COMMENT '系统id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间' ,
  PRIMARY KEY (`id`)
) COMMENT = '模块信息表'  ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*页面信息表*/
DROP TABLE IF EXISTS `page_info`;
CREATE TABLE `page_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '页面id',
  `page_name` varchar(255) DEFAULT NULL COMMENT '页面名称',
  `module_id` int(11) DEFAULT NULL COMMENT '模块id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间' ,
  PRIMARY KEY (`id`)
) COMMENT = '页面信息表'  ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*功能信息表*/
DROP TABLE IF EXISTS `function_info`;
CREATE TABLE `function_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '功能id',
  `function_name` varchar(255) DEFAULT NULL COMMENT '功能名称',
  `function_address` varchar(255) DEFAULT NULL COMMENT '功能访问地址',
  `page_id` int(11) DEFAULT NULL COMMENT '页面id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间' ,
  PRIMARY KEY (`id`)
) COMMENT = '功能信息表'  ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*角色权限表*/
DROP TABLE IF EXISTS `role_authority`;
CREATE TABLE `role_authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色权限id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `function_id` int(11) DEFAULT NULL COMMENT '功能id',
  `function_name` varchar(255) DEFAULT NULL COMMENT '功能名称',
  `function_address` varchar(255) DEFAULT NULL COMMENT '功能访问地址',
  `page_id` int(11) DEFAULT NULL COMMENT '页面id',
  `page_name` varchar(255) DEFAULT NULL COMMENT '页面名称',
  `module_id` int(11) DEFAULT NULL COMMENT '模块id',
  `module_name` varchar(255) DEFAULT NULL COMMENT '模块名称',
  `system_id` int(11) DEFAULT NULL COMMENT '系统id',
  `system_name` varchar(255) DEFAULT NULL COMMENT '系统名称',
  `system_address` varchar(1024) DEFAULT NULL COMMENT '系统地址',
  `banned_flag` int(2) DEFAULT NULL COMMENT '权限禁用标识，0：默认不禁用，1：禁用',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间' ,
  PRIMARY KEY (`id`)
) COMMENT = '角色权限表'  ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*用户关系表*/
DROP TABLE IF EXISTS `user_relation`;
CREATE TABLE `user_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色权限id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(255) DEFAULT NULL COMMENT '家族管理员名称',
  `rel_id` int(11) DEFAULT NULL COMMENT '关系id（如果类型为1：此为家族id；类型为2：代表其他id）',
  `rel_name` int(11) DEFAULT NULL COMMENT '关系的名称',
  `relation_type` int(4) DEFAULT NULL COMMENT '关系类型',
  `extend_type` int(4) DEFAULT NULL COMMENT '扩充类型，在家族中的身份类型，1：业务员，2：宗亲',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间' ,
  PRIMARY KEY (`id`)
) COMMENT = '用户关系表'  ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*菜单管理表*/
CREATE TABLE `menu_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `super_menu_id` int(11) DEFAULT NULL COMMENT '上级菜单id',
  `menu_name` varchar(100) DEFAULT NULL COMMENT '菜单名',
  `icon` varchar(1024) DEFAULT NULL COMMENT '图标',
  `route` varchar(1024) DEFAULT NULL COMMENT '页面路由',
  `is_show` int(4) DEFAULT NULL COMMENT '当前菜单是否显示',
  `have_children_menu` int(4) DEFAULT NULL COMMENT '是否有子菜单，0：没有子菜单，1：有',
  `is_show_children_menu` int(4) DEFAULT NULL COMMENT '是否显示子菜单，0：不显示，1：显示',
  `active` int(2) DEFAULT NULL COMMENT '活动状态，boolean，默认为false',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间' ,
  PRIMARY KEY (`id`)
) COMMENT = '菜单管理' ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*角色与菜单关系表*/
CREATE TABLE `role_menu_rel` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单id',
  `super_menu_id` int(11) DEFAULT NULL COMMENT '上级菜单id',
  `menu_name` varchar(100) DEFAULT NULL COMMENT '菜单名',
  `icon` varchar(1024) DEFAULT NULL COMMENT '图标',
  `route` varchar(1024) DEFAULT NULL COMMENT '页面路由',
  `is_show` int(4) DEFAULT NULL COMMENT '当前菜单是否显示',
  `have_children_menu` int(4) DEFAULT NULL COMMENT '是否有子菜单，0：没有子菜单，1：有',
  `is_show_children_menu` int(4) DEFAULT NULL COMMENT '是否显示子菜单，0：不显示，1：显示',
  `active` int(2) DEFAULT NULL COMMENT '活动状态，boolean，默认为false',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间' ,
  PRIMARY KEY (`id`)
) COMMENT = '角色与菜单关系表' ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*叙谱后台管理员菜单*/
INSERT INTO `user_manage`.`role_menu_rel` (`role_id`, `menu_id`, `super_menu_id`, `menu_name`, `icon`, `route`, `is_show`, `have_children_menu`, `is_show_children_menu`, `active`) VALUES ('22', '1', '0', '家族管理', 'el-icon-tickets', '/familyList', '1', '0', '0', '1');
INSERT INTO `user_manage`.`role_menu_rel` (`role_id`, `menu_id`, `super_menu_id`, `menu_name`, `icon`, `route`, `is_show`, `have_children_menu`, `is_show_children_menu`, `active`) VALUES ('22', '2', '0', '姓氏管理', 'el-icon-goods', '/surnamesList', '1', '0', '0', '1');
INSERT INTO `user_manage`.`role_menu_rel` (`role_id`, `menu_id`, `super_menu_id`, `menu_name`, `icon`, `route`, `is_show`, `have_children_menu`, `is_show_children_menu`, `active`) VALUES ('22', '3', '0', '籍贯管理', 'el-icon-sold-out', '/nativePlaceList', '1', '0', '0', '1');
INSERT INTO `user_manage`.`role_menu_rel` (`role_id`, `menu_id`, `super_menu_id`, `menu_name`, `icon`, `route`, `is_show`, `have_children_menu`, `is_show_children_menu`, `active`) VALUES ('22', '4', '0', '服务管理', 'el-icon-news', '/serviceManage', '1', '0', '0', '1');
/*叙谱家族管理员菜单*/
INSERT INTO `user_manage`.`role_menu_rel` (`role_id`, `menu_id`, `super_menu_id`, `menu_name`, `icon`, `route`, `is_show`, `have_children_menu`, `is_show_children_menu`, `active`) VALUES ('23', '5', '0', '基本信息', 'el-icon-tickets', '/beforeAdding', '1', '0', '0', '1');
INSERT INTO `user_manage`.`role_menu_rel` (`role_id`, `menu_id`, `super_menu_id`, `menu_name`, `icon`, `route`, `is_show`, `have_children_menu`, `is_show_children_menu`, `active`) VALUES ('23', '6', '0', '祠堂信息', 'el-icon-goods', '/clanHallManage', '1', '0', '0', '1');
INSERT INTO `user_manage`.`role_menu_rel` (`role_id`, `menu_id`, `super_menu_id`, `menu_name`, `icon`, `route`, `is_show`, `have_children_menu`, `is_show_children_menu`, `active`) VALUES ('23', '7', '0', '族谱管理', 'el-icon-sold-out', '/oldChartList', '1', '0', '0', '1');
INSERT INTO `user_manage`.`role_menu_rel` (`role_id`, `menu_id`, `super_menu_id`, `menu_name`, `icon`, `route`, `is_show`, `have_children_menu`, `is_show_children_menu`, `active`) VALUES ('23', '8', '0', '家族成员', 'el-icon-news', '/familyMember', '1', '0', '0', '1');
INSERT INTO `user_manage`.`role_menu_rel` (`role_id`, `menu_id`, `super_menu_id`, `menu_name`, `icon`, `route`, `is_show`, `have_children_menu`, `is_show_children_menu`, `active`) VALUES ('23', '9', '0', '理事会成员', 'el-icon-message', '/councilMember', '1', '0', '0', '1');
INSERT INTO `user_manage`.`role_menu_rel` (`role_id`, `menu_id`, `super_menu_id`, `menu_name`, `icon`, `route`, `is_show`, `have_children_menu`, `is_show_children_menu`, `active`) VALUES ('23', '10', '0', '功德碑', 'el-icon-bell', '/meritStele', '1', '0', '0', '1');
INSERT INTO `user_manage`.`role_menu_rel` (`role_id`, `menu_id`, `super_menu_id`, `menu_name`, `icon`, `route`, `is_show`, `have_children_menu`, `is_show_children_menu`, `active`) VALUES ('23', '11', '0', '咨询管理', 'el-icon-date', '/consultManage', '1', '0', '0', '1');
INSERT INTO `user_manage`.`role_menu_rel` (`role_id`, `menu_id`, `super_menu_id`, `menu_name`, `icon`, `route`, `is_show`, `have_children_menu`, `is_show_children_menu`, `active`) VALUES ('23', '12', '0', '名人堂', 'el-icon-view', '/celebrityManage', '1', '0', '0', '1');
INSERT INTO `user_manage`.`role_menu_rel` (`role_id`, `menu_id`, `super_menu_id`, `menu_name`, `icon`, `route`, `is_show`, `have_children_menu`, `is_show_children_menu`, `active`) VALUES ('23', '13', '0', '管理员', 'el-icon-service', '/adminMember', '1', '0', '0', '1');
INSERT INTO `user_manage`.`role_menu_rel` (`role_id`, `menu_id`, `super_menu_id`, `menu_name`, `icon`, `route`, `is_show`, `have_children_menu`, `is_show_children_menu`, `active`) VALUES ('23', '14', '0', '分支管理', 'el-icon-menu', '/branchManage', '1', '0', '0', '1');
INSERT INTO `user_manage`.`role_menu_rel` (`role_id`, `menu_id`, `super_menu_id`, `menu_name`, `icon`, `route`, `is_show`, `have_children_menu`, `is_show_children_menu`, `active`) VALUES ('23', '15', '0', '家族设置', 'el-icon-tickets', '/familySetting', '1', '0', '0', '1');

