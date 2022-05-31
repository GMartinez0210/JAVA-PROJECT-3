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
  `cod` int NOT NULL,
  `descripcion` text,
  PRIMARY KEY (`cod`)
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
  `codigo` int NOT NULL,
  `nivel` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anexos_2`
--

LOCK TABLES `anexos_2` WRITE;
/*!40000 ALTER TABLE `anexos_2` DISABLE KEYS */;
INSERT INTO `anexos_2` VALUES (1,'Alto'),(2,'Medio'),(3,'Bajo');
/*!40000 ALTER TABLE `anexos_2` ENABLE KEYS */;
UNLOCK TABLES;

--
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
-- Table structure for table `tb_estado`
--

DROP TABLE IF EXISTS `tb_estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_estado` (
  `cod` int NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_estado`
--

LOCK TABLES `tb_estado` WRITE;
/*!40000 ALTER TABLE `tb_estado` DISABLE KEYS */;
INSERT INTO `tb_estado` VALUES (1,'recibido'),(2,'anulado'),(3,'en espera');
/*!40000 ALTER TABLE `tb_estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_reportes`
--

DROP TABLE IF EXISTS `tb_reportes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_reportes` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(6) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `estado` int DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_reportes`
--

LOCK TABLES `tb_reportes` WRITE;
/*!40000 ALTER TABLE `tb_reportes` DISABLE KEYS */;
INSERT INTO `tb_reportes` VALUES (1,'US0001','Alerta Interna','2022-04-12',2);
/*!40000 ALTER TABLE `tb_reportes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tipo_usuario`
--

DROP TABLE IF EXISTS `tb_tipo_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tipo_usuario` (
  `codigo` int NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tipo_usuario`
--

LOCK TABLES `tb_tipo_usuario` WRITE;
/*!40000 ALTER TABLE `tb_tipo_usuario` DISABLE KEYS */;
INSERT INTO `tb_tipo_usuario` VALUES (1,'usuario'),(2,'OSI'),(3,'Responsable de monitoreo'),(4,'Mesa de Servicio'),(5,'Responsable de la atencion del incidente');
/*!40000 ALTER TABLE `tb_tipo_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuario`
--

DROP TABLE IF EXISTS `tb_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuario` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `usuario` varchar(6) DEFAULT NULL,
  `clave` varchar(10) DEFAULT NULL,
  `fecnac` date DEFAULT NULL,
  `tipo` int DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuario`
--

LOCK TABLES `tb_usuario` WRITE;
/*!40000 ALTER TABLE `tb_usuario` DISABLE KEYS */;
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-30 17:25:03
