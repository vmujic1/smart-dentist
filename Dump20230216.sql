CREATE DATABASE  IF NOT EXISTS `freedb_rpr-projekat` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `freedb_rpr-projekat`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: sql.freedb.tech    Database: freedb_rpr-projekat
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `materijali`
--

DROP TABLE IF EXISTS `materijali`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materijali` (
  `id` int NOT NULL AUTO_INCREMENT,
  `naziv` varchar(45) NOT NULL,
  `kolicina` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `naziv_UNIQUE` (`naziv`)
) ENGINE=InnoDB AUTO_INCREMENT=191 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materijali`
--

LOCK TABLES `materijali` WRITE;
/*!40000 ALTER TABLE `materijali` DISABLE KEYS */;
INSERT INTO `materijali` VALUES (2,'rukavice',5),(5,'ilkemma1',21),(7,'Maske',312),(8,'Klompe',77),(9,'Vedran',321),(128,'sad',23),(155,'Novo',2),(156,'dadsaas',231),(178,'papuce',1),(190,'Hrana',10);
/*!40000 ALTER TABLE `materijali` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `narudzbe_pacijenata`
--

DROP TABLE IF EXISTS `narudzbe_pacijenata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `narudzbe_pacijenata` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ime` varchar(45) NOT NULL,
  `prezime` varchar(45) NOT NULL,
  `povod` varchar(45) NOT NULL,
  `datum` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `narudzbe_pacijenata`
--

LOCK TABLES `narudzbe_pacijenata` WRITE;
/*!40000 ALTER TABLE `narudzbe_pacijenata` DISABLE KEYS */;
INSERT INTO `narudzbe_pacijenata` VALUES (83,'Samir','Nasri','Nesto','2023-02-14'),(95,'knh','kbbk','bkkh','2023-02-20'),(97,'Biki','viki','ciki','2023-03-03'),(101,'dsasaddas','sadsadas','dasdsa','2023-03-11');
/*!40000 ALTER TABLE `narudzbe_pacijenata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ime_ordinacije` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `lozinka` varchar(45) NOT NULL,
  `adresa` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `kontakt_telefon` varchar(45) NOT NULL,
  `broj_zaposlenih` varchar(45) NOT NULL,
  `broj_poslovnica` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `ime_ordinacije_UNIQUE` (`ime_ordinacije`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (23,'Kenzzo','ina.mujic','Inipi','Kod medicinskog fakuleta','ina.mujic@gmail.com','061653081','4','1'),(24,'312321','vmujic1','vedran','bčodfab','bofwoiu','buofsb','kdfaj','bjodf'),(25,'etf','profesor','profesor','zmaja od bosne','profa@gmail.com','061152228','10','1'),(104,'ikad','Nesto','Najnovije','sdasd','adssad','dasdas','21','21'),(105,'dsadas','dsada','sdsadsad','dsadas','adsaddas','ddsaas','43','34');
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

-- Dump completed on 2023-02-16 14:24:05
