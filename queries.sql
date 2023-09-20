CREATE database Librarymanagement;
USE Librarymanagement;

CREATE TABLE user (
    Id int NOT NULL AUTO_INCREMENT,
    UserName varchar(255),
    PassWord varchar(255),
    UserType ENUM('READER', 'LIBRARIAN'),
    PRIMARY KEY (Id)
);

CREATE TABLE reader(
	User_Id INT NOT NULL,
    ReaderId VARCHAR(255) NOT NULL,
	Name varchar (255),
    Gender varchar (255),
    Email varchar(255),
    Phone varchar(255),
	PRIMARY KEY (ReaderId),
	FOREIGN KEY (User_Id) REFERENCES user(Id)	
);

CREATE TABLE Librarian (
    User_Id INT NOT NULL,
    LibrarianId VARCHAR(255) NOT NULL,
    Name VARCHAR(255),
    Gender VARCHAR(255),
    Email VARCHAR(255),
    Phone VARCHAR(255),
    Salary DOUBLE,
    PRIMARY KEY (LibrarianId),
    FOREIGN KEY (User_Id) REFERENCES User(Id)
);

CREATE TABLE book(
	Id int NOT NULL primary key auto_increment,
	Title varchar (255),
    Author varchar (255),
    Price double,
    Category varchar (255),
    TotalAvailable int,
    BorrowDuration int
);

CREATE TABLE issuebook(
	Transaction_Id int NOT NULL primary key auto_increment,
	Quantity int,
    Charges double,
    Fine double,
    Issue_date date,
    Due_date date,
    Return_date date,
    Status boolean, -- Returned or borrowing
    Book_Id int,
    Reader_Id varchar(255),
	FOREIGN KEY (Book_Id) REFERENCES book(Id),	
    FOREIGN KEY (Reader_Id) REFERENCES reader(ReaderId)
);

INSERT INTO book (Id, Title, Author, Price, Category, TotalAvailable, BorrowDuration)
VALUES (1, 'Doremon', 'Fujiko Fujio', '20000', 'comic', 15 , 14),
(2, 'Conan', 'Gosho Aoyama', '18000', 'detective', 30 , 14),
(3, 'Đắc Nhân Tâm ', 'Dale Carnegie', '50000', 'self-help', 10 , 35),
(4, 'Nhà Gỉa Kim', ' Paulo Coelho', '40000', 'self-help', 5 , 21),
(5, 'Tuổi Trẻ Đáng Giá Bao Nhiêu?', 'Rosie Nguyễn', '60000', 'self-help', 40, 14);

INSERT INTO user (UserName, PassWord)
VALUES ('ngoquyen', 'ngoquyen01@'),
('quantrung', 'quantrung02@'),
('quehien', 'quehien03@'),
('trungdung', 'trungdung04@'),
('vivi', 'vancao05@');

INSERT INTO user (UserName, PassWord)
VALUES ('justin','abc123'),
('selena','b345'),
('hailey','c456'),
('tomson','d234'),
('jerry','e567');

UPDATE user
SET UserType = 'READER'
WHERE Id IN (1, 2, 3, 4, 5);

UPDATE user
SET UserType = 'LIBRARIAN'
WHERE Id IN (6, 7, 8, 9, 10);

INSERT INTO librarian (Name, Gender, Email, Phone, Salary, User_Id)
VALUES ('Justin', 'male', 'justin@gmail.com', '1111111111', 15000000, 6),
('Selena', 'female', 'selena@gmail.com', '2222222222', 12000000, 7),
('Hailey', 'female', 'hailey@gmail.com', '3333333333', 15000000, 8),
('Tomson', 'male', 'tomson@gmail.com', '4444444444', 12000000, 9),
('Jerry', 'female', 'jerry@gmail.com', '5555555555', 20000000, 10);

INSERT INTO reader (Name, Gender, Email, Phone, User_Id)
VALUES ('ngô quyền','male','ngoquyen@gmail.com','6666666666',1 ),
('quan trung','male','quantrung@gmail.com','7777777777',2 ),
('quệ hiền','female','quehien@gmail.com','8888888888',3 ),
('trung dũng','male','trungdung@gmail.com','9999999999',4 ),
('vi vi','female','vivi@gmail.com','1234567891', 5);

-- data ban dau la moi nguoi van dang muon sach, chua tra
INSERT INTO issuebook (Quantity, Charges, Fine, Issue_date, Due_date, Status, Book_Id, Reader_Id)
VALUES
    (10, 5000, 100000, '2023-09-14', '2023-09-28', TRUE, 1, 'R0001'),
    (5, 10000, 200000, '2023-09-19', '2023-10-03', TRUE, 2, 'R0002'),
    (1, 20000, 500000, '2023-09-10', '2023-10-07', TRUE, 3, 'R0003'),
    (2, 5000, 200000, '2023-09-01', '2023-09-22', TRUE, 4, 'R0004'),
    (4, 15000, 100000, '2023-08-10', '2023-08-24', TRUE, 5, 'R0005');
