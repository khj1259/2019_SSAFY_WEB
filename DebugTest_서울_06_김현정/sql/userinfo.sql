
CREATE TABLE member ( 
	id			varchar(20)		primary key, 
	pw	        varchar(20)		NOT NULL,
	name		varchar(20)		NOT NULL,
	nickname	varchar(30),
	email		varchar(30),
	homepage	varchar(30),
	address		varchar(100),
	hobby		varchar(50)
);

INSERT INTO member VALUES('admin', 'admin', 'admin', 'admin',
     'admin@ssafy.com','www.ssafy.com','seoul','독서');
INSERT INTO member VALUES('ssafy', 'ssafy', 'ssafy', 'ssafy',
     'java@ssafy.com','www.ssafy.com','seoul','독서 여행');

commit;



