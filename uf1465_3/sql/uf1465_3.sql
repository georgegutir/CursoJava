-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema uf1465_3
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema uf1465_3
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `uf1465_3` DEFAULT CHARACTER SET utf8mb4 ;
USE `uf1465_3` ;

-- -----------------------------------------------------
-- Table `uf1465_3`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `uf1465_3`.`usuarios` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
