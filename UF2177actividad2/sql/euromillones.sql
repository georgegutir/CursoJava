-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema euromillones
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema euromillones
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `euromillones` DEFAULT CHARACTER SET utf8mb4 ;
USE `euromillones` ;

-- -----------------------------------------------------
-- Table `euromillones`.`sorteos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `euromillones`.`sorteos` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `num1` INT NOT NULL,
  `num2` INT NOT NULL,
  `num3` INT NOT NULL,
  `num4` INT NOT NULL,
  `num5` INT NOT NULL,
  `star1` INT NOT NULL,
  `star2` INT NOT NULL,
  `fechasorteo` DATETIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
