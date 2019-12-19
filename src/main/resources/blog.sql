/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 19/12/2019 16:01:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', '123456');

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `catalog_id` int(11) NULL DEFAULT NULL,
  `create_time` date NULL DEFAULT NULL,
  `is_top` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`article_id`) USING BTREE,
  INDEX `fk_article_catalog`(`catalog_id`) USING BTREE,
  CONSTRAINT `fk_article_catalog` FOREIGN KEY (`catalog_id`) REFERENCES `catalog` (`catalog_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (25, 'git时光穿梭机-版本回退', '<p>git时光穿梭机-版本回退</p><p>git时光穿梭机-版本回退</p><p>git时光穿梭机-版本回退</p><p>git时光穿梭机-版本回退</p><p>git时光穿梭机-版本回退</p><p>&nbsp;<span style=\"font-size: small;\"><br></span></p>', 14, '2019-12-19', 0);
INSERT INTO `article` VALUES (27, 'Linux输入输出重定向与管道', '<p><span style=\"font-size: large;\"><span style=\"color: rgb(194, 79, 74);\">在平时的运维工作中，会经常遇到linux重定向操作和管道符。linux重定向分为输入重定向和输出重定向。简言之，输入重定向就是将文件内容导入到命令中，而输出重定向则是将原本要输出到屏幕上的信息写入到指定的文件中。</span>&nbsp;</span><span style=\"font-size: small;\">&nbsp;</span><br></p><p><strong style=\"color: rgb(249, 150, 59);\">重定向</strong>&nbsp;</p><p><span style=\"font-family: 微软雅黑;\">标准输入重定向(<code>STDIN</code>,文件描述符为0)：默认从键盘输入，也可以从其他文件或命令输入</span></p><p><span style=\"font-family: 微软雅黑;\">标准输出重定向(<code>STDOUT</code>,文件描述符为1)：默认输出到屏幕</span></p><p><span style=\"font-family: 微软雅黑;\">标准错误重定向(<code>STDERR</code>,文件描述符为2)：默认输出到屏幕&nbsp;</span><span style=\"font-size: small;\"><br></span></p><p><span style=\"color: rgb(249, 150, 59);\">输入重定向及其作用</span></p><p>命令 &lt; 文件 : 将文件作为命令的标准输入</p><p>命令 &lt;&lt; 分界符 : 从标准输入中读取，直到遇见分界符才终止</p><p>命令 &lt; 文件1 &gt; 文件2 : 将文件1作为命令的标准输入并将标准输出到文件2</p>', 16, '2019-12-19', 0);
INSERT INTO `article` VALUES (31, 'Lara博客系统v1.0版本发布', '<p>Lara是一款基于Laravel框架5.5版本开发的个人博客系统,它灵活轻巧,简单易用并易于扩展,适合搭建个人博客或作为企业CMS使用。</p><p>项目地址：<code>https://github.com/zhangfangsong/Lara</code>&nbsp;欢迎star ^_^</p><p>Demo地址：<code>http://lara.zfsphp.com</code></p><p><strong>V1.0 版本主要特性：</strong></p><ol><li><span style=\"font-family: Arial;\">文章管理</span></li><li><span style=\"font-family: Arial;\">分类管理(支持无限级分类)</span></li><li><span style=\"font-family: Arial;\">注册用户管理</span></li><li><span style=\"font-family: Arial;\">角色管理</span></li><li><span style=\"font-family: Arial;\">评论管理</span></li><li><span style=\"font-family: Arial;\">标签管理</span></li><li><span style=\"font-family: Arial;\">单页面管理</span></li><li><span style=\"font-family: Arial;\">链接管理</span></li><li><span style=\"font-family: Arial;\">集成Quill编辑器,支持图片上传,界面简洁美观</span></li></ol>', 1, '2019-12-19', 0);
INSERT INTO `article` VALUES (36, 'linux scp命令', '<p><code>scp</code>是&nbsp;<code>secure copy</code>的缩写, scp是linux系统下基于ssh登陆进行安全的远程文件拷贝命令。linux的scp命令可以在linux服务器之间复制文件和目录。</p><p>一. 命令格式</p><p><code>scp [参数] [原路径] [目标路径]</code></p><p>二. 参数说明</p><p><code>-1&nbsp;强制scp命令使用协议ssh1&nbsp;&nbsp;</code></p><p><code>-2&nbsp;强制scp命令使用协议ssh2&nbsp;&nbsp;</code></p><p><code>-4&nbsp;强制scp命令只使用IPv4寻址&nbsp;&nbsp;</code></p><p><code>-6&nbsp;强制scp命令只使用IPv6寻址&nbsp;&nbsp;</code></p><p><code>-B&nbsp;使用批处理模式（传输过程中不询问传输口令或短语）&nbsp;&nbsp;</code></p><p><code>-C&nbsp;允许压缩。（将-C标志传递给ssh，从而打开压缩功能）&nbsp;&nbsp;</code></p><p><code>-p 保留原文件的修改时间，访问时间和访问权限。&nbsp;&nbsp;</code></p><p><code>-q&nbsp;不显示传输进度条。&nbsp;&nbsp;</code></p><p><code>-r&nbsp;递归复制整个目录。&nbsp;&nbsp;</code></p><p><code>-v 详细方式显示输出。scp和ssh(1)会显示出整个过程的调试信息。这些信息用于调试连接，验证和配置问题。&nbsp;&nbsp;</code></p><p><code>-c cipher&nbsp;以cipher将数据传输进行加密，这个选项将直接传递给ssh。&nbsp;&nbsp;</code></p><p><code>-F ssh_config&nbsp;指定一个替代的ssh配置文件，此参数直接传递给ssh。&nbsp;&nbsp;</code></p><p><code>-i identity_file&nbsp;从指定文件中读取传输时使用的密钥文件，此参数直接传递给ssh。&nbsp;&nbsp;&nbsp;</code></p><p><code>-l limit&nbsp;限定用户所能使用的带宽，以Kbit/s为单位。&nbsp;&nbsp;&nbsp;</code></p><p><code>-o ssh_option&nbsp;如果习惯于使用ssh_config(5)中的参数传递方式，&nbsp;&nbsp;</code></p><p><code>-P port&nbsp;注意是大写的P, port是指定数据传输用到的端口号&nbsp;&nbsp;</code></p><p><code>-S program&nbsp;指定加密传输时所使用的程序。此程序必须能够理解ssh(1)的选项。</code></p>', 1, '2019-12-19', 0);
INSERT INTO `article` VALUES (37, 'Lara系统安装', '<p>1. 下载源码</p><p>在命令行界面输入&nbsp;<code>git clone&nbsp;</code><code>https://github.com/zhangfangsong/Lara.git</code>下载源码，</p><p>国内网速慢的同学可以用码云地址：<code>https://gitee.com/zfs/Lara.git</code></p><p></p><p>2. 安装<code>composer</code>依赖</p><p></p><p>进入项目根目录，在命令行界面输入&nbsp;<code>composer install</code>&nbsp;安装项目依赖</p><p>3. 配置<code>.env</code>文件</p><p>复制一份<code>.env.example</code>&nbsp;并重命名为<code>.env</code>&nbsp;编辑<code>.env</code>&nbsp;文件的以下部分为你的数据库连接配置</p><p>4 设置应用秘钥</p><p>在命令行界面输入&nbsp;<code>php artisan key:generate &amp;&amp; php artisan jwt:secret</code></p><p></p><p>5. 数据库迁移</p><p></p><p>在命令行界面输入&nbsp;<code>php artisan migrate</code>&nbsp;运行数据库迁移文件，生成数据库表结构</p>', 1, '2019-12-19', 0);

-- ----------------------------
-- Table structure for article_label
-- ----------------------------
DROP TABLE IF EXISTS `article_label`;
CREATE TABLE `article_label`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_id` int(11) NULL DEFAULT NULL,
  `label_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_article`(`article_id`) USING BTREE,
  INDEX `fk_label`(`label_id`) USING BTREE,
  CONSTRAINT `fk_article` FOREIGN KEY (`article_id`) REFERENCES `article` (`article_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_label` FOREIGN KEY (`label_id`) REFERENCES `label` (`label_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 79 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of article_label
-- ----------------------------
INSERT INTO `article_label` VALUES (71, 27, 99);
INSERT INTO `article_label` VALUES (72, 31, 100);
INSERT INTO `article_label` VALUES (73, 36, 101);
INSERT INTO `article_label` VALUES (74, 37, 102);
INSERT INTO `article_label` VALUES (77, 25, 105);
INSERT INTO `article_label` VALUES (78, 25, 106);

-- ----------------------------
-- Table structure for catalog
-- ----------------------------
DROP TABLE IF EXISTS `catalog`;
CREATE TABLE `catalog`  (
  `catalog_id` int(11) NOT NULL AUTO_INCREMENT,
  `catalog_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_top` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`catalog_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of catalog
-- ----------------------------
INSERT INTO `catalog` VALUES (1, '服务器', 0);
INSERT INTO `catalog` VALUES (14, '表格', 0);
INSERT INTO `catalog` VALUES (16, '777', 0);
INSERT INTO `catalog` VALUES (17, '个人博客', 0);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `article_id` int(11) NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` date NULL DEFAULT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE,
  INDEX `fk_comment_user`(`user_id`) USING BTREE,
  INDEX `fk_comment_article`(`article_id`) USING BTREE,
  CONSTRAINT `fk_comment_article` FOREIGN KEY (`article_id`) REFERENCES `article` (`article_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_comment_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (13, 10, 31, '写的很好，真不错', '2019-12-19');
INSERT INTO `comment` VALUES (14, 10, 25, '内容写的有点少', '2019-12-19');

-- ----------------------------
-- Table structure for label
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label`  (
  `label_id` int(11) NOT NULL AUTO_INCREMENT,
  `label_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_top` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`label_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 107 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of label
-- ----------------------------
INSERT INTO `label` VALUES (99, 'a', 0);
INSERT INTO `label` VALUES (100, 'hhhh', 0);
INSERT INTO `label` VALUES (101, 'Java', 0);
INSERT INTO `label` VALUES (102, 'CSS', 0);
INSERT INTO `label` VALUES (105, 'linux', 0);
INSERT INTO `label` VALUES (106, '博客', 0);

-- ----------------------------
-- Table structure for link
-- ----------------------------
DROP TABLE IF EXISTS `link`;
CREATE TABLE `link`  (
  `link_id` int(11) NOT NULL AUTO_INCREMENT,
  `link_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `link_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`link_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of link
-- ----------------------------
INSERT INTO `link` VALUES (1, '周文龙博客', 'http://www.baidu.com');
INSERT INTO `link` VALUES (2, 'GitHub', 'https://github.com/zhouwenlong1234');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` date NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (6, 'zhouwenlong', '123456', '17343698034', '2019-12-18');
INSERT INTO `user` VALUES (10, 'aaa', '123456', '17343678956', '2019-12-19');

SET FOREIGN_KEY_CHECKS = 1;
