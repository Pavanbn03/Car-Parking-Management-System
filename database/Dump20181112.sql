CREATE DATABASE  IF NOT EXISTS `s` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `sql`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sql
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `amount`
--

DROP TABLE IF EXISTS `amount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `amount` (
  `VID` varchar(45) DEFAULT NULL,
  `Checkin` varchar(45) DEFAULT NULL,
  `Checkout` varchar(45) DEFAULT NULL,
  `Amount` varchar(45) DEFAULT NULL,
  KEY `VID_a` (`VID`),
  CONSTRAINT `VID_a` FOREIGN KEY (`VID`) REFERENCES `customer` (`vid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amount`
--

LOCK TABLES `amount` WRITE;
/*!40000 ALTER TABLE `amount` DISABLE KEYS */;
INSERT INTO `amount` VALUES ('1','Thu Nov 01 19:17:54 IST 2018','Thu Nov 01 19:18:25 IST 2018','1.0'),('2','Thu Nov 01 19:20:10 IST 2018','Thu Nov 01 19:21:21 IST 2018','1.0'),('1','Thu Nov 01 20:42:23 IST 2018','Thu Nov 01 20:42:32 IST 2018','0.0'),('1','Fri Nov 02 09:49:49 IST 2018','Fri Nov 02 09:50:16 IST 2018','1.0'),('1','Fri Nov 02 09:58:28 IST 2018','Fri Nov 02 09:58:49 IST 2018','0.0'),('1','Fri Nov 02 11:33:50 IST 2018','Fri Nov 02 11:34:55 IST 2018','1.0'),('1','Tue Nov 06 13:44:35 IST 2018','Tue Nov 06 13:44:45 IST 2018','0.0'),('1','Tue Nov 06 14:11:32 IST 2018','Tue Nov 06 14:11:36 IST 2018','0.0'),('1','Tue Nov 06 14:12:05 IST 2018','Tue Nov 06 14:12:08 IST 2018','0.0'),('1','Tue Nov 06 14:17:03 IST 2018','Tue Nov 06 14:17:13 IST 2018','0.0'),('3','Tue Nov 06 14:21:23 IST 2018','Tue Nov 06 14:22:01 IST 2018','1.0'),('1','Tue Nov 06 14:21:01 IST 2018','Tue Nov 06 14:22:09 IST 2018','1.0'),('2','Tue Nov 06 14:21:12 IST 2018','Tue Nov 06 14:22:14 IST 2018','1.0'),('4','Tue Nov 06 14:25:29 IST 2018','Tue Nov 06 14:25:58 IST 2018','0.0'),('1','Tue Nov 06 14:25:08 IST 2018','Tue Nov 06 14:26:05 IST 2018','1.0'),('2','Tue Nov 06 14:28:57 IST 2018','Tue Nov 06 14:29:05 IST 2018','1.0');
/*!40000 ALTER TABLE `amount` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `amount_AFTER_INSERT` AFTER INSERT ON `amount` FOR EACH ROW BEGIN
insert into total values(new.VID);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `Fname` varchar(45) DEFAULT NULL,
  `Lname` varchar(45) DEFAULT NULL,
  `Age` varchar(45) DEFAULT NULL,
  `VehicleNo` varchar(45) DEFAULT NULL,
  `VehicleType` varchar(45) DEFAULT NULL,
  `Phno` varchar(45) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `VID` varchar(45) NOT NULL,
  `StaffLogin` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`VID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('pavan','pavan','20','1111','4','789456123','ylk','1','pavan'),('mahesh','kumar','20','5555','4','8521479633','ylk','2','kumar'),('mn','nn','34','4444','4','4343434343','cbpur','3','pavan'),('kamal','k','66','6666','2','87876656','cbpur','4','pavan');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `login` (
  `LoginID` varchar(45) NOT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `Fname` varchar(45) DEFAULT NULL,
  `Lname` varchar(45) DEFAULT NULL,
  `Address` varchar(45) DEFAULT NULL,
  `Phno` varchar(45) DEFAULT NULL,
  `age` varchar(45) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `question` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`LoginID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('kumar','kumar','Pavan','Kumar','cbpur','45645464','20','pavanumar@gmail.com','pavan'),('pavan','pavan','Pavan','BN','Banglore','789956564','20','pavan03@gmail.com','prajwal'),('pavankumar','12345','pavan','kumar','cbpur','123456','20','pavankumar@gmail.com','pavan');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parking`
--

DROP TABLE IF EXISTS `parking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `parking` (
  `VID` varchar(45) DEFAULT NULL,
  `CheckIN` varchar(45) DEFAULT NULL,
  `ParkingSlot` varchar(45) DEFAULT NULL,
  `RemainingSlot` varchar(45) DEFAULT NULL,
  KEY `VID_idx` (`VID`),
  CONSTRAINT `VID_P` FOREIGN KEY (`VID`) REFERENCES `customer` (`vid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parking`
--

LOCK TABLES `parking` WRITE;
/*!40000 ALTER TABLE `parking` DISABLE KEYS */;
/*!40000 ALTER TABLE `parking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `total`
--

DROP TABLE IF EXISTS `total`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `total` (
  `VID` varchar(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `total`
--

LOCK TABLES `total` WRITE;
/*!40000 ALTER TABLE `total` DISABLE KEYS */;
INSERT INTO `total` VALUES ('3'),('1'),('2'),('4'),('1'),('2');
/*!40000 ALTER TABLE `total` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'sql'
--

--
-- Dumping routines for database 'sql'
--
/*!50003 DROP PROCEDURE IF EXISTS `proc` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc`()
BEGIN
select sum(a.amount) from amount a;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-12 14:20:16
