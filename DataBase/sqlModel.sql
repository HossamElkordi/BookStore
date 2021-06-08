-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema BookStore
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `BookStore` ;

-- -----------------------------------------------------
-- Schema BookStore
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `BookStore` ;
USE `BookStore` ;

-- -----------------------------------------------------
-- Table `BookStore`.`Publisher`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BookStore`.`Publisher` ;

CREATE TABLE IF NOT EXISTS `BookStore`.`Publisher` (
  `Name` VARCHAR(20) NOT NULL,
  `Address` VARCHAR(45) NOT NULL,
  `Phone Number` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`Name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BookStore`.`Book`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BookStore`.`Book` ;

CREATE TABLE IF NOT EXISTS `BookStore`.`Book` (
  `ISBN` VARCHAR(13) NOT NULL,
  `Title` VARCHAR(45) NOT NULL,
  `Publisher` VARCHAR(20) NOT NULL,
  `Publication Year` VARCHAR(4) NOT NULL,
  `Category` SET('Art', 'Science', 'Religion', 'History', 'Geography') NOT NULL,
  `Selling Price` REAL UNSIGNED NOT NULL,
  `Quantity` INT NOT NULL,
  `Threshold` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`ISBN`),
  UNIQUE INDEX `Title_UNIQUE` (`Title` ASC) VISIBLE,
  FULLTEXT INDEX `PubIdx` (`Publisher`) VISIBLE,
  CONSTRAINT `fk_Pub`
    FOREIGN KEY (`Publisher`)
    REFERENCES `BookStore`.`Publisher` (`Name`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BookStore`.`Authors`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BookStore`.`Authors` ;

CREATE TABLE IF NOT EXISTS `BookStore`.`Authors` (
  `ISBN` VARCHAR(13) NOT NULL,
  `Author` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ISBN`, `Author`),
  CONSTRAINT `fk_ISBN`
    FOREIGN KEY (`ISBN`)
    REFERENCES `BookStore`.`Book` (`ISBN`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BookStore`.`Orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BookStore`.`Orders` ;

CREATE TABLE IF NOT EXISTS `BookStore`.`Orders` (
  `ISBN` VARCHAR(13) NOT NULL,
  `Quantity` INT UNSIGNED NOT NULL,
  INDEX `fk_ISBN_idx` (`ISBN` ASC) VISIBLE,
  PRIMARY KEY (`ISBN`),
  CONSTRAINT `fk_isbnPR`
    FOREIGN KEY (`ISBN`)
    REFERENCES `BookStore`.`Book` (`ISBN`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BookStore`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BookStore`.`User` ;

CREATE TABLE IF NOT EXISTS `BookStore`.`User` (
  `UserName` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `LName` VARCHAR(45) NOT NULL,
  `FName` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `Phone Number` VARCHAR(20) NOT NULL,
  `Shipping Address` VARCHAR(45) NOT NULL,
  `Type` SET('Manager', 'Customer') NOT NULL DEFAULT 'Customer',
  PRIMARY KEY (`UserName`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
USE `BookStore`;

DELIMITER $$

USE `BookStore`$$
DROP TRIGGER IF EXISTS `BookStore`.`Book_BEFORE_UPDATE` $$
USE `BookStore`$$
CREATE DEFINER = CURRENT_USER TRIGGER `BookStore`.`Book_BEFORE_UPDATE` BEFORE UPDATE ON `Book` FOR EACH ROW
BEGIN
	IF NEW.Quantity < 0 THEN
		signal sqlstate '45000'
        set message_text = 'Quantity cannot be negative';
    END IF;
END$$


USE `BookStore`$$
DROP TRIGGER IF EXISTS `BookStore`.`Book_AFTER_UPDATE` $$
USE `BookStore`$$
CREATE DEFINER = CURRENT_USER TRIGGER `BookStore`.`Book_AFTER_UPDATE` AFTER UPDATE ON `Book` FOR EACH ROW
BEGIN
	if New.Quantity < NEW.Threshold THEN
		insert into Orders value(New.ISBN, 100);
	END IF;
END$$


USE `BookStore`$$
DROP TRIGGER IF EXISTS `BookStore`.`Orders_BEFORE_DELETE` $$
USE `BookStore`$$
CREATE DEFINER = CURRENT_USER TRIGGER `BookStore`.`Orders_BEFORE_DELETE` BEFORE DELETE ON `Orders` FOR EACH ROW
BEGIN
	update Book as B set B.Quantity = B.Quantity + old.quantity
    where B.ISBN = old.ISBN;
END$$


DELIMITER ;
