-- 1 用户表
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(80) NOT NULL COMMENT '名字',
  `user_pic` varchar(255) NULL DEFAULT NULL COMMENT '头像',
  `password` varchar(255) NULL DEFAULT NULL COMMENT '密码',
  `phone` varchar(11) NULL DEFAULT NULL COMMENT '手机',
  `email` varchar(255) NULL DEFAULT NULL COMMENT '邮箱',
  `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '0 禁用 1启用',
  `create_time` int(11) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB COMMENT = '用户信息';

-- 2 用户绑定表
DROP TABLE IF EXISTS `user_bind`;
CREATE TABLE `user_bind`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `type` varchar(50) NOT NULL COMMENT '类型',
  `open_id` varchar(255) NOT NULL COMMENT '开放编号',
  `user_id` int(11) NULL DEFAULT 0 COMMENT '用户编号',
  `nick_name` varchar(50) NULL DEFAULT NULL COMMENT '昵称',
  `avatar_url` varchar(255) NULL DEFAULT NULL COMMENT '头像地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB COMMENT = '第三方登录信息';

-- 3 用户资料表
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` int(11) NOT NULL DEFAULT 0 COMMENT '用户id',
  `age` tinyint(4) NOT NULL DEFAULT 0 COMMENT '年龄',
  `sex` tinyint(4) NOT NULL DEFAULT 2 COMMENT '0 男 1女 2不限',
  `qg` tinyint(4) NOT NULL DEFAULT 0 COMMENT '0不限',
  `job` varchar(10) NULL DEFAULT NULL COMMENT '工作',
  `path` varchar(255) NULL DEFAULT NULL COMMENT '地址',
  `birthday` varchar(20) NULL DEFAULT NULL COMMENT '生日',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB COMMENT = '用户资料';

-- 4 广告
DROP TABLE IF EXISTS `adsense`;
CREATE TABLE `adsense`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `src` varchar(255) NOT NULL COMMENT '地址',
  `url` varchar(255) NULL DEFAULT NULL COMMENT '链接地址',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '0 动态轮播图 1个人中心',
  `create_time` int(11) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB COMMENT '广告';

-- 5 更新
DROP TABLE IF EXISTS `app_update`;
CREATE TABLE `app_update`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `url` varchar(255) NULL DEFAULT NULL COMMENT '链接地址',
  `version` varchar(10) NULL DEFAULT NULL COMMENT '版本号',
  `status` tinyint(4) NULL DEFAULT 0 COMMENT '0未上线 1上线',
  `create_time` int(11) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB COMMENT '更新';

-- 6 拉黑集
DROP TABLE IF EXISTS `black_list`;
CREATE TABLE `black_list`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `black_id` int(11) NOT NULL DEFAULT 0 COMMENT '拉黑id',
  `user_id` int(11) NOT NULL DEFAULT 0 COMMENT '用户id',
  `create_time` int(11) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB COMMENT '拉黑集';

-- 7 图片表
DROP TABLE IF EXISTS `images`;
CREATE TABLE `images`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `url` varchar(255) NOT NULL COMMENT '链接地址',
  `create_time` int(11) COMMENT '创建时间',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB COMMENT '图片';

-- 8 帖子表
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` int(11) NOT NULL DEFAULT 0 COMMENT '发布人',
  `title` varchar(80) NOT NULL COMMENT '标题',
  `title_pic` varchar(255) NOT NULL COMMENT '标题图片',
  `content` text NOT NULL COMMENT '内容',
  `share_num` int(11) NOT NULL DEFAULT 0 COMMENT '分享数',
  `path` varchar(255) NOT NULL COMMENT '路径',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '0 图文 1分享',
  `create_time` int(11) COMMENT '创建时间',
  `post_class_id` int(11) NULL DEFAULT NULL COMMENT 'post类型编号',
  `share_id` int(11) NULL DEFAULT 0 COMMENT '共享编号',
  `is_open` tinyint(4) NULL DEFAULT 1 COMMENT '1开放，0仅自己可见',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB COMMENT '帖子';

-- 9 帖子分类
DROP TABLE IF EXISTS `post_class`;
CREATE TABLE `post_class`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `class_name` varchar(10) NOT NULL COMMENT '类型名称',
  `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '0 禁用 1启用',
  `create_time` int(11) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB COMMENT '帖子分类';

-- 10 帖子图片关联表
DROP TABLE IF EXISTS `post_image`;
CREATE TABLE `post_image`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `post_id` int(11) NOT NULL DEFAULT 0 COMMENT '帖子id',
  `image_id` int(11) NOT NULL DEFAULT 0 COMMENT '图片id',
  `create_time` int(11) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB COMMENT '帖子图片关联';

-- 11 评论表
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` int(11) NOT NULL DEFAULT 0 COMMENT '发布人',
  `f_id` int(11) NOT NULL DEFAULT 0 COMMENT '回复id',
  `fnum` int(11) NOT NULL DEFAULT 0 COMMENT '被回复数',
  `data` varchar(225) NOT NULL COMMENT '数据',
   `create_time` int(11) COMMENT '创建时间',
  `post_id` int(11) NULL DEFAULT NULL COMMENT 'post编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB COMMENT '评论';

-- 12 反馈表
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `to_id` int(11) NOT NULL DEFAULT 0 COMMENT '接受id',
  `from_id` int(11) NOT NULL DEFAULT 0 COMMENT '发送id',
  `data` varchar(255) NULL DEFAULT NULL COMMENT '数据',
  `create_time` int(11) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB COMMENT '反馈';

-- 13 关注
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `follow_id` int(11) NOT NULL DEFAULT 0 COMMENT '关注id',
  `user_id` int(11) NOT NULL DEFAULT 0 COMMENT '用户id',
  `create_time` int(11) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB COMMENT '关注';

-- 14 支持表
DROP TABLE IF EXISTS `support`;
CREATE TABLE `support`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` int(11) NOT NULL DEFAULT 0 COMMENT '发布人',
  `post_id` int(11) NOT NULL DEFAULT 0 COMMENT '帖子id',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '0 顶 1踩',
  `create_time` int(11) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB COMMENT '支持';

-- 15 话题分类表
DROP TABLE IF EXISTS `topic_class`;
CREATE TABLE `topic_class`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `class_name` varchar(5) NOT NULL COMMENT '名称',
  `status` tinyint(4) NOT NULL DEFAULT 1 COMMENT '0 禁用 1启用',
  `create_time` int(11) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB COMMENT '话题分类';

-- 16 话题表
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `title` varchar(80) NOT NULL COMMENT '标题',
  `title_pic` varchar(255) NOT NULL COMMENT '标题图片',
  `desc` varchar(255) NOT NULL COMMENT '描述',
  `type` tinyint(4) NOT NULL DEFAULT 1 COMMENT '0 禁用 1启用',
  `create_time` int(11) COMMENT '创建时间',
  `topic_class_id` int(11) NULL DEFAULT NULL COMMENT '话题类型编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB COMMENT '话题';

-- 17 话题帖子关联表
DROP TABLE IF EXISTS `topic_post`;
CREATE TABLE `topic_post`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `topic_id` int(11) NOT NULL DEFAULT 0 COMMENT '话题id',
  `post_id` int(11) NOT NULL DEFAULT 0 COMMENT '帖子id',
  `create_time` int(11) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB COMMENT '话题帖子关联';




