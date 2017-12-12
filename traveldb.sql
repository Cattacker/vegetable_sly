-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: traveldb
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `applyteam`
--

DROP TABLE IF EXISTS `applyteam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `applyteam` (
  `team_id` bigint(20) NOT NULL,
  `user_id` varchar(225) NOT NULL,
  `captain_id` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applyteam`
--

LOCK TABLES `applyteam` WRITE;
/*!40000 ALTER TABLE `applyteam` DISABLE KEYS */;
INSERT INTO `applyteam` VALUES (0,'1150310228','null');
/*!40000 ALTER TABLE `applyteam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `basic`
--

DROP TABLE IF EXISTS `basic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `basic` (
  `ID` varchar(255) NOT NULL,
  `PassWord` varchar(255) DEFAULT NULL,
  `NickName` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Sex` int(11) DEFAULT NULL,
  `ComCity` varchar(255) DEFAULT NULL,
  `Birthday` date DEFAULT NULL,
  `PhoneNum` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `basic`
--

LOCK TABLES `basic` WRITE;
/*!40000 ALTER TABLE `basic` DISABLE KEYS */;
INSERT INTO `basic` VALUES ('1150310228','7374jack','hahaha',NULL,NULL,NULL,NULL,NULL),('1152220125','00000000','李四','李四',0,'哈尔滨','2017-11-01','18804636923'),('1152220126','00000000','王五','王五',0,'哈尔滨','2010-11-10','16705663388'),('1152220127','74562866','小燕子','燕钰',1,'临汾','1997-06-18','17645056836'),('1152340113','00000000','张三','张三',0,'哈尔滨','2000-01-26','17645032268'),('root','00000000','','',NULL,'',NULL,''),('tourist','11111111','','',NULL,'',NULL,''),('Vegetable','forzaMILAN1899','Hooin Kyoma',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `basic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invite`
--

DROP TABLE IF EXISTS `invite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invite` (
  `team_id` bigint(20) NOT NULL,
  `friend_id` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invite`
--

LOCK TABLES `invite` WRITE;
/*!40000 ALTER TABLE `invite` DISABLE KEYS */;
/*!40000 ALTER TABLE `invite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `path`
--

DROP TABLE IF EXISTS `path`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `path` (
  `path_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `start_id` bigint(20) NOT NULL,
  `end_id` bigint(20) NOT NULL,
  `path_size` int(11) NOT NULL,
  `hash_code` int(11) DEFAULT NULL,
  `rate_size` int(11) DEFAULT NULL,
  `rate_aver` double(6,5) DEFAULT NULL,
  PRIMARY KEY (`path_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `path`
--

LOCK TABLES `path` WRITE;
/*!40000 ALTER TABLE `path` DISABLE KEYS */;
/*!40000 ALTER TABLE `path` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `path_struct`
--

DROP TABLE IF EXISTS `path_struct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `path_struct` (
  `path_id` bigint(20) NOT NULL,
  `location_id` bigint(20) NOT NULL,
  `location_index` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `path_struct`
--

LOCK TABLES `path_struct` WRITE;
/*!40000 ALTER TABLE `path_struct` DISABLE KEYS */;
/*!40000 ALTER TABLE `path_struct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stratety`
--

DROP TABLE IF EXISTS `stratety`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stratety` (
  `editor` text,
  `id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stratety`
--

LOCK TABLES `stratety` WRITE;
/*!40000 ALTER TABLE `stratety` DISABLE KEYS */;
INSERT INTO `stratety` VALUES ('<p><img alt=\"\" src=\"http://vegetablesly-image.stor.sinaapp.com/gl1.png\" /><img alt=\"\" src=\"http://localhost:8080/test1/image/gl1.png\" /></p>\r\n\r\n<p>新藏线在众多热爱骑行的驴友心中是最艰苦、最考验毅力、环境最恶劣、人烟最稀少的极限骑行路线，新藏公路全长1455公里，是几条进藏路线中最危险的。然而沿途可欣赏连绵的雪山、密布的湖群、天气多变的喀喇昆仑山、盛极一时的古格王国遗址、神山冈仁波齐峰、圣湖玛旁雍错和黄教发源地&mdash;&mdash;萨迦寺，还能看到成群的藏野驴、黄羊等野生动物，场面十分准壮观，使这里成为探险者的乐园。七、八月，冬天大雪封山，路不通，其他季节也常有在路上受阻的时候，少则一两天，多则四五天。建议游玩三天。</p>\r\n',1),('<p><img alt=\"\" src=\"https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1306507973,3904226699&amp;fm=200&amp;gp=0.jpg\" style=\"height:332px; width:500px\" /></p>\r\n\r\n<p>迎客松屹立在黄山风景区玉屏楼的青狮石旁，海拔1670米处。树干中部伸出长达7.6米的两大侧枝展向前方，恰似一位好客的主人，伸出手臂，热情地欢迎五湖四海的宾客来黄山游览。迎客松不仅是黄山的象征，也是整个民族的骄傲，她代表了一种坚韧而顽强的傲骨。北京人民大会堂安徽厅陈列的巨幅铁画《迎客松》就是根据其形象做成。</p>\r\n',2),('<p><img alt=\"\" src=\"https://gss0.baidu.com/6b1IcTe9R1gBo1vgoIiO_jowehsv/maps/services/thumbnails?width=525&amp;height=295&amp;quality=100&amp;align=middle,middle&amp;src=http://gss0.baidu.com/7LsWdDW5_xN3otqbppnN2DJv/lvpics/pic/item/e1fe9925bc315c6082e6bd418fb1cb1349547729.jpg\" style=\"height:295px; width:525px\" /></p>\r\n\r\n<p>杭州风景美丽，人间天堂名不虚传。整个城市的绿化很好，空气很清新。最著名的景点就是西湖，西溪湿地也很舒服。杭州的生活节奏不快，租借一辆自行车在市区骑行也很不错。</p>\r\n\r\n<p>杭州，曾经因为一句&ldquo;上有天堂，下有苏杭&rdquo;而成为人们印象中天堂的化身，也曾因为&ldquo;梁祝&rdquo;、&ldquo;白蛇传&rdquo;而披上凄美浪漫的头纱。那都是几百年前的事情啦。但庆幸的是，西子湖的一潭碧水、龙井灵隐的茶园茂林和杭州人内敛隽秀的个性，让杭州至今仍保持着大家闺秀的风范。 如果，把杭州比喻成一个人的话，那一定是一个有着明亮双眸、读过一些诗书、柔声细语、总是微笑偶尔落泪，且待字闺中的大小姐。 她有得天独厚却不张扬的美貌，浓妆淡抹总相宜的西湖、清幽的九溪十八涧、闹中取静的西溪湿地、闲云野鹤般存在的西泠印社，让几乎每一个来过的人都称赞不绝；她也有耍小性子的时候，连续40天不放晴的梅雨天、越来越炎热难当的桑拿夏日、湿冷透骨的冬天，让生活在这儿的人，忍不住产生逃离的念头。可一旦离开，就又会无限想念。 真似一个不着痕迹就能引人牵肠挂肚的小妮子！</p>\r\n\r\n<p>最佳季节：3-5月。春季最佳。杭州四季景色各异，不过春季百花争艳，是杭州最美丽的时候。</p>\r\n\r\n<p>建议游玩：3-5天</p>\r\n',3),('<p>gggggggg</p>\r\n',4);
/*!40000 ALTER TABLE `stratety` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team`
--

DROP TABLE IF EXISTS `team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `plan_id` bigint(20) NOT NULL,
  `captain_id` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team`
--

LOCK TABLES `team` WRITE;
/*!40000 ALTER TABLE `team` DISABLE KEYS */;
INSERT INTO `team` VALUES (1,'aaa',2,'1152220127');
/*!40000 ALTER TABLE `team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `team_member`
--

DROP TABLE IF EXISTS `team_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `team_member` (
  `team_id` bigint(20) NOT NULL,
  `member_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `team_member`
--

LOCK TABLES `team_member` WRITE;
/*!40000 ALTER TABLE `team_member` DISABLE KEYS */;
INSERT INTO `team_member` VALUES (1,1152220127),(1,1152220127),(1,1152220126);
/*!40000 ALTER TABLE `team_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `travel_log`
--

DROP TABLE IF EXISTS `travel_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `travel_log` (
  `plan_id` bigint(20) NOT NULL,
  `log_index` int(11) NOT NULL,
  `time` date NOT NULL,
  `log` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travel_log`
--

LOCK TABLES `travel_log` WRITE;
/*!40000 ALTER TABLE `travel_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `travel_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `travelhobby`
--

DROP TABLE IF EXISTS `travelhobby`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `travelhobby` (
  `id` varchar(225) NOT NULL,
  `index` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travelhobby`
--

LOCK TABLES `travelhobby` WRITE;
/*!40000 ALTER TABLE `travelhobby` DISABLE KEYS */;
INSERT INTO `travelhobby` VALUES ('1150310210',5),('1150310210',6),('1150310210',7),('1150310210',10),('1150310210',12),('1150310210',13);
/*!40000 ALTER TABLE `travelhobby` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `travelhobbytags`
--

DROP TABLE IF EXISTS `travelhobbytags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `travelhobbytags` (
  `index` int(11) NOT NULL,
  `tagname` varchar(225) NOT NULL,
  PRIMARY KEY (`index`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travelhobbytags`
--

LOCK TABLES `travelhobbytags` WRITE;
/*!40000 ALTER TABLE `travelhobbytags` DISABLE KEYS */;
INSERT INTO `travelhobbytags` VALUES (1,'地文景观'),(2,'水域风光'),(3,'生物景观'),(4,'天象与气候'),(5,'历史遗迹'),(6,'建筑物'),(7,'博物馆'),(8,'民族民俗'),(9,'宗教'),(10,'主题公园'),(11,'旅游度假区'),(12,'美食类'),(13,'探险类'),(14,'刺激类');
/*!40000 ALTER TABLE `travelhobbytags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `travelplan`
--

DROP TABLE IF EXISTS `travelplan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `travelplan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `team_id` bigint(20) DEFAULT NULL,
  `path_id` bigint(20) NOT NULL,
  `date_begin` date NOT NULL,
  `date_end` date DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `state` smallint(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travelplan`
--

LOCK TABLES `travelplan` WRITE;
/*!40000 ALTER TABLE `travelplan` DISABLE KEYS */;
/*!40000 ALTER TABLE `travelplan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_relation`
--

DROP TABLE IF EXISTS `user_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_relation` (
  `following_user_id` varchar(255) NOT NULL,
  `followed_user_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_relation`
--

LOCK TABLES `user_relation` WRITE;
/*!40000 ALTER TABLE `user_relation` DISABLE KEYS */;
INSERT INTO `user_relation` VALUES ('1152220127','1152220126'),('1150310228','1152220127');
/*!40000 ALTER TABLE `user_relation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-12 16:24:51
