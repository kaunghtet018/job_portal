-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: jobportaldb
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `jobpost`
--

DROP TABLE IF EXISTS `jobpost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jobpost` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `duedate` date DEFAULT NULL,
  `employer` varchar(100) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `industry` varchar(100) DEFAULT NULL,
  `salary` int DEFAULT NULL,
  `description` text,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jobpost`
--

LOCK TABLES `jobpost` WRITE;
/*!40000 ALTER TABLE `jobpost` DISABLE KEYS */;
INSERT INTO `jobpost` VALUES (16,'Java Developer','2023-10-30','Host Myanmar Mandalay','73A/119-120/mandalay','Full Time','IT industry',500000,'Participate in entire application lifecycle, focusing on coding. \r\nWrite clean code to develop functional web applications. \r\nCollaborate with front-end developers to integrate user-facing elements with server side logic. \r\nGather and address technical and design requirements. ','closed'),(17,'Software/Web Developer','2023-10-30','JJ Global Translation Limited','Ngu War qt/ 11th st/Magway','Full Time','IT Industry',700000,'We are hiring developers.','open'),(18,'Senior PHP Developer','2023-10-30','MYSQL Co., Ltd.','Naing Group SuLe Tower (2), KyaukTada Township, Yangon, Myanmar','Full Time','IT Industry',800000,'Develop, build, troubleshoot, test and maintain the core product software and databases to ensure strong optimization and functionality.','open');
/*!40000 ALTER TABLE `jobpost` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-26 13:05:53
