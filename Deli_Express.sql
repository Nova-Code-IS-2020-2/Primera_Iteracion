-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Cliente` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Cliente` (
  `id_cliente` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `ap_pat` VARCHAR(45) NULL,
  `ap_mat` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `contr` VARCHAR(8) NULL,
  `telefono` VARCHAR(8) NULL,
  `direccion` VARCHAR(100) NULL,
  PRIMARY KEY (`id_cliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Categoria`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Categoria` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Categoria` (
  `id_cat` INT NOT NULL,
  `nombre_cat` VARCHAR(45) NULL,
  PRIMARY KEY (`id_cat`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Alimento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Alimento` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Alimento` (
  `id_alim` INT NOT NULL AUTO_INCREMENT,
  `direc_foto` VARCHAR(120) NULL,
  `descripcion` VARCHAR(255) NULL,
  `nombre_alim` VARCHAR(45) NULL,
  `precio` FLOAT NULL,
  PRIMARY KEY (`id_alim`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PerteneceAlimCat`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`PerteneceAlimCat` ;

CREATE TABLE IF NOT EXISTS `mydb`.`PerteneceAlimCat` (
  `Categoria_id_cat` INT NOT NULL,
  `Alimento_id_alim` INT NOT NULL,
  PRIMARY KEY (`Categoria_id_cat`, `Alimento_id_alim`),
  INDEX `fk_PerteneceAlimCat_Alimento1_idx` (`Alimento_id_alim` ASC),
  CONSTRAINT `fk_PerteneceAlimCat_Categoria1`
    FOREIGN KEY (`Categoria_id_cat`)
    REFERENCES `mydb`.`Categoria` (`id_cat`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PerteneceAlimCat_Alimento1`
    FOREIGN KEY (`Alimento_id_alim`)
    REFERENCES `mydb`.`Alimento` (`id_alim`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Administrador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Administrador` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Administrador` (
  `id_admin` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `ap_pat` VARCHAR(45) NULL,
  `ap_mat` VARCHAR(45) NULL,
  `contr` VARCHAR(8) NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`id_admin`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Repartidor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Repartidor` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Repartidor` (
  `id_repartidor` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `ap_pat` VARCHAR(45) NULL,
  `ap_mat` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `contr` VARCHAR(8) NULL,
  PRIMARY KEY (`id_repartidor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Orden`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Orden` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Orden` (
  `id_orden` INT NOT NULL,
  `precio` FLOAT NULL,
  `Repartidor_id_repartidor` INT NOT NULL,
  `Cliente_id_cliente` INT NOT NULL,
  PRIMARY KEY (`id_orden`),
  INDEX `fk_Orden_Repartidor1_idx` (`Repartidor_id_repartidor` ASC),
  INDEX `fk_Orden_Cliente1_idx` (`Cliente_id_cliente` ASC),
  CONSTRAINT `fk_Orden_Repartidor1`
    FOREIGN KEY (`Repartidor_id_repartidor`)
    REFERENCES `mydb`.`Repartidor` (`id_repartidor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Orden_Cliente1`
    FOREIGN KEY (`Cliente_id_cliente`)
    REFERENCES `mydb`.`Cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ContenerOrdAlim`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`ContenerOrdAlim` ;

CREATE TABLE IF NOT EXISTS `mydb`.`ContenerOrdAlim` (
  `cantidad` INT NOT NULL,
  `Alimento_id_alim` INT NOT NULL,
  `Orden_id_orden` INT NOT NULL,
  PRIMARY KEY (`Alimento_id_alim`, `Orden_id_orden`),
  INDEX `fk_ContenerOrdAlim_Orden1_idx` (`Orden_id_orden` ASC),
  CONSTRAINT `fk_ContenerOrdAlim_Alimento1`
    FOREIGN KEY (`Alimento_id_alim`)
    REFERENCES `mydb`.`Alimento` (`id_alim`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ContenerOrdAlim_Orden1`
    FOREIGN KEY (`Orden_id_orden`)
    REFERENCES `mydb`.`Orden` (`id_orden`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


insert into Alimento (direc_foto, descripcion, nombre_alim, precio) values ("aqui.png", "Muchas cosas wooo", "Vaca ciones", 98.50);

insert into Alimento (direc_foto, descripcion, nombre_alim, precio) values ("aqui-1.png", "Muchas cosas 1wooo", "Vaca ciones", 98.50);
insert into Alimento (direc_foto, descripcion, nombre_alim, precio) values ("aqui-2.png", "Muchas cosas 2wooo", "Taco de Lengua", 98.50);
insert into Alimento (direc_foto, descripcion, nombre_alim, precio) values ("aqui-3.png", "Muchas cosas 3wooo", "Doritos", 98.50);
insert into Alimento (direc_foto, descripcion, nombre_alim, precio) values ("aqui-4.png", "Muchas cosas 4wooo", "Dorilocos", 98.50);
insert into Alimento (direc_foto, descripcion, nombre_alim, precio) values ("aqui-5.png", "Muchas cosas 5wooo", "Vasoelote", 98.50);
insert into Alimento (direc_foto, descripcion, nombre_alim, precio) values ("aqui-6.png", "Muchas cosas 6wooo", "Ricosuave", 98.50);

select * from Alimento; 