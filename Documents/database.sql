SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';



-- -----------------------------------------------------
-- Table `User`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `User` (
  `idUser` INT NULL AUTO_INCREMENT ,
  `username` VARCHAR(45) NOT NULL ,
  `email` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(45) NOT NULL ,
  `address` VARCHAR(45) NULL ,
  `last_login` DATETIME NULL ,
  `enabled` TINYINT(1) NOT NULL DEFAULT 1 ,
  `confirmation_token` VARCHAR(45) NULL ,
  `locked` TINYINT(1) NOT NULL DEFAULT 0 ,
  `created_date` DATETIME NOT NULL ,
  PRIMARY KEY (`idUser`) ,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `Brand`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Brand` (
  `idBrand` INT NOT NULL AUTO_INCREMENT ,
  `brand_name` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idBrand`) ,
  UNIQUE INDEX `brand_name_UNIQUE` (`brand_name` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Tag`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Tag` (
  `idTag` INT NOT NULL AUTO_INCREMENT ,
  `tag_name` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idTag`) ,
  UNIQUE INDEX `tag_name_UNIQUE` (`tag_name` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Product`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Product` (
  `idProduct` INT NOT NULL AUTO_INCREMENT ,
  `product_description` TEXT NULL ,
  `buying_price` DECIMAL(10,0) NULL ,
  `product_name` VARCHAR(45) NULL ,
  `product_stock` INT NULL ,
  `selling_price` INT NULL ,
  `brand` INT NULL ,
  `tag` INT NULL ,
  `number_sold` INT NULL ,
  PRIMARY KEY (`idProduct`) ,
  INDEX `fk_Product_1_idx` (`brand` ASC) ,
  INDEX `fk_Product_2_idx` (`tag` ASC) ,
  CONSTRAINT `fk_Product_1`
    FOREIGN KEY (`brand` )
    REFERENCES `Brand` (`idBrand` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Product_2`
    FOREIGN KEY (`tag` )
    REFERENCES `Tag` (`idTag` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `Comment`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Comment` (
  `idComment` INT NOT NULL AUTO_INCREMENT ,
  `comment` TEXT NULL ,
  `score` INT NULL ,
  `user` INT NULL ,
  `product` INT NULL ,
  PRIMARY KEY (`idComment`) ,
  INDEX `fk_Comment_1_idx` (`user` ASC) ,
  INDEX `fk_Comment_2_idx` (`product` ASC) ,
  CONSTRAINT `fk_Comment_1`
    FOREIGN KEY (`user` )
    REFERENCES `User` (`idUser` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comment_2`
    FOREIGN KEY (`product` )
    REFERENCES `Product` (`idProduct` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `Command`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Command` (
  `idCommand` INT NOT NULL AUTO_INCREMENT ,
  `user` INT NULL ,
  `status` VARCHAR(45) NULL ,
  PRIMARY KEY (`idCommand`) ,
  INDEX `fk_Order_1_idx` (`user` ASC) ,
  CONSTRAINT `fk_Order_1`
    FOREIGN KEY (`user` )
    REFERENCES `User` (`idUser` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Bill`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Bill` (
  `idBill` INT NOT NULL AUTO_INCREMENT ,
  `command` INT NOT NULL ,
  `total_price` DOUBLE NOT NULL ,
  `ispaid` TINYINT(1) NOT NULL ,
  `date_payment` DATETIME NULL ,
  PRIMARY KEY (`idBill`) ,
  INDEX `fk_Bill_1_idx` (`command` ASC) ,
  CONSTRAINT `fk_Bill_1`
    FOREIGN KEY (`command` )
    REFERENCES `Command` (`idCommand` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Command_Product`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Command_Product` (
  `command` INT NULL ,
  `product` INT NULL ,
  `amount_product` INT NOT NULL ,
  PRIMARY KEY (`command`, `product`) ,
  INDEX `fk_Order_Product_1_idx` (`command` ASC) ,
  INDEX `fk_Order_Product_2_idx` (`product` ASC) ,
  CONSTRAINT `fk_Order_Product_1`
    FOREIGN KEY (`command` )
    REFERENCES `Command` (`idCommand` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_Product_2`
    FOREIGN KEY (`product` )
    REFERENCES `Product` (`idProduct` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Basket`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Basket` (
  `user` INT NOT NULL ,
  `product` INT NOT NULL ,
  `amount_product` INT UNSIGNED NOT NULL ,
  PRIMARY KEY (`user`, `product`) ,
  INDEX `fk_Basket_2_idx` (`product` ASC) ,
  CONSTRAINT `fk_Basket_1`
    FOREIGN KEY (`user` )
    REFERENCES `User` (`idUser` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Basket_2`
    FOREIGN KEY (`product` )
    REFERENCES `Product` (`idProduct` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

