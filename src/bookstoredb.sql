CREATE SCHEMA `book_store` ;
CREATE TABLE `book_store`.`publisher` (
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `telephone numbers` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`name`));
CREATE TABLE `book_store`.`book` (
  `ISBN` VARCHAR(45) NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `Author` VARCHAR(45) NOT NULL,
  `Publisher` VARCHAR(45) NOT NULL,
  `PublicationYear` YEAR(4) NOT NULL,
  `SellingPrice` DECIMAL(7,2) NOT NULL,
  `Category` VARCHAR(45) NOT NULL,
 `Threshold` INT NOT NULL,
 `Quantity` INT NOT NULL,
  PRIMARY KEY (`ISBN`),
  FOREIGN KEY (`publisher`)
  REFERENCES `book_store`.`publisher` (`name`)
  ON DELETE CASCADE
  ON UPDATE CASCADE);
  
  CREATE TABLE `book_store`.`user` (
  `User_name` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Lname` VARCHAR(45) NOT NULL,
  `Fname` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `Phone` VARCHAR(11) NOT NULL,
  `ShAddress` VARCHAR(45) NOT NULL,
  `Manager` BIT(1) NOT NULL,
  PRIMARY KEY (`User_name`));

CREATE TABLE `book_store`.`book_order` (
  `ISBN` VARCHAR(45) NOT NULL,
  `DateOut` DATE NOT NULL,
  `No_Of_Copies` VARCHAR(45) NOT NULL,
  `OrderId` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`OrderId`),
  INDEX `F1_idx` (`ISBN` ASC) VISIBLE,
  CONSTRAINT `F1`
    FOREIGN KEY (`ISBN`)
    REFERENCES `book_store`.`book` (`ISBN`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
USE book_store;   
delimiter $$
CREATE TRIGGER modify_existing_books
BEFORE UPDATE ON book
FOR EACH ROW
BEGIN
if (new.Quantity < 0) then
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Quantity can\'t be negative';
end if;
end $$

delimiter //
CREATE TRIGGER insert_books
BEFORE INSERT ON book
FOR EACH ROW
BEGIN
if (new.Quantity < new.threshold) then
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Quantity can\'t be less than threshold';
end if;
end //
delimiter ;

delimiter //
CREATE TRIGGER place_order
AFTER UPDATE ON book
FOR EACH ROW
BEGIN
if (new.Quantity < old.Threshold) then
INSERT INTO book_order(ISBN,DateOut,No_Of_Copies) VALUES(old.ISBN,CURDATE(),2*old.Threshold);
end if;
end //
delimiter ;


delimiter //
CREATE TRIGGER confirm_orders
BEFORE DELETE ON book_order
FOR EACH ROW
BEGIN
UPDATE book
SET Quantity = Quantity + old.No_Of_Copies
WHERE ISBN = OLD.ISBN;
end //
delimiter ;

INSERT INTO PUBLISHER VALUES
("Arktos Media", "Sydney, Australia", "0123456789"),
("Cisco Press", "Paris, France", "0112335778"),
("Orion Books", "New York City, USA", "123-456-789"),
("Zed Books", "London, UK", "+2912345681"),
("Pluto Press", "London, UK", "9876543210");

INSERT INTO BOOK VALUES
(135116155,"The Cultural Landscape","James M. Rubenstein","Orion Books",'1983',300,"Geography",10,15),
(1180134001,"Contemporary Human Geography","James M. Rubenstein","Orion Books",'2009',350,"Geography",7,15),
(9780133864649,"Goode's World Atlas","Rand McNally","Arktos Media",'1990',500,"Geography",5,14),
(671728687,"The Rise of the Third Reich","William L. Shirer","Zed Books",'1960',1500,"History",5,15),
(9780805066692,"Bury My Heart at Wounded Knee","Dee Alexander Brown","Pluto Press",'1970',500,"History",7,20),
(9781039582484,"The Code Breaker","Walter Isaacson","Pluto Press",'2021',2500,"Science",9,20),
(9780241292525,"The Order of Time","Carlo Rovelli","Cisco Press",'2017',1200,"Science",8,16),
(9781648760587,"This is Why We Pray","Ameenah Muhammad-Diggins","Pluto Press",'2021',400,"Religion",20,30),
(9781844137862,"Wall and Piece","Banksy","Cisco Press",'2005',700,"Art",15,40);

INSERT INTO USER VALUES
("Ali Walid","19331945","walid","ali","Aliwalid@yahoo.com","01155599722","32 street,mnhjui",0 ),
("Heba Hassan","125478678","hassan","heba","Hebahassan20@gmail.com","01335581726","52 street,mdsajui",0 ),
("Ahmed saeed","120345678","saeed","ahmed","ahmed50@yahoo.com","01512589722","32 street,nshhhjui",0 );


INSERT INTO book_order(ISBN,DateOut,No_Of_Copies) VALUES
("135116155","2021-11-10",5),
("9780241292525","2021-05-10",2);
