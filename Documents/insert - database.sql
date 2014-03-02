-- -----------------------------------------------------
-- INSERT `Category`
-- -----------------------------------------------------


INSERT INTO mydb1239.Category (`name`) VALUES ('Storage'),('Screen'),('Accessory'),('CPU'),('GPU'),('MotherBoard'),('Alimentation'),('Ram');

-- -----------------------------------------------------
-- INSERT `Product`
-- -----------------------------------------------------
-- INSERT INTO `Product` ( `name`, `buying_price`, `selling_price`, `description`, `Category_id`) VALUES
-- ('Asus X36', '350.00', '499.00', 'Ubber laptop !', 2), ( 'HDD - Zaphyre X3', '55.5', '75', 'HDD 1To, brand Zaphyre', '10');

	-- -----------------------------------------------------
	-- INSERT Product Storage
	-- -----------------------------------------------------
	INSERT INTO `Product` ( `name`, `buying_price`, `selling_price`, `description`, `Category_id`) VALUES
	 ( '', '', '', '', (SELECT id FROM Category WHERE name = "Storage"));

	-- -----------------------------------------------------
	-- INSERT Product Screen
	-- -----------------------------------------------------
	INSERT INTO `Product` ( `name`, `buying_price`, `selling_price`, `description`, `Category_id`) VALUES
	 ( '', '', '', '', SELECT id FROM Category WHERE name = "Screen");

	-- -----------------------------------------------------
	-- INSERT Product Accessory
	-- -----------------------------------------------------
	INSERT INTO `Product` ( `name`, `buying_price`, `selling_price`, `description`, `Category_id`) VALUES
	 ( '', '', '', '', SELECT id FROM Category WHERE name = `Accessory`);

	-- -----------------------------------------------------
	-- INSERT Product CPU
	-- -----------------------------------------------------
	INSERT INTO `Product` ( `name`, `buying_price`, `selling_price`, `description`, `Category_id`) VALUES
	 ( '', '', '', '', SELECT id FROM Category WHERE name = `CPU`);

	-- -----------------------------------------------------
	-- INSERT Product GPU
	-- -----------------------------------------------------
	INSERT INTO `Product` ( `name`, `buying_price`, `selling_price`, `description`, `Category_id`) VALUES
	 ( '', '', '', '', SELECT id FROM Category WHERE name = `GPU`);
	-- -----------------------------------------------------
	-- INSERT Product MotherBoard
	-- -----------------------------------------------------
	INSERT INTO `Product` ( `name`, `buying_price`, `selling_price`, `description`, `Category_id`) VALUES
	 ( '', '', '', '', SELECT id FROM Category WHERE name = `MotherBoard`);
	-- -----------------------------------------------------
	-- INSERT Product Alimentation
	-- -----------------------------------------------------
	INSERT INTO `Product` ( `name`, `buying_price`, `selling_price`, `description`, `Category_id`) VALUES
	 ( '', '', '', '', SELECT id FROM Category WHERE name = `Alimentation`);

	-- -----------------------------------------------------
	-- INSERT Product Ram
	-- -----------------------------------------------------
	INSERT INTO `Product` ( `name`, `buying_price`, `selling_price`, `description`, `Category_id`) VALUES
	 ( '', '', '', '', SELECT id FROM Category WHERE name = `Ram`);
