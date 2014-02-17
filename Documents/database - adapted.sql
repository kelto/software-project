SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


-- -----------------------------------------------------
-- Table `User`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `User` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `username` VARCHAR(45) NOT NULL ,
  `email` VARCHAR(45) NOT NULL ,
  `address` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `Usercol_UNIQUE` (`username` ASC) ,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Category`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Category` (
  `id` TINYINT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Product`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Product` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `buying_price` DECIMAL(5,2) NOT NULL ,
  `selling_price` DECIMAL(5,2) NOT NULL ,
  `description` TINYTEXT NULL ,
  `last_update` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
  `Category_id` TINYINT UNSIGNED NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Product_Category_idx` (`Category_id` ASC) ,
  CONSTRAINT `fk_Product_Category`
    FOREIGN KEY (`Category_id` )
    REFERENCES `Category` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `User_order`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `User_order` (
  `id` INT UNSIGNED NOT NULL ,
  `amount` DECIMAL(6,2) NOT NULL ,
  `date_created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  `confirmation_number` INT UNSIGNED NOT NULL ,
  `User_id` INT UNSIGNED NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_User_order_User1_idx` (`User_id` ASC) ,
  CONSTRAINT `fk_User_order_User1`
    FOREIGN KEY (`User_id` )
    REFERENCES `User` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ordered_product`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `ordered_product` (
  `User_order_id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `Product_id` INT UNSIGNED NOT NULL ,
  `quantity` SMALLINT UNSIGNED NOT NULL ,
  PRIMARY KEY (`User_order_id`, `Product_id`) ,
  INDEX `fk_User_order_has_Product_Product1_idx` (`Product_id` ASC) ,
  INDEX `fk_User_order_has_Product_User_order1_idx` (`User_order_id` ASC) ,
  CONSTRAINT `fk_ordered_product_User_order1`
    FOREIGN KEY (`User_order_id` )
    REFERENCES `User_order` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ordered_product_Product1`
    FOREIGN KEY (`Product_id` )
    REFERENCES `Product` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Comment`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Comment` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `comment` TINYTEXT NULL ,
  `score` TINYINT UNSIGNED NULL ,
  `User_id` INT UNSIGNED NOT NULL ,
  `Product_id` INT UNSIGNED NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Comment_User1_idx` (`User_id` ASC) ,
  INDEX `fk_Comment_Product1_idx` (`Product_id` ASC) ,
  CONSTRAINT `fk_Comment_User1`
    FOREIGN KEY (`User_id` )
    REFERENCES `User` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comment_Product1`
    FOREIGN KEY (`Product_id` )
    REFERENCES `Product` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Bill`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `Bill` (
  `id` INT UNSIGNED NOT NULL ,
  `isPaid` TINYINT(1) NOT NULL DEFAULT 0 ,
  `date_payment` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  `User_order_id` INT UNSIGNED NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Bill_User_order1_idx` (`User_order_id` ASC) ,
  CONSTRAINT `fk_Bill_User_order1`
    FOREIGN KEY (`User_order_id` )
    REFERENCES `User_order` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- INSERT `Category`
-- -----------------------------------------------------

INSERT INTO mydb1239.Category (`name`) VALUES ('HDD'),('Laptop'),('accessory'),('Desktop');

-- -----------------------------------------------------
-- INSERT `Product`
-- -----------------------------------------------------
INSERT INTO `Product` ( `name`, `buying_price`, `selling_price`, `description`, `last_update`, `Category_id`) VALUES
('Asus X36', '350.00', '499.00', 'Ubber laptop !', 2), ( 'HDD - Zaphyre X3', '55.5', '75', 'HDD 1To, brand Zaphyre', CURRENT_TIMESTAMP, '10');
