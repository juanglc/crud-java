CREATE DATABASE  IF NOT EXISTS `circo` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `circo`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: circo
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `actos`
--

DROP TABLE IF EXISTS `actos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actos` (
  `id_acto` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `esp` int NOT NULL,
  PRIMARY KEY (`id_acto`),
  KEY `fk_esp` (`esp`),
  CONSTRAINT `fk_esp` FOREIGN KEY (`esp`) REFERENCES `especialidades` (`id_especialidad`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actos`
--

LOCK TABLES `actos` WRITE;
/*!40000 ALTER TABLE `actos` DISABLE KEYS */;
INSERT INTO `actos` VALUES (1,'Show de payasos',1),(2,'Rueda de la muerte',2),(3,'Trapecistas Desequilibrados',3),(4,'El Mago Magordo',4);
/*!40000 ALTER TABLE `actos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `id_empleado` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(70) NOT NULL,
  `apellido` varchar(70) NOT NULL,
  `edad` int NOT NULL,
  `especialidad` int NOT NULL,
  `numero_telefonico` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_empleado`),
  KEY `fk_especialidad` (`especialidad`),
  CONSTRAINT `fk_especialidad` FOREIGN KEY (`especialidad`) REFERENCES `especialidades` (`id_especialidad`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (2,'Papo','Rodriguez',19,2,'3111111111'),(3,'Pepo','Pepez',18,3,'3222222222'),(6,'José','Jerez',20,4,'3225556668'),(7,'Alejandro','Tellez',19,3,'311456789'),(8,'Joselin','Joselu',45,2,'2222222221'),(11,'Luis','Forero',18,3,'123456789');
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especialidades`
--

DROP TABLE IF EXISTS `especialidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especialidades` (
  `id_especialidad` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(70) NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_especialidad`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especialidades`
--

LOCK TABLES `especialidades` WRITE;
/*!40000 ALTER TABLE `especialidades` DISABLE KEYS */;
INSERT INTO `especialidades` VALUES (1,'Payaso','El payaso debe tener habilidades sociales para hacer reir a la gente'),(2,'Acrábata en moto','El motociclista debe tener experiencia en el manejo extremo de motocicletas'),(3,'Trapecista','El trapecista debe tener experiencia en el manejo de trapecio y salto en los mismos'),(4,'Mago','El mago debe tener conocimientos y experiencia en ilusión visual');
/*!40000 ALTER TABLE `especialidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `pepopo`
--

DROP TABLE IF EXISTS `pepopo`;
/*!50001 DROP VIEW IF EXISTS `pepopo`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `pepopo` AS SELECT 
 1 AS `nombre_acto`,
 1 AS `nombre`,
 1 AS `apellido`,
 1 AS `nombre_especialidad`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `tablita`
--

DROP TABLE IF EXISTS `tablita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tablita` (
  `id` int NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tablita`
--

LOCK TABLES `tablita` WRITE;
/*!40000 ALTER TABLE `tablita` DISABLE KEYS */;
/*!40000 ALTER TABLE `tablita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `pepopo`
--

/*!50001 DROP VIEW IF EXISTS `pepopo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `pepopo` AS select `actos`.`nombre` AS `nombre_acto`,`empleados`.`nombre` AS `nombre`,`empleados`.`apellido` AS `apellido`,`especialidades`.`nombre` AS `nombre_especialidad` from ((`actos` join `especialidades` on((`actos`.`esp` = `especialidades`.`id_especialidad`))) join `empleados` on((`especialidades`.`id_especialidad` = `empleados`.`especialidad`))) order by `actos`.`nombre` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-16 18:35:31
