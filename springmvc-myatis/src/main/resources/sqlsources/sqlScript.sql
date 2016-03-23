CREATE TABLE `ba_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `url` varchar(150) NOT NULL,
  `parent` int(11) DEFAULT '-1' COMMENT '上级菜单，默认顶级菜单 -1',
  `enable` int(1) DEFAULT '0' COMMENT '0 不启用 1 启用',
  `is_leaf` int(1) DEFAULT '0' COMMENT '0叶子 1 非叶子',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;


CREATE TABLE `ba_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `enable` int(1) DEFAULT '0' COMMENT '0 不启用 1 启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

CREATE TABLE `ba_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_role_menu` (`role_id`),
  KEY `fk_menu` (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

CREATE TABLE `ba_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `enable` int(1) DEFAULT '0' COMMENT '0 不启用 1 启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

CREATE TABLE `ba_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user` (`user_id`),
  KEY `fk_role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

INSERT INTO `ba_menu` (`id`,`name`,`url`,`parent`,`enable`,`is_leaf`) VALUES (1,'开发者审批','',-1,0,1);
INSERT INTO `ba_menu` (`id`,`name`,`url`,`parent`,`enable`,`is_leaf`) VALUES (2,'应用审批','',-1,0,1);
INSERT INTO `ba_menu` (`id`,`name`,`url`,`parent`,`enable`,`is_leaf`) VALUES (3,'计费点审批','',-1,0,1);
INSERT INTO `ba_menu` (`id`,`name`,`url`,`parent`,`enable`,`is_leaf`) VALUES (4,'测试环境联调审批','',-1,0,1);
INSERT INTO `ba_menu` (`id`,`name`,`url`,`parent`,`enable`,`is_leaf`) VALUES (5,'线上环境联调审批','',-1,0,1);
INSERT INTO `ba_menu` (`id`,`name`,`url`,`parent`,`enable`,`is_leaf`) VALUES (6,'测试审批','',-1,0,1);
INSERT INTO `ba_menu` (`id`,`name`,`url`,`parent`,`enable`,`is_leaf`) VALUES (7,'上架审批','',-1,0,1);
INSERT INTO `ba_menu` (`id`,`name`,`url`,`parent`,`enable`,`is_leaf`) VALUES (8,'应用查询','',-1,0,1);
INSERT INTO `ba_menu` (`id`,`name`,`url`,`parent`,`enable`,`is_leaf`) VALUES (9,'权限管理','',-1,0,1);
INSERT INTO `ba_menu` (`id`,`name`,`url`,`parent`,`enable`,`is_leaf`) VALUES (10,'账号管理','',-1,0,1);
INSERT INTO `ba_menu` (`id`,`name`,`url`,`parent`,`enable`,`is_leaf`) VALUES (11,'开发者审批1','',1,0,1);
INSERT INTO `ba_menu` (`id`,`name`,`url`,`parent`,`enable`,`is_leaf`) VALUES (12,'应用审批1','',2,0,1);
INSERT INTO `ba_menu` (`id`,`name`,`url`,`parent`,`enable`,`is_leaf`) VALUES (13,'计费点审批1','',3,0,1);
INSERT INTO `ba_menu` (`id`,`name`,`url`,`parent`,`enable`,`is_leaf`) VALUES (14,'测试环境联调审批1','',4,0,1);
INSERT INTO `ba_menu` (`id`,`name`,`url`,`parent`,`enable`,`is_leaf`) VALUES (15,'线上环境联调审批1','',5,0,1);
INSERT INTO `ba_menu` (`id`,`name`,`url`,`parent`,`enable`,`is_leaf`) VALUES (16,'测试审批1','',6,0,1);
INSERT INTO `ba_menu` (`id`,`name`,`url`,`parent`,`enable`,`is_leaf`) VALUES (17,'上架审批1','',7,0,1);
INSERT INTO `ba_menu` (`id`,`name`,`url`,`parent`,`enable`,`is_leaf`) VALUES (18,'应用查询1','',8,0,1);
INSERT INTO `ba_menu` (`id`,`name`,`url`,`parent`,`enable`,`is_leaf`) VALUES (19,'权限管理1','',9,0,1);
INSERT INTO `ba_menu` (`id`,`name`,`url`,`parent`,`enable`,`is_leaf`) VALUES (20,'账号管理1','',2,0,1);
INSERT INTO `ba_menu` (`id`,`name`,`url`,`parent`,`enable`,`is_leaf`) VALUES (21,'测试菜单3级','',11,0,1);
INSERT INTO `ba_menu` (`id`,`name`,`url`,`parent`,`enable`,`is_leaf`) VALUES (22,'测试菜单32级','',12,0,1);
INSERT INTO `ba_menu` (`id`,`name`,`url`,`parent`,`enable`,`is_leaf`) VALUES (23,'测试菜单4级','',21,0,0);
INSERT INTO `ba_menu` (`id`,`name`,`url`,`parent`,`enable`,`is_leaf`) VALUES (24,'测试菜单43级','',22,0,0);


INSERT INTO `ba_role` (`id`,`name`,`enable`) VALUES (1,'应用审批员',0);
INSERT INTO `ba_role` (`id`,`name`,`enable`) VALUES (2,'权限管理员',0);
INSERT INTO `ba_role` (`id`,`name`,`enable`) VALUES (3,'开发者审批员',0);
INSERT INTO `ba_role` (`id`,`name`,`enable`) VALUES (4,'计费点审批员',0);
INSERT INTO `ba_role` (`id`,`name`,`enable`) VALUES (5,'测试环境联调审批员',0);
INSERT INTO `ba_role` (`id`,`name`,`enable`) VALUES (6,'线上环境联调审批员',0);
INSERT INTO `ba_role` (`id`,`name`,`enable`) VALUES (7,'测试审批员',0);
INSERT INTO `ba_role` (`id`,`name`,`enable`) VALUES (8,'上架审批员',0);
INSERT INTO `ba_role` (`id`,`name`,`enable`) VALUES (9,'应用查询员',0);
INSERT INTO `ba_role` (`id`,`name`,`enable`) VALUES (10,'账号管理员',0);
INSERT INTO `ba_role` (`id`,`name`,`enable`) VALUES (14,'角色添加测试',0);

INSERT INTO `ba_role_menu` (`id`,`role_id`,`menu_id`) VALUES (1,1,2);
INSERT INTO `ba_role_menu` (`id`,`role_id`,`menu_id`) VALUES (2,2,9);
INSERT INTO `ba_role_menu` (`id`,`role_id`,`menu_id`) VALUES (3,3,1);
INSERT INTO `ba_role_menu` (`id`,`role_id`,`menu_id`) VALUES (4,4,3);
INSERT INTO `ba_role_menu` (`id`,`role_id`,`menu_id`) VALUES (5,5,4);
INSERT INTO `ba_role_menu` (`id`,`role_id`,`menu_id`) VALUES (6,6,5);
INSERT INTO `ba_role_menu` (`id`,`role_id`,`menu_id`) VALUES (7,7,6);
INSERT INTO `ba_role_menu` (`id`,`role_id`,`menu_id`) VALUES (8,8,7);
INSERT INTO `ba_role_menu` (`id`,`role_id`,`menu_id`) VALUES (9,9,8);
INSERT INTO `ba_role_menu` (`id`,`role_id`,`menu_id`) VALUES (10,10,10);
INSERT INTO `ba_role_menu` (`id`,`role_id`,`menu_id`) VALUES (26,14,1);
INSERT INTO `ba_role_menu` (`id`,`role_id`,`menu_id`) VALUES (27,14,2);
INSERT INTO `ba_role_menu` (`id`,`role_id`,`menu_id`) VALUES (29,14,5);
INSERT INTO `ba_role_menu` (`id`,`role_id`,`menu_id`) VALUES (30,14,6);

INSERT INTO `ba_user` (`id`,`username`,`password`,`email`,`phone`,`enable`) VALUES (1,'test','1234567890','123456@qq.com','13554540000',0);
INSERT INTO `ba_user` (`id`,`username`,`password`,`email`,`phone`,`enable`) VALUES (3,'test123','123456','123456@qq.com','13554540001',0);
INSERT INTO `ba_user` (`id`,`username`,`password`,`email`,`phone`,`enable`) VALUES (4,'test0000001','123456','123456789@qq.com','13554540002',0);
INSERT INTO `ba_user` (`id`,`username`,`password`,`email`,`phone`,`enable`) VALUES (5,'testAdd','test','testAdd@qq.com','13554540001',0);


INSERT INTO `ba_user_role` (`id`,`user_id`,`role_id`) VALUES (1,1,1);
INSERT INTO `ba_user_role` (`id`,`user_id`,`role_id`) VALUES (2,1,2);
INSERT INTO `ba_user_role` (`id`,`user_id`,`role_id`) VALUES (7,3,3);
INSERT INTO `ba_user_role` (`id`,`user_id`,`role_id`) VALUES (8,3,4);
INSERT INTO `ba_user_role` (`id`,`user_id`,`role_id`) VALUES (9,3,5);
INSERT INTO `ba_user_role` (`id`,`user_id`,`role_id`) VALUES (10,3,1);
INSERT INTO `ba_user_role` (`id`,`user_id`,`role_id`) VALUES (11,3,2);
INSERT INTO `ba_user_role` (`id`,`user_id`,`role_id`) VALUES (12,4,1);
INSERT INTO `ba_user_role` (`id`,`user_id`,`role_id`) VALUES (13,4,2);
INSERT INTO `ba_user_role` (`id`,`user_id`,`role_id`) VALUES (17,4,3);
INSERT INTO `ba_user_role` (`id`,`user_id`,`role_id`) VALUES (18,4,4);
INSERT INTO `ba_user_role` (`id`,`user_id`,`role_id`) VALUES (19,4,5);
INSERT INTO `ba_user_role` (`id`,`user_id`,`role_id`) VALUES (20,5,1);
INSERT INTO `ba_user_role` (`id`,`user_id`,`role_id`) VALUES (21,5,2);
INSERT INTO `ba_user_role` (`id`,`user_id`,`role_id`) VALUES (22,5,5);
