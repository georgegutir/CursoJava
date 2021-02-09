use gestiondocente;

CREATE TABLE IF NOT EXISTS `resenas` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `resenas` VARCHAR(3000) NOT NULL,
  `alumno_codigo` INT NOT NULL,
  `curso_codigo` INT NOT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_resenas_alumno1_idx` (`alumno_codigo` ASC) visible,
  INDEX `fk_resenas_curso1_idx` (`curso_codigo` ASC) visible,
  CONSTRAINT `fk_resenas_alumno1`
    FOREIGN KEY (`alumno_codigo`)
    REFERENCES `alumno` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_resenas_curso1`
    FOREIGN KEY (`curso_codigo`)
    REFERENCES `curso` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB comment = 'Tabla de reseñas de alumnos';