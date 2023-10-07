DROP TABLE IF EXISTS patients;

CREATE TABLE patients (
	id TINYINT(4) PRIMARY KEY NOT NULL AUTO_INCREMENT,
	lastName VARCHAR(30) NOT NULL,
	firstName VARCHAR(30) NOT NULL,
	birthDate DATE NOT NULL,
	gender CHAR(1) NOT NULL,
	address VARCHAR(30),
	phone VARCHAR(30)	
);

INSERT INTO patients (lastName, firstName, birthDate, gender, address, phone) VALUES
	('TestNode', 'Test', '1966-12-31', 'F', '1 Brookside St', '100-222-3333'),
	('TestBorderline', 'Test', '1945-06-24', 'M', '2 High St', '200-333-4444'),
	('TestInDanger', 'Test', '2004-06-18', 'M', '3 Club Road', '300-444-5555'),
	('TestEarlyOnSet', 'Test', '2002-06-28', 'F', '4 Valley Dr', '400-555-6666');
