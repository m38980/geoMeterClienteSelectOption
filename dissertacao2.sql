CREATE DATABASE  IF NOT EXISTS `dissertacao` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `dissertacao`;
-- MySQL dump 10.13  Distrib 5.6.17, for osx10.6 (i386)
--
-- Host: localhost    Database: dissertacao
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cidade`
--

DROP TABLE IF EXISTS `cidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cidade` (
  `idcidade` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcidade`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidade`
--

LOCK TABLES `cidade` WRITE;
/*!40000 ALTER TABLE `cidade` DISABLE KEYS */;
INSERT INTO `cidade` VALUES (1,'São Tomé','Cidade Principal'),(2,'Trindade','Cidade da Trindade'),(3,'Angolares ','Cidade de Angolares'),(4,'Guadalupe ','Cidade de Guadalupe'),(5,'Neves','Cidade de Neves'),(6,'Santana','Cidade de Santana'),(7,'Santo António','Cidade Santo António do Príncipe');
/*!40000 ALTER TABLE `cidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `endereco` varchar(255) NOT NULL,
  `nip` varchar(255) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idcliente`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (3,'Lisandra Paixão','lisy@gmail.com','777 77 88','Rua Nobre12','30303030-1','Cliente 3'),(4,'Lavínea Paixão','lavinea@gmail.com','555 55 55','Rua Nova','40404040-1','Cliente 4'),(5,'Wanderley Pereira','wanderlei@gmail.com','444 44 44','Rua Museu','50505050-1','Cliente 5'),(6,'Wladislau Costa','wladislau@gmail.com','333 33 33','Rua Velha','60606060-1','Cliente 6'),(7,'Adleson Costa','adelson@gmail.com','222 22 22','Rua 8 de Setembro','70707070-1','Cliente 7'),(14,'Alzira Paixão','alzira@gmail.com','986 25 37','Bairro Satón','505050-1','Pré-Pago'),(17,'Eneio Lima','eneio@hotmail.com','991 27 52','Caixão Grande','808080-1','Pós-Pago');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contador`
--

DROP TABLE IF EXISTS `contador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contador` (
  `idcontador` bigint(20) NOT NULL AUTO_INCREMENT,
  `conta_numero` varchar(255) DEFAULT NULL,
  `numero_contador` varchar(255) DEFAULT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `leitura_anterior` int(11) DEFAULT NULL,
  `nova_leitura` int(11) DEFAULT NULL,
  `ramal` varchar(255) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `idcliente` int(11) DEFAULT NULL,
  `idlocalizacao` int(11) DEFAULT NULL,
  `iddistrito` int(11) DEFAULT NULL,
  `idcidade` int(11) DEFAULT NULL,
  PRIMARY KEY (`idcontador`),
  KEY `cliente_fk_idx` (`idcliente`),
  KEY `localizacao_fk_idx` (`idlocalizacao`),
  KEY `distrito_fk_idx` (`iddistrito`),
  KEY `cidade_fk_idx` (`idcidade`),
  CONSTRAINT `fk_cidade` FOREIGN KEY (`idcidade`) REFERENCES `cidade` (`idcidade`),
  CONSTRAINT `fk_cliente` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`),
  CONSTRAINT `fk_distrito` FOREIGN KEY (`iddistrito`) REFERENCES `distrito` (`iddistrito`),
  CONSTRAINT `fk_localizacao` FOREIGN KEY (`idlocalizacao`) REFERENCES `localizacao` (`idlocalizacao`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contador`
--

LOCK TABLES `contador` WRITE;
/*!40000 ALTER TABLE `contador` DISABLE KEYS */;
INSERT INTO `contador` VALUES (3,'10','3000',0.3434343,0.555555,200,410,'Híbrido','90A',3,1,1,1),(4,'20','3000',0.3434343,0.777777,50,60,'Trifásico','80A',4,11,6,2),(5,'30','3000',0.3434343,0.777777,400,1300,'Trifásico','80A',5,20,3,3),(6,'40','1500',0.3393,6.7419,100,110,'Monofásico','60A',17,21,4,4);
/*!40000 ALTER TABLE `contador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distrito`
--

DROP TABLE IF EXISTS `distrito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `distrito` (
  `iddistrito` int(11) NOT NULL AUTO_INCREMENT,
  `abreviatura` char(3) DEFAULT NULL,
  `descricao` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`iddistrito`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distrito`
--

LOCK TABLES `distrito` WRITE;
/*!40000 ALTER TABLE `distrito` DISABLE KEYS */;
INSERT INTO `distrito` VALUES (1,'AG','Água Grande'),(2,'CG','Cantagalo'),(3,'CE','Caué'),(4,'LEB','Lemba'),(5,'LBT','Lobata'),(6,'MZ','Mé-Zochi '),(7,'RAP','Pagué');
/*!40000 ALTER TABLE `distrito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localizacao`
--

DROP TABLE IF EXISTS `localizacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `localizacao` (
  `idlocalizacao` int(11) NOT NULL AUTO_INCREMENT,
  `latitude` varchar(64) NOT NULL,
  `longitude` varchar(64) NOT NULL,
  `descricao` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`idlocalizacao`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localizacao`
--

LOCK TABLES `localizacao` WRITE;
/*!40000 ALTER TABLE `localizacao` DISABLE KEYS */;
INSERT INTO `localizacao` VALUES (1,'0.37254547823184253','6.710500717163087','Saton'),(2,'0.37529200177436683','6.710371971130372','Bairro Aeroporto'),(3,'0.3737041679561029','6.715264320373536','Praia Francesa'),(4,'0.37061432835306124','6.712775230407716','Praia Nazaré'),(5,'0.34864210506376186','6.713032722473145','Oque Del Rei'),(6,'0.3491999941937912','6.717967987060548','Budo Budo'),(7,'0.34932873783446955','6.721487045288086','Potó Potó'),(8,'0.3398875328820167','6.717238426208497','Boa Morte'),(9,'0.336282706724362','6.7244911193847665','Riboque'),(10,'0.3343086346920691','6.728482246398927','Lucumi'),(11,'0.32907305042982266','6.665525436401368','Madalena'),(12,'0.33010300165071293','6.668057441711427','Prado'),(13,'0.3374414009923246','6.665310859680177','Água Telha'),(14,'0.33495235387676353','6.659002304077148','Vila Graciosa'),(15,'0.33435154930569416','6.702003479003907','Correia'),(16,'0.338385522145675','6.697711944580079','Mesquita'),(17,'0.34409316169778964','6.694622039794923','Uba-Cabra'),(18,'0.34902833600345523','6.684880256652833','Changra'),(19,'0.35932782182241824','6.689643859863281','Bela Vista'),(20,'0.13218987181681457','6.646229624748231','Mionga'),(21,'0.4023709601628521','6.687755584716798','Micoló');
/*!40000 ALTER TABLE `localizacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ADMIN'),(2,'EDITOR'),(3,'CREATOR'),(4,'USER'),(6,'USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'filipe','$2a$10$iZ9Ykj5aC8QUHbULaKynsOjV/p0w.L8QdYxK2SETiZURjTJdAbx62','filipelima@gmail.com',''),(2,'alzira','$2a$10$LBmTs51jPi9R/3icKtk.G.6dmF9GrwEUreW1PGadvKChgJTbqWI4i','alzira@gmail.com',''),(3,'lisy','$2a$10$0tj.XzIWhhpMnxFP01fl8.spqQW4Bpaq0gHA44fZeXga2KWepnz1G','lisy@gmail.com',''),(4,'lavinea','$2a$10$37pL/baECl7oYj/Wup.Xk.5GrLwGsP5ka.VVYcrB0RV7bCwuUE.lO','lavinea@gmail.com',''),(6,'oliver','$2a$10$E0vvzR2NbYU8NtX4QtMMaecTbDqV5/s.KT3YhVGCS/jQ./67OLgm.','oliver@gmail.com',''),(7,'dany','$2a$10$AOJslOvn/scXtamq9phhLOEwptLytpuPz8ftx6wwv8imE18Gdl1rG','dany@hotmail.com','');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `user_fk_idx` (`user_id`),
  KEY `role_fk_idx` (`role_id`),
  CONSTRAINT `role_fk` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`),
  CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (1,1),(2,2),(3,3),(7,6);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-28 16:47:10
