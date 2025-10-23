CREATE DATABASE  IF NOT EXISTS `wholesale` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `wholesale`;
-- MySQL dump 10.13  Distrib 8.0.36, for Linux (x86_64)
--
-- Host: localhost    Database: wholesale
-- ------------------------------------------------------
-- Server version	8.0.43

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `employeeid` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `department` varchar(45) DEFAULT NULL,
  `position` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'E001','王大明','業務部','業務經理','0912345678'),(2,'E002','李美華','會計部','會計專員','0921456789'),(3,'E003','陳志強','資訊部','系統工程師','0933567890'),(4,'E004','林玉珍','人事部','人事助理','0955678901'),(5,'E005','張建國','採購部','採購主管','0966789012'),(6,'E006','周佩玲','行銷部','行銷企劃','0977790123'),(7,'E007','黃俊豪','客服部','客服人員','0988901234'),(8,'E008','吳怡君','設計部','平面設計師','0999012145'),(9,'E009','陳大明','財務部','會計','0911009009'),(10,'E010','林小華','人事部','專員','0911009010'),(11,'E011','張玉婷','資訊部','工程師','0911009011'),(12,'E012','王志強','銷售部','業務','0911009012'),(13,'E013','李欣怡','行銷部','助理','0911009013'),(14,'E014','黃俊傑','研發部','工程師','0911009014'),(15,'E015','周子瑜','客服部','專員','0911009015'),(16,'E016','徐嘉文','財務部','會計','0911009016'),(17,'E017','鄭雅文','人事部','主管','0911009017'),(18,'E018','謝承翰','資訊部','工程師','0911009018'),(19,'E019','劉思涵','銷售部','業務','0911009019'),(20,'E020','何家豪','行銷部','助理','0911009020'),(21,'E021','吳欣怡','研發部','工程師','0911009021'),(22,'E022','洪智傑','客服部','專員','0911009022'),(23,'E023','蔡依林','財務部','會計','0911009023'),(24,'E024','葉志豪','人事部','專員','0911009024'),(25,'E025','梁佩君','資訊部','工程師','0911009025'),(26,'E026','賴冠廷','銷售部','業務','0911009026'),(27,'E027','許雅婷','行銷部','助理','0911009027'),(28,'E028','江宏傑','研發部','工程師','0911009028'),(29,'E029','羅嘉玲','客服部','專員','0911009029');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-10-23 15:30:56
