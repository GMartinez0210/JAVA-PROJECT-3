CREATE DATABASE  IF NOT EXISTS `projectdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `projectdb`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: projectdb
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `alerta`
--

DROP TABLE IF EXISTS `alerta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alerta` (
  `codAlerta` int NOT NULL AUTO_INCREMENT,
  `codUsuario` int DEFAULT NULL,
  `descripBreveAlerta` varchar(50) DEFAULT NULL,
  `descripcionAlerta` varchar(200) DEFAULT NULL,
  `relevanciaAlerta` tinyint NOT NULL,
  `derivadaAlerta` char(2) DEFAULT NULL,
  `fechaAlerta` date DEFAULT NULL,
  `plazoAlerta` date DEFAULT NULL,
  `estadoAlerta` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`codAlerta`),
  KEY `codUsuario_alerta_idx` (`codUsuario`),
  CONSTRAINT `codUsuario_alerta` FOREIGN KEY (`codUsuario`) REFERENCES `usuario` (`codUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alerta`
--

LOCK TABLES `alerta` WRITE;
/*!40000 ALTER TABLE `alerta` DISABLE KEYS */;
INSERT INTO `alerta` VALUES (4,NULL,'Being tested by Genaro',NULL,1,NULL,'2022-06-07',NULL,NULL);
/*!40000 ALTER TABLE `alerta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `anexo_1`
--

DROP TABLE IF EXISTS `anexo_1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `anexo_1` (
  `codAnexo` int NOT NULL AUTO_INCREMENT,
  `descripcionAnexo` varchar(200) NOT NULL,
  PRIMARY KEY (`codAnexo`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anexo_1`
--

LOCK TABLES `anexo_1` WRITE;
/*!40000 ALTER TABLE `anexo_1` DISABLE KEYS */;
INSERT INTO `anexo_1` VALUES (1,'Accesos no autorizados al correo electrónico, internet, servidores u otros'),(2,'Acceso físico no autorizado a los recursos y/o instalaciones de la organización'),(3,'Uso inadecuado de los recursos tecnológicos de la organización'),(4,'Divulgación no autorizada de información física '),(5,'Divulgación no autorizada de información digital '),(6,'Pérdida de Información en servicios, equipos o instalaciones '),(7,'Robo de información digital '),(8,'Robo de información física '),(9,'Robo o pérdida de equipos informáticos (PCs, Tablets, Smartphones de la institución)'),(10,'Destrucción no autorizada de información'),(11,'Uso no autorizado de la información '),(12,'Falla o sobrecarga de los sistemas de información '),(13,'Falla o sobrecarga de las comunicaciones '),(14,'Modificación no autorizada de un sitio o página web de la institución'),(15,'Modificación, instalación o eliminación no autorizada de software'),(16,'Cambios no controlados en Sistemas de Información'),(17,'Ataques de ingeniería social (phishing)'),(18,'Ataques de denegación de servicio o bloqueo de acceso '),(19,'Ataque o infección por código malicioso (virus, troyanos, otros) '),(20,'Desastres Naturales (sismos, inundaciones, otros) '),(21,'Desastres no Naturales (incendios, aniegos, otros)'),(22,'Interrupción, degradación y/o intermitencia de los servicios TI '),(23,'Fallas de alimentación eléctrica con duración mayor a la autonomia del UPS');
/*!40000 ALTER TABLE `anexo_1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `anexo_2`
--

DROP TABLE IF EXISTS `anexo_2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `anexo_2` (
  `codAnexo` int NOT NULL AUTO_INCREMENT,
  `nivelAnexo` varchar(45) NOT NULL,
  PRIMARY KEY (`codAnexo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anexo_2`
--

LOCK TABLES `anexo_2` WRITE;
/*!40000 ALTER TABLE `anexo_2` DISABLE KEYS */;
INSERT INTO `anexo_2` VALUES (0,'NO ASIGNADO'),(1,'ALTO'),(2,'MEDIO'),(3,'BAJO');
/*!40000 ALTER TABLE `anexo_2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estado` (
  `codEstado` int NOT NULL AUTO_INCREMENT,
  `descripcionEstado` varchar(200) NOT NULL,
  PRIMARY KEY (`codEstado`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` VALUES (1,'REGISTRADO'),(2,'ANULADO'),(3,'EN ESPERA'),(4,'EVALUADO');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reportes`
--

DROP TABLE IF EXISTS `reportes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reportes` (
  `codReporte` int NOT NULL AUTO_INCREMENT,
  `descripcionReporte` varchar(45) DEFAULT NULL,
  `codTipoUsuario` int NOT NULL,
  `codEstado` int DEFAULT NULL,
  `codAnexo` int DEFAULT NULL,
  `codAnexo2` int DEFAULT '0',
  `fechaReporte` date DEFAULT NULL,
  `fechaEvaluacion` date DEFAULT NULL,
  PRIMARY KEY (`codReporte`),
  KEY `codAnexo2_reportes_idx` (`codAnexo2`),
  KEY `codAnexo_reportes_idx` (`codAnexo`),
  KEY `codEstado_reportes_idx` (`codEstado`),
  KEY `codTipoUsuario_reportes_idx` (`codTipoUsuario`),
  CONSTRAINT `codAnexo2_reportes` FOREIGN KEY (`codAnexo2`) REFERENCES `anexo_2` (`codAnexo`),
  CONSTRAINT `codAnexo_reportes` FOREIGN KEY (`codAnexo`) REFERENCES `anexo_1` (`codAnexo`),
  CONSTRAINT `codEstado_reportes` FOREIGN KEY (`codEstado`) REFERENCES `estado` (`codEstado`),
  CONSTRAINT `codTipoUsuario_reportes` FOREIGN KEY (`codTipoUsuario`) REFERENCES `tipo_usuario` (`codTipoUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reportes`
--

LOCK TABLES `reportes` WRITE;
/*!40000 ALTER TABLE `reportes` DISABLE KEYS */;
INSERT INTO `reportes` VALUES (1,'Fallo de sistema',4,2,21,1,'2022-05-17','2022-06-15'),(2,'Caida de google',5,4,14,1,'2022-05-18','2022-06-13'),(3,'Me muero de sueño',2,4,5,1,'2022-05-25','2022-06-01'),(7,'Fallo de gastos',1,1,NULL,3,'2022-06-09',NULL),(10,'Anonimus entro al sistema',1,3,5,1,'2022-06-09','2022-06-01'),(11,'Panchito me hackeo',1,2,5,0,'2022-05-05',NULL),(12,'La db fallo',2,4,NULL,0,'2022-04-16',NULL),(13,'Toreto nos robo el auto',1,1,NULL,1,'2022-06-01',NULL),(14,'Perdi mis lentes',2,4,NULL,0,'2022-01-10',NULL),(15,'Nos han mentido',3,2,NULL,0,'2022-01-02',NULL);
/*!40000 ALTER TABLE `reportes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_usuario`
--

DROP TABLE IF EXISTS `tipo_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_usuario` (
  `codTipoUsuario` int NOT NULL AUTO_INCREMENT,
  `descripcionTipoUsuario` varchar(200) NOT NULL,
  PRIMARY KEY (`codTipoUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_usuario`
--

LOCK TABLES `tipo_usuario` WRITE;
/*!40000 ALTER TABLE `tipo_usuario` DISABLE KEYS */;
INSERT INTO `tipo_usuario` VALUES (1,'Usuario'),(2,'OSI'),(3,'Responsable de monitoreo'),(4,'Mesa de Servicio'),(5,'Responsable de la atencion ');
/*!40000 ALTER TABLE `tipo_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `codUsuario` int NOT NULL AUTO_INCREMENT,
  `dniUsuario` char(8) NOT NULL,
  `claveUsuario` varchar(50) NOT NULL,
  `nombreUsuario` varchar(50) NOT NULL,
  `apellidoUsuario` varchar(50) NOT NULL,
  `codTipo` int NOT NULL,
  PRIMARY KEY (`codUsuario`),
  UNIQUE KEY `dniUsuario_UNIQUE` (`dniUsuario`),
  KEY `codTipo_usuario_idx` (`codTipo`),
  CONSTRAINT `codTipo_usuario` FOREIGN KEY (`codTipo`) REFERENCES `tipo_usuario` (`codTipoUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'71490743','123','Genaro','Martinez',1),(2,'71490744','123','Felix','Criollo',2),(3,'71490745','123','Adhemar','Romero',3),(4,'71490746','123','Mirella','Morales',4),(5,'71490747','123','Alessandro','Pastor',5);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'projectdb'
--

--
-- Dumping routines for database 'projectdb'
--
/*!50003 DROP PROCEDURE IF EXISTS `proc_evaluarReportes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_evaluarReportes`(cod int, usuario int, descripcion varchar(45), fecha date, estado int, anexo int, fechaev date)
update reportes 
set 
codTipoUsuario = usuario,
descripcionReporte = descripcion, 
fechaReporte = fecha,
codEstado = estado, 
codAnexo = anexo, 
fechaevaluacion = fechaev
where codReporte = cod ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `proc_listarreportes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_listarreportes`()
select r.codReporte, u.descripcionTipoUsuario, r.descripcionReporte, r.fechaReporte, e.descripcionEstado
from reportes as r
inner join tipo_usuario as u
on r.codTipoUsuario = u.codTipoUsuario
inner join estado as e
on r.codEstado = e.codEstado ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Proc_listarReporteXPrioridad` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Proc_listarReporteXPrioridad`(cod_prio int)
select codReporte, codAnexo2, descripcionReporte from reportes 
where codAnexo2 = cod_prio ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `proc_mostrarRegistros` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_mostrarRegistros`()
select r.codReporte, u.descripcionTipoUsuario, r.descripcionReporte, r.fechaReporte, e.descripcionEstado, r.codAnexo, r.fechaReporte
from reportes as r
inner join tipo_usuario as u
on r.codTipoUsuario = u.codTipoUsuario
inner join estado as e
on r.codEstado = e.codEstado ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Proc_updatePrioridadXCod` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Proc_updatePrioridadXCod`(cod int, cod_prio int)
update reportes set codAnexo2 = cod_prio
where codReporte = cod ;;
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

-- Dump completed on 2022-06-08 16:06:15
