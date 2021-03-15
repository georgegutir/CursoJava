-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: supermercado
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `apellidos` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `cif` char(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Javier','Lete','12345678a',NULL),(2,'Pepe','Perez','12345679b',NULL),(3,'Juan','Juanes','87654321A','2021-01-26'),(5,'Juan','Juanes','87654321A','2021-02-19'),(7,'Nuevo','Nuevez Novisimez','13243545Z','2021-01-26'),(8,'Nuevoll','Nuevez Novisimez','13243545Z','2021-01-26'),(9,'Nuevoll','Nuevez Novisimez','13243545Z','2021-02-19'),(10,'Jorge','Lopez','12345678J','2021-03-03'),(11,'Jorge','Lopez','12345678J','2021-03-05'),(12,'Jorge','Lopez','12345678J','2021-03-05');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `clientes_AFTER_INSERT` AFTER INSERT ON `clientes` FOR EACH ROW BEGIN
	insert into historicos (tabla, mensaje) values ('clientes', concat('nuevo cliente: ', new.nombre, ' ', new.apellidos));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `departamentos`
--

DROP TABLE IF EXISTS `departamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamentos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `descripcion` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamentos`
--

LOCK TABLES `departamentos` WRITE;
/*!40000 ALTER TABLE `departamentos` DISABLE KEYS */;
INSERT INTO `departamentos` VALUES (1,'lacteos',NULL),(2,'frescos',NULL),(3,'congelados',NULL),(4,'electronica',NULL),(5,'navidad',NULL),(6,'bebidas',NULL),(7,'Embutido','Embutidos y jamones');
/*!40000 ALTER TABLE `departamentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facturas`
--

DROP TABLE IF EXISTS `facturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facturas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `fecha` date NOT NULL,
  `clientes_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  KEY `fk_facturas_clientes1_idx` (`clientes_id`),
  CONSTRAINT `fk_facturas_clientes1` FOREIGN KEY (`clientes_id`) REFERENCES `clientes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facturas`
--

LOCK TABLES `facturas` WRITE;
/*!40000 ALTER TABLE `facturas` DISABLE KEYS */;
INSERT INTO `facturas` VALUES (1,'20210002','2021-03-09',10),(3,'20210003','2021-03-10',12);
/*!40000 ALTER TABLE `facturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `facturas_completas`
--

DROP TABLE IF EXISTS `facturas_completas`;
/*!50001 DROP VIEW IF EXISTS `facturas_completas`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `facturas_completas` AS SELECT 
 1 AS `id_cliente`,
 1 AS `nombre_cliente`,
 1 AS `apellidos`,
 1 AS `cif`,
 1 AS `id_factura`,
 1 AS `codigo`,
 1 AS `fecha`,
 1 AS `cantidad`,
 1 AS `id_producto`,
 1 AS `nombre_producto`,
 1 AS `descripcion`,
 1 AS `url_imagen`,
 1 AS `precio`,
 1 AS `descuento`,
 1 AS `unidad_medida`,
 1 AS `precio_unidad_medida`,
 1 AS `stock`,
 1 AS `departamentos_id`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `facturas_has_productos`
--

DROP TABLE IF EXISTS `facturas_has_productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facturas_has_productos` (
  `facturas_id` bigint NOT NULL,
  `productos_id` bigint NOT NULL,
  `cantidad` int DEFAULT '1',
  PRIMARY KEY (`facturas_id`,`productos_id`),
  KEY `fk_facturas_has_productos_productos1_idx` (`productos_id`),
  KEY `fk_facturas_has_productos_facturas1_idx` (`facturas_id`),
  CONSTRAINT `fk_facturas_has_productos_facturas1` FOREIGN KEY (`facturas_id`) REFERENCES `facturas` (`id`),
  CONSTRAINT `fk_facturas_has_productos_productos1` FOREIGN KEY (`productos_id`) REFERENCES `productos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facturas_has_productos`
--

LOCK TABLES `facturas_has_productos` WRITE;
/*!40000 ALTER TABLE `facturas_has_productos` DISABLE KEYS */;
INSERT INTO `facturas_has_productos` VALUES (1,2,1),(1,4,2),(3,1,4),(3,4,2),(3,5,1);
/*!40000 ALTER TABLE `facturas_has_productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historicos`
--

DROP TABLE IF EXISTS `historicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historicos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tabla` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `mensaje` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historicos`
--

LOCK TABLES `historicos` WRITE;
/*!40000 ALTER TABLE `historicos` DISABLE KEYS */;
INSERT INTO `historicos` VALUES (1,'clientes','nuevo cliente: Jose Mogro','2021-01-25 10:52:31'),(2,'clientes','nuevo cliente: Nuevo Nuevez Novisimez','2021-01-25 10:57:26'),(3,'clientes','nuevo cliente: Nuevo Nuevez Novisimez','2021-01-25 10:58:01'),(4,'clientes','nuevo cliente: Nuevo Nuevez Novisimez','2021-01-25 10:58:43'),(5,'clientes','nuevo cliente: Nuevo Nuevez Novisimez','2021-01-26 12:50:54'),(6,'clientes','nuevo cliente: Nuevoll Nuevez Novisimez','2021-01-26 12:56:07'),(7,'clientes','nuevo cliente: Nuevoll Nuevez Novisimez','2021-02-19 08:49:40'),(8,'clientes','nuevo cliente: Jorge Lopez','2021-03-09 12:08:34'),(9,'clientes','nuevo cliente: Jorge Lopez','2021-03-10 13:41:16'),(10,'clientes','nuevo cliente: Jorge Lopez','2021-03-10 13:53:38');
/*!40000 ALTER TABLE `historicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimientos`
--

DROP TABLE IF EXISTS `movimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movimientos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `importe` decimal(12,2) NOT NULL,
  `clientes_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cuentas_clientes1_idx` (`clientes_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimientos`
--

LOCK TABLES `movimientos` WRITE;
/*!40000 ALTER TABLE `movimientos` DISABLE KEYS */;
INSERT INTO `movimientos` VALUES (1,500.00,1),(2,300.00,2),(3,-100.00,2);
/*!40000 ALTER TABLE `movimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `descripcion` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `url_imagen` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `precio` decimal(20,2) NOT NULL,
  `descuento` int DEFAULT NULL,
  `unidad_medida` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `precio_unidad_medida` decimal(20,2) DEFAULT NULL,
  `cantidad` int DEFAULT NULL,
  `departamentos_id` int NOT NULL,
  `activo` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `fk_productos_departamentos1_idx` (`departamentos_id`),
  CONSTRAINT `fk_productos_departamentos1` FOREIGN KEY (`departamentos_id`) REFERENCES `departamentos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Cerveza','dougalls negra Stout','SessionStout.jpg',3.00,15,'litro',6.00,0,6,1),(2,'Roscon','con nata','roscon.JPG',15.00,5,'kg',60.00,0,5,1),(3,'Leche entera','valle de soba','collados.JPG',1.50,0,'litro',1.00,0,1,1),(4,'Vino','blanco ','LANCINA.jpg',6.00,5,'litro',4.00,20,6,1),(5,'Chorizo','picante','chorizo.jpg',3.20,10,'kg',16.00,40,7,1);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `clientes_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_usuarios_clientes_idx` (`clientes_id`),
  CONSTRAINT `fk_usuarios_clientes` FOREIGN KEY (`clientes_id`) REFERENCES `clientes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'javier@lete.com','javier',1),(2,'pepe@perez.com','pepe',2),(3,'jorge@lopez','jorge',10);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `facturas_completas`
--

/*!50001 DROP VIEW IF EXISTS `facturas_completas`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `facturas_completas` AS select `c`.`id` AS `id_cliente`,`c`.`nombre` AS `nombre_cliente`,`c`.`apellidos` AS `apellidos`,`c`.`cif` AS `cif`,`f`.`id` AS `id_factura`,`f`.`codigo` AS `codigo`,`f`.`fecha` AS `fecha`,`fp`.`cantidad` AS `cantidad`,`p`.`id` AS `id_producto`,`p`.`nombre` AS `nombre_producto`,`p`.`descripcion` AS `descripcion`,`p`.`url_imagen` AS `url_imagen`,`p`.`precio` AS `precio`,`p`.`descuento` AS `descuento`,`p`.`unidad_medida` AS `unidad_medida`,`p`.`precio_unidad_medida` AS `precio_unidad_medida`,`p`.`cantidad` AS `stock`,`p`.`departamentos_id` AS `departamentos_id` from (((`clientes` `c` join `facturas` `f` on((`c`.`id` = `f`.`clientes_id`))) join `facturas_has_productos` `fp` on((`f`.`id` = `fp`.`facturas_id`))) join `productos` `p` on((`fp`.`productos_id` = `p`.`id`))) */;
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

-- Dump completed on 2021-03-12 11:52:52
