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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `nickname` varchar(65) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  `locked` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (6,'admin','admin','Admin','admin@gmail.com','1000:7ffccc335ca7264bbb79fb54b46ee129:f95102d79a5ff5655d376f01f75217fc5ef784f069045b2ef674d3e348cfb24d09235331699d074750e4c5bd1009a1d8249c7f7be52a6d5e07971cc4f8f28764','admin',0),(9,'Mg','Mg','MgMg007','mgmg@gmail.com','1000:2eeb9930d3b16a4940f2f833e0b0ad35:e4f35fdf46d5f28f91c0fed1517a2ad0fcf20799dde4c521aae9020b8c4a735f1f7bdf5ff883a1d00a15d3cc5834dd8f89a6ed9be54abc3a7ac73edc89b04085','user',0),(10,'Ye','Ye','YeYe123','yeye@gmail.com','1000:ba268cdec7e99ce69d72a0dd5377e118:4a1e76534e69a83d477dfaa31fbc6df61d6d96f010cdeec50a37e8a107ef8aa74132e5a3202b011d75bae150af446d383d2fbf113571b47bd52d0152590fec05','user',0),(11,'kaung','htet','kaunghtet007','kaung@gmail.com','1000:0e6fb80c1b24a2baa35f182d313f1219:2ee393d559d0253ce191b8d373d9638922e20e7472ac89e7f3cb99591893ec8d36fa095643ced38f300d45f3429d40120df537b39fc811a24e77a94c5f2d9a51','user',0),(12,'Mg','Htet','MgHtet','htet@gmail.com','1000:1e23c4e4eac36ebac86cc677135c4c91:5b44a81fc7f04e540a28c74e8b36412a19afa49222ebe278de76683819f9067989e6cfcd7df87daae832ac651b608a182f573fd2b3b7424bc217a42df1cd40dd','user',0),(13,'Kaung','Htet','MgMg007','batbat@gmail.com','1000:88981bf6a2b8030d973548820c0b7d91:00f2e9e15b537d5aa7e3f6accf567f16c98806e1c4f0a6e8666bb1c3e00614cd608dd93aef8113ba602da15c8c73223e6b171fd59bd48b2ae42200a9b27e4424','user',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
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
