DROP TABLE IF EXISTS PRODUCT;

CREATE TABLE PRODUCT (
  `id` INT AUTO_INCREMENT,
  `type` ENUM('phone','subscription'),
  `properties` VARCHAR(250),
  `property_name` ENUM('color','gb_limit'),
  `property_value` VARCHAR(250),
  `price` DECIMAL(10,2),
  `store_address` varchar(250), 
  `city` varchar(250),
  PRIMARY KEY (id)
);
