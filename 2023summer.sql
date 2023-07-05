-- MySQL dump 10.13  Distrib 5.7.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: test1
-- ------------------------------------------------------
-- Server version	5.7.31-log

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
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class` (
  `class_no` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '班级号',
  `ter_no` int(10) unsigned zerofill DEFAULT NULL COMMENT '专业号',
  `co_no` int(11) DEFAULT NULL COMMENT '学院号',
  PRIMARY KEY (`class_no`) USING BTREE,
  KEY `class_college__fk` (`co_no`),
  KEY `class_teacher__fk` (`ter_no`),
  CONSTRAINT `class_college__fk` FOREIGN KEY (`co_no`) REFERENCES `college` (`co_no`),
  CONSTRAINT `class_teacher__fk` FOREIGN KEY (`ter_no`) REFERENCES `teacher` (`tea_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classtable`
--

DROP TABLE IF EXISTS `classtable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classtable` (
  `class_no` int(11) NOT NULL COMMENT '班级号',
  `class_order` int(11) NOT NULL COMMENT '第几节课',
  `class_weekday` varchar(255) NOT NULL COMMENT '周几',
  `sub_no` int(10) unsigned zerofill DEFAULT NULL COMMENT '课程号',
  `tea_no` int(10) unsigned zerofill DEFAULT NULL COMMENT '教师工号',
  PRIMARY KEY (`class_no`,`class_order`,`class_weekday`) USING BTREE,
  KEY `ClassNo` (`class_no`) USING BTREE,
  KEY `classtable_teacher__fk` (`tea_no`),
  KEY `classtable_subject__fk` (`sub_no`),
  CONSTRAINT `classtable_subject__fk` FOREIGN KEY (`sub_no`) REFERENCES `subject` (`sub_no`),
  CONSTRAINT `classtable_teacher__fk` FOREIGN KEY (`tea_no`) REFERENCES `teacher` (`tea_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classtable`
--

LOCK TABLES `classtable` WRITE;
/*!40000 ALTER TABLE `classtable` DISABLE KEYS */;
/*!40000 ALTER TABLE `classtable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classtostudent`
--

DROP TABLE IF EXISTS `classtostudent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classtostudent` (
  `class_no` int(11) NOT NULL COMMENT '班级号',
  `stu_no` int(255) unsigned zerofill DEFAULT NULL COMMENT '学号',
  PRIMARY KEY (`class_no`) USING BTREE,
  KEY `classtostudent_student__fk` (`stu_no`),
  CONSTRAINT `classtostudent_student__fk` FOREIGN KEY (`stu_no`) REFERENCES `student` (`stu_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classtostudent`
--

LOCK TABLES `classtostudent` WRITE;
/*!40000 ALTER TABLE `classtostudent` DISABLE KEYS */;
/*!40000 ALTER TABLE `classtostudent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `college`
--

DROP TABLE IF EXISTS `college`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `college` (
  `co_no` int(11) NOT NULL COMMENT '学院号',
  `co_name` varchar(255) DEFAULT NULL COMMENT '学院名',
  PRIMARY KEY (`co_no`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `college`
--

LOCK TABLES `college` WRITE;
/*!40000 ALTER TABLE `college` DISABLE KEYS */;
/*!40000 ALTER TABLE `college` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grade`
--

DROP TABLE IF EXISTS `grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grade` (
  `stu_no` int(11) NOT NULL COMMENT '学号',
  `sub_no` int(11) NOT NULL COMMENT '课程号',
  `grade` float(255,0) unsigned DEFAULT NULL COMMENT '成绩',
  PRIMARY KEY (`stu_no`,`sub_no`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade`
--

LOCK TABLES `grade` WRITE;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `report` (
  `re_no` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '报告号',
  `stu_no` int(255) unsigned zerofill DEFAULT NULL COMMENT '学号',
  `tea_no` int(10) unsigned zerofill DEFAULT NULL COMMENT '教师工号',
  `re_location` varchar(255) DEFAULT NULL COMMENT '文件地址（相对）',
  `upload_date` datetime DEFAULT NULL COMMENT '上传时间',
  PRIMARY KEY (`re_no`) USING BTREE,
  KEY `report_student__fk` (`stu_no`),
  KEY `report_teacher__fk` (`tea_no`),
  CONSTRAINT `report_student__fk` FOREIGN KEY (`stu_no`) REFERENCES `student` (`stu_no`),
  CONSTRAINT `report_teacher__fk` FOREIGN KEY (`tea_no`) REFERENCES `teacher` (`tea_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `stu_no` int(255) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '学号',
  `stu_name` varchar(255) NOT NULL COMMENT '姓名',
  `stu_sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `stu_year` year(4) DEFAULT NULL COMMENT '入学年',
  `ter_no` int(10) unsigned zerofill DEFAULT NULL COMMENT '专业号',
  PRIMARY KEY (`stu_no`) USING BTREE,
  KEY `student_teacher__fk` (`ter_no`),
  CONSTRAINT `student_teacher__fk` FOREIGN KEY (`ter_no`) REFERENCES `teacher` (`tea_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject` (
  `sub_no` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '课程号',
  `tea_no` int(10) unsigned zerofill DEFAULT NULL COMMENT '教师工号',
  `sub_name` varchar(255) NOT NULL COMMENT '课程名',
  PRIMARY KEY (`sub_no`) USING BTREE,
  KEY `subject_teacher__fk` (`tea_no`),
  CONSTRAINT `subject_teacher__fk` FOREIGN KEY (`tea_no`) REFERENCES `teacher` (`tea_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `tea_no` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '教师工号',
  `tea_col_no` int(11) DEFAULT NULL COMMENT '学院号',
  `tea_name` varchar(255) DEFAULT NULL COMMENT '教师姓名',
  `tea_level` varchar(255) DEFAULT NULL COMMENT '教师职称',
  PRIMARY KEY (`tea_no`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `terminology`
--

DROP TABLE IF EXISTS `terminology`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `terminology` (
  `ter_no` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '专业号',
  `ter_name` varchar(255) DEFAULT NULL COMMENT '专业名称',
  PRIMARY KEY (`ter_no`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `terminology`
--

LOCK TABLES `terminology` WRITE;
/*!40000 ALTER TABLE `terminology` DISABLE KEYS */;
/*!40000 ALTER TABLE `terminology` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userform`
--

DROP TABLE IF EXISTS `userform`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userform` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码，用md5码存储',
  `power` varchar(255) DEFAULT NULL COMMENT 'teacher/admin/student',
  `tea_no` int(10) unsigned zerofill DEFAULT NULL COMMENT '教师工号，为教师时填写',
  `stu_no` int(255) unsigned zerofill DEFAULT NULL COMMENT '学生学号，为学生时填写',
  PRIMARY KEY (`user_id`) USING BTREE,
  KEY `userform_teacher__fk` (`tea_no`),
  KEY `userform_student__fk` (`stu_no`),
  CONSTRAINT `userform_student__fk` FOREIGN KEY (`stu_no`) REFERENCES `student` (`stu_no`),
  CONSTRAINT `userform_teacher__fk` FOREIGN KEY (`tea_no`) REFERENCES `teacher` (`tea_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userform`
--

LOCK TABLES `userform` WRITE;
/*!40000 ALTER TABLE `userform` DISABLE KEYS */;
/*!40000 ALTER TABLE `userform` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-05 14:10:43
