CREATE DATABASE  IF NOT EXISTS `javaprojectdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `javaprojectdb`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: javaprojectdb
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
-- Table structure for table `anexos_1`
--

DROP TABLE IF EXISTS `anexos_1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `anexos_1` (
<<<<<<< HEAD
  `cod_anexo_1` int NOT NULL,
  `descripcion` text,
  PRIMARY KEY (`cod_anexo_1`)
=======
<<<<<<< HEAD
  `cod` int NOT NULL,
  `descripcion` text,
  PRIMARY KEY (`cod`)
=======
  `cod_anexo_1` int NOT NULL,
  `descripcion` text,
  PRIMARY KEY (`cod_anexo_1`)
>>>>>>> 40e502f42de0d1792011f3d9c3b579e429374fc8
>>>>>>> JoseFelixTheOne-Ghost
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anexos_1`
--

LOCK TABLES `anexos_1` WRITE;
/*!40000 ALTER TABLE `anexos_1` DISABLE KEYS */;
INSERT INTO `anexos_1` VALUES (1,'Accesos no autorizados al correo electrónico, internet, servidores u otros'),(2,'Acceso físico no autorizado a los recursos y/o instalaciones de la organización'),(3,'Uso inadecuado de los recursos tecnológicos de la organización'),(4,'Divulgación no autorizada de información física '),(5,'Divulgación no autorizada de información digital '),(6,'Pérdida de Información en servicios, equipos o instalaciones '),(7,'Robo de información digital '),(8,'Robo de información física '),(9,'Robo o pérdida de equipos informáticos (PCs, Tablets, Smartphones de la institución)'),(10,'Destrucción no autorizada de información'),(11,'Uso no autorizado de la información '),(12,'Falla o sobrecarga de los sistemas de información '),(13,'Falla o sobrecarga de las comunicaciones '),(14,'Modificación no autorizada de un sitio o página web de la institución'),(15,'Modificación, instalación o eliminación no autorizada de software'),(16,'Cambios no controlados en Sistemas de Información'),(17,'Ataques de ingeniería social (phishing)'),(18,'Ataques de denegación de servicio o bloqueo de acceso '),(19,'Ataque o infección por código malicioso (virus, troyanos, otros) '),(20,'Desastres Naturales (sismos, inundaciones, otros) '),(21,'Desastres no Naturales (incendios, aniegos, otros)'),(22,'Interrupción, degradación y/o intermitencia de los servicios TI '),(23,'Fallas de alimentación eléctrica con duración mayor a la autonomia del UPS');
/*!40000 ALTER TABLE `anexos_1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `anexos_2`
--

DROP TABLE IF EXISTS `anexos_2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `anexos_2` (
<<<<<<< HEAD
  `cod_anexo_2` int NOT NULL,
  `nivel` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`cod_anexo_2`)
=======
<<<<<<< HEAD
  `codigo` int NOT NULL,
  `nivel` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
=======
  `cod_anexo_2` int NOT NULL,
  `nivel` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`cod_anexo_2`)
>>>>>>> 40e502f42de0d1792011f3d9c3b579e429374fc8
>>>>>>> JoseFelixTheOne-Ghost
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anexos_2`
--

LOCK TABLES `anexos_2` WRITE;
/*!40000 ALTER TABLE `anexos_2` DISABLE KEYS */;
<<<<<<< HEAD
INSERT INTO `anexos_2` VALUES (1,'Alto'),(2,'Medio'),(3,'Bajo');
=======
INSERT INTO `anexos_2` VALUES (0,'NO ASIGNADO'),(1,'ALTO'),(2,'MEDIO'),(3,'BAJO');
>>>>>>> 40e502f42de0d1792011f3d9c3b579e429374fc8
/*!40000 ALTER TABLE `anexos_2` ENABLE KEYS */;
UNLOCK TABLES;

--
<<<<<<< HEAD
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cargo` (
  `idCargo` int NOT NULL AUTO_INCREMENT,
  `desCargo` varchar(45) NOT NULL,
  PRIMARY KEY (`idCargo`),
  UNIQUE KEY `idCargo_UNIQUE` (`idCargo`),
  UNIQUE KEY `desCargo_UNIQUE` (`desCargo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` VALUES (2,'MESA DE SERVICIO'),(3,'OSI'),(1,'USUARIO');
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
=======
<<<<<<< HEAD
=======
-- Table structure for table `tb_alerta`
--

DROP TABLE IF EXISTS `tb_alerta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_alerta` (
  `cod_aler` int NOT NULL AUTO_INCREMENT,
  `cod_user` int DEFAULT NULL,
  `fec_aler` date DEFAULT NULL,
  `descripbreve_aler` varchar(30) DEFAULT NULL,
  `descrip_aler` varchar(80) DEFAULT NULL,
  `relevancia_aler` tinyint(1) NOT NULL,
  `derivada_aler` char(2) DEFAULT NULL,
  `plazoatencion_aler` date DEFAULT NULL,
  PRIMARY KEY (`cod_aler`),
  KEY `idUsuario_idx` (`cod_user`),
  CONSTRAINT `cod_user` FOREIGN KEY (`cod_user`) REFERENCES `tb_usuario` (`cod_user`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_alerta`
--

LOCK TABLES `tb_alerta` WRITE;
/*!40000 ALTER TABLE `tb_alerta` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_alerta` ENABLE KEYS */;
UNLOCK TABLES;

--
>>>>>>> 40e502f42de0d1792011f3d9c3b579e429374fc8
>>>>>>> JoseFelixTheOne-Ghost
-- Table structure for table `tb_estado`
--

DROP TABLE IF EXISTS `tb_estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_estado` (
<<<<<<< HEAD
  `cod_estado` int NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_estado`)
=======
<<<<<<< HEAD
  `cod` int NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod`)
=======
  `cod_estado` int NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_estado`)
>>>>>>> 40e502f42de0d1792011f3d9c3b579e429374fc8
>>>>>>> JoseFelixTheOne-Ghost
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_estado`
--

LOCK TABLES `tb_estado` WRITE;
/*!40000 ALTER TABLE `tb_estado` DISABLE KEYS */;
<<<<<<< HEAD
INSERT INTO `tb_estado` VALUES (1,'registrado'),(2,'anulado'),(3,'en espera');
=======
<<<<<<< HEAD
INSERT INTO `tb_estado` VALUES (1,'recibido'),(2,'anulado'),(3,'en espera');
=======
INSERT INTO `tb_estado` VALUES (1,'REGISTRADO'),(2,'ANULADO'),(3,'EN ESPERA'),(4,'EVALUADO');
>>>>>>> 40e502f42de0d1792011f3d9c3b579e429374fc8
>>>>>>> JoseFelixTheOne-Ghost
/*!40000 ALTER TABLE `tb_estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_reportes`
--

DROP TABLE IF EXISTS `tb_reportes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_reportes` (
<<<<<<< HEAD
  `cod_reporte` int NOT NULL AUTO_INCREMENT,
  `cod_tipo_user` int NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `cod_estado` int DEFAULT NULL,
  PRIMARY KEY (`cod_reporte`),
  KEY `FKTipoUser_idx` (`cod_tipo_user`),
  KEY `FKestado_idx` (`cod_estado`),
  CONSTRAINT `FKestado` FOREIGN KEY (`cod_estado`) REFERENCES `tb_estado` (`cod_estado`),
  CONSTRAINT `FKTipoUser` FOREIGN KEY (`cod_tipo_user`) REFERENCES `tb_tipo_usuario` (`cod_tipo_user`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
=======
<<<<<<< HEAD
  `codigo` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(6) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `estado` int DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
=======
  `cod_reporte` int NOT NULL AUTO_INCREMENT,
  `cod_tipo_user` int NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `cod_estado` int DEFAULT NULL,
  `cod_anexo` int DEFAULT NULL,
  `fecha_evaluacion` date DEFAULT NULL,
  `cod_anexo_2` int DEFAULT '0',
  PRIMARY KEY (`cod_reporte`),
  KEY `FKTipoUser_idx` (`cod_tipo_user`),
  KEY `FKestado_idx` (`cod_estado`),
  KEY `FKAnexo_idx` (`cod_anexo`),
  KEY `FKCod_anexo_2_idx` (`cod_anexo_2`),
  CONSTRAINT `FKAnexo` FOREIGN KEY (`cod_anexo`) REFERENCES `anexos_1` (`cod_anexo_1`),
  CONSTRAINT `FKCod_anexo_2` FOREIGN KEY (`cod_anexo_2`) REFERENCES `anexos_2` (`cod_anexo_2`),
  CONSTRAINT `FKestado` FOREIGN KEY (`cod_estado`) REFERENCES `tb_estado` (`cod_estado`),
  CONSTRAINT `FKTipoUser` FOREIGN KEY (`cod_tipo_user`) REFERENCES `tb_tipo_usuario` (`cod_tipo_user`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
>>>>>>> 40e502f42de0d1792011f3d9c3b579e429374fc8
>>>>>>> JoseFelixTheOne-Ghost
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_reportes`
--

LOCK TABLES `tb_reportes` WRITE;
/*!40000 ALTER TABLE `tb_reportes` DISABLE KEYS */;
<<<<<<< HEAD
INSERT INTO `tb_reportes` VALUES (2,1,'Fallos de Sistema','2022-05-30',1),(3,1,'Fallo de seguridad','2022-05-30',1);
=======
<<<<<<< HEAD
INSERT INTO `tb_reportes` VALUES (1,'US0001','Alerta Interna','2022-04-12',2);
=======
INSERT INTO `tb_reportes` VALUES (1,4,'Fallo de sistema','2022-05-17',2,21,'2022-06-15',0),(2,5,'Caida de google','2022-05-18',4,14,'2022-06-13',0),(3,2,'Me muero de sueño','2022-05-25',4,5,'2022-06-01',0),(7,1,'Fallo de gastos','2022-06-09',1,NULL,NULL,0),(10,2,'Anonimus entro al sistema','2022-06-09',1,21,'2022-06-11',1),(11,1,'Panchito me hackeo','2022-05-05',2,5,NULL,0),(12,2,'La db fallo','2022-04-16',4,NULL,NULL,0),(13,1,'Toreto nos robo el auto','2022-06-01',1,NULL,NULL,1),(14,2,'Perdi mis lentes','2022-01-10',4,NULL,NULL,0),(15,3,'Nos han mentido','2022-01-02',2,NULL,NULL,0);
>>>>>>> 40e502f42de0d1792011f3d9c3b579e429374fc8
>>>>>>> JoseFelixTheOne-Ghost
/*!40000 ALTER TABLE `tb_reportes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipo_usuario`
--

DROP TABLE IF EXISTS `tb_tipo_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tipo_usuario` (
<<<<<<< HEAD
  `cod_tipo_user` int NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_tipo_user`)
=======
<<<<<<< HEAD
  `codigo` int NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
=======
  `cod_tipo_user` int NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_tipo_user`)
>>>>>>> 40e502f42de0d1792011f3d9c3b579e429374fc8
>>>>>>> JoseFelixTheOne-Ghost
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipo_usuario`
--

LOCK TABLES `tb_tipo_usuario` WRITE;
/*!40000 ALTER TABLE `tb_tipo_usuario` DISABLE KEYS */;
<<<<<<< HEAD
INSERT INTO `tb_tipo_usuario` VALUES (1,'Usuario'),(2,'OSI'),(3,'Responsable de monitoreo'),(4,'Mesa de Servicio'),(5,'Responsable de la atencion ');
=======
<<<<<<< HEAD
INSERT INTO `tb_tipo_usuario` VALUES (1,'usuario'),(2,'OSI'),(3,'Responsable de monitoreo'),(4,'Mesa de Servicio'),(5,'Responsable de la atencion del incidente');
=======
INSERT INTO `tb_tipo_usuario` VALUES (1,'Usuario'),(2,'OSI'),(3,'Responsable de monitoreo'),(4,'Mesa de Servicio'),(5,'Responsable de la atencion ');
>>>>>>> 40e502f42de0d1792011f3d9c3b579e429374fc8
>>>>>>> JoseFelixTheOne-Ghost
/*!40000 ALTER TABLE `tb_tipo_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuario`
--

DROP TABLE IF EXISTS `tb_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuario` (
<<<<<<< HEAD
  `cod_user` int NOT NULL AUTO_INCREMENT,
=======
<<<<<<< HEAD
  `codigo` int NOT NULL AUTO_INCREMENT,
>>>>>>> JoseFelixTheOne-Ghost
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `cod_tipo_user` int DEFAULT NULL,
  `clave` varchar(10) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `tipo` int DEFAULT NULL,
<<<<<<< HEAD
  PRIMARY KEY (`cod_user`),
  KEY `FKTipUser_idx` (`cod_tipo_user`),
  CONSTRAINT `FKTipUser` FOREIGN KEY (`cod_tipo_user`) REFERENCES `tb_tipo_usuario` (`cod_tipo_user`)
=======
  PRIMARY KEY (`codigo`)
=======
  `cod_user` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `cod_tipo_user` int DEFAULT NULL,
  `clave` varchar(10) DEFAULT NULL,
  `fecnac` date DEFAULT NULL,
  `tipo` int DEFAULT NULL,
  PRIMARY KEY (`cod_user`),
  KEY `FKTipUser_idx` (`cod_tipo_user`),
  CONSTRAINT `FKTipUser` FOREIGN KEY (`cod_tipo_user`) REFERENCES `tb_tipo_usuario` (`cod_tipo_user`)
>>>>>>> 40e502f42de0d1792011f3d9c3b579e429374fc8
>>>>>>> JoseFelixTheOne-Ghost
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuario`
--

LOCK TABLES `tb_usuario` WRITE;
/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
INSERT INTO `tb_usuario` VALUES (1,'U0001','123','GENARO','MARTINEZ',1),(2,'U0002','456','FELIX','CRIOLLO',1),(3,'M0001','147','ADHEMAR','ROMERO',4),(4,'M0002','258','MIRELA','MORALES',4),(5,'S0001','159','LUIS','CALDERON',2),(6,'S0002','357','JOSE FELIX','HANDSOME',2),(7,'RM001','123','JUANITO','ALCACHOFA',3),(8,'RM002','123','PETER','ELITE',3),(9,'RA001','123','ALESSANDRO','PASTOR',5),(10,'RA002','123','MIDORY','IPARRAGUIRRE',5);
/*!40000 ALTER TABLE `tb_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `idUser` int NOT NULL AUTO_INCREMENT,
  `codUser` varchar(45) NOT NULL,
  `passwordUser` varchar(45) NOT NULL,
  `nameUser` varchar(45) NOT NULL,
  `lastnameUser` varchar(45) NOT NULL,
  `idCargo` int NOT NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE KEY `codUser_UNIQUE` (`codUser`),
  KEY `idCargo_idx` (`idCargo`),
  CONSTRAINT `idCargo` FOREIGN KEY (`idCargo`) REFERENCES `cargo` (`idCargo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'U0001','123','GENARO','MARTINEZ',1),(2,'U0002','456','FELIX','CRIOLLO',1),(3,'M0001','147','ADHEMAR','ROMERO',2),(4,'M0002','258','MIRELA','MORALES',2),(5,'S0001','159','LUIS','CALDERON',3),(6,'S0002','357','JOSE FELIX','HANDSOME',3);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'javaprojectdb'
--

--
-- Dumping routines for database 'javaprojectdb'
--
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
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
update tb_reportes 
set 
cod_tipo_user = usuario,
descripcion = descripcion, 
fecha = fecha,
cod_estado = estado, 
cod_anexo = anexo, 
fecha_evaluacion = fechaev
where cod_reporte = cod ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
>>>>>>> JoseFelixTheOne-Ghost
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
select r.cod_reporte, u.descripcion, r.descripcion, r.fecha, e.descripcion
from tb_reportes r
inner join tb_tipo_usuario u
on r.cod_tipo_user = u.cod_tipo_user
inner join tb_estado e
on r.cod_estado = e.cod_estado ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
<<<<<<< HEAD
=======
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
select cod_reporte, cod_anexo_2, descripcion from tb_reportes 
where cod_anexo_2 = cod_prio ;;
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
select r.cod_reporte, u.descripcion, r.descripcion, r.fecha, e.descripcion, r.cod_anexo, r.fecha_evaluacion
from tb_reportes r
inner join tb_tipo_usuario u
on r.cod_tipo_user = u.cod_tipo_user
inner join tb_estado e
on r.cod_estado = e.cod_estado ;;
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
update tb_reportes set cod_anexo_2 = cod_prio
where cod_reporte = cod ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
>>>>>>> 40e502f42de0d1792011f3d9c3b579e429374fc8
>>>>>>> JoseFelixTheOne-Ghost
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

<<<<<<< HEAD

-- Dump completed on 2022-06-01 18:29:02

-- Dump completed on 2022-05-30 22:35:48

=======
<<<<<<< HEAD
-- Dump completed on 2022-05-21  0:25:42
=======
-- Dump completed on 2022-06-03 19:59:35
>>>>>>> 40e502f42de0d1792011f3d9c3b579e429374fc8
>>>>>>> JoseFelixTheOne-Ghost
