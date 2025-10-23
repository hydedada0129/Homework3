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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `customerid` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `companyname` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'CUST001','test','test123','杜約翰','科技新星有限公司','0912-345-678','台灣台北市','john@example.com','2025-01-05 09:30:15'),(2,'CUST002','jane_smith','abc456','史密斯珍妮','創新軟體股份有限公司','0922-876-543','台灣高雄市','jane@example.com','2025-02-12 14:20:10'),(3,'CUST003','mike_lee','mike789','李麥克','未來科技有限公司','0933-112-334','台灣台中市','mike@example.com','2025-03-08 11:45:05'),(4,'CUST004','lisa_wang','lisa321','王麗莎','綠能解決方案','0944-556-778','台灣台南市','lisa@example.com','2025-04-20 16:55:30'),(5,'CUST005','tom_huang','tom987','黃湯姆','天際企業有限公司','0955-667-889','台灣新竹市','tom@example.com','2025-05-15 08:10:50'),(6,'CUST006','bob123','b1b2b3','劉鮑伯','創新企業有限公司','0977-888-999','台灣台中市','bob@example.com','2025-10-16 22:45:41'),(7,'CUST007','test2','test222','Vincent','X Shoes','0911222333','台北市內湖區','','2025-10-18 12:24:19'),(8,'CUST008','test3','test333','Andy Liu','AL Entertainment','09223334444','香港','ale@example.com','2025-10-18 12:30:42'),(9,'CUST009','test4','test444','Bobby','Long Beach企業有限公司','09445556666','台灣台中市','lb@example.com',NULL),(10,'CUST010','test4test4','test4444','Long','Beach company','0988999444','雲林縣萬丹','',NULL),(11,'CUST011','test5','test555','Selena','google','0966777888','Monteray Park','sj@example.com',NULL),(12,'CUST012','test6','test666','Uno Lin','Uno Sushi','0966888777','日本千頁縣','ul@example.com',NULL),(13,'CUST013','test7','test777','Jordan Ming','Niko Shoes','0977888999','美國洛磯山','jm@example.com',NULL),(14,'CUST014','test8','test888','Joe Ten','Gold Supply','0999888777','台東縣平安鄉','gs@example.com',NULL),(15,'CUST015','test9','test999','Opula Ping','Comedian Entertainment','0900112335','美國紐約州皇后區','ce@example.com',NULL),(16,'CUST016','test10','test1010','Peter Huang','Computer Inc','0912312321','桃園縣平鎮市','ci@example.com',NULL),(17,'CUST017','test11','test1111','Ian Jiang','黃浦實業','0955464312','日本廣島','huang@example,com',NULL),(18,'CUST018','test12','test1212','Gang Ning','討債公司','09898989889','屏東縣萬丹','money@example.com',NULL),(19,'CUST019','test13','test1313','Kenji Qi','台達點子','09999999999','台南市馬稠后里','delta@example.com',NULL),(20,'CUST020','test14','test1414','Ban Mei','達拉斯地產','09000000000','美國達拉斯','dallas@example.com',NULL),(21,'CUST021','test15','test1515','Anthony Jo','Barbecue','09882221111','美國加州羅蘭剛','bar@example.com',NULL),(22,'CUST022','test16','test1616','UUU','lol company','0975325416','台北澄清湖','lol@example.com',NULL),(23,'CUST023','test17','test1717','Lin Zero','Bank inc','0946587965','新北市板橋','bi@example.com',NULL),(24,'CUST024','test18','test1818','Ann Kuo','class 302','0934216549','Rowland Heights','class@example.com',NULL),(25,'CUST025','test19','test1919','JoJo','ComicBook inc','09132165468','日本北海道','cb@example.com',NULL),(26,'CUST026','test20','test2020','Jackie Wu','Night Show','09885552222','台北長安東路','ns@example.com',NULL),(27,'CUST027','test21','test2121','Ginger Fu','Tofo company','0944512356','台北深坑','tc@example.com',NULL),(28,'CUST028','test22','test2222','Yo Ming','NBA inc','0955668798','大陸廣州','nba@example.com',NULL),(29,'CUST029','test23','test2323','Ian Lee','Amazon inc','0946598735','台北市文山區','ama@example.com',NULL),(30,'CUST030','test24','test2424','Paul George','Laker','0911111442','Los Angeles','laker@example.com',NULL),(31,'CUST031','test25','test2525','John Jo','Delta Electronic','0987443216','East Vale','DE@example.com',NULL),(32,'CUST032','test26','test2626','Jing Jia','Sport Goods','09002003000','Anaheim','sg@example.com',NULL),(33,'CUST033','test27','test2727','Ford Wen','Ford Motor','09887798456','Detroit','ford@example.com',NULL),(34,'CUST034','test28','test2828','Ken','GooDonut','0945645645','北車','goo@example.com',NULL),(35,'CUST035','test29','test2929','Sebrina Ho','Garden Cafe','09789845645','San Gabrial','gc@example.com',NULL),(36,'CUST036','test30','test3030','William Chang','OK Supermarket','54321','屏東縣山地們','ok@example.com',NULL),(37,'CUST037','test31','test3131','Mo Jo','TSMC','09494945959','Arizona','ooo@example.com','2025-10-18 23:11:56'),(38,'CUST038','test38','test3838','三八','八三夭','0938383838','台北市八德三路','83@example.com','2025-10-21 20:18:04'),(39,'CUST039','test39','test3939','Hellan','Hair Salon','0944545664','屏東縣白河鄉','hs@example.com','2025-10-21 20:23:27'),(40,'CUST040','test41','test4141','41','41','41','41','41','2025-10-21 23:36:20');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
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
