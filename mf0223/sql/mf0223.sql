-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: mf0223
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
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'entrante'),(2,'primero'),(3,'segundo'),(4,'postre'),(5,'bebida');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plato`
--

DROP TABLE IF EXISTS `plato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plato` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `calorias` int DEFAULT NULL,
  `categoria_id` bigint NOT NULL,
  `procedencia_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_plato_categoria_idx` (`categoria_id`),
  KEY `fk_plato_procedencia1_idx` (`procedencia_id`),
  CONSTRAINT `fk_plato_categoria` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`),
  CONSTRAINT `fk_plato_procedencia1` FOREIGN KEY (`procedencia_id`) REFERENCES `procedencia` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plato`
--

LOCK TABLES `plato` WRITE;
/*!40000 ALTER TABLE `plato` DISABLE KEYS */;
INSERT INTO `plato` VALUES (27,'Lentejas',1000,2,73),(28,'Pato a la pekinesa',400,2,47),(29,'aceitunas',200,1,73),(30,'sushi',350,3,114),(31,'haggis',800,3,180),(32,'hákarl',500,1,110),(33,'canelones',450,3,112),(34,'whisky',300,5,180);
/*!40000 ALTER TABLE `plato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `procedencia`
--

DROP TABLE IF EXISTS `procedencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `procedencia` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=241 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `procedencia`
--

LOCK TABLES `procedencia` WRITE;
/*!40000 ALTER TABLE `procedencia` DISABLE KEYS */;
INSERT INTO `procedencia` VALUES (1,'Afganistán'),(2,'Islas Gland'),(3,'Albania'),(4,'Alemania'),(5,'Andorra'),(6,'Angola'),(7,'Anguilla'),(8,'Antártida'),(9,'Antigua y Barbuda'),(10,'Antillas Holandesas'),(11,'Arabia Saudí'),(12,'Argelia'),(13,'Argentina'),(14,'Armenia'),(15,'Aruba'),(16,'Australia'),(17,'Austria'),(18,'Azerbaiyán'),(19,'Bahamas'),(20,'Bahréin'),(21,'Bangladesh'),(22,'Barbados'),(23,'Bielorrusia'),(24,'Bélgica'),(25,'Belice'),(26,'Benin'),(27,'Bermudas'),(28,'Bhután'),(29,'Bolivia'),(30,'Bosnia y Herzegovina'),(31,'Botsuana'),(32,'Isla Bouvet'),(33,'Brasil'),(34,'Brunéi'),(35,'Bulgaria'),(36,'Burkina Faso'),(37,'Burundi'),(38,'Cabo Verde'),(39,'Islas Caimán'),(40,'Camboya'),(41,'Camerún'),(42,'Canadá'),(43,'República Centroafricana'),(44,'Chad'),(45,'República Checa'),(46,'Chile'),(47,'China'),(48,'Chipre'),(49,'Isla de Navidad'),(50,'Ciudad del Vaticano'),(51,'Islas Cocos'),(52,'Colombia'),(53,'Comoras'),(54,'República Democrática del Congo'),(55,'Congo'),(56,'Islas Cook'),(57,'Corea del Norte'),(58,'Corea del Sur'),(59,'Costa de Marfil'),(60,'Costa Rica'),(61,'Croacia'),(62,'Cuba'),(63,'Dinamarca'),(64,'Dominica'),(65,'República Dominicana'),(66,'Ecuador'),(67,'Egipto'),(68,'El Salvador'),(69,'Emiratos Árabes Unidos'),(70,'Eritrea'),(71,'Eslovaquia'),(72,'Eslovenia'),(73,'España'),(74,'Islas ultramarinas de Estados Unidos'),(75,'Estados Unidos'),(76,'Estonia'),(77,'Etiopía'),(78,'Islas Feroe'),(79,'Filipinas'),(80,'Finlandia'),(81,'Fiyi'),(82,'Francia'),(83,'Gabón'),(84,'Gambia'),(85,'Georgia'),(86,'Islas Georgias del Sur y Sandwich del Sur'),(87,'Ghana'),(88,'Gibraltar'),(89,'Granada'),(90,'Grecia'),(91,'Groenlandia'),(92,'Guadalupe'),(93,'Guam'),(94,'Guatemala'),(95,'Guayana Francesa'),(96,'Guinea'),(97,'Guinea Ecuatorial'),(98,'Guinea-Bissau'),(99,'Guyana'),(100,'Haití'),(101,'Islas Heard y McDonald'),(102,'Honduras'),(103,'Hong Kong'),(104,'Hungría'),(105,'India'),(106,'Indonesia'),(107,'Irán'),(108,'Iraq'),(109,'Irlanda'),(110,'Islandia'),(111,'Israel'),(112,'Italia'),(113,'Jamaica'),(114,'Japón'),(115,'Jordania'),(116,'Kazajstán'),(117,'Kenia'),(118,'Kirguistán'),(119,'Kiribati'),(120,'Kuwait'),(121,'Laos'),(122,'Lesotho'),(123,'Letonia'),(124,'Líbano'),(125,'Liberia'),(126,'Libia'),(127,'Liechtenstein'),(128,'Lituania'),(129,'Luxemburgo'),(130,'Macao'),(131,'ARY Macedonia'),(132,'Madagascar'),(133,'Malasia'),(134,'Malawi'),(135,'Maldivas'),(136,'Malí'),(137,'Malta'),(138,'Islas Malvinas'),(139,'Islas Marianas del Norte'),(140,'Marruecos'),(141,'Islas Marshall'),(142,'Martinica'),(143,'Mauricio'),(144,'Mauritania'),(145,'Mayotte'),(146,'México'),(147,'Micronesia'),(148,'Moldavia'),(149,'Mónaco'),(150,'Mongolia'),(151,'Montserrat'),(152,'Mozambique'),(153,'Myanmar'),(154,'Namibia'),(155,'Nauru'),(156,'Nepal'),(157,'Nicaragua'),(158,'Níger'),(159,'Nigeria'),(160,'Niue'),(161,'Isla Norfolk'),(162,'Noruega'),(163,'Nueva Caledonia'),(164,'Nueva Zelanda'),(165,'Omán'),(166,'Países Bajos'),(167,'Pakistán'),(168,'Palau'),(169,'Palestina'),(170,'Panamá'),(171,'Papúa Nueva Guinea'),(172,'Paraguay'),(173,'Perú'),(174,'Islas Pitcairn'),(175,'Polinesia Francesa'),(176,'Polonia'),(177,'Portugal'),(178,'Puerto Rico'),(179,'Qatar'),(180,'Reino Unido'),(181,'Reunión'),(182,'Ruanda'),(183,'Rumania'),(184,'Rusia'),(185,'Sahara Occidental'),(186,'Islas Salomón'),(187,'Samoa'),(188,'Samoa Americana'),(189,'San Cristóbal y Nevis'),(190,'San Marino'),(191,'San Pedro y Miquelón'),(192,'San Vicente y las Granadinas'),(193,'Santa Helena'),(194,'Santa Lucía'),(195,'Santo Tomé y Príncipe'),(196,'Senegal'),(197,'Serbia y Montenegro'),(198,'Seychelles'),(199,'Sierra Leona'),(200,'Singapur'),(201,'Siria'),(202,'Somalia'),(203,'Sri Lanka'),(204,'Suazilandia'),(205,'Sudáfrica'),(206,'Sudán'),(207,'Suecia'),(208,'Suiza'),(209,'Surinam'),(210,'Svalbard y Jan Mayen'),(211,'Tailandia'),(212,'Taiwán'),(213,'Tanzania'),(214,'Tayikistán'),(215,'Territorio Británico del Océano Índico'),(216,'Territorios Australes Franceses'),(217,'Timor Oriental'),(218,'Togo'),(219,'Tokelau'),(220,'Tonga'),(221,'Trinidad y Tobago'),(222,'Túnez'),(223,'Islas Turcas y Caicos'),(224,'Turkmenistán'),(225,'Turquía'),(226,'Tuvalu'),(227,'Ucrania'),(228,'Uganda'),(229,'Uruguay'),(230,'Uzbekistán'),(231,'Vanuatu'),(232,'Venezuela'),(233,'Vietnam'),(234,'Islas Vírgenes Británicas'),(235,'Islas Vírgenes de los Estados Unidos'),(236,'Wallis y Futuna'),(237,'Yemen'),(238,'Yibuti'),(239,'Zambia'),(240,'Zimbabue');
/*!40000 ALTER TABLE `procedencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'mf0223'
--

--
-- Dumping routines for database 'mf0223'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-20 12:55:52
