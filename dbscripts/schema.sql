-- MySQL Script generated by MySQL Workbench
-- 11/28/19 10:30:54
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema 144_bill_payment_system
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema 144_bill_payment_system
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `144_bill_payment_system` DEFAULT CHARACTER SET utf8 ;
USE `144_bill_payment_system` ;

-- -----------------------------------------------------
-- Table `144_bill_payment_system`.`bill_types`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `144_bill_payment_system`.`bill_types` (
  `bt_id` INT(11) NOT NULL AUTO_INCREMENT,
  `bt_name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`bt_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `144_bill_payment_system`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `144_bill_payment_system`.`user` (
  `us_id` INT(11) NOT NULL AUTO_INCREMENT,
  `us_firstname` VARCHAR(45) NULL DEFAULT NULL,
  `us_lastname` VARCHAR(45) NULL DEFAULT NULL,
  `us_age` INT(11) NULL DEFAULT NULL,
  `us_gender` VARCHAR(45) NULL DEFAULT NULL,
  `us_contactnumber` VARCHAR(45) NULL DEFAULT NULL,
  `us_pan` VARCHAR(45) NULL DEFAULT NULL,
  `us_aadharnumber` VARCHAR(45) NULL DEFAULT NULL,
  `us_usID` VARCHAR(45) NULL DEFAULT NULL,
  `us_password` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`us_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `144_bill_payment_system`.`bills`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `144_bill_payment_system`.`bills` (
  `bi_id` INT(11) NOT NULL AUTO_INCREMENT,
  `bi_amount` INT(11) NULL,
  `user_us_id` INT(11) NOT NULL,
  `bill_types_bill_id` INT(11) NOT NULL,
  PRIMARY KEY (`bi_id`),
  INDEX `fk_ub_bill_types_idx` (`bill_types_bill_id` ASC),
  INDEX `fk_ub_user_idx` (`user_us_id` ASC),
  CONSTRAINT `fk_bills_types_bill_idx`
    FOREIGN KEY (`bill_types_bill_id`)
    REFERENCES `144_bill_payment_system`.`bill_types` (`bt_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bills_types_user_idx`
    FOREIGN KEY (`user_us_id`)
    REFERENCES `144_bill_payment_system`.`user` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `144_bill_payment_system`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `144_bill_payment_system`.`role` (
  `ro_id` INT(11) NOT NULL AUTO_INCREMENT,
  `ro_name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ro_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `144_bill_payment_system`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `144_bill_payment_system`.`user_role` (
  `ur_id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_us_id` INT(11) NULL DEFAULT NULL,
  `role_ro_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ur_id`),
  INDEX `fk_ur_role_idx` (`role_ro_id` ASC),
  INDEX `fk_ur_user_idx` (`user_us_id` ASC),
  CONSTRAINT `fk_ur_ro_idx`
    FOREIGN KEY (`role_ro_id`)
    REFERENCES `144_bill_payment_system`.`role` (`ro_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ur_us_idx`
    FOREIGN KEY (`user_us_id`)
    REFERENCES `144_bill_payment_system`.`user` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `144_bill_payment_system`.`vendor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `144_bill_payment_system`.`vendor` (
  `ven_id` INT(11) NOT NULL AUTO_INCREMENT,
  `ven_name` VARCHAR(50) NULL DEFAULT NULL,
  `ven_com_reg_no` VARCHAR(50) NULL DEFAULT NULL,
  `ven_type` VARCHAR(45) NULL DEFAULT NULL,
  `ven_address` VARCHAR(45) NULL DEFAULT NULL,
  `ven_country` VARCHAR(45) NULL DEFAULT NULL,
  `ven_state` VARCHAR(45) NULL DEFAULT NULL,
  `ven_email_address` VARCHAR(45) NULL DEFAULT NULL,
  `ven_contact_number` INT(12) NULL DEFAULT NULL,
  `ven_website` VARCHAR(45) NULL DEFAULT NULL,
  `ven_certificate_issue` DATE NULL DEFAULT NULL,
  `ven_certificate_validity` DATE NULL DEFAULT NULL,
  `ven_year_of_establishment` INT(12) NULL DEFAULT NULL,
  `ven_payment` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ven_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `144_bill_payment_system`.`vendor_bills`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `144_bill_payment_system`.`vendor_bills` (
  `vb_id` INT(11) NOT NULL AUTO_INCREMENT,
  `vb_bi_id` INT(11) NOT NULL,
  `vb_ven_id` INT(11) NOT NULL,
  PRIMARY KEY (`vb_id`),
  CONSTRAINT `fk_vendor_bills_bills1`
    FOREIGN KEY (`vb_bi_id`)
    REFERENCES `144_bill_payment_system`.`bills` (`bi_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vendor_bills_vendor1`
    FOREIGN KEY (`vb_ven_id`)
    REFERENCES `144_bill_payment_system`.`vendor` (`ven_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
