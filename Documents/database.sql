SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Table `User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `User` ;

CREATE  TABLE IF NOT EXISTS `User` (
  `idUser` INT NULL ,
  `pseudo` VARCHAR(45) NULL ,
  `email` VARCHAR(45) NULL ,
  `password` VARCHAR(45) NULL ,
  `address` VARCHAR(45) NULL ,
  PRIMARY KEY (`idUser`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `Brand`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Brand` ;

CREATE  TABLE IF NOT EXISTS `Brand` (
  `idBrand` INT NOT NULL ,
  `brand_name` VARCHAR(45) NULL ,
  PRIMARY KEY (`idBrand`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Tag`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Tag` ;

CREATE  TABLE IF NOT EXISTS `Tag` (
  `idTag` INT NOT NULL ,
  `tag_name` VARCHAR(45) NULL ,
  PRIMARY KEY (`idTag`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Product` ;

CREATE  TABLE IF NOT EXISTS `Product` (
  `idProduct` INT NOT NULL ,
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
DROP TABLE IF EXISTS `Comment` ;

CREATE  TABLE IF NOT EXISTS `Comment` (
  `idComment` INT NOT NULL ,
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
DROP TABLE IF EXISTS `Command` ;

CREATE  TABLE IF NOT EXISTS `Command` (
  `idCommand` INT NOT NULL ,
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
DROP TABLE IF EXISTS `Bill` ;

CREATE  TABLE IF NOT EXISTS `Bill` (
  `idBill` INT NOT NULL ,
  `command` INT NULL ,
  `total_price` DOUBLE NULL ,
  `ispaid` TINYINT(1) NULL ,
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
DROP TABLE IF EXISTS `Command_Product` ;

CREATE  TABLE IF NOT EXISTS `Command_Product` (
  `command` INT NULL ,
  `product` INT NULL ,
  `amount_product` INT NULL ,
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
DROP TABLE IF EXISTS `Basket` ;

CREATE  TABLE IF NOT EXISTS `Basket` (
  `user` INT NOT NULL ,
  PRIMARY KEY (`user`) ,
  CONSTRAINT `fk_Basket_1`
    FOREIGN KEY (`user` )
    REFERENCES `User` (`idUser` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Basket_Product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Basket_Product` ;

CREATE  TABLE IF NOT EXISTS `Basket_Product` (
  `basket` INT NOT NULL ,
  `product` INT NULL ,
  `amount` INT NULL ,
  PRIMARY KEY (`basket`) ,
  INDEX `fk_Basket_Product_2_idx` (`product` ASC) ,
  CONSTRAINT `fk_Basket_Product_1`
    FOREIGN KEY (`basket` )
    REFERENCES `Basket` (`user` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Basket_Product_2`
    FOREIGN KEY (`product` )
    REFERENCES `Product` (`idProduct` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

