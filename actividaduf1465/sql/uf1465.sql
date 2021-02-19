-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema uf1465
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema uf1465
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `uf1465` DEFAULT CHARACTER SET utf8mb4 ;
USE `uf1465` ;

-- -----------------------------------------------------
-- Table `uf1465`.`Categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `uf1465`.`Categorias` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nombreCategoria` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `uf1465`.`Productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `uf1465`.`Productos` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(150) NOT NULL,
  `precio` DECIMAL(20,2) NOT NULL,
  `Categorias_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Productos_Categorias_idx` (`Categorias_id` ASC) VISIBLE,
  CONSTRAINT `fk_Productos_Categorias`
    FOREIGN KEY (`Categorias_id`)
    REFERENCES `uf1465`.`Categorias` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
