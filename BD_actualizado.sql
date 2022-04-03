-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema sisinv
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema sisinv
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sisinv` DEFAULT CHARACTER SET utf8 ;
USE `sisinv` ;

-- -----------------------------------------------------
-- Table `sisinv`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisinv`.`cliente` (
  `idCliente` INT(11) NOT NULL,
  `nombre_Cliente` VARCHAR(45) NOT NULL,
  `apellido_Cliente` VARCHAR(45) NOT NULL,
  `apellido2_Cliente` VARCHAR(45) NOT NULL,
  `telefono_Cliente` INT(10) NOT NULL,
  `email_Cliente` VARCHAR(45) NOT NULL,
  `direccion_Cliente` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sisinv`.`proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisinv`.`proveedor` (
  `idProveedor` INT(11) NOT NULL,
  `nombre_Proveedor` VARCHAR(45) NOT NULL,
  `telefono_Proveedor` INT(10) NOT NULL,
  `telefono2_Proveedor` INT(10) NOT NULL,
  `direccion_Proveedor` VARCHAR(45) NOT NULL,
  `email_Proveedor` VARCHAR(45) NOT NULL,
  `descripcion_Proveedor` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idProveedor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sisinv`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisinv`.`producto` (
  `idProducto` INT(11) NOT NULL,
  `nom_Producto` VARCHAR(45) NOT NULL,
  `descripcion_Producto` VARCHAR(45) NULL DEFAULT NULL,
  `precio_Producto` DECIMAL(10,0) NOT NULL,
  `precio_sugerido` DECIMAL(10,0) NOT NULL,
  `fecha_registro` DATETIME NOT NULL,
  `idProveedor` INT(11) NOT NULL,
  PRIMARY KEY (`idProducto`),
  INDEX `fk_Producto_Proveedor1_idx` (`idProveedor` ASC),
  CONSTRAINT `fk_Producto_Proveedor1`
    FOREIGN KEY (`idProveedor`)
    REFERENCES `sisinv`.`proveedor` (`idProveedor`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sisinv`.`entradas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisinv`.`entradas` (
  `idEntradas` INT(11) NOT NULL AUTO_INCREMENT,
  `codigo_Entrada` INT(11) NOT NULL,
  `fecha_Entrada` DATE NOT NULL,
  `cantidad_Entrada` INT(11) NOT NULL,
  `idProveedor` INT(11) NOT NULL,
  PRIMARY KEY (`idEntradas`),
  INDEX `fk_Entradas_Proveedor_idx` (`idProveedor` ASC),
  INDEX `fk_Entradas_Producto1_idx` (`codigo_Entrada` ASC),
  CONSTRAINT `fk_Entradas_Producto1`
    FOREIGN KEY (`codigo_Entrada`)
    REFERENCES `sisinv`.`producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Entradas_Proveedor`
    FOREIGN KEY (`idProveedor`)
    REFERENCES `sisinv`.`proveedor` (`idProveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sisinv`.`inventario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisinv`.`inventario` (
  `idInventario` INT(11) NOT NULL AUTO_INCREMENT,
  `codigo_Inventario` INT(11) NOT NULL,
  `entrada_Inventario` INT(11) NOT NULL,
  `cantidad_Salida` INT(11) NOT NULL,
  `stock` INT(11) NOT NULL,
  PRIMARY KEY (`idInventario`),
  INDEX `fk_Inventario_Producto1_idx` (`codigo_Inventario` ASC),
  CONSTRAINT `fk_Inventario_Producto1`
    FOREIGN KEY (`codigo_Inventario`)
    REFERENCES `sisinv`.`producto` (`idProducto`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sisinv`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisinv`.`rol` (
  `idRol` INT(11) NOT NULL,
  `nombre_Rol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idRol`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sisinv`.`salidas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisinv`.`salidas` (
  `idSalidas` INT(11) NOT NULL AUTO_INCREMENT,
  `codigo_Salida` INT(11) NOT NULL,
  `fecha_Salida` DATE NOT NULL,
  `cantidad_Salida` INT(11) NOT NULL,
  `idCliente` INT(11) NOT NULL,
  PRIMARY KEY (`idSalidas`),
  INDEX `fk_Salidas_Cliente1_idx` (`idCliente` ASC),
  INDEX `fk_Salidas_Producto1_idx` (`codigo_Salida` ASC),
  CONSTRAINT `fk_Salidas_Cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `sisinv`.`cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Salidas_Producto1`
    FOREIGN KEY (`codigo_Salida`)
    REFERENCES `sisinv`.`producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sisinv`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sisinv`.`usuario` (
  `idUsuario` INT(11) NOT NULL,
  `identidad_Usuario` VARCHAR(45) NOT NULL,
  `contra_Usuario` VARCHAR(45) NOT NULL,
  `nombres_Usuario` VARCHAR(45) NOT NULL,
  `apellido1_Usuario` VARCHAR(45) NOT NULL,
  `apellido2_Usuario` VARCHAR(45) NOT NULL,
  `idRol` INT(11) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE INDEX `idUsuario_UNIQUE` (`idUsuario` ASC),
  INDEX `fk_Usuario_Rol_idx` (`idRol` ASC),
  CONSTRAINT `fk_Usuario_Rol`
    FOREIGN KEY (`idRol`)
    REFERENCES `sisinv`.`rol` (`idRol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

USE `sisinv` ;

-- -----------------------------------------------------
-- procedure NUEVO_PRODUCTO
-- -----------------------------------------------------

DELIMITER $$
USE `sisinv`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `NUEVO_PRODUCTO`(`CODIGO` VARCHAR(10))
INSERT INTO Inventario (codigo_Inventario) VALUES (CODIGO)$$

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
